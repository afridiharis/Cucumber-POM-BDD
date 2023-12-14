package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.PartnersPortalPage;
import com.qa.factory.DriverFactory;
import com.qa.util.SeleniumWaits;

import io.cucumber.java.en.*;

public class PartnersPortalSteps {

	private WebDriver driver = DriverFactory.getDriver();
	private PartnersPortalPage portalPage = new PartnersPortalPage(driver);

	@Given("user is on partners portal page")
	public void user_is_on_partners_portal_page() {

		driver.get("https://purple.ai/partners/partner-portal/");
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {

		// This is just an interaction to stop the infinite load for email login field
		// which is a bug on the web page
		WebElement headingText = SeleniumWaits.waitForElement(driver, By.cssSelector("div.container.text-white"), 10,
				SeleniumWaits.WaitCondition.PRESENCE);
		headingText.click();
		portalPage.enterUsername(username);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {

		portalPage.clickOnLogin();
	}

	@Then("user should get an error message {string}")
	public void incorrect_login_error_message(String expectedErrorMessage) {
		System.out.println("This is expected text: " + expectedErrorMessage);
		System.out.println("This is actual text: " + portalPage.portalLoginErrorMessage());
		Assert.assertEquals("Expected text is not the same as actual text", expectedErrorMessage,
				portalPage.portalLoginErrorMessage());
	}
}
