package fuzzy

import org.scalatest.{FunSuite, BeforeAndAfterAll}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RankingSuite extends FunSuite with BeforeAndAfterAll {

  val msg = " -- did you fill in all the values?"

  def init(): Boolean =
    try {
      Ranking
      true
    } catch {
      case ex: Throwable =>
        println(ex.getMessage)
        ex.printStackTrace()
        false
    }

  override def afterAll(): Unit = {

    assert(init(), msg)
//    import fuzzy.Ranking._
//    sc.stop()
  }



  test("Joins data") {
    assert(init(), msg)
    import fuzzy.Ranking._

//    val joins = join(testCompanies, fste)
//    println(initialList.collect().toList)
//    println(testCompanies.map( c => (c)).collect() )
//    println(testCompanies.collect())
//    println(fste.size)
//          .foreach { company =>
//          company._2.foreach(l => println(s" '${company._1.name}' '${l._1.name}' ->  ${if(l._3) 1.0 else l._2} "))
//        }

  }
}
