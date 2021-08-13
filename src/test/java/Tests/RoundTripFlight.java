package Tests;

import java.util.Set;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Frameworks.BaseTest;

public class RoundTripFlight extends BaseTest {
	@Test
	public void tc_flight_roundtrip01() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		driver.findElement(By.className("userLoggedOut")).click();
		driver.findElement(By.cssSelector("li[data-cy='roundTrip']")).click();
		
		// driver.findElement(By.cssSelector("button[type='button']")).click();
		
		driver.findElement(By.linkText("SEARCH")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/span")).click();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Set<String> wnd = driver.getWindowHandles();
		Iterator<String> i = wnd.iterator();
		 String prntw = i.next();
		 String popwnd = i.next();
		 driver.switchTo().window(popwnd);
		 driver.close();
		 driver.switchTo().window(prntw);
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[3]/button")).click();
		/*
		 Set wnd = driver.getWindowHandles();
	      // window handles iterate
	      Iterator i = wnd.iterator();
	      String popwnd = (String) i.next();
	      String prntw = (String) i.next();
	      
	      // switching pop up tab
	      driver.switchTo().window(prntw);
	      driver.findElement(By.linkText("OKAY, GOT IT!")).click();
		*/
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[3]/button")).click();
		
		//driver.findElement(By.linkText("Book Now")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div[3]/div/div[2]/buttonn")).click();
	Thread.sleep(5000);
	}
}
