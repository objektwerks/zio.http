name := "zio.http"
organization := "objektwerks"
version := "0.3-SNAPSHOT"
scalaVersion := "3.8.3"
libraryDependencies ++= {
  val zioVersion = "2.1.25"
  Seq(
    "dev.zio" %% "zio-http" % "3.10.1",
    "dev.zio" %% "zio-json" % "0.9.1",
    "ch.qos.logback" % "logback-classic" % "1.5.32",
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test

  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
