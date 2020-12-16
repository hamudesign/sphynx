package sphynx

import cats.effect.IO
import org.scalamock.scalatest.MockFactory
import org.scalatest.wordspec.AnyWordSpec
import org.slf4j.{Logger, Marker, MarkerFactory}

import scala.util.Random

trait LazyLoggingBehavior extends MockFactory with LoggingSimulation { this: AnyWordSpec =>

  def lazyErrorEnabled(factory: Logger => LazyLogger[IO]): Unit = {
    "log error level log given message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockErrorEnabledLogger(msg))
        .error(msg)
        .unsafeRunSync
    }
    "log error level log given message and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockErrorEnabledLogger(msg, cause))
        .error(msg, cause)
        .unsafeRunSync
    }
    "log error level log given marker and message" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockErrorEnabledLogger(marker, msg))
        .markedError(marker, msg)
        .unsafeRunSync
    }
    "log error level log given marker, message, and cause" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockErrorEnabledLogger(marker, msg, cause))
        .markedError(marker, msg, cause)
        .unsafeRunSync
    }
  }

  def lazyErrorDisabled(factory: Logger => LazyLogger[IO]): Unit = {
    "not log error level log given message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockErrorDisabledLogger)
        .error(msg)
        .unsafeRunSync
    }
    "not log error level log given message and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockErrorDisabledLogger)
        .error(msg, cause)
        .unsafeRunSync
    }
    "not log error level log given marker and message" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockErrorDisabledLogger(marker))
        .markedError(marker, msg)
        .unsafeRunSync
    }
    "not log error level log given marker, message, and cause" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockErrorDisabledLogger(marker))
        .markedError(marker, msg, cause)
        .unsafeRunSync
    }
  }

  def lazyWarnEnabled(factory: Logger => LazyLogger[IO]): Unit = {
    "log warn level log given message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockWarnEnabledLogger(msg))
        .warn(msg)
        .unsafeRunSync
    }
    "log warn level log given message and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockWarnEnabledLogger(msg, cause))
        .warn(msg, cause)
        .unsafeRunSync
    }
    "log warn level log given marker and message" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockWarnEnabledLogger(marker, msg))
        .markedWarn(marker, msg)
        .unsafeRunSync
    }
    "log warn level log given marker, message, and cause" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockWarnEnabledLogger(marker, msg, cause))
        .markedWarn(marker, msg, cause)
        .unsafeRunSync
    }
  }

  def lazyWarnDisabled(factory: Logger => LazyLogger[IO]): Unit = {
    "not log warn level log given message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockWarnDisabledLogger)
        .warn(msg)
        .unsafeRunSync
    }
    "not log warn level log given message and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockWarnDisabledLogger)
        .warn(msg, cause)
        .unsafeRunSync
    }
    "not log warn level log given marker and message" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockWarnDisabledLogger(marker))
        .markedWarn(marker, msg)
        .unsafeRunSync
    }
    "not log warn level log given marker, message, and cause" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockWarnDisabledLogger(marker))
        .markedWarn(marker, msg, cause)
        .unsafeRunSync
    }
  }

  def lazyInfoEnabled(factory: Logger => LazyLogger[IO]): Unit = {
    "log info level log given message if info enabled" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockInfoEnabledLogger(msg))
        .info(msg)
        .unsafeRunSync
    }
    "log info level log given message and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockInfoEnabledLogger(msg, cause))
        .info(msg, cause)
        .unsafeRunSync
    }
    "log info level log given marker and message" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockInfoEnabledLogger(marker, msg))
        .markedInfo(marker, msg)
        .unsafeRunSync
    }
    "log info level log given marker, message, and cause" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockInfoEnabledLogger(marker, msg, cause))
        .markedInfo(marker, msg, cause)
        .unsafeRunSync
    }
  }

  def lazyInfoDisabled(factory: Logger => LazyLogger[IO]): Unit = {
    "not log info level log given message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockInfoDisabledLogger)
        .info(msg)
        .unsafeRunSync
    }
    "not log info level log given message and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockInfoDisabledLogger)
        .info(msg, cause)
        .unsafeRunSync
    }
    "not log info level log given marker and message" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockInfoDisabledLogger(marker))
        .markedInfo(marker, msg)
        .unsafeRunSync
    }
    "not log info level log given marker, message, and cause" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockInfoDisabledLogger(marker))
        .markedInfo(marker, msg, cause)
        .unsafeRunSync
    }
  }

  def lazyDebugEnabled(factory: Logger => LazyLogger[IO]): Unit = {
    "log debug level log given message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockDebugEnabledLogger(msg))
        .debug(msg)
        .unsafeRunSync
    }
    "log debug level log given message and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockDebugEnabledLogger(msg, cause))
        .debug(msg, cause)
        .unsafeRunSync
    }
    "log debug level log given marker and message" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockDebugEnabledLogger(marker, msg))
        .markedDebug(marker, msg)
        .unsafeRunSync
    }
    "log debug level log given marker, message, and cause" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockDebugEnabledLogger(marker, msg, cause))
        .markedDebug(marker, msg, cause)
        .unsafeRunSync
    }
  }

  def lazyDebugDisabled(factory: Logger => LazyLogger[IO]): Unit = {
    "not log debug level log given message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockDebugDisabledLogger)
        .debug(msg)
        .unsafeRunSync
    }
    "not log debug level log given message and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockDebugDisabledLogger)
        .debug(msg, cause)
        .unsafeRunSync
    }
    "not log debug level log given marker and message" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockDebugDisabledLogger(marker))
        .markedDebug(marker, msg)
        .unsafeRunSync
    }
    "not log debug level log given marker, message, and cause" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockDebugDisabledLogger(marker))
        .markedDebug(marker, msg, cause)
        .unsafeRunSync
    }
  }

  def lazyTraceEnabled(factory: Logger => LazyLogger[IO]): Unit = {
    "log trace level log given message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockTraceEnabledLogger(msg))
        .trace(msg)
        .unsafeRunSync
    }
    "log trace level log given message and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockTraceEnabledLogger(msg, cause))
        .trace(msg, cause)
        .unsafeRunSync
    }
    "log trace level log given marker and message" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockTraceEnabledLogger(marker, msg))
        .markedTrace(marker, msg)
        .unsafeRunSync
    }
    "log trace level log given marker, message, and cause" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockTraceEnabledLogger(marker, msg, cause))
        .markedTrace(marker, msg, cause)
        .unsafeRunSync
    }
  }

  def lazyTraceDisabled(factory: Logger => LazyLogger[IO]): Unit = {
    "not log trace level log given message" in {
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockTraceDisabledLogger)
        .trace(msg)
        .unsafeRunSync
    }
    "not log trace level log given message and cause" in {
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockTraceDisabledLogger)
        .trace(msg, cause)
        .unsafeRunSync
    }
    "not log trace level log given marker and message" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      factory(mockTraceDisabledLogger(marker))
        .markedTrace(marker, msg)
        .unsafeRunSync
    }
    "not log trace level log given marker, message, and cause" in {
      val marker = MarkerFactory.getDetachedMarker("test")
      val msg = Random.alphanumeric.take(10).mkString
      val cause = new Exception("Expected error")
      factory(mockTraceDisabledLogger(marker))
        .markedTrace(marker, msg, cause)
        .unsafeRunSync
    }
  }

  def lazyLoggerFactory(factory: Logger => LazyLogger[IO]): Unit = {
    "error enabled" should {
      behave like lazyErrorEnabled(factory)
    }
    "error disabled" should {
      behave like lazyErrorDisabled(factory)
    }
    "warn enabled" should {
      behave like lazyWarnEnabled(factory)
    }
    "warn disabled" should {
      behave like lazyWarnDisabled(factory)
    }
    "info enabled" should {
      behave like lazyInfoEnabled(factory)
    }
    "info disabled" should {
      behave like lazyInfoDisabled(factory)
    }
    "debug enabled" should {
      behave like lazyDebugEnabled(factory)
    }
    "debug disabled" should {
      behave like lazyDebugDisabled(factory)
    }
    "trace enabled" should {
      behave like lazyTraceEnabled(factory)
    }
    "trace disabled" should {
      behave like lazyTraceDisabled(factory)
    }
  }
}
