name := "zio.http"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.5.0-RC4"
libraryDependencies ++= {
  val zioVersion = "2.1.6"
  Seq(
    "dev.zio" %% "zio-http" % "3.0.0-RC9",
    "dev.zio" %% "zio-json" % "0.7.1",
    "ch.qos.logback" % "logback-classic" % "1.5.6",
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test

  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
