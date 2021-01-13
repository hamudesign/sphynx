package sphynx

import cats.effect.IO
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class StructuredLazyLoggingSpec extends AnyWordSpec with Matchers with StructuredLazyLogging[IO] {
  "StructuredLazyLoggingSpec" should {
    "provide logger" in {
      type IOLogger = StructuredLazyLogger[IO]
      logger mustBe a[IOLogger]
    }
  }
}
