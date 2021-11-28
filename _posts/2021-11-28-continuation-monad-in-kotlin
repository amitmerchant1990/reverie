---
layout: post
title: Continuation<R, A> in Kotlin
categories: [Kotlin, Continuation, Monad]
---

Kotlin has support for CPS, or Continuation Passing Style, which means that by marking a function as `suspend` it will have an implicit `Continuation` parameter that will be automatically be interleaved by the compiler. Or "Passing" the "Continuation" instance style/feature of the compiler.

This `kotlin.coroutines.Continuation` only has a single type parameter `kotlin.coroutines.Continuation<A>`, and the _result_ of running this `suspend`/`Continuation` based program is _either_ `A`, or `Throwable`.
This is represented by `Result<A>` in the Kotlin Standard Library.

What if we'd want to finish the program, or `Continuation<A>`, with a typed error of value `R` instead of "untyped" `Throwable`.
So what we'd want is the power to stop the program and return `R` instead of resulting in a value of `A`. This can be done by creating a new _Continuation_ type `Cont<R, A>`.


So `Cont<R, A>` represents a function of `suspend () -> A` that can fail with `R` (and `Throwable`), so it's defined by `suspend fun <B> fold(f: suspend (R) -> B, g: suspend (A) -> B): B`.

So to construct a `Cont<R, A>` we simply call the `cont<R, A> { }` DSL, which exposes a rich syntax through the lambda receiver `suspend ContEffect<R>.() -> A`.

What is interesting about the `Cont<R, A>` type is that it doesn't rely on any wrappers such as `Either`, `Ior` or `Validated`. Instead `Cont<R, A>` represents a suspend function, and only when we call `fold` it will actually create a `Continuation` and runs the computation (without intercepting). This makes `Cont<R, A>` a very efficient generic runtime.

## Writing a program with Cont<R, A>

Let's write a small program to read a file from disk, and instead of having the program work exception based we want to turn it into a polymorphic type-safe program.

We'll start by defining a small function that accepts a `String`, and does some simply validation to check that the path is not empty. If the path is empty, we want to program to result in `EmptyPath`. So we're immediately going to see how we can raise an error of any arbitrary type `R` by using the function `shift`. The name `shift` comes shifting (or changing, especially unexpectedly), away from the computation and finishing the `Continuation` with `R`.

```kotlin
object EmptyPath

fun readFile(path: String): Cont<EmptyPath, Unit> = cont {
  if (path.isNotEmpty()) shift(EmptyPath) else Unit
}
```

Here we see how we can define a `Cont<R, A>` which has `EmptyPath` for the shift type `R`, and `Unit` for the success type `A`.

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

Since these are the properties of our `Cont` function, we can turn it into a value.

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

The functions above our available out of the box, but it's easy to define your own extension functions in terms of `fold`. Implementing the `toEither()` operator is as simple as:

```kotlin
suspend fun <R, A> Cont<R, A>.toEither(): Either<R, A> =
  fold({ Either.Left(it) }) { Either.Right(it) }

suspend fun <A> Cont<None, A>.toOption(): Option<A> =
  fold(::identity) { Some(it) }
```

> You can get the full code [here](guide/example/example-readme-03.kt).

Adding your own syntax to `ContEffect<R>` is tricky atm, but will be easy once "Multiple Receivers" become available.

```
context(ContEffect<R>)
suspend fun <R, A> Either<R, A>.bind(): A =
  when (this) {
    is Either.Left -> shift(value)
    is Either.Right -> value
  }

context(ContEffect<None>)
fun <A> Option<A>.bind(): A =
  fold({ shift(it) }, ::identity)
```

## Handling errors

Handling errors of type `R` is the same as handling errors for any other data type in Arrow.
`Cont<R, A>` offers `handleError`, `handleErrorWith`, `redeem`, `redeemWith` and `attempt`.

As you can see in the examples below it is possible to resolve errors of `R` or `Throwable` in `Cont<R, A>` in a generic manner. There is no need to run `Cont<R, A>` into `Either<R, A>` before you can access `R`, you can simply call the same functions on `Cont<R, A>` as you would on `Either<R, A>` directly.

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
> You can get the full code [here](guide/example/example-readme-04.kt).
<!--- TEST lines.isEmpty() -->

Note:
 Handling errors can also be done with `try/catch` but this is **not recommended**, it uses `CancellationException` which is used to cancel `Coroutine`s and is advised not to capture in Kotlin. The `CancellationException` from `Cont` is `ShiftCancellationException`, this a public type so it can be distinguished from any other `CancellationException` if necessary.

## Structured Concurrency

`Cont<R, A>` relies on `kotlin.cancellation.CancellationException` to `shift` error values of type `R` inside the `Continuation` since it effectively cancels/short-circuits it. For this reason `shift` adheres to the same rules as [`Structured Concurrency`](https://kotlinlang.org/docs/coroutines-basics.html#structured-concurrency)

Let's overview below how `shift` behaves with the different concurrency builders from Arrow Fx & KotlinX Coroutines.
In the examples below we're going to be using a utility to show how _sibling tasks_ get cancelled. The utility function show below called `awaitExitCase` will `never` finish suspending, and completes a `Deferred` with the `ExitCase`. `ExitCase` is a sealed class that can be a value of `Failure(Throwable)`, `Cancelled(CancellationException)`, or `Completed`. Since `awaitExitCase` suspends forever, it can only result in `Cancelled(CancellationException)`.

```kotlin
suspend fun <A> awaitExitCase(exit: CompletableDeferred<ExitCase>): A =
  guaranteeCase(::awaitCancellation) { exitCase -> exit.complete(exitCase) }
```

### Arrow Fx Coroutines

All operators in Arrow Fx Coroutines run in place, so they have no way of leaking `shift`.
It's there always safe to compose `cont` with any Arrow Fx combinator. Let's see some small examples below.

#### parZip

```kotlin
suspend fun test() = checkAll(Arb.string()) { error ->
  val exit = CompletableDeferred<ExitCase>()
  cont<String, Int> {
    parZip({ awaitExitCase<Int>(exit) }, { shift<Int>(error) }) { a, b -> a + b }
  }.fold({ it shouldBe error }, { fail("Int can never be the result") })
  exit.await().shouldBeTypeOf<ExitCase>()
}
```
> You can get the full code [here](guide/example/example-readme-05.kt).
[comment]: <> (Test disabled due to missing join in parZip)

#### parTraverse

<!--- INCLUDE
suspend fun <A> awaitExitCase(exit: CompletableDeferred<ExitCase>): A =
  guaranteeCase(::awaitCancellation) { exitCase -> exit.complete(exitCase) }

suspend fun <A> CompletableDeferred<A>.getOrNull(): A? =
  if (isCompleted) await() else null
-->
```kotlin
suspend fun test() = checkAll(Arb.string()) { error ->
  val exits = (0..3).map { CompletableDeferred<ExitCase>() }
  cont<String, List<Unit>> {
    (0..4).parTraverse { index ->
      if (index == 4) shift(error)
      else awaitExitCase(exits[index])
    }
  }.fold({ msg -> msg shouldBe error }, { fail("Int can never be the result") })
  // It's possible not all parallel task got launched, and in those cases awaitCancellation never ran
  exits.forEach { exit -> exit.getOrNull()?.shouldBeTypeOf<ExitCase.Cancelled>() }
}
```

`parTraverse` will launch 5 tasks, for every element in `1..5`.
The last task to get scheduled will `shift` with "error", and it will cancel the other launched tasks before returning.

> You can get the full code [here](guide/example/example-readme-06.kt).
<!--- TEST lines.isEmpty() -->

#### raceN

<!--- INCLUDE
suspend fun <A> awaitExitCase(exit: CompletableDeferred<ExitCase>): A =
  guaranteeCase(::awaitCancellation) { exitCase -> exit.complete(exitCase) }

suspend fun <A> CompletableDeferred<A>.getOrNull(): A? =
  if (isCompleted) await() else null
-->
```kotlin
suspend fun test() = checkAll(Arb.string()) { error ->
  val exit = CompletableDeferred<ExitCase>()
  cont<String, Int> {
    raceN({ awaitExitCase<Int>(exit) }) { shift<Int>(error) }
      .merge() // Flatten Either<Int, Int> result from race into Int
  }.fold({ msg -> msg shouldBe error }, { fail("Int can never be the result") })
  // It's possible not all parallel task got launched, and in those cases awaitCancellation never ran
  exit.getOrNull()?.shouldBeTypeOf<ExitCase.Cancelled>()
}
```

`raceN` races `n` suspend functions in parallel, and cancels all participating functions when a winner is found. We can consider the function that `shift`s the winner of the race, except with a shifted value instead of a successful one. So when a function in the race `shift`s, and thus short-circuiting the race, it will cancel all the participating functions.

> You can get the full code [here](guide/example/example-readme-07.kt).
<!--- TEST lines.isEmpty() -->

#### bracketCase / Resource
<!--- INCLUDE
import java.io.*
-->
```kotlin
suspend fun test() = checkAll(Arb.string()) { error ->
  val exit = CompletableDeferred<ExitCase>()
  cont<String, Int> {
    bracketCase(
      acquire = { File("build.gradle.kts").bufferedReader() },
      use = { reader: BufferedReader -> shift(error) },
      release = { reader, exitCase ->
        reader.close()
        exit.complete(exitCase)
      }
    )
  }.fold({ it shouldBe error }, { fail("Int can never be the result") })
  exit.await().shouldBeTypeOf<ExitCase.Cancelled>()
}
```
> You can get the full code [here](guide/example/example-readme-08.kt).
<!--- TEST lines.isEmpty() -->

<!--- INCLUDE
import java.io.*

fun <A> Resource<A>.releaseCase(releaseCase: suspend (A, ExitCase) -> Unit): Resource<A> =
  flatMap { a -> Resource({ a }, releaseCase) }
-->
```kotlin
suspend fun test() = checkAll(Arb.string()) { error ->
  val exit = CompletableDeferred<ExitCase>()

  fun bufferedReader(path: String): Resource<BufferedReader> =
    Resource.fromAutoCloseable { File(path).bufferedReader() }
      .releaseCase { _, exitCase -> exit.complete(exitCase) }

  cont<String, Int> {
    val lineCount = bufferedReader("build.gradle.kts")
      .use { reader -> shift<Int>(error) }
    lineCount
  }.fold({ it shouldBe error }, { fail("Int can never be the result") })
  exit.await().shouldBeTypeOf<ExitCase.Cancelled>()
}
```
> You can get the full code [here](guide/example/example-readme-09.kt).
<!--- TEST lines.isEmpty() -->

### KotlinX
#### withContext
It's always safe to call `shift` from `withContext` since it runs in place, so it has no way of leaking `shift`.
When `shift` is called from within `withContext` it will cancel all `Job`s running inside the `CoroutineScope` of `withContext`.

<!--- INCLUDE
import java.io.*

@JvmInline
value class Content(val body: List<String>)

sealed interface FileError
@JvmInline value class SecurityError(val msg: String?) : FileError
@JvmInline value class FileNotFound(val path: String) : FileError
object EmptyPath : FileError {
  override fun toString() = "EmptyPath"
}

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

suspend fun <A> awaitExitCase(exit: CompletableDeferred<ExitCase>): A =
  guaranteeCase(::awaitCancellation) { exitCase -> exit.complete(exitCase) }
-->
```kotlin
suspend fun test() {
  val exit = CompletableDeferred<ExitCase>()
  cont<FileError, Int> {
    withContext(Dispatchers.IO) {
      val job = launch { awaitExitCase(exit) }
      val content = readFile("failure").bind()
      job.join()
      content.body.size
    }
  }.fold({ e -> e shouldBe FileNotFound("failure") }, { fail("Int can never be the result") })
  exit.await().shouldBeInstanceOf<ExitCase>()
}
```
> You can get the full code [here](guide/example/example-readme-10.kt).
<!--- TEST lines.isEmpty() -->

#### async

When calling `shift` from `async` you should **always** call `await`, otherwise `shift` can leak out of its scope.

```kotlin
suspend fun test() = checkAll(Arb.string(), Arb.string()) { errorA, errorB ->
  coroutineScope {
    cont<String, Int> {
      val fa = async<Int> { shift(errorA) }
      val fb = async<Int> { shift(errorB) }
      fa.await() + fb.await()
    }.fold({ error -> error shouldBeIn listOf(errorA, errorB) }, { fail("Int can never be the result") }) 
  }
}
```
> You can get the full code [here](guide/example/example-readme-11.kt).
<!--- TEST lines.isEmpty() -->

#### launch

```kotlin
suspend fun test() = checkAll(Arb.string(), Arb.string(), Arb.int()) { errorA, errorB, int ->
  cont<String, Int> {
    coroutineScope<Int> {
      launch { shift(errorA) }
      launch { shift(errorB) }
      int
    }
  }.fold({ fail("Shift can never finish") }, { it shouldBe int })
}
```
> You can get the full code [here](guide/example/example-readme-12.kt).
<!--- TEST lines.isEmpty() -->

#### Strange edge cases

**NOTE**
Capturing `shift` into a lambda, and leaking it outside of `Cont` to be invoked outside will yield unexpected results.
Below we capture `shift` from inside the DSL, and then invoke it outside its context `ContEffect<String>`.

```kotlin
cont<String, suspend () -> Unit> {
 suspend { shift("error") }
}.fold({ }, { leakedShift -> leakedShift.invoke() })
```

The same violation is possible in all DSLs in Kotlin, including Structured Concurrency.

```kotlin
val leakedAsync = coroutineScope<suspend () -> Deferred<Unit>> {
  suspend {
    async {
      println("I am never going to run, until I get called invoked from outside")
    }
  }
}
leakedAsync.invoke().await()
```
