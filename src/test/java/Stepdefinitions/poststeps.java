package Stepdefinitions;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;


public class poststeps {
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();

	@Given("Enter the baseuri and postrequest")
	public void enter_the_baseuri_and_postrequest() throws FileNotFoundException {
		util.postrequest();
	}

	@When("validate the response")
	public void validate_the_response() throws FileNotFoundException {
		valutil.statuscodeValidation();
	    
	}
	@Then("log the results")
	public void log_the_results() {
		
		System.out.println("logging results");
	   
	}

}
