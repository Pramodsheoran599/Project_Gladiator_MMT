package tests;

import frameworks.BaseTest;
import pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest
{
    @Test (description = "To check if Login Page Opens or not")
    public void tc_login01()
    {
        driver.get("https://www.makemytrip.com");
        HomePage homePage = new HomePage(driver);
        homePage.goto_login_page();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='font26 latoBlack']")).isDisplayed());
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (description = "To Check Login Feature With Blank Username")
    public void tc_login02() throws InterruptedException
    {
        driver.get("https://www.makemytrip.com");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goto_login_page();

        Assert.assertFalse(driver.findElement(loginPage.continue_button).isEnabled());
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (description = "To Check Login Feature With Blank Password Entered")
    public void tc_login03() throws InterruptedException
    {
        driver.get("https://www.makemytrip.com");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goto_login_page();

        driver.findElement(loginPage.email_mobile_field).sendKeys("pramodsheoran599@gmail.com");
        driver.findElement(loginPage.continue_button).click();

        String continue_btn_color = driver.findElement(loginPage.continue_button).getCssValue("background-color");
        Assert.assertEquals(, "rgba(194, 194, 194, 1)");
        Assert.assertFalse(driver.findElement(loginPage.login_button).isEnabled());
        Thread.sleep(2000);
//        Assert.assertEquals(continue_btn_color, "rgba(194, 194, 194, 1)");
//        Assert.assertFalse(driver.findElement(loginPage.continue_button).isEnabled());
    }
}
