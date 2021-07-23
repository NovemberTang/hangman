name := "hangman"

version := "0.1"

scalaVersion := "2.13.6"

idePackagePrefix := Some("novembertang.hangman")

val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "com.lihaoyi" %% "requests" % "0.6.9"

)
