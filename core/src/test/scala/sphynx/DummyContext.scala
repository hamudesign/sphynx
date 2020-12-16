package sphynx

import net.logstash.logback.marker.{DeferredLogstashMarker, Markers}

case class DummyContext(value: String)

object DummyContext {
  implicit val loggingContext: LoggingContext[DummyContext] = ctx => new DeferredLogstashMarker(() => {
    Markers.empty.and(Markers.append("value", ctx.value))
  })
}