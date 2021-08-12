package frameworks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


//----------------------------------------------------------------------------------------------------------------------

public class BaseTest
{
    public WebDriver driver;
    public String browserType = "chrome";
    
	private Properties props;


//----------------------------------------------------------------------------------------------------------------------

    @BeforeTest
    public void beforeTest()
    {
        driver = AllWebDrivers.setupDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

//----------------------------------------------------------------------------------------------------------------------

    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }
    
    
    protected Properties getProperties() {
		if (this.props == null) {
			this.props = new Properties();
			try {
				this.props.load(new FileInputStream(Constants.SETTINGS_PATH));
			} catch (FileNotFoundException e) {
				System.out.println("File not found at path - " + Constants.SETTINGS_PATH);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error occured while reading file, cannot read file - " + Constants.SETTINGS_PATH);
				e.printStackTrace();
			}
		}
		return this.props;
	}
}

//----------------------------------------------------------------------------------------------------------------------