package frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Arrays;


public class AllWebDrivers
{
    public static WebDriver setupDriver(String type)
    {
        // Defining System Property for the Drivers
        System.setProperty ("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe"  );
        System.setProperty ("webdriver.gecko.driver" , "src/test/resources/drivers/geckodriver.exe"   );
        System.setProperty ("webdriver.ie.driver"    , "src/test/resources/drivers/IEDriverServer.exe");

        WebDriver driver = null;

        // Initiating the Driver
        if (type.contentEquals("chrome"))
            driver = new ChromeDriver();

        else if (type.contentEquals("firefox"))
            driver = new FirefoxDriver();

        else if (type.contentEquals("internet_explorer"))
            driver = new InternetExplorerDriver();

        else
        {
            System.out.println("Invalid Driver Type.");
            System.exit(-1);
        }

        return driver;
    }
}
