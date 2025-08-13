package Testcase;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.RestassuredUtilities;

public class getrequest {
	RestassuredUtilities util = new RestassuredUtilities();
	
	@BeforeMethod
	public void post() throws FileNotFoundException {
		util.postrequest();
	}
		@Test(priority =2)
		public void get() throws FileNotFoundException {
			util.getrequest();
		}
}
