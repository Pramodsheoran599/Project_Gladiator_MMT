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

    By heading          = object_repository.getLocator ("loginPage.heading");
    By emailMobileField = object_repository.getLocator ("loginPage.emailMobileField");
    By passwordField    = object_repository.getLocator ("loginPage.passwordField");
    By otpField         = object_repository.getLocator ("loginPage.otpField");

    By continueButton   = object_repository.getLocator ("loginPage.continueButton");
    By loginButton      = object_repository.getLocator ("loginPage.loginButton");

    By loginViaPassword = object_repository.getLocator ("loginPage.loginViaPassword");

    By invalidIdError   = object_repository.getLocator("loginPage.invalidIdError");
    By invalidOtpError  = object_repository.getLocator("loginPage.invalidOTP");
    By error            = object_repository.getLocator("loginPage.error");

    By loginViaGoogleButton = object_repository.getLocator("loginPage.loginViaGoogleButton");

//----------------------------------------------------------------------------------------------------------------------

    // Getter Methods
    public By getContinue_button      () { return continueButton; }
    public By getLogin_button         () { return loginButton; }
    public By getLoginViaPassword     () { return loginViaPassword; }
    public By getInvalidIdError       () { return invalidIdError; }
    public By getInvalidOtpError      () { return invalidOtpError; }
    public By getError                () { return error; }

//----------------------------------------------------------------------------------------------------------------------

    public boolean isDisplayed()
    {
        return driver.findElement(heading).isDisplayed();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void enterUsername(String username)
    {
        driver.findElement(emailMobileField).sendKeys(username);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void clickContinue()
    {
        try
        {
            driver.findElement(continueButton).click();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    public void enterPassword(String password)
    {
        waitTillVisibilityOfElement(passwordField);
        driver.findElement(passwordField).sendKeys(password);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void enterOTP(String otp)
    {
        waitTillVisibilityOfElement(otpField);
        driver.findElement(otpField).sendKeys(otp);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void clickLoginViaPassword()
    {
        driver.findElement(loginViaPassword).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void clickLoginViaGoogle()
    {
        driver.findElement(loginViaGoogleButton).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void login()
    {
        driver.findElement(loginButton).click();
    }
}
//----------------------------------------------------------------------------------------------------------------------
