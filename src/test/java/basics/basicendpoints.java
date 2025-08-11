package basics;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class basicendpoints {
		@Test
		public void postrequest(){
			RestAssured.baseURI="https://rahulshettyacademy.com";
			
			given().contentType("application/json").body("{\r\n"
					+ "  \"location\": {\r\n"
					+ "    \"lat\": -38.383494,\r\n"
					+ "    \"lng\": 33.427362\r\n"
					+ "  },\r\n"
					+ "  \"accuracy\": 50,\r\n"
					+ "  \"name\": \"Frontline house\",\r\n"
					+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
					+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
					+ "  \"types\": [\r\n"
					+ "    \"shoe park\",\r\n"
					+ "    \"shop\"\r\n"
					+ "  ],\r\n"
					+ "  \"website\": \"http://google.com\",\r\n"
					+ "  \"language\": \"French-IN\"\r\n"
					+ "}\r\n"
					+ "").queryParam("key", "qaclick123").log().all().post("maps/api/place/add/json")
			.then().statusCode(200).log().all();
		}
		
		@Test
		public void getrequest() {
			RestAssured.baseURI="https://rahulshettyacademy.com";
			
			given().contentType("application/json").queryParam("place_id","0999513de743acfe455c737d52e3d39f").log().all().when().get("maps/api/place/get/json")
			.then().statusCode(200).log().all();
			
		}
		@Test
		public void putrequest() {
			RestAssured.baseURI="https://rahulshettyacademy.com";
			given().contentType("application/json").body("{\r\n"
					+ "\"place_id\":\"0999513de743acfe455c737d52e3d39f\",\r\n"
					+ "\"address\":\"70 Chennai, India\",\r\n"
					+ "\"key\":\"qaclick123\"\r\n"
					+ "}\r\n"
					+ "").queryParam("key", "qaclick123").log().all().when().put("maps/api/place/update/json")
			.then().statusCode(200).log().all();
			
			
		}
		@Test
		public void deleterequest() {
			
			RestAssured.baseURI="https://rahulshettyacademy.com";
			
			given().contentType("application/json").body("{\r\n"
					+ "    \"place_id\":\"0999513de743acfe455c737d52e3d39f\"\r\n"
					+ "} \r\n"
					+ "").queryParam("key", "qaclick123").log().all().when().delete("maps/api/place/delete/json")
			.then().statusCode(200).log().all();
			
		}

	
}
