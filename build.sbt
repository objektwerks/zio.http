name := "zio.http"
organization := "objektwerks"
version := "0.3-SNAPSHOT"
scalaVersion := "3.7.1-RC1"
libraryDependencies ++= {
  val zioVersion = "2.1.18"
  Seq(
    "dev.zio" %% "zio-http" % "3.3.0",
    "dev.zio" %% "zio-json" % "0.7.43",
    "ch.qos.logback" % "logback-classic" % "1.5.18",
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test

  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
