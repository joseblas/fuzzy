package fuzzy.http

import spray.json.{JsArray, JsNumber, JsObject, JsString}

case class Result(source1: String, source2: String, score: Double)

case class Match(search: String, result: List[Result])

object JsonUtilities {


  def parse(t: (String, List[(String, String, Double)])): JsObject = {
    val result = t._2.toVector.map(r => JsObject(/*"source1" -> JsString(r._1),*/ "target" -> JsString(r._2), "score" -> JsNumber(r._3)))
    JsObject("source" -> JsString(t._1), "result " -> JsArray(result))

  }


}
