package sphynx

import cats.effect.IO
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class StructuredLazyLoggingSpec extends AnyWordSpec with Matchers with StructuredLazyLogging[IO] {
  "StructuredLazyLoggingSpec" should {
    type IOLogger = StructuredLazyLogger[IO]
    "provide logger" in {
      logger mustBe a[IOLogger]
    }
    "construct logger using name" in {
      StructuredLazyLogger[IO]("name") mustBe a[IOLogger]
    }
  }
}
