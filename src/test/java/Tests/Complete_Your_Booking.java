package Tests;

import org.testng.annotations.Test;

import Frameworks.BaseTest;
import Pages.CompleteYourBookingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Complete_Your_Booking extends BaseTest {
	
  @Test
  public void tc_Traveller_Details() {
	  
	  driver.get("https://www.makemytrip.com/flight/reviewDetails/?itineraryId=4d8372116bb4451fe7c36fbc8efcd80392688100&crId=d32dc9b6-4ff8-4d92-9085-026d0846b98c&cur=INR&xflt=eyJjIjoiRSIsInAiOiJBLTFfQy0wX0ktMCIsInQiOiIiLCJzIjoiREVMLUJMUi0yMDIxMDgxMyJ9&rKey=RKEY:6070562f-d69e-4a63-808b-c48091c29b27:3_0&ccde=IN");
	  
	 WebElement E =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[3]/div[1]/label[1]/span[2]"));
	 E.click();
	 E.isSelected();
	 
	 driver.findElement(By.cssSelector("button[class='addTravellerBtn']")).click();
	  
	  
	 CompleteYourBookingPage obj=new CompleteYourBookingPage(driver);
	 
	  obj.enterFirstName("Evan");
	  
	  obj.enterLastName("Jace");
	  
	  obj.selectFemale();
	  
	  
	  
	  
	  driver.findElement(By.cssSelector("input[placeholder='Mobile No']")).sendKeys("1234567893");
	  driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmai.com");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      String pixels;
	js.executeScript("window.scrollBy(0," + 300 + ")");
	
	//CONTINUE
	  //driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/form[1]/div[4]/button[1]")).click();
	  
	driver.findElement(By.xpath("//*[@id=\"mainSection_0\"]/div[6]/button")).click();
	//driver.findElement(By.linkText("Continue")).click();

	//driver.findElement(By.cssSelector("button[type='button']")).click();
	  
	  
  }
}