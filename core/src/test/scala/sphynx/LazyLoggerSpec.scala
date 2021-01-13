package sphynx

import cats.effect.IO
import org.scalamock.scalatest.MockFactory
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class LazyLoggerSpec extends AnyWordSpec with Matchers with MockFactory with LazyLoggingBehavior {
  "LazyLogger" when {
    behave like lazyLoggerFactory(LazyLogger.apply[IO])
  }
}
