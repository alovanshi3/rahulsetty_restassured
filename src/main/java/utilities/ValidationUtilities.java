package utilities;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



import baseclass.BaseTest;

public class ValidationUtilities {
    public void statuscodeValidation() throws FileNotFoundException {
    	   given()
           .spec(BaseTest.setup())
       .when()
            .then()
       .statusCode(200)
           .spec(BaseTest.responseSpec());
    }

    public void headerValidation() throws FileNotFoundException {
        given()
            .spec(BaseTest.setup()) 
        .when()
            .get(Resource.getResource.getResource())
        .then()
            .statusCode(200)
            .header("content-type", equalTo("application/json; charset=UTF-8"));
    }

    public void ResponseBodyValidation() throws FileNotFoundException {
        given()
            .spec(BaseTest.setup()) 
        .when()
            .get(Resource.getResource.getResource())
        .then()
            .statusCode(200)
            .header("Content-Type", equalTo("application/json; charset=utf-8"))
            .body("title", equalTo("Testing"))
            .body("body", equalTo("Rest assured"));
    }
}
