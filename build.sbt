name := "basic-project"

organization := "example"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

//crossScalaVersions := Seq("2.10.5", "2.11.2")

resolvers += "DataStax Repo" at "https://datastax.artifactoryonline.com/datastax/public-repos/"

val akkaHttpVersion = "2.0.5"
val dseVersion = "5.1.0"

libraryDependencies ++= Seq(
  //  "org.apache.spark" %% "spark-core" % "2.0.2" excludeAll(
  "com.datastax.dse" % "dse-spark-dependencies" % dseVersion excludeAll(
    ExclusionRule("org.slf4j", "slf4j-log4j12"),
    ExclusionRule("org.mortbay.jetty"),
    ExclusionRule("javax.servlet"),
    ExclusionRule("org.apache.cassandra"),
    ExclusionRule("com.datastax.dse", "dse-java-driver-core"),
    ExclusionRule("org.apache.solr", "solr-solrj")
  ),
  "org.apache.commons" % "commons-lang3" % "3.5",
  "com.typesafe.akka" %% "akka-http-experimental" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaHttpVersion,
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "test",
  "junit" % "junit" % "4.10" % "test"
)


