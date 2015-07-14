name := "Simple_Project"
version := "1.0"
scalaVersion := "2.10.4"
libraryDependencies ++= Seq(
    ("org.apache.spark" %% "spark-core" % "1.3.1" % "provided"),
    "org.apache.spark" %% "spark-sql" % "1.3.1" % "provided",
    "org.apache.spark" % "spark-streaming_2.10" % "1.3.1" % "provided",
    ("org.apache.spark" % "spark-streaming-kafka_2.10" % "1.3.1").exclude("org.spark-project.spark", "unused") ,
    "com.datastax.spark" %% "spark-cassandra-connector" % "1.3.0-M1"
)

