package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Frameworks.BaseTest;
import Pages.CompleteYourBookingPage;

import org.testng.annotations.Test;

public class BookingTests extends BaseTest
{
    @Test
    public void tc_Book() throws InterruptedException
    {
    	driver.get("https://www.makemytrip.com");
		driver.findElement(By.className("userLoggedOut")).click();
		
		
		//checking for search button
        driver.findElement(By.cssSelector(".primaryBtn.font24.latoBold.widgetSearchBtn")).click();
      
        //checking for view details
      driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/button[1]")).click();
      
      //checking for book button
      driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/button[1]")).click();
      Thread.sleep(4000);
      
     
 	  
 	  
 	  
    }
}