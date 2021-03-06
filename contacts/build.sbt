name := """contacts"""
organization := "com.innoq"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  evolutions,
  jdbc,
  javaJdbc % Test,
  guice,
  "com.h2database" % "h2" % "1.4.192",
  "org.webjars" %% "webjars-play" % "2.6.0",
  "org.webjars" % "bootstrap" % "3.3.7-1",
  "org.webjars" % "jquery" % "1.11.0"
)

javaOptions in Test += "-Dconfig.file=conf/application.test.conf"
