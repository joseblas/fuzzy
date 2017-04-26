package fuzzy

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * Created by jta on 21/04/2017.
  */
object Simple  //extends App
{
  val conf: SparkConf = new SparkConf()
    .setAppName("Fuzzy")
    .setMaster("spark://127.0.0.1:7077")
    .set("spark.cores.max", "2")

      .setJars(Seq(
        "/Users/jta/.ivy2/local/example/basic-project_2.10/0.1.0-SNAPSHOT/jars/basic-project_2.10.jar"
  //      "/Users/jta/.ivy2/cache/org.apache.spark/spark-core_2.10/jars/spark-core_2.10-1.6.3.jar",
  //      "/Users/jta/.ivy2/cache/org.apache.commons/commons-lang3/jars/commons-lang3-3.5.jar",
  //      "/Users/jta/.ivy2/local/example/basic-project_2.10/0.1.0-SNAPSHOT/jars/basic-project_2.10.jar")
      ))

  val sc: SparkContext = SparkContext.getOrCreate(conf)


  var NUM_SAMPLES: Int = 4

  val join = sc.parallelize(1 to NUM_SAMPLES).filter { _ =>
    val x = math.random
    val y = math.random
    x*x + y*y < 1
  }.count()
  println(s"Pi is roughly ${4.0 * join / NUM_SAMPLES}")


//  val testCompanies: RDD[String] = sc.parallelize(Seq("Tesco", "TSB", "JT Coder"))
//  val myNames: RDD[String] = sc.parallelize(Seq("Tesco", "TSB", "JT Coder"))
//
//  val join = testCompanies.map(c => (c, myNames))
}
