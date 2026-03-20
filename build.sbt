name := "zio.http"
organization := "objektwerks"
version := "0.3-SNAPSHOT"
scalaVersion := "3.8.3-RC2"
libraryDependencies ++= {
  val zioVersion = "2.1.24"
  Seq(
    "dev.zio" %% "zio-http" % "3.10.1",
    "dev.zio" %% "zio-json" % "0.9.0",
    "ch.qos.logback" % "logback-classic" % "1.5.32",
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test

  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
