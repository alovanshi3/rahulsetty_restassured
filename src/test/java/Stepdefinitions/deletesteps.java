package Stepdefinitions;

import java.io.FileNotFoundException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;

public class deletesteps {
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();
	
	@Given("Call  post request")
	public void call_post_request() throws FileNotFoundException {
		util.postrequest();
	}

	@When("Enter the baseuri and delete request")
	public void enter_the_baseuri_and_delete_request() throws FileNotFoundException {
		util.deleteRequest();
	    
	}
	@Then("log  the result")
	public void log_the_result() {
		
		System.out.println("logging results");
	    
	}

}
