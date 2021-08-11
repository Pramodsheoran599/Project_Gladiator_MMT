package Frameworks;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AllWebDrivers
{
    public WebDriver setupDriver(String type)
    {
        System.setProperty ("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        System.setProperty ("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");

        WebDriver driver = null;

        if (type.contentEquals("chrome"))
            driver = new ChromeDriver();

        else if (type.contentEquals("firefox"))
            driver = new FirefoxDriver();

        else
        {
            System.out.println("Invalid Driver Type.");
            System.exit(-1);
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
