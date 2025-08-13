package Stepdefinitions;

import java.io.FileNotFoundException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;

public class getsteps {
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();

	@Given("Post request should be called")
	public void post_request_should_be_called() throws FileNotFoundException  {
		util.postrequest();
	}

	@When("Enter the baseuri and get request")
	public void enter_the_baseuri_and_get_request() throws FileNotFoundException {
		util.getrequest();
	}

	@Then("Validate the response")
	public void validate_the_response() {
		
		System.out.println("logging results");
	   
	}
}
