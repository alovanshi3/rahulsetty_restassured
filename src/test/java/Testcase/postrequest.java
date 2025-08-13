package Testcase;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import utilities.RestassuredUtilities;

public class postrequest {
		RestassuredUtilities util = new RestassuredUtilities();
		
		@Test(priority =1)
		public void post() throws FileNotFoundException {
			util.postrequest();
		}
}
