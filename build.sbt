import design.hamu.Dependencies
import design.hamu.CompilerPlugins

lazy val commonSettings = Seq(
  scalaVersion := "2.13.2",
  organization := "design.hamu",
  version := "0.0.1",
  scalacOptions := Seq("-Xlint", "-Ywarn-unused", "-deprecation", "-Ymacro-annotations"),
  dependencyUpdatesFailBuild := true,
  logLevel := Level.Info
)

lazy val publishSettings = Seq(
  coverageMinimum := 90,
  coverageFailOnMinimum := true,
  crossScalaVersions := Seq(
    "2.12.10",
    "2.13.2"
  ),
  scalacOptions := {
    scalaBinaryVersion.value match {
      case v if v.startsWith("2.12") => Seq("-Ypartial-unification", "-deprecation")
      case v if v.startsWith("2.13") => Seq("-Xlint", "-Ywarn-unused", "-deprecation")
      case _ => Seq()
    }
  }
)

lazy val root = project
  .in(file("."))

lazy val core = project
  .in(file("core"))
  .settings(
    name := "sphynx-core",
    commonSettings,
    publishSettings,
    libraryDependencies ++= Seq(
      Dependencies.Cats.core,
      Dependencies.Cats.effect,
      Dependencies.Logback.classic,
      Dependencies.Logstash.encoder
    ) ++ Seq(
      Dependencies.Scalatest.core,
      Dependencies.ScalaMock.core
    ).map(_ % "test")
  )

lazy val circe = project
  .in(file("circe"))
  .settings(
    name := "sphynx-circe",
    commonSettings,
    publishSettings,
    libraryDependencies ++= Seq(
      Dependencies.Circe.core,
      Dependencies.Circe.jackson
    ) ++ Seq(
      Dependencies.Scalatest.core
    ).map(_ % "test")
  )
  .dependsOn(core)

lazy val example = project
  .in(file("example"))
  .settings(
    name := "sphynx-example",
    commonSettings,
    publishSettings
  )
  .dependsOn(circe)

lazy val docs = project
  .in(file("docs"))
  .settings(
    name := "sphynx-docs",
    commonSettings,
    micrositeName := "Sphynx",
    micrositeCompilingDocsTool := WithTut,
    micrositeBaseUrl := "sphynx",
    micrositeHomepage := "https://hamuhouse.github.io/sphynx/",
    micrositeHighlightTheme := "atom-one-light",
    git.remoteRepo := "https://github.com/hamuhouse/sphynx.git"
  )
  .enablePlugins(MicrositesPlugin)

