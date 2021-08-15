package frameworks;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//----------------------------------------------------------------------------------------------------------------------

public class BasePage
{
	protected WebDriver driver;
	protected Object_Repository object_repository = new Object_Repository();
	protected Actions action;

//----------------------------------------------------------------------------------------------------------------------

	protected BasePage(WebDriver driver)
	{
		this.driver = driver;
	}

//----------------------------------------------------------------------------------------------------------------------

	protected void waitTillVisibilityOfElement(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

//----------------------------------------------------------------------------------------------------------------------

	protected WebElement findElement(By locator)
	{
		try
		{
			return driver.findElement(locator);
		}
		catch (NoSuchElementException e)
		{
			System.out.println(locator + " : Element Not Found.");
			return null;
		}
	}
	
//----------------------------------------------------------------------------------------------------------------------

	protected void scrollPageVertically(int pixels)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

//----------------------------------------------------------------------------------------------------------------------

	public void switchToNewTab()
	{
		String currentTab = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String w : windows)
		{
			if (!w.equals(currentTab))
			{
				driver.close();
				driver.switchTo().window(w);
			}
		}
	}

//----------------------------------------------------------------------------------------------------------------------

	public void executeMouseClick(WebElement webElement)
	{
		if (action == null)
		{
			action = new Actions(driver);
		}
		action.moveToElement(webElement).click().perform();
	}
}
//----------------------------------------------------------------------------------------------------------------------
