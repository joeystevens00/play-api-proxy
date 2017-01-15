package controllers
import play.api.libs.functional.syntax._
import play.api.libs.json._
import java.util.NoSuchElementException
import play.api._
import play.api.mvc._
import scalaj.http.Http
import scala.util.matching.Regex

class getHeaders extends Application 
{
	def getHeaders=  Action { request =>  
		var passedHeaders: String = "{"
		for (e <- request.headers.keys) 
		 	{
				var key: String = e
 				var value: String = request.headers.get(e).getOrElse("")
 		 		passedHeaders += ("\"" + key + "\": \""  +  value + "\",")
			}
			passedHeaders += "}"
			passedHeaders = passedHeaders.replaceAll(",}", "}")

		Ok(passedHeaders)

	}

}