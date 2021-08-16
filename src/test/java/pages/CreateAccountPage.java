package pages;

import frameworks.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage
{
    public CreateAccountPage(WebDriver driver)
    {
        super(driver);
    }

    By otp_field     = object_repository.getLocator("createAccount.otp_field");
    By fullNameField = object_repository.getLocator("createAccount.fullNameField");
    By passwordField = object_repository.getLocator("createAccount.passwordField");

    By createButton  = object_repository.getLocator("createAccount.createButton");
    By saveButton    = object_repository.getLocator("createAccount.saveButton");
    By wrongOtpError = object_repository.getLocator("createAccount.wrongOtpError");

//----------------------------------------------------------------------------------------------------------------------

    public By getWrongOtpError() { return wrongOtpError; }

    public void clickCreate   ()                { driver.findElement(createButton).click(); }
    public void clickSave     ()                { driver.findElement(saveButton).click(); }
    public void enterOTP      (String otp)      { driver.findElement(otp_field).sendKeys(otp); }
    public void enterFullName (String name)     { driver.findElement(fullNameField).sendKeys(name); }
    public void enterPassword (String password) { driver.findElement(passwordField).sendKeys(password); }

}
