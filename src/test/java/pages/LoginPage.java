package pages;

import frameworks.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//----------------------------------------------------------------------------------------------------------------------

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    By heading            = object_repository.getLocator("loginPage.heading");
    By email_mobile_field = object_repository.getLocator("loginPage.email_mobile_field");
    By password_field     = object_repository.getLocator("loginPage.password_field");
    By otp_field          = object_repository.getLocator("loginPage.otp_field");

    By continue_button    = object_repository.getLocator("loginPage.continue_button");
    By login_button       = object_repository.getLocator("loginPage.login_button");

    By login_via_otp      = object_repository.getLocator("loginPage.login_via_otp");
    By login_via_password = object_repository.getLocator("loginPage.login_via_password");

    By blank_id_error     = object_repository.getLocator("loginPage.blank_id_error");
    By invalidOtpError    = object_repository.getLocator("loginPage.invalidOTP");
    By error              = object_repository.getLocator("loginPage.error");

    By loginViaGoogleButton = object_repository.getLocator("loginPage.login_via_google_button");

//----------------------------------------------------------------------------------------------------------------------

    // Getter Methods
    public By getContinue_button () { return continue_button; }
    public By getLogin_button    () { return login_button; }
    public By getBlank_id_error  () { return blank_id_error; }
    public By getInvalidOtpError () { return invalidOtpError; }
    public By getError           () { return error; }
    public By getLoginViaGoogleButton () { return loginViaGoogleButton; }

//----------------------------------------------------------------------------------------------------------------------

    public boolean isDisplayed()
    {
        return driver.findElement(heading).isDisplayed();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void enterUsername(String username)
    {
        driver.findElement(email_mobile_field).sendKeys(username);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void clickContinue()
    {
        try
        {
            driver.findElement(continue_button).click();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    public void enterPassword(String password)
    {
        driver.findElement(password_field).sendKeys(password);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void enterOTP(String otp)
    {
        driver.findElement(otp_field).sendKeys(otp);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void clickLoginViaPassword()
    {
        driver.findElement(login_via_password).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void clickLoginViaGoogle()
    {
        driver.findElement(loginViaGoogleButton).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void login()
    {
        driver.findElement(login_button).click();
    }
}
//----------------------------------------------------------------------------------------------------------------------
