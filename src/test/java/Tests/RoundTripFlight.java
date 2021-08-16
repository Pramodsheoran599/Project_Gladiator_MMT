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
		Actions act = new Actions(driver);
		driver.get("https://www.makemytrip.com");
		if (driver.findElement(By.cssSelector("div[data-cy='googleLogin']")).isDisplayed())
			driver.findElement(By.className("userLoggedOut")).click();
		driver.findElement(By.cssSelector("li[data-cy='roundTrip']")).click();

		driver.findElement(By.linkText("SEARCH")).click();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div/div[3]/button")).click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/div[1]/div[3]/div/div[2]/button"))
				.click();

		Thread.sleep(8000);
		driver.findElement(
				By.xpath("	/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/button")).click();

		Set<String> wnd = driver.getWindowHandles();
		Iterator i = wnd.iterator();
		String page1 = (String) i.next();
		String page2 = (String) i.next();

		driver.switchTo().window(page2);

		WebDriverWait w = new WebDriverWait(driver, 3);
		Thread.sleep(3000);

		try {
			driver.findElement(By.xpath("//*[@id=\"INSURANCE\"]/div/div[3]/div[2]/label")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("button[class='addTravellerBtn']")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("input[placeholder='First & Middle Name']")).sendKeys("Abhinash");
			driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Malakar");
			driver.findElement(
					By.xpath("//*[@id=\"wrapper_ADULT\"]/div[2]/div[2]/div/div[2]/div/div/div[3]/div/div/label[1]"))
					.click();

			driver.findElement(By.cssSelector("input[placeholder='Mobile No']")).sendKeys("12345678");
			driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmail.com");

			act.moveToElement(driver.findElement(By.xpath("//*[@id=\"mainSection_0\"]/div[6]/button"))).click()
					.perform();
			driver.findElement(By.xpath("//*[@id=\"mainSection_0\"]/div[6]/button")).click();
			driver.findElement(By.cssSelector("button[class='button buttonPrimary buttonBig fontSize14']")).click();

			Thread.sleep(5000);
			if (driver.findElement(By.cssSelector("span[class='fontSize16 linkText']")).isDisplayed())
				driver.findElement(By.cssSelector("span[class='fontSize16 linkText']")).click(); // seat autoselect
																									// popup
			Thread.sleep(3000);

			driver.findElement(By.cssSelector("span[class='linkText ']")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("button[class='lato-black button buttonPrimary extraPadBtn fontSize16']"))
					.click();
		} catch (Exception exception) {

			try {
				driver.findElement(By.xpath("//*[@id=\"digit-insurance-section\"]/div[3]/label[1]/input")).click();
				Thread.sleep(5000);
			}

			catch (Exception exception1) {
				driver.findElement(By.cssSelector("input[value='no']")).click();
				Thread.sleep(5000);
			}

			act.moveToElement(driver.findElement(By.id("review-continue"))).click().perform();

			driver.findElement(By.cssSelector("input[placeholder='First & Middle Name']")).sendKeys("Abhinash");
			driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Malakar");
			driver.findElement(By.cssSelector("label[tabindex='0']")).click();

			driver.findElement(By.cssSelector("input[placeholder='Mobile No']")).sendKeys("12345678");
			driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmail.com");
			act.moveToElement(driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/form/div[9]/div/div/button")))
					.click().perform();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("a[class='fli_primary_btn btn marR10']")).click();

			Thread.sleep(5000);
			driver.findElement(By.cssSelector("span[class='pull-right font14 linkText marT13 cursor_pointer']"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("a[id='ancillary-secondary']")).click();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("a[class='btn fli_secondry_btn text-uppercase']")).click();
		}
		Thread.sleep(15000);
	}
}
