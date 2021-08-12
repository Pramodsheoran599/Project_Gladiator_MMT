package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Frameworks.BaseTest;

public class HotelSelect extends BaseTest{
  @Test
  public void tc_hotel_book02() throws InterruptedException {
	  
	  driver.get("https://www.makemytrip.com/hotels/hotel-listing/?checkin=08132021&city=CTBOM&checkout=08172021&roomStayQualifier=3e1e5e&locusId=CTBOM&country=IN&locusType=city&searchText=Mumbai&visitorId=e4cedc02-dbe5-4c02-b215-b0f0e3a88a4a&regionNearByExp=3");
	  driver.findElement(By.id("Listing_hotel_1")).click();
	  
	//  Thread.sleep(5000);
	  
	  Set<String> Win=driver.getWindowHandles();
	  List<String> allWin=new ArrayList<>(Win);
	  
	  driver.switchTo().window(allWin.get(1));
	  
	  driver.findElement(By.id("detpg_headerright_book_now")).click();
	
	  //Thread.sleep(5000);
	  
	  WebElement E = driver.findElement(By.id("title"));
		Select title = new Select(E);
		title.selectByVisibleText("Mr");
		
		driver.findElement(By.id("fName")).sendKeys("Pramod");
		driver.findElement(By.id("lName")).sendKeys("Sheoran");
		driver.findElement(By.id("email")).sendKeys("pramodsheoran599@gmail.com");
		driver.findElement(By.id("mNo")).sendKeys("7021521142");
		driver.findElement(By.linkText("PAY NOW")).click();
		
		Thread.sleep(5000);
		
		
		
		
	  
	  
	  
  }
}
