name := "zio.http"
organization := "objektwerks"
version := "0.3-SNAPSHOT"
scalaVersion := "3.5.1-RC2"
libraryDependencies ++= {
  val zioVersion = "2.1.9"
  Seq(
    "dev.zio" %% "zio-http" % "3.0.0-RC10",
    "dev.zio" %% "zio-json" % "0.7.2",
    "ch.qos.logback" % "logback-classic" % "1.5.7",
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test

  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
