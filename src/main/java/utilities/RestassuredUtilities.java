package utilities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import baseclass.BaseTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloads.requestbody;

public class RestassuredUtilities {
	requestbody request = new requestbody();
	
	PrintStream log;
	String placeId;

//    @BeforeClass
//    public void setup() throws FileNotFoundException {
//        RestAssured.baseURI = "https://rahulshettyacademy.com";
//
//        // Create log file for request and response
//        log = new PrintStream("src/test/resources/logger/log.txt");
//
//        // Attach filters for logging requests & responses
//        RestAssured.filters(
//            new RequestLoggingFilter(log),
//            new ResponseLoggingFilter(log)
//        );
//    }

	
		
	public void postrequest() throws FileNotFoundException{
		 log = new PrintStream(new File("src/test/resources/logger/postlog.txt"));	
		
	//	RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Response response = given(BaseTest.setup())
				.filter(RequestLoggingFilter.logRequestTo(log))
	            .filter(ResponseLoggingFilter.logResponseTo(log))
	            .queryParam("key", "qaclick123")
				.contentType("application/json")
				.body(request.postbody())
				.when()	
				//.log().all()
				.post(Resource.postResource.getResource())
		//.then().statusCode(200).log().all();
		.then()
		//.assertThat()
		//.statusCode(200)
//		.body("status",equalTo("OK"))
//		.body("scope",equalTo("APP"))
//		.body("place_id",not(emptyString()))
//		.log().all()
		.extract().response();
		
		String responseString = response.asString();
		JsonPath js = new JsonPath(responseString);
		placeId = js.getString("place_id");
		System.out.println("Extracted place id is "+placeId);
		
		
	}
	
	public void getrequest() throws FileNotFoundException {
        log = new PrintStream(new File("src/test/resources/logger/getlog.txt"));

        given(BaseTest.setup())
                .filter(RequestLoggingFilter.logRequestTo(log))
                .filter(ResponseLoggingFilter.logResponseTo(log))
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .get(Resource.getResource.getResource())
                .then()
                .statusCode(200);
               
    }
	    public void putrequest() throws FileNotFoundException {
	        log = new PrintStream(new File("src/test/resources/logger/putlog.txt"));

	        String newAddress = "70 Winter Walk, USA";

	        given(BaseTest.setup())
	                .filter(RequestLoggingFilter.logRequestTo(log))
	                .filter(ResponseLoggingFilter.logResponseTo(log))
	                .queryParam("key", "qaclick123")
	                .contentType("application/json")
	                .body(request.putbody(placeId, newAddress))
	                .when()
	                .put(Resource.putResource.getResource())
	                .then()
	                .statusCode(200);
	               
	    }

//	    public void deleteRequest() throws FileNotFoundException {
//	        log = new PrintStream(new File("src/test/resources/logger/deletelog.txt"));
//
//	        given(BaseTest.setup())
//	                .filter(RequestLoggingFilter.logRequestTo(log))
//	                .filter(ResponseLoggingFilter.logResponseTo(log))
//	                .queryParam("key", "qaclick123")
//	                .contentType("application/json")
//	                .body(request.deletebody(placeId))
//	                .when()
//	                .post(Resource.deleteResource.getResource())
//	                .then()
//	                .statusCode(200)
//	                .body("status", equalTo("OK"));
//	    }
	    public void deleteRequest() throws FileNotFoundException {
	        log = new PrintStream(new File("src/test/resources/logger/deletelog.txt"));

	        Response response = given(BaseTest.setup())
	                .filter(RequestLoggingFilter.logRequestTo(log))
	                .filter(ResponseLoggingFilter.logResponseTo(log))
	                .queryParam("key", "qaclick123")
	                .contentType("application/json")
	                .body(request.deletebody(placeId))
	                .when()
	                .post(Resource.deleteResource.getResource());

	        // Always check status code
	        response.then().statusCode(200); // or 204 depending on API

	        // Only check JSON if body is not empty
	        String bodyString = response.asString().trim();
	        if (!bodyString.isEmpty()) {
	            response.then().body("status", equalTo("OK"));
	        } else {
	            System.out.println("No JSON body returned for DELETE request.");
	        }
	    }

}
