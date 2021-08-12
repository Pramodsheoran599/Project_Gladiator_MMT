package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Frameworks.BaseTest;

public class FlightSearch extends BaseTest {
	@Test
	public void tc_flight_search01() throws InterruptedException {
		driver.get("https://www.makemytrip.com");
		driver.findElement(By.className("userLoggedOut")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div/div/nav/ul/li[1]/a/span[1]")).click();
		
		driver.findElement(By.id("fromCity")).click();
		WebElement from = driver.findElement(
				By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
		from.sendKeys("Kolkata");
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		

	}
}
