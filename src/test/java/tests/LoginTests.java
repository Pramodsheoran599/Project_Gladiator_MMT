package tests;

import frameworks.BaseTest;
import pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest
{
    @Test
    public void tc_login01() throws InterruptedException
    {
        driver.get("https://www.makemytrip.com");
        HomePage homePage = new HomePage(driver);
        homePage.goto_login_page();

//        driver.switchTo().activeElement();
        Assert.assertTrue(driver.findElement(By.linkText("Login/Signup")).isDisplayed());
    }



    @Test
    public void tc_login02() throws InterruptedException
    {
        driver.get("https://www.makemytrip.com");
        HomePage homePage = new HomePage(driver);
        homePage.goto_login_page();

//        driver.switchTo().activeElement();
        Assert.assertTrue(driver.findElement(By.linkText("Login/Signup")).isDisplayed());
    }
}
