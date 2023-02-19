---
layout: post
title: Grateful Shutdown with Structured Concurrency
categories: [Kotlin, StructuredConcurrency, Resource]
---

[![Grateful Shutdown with Structured Concurrency](http://img.youtube.com/vi/A69_t_oEP_E/0.jpg)](http://www.youtube.com/watch?v=A69_t_oEP_E "Grateful Shutdown with Structured Concurrency")

In the modern world we often need to make strong guarantees about how our applications terminate; Structured Concurrency gives us a powerful tool to reason about concurrency, parallel processes and how they relate to each other.

This talk will cover some of the issues you might encounter when not respecting graceful shutdown, and how we can leverage Structured Concurrency to reason about these issues.
