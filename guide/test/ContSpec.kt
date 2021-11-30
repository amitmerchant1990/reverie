// This file was automatically generated from 2021-11-28-continuation-monad-in-kotlin.md by Knit tool. Do not edit.
package example.test

import io.kotest.core.spec.style.StringSpec
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class ContSpec : StringSpec({
    "ExampleReadme02".config(timeout= Duration.seconds(1)) {
      example.exampleReadme02.test()
    }

    "ExampleReadme03".config(timeout= Duration.seconds(1)) {
      example.exampleReadme03.test()
    }

    "ExampleReadme04".config(timeout= Duration.seconds(1)) {
      example.exampleReadme04.test()
    }

})
