package tests.moduleTests;

import frameworks.BaseTest;

import pages.HomePage;
import pages.LoginPage;

import org.openqa.selenium.By;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

//----------------------------------------------------------------------------------------------------------------------

public class Login_Logout_Tests extends BaseTest
{
    HomePage homePage;
    LoginPage loginPage;

//----------------------------------------------------------------------------------------------------------------------

    @BeforeMethod
    public void beforeMethod()
    {
        driver.get(object_repository.getProperty("homepage_url"));
        homePage = new HomePage(driver);
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 1, description = "To check if Login Page Opens or not")
    public void tc_login01()
    {
        test = extentReports.createTest("tc_login01", "To check if Login Page Opens or not");

        loginPage = homePage.gotoLoginPage();
        Assert.assertTrue(loginPage.isDisplayed());
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 2, description = "To Check Login Feature With Blank Username")
    public void tc_login02()
    {
        test = extentReports.createTest("tc_login02", "To Check Login Feature With Blank Username");

        loginPage = homePage.gotoLoginPage();
        Assert.assertFalse(isElementEnabled(loginPage.getContinue_button()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 3, description = "To Check Login Feature With Blank Password Entered")
    public void tc_login03()
    {
        test = extentReports.createTest("tc_login03", "To Check Login Feature With Blank Password Entered");

        loginPage = homePage.gotoLoginPage();
        loginPage.enterUsername("pramodsheoran599@gmail.com");
        loginPage.clickContinue();

        Assert.assertFalse(isElementEnabled(loginPage.getLogin_button()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 4, description = "To check Login Feature with Invalid Email-ID")
    public void tc_login04()
    {
        test = extentReports.createTest("tc_login04", "To check Login Feature with Invalid Email-ID");

        loginPage = homePage.gotoLoginPage();

        loginPage.enterUsername("mmt.project.team@gmailcom");
        driver.findElement(By.className("modalMain")).click();

        Assert.assertTrue(isElementDisplayed(loginPage.getInvalidIdError()));
        Assert.assertFalse(isElementEnabled(loginPage.getContinue_button()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 5, description = "To Check Login Feature with Valid Email and Valid Password")
    public void tc_login05()
    {
        test = extentReports.createTest("tc_login05", "To Check Login Feature with Valid Email and Valid Password");

        loginPage = homePage.gotoLoginPage();

        loginPage.enterUsername("pramodsheoran599@gmail.com");
        loginPage.clickContinue();

        loginPage.enterPassword("Pramod@1234");
        loginPage.login();

        Assert.assertTrue(homePage.isUserLoggedIn());
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 6, description = "To check Login Feature with Valid Email-ID and Invalid Password")
    public void tc_login06()
    {
        test = extentReports.createTest("tc_login06", "To check Login Feature with Valid Email-ID and Invalid Password");

        loginPage = homePage.gotoLoginPage();

        loginPage.enterUsername("pramodsheoran599@gmail.com");
        loginPage.clickContinue();

        loginPage.enterPassword("Pramod@134");
        loginPage.login();

        Assert.assertTrue(isElementDisplayed(loginPage.getError()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 7, description = "To check Login Feature with Invalid Mobile Number")
    public void tc_login07()
    {
        test = extentReports.createTest("tc_login07", "To check Login Feature with Invalid Mobile Number");

        loginPage = homePage.gotoLoginPage();

        loginPage.enterUsername("70215211422");
        loginPage.clickContinue();

        Assert.assertTrue(isElementDisplayed(loginPage.getError()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 8, description = "To Check Login Feature with Valid Mobile Number and Valid Password")
    public void tc_login08()
    {
        test = extentReports.createTest("tc_login08", "To Check Login Feature with Valid Mobile Number and Valid Password");

        loginPage = homePage.gotoLoginPage();

        loginPage.enterUsername("7021521142");
        loginPage.clickContinue();

        loginPage.clickLoginViaPassword();
        loginPage.enterPassword("Pramod@1234");
        loginPage.login();

        Assert.assertTrue(homePage.isUserLoggedIn());
        homePage.logout();
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 9, description = "To check Login Feature with Valid Mobile Number and Invalid Password")
    public void tc_login09()
    {
        test = extentReports.createTest("tc_login09", "To check Login Feature with Valid Mobile Number and Invalid Password");

        loginPage = homePage.gotoLoginPage();

        loginPage.enterUsername("7021521142");
        loginPage.clickContinue();

        loginPage.clickLoginViaPassword();
        loginPage.enterPassword("Pramod@134");
        loginPage.login();

        Assert.assertTrue(isElementDisplayed(loginPage.getError()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (enabled = true, priority = 10, description = "To check Login Feature with Valid Mobile Number and valid OTP")
    public void tc_login10() throws Exception
    {
        test = extentReports.createTest("tc_login10", "To check Login Feature with Valid Mobile Number and valid OTP");

        loginPage = homePage.gotoLoginPage();

        loginPage.enterUsername("7021521142");
        loginPage.clickContinue();

        Thread.sleep(30000);
        loginPage.login();

        Assert.assertTrue(homePage.isUserLoggedIn());
        homePage.logout();
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 11, description = "To check Login Feature with Valid Mobile Number and Invalid OTP")
    public void tc_login11()
    {
        test = extentReports.createTest("tc_login11", "To check Login Feature with Valid Mobile Number and Invalid OTP");

        loginPage = homePage.gotoLoginPage();

        loginPage.enterUsername("7021521142");
        loginPage.clickContinue();

        loginPage.enterOTP("12356");
        loginPage.login();

        Assert.assertTrue(isElementDisplayed(loginPage.getInvalidOtpError()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 12, description = "To check Login Feature with 'Login with Google' Button")
    public void tc_login12() throws Exception
    {
        test = extentReports.createTest("tc_login12", "To check Login Feature with 'Login with Google' Button");

        loginPage = homePage.gotoLoginPage();
        String parentWindowId = driver.getWindowHandle();

        loginPage.clickLoginViaGoogle();

        Set<String> allWindowIds = driver.getWindowHandles();

        for (String id : allWindowIds)
        {
            if (!parentWindowId.equals(id))
                driver.switchTo().window(id);
        }

        driver.findElement(By.id("identifierId")).sendKeys("mmt.project.team@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
        driver.findElement(By.name("password")).sendKeys("Project@Team10");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();

        Thread.sleep(5000);
        driver.switchTo().window(parentWindowId);
        Assert.assertTrue(homePage.isUserLoggedIn());
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (dependsOnMethods = "tc_login05", description = "To check if Logout happens or not")
    public void tc_logout01()
    {
        test = extentReports.createTest("tc_logout01", "To check if Logout happens or not");

        homePage.logout();
        Assert.assertFalse(homePage.isUserLoggedIn());
    }

//----------------------------------------------------------------------------------------------------------------------
}