package Tests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Frameworks.BaseTest;

public class RoundTripFlight extends BaseTest {
	@Test
	public void tc_flight_roundtrip01() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		driver.findElement(By.className("userLoggedOut")).click();
		driver.findElement(By.cssSelector("li[data-cy='roundTrip']")).click();

		driver.findElement(By.linkText("SEARCH")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div/div[3]/button")).click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div[3]/div/div[2]/button"))
				.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[3]/button"))
				.click();

		

		Set<String> wnd = driver.getWindowHandles();
		Iterator i = wnd.iterator();
		String page1 = (String) i.next();
		String page2 = (String) i.next();
		
		driver.switchTo().window(page2);
		 WebDriverWait w = new WebDriverWait(driver,3);
	      // presenceOfElementLocated condition
	      w.until(ExpectedConditions.presenceOfElementLocated (By.id("review-continue")));
		//driver.findElement(By.cssSelector("input[value='no']")).click();
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.cssSelector("input[value='no']"))).click().perform();
		
		/*
		try {
			driver.findElement(By.xpath("//*[@id=\"digit-insurance-section\"]/div[3]/label[1]/input")).click();
	
		}
		
		
		catch(Exception exception)
		{
			driver.findElement(By.cssSelector("input[value='no']")).click();
		}
		*/
		//*[@id="digit-insurance-section"]/div[3]/label[1]/input
		//Thread.sleep(10000);
		//driver.findElement(By.xpath("//*[@id=\"insurance-section\"]/div/div[3]/label[2]/input")).click();
		/*
		 * WebElement e = driver.findElement(By.id("review-continue"));

		boolean actualValue = e.isEnabled();

		if (actualValue) {
		       System.out.println("Button is enabled");
		     
		}
		else
		       System.out.println("Button is disabled");
		       */
		Thread.sleep(9000);
		//Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.id("review-continue"))).click().perform();
	//driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[5]/button")).click();
	//driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[5]/button")).click();	
		System.out.println("Last");
		driver.findElement(By.xpath("//*[@id=\"MANUAL_f10a47b6-82ab-44f5-8e9a-157dc1cfb7aa\"]/div[2]/div/div[1]/div[1]/div/input")).sendKeys("AQbhinash");
		
	}
}
