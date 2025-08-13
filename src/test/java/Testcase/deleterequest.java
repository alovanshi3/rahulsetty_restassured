package Testcase;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.RestassuredUtilities;

public class deleterequest {
	RestassuredUtilities util = new RestassuredUtilities();
	
	@BeforeMethod
	public void post() throws FileNotFoundException {
		util.postrequest();
	}
		
		@Test(priority =4)
		public void delete() throws FileNotFoundException {
			util.deleteRequest();
		}
}
