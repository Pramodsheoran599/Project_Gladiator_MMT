package Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Frameworks.BaseTest;

public class CompleteHotel extends BaseTest {
	@Test
	public void tc_hotel_book02() throws InterruptedException {

		driver.get("https://www.makemytrip.com");
		driver.findElement(By.className("userLoggedOut")).click();
		driver.findElement(By.linkText("Hotels")).click();
		driver.findElement(By.id("city")).click();
		
		WebElement from = driver.findElement(By.cssSelector("input[placeholder='Enter city/ Hotel/ Area/ Building']"));
		from.click();
		from.sendKeys("Mumbai");
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		
		
		
		Thread.sleep(5000);
		
		
		driver.findElement(By.id("hsw_search_button")).click();

		driver.findElement(By.id("Listing_hotel_1")).click();

	

		Set<String> Win = driver.getWindowHandles();
		List<String> allWin = new ArrayList<>(Win);

		driver.switchTo().window(allWin.get(1));

		driver.findElement(By.id("detpg_headerright_book_now")).click();

		Thread.sleep(5000);

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
