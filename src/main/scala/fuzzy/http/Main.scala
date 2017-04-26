package fuzzy.http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import fuzzy.RankingSpark
import spray.json.DefaultJsonProtocol._


object Main extends App with SprayJsonSupport {
  val config = ConfigFactory.load()

  implicit val system = ActorSystem.create()
  implicit val executionContext = system.dispatcher
  implicit val matchingRequestFormat = jsonFormat2(MatchingRequest.apply)
  implicit val materializer = ActorMaterializer()

//  val data = Source.fromFile("/Users/jta/coursera/fuzzy/src/main/resources/samples/companytestlist.csv").getLines().toList
//  val fste = Source.fromFile("/Users/jta/coursera/fuzzy/src/main/resources/samples/ftse100companies.csv").getLines().toList
//  println(s"${data.mkString(",")}")
//  println(s"${fste.mkString(",")}")

  lazy val route =
  //    path("/matching") {
    (post & entity(as[MatchingRequest])) { req =>
      val r = new RankingSpark(req.data.split(",").toList, req.kb.split(",").toList)
      val toList = r.list.collect().toList.map(JsonUtilities.parse)
      complete(toList)

    }
  //    }
  //  ~
  //      get {
  //        pathSingleSlash {
  //
  //          val data = Source.fromFile("/Users/jta/coursera/fuzzy/src/main/resources/samples/companytestlist.csv").getLines().toList
  //          val fste = Source.fromFile("/Users/jta/coursera/fuzzy/src/main/resources/samples/ftse100companies.csv").getLines().toList
  //
  //          val r = new RankingSpark(data, fste)
  //          val toList = r.list.collect().toList.map(JsonUtilities.parse)
  //
  //          complete(toList)
  //        } ~
  //          path(Segment) { string =>
  //            complete(string)
  //          }
  //      }


  Http().bindAndHandle(route, interface = "localhost", port = 8888)
}
