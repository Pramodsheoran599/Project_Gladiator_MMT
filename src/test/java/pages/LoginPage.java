package pages;

import frameworks.BasePage;
import frameworks.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//----------------------------------------------------------------------------------------------------------------------

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    By email_mobile_field = object_repository.getLocator("loginPage.email_mobile_field");
    By password_field     = object_repository.getLocator("loginPage.password_field");
    By otp_field          = object_repository.getLocator("loginPage.otp_field");

    By continue_button    = object_repository.getLocator("loginPage.continue_button");
    By login_button       = object_repository.getLocator("loginPage.login_button");

    By login_via_otp      = object_repository.getLocator("loginPage.login_via_otp");
    By login_via_password = object_repository.getLocator("loginPage.login_via_password");

    By blank_id_error     = object_repository.getLocator("loginPage.blank_id_error");
    By error              = object_repository.getLocator("loginPage.error");

    By login_via_google_button = object_repository.getLocator("loginPage.login_via_google_button");

//----------------------------------------------------------------------------------------------------------------------

    public void enter_username(String username)
    {
        driver.findElement(email_mobile_field).sendKeys(username);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void click_continue()
    {
        driver.findElement(continue_button).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void enter_password(String password)
    {
        driver.findElement(password_field).sendKeys(password);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void enter_otp(String otp)
    {
        driver.findElement(otp_field).sendKeys(otp);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void click_login_via_password()
    {
        driver.findElement(login_via_password).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void click_login_via_google()
    {
        driver.findElement(login_via_google_button).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void login()
    {
        driver.findElement(login_button).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public boolean check_if_element_is_enabled(String elementName)
    {
        if (elementName.equalsIgnoreCase("continue_button"))
            return driver.findElement(continue_button).isEnabled();

        else if (elementName.equalsIgnoreCase("login_button"))
            return driver.findElement(login_button).isEnabled();

        else
            System.out.println("Invalid Element Name.");
            return false;
    }

//----------------------------------------------------------------------------------------------------------------------

    public boolean check_if_element_is_displayed(String elementName)
    {
        if (elementName.equalsIgnoreCase("error"))
            return driver.findElement(error).isDisplayed();

        else
            System.out.println("Invalid Element Name.");
            return false;
    }
}

//----------------------------------------------------------------------------------------------------------------------
