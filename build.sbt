name := "zio.http"
organization := "objektwerks"
version := "0.3-SNAPSHOT"
scalaVersion := "3.7.0-RC1"
libraryDependencies ++= {
  val zioVersion = "2.1.16"
  Seq(
    "dev.zio" %% "zio-http" % "3.0.1",
    "dev.zio" %% "zio-json" % "0.7.39",
    "ch.qos.logback" % "logback-classic" % "1.5.17",
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test

  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
