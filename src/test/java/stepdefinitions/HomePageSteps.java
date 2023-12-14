package stepdefinitions;

import java.util.List;

import org.junit.Assert;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class HomePageSteps {

	private HomePage homePage = new HomePage(DriverFactory.tlDriver.get());

	@Given("user is on home page")
	public void user_is_on_home_page() {

		DriverFactory.tlDriver.get().get("https://purple.ai/");

	}

	@Then("user scrolls down to observe list of sectors covered")
	public void user_scrolls_down_to_observe_list_of_sectors_covered(DataTable dataTable) {

		List<String> expectedSectorsList = dataTable.asList();
		System.out.println("Expected sectors list: " + expectedSectorsList);

		List<String> actualSectorsList = homePage.getSectorsList();
		System.out.println("Actual sectors list: " + actualSectorsList);

		Assert.assertTrue(expectedSectorsList.containsAll(actualSectorsList));

	}

	@Then("sectors covered count should be {int}")
	public void sectors_covered_count_should_be(Integer expectedCount) {
		Assert.assertTrue(expectedCount == homePage.getSectorsListCount());

	}

}
