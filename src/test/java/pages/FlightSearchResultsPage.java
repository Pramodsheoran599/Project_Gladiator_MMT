package pages;

import frameworks.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSearchResultsPage extends BasePage
{

    public FlightSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    By flights = By.className("fli-list");

    public int getCountOfFlights() {
        return driver.findElements(flights).size();
    }
}
