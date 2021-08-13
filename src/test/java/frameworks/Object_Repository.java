package frameworks;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Object_Repository
{
    Properties prop;

    // Constructor to load properties file
    public Object_Repository()
    {
        prop = new Properties();

        try
        {
            FileInputStream fis = new FileInputStream(Constants.OBJECT_REPO_PATH);
            prop.load(fis);
            fis.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    // Method to Get Regular Property
    public String getProperty(String key)
    {
        return prop.getProperty(key);
    }

//----------------------------------------------------------------------------------------------------------------------

    // Method to get a WebElement Locator
    public By getLocator(String WebElementName)
    {
        // Retrieve value from properties file using key
        String locatorTypeAndValue = prop.getProperty(WebElementName);

        // extract the locator type and value from the object
        String[] locatorTypeAndValueArray = locatorTypeAndValue.split(":", 2);
        String locatorType = locatorTypeAndValueArray[0];
        String locatorValue = locatorTypeAndValueArray[1];

        switch (locatorType.toUpperCase())
        {
            case "ID":              return By.id              (locatorValue);
            case "NAME":            return By.name            (locatorValue);
            case "TAGNAME":         return By.tagName         (locatorValue);
            case "LINKTEXT":        return By.linkText        (locatorValue);
            case "PARTIALLINKTEXT": return By.partialLinkText (locatorValue);
            case "XPATH":           return By.xpath           (locatorValue);
            case "CSS":             return By.cssSelector     (locatorValue);
            case "CLASSNAME":       return By.className       (locatorValue);
            default:                System.out.println("Invalid Locator Type in Object Repo.");
                                    return null;
        }
    }
}

//----------------------------------------------------------------------------------------------------------------------