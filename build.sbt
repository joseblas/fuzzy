name := "basic-project"

organization := "example"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.5"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

//crossScalaVersions := Seq("2.10.4", "2.11.2")

mainClass := Some("fuzzy.Simple")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.3" excludeAll(
    ExclusionRule("commons-beanutils", "commons-beanutils-core"),
    ExclusionRule("commons-collections", "commons-collections"),
    ExclusionRule("org.hamcrest", "hamcrest-core"),
    ExclusionRule("junit", "junit"),
    ExclusionRule("org.jboss.netty", "netty"),
    ExclusionRule("com.esotericsoftware.minlog", "minlog")
  ),
  "org.apache.commons" % "commons-lang3" % "3.5",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "test",
  "junit" % "junit" % "4.10" % "test"
)


