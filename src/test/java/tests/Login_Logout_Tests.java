package tests;

import frameworks.BaseTest;
import frameworks.Object_Repository;

import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.LoginPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

//----------------------------------------------------------------------------------------------------------------------

public class Login_Logout_Tests extends BaseTest
{

    Object_Repository object_repository = new Object_Repository();

//    @Test (description = "To check if Login Page Opens or not")
//    public void tc_login01()
//    {
//        driver.get(object_repository.getProperty("homepage_url"));
//        HomePage homePage = new HomePage(driver);
//        homePage.goto_login_page();
//
//        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='font26 latoBlack']")).isDisplayed());
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test (description = "To Check Login Feature With Blank Username")
//    public void tc_login02()
//    {
//        driver.get("https://www.makemytrip.com");
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.goto_login_page();
//
//        Assert.assertFalse(loginPage.check_if_element_is_enabled("continue_button"));
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test (description = "To Check Login Feature With Blank Password Entered")
//    public void tc_login03()
//    {
//        driver.get("https://www.makemytrip.com");
//
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.goto_login_page();
//
//        loginPage.enter_username("pramodsheoran599@gmail.com");
//        loginPage.click_continue();
//
//        Assert.assertFalse(loginPage.check_if_element_is_enabled("login_button"));
//    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (description = "To Check Login Feature with Valid Email and Valid Password")
    public void tc_login04() throws InterruptedException
    {
        driver.get("https://www.makemytrip.com");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goto_login_page();

        loginPage.enter_username("pramodsheoran599@gmail.com");
        loginPage.click_continue();

        loginPage.enter_password("Pramod@1234");
        loginPage.login();

        Thread.sleep(3000);
        Assert.assertTrue(homePage.is_user_logged_in());
    }

//----------------------------------------------------------------------------------------------------------------------

//    @Test (description = "To check Login Feature with Invalid Email-ID")
//    public void tc_login05()
//    {
//        driver.get("https://www.makemytrip.com");
//
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.goto_login_page();
//
//        loginPage.enter_username("mmt.project.team@gmailcom");
//
//        Assert.assertFalse(loginPage.check_if_element_is_enabled("continue_button"));
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test (description = "To check Login Feature with Valid Email-ID and Invalid Password")
//    public void tc_login06()
//    {
//        driver.get("https://www.makemytrip.com");
//
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.goto_login_page();
//
//        loginPage.enter_username("pramodsheoran599@gmail.com");
//        loginPage.click_continue();
//
//        loginPage.enter_password("Pramod@134");
//        loginPage.login();
//
//        Assert.assertTrue(loginPage.check_if_element_is_displayed("error"));
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test (description = "To Check Login Feature with Valid Mobile Number and Valid Password")
//    public void tc_login07() throws InterruptedException
//    {
//        driver.get("https://www.makemytrip.com");
//
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.goto_login_page();
//
//        loginPage.enter_username("7021521142");
//        loginPage.click_continue();
//
//        loginPage.click_login_via_password();
//        loginPage.enter_password("Pramod@1234");
//        loginPage.login();
//
//        Thread.sleep(10000);                              // Need to Fix Stale Element Exception if Removed
//        Assert.assertTrue(homePage.is_user_logged_in());        // Exception occurs in hey_username element
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test (description = "To check Login Feature with Invalid Mobile Number")
//    public void tc_login08()
//    {
//        driver.get("https://www.makemytrip.com");
//
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.goto_login_page();
//
//        loginPage.enter_username("70215211422");
//        loginPage.click_continue();
//
//        Assert.assertTrue(loginPage.check_if_element_is_displayed("error"));
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test (description = "To check Login Feature with Valid Mobile Number and Invalid Password")
//    public void tc_login09()
//    {
//        driver.get("https://www.makemytrip.com");
//
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.goto_login_page();
//
//        loginPage.enter_username("7021521142");
//        loginPage.click_continue();
//
//        loginPage.click_login_via_password();
//        loginPage.enter_password("Pramod@134");
//        loginPage.login();
//
//        Assert.assertTrue(loginPage.check_if_element_is_displayed("error"));
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test (description = "To check Login Feature with Valid Mobile Number and valid OTP")
//    public void tc_login10() throws Exception
//    {
//        driver.get("https://www.makemytrip.com");
//
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.goto_login_page();
//
//        loginPage.enter_username("7021521142");
//        loginPage.click_continue();
//
//        Thread.sleep(10000);
//        loginPage.login();
//
//        Assert.assertTrue(homePage.is_user_logged_in());
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test (description = "To check Login Feature with Valid Mobile Number and Invalid OTP")
//    public void tc_login11() throws Exception
//    {
//        driver.get("https://www.makemytrip.com");
//
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.goto_login_page();
//
//        loginPage.enter_username("7021521142");
//        loginPage.click_continue();
//
//        Thread.sleep(1000);
//        loginPage.enter_otp("12356");
//        loginPage.login();
//
//        Assert.assertTrue(loginPage.check_if_element_is_displayed("error"));
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test (description = "To check Login Feature with 'Login with Google' Button")
//    public void tc_login12() throws Exception
//    {
//        driver.get("https://www.makemytrip.com");
//
//        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.goto_login_page();
//        String parentWindowId = driver.getWindowHandle();
//
//        loginPage.click_login_via_google();
//
//        Set<String> allWindowIds = driver.getWindowHandles();
//
//        for (String id : allWindowIds)
//        {
//            if (!parentWindowId.equals(id))
//                driver.switchTo().window(id);
//        }
//
//        driver.findElement(By.id("identifierId")).sendKeys("mmt.project.team@gmail.com");
//        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
//        driver.findElement(By.name("password")).sendKeys("Project@Team10");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
//
//        Thread.sleep(5000);
//        driver.switchTo().window(parentWindowId);
//        Assert.assertTrue(homePage.is_user_logged_in());
//    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (dependsOnMethods = "tc_login04", description = "To check if Logout happens or not")
    public void tc_logout01() throws Exception
    {
        HomePage homePage = new HomePage(driver);

        homePage.logout();

        Thread.sleep(10000);
        Assert.assertFalse(homePage.is_user_logged_in());
    }

//----------------------------------------------------------------------------------------------------------------------
}
