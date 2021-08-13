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
		
		
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div/div[3]/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div[3]/div/div[2]/button")).click();
		
	Thread.sleep(10000);
	}
}
