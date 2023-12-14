package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//		tags = "@test", 
		features = { "src/test/resources/Features/" }, 
		glue = { "stepdefinitions"}, 
		plugin = { "pretty", "html: target/cucumber-reports.html" }
)

public class JUnitTestRunner {

}
