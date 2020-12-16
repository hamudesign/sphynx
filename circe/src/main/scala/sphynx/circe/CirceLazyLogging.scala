package sphynx.circe

import sphynx.StructuredLazyLogging

trait CirceLazyLogging[F[_]] extends StructuredLazyLogging[F] with CirceSphynxInstances
