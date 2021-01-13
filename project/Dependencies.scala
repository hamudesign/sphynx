package design.hamu

import sbt._

object Dependencies {

  object ScalaLang {
    def compiler(scalaVersion: String) = "org.scala-lang" % "scala-compiler" % scalaVersion
  }

  object Cats {
    private val version = "2.3.1"
    val core = "org.typelevel" %% "cats-core" % version
    val effect = "org.typelevel" %% "cats-effect" % version
  }

  object SLF4J {
    private val version = "1.7.30"
    val api = "org.slf4j" % "slf4j-api" % version
  }

  object Logback {
    private val version = "1.2.3"
    val classic = "ch.qos.logback" %  "logback-classic" % version
  }

  object Logstash {
    private val version = "6.6"
    val encoder = "net.logstash.logback" % "logstash-logback-encoder" % version
  }

  object Jackson {
    private val version = "2.10.5"
    val core = "com.fasterxml.jackson.core" % "jackson-core" % version
  }

  object Circe {
    private val version = "0.13.0"
    val core =  "io.circe" %% "circe-core" % version
    val generic = "io.circe" %% "circe-generic" % version
    val jackson = "io.circe" %% "circe-jackson210" % version
  }

  object Scalatest {
    private val version = "3.2.3"
    val core: ModuleID = "org.scalatest" %% "scalatest" % version
  }

  object ScalaMock {
    val core: ModuleID = "org.scalamock" %% "scalamock" % "5.1.0"
  }
}
