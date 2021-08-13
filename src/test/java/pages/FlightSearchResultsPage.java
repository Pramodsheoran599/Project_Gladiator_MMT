package pages;

import frameworks.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSearchResultsPage extends BasePage {

	public FlightSearchResultsPage(WebDriver driver) {
		super(driver);
	}

	By flights = By.cssSelector(".listingCard");
	By multiCityFlights = By.cssSelector(".listingCard ");

	public int getCountOfFlights() {
		return driver.findElements(flights).size();
	}

	public int getCountOfFlights(boolean multiCity) {
//		waitTillVisibilityOfElement(flights);
		if (multiCity)
			return driver.findElements(multiCityFlights).size();
		else
			return driver.findElements(flights).size();
	}
}