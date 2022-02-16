---
layout: post
title: Exploring Kotlin's Context Receivers
categories: [Kotlin, Suspend, DSL, Effect]
---
Last week a long awaited feature was released as a preview in Kotlin 1.6.20-M1.
In this blogpost we're going to explore what _Context Receivers_ are, and some benefits and patterns they'll enable.
To try it out in your IDE, follow this [guide](https://kotlinlang.org/docs/install-eap-plugin.html)

Currently, the only _receiver_ we can define in Kotlin is through [extension functions](https://kotlinlang.org/docs/extensions.html).
In the following function, `fun List<Int>.sum(): Int`, we call `List<Int>` the _receiver_ of the function.

We can call the above function as a member function on the type `List<Int>`.
Note that for a custom defined extension function it requires an import, but not for most functions from the Kotlin Std.

```kotlin
listOf(1, 2, 3).sum()
```

## What are Context Receivers

With _Context Receivers_ we can introduce *additional* receivers.
Let's take another function from the Kotlin Std [`List<A>.sortedWith(comparator: Comparator<A>): List<A>`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sorted-with.html) and refactor it to use _context receivers_.

With context receivers we can redefine this function *without* the `Comparator<A>` argument in the parameter list.
Where we call `Comparator<A>` the _Context receiver_, and `List<A>` the _Extension Receiver_

```kotlin
context(Comparator<A>)
fun <A> List<A>.sort(): List<A> =
  sortedWith(this@Comparator)
```

We can now call this function *only* from within the *context* of `Comparator<A>`, so we can use Kotlin's [scope functions](https://kotlinlang.org/docs/scope-functions.html) to bring `Comparator<A>` into *context*.

```kotlin
with(Comparator.naturalOrder<Int>()) {
  listOf(3, 5, 1).sort() // [1, 3, 5]
}

Comparator.naturalOrder<Int>().run {
  listOf(4, 6, 2, 1).sort() // [1, 2, 4, 6]
}
```

What happens if we mark a function with `context(Comparator<A>)`, is that it gets an implicit argument that the compiler automatically fills in for us when we're in its scope.
If we look at the JVM signature we will see `public <A> List<A> sort(List<A> extension, Comparator<A> comporator)`, where *both* receivers are actually regular arguments on the JVM and Kotlin takes care of passing them around for us.

## Context Receivers in action

So now that we have an understanding of how _Context Receivers_ work, and what terminology is involved, lets take a look at some cool patterns.

In a previous blogposts we've discussed [`Effect`](https://nomisrev.github.io/continuation-monad-in-kotlin/) & [`inline` & `suspend`](https://nomisrev.github.io/inline-and-suspend/).
Currently, in Kotlin with Arrow we'd write a function like this `fun readFile(path: String?): Effect<FileError, Content> = effect { ... }`.
We're forced to have a wrapper in the return type, `Effect<FileError, Content>`,  to signal to the type system that the function results in `Content` but can fail with `FileError`.

With _Context Receivers_ we can write code _inside the effect context_, so  we can rewrite the function as:

```kotlin
@JvmInline value class Content(val body: List<String>)

sealed interface FileError
@JvmInline value class SecurityError(val msg: String?) : FileError
@JvmInline value class FileNotFound(val path: String) : FileError
object EmptyPath : FileError {
  override fun toString() = "EmptyPath"
}

context(EffectScope<FileError>)
suspend fun readFile(path: String?): Content {
  TODO("All functionality from effect { } available here")
}
```

So we can now write functions like we love in Kotlin, `suspend fun` with the happy-path in the return type.
There are two ways that we can call this function:

```kotlin
val res: Effect<FileError, Content> = effect {
  readFile("")
}

context(EffectScope<FileError>)
suspend fun allFiles(vararg path: String): List<Content> =
  path.map { readFile(it) }
```

However, we can also introduce new context receivers as we go along in our program, for example logging.

```kotlin
fun interface Logger {
  suspend fun info(msg: String): Unit
  suspend fun warn(msg: String): Unit
  suspend fun error(msg: String): Unit
}

context(EffectScope<FileError>, Logger)
suspend fun allFiles(vararg path: String): List<Content> {
  info("Processing files")
  return path.map { readFile(it) }
}

val res2: Effect<FileError, Content> = with(Logger(::println)) {
  effect {
    allFiles("path1", "path2")
  }
}
```

Kotlin _Context Receivers_ enable a popular pattern in FP called "Effect Handlers", which refers to the technique of constraining functionality to an `interface` and enabling its functionality by bringing it into _scope_.
In the example above the `Logger` handler enables the `info`, `warn` and `error` functionality.
We can resolve the _EffectScope<FileError>_ part of our _context_ but  leave the `Logger` handler as _context_.

```kotlin
context(Logger)
suspend fun allFilesOrEmpty(vararg path: String): List<Content> =
  effect<FileError, List<Content>> {
    allFiles(*path)
  }.orElse { emptyList() }
```

Here we were able to make resolve the `EffectScope<FileError>` context, by wrapping in `effect` and resolving the error by defaulting to an `emptyList`.
This makes it very easy to solve errors across certain layers in your application,
in case you'd want to resolve `DbError` before consuming them in the _service_ layer.

Let's look at a quick example of what that might look like:

```kotlin
data class User(val uuid: UUID)
data class DbError(val error: Throwable)

interface Users { // Normally we'd use an interface here
  context(EffectScope<DbError>)
  suspend fun fetchUser(uuid: UUID): User = User(uuid)
  
  companion object Default : Users
}

data class Profile(val uuid: UUID)
data class NetworkError(val error: Throwable)

interface Profiles { // Normally we'd use an interface here
  context(EffectScope<NetworkError>)
  suspend fun fetchProfile(user: User): Profile = Profile(user.uuid)

  companion object Default : Profiles
}

context(EffectScope<DbError>, EffectScope<NetworkError>, Profiles, Users)
suspend fun service(): Profile {
  val user = fetchUser(UUID.randomUUID())
  return fetchProfile(user)
}
```

Here we have defined a `service` function, that talks to the `Persistence` layer, and the `Network` layer.
Both layers have their own error hierarchy, and we would like to keep them separate, so we don't have to create a single error hierarchy for all layers.
This also makes it more explicit from which layers the error came from.

```kotlin
suspend fun program(): Profile? = with(Profiles.Default) {
  with(Users.Default) {
    effect<DbError, Profile?> {
      effect<NetworkError, Profile?> {
        service(Persistence, Network)
      }.tapLeft { networkError -> println(networkError) }
        .orNull()
    }.tapLeft { dbError -> println(dbError) }
      .orNull()
  }
}
```

## Conclusion

Context receivers give us an elegant way of constraining functions to which context they can be called from.
It allows for composing _context_ without requiring inheritance, and bringing them into _scope_/_context_ by using Kotlin's [scope functions](https://kotlinlang.org/docs/scope-functions.html).

The biggest improvement I'm still hoping for is `with` that allows multiple parameters, that would allow us to flatten a lot of code.

```kotlin
with(Users.Default, Profiles.Default) {
  // Users & Profiles available here
}
```

After having tried context receivers I cannot wait for them to become stable, and will probably start using them in all my toy projects already and perhaps even in some production code.

Thanks for reading my blog, and thoughts on Kotlin's context receivers.
Hope you enjoyed it!

A Gradle project with the code from this blogpost can be found on GitHub [here](https://github.com/nomisRev/context-receivers-blog).
If you want to try it out do not forget to set up your IDEA as well, instructions can be found [here](https://kotlinlang.org/docs/install-eap-plugin.html).
