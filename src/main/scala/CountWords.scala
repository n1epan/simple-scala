import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleAPP {
    def main(args: Array[String]) {
        val logFile = "/usr/local/spark-1.3.1-bin-hadoop2.6/README.md"
        val conf = new SparkConf().setAppName("Simple Application")
        val sc = new SparkContext(conf)
        val logData = sc.textFile(logFile,2).cache()
        val numAs = logData.filter(line=>line.contains("a")).count()
        val numBs = logData.filter(line=>line.contains("b")).count()
        println("lines with a:%s, lines with b: %s".format(numAs, numBs))
    }
}
