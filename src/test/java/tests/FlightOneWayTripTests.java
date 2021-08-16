package tests;

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
		if (url.contains("reviewDetails")) {
			isReviewDetail = true;
			waitForSeconds(5);
			flightSearchResults
					.executeMouseClick(driver.findElement(By.xpath("//button[normalize-space()='Continue']")));
			Assert.assertTrue(
					driver.findElements(By.cssSelector("span[class='errorMsg fontSize14 appendLeft5']")).size() != 0);
		} else {
			Thread.sleep(1000);
			flightSearchResults.executeMouseClick(driver.findElement(By.id("review-continue")));
			flightSearchResults.executeMouseClick(driver.findElement(By.id("review-continue")));

			Assert.assertTrue(driver
					.findElements(
							By.xpath("//font[normalize-space()='NOTE: Please select Yes or No above to continue.']"))
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
	public void tc_flight_traveller01() throws Exception {
		if (isReviewDetail) {
			flightSearchResults.executeMouseClick(
					driver.findElement(By.cssSelector("span[class='darkText lightFont fontSize14 appendLeft10']")));

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			flightSearchResults.waitTillVisibilityOfElement(By.cssSelector("button[class='addTravellerBtn']"));
			flightSearchResults.executeMouseClick(driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/div[1]/div[3]/div[2]/div[3]/button[1]")));

			flightSearchResults.waitTillVisibilityOfElement(By.cssSelector("input[placeholder='First & Middle Name']"));

			driver.findElement(By.cssSelector("input[placeholder='First & Middle Name']")).sendKeys("Rutvik");
			driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Panchal");
			driver.findElement(By.cssSelector("label[tabindex='0']")).click();
			driver.findElement(By.cssSelector("input[placeholder='Mobile No']")).sendKeys("1234567890");
			driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@test.com");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			flightSearchResults
					.executeMouseClick(driver.findElement(By.xpath("//button[normalize-space()='Continue']")));
			flightSearchResults
					.executeMouseClick(driver.findElement(By.xpath("//button[normalize-space()='Continue']")));

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			flightSearchResults
					.executeMouseClick(driver.findElement(By.xpath("//button[normalize-space()='CONFIRM']")));

			flightSearchResults.switchToNewTab();

			flightSearchResults.executeMouseClick(
					driver.findElement(By.cssSelector("span[class='fontSize16 boldFont appendRight20 linkText ']")));

			for (WebElement e : driver
					.findElements(By.cssSelector("div[style='background-color: rgb(186, 218, 255);']"))) {
				flightSearchResults.executeMouseClick(e);
				break;
			}

			Thread.sleep(2000);

			flightSearchResults
					.executeMouseClick(driver.findElement(By.xpath("//button[normalize-space()='Continue']")));
			flightSearchResults
					.executeMouseClick(driver.findElement(By.xpath("//button[normalize-space()='CONTINUE ANYWAY']")));

			flightSearchResults.switchToNewTab();
			flightSearchResults
					.executeMouseClick(driver.findElement(By.xpath("//button[normalize-space()='Proceed to pay']")));

		} else {

		}
	}
}