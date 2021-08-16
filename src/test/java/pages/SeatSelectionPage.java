package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.BasePage;

public class SeatSelectionPage extends BasePage {

	public SeatSelectionPage(WebDriver driver) {
		super(driver);
	}

	By continuePopUp = By.cssSelector("span[class='fontSize16 boldFont appendRight20 linkText ']");

	public void clickContinuePopUp() {
		jsClick(driver.findElement(continuePopUp));
	}

	public void selectSeat() {
		for (WebElement e : driver.findElements(By.cssSelector("div[style='background-color: rgb(186, 218, 255);']"))) {
			executeMouseClick(e);
			break;
		}
	}
	
	public void clickContinue() {
		jsClick(driver.findElement(By.xpath("//button[normalize-space()='Continue']")));
		jsClick(driver.findElement(By.xpath("//button[normalize-space()='CONTINUE ANYWAY']")));
	}
	
	public void proceedToPay() {
		jsClick(driver.findElement(By.xpath("//button[normalize-space()='Proceed to pay']")));

	}
}
