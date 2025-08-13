package Stepdefinitions;

import java.io.FileNotFoundException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;

public class putsteps {
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();
	@Given("Call the post request")
	public void call_the_post_request() throws FileNotFoundException {
		util.postrequest();
	}

	@When("Enter the baseuri and put request")
	public void enter_the_baseuri_and_put_request() throws FileNotFoundException {
		util.putrequest();
	    
	}

	@Then("Validate  response")
	public void validate_response() throws FileNotFoundException {
		valutil.statuscodeValidation();
	   
	}
	
	@Then("log  results")
	public void log_results() {
		System.out.println("loggin results");
	    
	}

}
