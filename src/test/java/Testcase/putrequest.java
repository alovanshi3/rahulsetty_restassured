package Testcase;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.RestassuredUtilities;

public class putrequest {
	RestassuredUtilities util = new RestassuredUtilities();
	
	@BeforeMethod
	public void post() throws FileNotFoundException {
		util.postrequest();
	}
		
		@Test(priority =3)
		public void update() throws FileNotFoundException {
			util.putrequest();
		}
}
