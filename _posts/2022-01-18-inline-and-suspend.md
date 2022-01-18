---
layout: post
title: My favorite Kotlin feature
categories: [Kotlin, Continuation, Suspend, DSL]
---
Over the last several years I've seen many discussions on Kotlin's features.
Nullability is always a very high ranked one. I like it, but it's definitely not my favorite feature.

What I love most about Kotlin are some small features, that make the language very elegant. 
Such as smart-casting (contracts), suspend, receiver/extension functions & delegation.
 
But at this point in time my favorite feature is the combination of `inline` and `suspend`.

# Inline recap

The _inline_ feature is a feature everyone in Kotlin is using regularly, knowingly or not.
A function can be marked _inline_ when it has lambdas as parameters, also known as Higher Order Functions.
A Higher Order Function is a function that takes other functions as parameters, or returns a new function. We call `map` a HOF since it takes another function `transform` as a parameter. 

```kotlin
inline fun <A, B> Iterable<A>.map(transform: (A) -> B): List<B>
```

`Iterable.map` is probably the best known one.
It maps all elements in a `List` of type `A` to a `List` of type `B` using the `transform` function `(A) -> B`.
When these patterns were first introduced, there was some concern about performance due to _for-loops_ being more efficient at byte-code level.

_inline_ is a Kotlin compiler feature that can completely get rid of that concern. If we look at the function body of `Iterable.map` we see a _for-loop_.

So let’s see what the bytecode of `listOf(1, 2).map(Int::toString)` looks like:

```kotlin
val destination = ArrayList<String>()
for (item in listOf(1, 2)) {
  destination.add(item.toString())
}  
```

It looks the same as if we’d have written the _for-loop_ by hand. Awesome, we can write high-level code without losing any of the benefits of writing low-level code!

However, inlining is not unique to Kotlin. Many other languages also support inlining.

# suspend recap

`suspend` in Kotlin is extremely powerful, and it has many interesting use-cases.
Suspension allows us to wrap callbacks, and write imperative code over callbacks.

```kotlin
suspend fun example(): Int = suspendCoroutine { continuation ->
    callbackCode { int, error ->
      if(error == null) continuation.resume(int)
      else continuation.resumeWithException(error)
    }
}

suspend fun twice() = example() + example()
```

In concurrency that means we can work with `JVM Future` or `JS Promise` without having to write callback based code.
This is very powerful, as we can now write “regular imperative” to describe powerful async workflows,
but it also allows for very interesting use-cases outside of concurrency.
A great example is discussed at length in my previous [blogpost](here). 

The compiler also verifies that suspending code can only be called from other suspending code, so that you can never accidentally call suspending code from places that do not support it.

```kotlin
suspend fun example(): Int = suspendCoroutine { continuation ->
  callbackCode { int, error ->
    if(error == null) continuation.resume(int)
    else continuation.resumeWithException(error)
  }
}

fun once() = example()
// Cannot call suspending fun example from non-suspending fun once
```

The `suspend` functionality is also known as `Continuation Passing Style`, which means that the compiler can automatically pass `Continuation` between function for us.
It does so in an extremely efficient manner, and that allows us to write callback based code in an immediate manner.

# suspend + inline

Now that we've discussed how `suspend` and `inline` works,
we can take a look at my favourite Kotlin feature which is support between `suspend` + `inline`!

Let’s start from a non-inline example.

```kotlin
fun <A, B> Iterable<A>.map(transform: (A) -> B): List<A> = TODO()

suspend fun fetchUser(id: Int): Result<Int> = Result.success(id)

suspend fun example5() = listOf(1, 2, 3).map { fetchUser(it) }
```

This fails to compile with _Suspension functions can be called only within coroutine body_ even though our `example` function is marked as suspend.
This is because we’re creating a `non-suspending lambda transform` to pass to the `map` function,
and from within that `non-suspending lambda` we cannot call the `suspend function fetchUser`.

But when we mark this function inline it suddenly works.
That’s because it’s not creating a `non-suspending lambda` anymore, but instead in our example we now have again our optimised for-loop and the resolve function is being called from within.

Since the compiler knows that the `non-suspending lambda` will not exist due to `inline`, it allows `suspend` to be called from inside.
This is similar to _smart-casting_, the compiler has certain knowledge about the program that it allows us to do something that is regularly not allowed.

When designing libraries, or higher order functions it's important to keep inline in mind.
Not only for performance reasons, but also for `suspend`.

It's one of the features of the Kotlin Compiler that is easily overseen, since it works so transparently.

# More examples

Let’s see some other interesting examples, and some caveats.

```kotlin
fun process(i: Int): Either<String, Int> = i.right()

val res: List<Either<String, Int>> = (0..9).map { process(it) }
```

In the above example we have a list of 10 items, and want to process every element.
When we use `Iterable.map` we get `List<Either<String, Int>>`, which is not that interesting.
Actually we'd want `Either<String, List<Int>>`, _either the first error, or all processed results_.

If you're familiar with Arrow, or the Cont blogpost you've seen a DSL where we can use `suspend` to work over `Either.Right` in a nicer way.
Since we can combine `inline` with `suspend`, we can extract the value out of `Either` inside `Iterable.map`.

```kotlin
fun process(i: Int): Either<String, Int> = i.right()

val res: Either<String, List<Int>> = either.eager<String, Int> {
  (0..9).map { process(it).bind() }
}
```

Now we get the result we're interested in `Either<String, List<Int>>`, _either the first error, or all processed results_.
If you're familiar with functional programming, you might see that this replaces the `Traverse` and `Monad` hierarchy.
So when practicing FP in Kotlin, we can forget about a lot of complexity since it's possible to provide powerful semantic sugar through suspension.
Note: here we use `either.eager` which uses `suspend` but doesn't allow any foreign suspending code.

Another interesting example is `Sequence` from Kotlin Std,
where `suspend` is used to offer a powerful DSL for building lazy sequences.
`sequence` offers `suspend fun yield(a: A): Unit` which can be used to `emit`/`yield` a value to the `Sequence`.
Below we can use it to implement `flatMap` through `suspend` and `inline`.

```kotlin
fun <A, B> Sequence<A>.flatMap(transform: (A) -> Sequence<B>): Sequence<B> =
  sequence {
    forEach { a: A ->
      f(a).forEach { b: B -> yield(b) }
    }
  }
```

1. Open a `sequence` DSL block
2. Loop over all elements in `Sequence<A>`
3. `transform` `A` into `Sequence<B>`
4. Loop over all elements of `Sequence<B>` and yield them

The reason we can call `yield` from the double nested `forEach` is because both are marked as `inline`, and thus we can call `yield` safely from inside.

## Caveat

This pattern is sadly not foolproof, there are some gotchas in terms of resource-safety and cancellation.

```kotlin
coroutineScope {
  listOf(1, 2, 3)
    .map { async { ... } }
    .map { it.await() }
}
```

This code is not cancellation safe, if a task fails it can never cancel the other tasks **ahead of it in the list**.
Due to awaiting the `Deferred` in the order of the list instead of all at the same time.
To await all the `Deferred` at the same time you should use `awaitAll`.

```kotlin
coroutineScope {
  listOf(1, 2, 3)
    .map { async { ... } }
    .awaitAll()
}
```

# Conclusion

The way these two features work so seamlessly together is in my opinion an underappreciated feature of the Kotlin compiler and one of my favourites.

An upcoming feature in Kotlin, [Context receivers](https://github.com/Kotlin/KEEP/issues/259), is going to make this pattern more powerful. More on that in a next post.

Thanks for reading my blog on my favorite Kotlin feature(s). I hope you enjoyed it, and a Happy New Year!
