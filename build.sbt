name := "zio.http"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.4.2-RC1"
libraryDependencies ++= {
  val zioVersion = "2.0.21"
  Seq(
    "dev.zio" %% "zio-http" % "3.0.0-RC6",
    "dev.zio" %% "zio-json" % "0.6.2",
    "ch.qos.logback" % "logback-classic" % "1.5.3",
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test

  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
