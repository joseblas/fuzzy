package fuzzy


import fuzzy.CompanyData._
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by jta on 25/04/2017.
  */
class RankingSpark(data: List[String], kb: List[String]) {

  val conf: SparkConf = getSpark(Dse(), "Fuzzy")

  val sc: SparkContext = SparkContext.getOrCreate(conf)

  val kownledgeBase: RDD[String] = sc.parallelize(kb)
  val fste = sc.parallelize(data)

  val list = fste
    .cartesian(kownledgeBase)
    .map( e => (e._1,e._2, distance(e._1,e._2) ))
    .groupBy(_._1)
    .map( e => (e._1, e._2.toList.sortBy(_._3)(Ordering[Double].reverse) ))

}
