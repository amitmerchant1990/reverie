// This file was automatically generated from 2021-11-28-continuation-monad-in-kotlin.md by Knit tool. Do not edit.
package example.exampleReadme04

import arrow.*
import arrow.core.*
import arrow.fx.coroutines.*
import kotlinx.coroutines.*
import io.kotest.matchers.collections.*
import io.kotest.assertions.*
import io.kotest.matchers.*
import io.kotest.matchers.types.*
import kotlin.coroutines.cancellation.CancellationException
import io.kotest.property.*
import io.kotest.property.arbitrary.*
import arrow.core.test.generators.*

interface ContEffect<E> {
  suspend fun <A> shift(e: e): A
  
  suspend fun <A> Either<E, A>.bind(): A =
    when(this) {
      is Either.Right -> value
      is Either.Left -> shift(value)
    }
}

suspend fun test() {
  cont<String, Int> {
    val x: Int = 1.right().bind()
    val y: Int = shift("Failed")
  }.toEither() shouldBe Either.Left("failed")
}
