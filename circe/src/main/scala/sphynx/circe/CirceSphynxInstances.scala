package sphynx.circe

import io.circe.syntax._
import io.circe.{Encoder, JsonObject}
import io.circe.jackson.circeToJackson
import net.logstash.logback.marker.{DeferredLogstashMarker, Markers}
import sphynx.LoggingContext

trait CirceSphynxInstances {
  implicit val circeJsonLoggingContext: LoggingContext[JsonObject] = (json: JsonObject) =>
    new DeferredLogstashMarker(() => {
      json.toIterable.foldLeft(Markers.empty()) {
        case (marker, (k, v)) =>
          marker.and(Markers.append(k, circeToJackson(v)))
      }
    })

  implicit def circeEncoderLoggingContext[T: Encoder.AsObject]: LoggingContext[T] =
    (arg: T) => circeJsonLoggingContext.encode(arg.asJsonObject)
}
