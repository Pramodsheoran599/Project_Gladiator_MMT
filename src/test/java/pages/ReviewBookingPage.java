package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworks.BasePage;

public class ReviewBookingPage extends BasePage {

	public ReviewBookingPage(WebDriver driver) {
		super(driver);
	}

	By continueButton = object_repository.getLocator("reviewBooking.continueButton");
	By optInsuranceRadio = object_repository.getLocator("reviewBooking.optInsuranceRadio");
	By addTravellerButton = object_repository.getLocator("reviewBooking.addTravellerButton");
	By firstNameInput = object_repository.getLocator("reviewBooking.firstNameInput");
	By lastNameInput = object_repository.getLocator("reviewBooking.lastNameInput");
	By travellerMale = object_repository.getLocator("reviewBooking.travellerMale");
	By mobileNoInput = object_repository.getLocator("reviewBooking.mobileNoInput");
	By emailInput = object_repository.getLocator("reviewBooking.emailInput");
	By confirmButton = object_repository.getLocator("reviewBooking.confirmButton");

	public void clickOnContinue() {
		waitForElementTobeClickable(driver.findElement(continueButton));
		executeMouseClick(driver.findElement(continueButton));
		jsClick(driver.findElement(continueButton));
	}

	public void optForInsurance() {
		jsClick(driver.findElement(optInsuranceRadio));
	}

	public void clickAddTravellerButton() {
		waitTillVisibilityOfElement(addTravellerButton);
		jsClick(driver.findElement(addTravellerButton));
	}

	public void addTravellerDetails(String firstName, String lastName) {
		waitTillVisibilityOfElement(firstNameInput);
		driver.findElement(firstNameInput).sendKeys(firstName);
		driver.findElement(lastNameInput).sendKeys(lastName);
		driver.findElement(travellerMale).click();
	}

	public void addTravellerContactDetails(String phoneNo, String email) {
		driver.findElement(mobileNoInput).sendKeys(phoneNo);
		driver.findElement(emailInput).sendKeys(email);
	}

	public void confirmBooking() {
		jsClick(driver.findElement(confirmButton));
	}
}
