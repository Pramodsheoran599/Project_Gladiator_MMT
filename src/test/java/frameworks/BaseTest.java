package frameworks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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
    public ExtentReports extentReports;
    public ExtentTest test;

//----------------------------------------------------------------------------------------------------------------------

    @BeforeTest
    public void beforeTest()
    {
        driver = AllWebDrivers.setupDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        extentReports = new ExtentReports();
        extentReports.attachReporter(new ExtentHtmlReporter("test.html"));
    }

//----------------------------------------------------------------------------------------------------------------------

    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }

        else if(result.getStatus() == ITestResult.SUCCESS)
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));

        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    
    @AfterTest
    public void afterTest()
    {
        driver.quit();
        extentReports.flush();
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

