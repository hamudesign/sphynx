package sphynx

import net.logstash.logback.marker.{DeferredLogstashMarker}

trait LoggingContext[T] {
  def encode(context: T): DeferredLogstashMarker
}
