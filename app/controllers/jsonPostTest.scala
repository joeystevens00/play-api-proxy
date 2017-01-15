package controllers
import play.api.libs.functional.syntax._
import play.api.libs.json._
import java.util.NoSuchElementException
import play.api._
import play.api.mvc._
import scalaj.http.Http
import scala.util.matching.Regex

class jsonPostTest extends Application 
{
	 def jsonPostTest=  Action { request =>
	  	var contentType: String = request.headers.get("Content-Type").getOrElse("")
 		if (contentType.toUpperCase() contains "JSON") 
 		{	//HANDLING JSON REQUESTS
  			try 
 			{          
    			val json = request.body.asJson.get
    			val jsonString: String = Json.stringify(json)
    			Ok(jsonString)
    		}
    		catch
 			{ 
 				case ioe: NoSuchElementException => BadRequest("No such element")
 			  	case e: Exception => BadRequest("Something went wrong: " + e)
 			}
 		}
 		else
 		{
 				BadRequest("Incorrect usage. Please post JSON")
 		}
 	}
}
