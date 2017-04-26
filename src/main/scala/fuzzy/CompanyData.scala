package fuzzy

import java.io.File
import java.util.Locale

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.StringUtils.{getFuzzyDistance, getJaroWinklerDistance}
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

import scala.math.BigDecimal.RoundingMode

/**
  * Created by jta on 20/04/2017.
  */

sealed class Env()

case class Local() extends Env

case class Dse() extends Env

case class Spark() extends Env


//case class Company(name: String)

object CompanyData {

  private[fuzzy] def fileTestPath = {
    new File(this.getClass.getClassLoader.getResource("/Users/jta/spark/companytestlist.csv").toURI).getPath
    //    new File("file:/Users/jta/spark/companytestlist.csv").getPath
  }

  private[fuzzy] def filePath = {
    new File(this.getClass.getClassLoader.getResource("/Users/jta/spark/ftse100companies.csv").toURI).getPath
    //    new File("file:/Users/jta/spark/ftse100companies.csv").getPath
  }

  //  def parse(line: String): Company = Company(line)

  def distance(name: String, other: String) = {
    if (name.equalsIgnoreCase(other))
      1.0
    else
      BigDecimal(
        (Math.max(
          getJaroWinklerDistance(name, other),
          getJaroWinklerDistance(other, name))

          +
          getAcronymDistance(name, other)
          +
          Math.max(
            getFuzzyDistance(other, name, Locale.ENGLISH) / value(name),
            getFuzzyDistance(name, other, Locale.ENGLISH) / value(name)
          ))
          / 3
      ).setScale(2, RoundingMode.HALF_UP).toDouble
  }

  def getAcronymDistance(a: String, b: String): Double = {
    if (a.forall(_.isUpper) && a.split(" ").length == 1) {
      StringUtils.getJaroWinklerDistance(a, cap(b))
    } else if (b.forall(_.isUpper) && b.split(" ").length == 1) {
      StringUtils.getJaroWinklerDistance(cap(a), b)
    } else
      1
  }

  def value(str: String) = str.length * 3 - 2

  def cap(str: String) = str.split(" ").map(_.charAt(0).toUpper).mkString

  def getSpark(env: Env, name: String = "Fuzzy"): SparkConf = {
     env match {
      case Local() =>
        new SparkConf()
          .setAppName(name)
          .setMaster("local[2]")

      case Dse() =>
        new SparkConf()
          .setAppName(name)
          .setMaster("spark://localhost:7077")
          .set("spark.cores.max", "2")
//          .set("spark.driver.cores", "2")
//          .set("spark.driver.memory", "512M")
          .set("spark.testing.reservedMemory", "57425008")
          .set("spark.executor.memory", "512M")

          .setJars(Seq(
            //            "/Users/jta/.ivy2/local/example/basic-project_2.10/0.1.0-SNAPSHOT/jars/basic-project_2.10.jar",
            //            "/Users/jta/.ivy2/cache/org.apache.spark/spark-core_2.10/jars/spark-core_2.10-1.6.3.jar",
            "/Users/jta/.ivy2/local/example/basic-project_2.10/0.1.0-SNAPSHOT/jars/basic-project_2.10.jar"
            //            "/Users/jta/.ivy2/cache/org.apache.commons/commons-lang3/jars/commons-lang3-3.5.jar"

          )
          )
    }
  }


  def pair(str: String)(fste: RDD[String]) = (str, fste)
}
