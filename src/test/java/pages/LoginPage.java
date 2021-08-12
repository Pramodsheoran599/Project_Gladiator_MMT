package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public By email_mobile_field = By.id("username");
    public By password_field     = By.id("password");
    public By continue_button    = By.cssSelector("button[data-cy='continueBtn']");
    public By login_button       = By.cssSelector("button[data-cy='login']");
    public By login_via_otp      = By.linkText("or Login via OTP");
    public By blank_id_error     = By.cssSelector("button[data-cy='error']");
    public By login_via_google_button = By.cssSelector("button[data-cy='googleLogin']");



}
