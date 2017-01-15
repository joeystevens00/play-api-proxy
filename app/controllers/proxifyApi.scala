package controllers
import play.api.libs.functional.syntax._
import play.api.libs.json._
import java.util.NoSuchElementException
import play.api._
import play.api.mvc._
import scalaj.http.Http

class Application extends Controller 
{
	def isBlank( input : Option[String]) : Boolean = input match 
  	{
    	case None    => true
    	case Some(s) => s.trim.isEmpty
  	}
 	def proxifyApi=  Action { request =>  
 		var requestUrl: String = request.headers.get("api-forward-url").getOrElse("")
 		var contentType: String = request.headers.get("Content-Type").getOrElse("")
 		var requestUrlParam: String = request.getQueryString("api-forward-url").getOrElse("")
 		if (isBlank(Option(requestUrl)) && isBlank(Option(requestUrlParam))) 
 		{ // If the user didn't give us api-forward-url
 			var error: String ="Incorrect usage. Pass your request URL as api-forward-url in the headers or as a url paramater"
 			System.out.println(error)
 			BadRequest(error)
 		}
 		else 
 		{
 			if (isBlank(Option(requestUrl))) {
 				//If the User passed api-forward-url as a URL paramater
 				requestUrl=requestUrlParam
 			}

 			if (contentType.toUpperCase() contains "JSON") 
 			{	//HANDLING JSON REQUESTS
 				try 
 				{          
    				val json = request.body.asJson.get
    				val jsonString: String = Json.stringify(json)
    				//val parsedperson = json.as[Person]
  		 			System.out.println("Received JSON Request To: " + requestUrl)
 		 			var result = Http(requestUrl).postData(jsonString)
 		 				.header("Content-Type", contentType).asString
 		 			Ok(result.body)
 		 		}
 		 		catch 
 		 		{ 
 		 				case ioe: NoSuchElementException => BadRequest("No such element")
 		 			  	case e: Exception => BadRequest("Something went wrong: " + e)
 		 		}
 		 	} 
 		 	else 
 		 	{
				//HANDLING NON JSON REQUESTS
				System.out.println("Received NON-JSON Request To: " + requestUrl)
				var result = Http(requestUrl).asString
 				Ok(result.body)

 			}
		}		
	}
}