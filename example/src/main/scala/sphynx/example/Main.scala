package sphynx.example

import cats.effect.{ExitCode, IO, IOApp}
import io.circe.{Json, JsonObject}
import sphynx.circe.CirceLazyLogging

object Main extends IOApp with CirceLazyLogging[IO] {

  def run(args: List[String]): IO[ExitCode] =
    for {
      _ <- logger.info("Starting up app...")
      _ <- logger.structuredInfo(
        ("app" -> Json.fromString("example")) +: JsonObject.empty,
        "Example contextual log..."
      )
    } yield ExitCode.Success
}
