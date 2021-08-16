package pages;

import frameworks.BasePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSearchResultsPage extends BasePage {

	public FlightSearchResultsPage(WebDriver driver) {
		super(driver);
	}

	By flights = By.cssSelector(".listingCard");
	By multiCityFlights = By.cssSelector("button[id^='bookbutton']");

	By viewPricesButton = By.xpath("//button[@id='bookbutton-RKEY:c71da437-423a-47c5-ad07-54d1222a7e49:16_0']//span[@class='appendRight8'][normalize-space()='View Prices']");
	By bookNowButton = By.cssSelector("button.fli_primary_btn");

	public int getCountOfFlights() {
		return driver.findElements(flights).size();
	}

	public int getCountOfFlights(boolean multiCity) {
		if (multiCity)
			return driver.findElements(multiCityFlights).size();
		else
			return driver.findElements(flights).size();
	}
	
	public void bookFirstFlight() {
		try {
			waitTillVisibilityOfElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']"));
			driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		}

		List<WebElement> ele = driver.findElements(By.cssSelector("[id^=bookbutton]"));
		System.out.println(ele.size());
		ele.get(0).click();
		
		scrollPageVertically(150);
		
		List<WebElement> bookNowButtons = driver.findElements(By.cssSelector("[id^=bookbutton]"));
		System.out.println(bookNowButtons.size());
		for (WebElement elem: bookNowButtons) {
			System.out.println(elem.getText());
			if (elem.getText().equalsIgnoreCase("book now")) {
				elem.click();
				System.out.println("Book Now clicked");
				break;
			}
		}
	}
	
	public void bookFirstMultiCItyFlight() {
		try {
			waitTillVisibilityOfElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']"));
			driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		} catch (NoSuchElementException e) {
			
		} catch(TimeoutException e) {
			
		}
		
		List<WebElement> ele = driver.findElements(By.cssSelector("[class*='ViewFareBtn']"));
		System.out.println(ele.size());
		ele.get(0).click();
		
		scrollPageVertically(150);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> bookNowButtons = driver.findElements(By.cssSelector("button[class*='btn']"));
		System.out.println(bookNowButtons.size());
		for (WebElement elem: bookNowButtons) {
			System.out.println(elem.getText());
			if (elem.getText().equalsIgnoreCase("book now")) {
				elem.click();
				System.out.println("Book Now clicked");
				break;
			}
		}
	}
	
}