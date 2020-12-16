package sphynx

import cats.effect.Sync
import org.slf4j.{LoggerFactory, Logger => Underlying}

trait LazyLogging[F[_]] {
  private lazy val underlying: Underlying =
    LoggerFactory.getLogger(getClass.getName)
  protected def logger(implicit sync: Sync[F]): LazyLogger[F] =
    LazyLogger(underlying)
}
