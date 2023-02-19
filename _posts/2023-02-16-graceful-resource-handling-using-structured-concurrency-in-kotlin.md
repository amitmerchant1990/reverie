---
layout: post
title: Graceful Resource Handling Using Structured Concurrency in Kotlin
categories: [Kotlin, StructuredConcurrency, Resource, Kubernetes, Microservices]
---

Webinar with Anton Arhipov on functional microservices with Ktor and Kubernetes about zero-downtime deployments.

The code can be found in the [Ktor K8s Zero Downtime](https://github.com/nomisRev/ktor-k8s-zero-downtime) repository.

[![Graceful Resource Handling Using Structured Concurrency in Kotlin](http://img.youtube.com/vi/zKrTBH8jqH4/0.jpg)](http://www.youtube.com/watch?v=zKrTBH8jqH4 "Graceful Resource Handling Using Structured Concurrency in Kotlin")

Modern programming often requires us to make strong guarantees about how our applications terminate. One way to do this is through the use of structured concurrency, which allows us to reason about parallel processes and how they relate to each other.

In this session, we will learn how to use Arrow’s Resource Domain-Specific Language (DSL) to reason about resource safety in the same way we use structured concurrency to avoid leaking resources. We will also see how this can be combined with KotlinX Coroutines to build complex use cases in a simple and elegant way using Kotlin DSLs.
