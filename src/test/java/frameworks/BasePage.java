package frameworks;

import frameworks.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    protected WebDriver driver;
    private   Properties props;
    protected Object_Repository object_repository = new Object_Repository();

    protected BasePage(WebDriver driver) {
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

//----------------------------------------------------------------------------------------------------------------------

    protected Properties getProperties() {
        if (this.props == null)
        {
            this.props = new Properties();
            try
            {
                this.props.load(new FileInputStream(Constants.OBJECT_REPO_PATH));
            }
            catch (FileNotFoundException e)
            {
                System.out.println("File not found at path - " + Constants.OBJECT_REPO_PATH);
                e.printStackTrace();
            }
            catch (IOException e)
            {
                System.out.println("Error occurred while reading file, cannot read file - " + Constants.OBJECT_REPO_PATH);
                e.printStackTrace();
            }
        }
        return this.props;
    }
}
//----------------------------------------------------------------------------------------------------------------------