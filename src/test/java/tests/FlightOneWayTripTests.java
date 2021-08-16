package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.BaseTest;
import pages.FlightSearchResultsPage;
import pages.Search;

public class FlightOneWayTripTests extends BaseTest {

	Search search;
	FlightSearchResultsPage flightSearchResults;
	boolean isReviewDetail = false;

	@Test(description = "To Test if flights are available")
	public void tc_flight_search02() throws InterruptedException {
		driver.get(object_repository.getProperty("homepage_url"));

		search = new Search(driver);
		search.selectFromCity();
		search.searchFromCity("Mumbai");
		search.searchToCity("Mumbai");

		Assert.assertEquals(true, search.isSameCityErrorVisible());
	}

	@Test(dependsOnMethods = "tc_flight_search02", description = "To test flights with same arrival and departure  destination")
	public void tc_flight_search01() {
		String fromCity = "Mumbai";
		String toCity = "Delhi";
		String date = "20-08-2021";

		search.searchOneWayTripFlights(fromCity, toCity, date);
		flightSearchResults = new FlightSearchResultsPage(driver);
		Assert.assertTrue(flightSearchResults.getCountOfFlights() > 0);
	}

	@Test(dependsOnMethods = "tc_flight_search01", description = "To test Book now feature")
	public void tc_flight_select01() {
		flightSearchResults.bookFirstFlight();
		flightSearchResults.switchToNewTab();

		Assert.assertTrue(driver.getCurrentUrl().contains("review"));
	}

	@Test(dependsOnMethods = "tc_flight_select01", description = "To test review page")
	public void tc_flight_review02() throws Exception {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		if (url.contains("reviewDetails")) {
			isReviewDetail = true;

			List<WebElement> but = driver.findElements(
					By.cssSelector("button[class='lato-black button buttonPrimary extraPadBtn fontSize16 ']"));
			for (WebElement b : but) {
				if (b.getText().equalsIgnoreCase("continue")) {
					b.click();
				}
			}
			Assert.assertTrue(
					driver.findElements(By.cssSelector("span[class='errorMsg fontSize14 appendLeft5']")).size() != 0);
		} else {
			flightSearchResults.executeMouseClick(driver.findElement(By.cssSelector("button[id='review-continue']")));

			Assert.assertTrue(driver.findElements(By.cssSelector("p[class='validation-error digit-validation-error']"))
					.size() != 0);
		}
	}

	@Test(dependsOnMethods = "tc_flight_review02", description = "To test review page")
	public void tc_flight_review01() {
		if (isReviewDetail) {
			flightSearchResults.executeMouseClick(
					driver.findElement(By.cssSelector("span[class='darkText lightFont fontSize14 appendLeft10']")));
			Assert.assertTrue(driver.getCurrentUrl().contains("review"));
		} else {

		}
	}

	@Test(dependsOnMethods = "tc_flight_review01", description = "To test continue button without filling mandatory details")
	public void tc_flight_traveller01() {
		if (isReviewDetail) {
			flightSearchResults.executeMouseClick(
					driver.findElement(By.cssSelector("span[class='darkText lightFont fontSize14 appendLeft10']")));

			flightSearchResults.waitTillVisibilityOfElement(By.cssSelector("button[class='addTravellerBtn']"));
			flightSearchResults
					.executeMouseClick(driver.findElement(By.cssSelector("button[class='addTravellerBtn']")));
			
			driver.findElement(By.cssSelector("input[placeholder='First & Middle Name']")).sendKeys("Rutvik");
			driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Panchal");
			driver.findElement(By.cssSelector("label[tabindex='0']")).click();
			driver.findElement(By.cssSelector("input[placeholder='Mobile No']")).sendKeys("1234567890");
			driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@test.com");
			
			flightSearchResults.executeMouseClick(
					driver.findElement(By.cssSelector(".lato-black.button.buttonPrimary.extraPadBtn.fontSize16 ")));
			flightSearchResults.executeMouseClick(
					driver.findElement(By.cssSelector(".lato-black.button.buttonPrimary.extraPadBtn.fontSize16 ")));

			flightSearchResults.switchToNewTab();
			
		} else {

		}
	}

//	@Test(dependsOnMethods = "tc_flight_search01")
//	public void tc_flight_search05() {
//		Actions act = new Actions(driver);
//
//		driver.findElement(By.cssSelector("span[class='darkText lightFont fontSize14 appendLeft10']")).click();
//
//		flightSearchResults.executeMouseClick(driver.findElement(By.cssSelector("button[class='addTravellerBtn']")));
//
//		driver.findElement(By.cssSelector("input[placeholder='First & Middle Name']")).sendKeys("Rutvik");
//		driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Panchal");
//		driver.findElement(By.cssSelector("label[tabindex='0']")).click();
//		driver.findElement(By.cssSelector("input[placeholder='Mobile No']")).sendKeys("1234567890");
//		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@test.com");
//
//		flightSearchResults.executeMouseClick(
//				driver.findElement(By.cssSelector(".lato-black.button.buttonPrimary.extraPadBtn.fontSize16 ")));
//		flightSearchResults.executeMouseClick(
//				driver.findElement(By.cssSelector(".lato-black.button.buttonPrimary.extraPadBtn.fontSize16 ")));
//
//		flightSearchResults.switchToNewTab();
//
//		act.moveToElement(driver.findElement(By.cssSelector(".button.buttonPrimary.buttonBig.fontSize14"))).click()
//				.perform();
//
//		act.moveToElement(driver.findElement(By.cssSelector(".lato-black.button.buttonPrimary.buttonBig.fontSize12")))
//				.click().perform();
//		act.moveToElement(
//				driver.findElement(By.cssSelector(".lato-black.button.buttonPrimary.extraPadBtn.fontSize16 "))).click()
//				.perform();
//		act.moveToElement(
//				driver.findElement(By.cssSelector(".lato-black.button.buttonPrimary.extraPadBtn.fontSize16 "))).click()
//				.perform();
//
//	}
}