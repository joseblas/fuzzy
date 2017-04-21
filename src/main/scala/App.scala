package example

import fuzzy.{Ranking, Simple}

object App {
  def main(args: Array[String]) {
    print("Hello basic-project!")
    val r = Simple
    println( r.join.collect() )
  }
}
