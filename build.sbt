name := "labeled-tostring-benchmarks"

organization := "com.yuvimasory"

version := "0.5.0"

description := "Benchmarks for labeled-tostring project"

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-deprecation", "-unchecked")

crossScalaVersions := Seq(
  "2.9.1-1", "2.9.1", "2.9.0-1", "2.9.0",
  "2.8.1", "2.8.0"
)

traceLevel := 5

libraryDependencies ++= Seq(
  "com.google.code.java-allocation-instrumenter" % "java-allocation-instrumenter" % "2.0",
  "com.google.code.gson" % "gson" % "1.7.1",
  "com.yuvimasory" %% "labeled-tostring" % "0.5.0"
)

resolvers += "sonatypeSnapshots" at "http://oss.sonatype.org/content/repositories/snapshots"

fork in run := true

javaOptions in run <++= (fullClasspath in Runtime) map { cp => Seq("-cp", sbt.Build.data(cp).mkString(":")) }
