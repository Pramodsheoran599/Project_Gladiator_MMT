package frameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


//----------------------------------------------------------------------------------------------------------------------

public class BaseTest
{
    protected WebDriver driver;
    public String browserType = "chrome";
    protected Object_Repository object_repository = new Object_Repository();
    public ExtentReports report;

//----------------------------------------------------------------------------------------------------------------------

    @BeforeTest
    public void beforeTest()
    {
        driver = AllWebDrivers.setupDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

//----------------------------------------------------------------------------------------------------------------------

    @AfterTest
    public void afterTest()
    {
        driver.quit();
        report.flush();
    }

//----------------------------------------------------------------------------------------------------------------------

    protected void waitTillVisibilityOf(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

//----------------------------------------------------------------------------------------------------------------------

    public boolean isElementEnabled(By locator)
    {
        try
        {
            return driver.findElement(locator).isEnabled();
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    public boolean isElementDisplayed(By locator)
    {
        try
        {
            return driver.findElement(locator).isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            System.out.println(locator + " : Not Found");
            return false;
        }
    }
}
//----------------------------------------------------------------------------------------------------------------------

