package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.BaseTest;
import pages.FlightSearchResultsPage;
import pages.Search;

public class FlightOneWayTripTests extends BaseTest {

	Search search;
	FlightSearchResultsPage flightSearchResults;

	@Test
	public void tc_flight_search02() {
		driver.get(getProperties().getProperty("url"));
		search = new Search(driver);

		search.selectFromCity();
		search.searchFromCity("Mumbai");
		search.searchToCity("Mumbai");

		Assert.assertEquals(true, !driver.findElements(By.cssSelector("span[data-cy='sameCityError']")).isEmpty());
	}

	@Test(dependsOnMethods = "tc_flight_search02")
	public void tc_flight_search01() {

		search.searchOneWayTripFlights("Mumbai", "Delhi", "15-08-2021");
		flightSearchResults = new FlightSearchResultsPage(driver);

		Assert.assertTrue(flightSearchResults.getCountOfFlights() > 0);
	}
}
