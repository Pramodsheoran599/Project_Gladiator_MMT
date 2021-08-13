package frameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//----------------------------------------------------------------------------------------------------------------------

public class BasePage
{
    protected WebDriver driver;
    protected Object_Repository object_repository = new Object_Repository();

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

    protected void scrollPageVertically(int pixels)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }
}
//----------------------------------------------------------------------------------------------------------------------