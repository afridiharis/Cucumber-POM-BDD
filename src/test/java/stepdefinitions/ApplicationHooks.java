package stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import stepdefinitions.GenericSteps;

public class ApplicationHooks {

	private WebDriver driver;
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();

	}

	@Before(order = 1)
	public void launchBrowser() {
		String driverName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(driverName);
	}

	// Accept cookies before every scenario is run
	@Before(order = 2)
	public void acceptCookies() {
		driver.get("https://purple.ai/");
		GenericSteps genericSteps = new GenericSteps();
		genericSteps.accept_cookies();
	}

	// This will be executed at the end
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", screenShotName);
		}
	}
}
