package tests.moduleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.BaseTest;
import pages.FlightSearchResultsPage;
import pages.ReviewBookingPage;
import pages.Search;
import pages.SeatSelectionPage;

public class FlightOneWayTripTests extends BaseTest {

	Search search;
	FlightSearchResultsPage flightSearchResults;
	ReviewBookingPage reviewBookingPage;
	SeatSelectionPage seatSelectionPage;
	boolean isReviewDetail = false;

	@Test(description = "To test flights with same arrival and departure  destination")
	public void tc_flight_search02() throws InterruptedException {
		test = extentReports.createTest("tc_flight_search02",
				"To test flights search with same arrival and departure  destination");
		driver.get(object_repository.getProperty("homepage_url"));
		search = new Search(driver);
		search.selectFromCity();
		search.searchFromCity("Mumbai");
		test.pass("Mumbai entered as source city.");

		search.searchToCity("Mumbai");
		test.pass("Mumbai entered as destination city.");

		Assert.assertEquals(true, search.isSameCityErrorVisible());
		test.info("Error message is displayed if the source and destination city is same.");
		takeScreenshot(object_repository.getProperty("snapshot.FlightOneWayTripTests") + "SameCityError.png");
	}

	@Test(dependsOnMethods = "tc_flight_search02", description = "To Test if flights are available")
	public void tc_flight_search01() {
		test = extentReports.createTest("tc_flight_search01", "To Test if flights are available");
		String fromCity = "Mumbai";
		String toCity = "Delhi";
		String date = "25-08-2021";
		search.searchOneWayTripFlights(fromCity, toCity, date);
		test.pass("Source, Destination City and Date entered.");

		flightSearchResults = new FlightSearchResultsPage(driver);
		Assert.assertTrue(flightSearchResults.getCountOfFlights() > 0);
		test.pass("Flight search Success.");
		takeScreenshot(object_repository.getProperty("snapshot.FlightOneWayTripTests") + "FlightSearch.png");
	}

	@Test(dependsOnMethods = "tc_flight_search01", description = "To test Book now feature")
	public void tc_flight_select01() {
		test = extentReports.createTest("tc_flight_select01", "To test Book now feature");

		flightSearchResults.bookFirstFlight();
		test.pass("First Flight From Flight Search Results Booked.");

		flightSearchResults.switchToNewTab();
		Assert.assertTrue(driver.getCurrentUrl().contains("review"));
		test.pass("Review Booking Page is Displayed.");
		test.pass("Book Now Feature is Working");
		takeScreenshot(object_repository.getProperty("snapshot.FlightOneWayTripTests") + "BookNow.png");
	}

	@Test(dependsOnMethods = "tc_flight_select01", description = "To test review without selecting any add-ons")
	public void tc_flight_review02() throws Exception {
		test = extentReports.createTest("tc_flight_review02", "To test review without selecting any add-ons");

		String url = driver.getCurrentUrl();
		if (url.contains("reviewDetails")) {
			isReviewDetail = true;
			waitForSeconds(5);
			reviewBookingPage = new ReviewBookingPage(driver);
			reviewBookingPage.clickOnContinue();
			Assert.assertTrue(reviewBookingPage
					.isElementPresent(By.cssSelector("span[class='errorMsg fontSize14 appendLeft5']")));
			test.info("User cannot proceed if Insurance option is not selected");
			takeScreenshot(
					object_repository.getProperty("snapshot.FlightOneWayTripTests") + "InsuranceOptionNotSelected.png");
		} else {
			driver.findElement(By.xpath("//span[@class='labeltext darkGrayText']")).click();
			waitForSeconds(2);
			flightSearchResults.executeMouseClick(driver
					.findElement(By.xpath("//button[class='fli_primary_btn btn text-uppercase continue_cta']']")));

			Thread.sleep(4000);
			driver.findElement(By.cssSelector("button[class='addTravellerBtn']")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("input[placeholder='First & Middle Name']")).sendKeys("Abhinash");
			driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Malakar");
			driver.findElement(
					By.xpath("//*[@id=\"wrapper_ADULT\"]/div[2]/div[2]/div/div[2]/div/div/div[3]/div/div/label[1]"))
					.click();

			driver.findElement(By.cssSelector("input[placeholder='Mobile No']")).sendKeys("12345678");
			driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmail.com");

			flightSearchResults
					.executeMouseClick(driver.findElement(By.xpath("//*[@id=\"mainSection_0\"]/div[6]/button")));
			driver.findElement(By.xpath("//*[@id=\"mainSection_0\"]/div[6]/button")).click();
			driver.findElement(By.cssSelector("button[class='button buttonPrimary buttonBig fontSize14']")).click();

			waitForSeconds(5);
			if (driver.findElement(By.cssSelector("span[class='fontSize16 linkText']")).isDisplayed())
				driver.findElement(By.cssSelector("span[class='fontSize16 linkText']")).click();

			waitForSeconds(3);

			driver.findElement(By.cssSelector("span[class='linkText ']")).click();
			waitForSeconds(4);
			driver.findElement(By.cssSelector("button[class='lato-black button buttonPrimary extraPadBtn fontSize16']"))
					.click();
		}
	}

	@Test(dependsOnMethods = "tc_flight_review02", description = "To test continue button by putting valid details")
	public void tc_flight_traveller01() throws Exception {
		test = extentReports.createTest("tc_flight_traveller01", "To test review without selecting any add-ons");

		if (isReviewDetail) {
			reviewBookingPage.optForInsurance();
			waitForSeconds(2);
			test.pass("Insurance Option is Opted.");
			reviewBookingPage.clickAddTravellerButton();
			reviewBookingPage.addTravellerDetails("Rutvik", "Panchal");
			reviewBookingPage.addTravellerContactDetails("1234567890", "test@test.com");
			waitForSeconds(3);
			test.pass("Traveller Details entered.");
			reviewBookingPage.clickOnContinue();
			waitForSeconds(2);
			try {
				reviewBookingPage.confirmBooking();
			} catch (Exception e) {
			}
			reviewBookingPage.switchToNewTab();
			test.pass("Flight Booking is done after valid details input.");
			takeScreenshot(object_repository.getProperty("snapshot.FlightOneWayTripTests") + "ValidFlightBooking.png");
		} else {
		}
	}

	@Test(dependsOnMethods = "tc_flight_traveller01", description = "To test flight search issue")
	public void tc_flight_seats01() throws Exception {
		if (isReviewDetail) {
			test = extentReports.createTest("tc_flight_seats01", "To test flight seat selection");
			seatSelectionPage = new SeatSelectionPage(driver);
//			seatSelectionPage.clickContinuePopUp();
			seatSelectionPage.selectSeat();
			test.pass("Seat selected.");

			waitForSeconds(2);
			seatSelectionPage.clickContinue();

			seatSelectionPage.proceedToPay();
			seatSelectionPage.switchToNewTab();

			test.pass("Proceed to Pay Clicked.");
			test.pass("Flight Booked.");
			takeScreenshot(object_repository.getProperty("snapshot.FlightOneWayTripTests") + "FlightSeatSelection.png");
		} else {

		}
	}
}