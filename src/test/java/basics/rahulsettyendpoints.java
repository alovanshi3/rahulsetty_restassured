package basics;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloads.requestbody;
import utilities.Resource;

import static org.hamcrest.Matchers.*;

public class rahulsettyendpoints {
	requestbody req = new requestbody();
	
	PrintStream log;
	String placeId;

    @BeforeClass
    public void setup() throws FileNotFoundException {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Create log file for request and response
        log = new PrintStream("src/test/resources/logger/log.txt");

        // Attach filters for logging requests & responses
        RestAssured.filters(
            new RequestLoggingFilter(log),
            new ResponseLoggingFilter(log)
        );
    }

	
	@Test	
	public void postrequest(){
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Response response = given().contentType("application/json").body(req.postbody()).queryParam("key", "qaclick123").log().all().post(Resource.postResource.getResource())
		//.then().statusCode(200).log().all();
		.then()
		.assertThat()
		.statusCode(200)
		.body("status",equalTo("OK"))
		.body("scope",equalTo("APP"))
		.body("place_id",not(emptyString()))
		.log().all()
		.extract().response();
		
		String responseString = response.asString();
		JsonPath js = new JsonPath(responseString);
		placeId = js.getString("place_id");
		System.out.println("Extracted place id is "+placeId);
		
		
	}
	@Test
	public void getrequest() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		given().contentType("application/json").queryParam("key", "qaclick123").queryParam("place_id",placeId).log().all().when().get(Resource.getResource.getResource())
		//.then().statusCode(200).log().all();
		.then()
		.assertThat()
		.statusCode(200)
		.body("name",equalTo("Frontline house"))
		.body("address",equalTo("Barwai Teh Khategaon"))
		.body("language",equalTo("French-IN"))
		.body("location.lan",notNullValue())
		.body("location.lng",notNullValue())
		.log().all();
		
	}
	
	@Test
	public void putrequest() {
		String newAddress = "Barwai Teh Khategaon";
		//String placeid = "37ef2c1e51a9360c841bc3fe368a02cf";
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().contentType("application/json").body(req.putbody(placeId,newAddress)).queryParam("key", "qaclick123").queryParam("place_id",placeId).log().all().when().put(Resource.putResource.getResource())
		.then().statusCode(200).log().all();
	}
	
	@Test
	public void deleterequest() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
	//	String placeid = "0adf784feade2a97f1143a0a8849a8f7";
		given().contentType("application/json").body(req.deletebody(placeId)).queryParam("key", "qaclick123").log().all().when().delete(Resource.deleteResource.getResource())
		.then().statusCode(200).log().all();
			
	}
	@Test
	public void getrequestafterdelete() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		given().contentType("application/json").queryParam("place_id",placeId).log().all().when().get(Resource.getResource.getResource())
		.then().statusCode(200).log().all();
		
	}
}
