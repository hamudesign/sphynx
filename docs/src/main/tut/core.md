---
layout: page
title:  "Core"
section: "core"
position: 2
---

# Core

### LazyLogging
The `LazyLogging[F]` provides a lazy, _check-enabled-idiom_ logger that can be used for logging in an `F` sync type.

```scala
import cats.effect.{ExitCode, IO, IOApp}
import sphynx.LazyLogging

object Main extends IOApp with LazyLogging[IO] {
  def run(args: List[String]): IO[ExitCode] =
      for {
        _ <- logger.info("This is an info level log...")
        _ <- logger.warn("This is a warn level log...")
        _ <- logger.error(
          "This is an error level log...", 
          new Exception("Cause of error")
        )
      } yield ExitCode.Success
}
```

### LoggingContext
`LoggingContext[T]` provides a TypeClass for types that can be treated as a context marker for
the Logstash Logback Encoder.

```scala
trait LoggingContext[T] {
  def encode(context: T): DeferredLogstashMarker
}
```

### StructuredLazyLogging
The `StructuredLazyLogging[F]` provides extra functionality on top of `LazyLogging[F]`, 
allowing for logging with additional context object `T` provided an implicit `LoggingContext` type class.

```scala
import cats.effect.{ExitCode, IO, IOApp}
import sphynx.StructuredLazyLogging

case class MyContext(name: String)
object MyContext {
  implicit val loggingContext: LoggingContext[MyContext] = ...
}

object Main extends IOApp with StructuredLazyLogging[IO] {
  def run(args: List[String]): IO[ExitCode] =
      for {
        _ <- logger.info("I can log without context...")
        _ <- logger.structuredInfo(
          MyContext("example"),
          "I can also log with context..."
        )
      } yield ExitCode.Success
}
```
