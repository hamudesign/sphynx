import design.hamu.Dependencies
import design.hamu.CompilerPlugins

lazy val commonSettings = Seq(
  scalaVersion := "2.13.2",
  organization := "design.hamu",
  version := "0.1.0",
  scalacOptions := Seq("-Xlint", "-Ywarn-unused", "-deprecation", "-Ymacro-annotations"),
  dependencyUpdatesFailBuild := true,
  dependencyUpdatesFilter -= moduleFilter(name = "scala-library")
)

lazy val publishSettings = Seq(
  coverageMinimum := 90,
  coverageFailOnMinimum := true,
  crossScalaVersions := Seq(
    "2.12.12",
    "2.13.4"
  ),
  scalacOptions := {
    scalaBinaryVersion.value match {
      case v if v.startsWith("2.12") => Seq("-Ypartial-unification", "-deprecation")
      case v if v.startsWith("2.13") => Seq("-Ymacro-annotations", "-Xlint", "-Ywarn-unused", "-deprecation")
      case _ => Seq()
    }
  },
  libraryDependencies ++= {
    scalaBinaryVersion.value match {
      case v if v.startsWith("2.13") =>
        Seq()
      case _ =>
        Seq(
          compilerPlugin(CompilerPlugins.MacroParadise.core cross CrossVersion.full)
        )
    }
  },
  homepage := Some(url("https://hamuhouse.github.io/sphynx/")),
  licenses := List("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
  developers := List(
    Developer(id = "matsudaskai", name = "Kai Matsuda", email = "", url = url("https://vangogh500.github.io/"))
  ),
  scmInfo := Some(
    ScmInfo(url("https://github.com/hamuhouse/sphynx"), "scm:git@github.com:hamuhouse/sphynx.git")
  ),
  publishConfiguration := publishConfiguration.value.withOverwrite(isSnapshot.value),
  publishTo := sonatypePublishTo.value,
  credentials += Credentials(
    "Sonatype Nexus Repository Manager",
    "oss.sonatype.org",
    sys.env.getOrElse("SONATYPE_USERNAME", ""),
    sys.env.getOrElse("SONATYPE_PASSWORD", "")
  ),
  testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-u", "test-results", "-oD")
)

lazy val root = project
  .in(file("."))
  .settings(
    publish / skip := true
  )
  .aggregate(
    core,
    circe
  )

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
      Dependencies.Scalatest.core,
      Dependencies.ScalaMock.core
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
    micrositeName := "Sphynx",
    micrositeCompilingDocsTool := WithTut,
    micrositeBaseUrl := "sphynx",
    micrositeHomepage := "https://hamudesign.github.io/sphynx/",
    micrositeHighlightTheme := "atom-one-light",
    git.remoteRepo := "https://github.com/hamudesign/sphynx.git"
  )
  .enablePlugins(MicrositesPlugin)

