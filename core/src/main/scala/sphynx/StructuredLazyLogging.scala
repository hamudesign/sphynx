package sphynx

import cats.effect.Sync

import org.slf4j.{LoggerFactory, Logger => Underlying}

trait StructuredLazyLogging[F[_]] {
  private lazy val underlying: Underlying =
    LoggerFactory.getLogger(getClass.getName)
  protected def logger(implicit sync: Sync[F]): StructuredLazyLogger[F] =
    StructuredLazyLogger(underlying)
}
