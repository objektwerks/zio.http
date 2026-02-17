name := "zio.http"
organization := "objektwerks"
version := "0.3-SNAPSHOT"
scalaVersion := "3.8.2-RC3"
libraryDependencies ++= {
  val zioVersion = "2.1.24"
  Seq(
    "dev.zio" %% "zio-http" % "3.7.4",
    "dev.zio" %% "zio-json" % "0.8.0",
    "ch.qos.logback" % "logback-classic" % "1.5.25",
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test

  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
