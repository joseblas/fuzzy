package fuzzy

import java.util.Locale

import org.apache.commons.lang3.StringUtils._
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import fuzzy.CompanyData._

import scala.io.Source
import scala.math.BigDecimal.RoundingMode

object Ranking //extends App
 {

  //  val conf: SparkConf = getSpark(Local(), "Fuzzy")

  //  val sc: SparkContext = SparkContext.getOrCreate(conf)

  val data = Source.fromFile("/Users/jta/coursera/fuzzy/src/main/resources/samples/companytestlist.csv").getLines().toList
  val fste = Source.fromFile("/Users/jta/coursera/fuzzy/src/main/resources/samples/ftse100companies.csv").getLines().toList

  //  val testCompanies: RDD[String] = sc.parallelize(data)

  //  val testCompanies: RDD[String] = sc.textFile(CompanyData.fileTestPath)
  //    val testCompanies: RDD[String] = sc.parallelize(kb)
  //sc.textFile(CompanyData.fileTestPath).map(CompanyData.parse)

  //  val fste = sc.textFile(CompanyData.filePath).collect.toList


  //  println("fste " + fste.size)

  //  val ff = testCompanies.map(c => (c, fste))

  val join = data.map(c => (c, fste.filter(_.toLowerCase.startsWith(c.charAt(0).toString.toLowerCase))))
    .map { c =>
      val fuzzyList = c._2
        .map(company => (
          company,
          BigDecimal(
            (Math.max(
              getJaroWinklerDistance(c._1, company),
              getJaroWinklerDistance(company, c._1))

              +
              getAcronymDistance(c._1, company)
              +
              Math.max(
                getFuzzyDistance(company, c._1, Locale.ENGLISH) / value(c._1),
                getFuzzyDistance(c._1, company, Locale.ENGLISH) / value(c._1)
              ))
              / 3
          ).setScale(2, RoundingMode.HALF_UP).toDouble,

          company.equalsIgnoreCase(c._1)
        ))
        .sortBy(_._2)(Ordering[Double].reverse)
        .take(1)
      //                 //// .takeOrdered(1)( Ordering[Double].reverse.on { x => x._2 })
      //
      //
      (c._1, fuzzyList)
    }
  //    join
  //  }
  join.
    foreach {
      it => it._2.foreach( e =>  println(s" Company: ${it._1}  -> ${e._1} ${if (e._3) 1.0 else e._2}") )
    }
}

//object Ranking {
//
//  def apply(kb: List[String], data: List[String]) = new Ranking(kb, data)
//
//
//}
