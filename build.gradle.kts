import kotlinx.knit.KnitPluginExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  dependencies {
    classpath("org.jetbrains.kotlinx:kotlinx-knit:0.3.0")
  }
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  kotlin("jvm") version "1.6.0"
}

apply(plugin = "kotlinx-knit")

group = "io.github.nomisrev"

allprojects {
  repositories {
    mavenCentral()
  }
}

configure<KnitPluginExtension> {
  siteRoot = "https://nomisrev.github.io/"
}

// We need to copy examples since knit generates them in the wrong place
// See issue:
tasks.register<Copy>("copyExamples") {
  from(rootDir.resolve("_posts/guide/example").listFiles())
  into(rootDir.resolve("guide/example"))
}