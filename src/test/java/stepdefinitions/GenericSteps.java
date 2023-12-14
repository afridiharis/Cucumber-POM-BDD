package stepdefinitions;

import org.junit.Assert;

import com.pages.GenericToPages;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GenericSteps {

	private GenericToPages genericPage = new GenericToPages(DriverFactory.getDriver());
	private String title;

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		title = genericPage.getPageTitle();
		System.out.println("The title of the login page is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		Assert.assertTrue(title.contains(expectedTitle));

	}

	@And("accept any cookies")
	public void accept_cookies() {

		genericPage.cookieAcceptBox();

	}
}
