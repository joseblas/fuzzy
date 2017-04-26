package fuzzy.http

import spray.json.{JsArray, JsNumber, JsObject, JsString}

case class MatchingRequest(kb: String, data: String)

object JsonUtilities {

  def parse(t: (String, List[(String, String, Double)])): JsObject = {
    val result = t._2.toVector.map(r => JsObject("target" -> JsString(r._2), "score" -> JsNumber(r._3)))
    JsObject("source" -> JsString(t._1), "result " -> JsArray(result))

  }

}
