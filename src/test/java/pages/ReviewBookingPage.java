package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworks.BasePage;

public class ReviewBookingPage extends BasePage {

	public ReviewBookingPage(WebDriver driver) {
		super(driver);
	}

	By continueButton = object_repository.getLocator("reviewBooking.continueButton");
	By optInsuranceRadio = By.cssSelector("span[class='darkText lightFont fontSize14 appendLeft10']");
	By addTravellerButton = By.cssSelector("button[class='addTravellerBtn']");
	By firstNameInput = By.cssSelector("input[placeholder='First & Middle Name']");
	By lastNameInput = By.cssSelector("input[placeholder='Last Name']");
	By travellerMale = By.cssSelector("label[tabindex='0']");

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
		driver.findElement(By.cssSelector("input[placeholder='Mobile No']")).sendKeys(phoneNo);
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(email);
	}

	public void confirmBooking() {
		jsClick(driver.findElement(By.xpath("//button[normalize-space()='CONFIRM']")));
	}
}
