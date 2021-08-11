package Frameworks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


//----------------------------------------------------------------------------------------------------------------------

public class BaseTest
{
    public WebDriver driver;
    public String browserType = "chrome";

//----------------------------------------------------------------------------------------------------------------------

    @BeforeTest
    public void beforeTest()
    {
        driver = new AllWebDrivers().setupDriver(browserType);
    }

//----------------------------------------------------------------------------------------------------------------------

    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }
}

//----------------------------------------------------------------------------------------------------------------------