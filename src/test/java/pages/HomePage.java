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

    public LoginPage gotoLoginPage()
    {
        try
        {
            if (driver.findElement(By.cssSelector("div[class='autopop__wrap makeFlex column defaultCursor']")).isDisplayed())
                driver.findElement(object_repository.getLocator("homepage.loginPopup.login")).click();
        }
        catch (NoSuchElementException e)
        {
            driver.findElement(login_button).click();
        }

        return new LoginPage(driver);
    }

//----------------------------------------------------------------------------------------------------------------------

    public boolean isUserLoggedIn()
    {
        try
        {
            waitTillVisibilityOfElement(hey_username);
            return driver.findElement(hey_username).isDisplayed();
        }
        catch (Exception e) {
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

        try
        {
            if (driver.findElement(By.cssSelector("div[class='autopop__wrap makeFlex column defaultCursor']")).isDisplayed())
                driver.findElement(object_repository.getLocator("homepage.login_button")).click();

            driver.findElement(hotels_button).click();
        }
        catch (NoSuchElementException e)
        {
            driver.findElement(hotels_button).click();
        }
    }

}
//----------------------------------------------------------------------------------------------------------------------