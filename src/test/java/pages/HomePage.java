package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	By login_button = By.className("userLoggedOut");
	By flights_button = By.cssSelector("a[href='https://www.makemytrip.com/flights/']");
	By hotels_button = By.cssSelector("a[href='https://www.makemytrip.com/hotels/']");

	public void goto_login_page() throws InterruptedException {
		driver.findElement(login_button).click();
		driver.findElement(login_button).click();
		Thread.sleep(5000);
	}

	public void goto_flights_page() {
		driver.findElement(flights_button).click();
	}

	public void goto_hotels_page() {
		driver.findElement(hotels_button).click();
	}
}