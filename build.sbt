name := """api-proxy"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalaj" % "scalaj-http_2.11" % "2.3.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

