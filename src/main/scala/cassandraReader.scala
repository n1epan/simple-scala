import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import com.datastax.spark.connector._
import org.apache.spark.sql.cassandra.CassandraSQLContext

object CassandraAPP{
    def main(args: Array[String]) {
        val csHost = "cassandra-useast1b-node1.dev.bosecm.com"
        val csMaster = "spark://cassandra-useast1b-node1.dev.bosecm.com:7077"
        val conf = new SparkConf(true).set("spark.cassandra.connection.host", csHost).set("spark.cassandra.auth.username", "cassandra").set("spark.cassandra.auth.password", "cassandra")
        val sc = new SparkContext(conf)
        val cc = new CassandraSQLContext(sc)
        val df = cc.sql("SELECT * from stormcassandra.matchedtab_v3 WHERE userid = '11756' ORDER BY ts DESC LIMIT 3")
        df.show()
        //val rdd = sc.cassandraTable("stormcassandra", "matchedtab_v3")
        //rdd.toArray.foreach(println)
        //val collection = sc.parallelize(Seq(("0013", -423), ("134", 99)))
        //collection.saveToCassandra("stormcassandra", "test", SomeColumns("id", "value"))
        //println(rdd.count)
        //println(rdd.first)
        //println(rdd.map(_.getInt("value")).sum)        
    }
}
