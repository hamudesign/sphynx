---
layout: page
title: "Home"
position: 1
---

# Sphynx
[![maven-central](https://img.shields.io/maven-central/v/design.hamu/sphynx-core_2.12)](https://index.scala-lang.org/hamuhouse/sphynx-core/sphynx-core)
[![javadoc.io](https://javadoc.io/badge2/design.hamu/sphynx-core_2.12/javadoc.io.svg)](https://javadoc.io/doc/design.hamu/sphynx-core_2.12)

Fully functional logging framework built on top of SLF4J. Available for scala 2.12 and 2.13.

Fast tuning is powered by lazy evaluation and applied _check-enabled-idiom_.
```scala
if (logger.isDebugEnabled) logger.debug(s"Some $expensive message!")
```

### Getting Started
Create sphynx dependency by adding the following line to your `build.sbt`
```scala
libraryDependencies += "design.hamu" %% "sphynx-core" % version
```

Below are additional addon modules that may also be needed based on your use case.
- `sphynx-circe` if you want to integrate structured logging with circe

### Technology Used
- SLF4J
- Logstash Logback Encoder (for structured logging)
- Jackson JSON (for structured logging)
