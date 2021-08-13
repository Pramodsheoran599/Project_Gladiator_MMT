package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteYourBookingPage {
	WebDriver driver;
	public CompleteYourBookingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By e_firstNameMiddleName = By.cssSelector("input[placeholder='First & Middle Name']");
	By e_lastName = By.cssSelector("input[placeholder='Last Name']");
	
	By e_Male = By.cssSelector("label[tabindex='0']");
	By e_Female = By.cssSelector("label[tabindex='1']");
	By country_code = By.cssSelector(".dropdown_value-container.dropdown_value-container--has-value.css-1hwfws3");
	By Mobile_no = By.cssSelector("input[placeholder='Mobile No']");
	By e_mail = By.cssSelector("input[placeholder='Email']");
	
	public void enterFirstName(String fname)
	{
		driver.findElement(e_firstNameMiddleName).sendKeys(fname);	
	}
	public void enterLastName(String lname)
	{
		driver.findElement(e_lastName).sendKeys(lname);	
	}
	
	
	public void selectFemale()
	{
		driver.findElement(e_Female).click();	
	}
	
	public void fillTravellerDetails(String fname,String lname)
	{
		enterFirstName(fname);
		enterLastName(lname);
		selectFemale();
		
	}
	 
	
	
	
}