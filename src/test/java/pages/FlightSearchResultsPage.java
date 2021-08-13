package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSearchResultsPage extends BasePage {

	public FlightSearchResultsPage(WebDriver driver) {
		super(driver);
	}

	By flights = By.cssSelector(".listingCard");

	public int getCountOfFlights() {
//		waitTillVisibilityOfElement(flights);
		return driver.findElements(flights).size();
	}
}
