package sphynx

import cats.effect.Sync
import org.slf4j.{LoggerFactory, Marker, Logger => Underlying}

import scala.reflect.ClassTag

trait StructuredLazyLogger[F[_]] extends LazyLogger[F] {
  def structuredError[C: LoggingContext](ctx: => C, message: => String): F[Unit]
  def structuredError[C: LoggingContext](ctx: => C, message: => String, cause: => Throwable): F[Unit]
  def structuredWarn[C: LoggingContext](ctx: => C, message: => String): F[Unit]
  def structuredWarn[C: LoggingContext](ctx: => C, message: => String, cause: => Throwable): F[Unit]
  def structuredInfo[C: LoggingContext](ctx: => C, message: => String): F[Unit]
  def structuredInfo[C: LoggingContext](ctx: => C, message: => String, cause: => Throwable): F[Unit]
  def structuredDebug[C: LoggingContext](ctx: => C, message: => String): F[Unit]
  def structuredDebug[C: LoggingContext](ctx: => C, message: => String, cause: => Throwable): F[Unit]
  def structuredTrace[C: LoggingContext](ctx: => C, message: => String): F[Unit]
  def structuredTrace[C: LoggingContext](ctx: => C, message: => String, cause: => Throwable): F[Unit]
}

object StructuredLazyLogger {

  def apply[F[_]: Sync](underlying: Underlying): StructuredLazyLogger[F] = new StructuredLazyLogger[F] {

    def error(message: => String): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isErrorEnabled) underlying.error(message)
    }

    def error(message: => String, cause: => Throwable): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isErrorEnabled) underlying.error(message, cause)
    }

    def markedError(marker: => Marker, message: => String): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isErrorEnabled(marker)) underlying.error(marker, message)
    }

    def markedError(marker: => Marker, message: => String, cause: => Throwable): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isErrorEnabled(marker)) underlying.error(marker, message, cause)
    }

    def warn(message: => String): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isWarnEnabled) underlying.warn(message)
    }

    def warn(message: => String, cause: => Throwable): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isWarnEnabled) underlying.warn(message, cause)
    }

    def markedWarn(marker: => Marker, message: => String): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isWarnEnabled(marker)) underlying.warn(marker, message)
    }

    def markedWarn(marker: => Marker, message: => String, cause: => Throwable): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isWarnEnabled(marker)) underlying.warn(marker, message, cause)
    }

    def info(message: => String): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isInfoEnabled) underlying.info(message)
    }

    def info(message: => String, cause: => Throwable): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isInfoEnabled) underlying.info(message, cause)
    }

    def markedInfo(marker: => Marker, message: => String): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isInfoEnabled(marker)) underlying.info(marker, message)
    }

    def markedInfo(marker: => Marker, message: => String, cause: => Throwable): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isInfoEnabled(marker)) underlying.info(marker, message, cause)
    }

    def debug(message: => String): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isDebugEnabled) underlying.debug(message)
    }

    def debug(message: => String, cause: => Throwable): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isDebugEnabled) underlying.debug(message, cause)
    }

    def markedDebug(marker: => Marker, message: => String): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isDebugEnabled(marker)) underlying.debug(marker, message)
    }

    def markedDebug(marker: => Marker, message: => String, cause: => Throwable): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isDebugEnabled(marker)) underlying.debug(marker, message, cause)
    }

    def trace(message: => String): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isTraceEnabled) underlying.trace(message)
    }

    def trace(message: => String, cause: => Throwable): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isTraceEnabled) underlying.trace(message, cause)
    }

    def markedTrace(marker: => Marker, message: => String): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isTraceEnabled(marker)) underlying.trace(marker, message)
    }

    def markedTrace(marker: => Marker, message: => String, cause: => Throwable): F[Unit] = implicitly[Sync[F]].delay {
      if (underlying.isTraceEnabled(marker)) underlying.trace(marker, message, cause)
    }

    def structuredError[C: LoggingContext](ctx: => C, message: => String): F[Unit] =
      markedError(implicitly[LoggingContext[C]].encode(ctx), message)

    def structuredError[C: LoggingContext](ctx: => C, message: => String, cause: => Throwable): F[Unit] =
      markedError(implicitly[LoggingContext[C]].encode(ctx), message, cause)

    def structuredWarn[C: LoggingContext](ctx: => C, message: => String): F[Unit] =
      markedWarn(implicitly[LoggingContext[C]].encode(ctx), message)

    def structuredWarn[C: LoggingContext](ctx: => C, message: => String, cause: => Throwable): F[Unit] =
      markedWarn(implicitly[LoggingContext[C]].encode(ctx), message, cause)

    def structuredInfo[C: LoggingContext](ctx: => C, message: => String): F[Unit] =
      markedInfo(implicitly[LoggingContext[C]].encode(ctx), message)

    def structuredInfo[C: LoggingContext](ctx: => C, message: => String, cause: => Throwable): F[Unit] =
      markedInfo(implicitly[LoggingContext[C]].encode(ctx), message, cause)

    def structuredDebug[C: LoggingContext](ctx: => C, message: => String): F[Unit] =
      markedDebug(implicitly[LoggingContext[C]].encode(ctx), message)

    def structuredDebug[C: LoggingContext](ctx: => C, message: => String, cause: => Throwable): F[Unit] =
      markedDebug(implicitly[LoggingContext[C]].encode(ctx), message, cause)

    def structuredTrace[C: LoggingContext](ctx: => C, message: => String): F[Unit] =
      markedTrace(implicitly[LoggingContext[C]].encode(ctx), message)

    def structuredTrace[C: LoggingContext](ctx: => C, message: => String, cause: => Throwable): F[Unit] =
      markedTrace(implicitly[LoggingContext[C]].encode(ctx), message, cause)
  }

  def apply[F[_]: Sync](name: String): StructuredLazyLogger[F] =
    StructuredLazyLogger(LoggerFactory.getLogger(name))

  def apply[F[_]: Sync](clazz: Class[_]): StructuredLazyLogger[F] =
    StructuredLazyLogger(LoggerFactory.getLogger(clazz.getName))

  def apply[F[_]: Sync, T: ClassTag]: StructuredLazyLogger[F] =
    StructuredLazyLogger(
      LoggerFactory.getLogger(implicitly[ClassTag[T]].runtimeClass.getName.stripSuffix("$"))
    )
}
