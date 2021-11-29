---
layout: post
title: Continuation<R, A> in Kotlin
categories: [Kotlin, Continuation, Monad]
---

<!--- TEST_NAME ContSpec -->

Coroutines is one of the most liked features in Kotlin. Most people are familiar with the KotlinX Coroutines implementation,
and many are also familiar with `suspendCoroutine` from the Kotlin Standard Library and then have also come across `Continuation`.

Kotlin has support for CPS, or Continuation Passing Style,
which means that the compiler has a _style_ in which it can automatically _pass_ _Continuation_ between functions that are marked with `suspend`.

This means that in every `suspend fun` we have access to an implicit `Continuation` parameter through `suspendCoroutine { cont: Continuation -> ... }`, or any of it's lower level variants.

This `Continuation` only has a single type parameter `Continuation<A>`, and the _result_ of running this `suspend`/`Continuation` based program is _either_ `A`, or `Throwable`.
This is represented by the `Result<A>` type from the Kotlin Standard Library.

In functional programming we often prefer to interrupt the program with a typed value `R` instead of `Throwable`. 
So we'd like a `Continuation` that instead of only being able to result in `A | Throwable` can result in `A | R | Throwable`,
you can never escape that a program can also result in `Throwable` and `suspend` explicitly takes `Throwable` into account to operate correctly. 

To achieve this we define a new type `interface Cont<R, A>`, 
which represents a function of `suspend () -> A` that can fail with `R` (and `Throwable`).
It's defined by `suspend fun <B> fold(f: suspend (R) -> B, g: suspend (A) -> B): B`.

What is interesting about the `Cont<R, A>` type is it's a suspend function `fold`, so it doesn't rely on any wrappers such as `Either`, `Ior` or `Validated`.
Only when `fold` is called it will create a `Continuation` and run the computation, this means `Cont` can encode `side-effects` as `pure values`.
This makes `Cont<R, A>` a very efficient generic runtime.

To construct a `Cont<R, A>` we simply call the `cont<R, A> { }` constructor, which exposes a rich syntax through the lambda receiver `suspend ContEffect<R>.() -> A`.

## Working with Cont<R, A>

Let's write a small program to read a file from disk, and instead of having the program work exception based we want to turn it into a polymorphic type-safe program.

We start by defining a small function that accepts a `String`, and does some simply validation to check that the path is not empty.
If the path is empty, we want to program to result in `EmptyPath`.
So we're immediately going to see how we can raise an error of any arbitrary type `R` by using the function `shift`. 
The name `shift` comes shifting (or changing, especially unexpectedly), away from the computation and finishing the `Continuation` with `R`.

```kotlin
object EmptyPath

fun readFile(path: String): Cont<EmptyPath, Unit> = cont {
  if (path.isNotEmpty()) shift(EmptyPath) else Unit
}
```

Here we see how we can define a `Cont<R, A>` which has `EmptyPath` for the shifted type `R`, and `Unit` for the success type `A`.

Patterns like validating a `Boolean` is very common, and the `Cont` DSL offers utility functions like `kotlin.require` and `kotlin.requireNotNull`. They're named `ensure` and `ensureNotNull` to avoid conflicts with the `kotlin` namespace. So let's rewrite the function from above to use the DSL instead.

```kotlin
fun readFile2(path: String?): Cont<EmptyPath, Unit> = cont {
  ensureNotNull(path) { EmptyPath }
  ensure(path.isEmpty()) { EmptyPath }
}
```

> You can get the full code [here](guide/example/example-readme-01.kt).

Now that we have the path, we can read from the `File` and return it as a domain model `Content`.
We also want to take a look at what exceptions reading from a file might occur `FileNotFoundException` & `SecurityError`, so lets make some domain errors for those too. Grouping them as a sealed interface is useful since that way we can resolve *all* errors in a type safe manner.

<!--- INCLUDE
import java.io.*
-->
```kotlin
@JvmInline
value class Content(val body: List<String>)

sealed interface FileError
@JvmInline value class SecurityError(val msg: String?) : FileError
@JvmInline value class FileNotFound(val path: String) : FileError
object EmptyPath : FileError {
  override fun toString() = "EmptyPath"
}
```

We can finish our function, but we need to refactor our return value from `Unit` to `Content` and our error type from `EmptyPath` to `FileError`.

```kotlin
fun readFile(path: String?): Cont<FileError, Content> = cont {
  ensureNotNull(path) { EmptyPath }
  ensure(path.isNotEmpty()) { EmptyPath }
  try {
    val lines = File(path).readLines()
    Content(lines)
  } catch (e: FileNotFoundException) {
    shift(FileNotFound(path))
  } catch (e: SecurityException) {
    shift(SecurityError(e.message))
  }
}
```

The `readFile` function defines a `suspend fun` that will return:

- the `Content` of a given `path`
- a `FileError`
- An unexpected fatal error (`OutOfMemoryException`)

Now that we have our `Cont<FileError, Content>` function, we can turn it into a value.

```kotlin
suspend fun test() {
  readFile("").toEither() shouldBe Either.Left(EmptyPath)
  readFile("knit.properties").toValidated() shouldBe  Validated.Invalid(FileNotFound("knit.properties"))
  readFile("gradle.properties").toIor() shouldBe Ior.Left(FileNotFound("gradle.properties"))
  readFile("README.MD").toOption { None } shouldBe None

  readFile("build.gradle.kts").fold({ _: FileError -> null }, { it })
    .shouldBeInstanceOf<Content>()
    .body.shouldNotBeEmpty()
}
```
> You can get the full code [here](guide/example/example-readme-02.kt).
<!--- TEST lines.isEmpty() -->

## Handling errors

Handling errors of type `R` is the same as handling errors for any other data type in Arrow.
`Cont<R, A>` offers `handleError`, `handleErrorWith`, `redeem`, `redeemWith` and `attempt`.

As you can see in the examples below it is possible to resolve errors of `R` or `Throwable` in `Cont<R, A>` in a generic manner.
There is no need to run `Cont<R, A>` into `Either<R, A>` before you can access `R`, you can simply call the same functions on `Cont<R, A>` as you would on `Either<R, A>` directly.

```kotlin
val failed: Cont<String, Int> =
  cont { shift("failed") }

val resolved: Cont<Nothing, Int> =
  failed.handleError { it.length }

val newError: Cont<List<Char>, Int> =
  failed.handleErrorWith { str ->
    cont { shift(str.reversed().toList()) }
  }

val redeemed: Cont<Nothing, Int> =
  failed.redeem({ str -> str.length }, ::identity)

val captured: Cont<String, Result<Int>> = cont<String, Int> {
  1
}.attempt()

suspend fun test() {
  failed.toEither() shouldBe Either.Left("failed")
  resolved.toEither() shouldBe Either.Right(6)
  newError.toEither() shouldBe Either.Left(listOf('d', 'e', 'l', 'i', 'a', 'f'))
  redeemed.toEither() shouldBe Either.Right(6)
  captured.toEither() shouldBe Either.Right(Result.success(1))
}
```
> You can get the full code [here](guide/example/example-readme-03.kt).
<!--- TEST lines.isEmpty() -->

## Cont<E, A> vs Either<E, A>

We've briefly mentioned the difference between `Either<E, A>` and `Cont<E, A>` but let's compare them now that we know how `Cont<E, A>` works.

`Either<String, Int>` represents a *value* of _either_ `String` or `Int`,
whilst `Cont<String, Int>` represents a *function* that will result in `String` or `Int`.

You might have guessed it, `either` can be implemented by `cont`.

```kotlin
suspend fun <E, A> either(block: suspend ContEffect<E>.() -> A): Either<E, A> =
  cont(block).fold({ e: E -> Either.Left(e) }) { a: A -> Either.Right(a) }
```

Here you can clearly see that `cont` represents the actual computation,
and `Either` represents the final result of running a program.

## Structured Concurrency

`Cont<R, A>` can automatically operates with KotlinX's Structured Concurrency by leveraging `kotlin.cancellation.CancellationException` introduced in Kotlin 1.4.
It's used by `shift` to raise error values of type `R` inside the `Continuation` since it effectively cancels/short-circuits it.
For this reason `shift` adheres to the same rules as [`Structured Concurrency`](https://kotlinlang.org/docs/coroutines-basics.html#structured-concurrency)

For more details see the [`Cont<R, A>` documentation](https://github.com/nomisRev/Continuation#structured-concurrency)

## Conclusion

Thank you for reading the first informal (test) blog on my Github Pages, I hope you enjoyed it!
Feel free to reach out on KotlinLang Slack for feedback or questions.

Stay tuned for more informal blogs! 
