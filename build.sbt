name := "DELearning"

version := "0.1"

scalaVersion := "2.12.8"

version in ThisBuild := "1.0-SNAPSHOT"

publish / skip := true

libraryDependencies ++= Seq(

  "ru.chermenin" %% "spark-states" % "0.2",
  "org.apache.spark" %% "spark-core" % "2.4.5",
  "org.apache.spark" %% "spark-sql" % "2.4.5"


)