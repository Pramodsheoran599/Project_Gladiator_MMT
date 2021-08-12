package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.BaseTest;
import pages.Search;

public class FlightReturnTripTests extends BaseTest {
	
	Search search;

	@Test
	public void tc_return_flight_search_01() {
		driver.get(getProperties().getProperty("url"));
		search = new Search(driver);
		search.isOneWaySelected();
		search.selectFromCity();
		search.searchFromCity("Mumbai");
		search.searchToCity("Bengaluru");
		search.selectDate("20-08-2021");
		driver.findElement(By.cssSelector("div[data-cy='returnArea']")).click();
		search.selectDate("20-08-2021");

		Assert.assertEquals(true, search.isRoundTripSelected());
	}

	@Test(dependsOnMethods="tc_return_flight_search_01")
	public void tc_return_flight_search_02() {
		driver.findElement(By.cssSelector(".returnCross.landingSprite")).click();
		
		Assert.assertEquals(true, search.isOneWaySelected());
	}
	
	@Test(dependsOnMethods="tc_return_flight_search_02")
	public void tc_return_flight_search_03() {
		search.selectRoundTrip();
		search.searchFlights();
		
		List<WebElement> panels = driver.findElements(By.className("paneView"));
		Assert.assertTrue(driver.getTitle().equals("MakeMyTrip"));
		Assert.assertEquals(panels.size(), 2);
	}
}
