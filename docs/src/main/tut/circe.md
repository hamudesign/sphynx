---
layout: page
title:  "Circe"
section: "circe"
position: 3
---

# Circe

### CirceLogging
The `CirceLazyLogging[F]` is equivalent to `StructuredLazyLogging[F]`, 
however provides implicit `LoggingContext[T]` instances for 
circe `JsonObject` and any type with an implicit circe `Encoder.AsObject`.

```scala
import cats.effect.{ExitCode, IO, IOApp}
import io.circe.{Json, JsonObject}
import sphynx.circe.CirceLazyLogging

object Main extends IOApp with CirceLazyLogging[IO] {

  def run(args: List[String]): IO[ExitCode] =
    for {
      _ <- logger.info("Log without context...")
      _ <- logger.structuredInfo(
        ("app" -> Json.fromString("example")) +: JsonObject.empty,
        "Log with context..."
      )
    } yield ExitCode.Success
}
```
