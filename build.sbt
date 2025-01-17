name := "zio.http"
organization := "objektwerks"
version := "0.3-SNAPSHOT"
scalaVersion := "3.6.3"
libraryDependencies ++= {
  val zioVersion = "2.1.14"
  Seq(
    "dev.zio" %% "zio-http" % "3.0.1",
    "dev.zio" %% "zio-json" % "0.7.4",
    "ch.qos.logback" % "logback-classic" % "1.5.16",
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test

  )
}
scalacOptions ++= Seq(
  "-Wall"
)
