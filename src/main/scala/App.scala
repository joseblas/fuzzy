package example

import fuzzy.{Ranking, RankingSpark, Simple}

import scala.io.Source

object App {
  def main(args: Array[String]) {


    val data = Source.fromFile("/Users/jta/coursera/fuzzy/src/main/resources/samples/companytestlist.csv").getLines().toList
    val fste = Source.fromFile("/Users/jta/coursera/fuzzy/src/main/resources/samples/ftse100companies.csv").getLines().toList

    val r = new RankingSpark(data, fste)
//
    val toList = r.list

    val l = toList.collect().toList

  println(l)
//    l.foreach{ e=>
//        println(s" ${e._1} -> ${e._2}")
//
//    }
    r.sc.stop()
    sys.exit()
//    toList
//    .foreach {
//      it => it._2.foreach( e =>  println(s" Company: ${it._1}  -> ${e._1} ${if (e._3) 1.0 else e._2}") )
//    }

  }
}
