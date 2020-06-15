import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.{OutputMode, Trigger}
import ru.chermenin.spark.sql.execution.streaming.state.implicits._


object SparkApp {

  def main(args:Array[String]) = {

    println("hello")

    val spark = SparkSession.builder().master("local[*]").useRocksDBStateStore().getOrCreate()

    // Create DataFrame representing the stream of input lines from connection to localhost:9999
    val lines = spark.readStream
      .format("socket")
      .option("host", "localhost")
      .option("port", 9999)
      .load()

    import spark.implicits._
    // Split the lines into words
    val words = lines.as[String].flatMap(_.split(" "))

    // Generate running word count
    val wordCounts = words.groupBy("value").count()
    val query = wordCounts.writeStream
      .format("console")
    .outputMode(OutputMode.Update())
    .trigger(Trigger.ProcessingTime(1000L))
      .stateTimeout(spark.conf, queryName="myQuery1", expirySecs = 5, checkpointLocation ="chkpntloc")
      .start()

    query.awaitTermination()
  }
}
