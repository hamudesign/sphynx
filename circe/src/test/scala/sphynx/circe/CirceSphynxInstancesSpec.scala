package sphynx.circe

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.json.JsonGeneratorImpl
import com.fasterxml.jackson.databind.node.{IntNode, TextNode}
import io.circe.{Json, JsonObject}
import net.logstash.logback.marker.{DeferredLogstashMarker, LogstashMarker, Markers}
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import sphynx.LoggingContext

class CirceSphynxInstancesSpec extends AnyWordSpec with Matchers with CirceSphynxInstances {
  "CirceSphynxInstances" should {
    "supply LoggingContext[JsonObject]" in {
      implicitly[LoggingContext[JsonObject]]
        .encode(
          JsonObject.fromMap(
            Map(
              "foo" -> Json.fromString("bar"),
              "bar" -> Json.fromInt(1)
            )
          )
        )
        .toString must equal(
        new DeferredLogstashMarker(() => {
          Markers
            .empty()
            .and[LogstashMarker](
              Markers.append("foo", TextNode.valueOf("bar"))
            )
            .and[LogstashMarker](
              Markers.append("bar", IntNode.valueOf(1))
            )
        }).toString
      )
    }
    "supply LoggingContext[T] given Encoder[T]" in {
      implicitly[LoggingContext[Map[String, Int]]]
        .encode(
          Map("one" -> 1, "two" -> 2)
        )
        .toString must equal(
        new DeferredLogstashMarker(() => {
          Markers.empty
            .and[LogstashMarker](
              Markers.append("one", IntNode.valueOf(1))
            )
            .and[LogstashMarker](
              Markers.append("two", IntNode.valueOf(2))
            )
        }).toString
      )
    }
  }
}
