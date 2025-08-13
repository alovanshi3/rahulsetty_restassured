package baseclass;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest {
	
	static RequestSpecification reqSpec;
    static ResponseSpecification resSpec;

    public static RequestSpecification setup() throws FileNotFoundException {
        if (reqSpec == null) {
            PrintStream log = new PrintStream("src/test/resources/logger/restassured_log.txt");

            String baseURI = Configmanager.getProperty("baseURI"); 

            reqSpec = new RequestSpecBuilder()
                    .setBaseUri(baseURI)
                    .setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
        }
        return reqSpec;
    }

    public static ResponseSpecification responseSpec() {
        if (resSpec == null) {
            resSpec = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .expectContentType(ContentType.JSON)
                    .build();
        }
        return resSpec;
    }
}
