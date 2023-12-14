package stepdefinitions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty", "html: target/cucumber-reports.html"}, 
		monochrome = true,
		glue = { "stepdefinitions" },
		features = { "src/test/resources/Features" }
)

public class TestNGParallelRun extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}