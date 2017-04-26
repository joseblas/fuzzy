package fuzzy

import fuzzy.CompanyData.{distance, getSpark}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * Created by jta on 26/04/2017.
  */
class RankingSparkKb(data: List[String], kb: List[String]) {

  val dict = Map("limited" -> 1, "ltd" -> 1)

  val conf: SparkConf = getSpark(Dse(), "Fuzzy")

  val sc: SparkContext = SparkContext.getOrCreate(conf)

  val kownledgeBase: RDD[String] = sc.parallelize(kb)
  val fste = sc.parallelize(data)

  val list = fste
    .cartesian(kownledgeBase)
    .map( e => (e._1,e._2, distance(e._1,e._2) ))
    .groupBy(_._1)
    .map( e => (e._1, e._2.toList.sortBy(_._3)(Ordering[Double].reverse).take(1) ))

}
