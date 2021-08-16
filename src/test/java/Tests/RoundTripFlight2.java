package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Frameworks.BaseTest;

public class RoundTripFlight2 extends BaseTest{
  @Test
  public void tc_flight_roundtrip01() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		driver.get("https://www.makemytrip.com");
		if(driver.findElement(By.cssSelector("div[data-cy='googleLogin']")).isDisplayed())
		driver.findElement(By.className("userLoggedOut")).click();
		driver.findElement(By.cssSelector("li[data-cy='roundTrip']")).click();

		driver.findElement(By.linkText("SEARCH")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div/div[3]/button")).click();
		
		Thread.sleep(10000);
		/*
		//driver.findElement(By.xpath("/html/body/div[10]/div[2]/div/p[3]/span")).click();
		//driver.findElement(By.cssSelector("span[class='linkText']")).click();
		//driver.findElement(By.xpath("/html/body/div[10]/div[2]/div/p[3]/span")).click();
		//driver.findElement(By.cssSelector("span[class='outer']")).click();
		WebElement element = driver.findElement(By.xpath(
				"//*[@id=\"flightCard-4\"]/div/div[2]/div[2]/span"));

	//	driver.findElement(By.xpath("//*[@id=\"return\"]")).click();
	//	driver.findElement(By.xpath("//*[@id=\"search-widget\"]/div/div[6]/div[1]/div/div/div/div/div[2]/div[1]/div[3]/div[3]/div[6]"));

		
		Actions actions = new Actions(driver);

		actions.moveToElement(element).click().perform();
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].scrollIntoView()", element); 
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div/div[7]/label/div/div[2]/div[2]/span")).click();
		//driver.findElement(By.xpath(
		//		"/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div/div[2]/label/div/div[2]/div[2]/span/span")).click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div[3]/div/div[2]/button"))
				.click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[3]/button"))
		.click();
		
		
		*/
  }
}
