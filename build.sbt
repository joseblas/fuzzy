name := "basic-project"

organization := "example"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.4"

//crossScalaVersions := Seq("2.10.4", "2.11.2")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.3",
//  "org.apache.commons" % "commons-lang3" % "3.5",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "test",
  "junit" % "junit" % "4.10" % "test"
)


