package sphynx

import cats.effect.Sync

import scala.reflect.ClassTag
import org.slf4j.{LoggerFactory, Marker, Logger => Underlying}

trait LazyLogger[F[_]] {
  def error(message: => String): F[Unit]
  def error(message: => String, cause: => Throwable): F[Unit]
  def markedError(marker: => Marker, message: => String): F[Unit]
  def markedError(marker: => Marker, message: => String, cause: => Throwable): F[Unit]
  def warn(message: => String): F[Unit]
  def warn(message: => String, cause: => Throwable): F[Unit]
  def markedWarn(marker: => Marker, message: => String): F[Unit]
  def markedWarn(marker: => Marker, message: => String, cause: => Throwable): F[Unit]
  def info(message: => String): F[Unit]
  def info(message: => String, cause: => Throwable): F[Unit]
  def markedInfo(marker: => Marker, message: => String): F[Unit]
  def markedInfo(marker: => Marker, message: => String, cause: => Throwable): F[Unit]
  def debug(message: => String): F[Unit]
  def debug(message: => String, cause: => Throwable): F[Unit]
  def markedDebug(marker: => Marker, message: => String): F[Unit]
  def markedDebug(marker: => Marker, message: => String, cause: => Throwable): F[Unit]
  def trace(message: => String): F[Unit]
  def trace(message: => String, cause: => Throwable): F[Unit]
  def markedTrace(marker: => Marker, message: => String): F[Unit]
  def markedTrace(marker: => Marker, message: => String, cause: => Throwable): F[Unit]
}

object LazyLogger {

  def apply[F[_]: Sync](underlying: Underlying): LazyLogger[F] = new LazyLogger[F] {

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
  }

  def apply[F[_]: Sync](name: String): LazyLogger[F] =
    LazyLogger(LoggerFactory.getLogger(name))

  def apply[F[_]: Sync](clazz: Class[_]): LazyLogger[F] =
    LazyLogger(LoggerFactory.getLogger(clazz.getName))

  def apply[F[_]: Sync, T: ClassTag]: LazyLogger[F] =
    LazyLogger(
      LoggerFactory.getLogger(implicitly[ClassTag[T]].runtimeClass.getName.stripSuffix("$"))
    )
}
