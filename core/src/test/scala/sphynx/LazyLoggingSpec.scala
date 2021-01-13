package sphynx

import cats.effect.IO
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class LazyLoggingSpec extends AnyWordSpec with Matchers with LazyLogging[IO] {
  "LazyLogging" should {
    "provide logger" in {
      type IOLogger = LazyLogger[IO]
      logger mustBe a[IOLogger]
    }
  }
}
