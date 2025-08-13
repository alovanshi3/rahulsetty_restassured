//package TestRunner;
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//	    features = {"src/test/resources/Features"},      // Path to feature files
//	    glue = {"Stepdefinitions"},
//	    		plugin = {
//	    		        "pretty",
//	    		        "html:target/cucumber-html-report",
//	    		        "json:target/cucumber.json",
//	    		        "rerun:target/rerun.txt",
//	    		        "TestRunner.CucumberExtentReportPlugin"
//	    		       	    		    },
//	    		
//	    		 monochrome = false
//	    
//	   
//	)
//
//public class TestRunner {
//
//}
package TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Features",  // Path to feature files
	    glue = "Stepdefinitions",                 // Path to step definitions
	    plugin = {"pretty", "html:target/cucumber-reports.html"}
	)
	public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {

	    

	    
	}

