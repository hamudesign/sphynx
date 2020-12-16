package sphynx

import org.scalamock.scalatest.MockFactory
import org.slf4j.{Logger, Marker}

trait LoggingSimulation { this: MockFactory =>

  def mockErrorEnabledLogger(msg: String): Logger = {
    val underlying = mock[Logger]
    (underlying.isErrorEnabled: () => Boolean).expects().returning(true)
    (underlying.error(_: String)).expects(msg)
    underlying
  }

  def mockErrorEnabledLogger(msg: String, cause: Throwable): Logger = {
    val underlying = mock[Logger]
    (underlying.isErrorEnabled: () => Boolean).expects().returning(true)
    (underlying.error(_: String, _: Throwable)).expects(msg, cause)
    underlying
  }

  def mockErrorEnabledLogger(marker: Marker, msg: String): Logger = {
    val underlying = mock[Logger]
    (underlying.isErrorEnabled(_: Marker)).expects(marker).returning(true)
    (underlying.error(_: Marker, _: String)).expects(marker, msg)
    underlying
  }

  def mockErrorEnabledLogger(marker: Marker, msg: String, cause: Throwable): Logger = {
    val underlying = mock[Logger]
    (underlying.isErrorEnabled(_: Marker)).expects(marker).returning(true)
    (underlying.error(_: Marker, _: String, _: Throwable)).expects(marker, msg, cause)
    underlying
  }

  def mockErrorDisabledLogger: Logger = {
    val underlying = mock[Logger]
    (underlying.isErrorEnabled: () => Boolean).expects().returning(false)
    underlying
  }

  def mockErrorDisabledLogger(marker: Marker): Logger = {
    val underlying = mock[Logger]
    (underlying.isErrorEnabled(_: Marker)).expects(marker).returning(false)
    underlying
  }

  def mockWarnEnabledLogger(msg: String): Logger = {
    val underlying = mock[Logger]
    (underlying.isWarnEnabled: () => Boolean).expects().returning(true)
    (underlying.warn(_: String)).expects(msg)
    underlying
  }

  def mockWarnEnabledLogger(msg: String, cause: Throwable): Logger = {
    val underlying = mock[Logger]
    (underlying.isWarnEnabled: () => Boolean).expects().returning(true)
    (underlying.warn(_: String, _: Throwable)).expects(msg, cause)
    underlying
  }

  def mockWarnEnabledLogger(marker: Marker, msg: String): Logger = {
    val underlying = mock[Logger]
    (underlying.isWarnEnabled(_: Marker)).expects(marker).returning(true)
    (underlying.warn(_: Marker, _: String)).expects(marker, msg)
    underlying
  }

  def mockWarnEnabledLogger(marker: Marker, msg: String, cause: Throwable): Logger = {
    val underlying = mock[Logger]
    (underlying.isWarnEnabled(_: Marker)).expects(marker).returning(true)
    (underlying.warn(_: Marker, _: String, _: Throwable)).expects(marker, msg, cause)
    underlying
  }

  def mockWarnDisabledLogger: Logger = {
    val underlying = mock[Logger]
    (underlying.isWarnEnabled: () => Boolean).expects().returning(false)
    underlying
  }

  def mockWarnDisabledLogger(marker: Marker): Logger = {
    val underlying = mock[Logger]
    (underlying.isWarnEnabled(_: Marker)).expects(marker).returning(false)
    underlying
  }

  def mockInfoEnabledLogger(msg: String): Logger = {
    val underlying = mock[Logger]
    (underlying.isInfoEnabled: () => Boolean).expects().returning(true)
    (underlying.info(_: String)).expects(msg)
    underlying
  }

  def mockInfoEnabledLogger(msg: String, cause: Throwable): Logger = {
    val underlying = mock[Logger]
    (underlying.isInfoEnabled: () => Boolean).expects().returning(true)
    (underlying.info(_: String, _: Throwable)).expects(msg, cause)
    underlying
  }

  def mockInfoEnabledLogger(marker: Marker, msg: String): Logger = {
    val underlying = mock[Logger]
    (underlying.isInfoEnabled(_: Marker)).expects(marker).returning(true)
    (underlying.info(_: Marker, _: String)).expects(marker, msg)
    underlying
  }

  def mockInfoEnabledLogger(marker: Marker, msg: String, cause: Throwable): Logger = {
    val underlying = mock[Logger]
    (underlying.isInfoEnabled(_: Marker)).expects(marker).returning(true)
    (underlying.info(_: Marker, _: String, _: Throwable)).expects(marker, msg, cause)
    underlying
  }

  def mockInfoDisabledLogger: Logger = {
    val underlying = mock[Logger]
    (underlying.isInfoEnabled: () => Boolean).expects().returning(false)
    underlying
  }

  def mockInfoDisabledLogger(marker: Marker): Logger = {
    val underlying = mock[Logger]
    (underlying.isInfoEnabled(_: Marker)).expects(marker).returning(false)
    underlying
  }

  def mockDebugEnabledLogger(msg: String): Logger = {
    val underlying = mock[Logger]
    (underlying.isDebugEnabled: () => Boolean).expects().returning(true)
    (underlying.debug(_: String)).expects(msg)
    underlying
  }

  def mockDebugEnabledLogger(msg: String, cause: Throwable): Logger = {
    val underlying = mock[Logger]
    (underlying.isDebugEnabled: () => Boolean).expects().returning(true)
    (underlying.debug(_: String, _: Throwable)).expects(msg, cause)
    underlying
  }

  def mockDebugEnabledLogger(marker: Marker, msg: String): Logger = {
    val underlying = mock[Logger]
    (underlying.isDebugEnabled(_: Marker)).expects(marker).returning(true)
    (underlying.debug(_: Marker, _: String)).expects(marker, msg)
    underlying
  }

  def mockDebugEnabledLogger(marker: Marker, msg: String, cause: Throwable): Logger = {
    val underlying = mock[Logger]
    (underlying.isDebugEnabled(_: Marker)).expects(marker).returning(true)
    (underlying.debug(_: Marker, _: String, _: Throwable)).expects(marker, msg, cause)
    underlying
  }

  def mockDebugDisabledLogger: Logger = {
    val underlying = mock[Logger]
    (underlying.isDebugEnabled: () => Boolean).expects().returning(false)
    underlying
  }

  def mockDebugDisabledLogger(marker: Marker): Logger = {
    val underlying = mock[Logger]
    (underlying.isDebugEnabled(_: Marker)).expects(marker).returning(false)
    underlying
  }

  def mockTraceEnabledLogger(msg: String): Logger = {
    val underlying = mock[Logger]
    (underlying.isTraceEnabled: () => Boolean).expects().returning(true)
    (underlying.trace(_: String)).expects(msg)
    underlying
  }

  def mockTraceEnabledLogger(msg: String, cause: Throwable): Logger = {
    val underlying = mock[Logger]
    (underlying.isTraceEnabled: () => Boolean).expects().returning(true)
    (underlying.trace(_: String, _: Throwable)).expects(msg, cause)
    underlying
  }

  def mockTraceEnabledLogger(marker: Marker, msg: String): Logger = {
    val underlying = mock[Logger]
    (underlying.isTraceEnabled(_: Marker)).expects(marker).returning(true)
    (underlying.trace(_: Marker, _: String)).expects(marker, msg)
    underlying
  }

  def mockTraceEnabledLogger(marker: Marker, msg: String, cause: Throwable): Logger = {
    val underlying = mock[Logger]
    (underlying.isTraceEnabled(_: Marker)).expects(marker).returning(true)
    (underlying.trace(_: Marker, _: String, _: Throwable)).expects(marker, msg, cause)
    underlying
  }

  def mockTraceDisabledLogger: Logger = {
    val underlying = mock[Logger]
    (underlying.isTraceEnabled: () => Boolean).expects().returning(false)
    underlying
  }

  def mockTraceDisabledLogger(marker: Marker): Logger = {
    val underlying = mock[Logger]
    (underlying.isTraceEnabled(_: Marker)).expects(marker).returning(false)
    underlying
  }
}
