package sphynx

import cats.effect.IO
import org.scalatest.wordspec.AnyWordSpec
import org.slf4j.{Logger}

import scala.util.Random

trait StructuredLazyLoggingBehavior extends LazyLoggingBehavior { this: AnyWordSpec =>

  lazy val ctx = DummyContext(Random.alphanumeric.take(10).mkString)
  lazy val marker = DummyContext.loggingContext.encode(ctx)

  def structuredErrorEnabled(factory: Logger => StructuredLazyLogger[IO]): Unit = {
    "log structured error level log given context and message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockErrorEnabledLogger(marker, msg))
        .structuredError(ctx, msg)
        .unsafeRunSync()
    }
    "log structured error level log given context, message, and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockErrorEnabledLogger(marker, msg, cause))
        .structuredError(ctx, msg, cause)
        .unsafeRunSync()
    }
  }

  def structuredWarnEnabled(factory: Logger => StructuredLazyLogger[IO]): Unit = {
    "log structured warn level log given context and message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockWarnEnabledLogger(marker, msg))
        .structuredWarn(ctx, msg)
        .unsafeRunSync()
    }
    "log structured warn level log given context, message, and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockWarnEnabledLogger(marker, msg, cause))
        .structuredWarn(ctx, msg, cause)
        .unsafeRunSync()
    }
  }

  def structuredInfoEnabled(factory: Logger => StructuredLazyLogger[IO]): Unit = {
    "log structured info level log given context and message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockWarnEnabledLogger(marker, msg))
        .structuredWarn(ctx, msg)
        .unsafeRunSync()
    }
    "log structured info level log given context, message, and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockWarnEnabledLogger(marker, msg, cause))
        .structuredWarn(ctx, msg, cause)
        .unsafeRunSync()
    }
  }

  def structuredDebugEnabled(factory: Logger => StructuredLazyLogger[IO]): Unit = {
    "log structured debug level log given context and message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockDebugEnabledLogger(marker, msg))
        .structuredDebug(ctx, msg)
        .unsafeRunSync()
    }
    "log structured debug level log given context, message, and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockDebugEnabledLogger(marker, msg, cause))
        .structuredDebug(ctx, msg, cause)
        .unsafeRunSync()
    }
  }

  def structuredTraceEnabled(factory: Logger => StructuredLazyLogger[IO]): Unit = {
    "log structured trace level log given context and message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockTraceEnabledLogger(marker, msg))
        .structuredTrace(ctx, msg)
        .unsafeRunSync()
    }
    "log structured trace level log given context, message, and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockTraceEnabledLogger(marker, msg, cause))
        .structuredTrace(ctx, msg, cause)
        .unsafeRunSync()
    }
  }

  def structuredLoggerFactory(factory: Logger => StructuredLazyLogger[IO]): Unit = {
    "error enabled" should {
      behave like lazyErrorEnabled(factory)
      behave like structuredErrorEnabled(factory)
    }
    "error disabled" should {
      behave like lazyErrorDisabled(factory)
    }
    "warn enabled" should {
      behave like lazyWarnEnabled(factory)
      behave like structuredWarnEnabled(factory)
    }
    "warn disabled" should {
      behave like lazyWarnDisabled(factory)
    }
    "info enabled" should {
      behave like lazyInfoEnabled(factory)
      behave like structuredInfoEnabled(factory)
    }
    "info disabled" should {
      behave like lazyInfoDisabled(factory)
    }
    "debug enabled" should {
      behave like lazyDebugEnabled(factory)
      behave like structuredDebugEnabled(factory)
    }
    "debug disabled" should {
      behave like lazyDebugDisabled(factory)
    }
    "trace enabled" should {
      behave like lazyTraceEnabled(factory)
      behave like structuredTraceEnabled(factory)
    }
    "trace disabled" should {
      behave like lazyTraceDisabled(factory)
    }
  }
}
