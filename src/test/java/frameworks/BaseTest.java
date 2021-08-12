package frameworks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


//----------------------------------------------------------------------------------------------------------------------

public class BaseTest
{
    public WebDriver driver;
    public String browserType = "chrome";

//----------------------------------------------------------------------------------------------------------------------

    @BeforeTest
    public void beforeTest()
    {
        driver = AllWebDrivers.setupDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

//----------------------------------------------------------------------------------------------------------------------

    @AfterMethod
    public void afterMethod() throws InterruptedException
    {
//        driver.close();
    }

//----------------------------------------------------------------------------------------------------------------------

    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }
}

//----------------------------------------------------------------------------------------------------------------------