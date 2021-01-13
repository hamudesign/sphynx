package sphynx.circe

import com.fasterxml.jackson.core.JsonGenerator
import io.circe.{Json, JsonObject}
import org.scalamock.scalatest.MockFactory
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CirceSphynxInstancesSpec extends AnyWordSpec with Matchers with CirceSphynxInstances with MockFactory {
  "CirceSphynxInstances" should {
    "supply LoggingContext[JsonObject]" in {
      val generator = mock[JsonGenerator]
      (generator
        .writeFieldName(_: String))
        .expects("foo")
        .once()
      (generator.writeObject _)
        .expects(*)
        .once()
      (generator
        .writeFieldName(_: String))
        .expects("bar")
        .once()
      (generator.writeObject _)
        .expects(*)
        .once()
      circeJsonLoggingContext
        .encode(
          JsonObject.fromMap(
            Map(
              "foo" -> Json.fromString("bar"),
              "bar" -> Json.fromInt(1)
            )
          )
        )
        .writeTo(generator)
    }
    "supply LoggingContext[T] given Encoder[T]" in {
      val generator = mock[JsonGenerator]
      (generator
        .writeFieldName(_: String))
        .expects("one")
        .once()
      (generator.writeObject _)
        .expects(*)
        .once()
      (generator
        .writeFieldName(_: String))
        .expects("two")
        .once()
      (generator.writeObject _)
        .expects(*)
        .once()
      circeEncoderLoggingContext[Map[String, Int]]
        .encode(
          Map("one" -> 1, "two" -> 2)
        )
        .writeTo(generator)
    }
  }
}
