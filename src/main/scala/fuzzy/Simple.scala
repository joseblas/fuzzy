package fuzzy

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * Created by jta on 21/04/2017.
  */
object Simple {
  val conf: SparkConf = new SparkConf()
    .setAppName("Fuzzy")
        .setMaster("spark://127.0.0.1:7077")

    .setJars(Seq(
      "/Users/jta/.ivy2/cache/org.apache.spark/spark-core_2.10/jars/spark-core_2.10-1.6.3.jar",
      "/Users/jta/.ivy2/cache/org.apache.commons/commons-lang3/jars/commons-lang3-3.5.jar",
      "/Users/jta/.ivy2/local/example/basic-project_2.10/0.1.0-SNAPSHOT/jars/basic-project_2.10.jar")
    )

  val sc: SparkContext = SparkContext.getOrCreate(conf)

  val companyNames: RDD[String] = sc.parallelize(Seq("Tesco", "TSB", "JT Coder"))
  val myNames: RDD[String] = sc.parallelize(Seq("Tesco", "TSB", "JT Coder"))

  val join = companyNames.map( c => (c,myNames))
}
