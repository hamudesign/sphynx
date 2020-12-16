package sphynx

import cats.effect.IO
import org.scalamock.scalatest.MockFactory
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.slf4j.Logger

class StructuredLazyLoggerSpec extends AnyWordSpec with Matchers with MockFactory with LazyLoggingBehavior {
  "StructuredLazyLogger" when {
    behave like lazyLoggerFactory(StructuredLazyLogger.apply[IO])
  }
}
