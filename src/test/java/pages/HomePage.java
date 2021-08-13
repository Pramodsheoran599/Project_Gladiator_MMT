package pages;

import frameworks.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

//----------------------------------------------------------------------------------------------------------------------

public class HomePage extends BasePage
{
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

//----------------------------------------------------------------------------------------------------------------------

    By login_button   = object_repository.getLocator("homepage.login_button");
    By my_profile     = object_repository.getLocator("homepage.my_profile");
    By hey_username   = object_repository.getLocator("homepage.hey_username");
    By flights_button = object_repository.getLocator("homepage.flights");
    By hotels_button  = object_repository.getLocator("homepage.hotels");

//----------------------------------------------------------------------------------------------------------------------

    public LoginPage goto_login_page()
    {
        driver.findElement(login_button).click();
        driver.findElement(login_button).click();
        return new LoginPage(driver);
    }

//----------------------------------------------------------------------------------------------------------------------

    public boolean is_user_logged_in()
    {
        try {
            return driver.findElement(hey_username).isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    public void logout()
    {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(hey_username)).perform();
        action.moveToElement(driver.findElement(my_profile)).click().perform();
        action.moveToElement(driver.findElement(new ProfilePage().logout_button)).click().perform();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void goto_flights_page()
    {
        driver.findElement(flights_button).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void goto_hotels_page()
    {
        driver.findElement(hotels_button).click();
    }
}

//----------------------------------------------------------------------------------------------------------------------