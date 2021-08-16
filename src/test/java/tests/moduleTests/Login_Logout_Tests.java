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

    @Test (priority = 1, description = "To check if Login Page Opens or not.")
    public void tc_login01()
    {
        test = extentReports.createTest("tc_login01", "To check if Login Page Opens or not.");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login01.png");
        
        Assert.assertTrue(loginPage.isDisplayed());
        test.pass("Check if Login Page is Displayed By Verifying its Heading.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 2, description = "To Check Login Feature With Blank Username")
    public void tc_login02()
    {
        test = extentReports.createTest("tc_login02", "To Check Login Feature With Blank Username.");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login02.png");

        Assert.assertFalse(isElementEnabled(loginPage.getContinue_button()));
        test.pass("Check if Continue Button is Disabled By Default.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 3, description = "To Check Login Feature With Blank Password Entered")
    public void tc_login03()
    {
        test = extentReports.createTest("tc_login03", "To Check Login Feature With Blank Password Entered.");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername(object_repository.getProperty("validEmail"));
        loginPage.clickContinue();
        test.pass("Enter Valid Email-ID and Click Continue.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login03.png");

        Assert.assertFalse(isElementEnabled(loginPage.getLogin_button()));
        test.pass("Check if Login Button is Disabled by Default.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 4, description = "To check Login Feature with Invalid Email-ID")
    public void tc_login04()
    {
        test = extentReports.createTest("tc_login04", "To check Login Feature with Invalid Email-ID");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername("mmt.project.team@gmailcom");
        test.pass("Enter Invalid Email-ID.");

        Assert.assertFalse(isElementEnabled(loginPage.getContinue_button()));
        test.pass("Check if Continue button is disabled after Enter Invalid Email-ID.");

        driver.findElement(By.className("modalMain")).click();
        test.pass("Click anywhere on the Login Page (as Continue button is disabled).");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login04.png");

        Assert.assertTrue(isElementDisplayed(loginPage.getInvalidIdError()));
        test.pass("Check if Invalid Email-ID Error is Displayed.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 5, description = "To Check Login Feature with Valid Email and Valid Password")
    public void tc_login05()
    {
        test = extentReports.createTest("tc_login05", "To Check Login Feature with Valid Email and Valid Password");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername(object_repository.getProperty("validEmail"));
        loginPage.clickContinue();
        test.pass("Enter Valid Email-ID and Click Continue.");

        loginPage.enterPassword(object_repository.getProperty("validPassword"));
        loginPage.login();
        test.pass("Enter Valid Password and Click Login.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login05.png");

        Assert.assertTrue(homePage.isUserLoggedIn());
        test.pass("Check if User is Logged in.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 6, description = "To check Login Feature with Valid Email-ID and Invalid Password")
    public void tc_login06()
    {
        test = extentReports.createTest("tc_login06", "To check Login Feature with Valid Email-ID and Invalid Password");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername(object_repository.getProperty("validEmail"));
        loginPage.clickContinue();
        test.pass("Enter Valid Email-ID and Click Continue.");

        loginPage.enterPassword("Pramod@123");
        loginPage.login();
        test.pass("Enter Invalid Password and Click Login.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login06.png");

        Assert.assertTrue(isElementDisplayed(loginPage.getError()));
        test.pass("Check if Invalid Password Error is Displayed.");

    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 7, description = "To check Login Feature with Invalid Mobile Number")
    public void tc_login07()
    {
        test = extentReports.createTest("tc_login07", "To check Login Feature with Invalid Mobile Number");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername("70215211422");
        loginPage.clickContinue();
        test.pass("Enter Invalid Mobile Number and Click Continue.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login07.png");

        Assert.assertTrue(isElementDisplayed(loginPage.getError()));
        test.pass("Check if Invalid Mobile Number Error is Displayed.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 8, description = "To Check Login Feature with Valid Mobile Number and Valid Password")
    public void tc_login08() throws InterruptedException
    {
        test = extentReports.createTest("tc_login08", "To Check Login Feature with Valid Mobile Number and Valid Password");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername(object_repository.getProperty("validMobile"));

        Thread.sleep(5000);
        loginPage.clickContinue();
        test.pass("Enter Valid Mobile Number and Click Continue.");

        Thread.sleep(5000);

        if (isElementDisplayed(loginPage.getLoginViaPassword()))
            loginPage.clickLoginViaPassword();
            test.pass("Click Login Via Password Link.");

        loginPage.enterPassword(object_repository.getProperty("validPassword"));
        loginPage.login();
        test.pass("Enter Valid Password and Click Login.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login08.png");

        Assert.assertTrue(homePage.isUserLoggedIn());
        test.pass("Check if User is Logged in.");
        homePage.logout();
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 9, description = "To check Login Feature with Valid Mobile Number and Invalid Password")
    public void tc_login09() throws InterruptedException
    {
        test = extentReports.createTest("tc_login09", "To check Login Feature with Valid Mobile Number and Invalid Password");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername(object_repository.getProperty("validMobile"));
        loginPage.clickContinue();
        test.pass("Enter Valid Mobile Number and Click Continue.");

        if (isElementDisplayed(loginPage.getLoginViaPassword()))
            loginPage.clickLoginViaPassword();
            test.pass("Click Login Via Password Link.");

        loginPage.enterPassword("Pramod@134");
        loginPage.login();
        test.pass("Enter Invalid Password and Click Login.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login09.png");

        Assert.assertTrue(isElementDisplayed(loginPage.getError()));
        test.pass("Check if Invalid Password Error is Displayed.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 10, description = "To check Login Feature with Valid Mobile Number and valid OTP")
    public void tc_login10() throws Exception
    {
        test = extentReports.createTest("tc_login10", "To check Login Feature with Valid Mobile Number and valid OTP");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername(object_repository.getProperty("validMobile"));
        loginPage.clickContinue();
        test.pass("Enter Valid Mobile Number and Click Continue.");

        Thread.sleep(30000);
        loginPage.login();
        test.pass("Waiting for Manual Input of OTP and then Click Login.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login10.png");

        Assert.assertTrue(homePage.isUserLoggedIn());
        homePage.logout();
        test.pass("Check if User is Logged in.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 11, description = "To check Login Feature with Valid Mobile Number and Invalid OTP")
    public void tc_login11()
    {
        test = extentReports.createTest("tc_login11", "To check Login Feature with Valid Mobile Number and Invalid OTP");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername(object_repository.getProperty("validMobile"));
        loginPage.clickContinue();
        test.pass("Enter Valid Mobile Number and Click Continue.");

        loginPage.enterOTP("12356");
        loginPage.login();
        test.pass("Enter Invalid OTP and Click Login Button.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login11.png");

        Assert.assertTrue(isElementDisplayed(loginPage.getInvalidOtpError()));
        test.pass("Check if Invalid OTP Error is Displayed.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 12, description = "To check Login Feature with 'Login with Google' Button")
    public void tc_login12() throws Exception
    {

        test = extentReports.createTest("tc_login12", "To check Login Feature with 'Login with Google' Button");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        String parentWindowId = driver.getWindowHandle();

        loginPage.clickLoginViaGoogle();
        test.pass("Click Login Via Google Button.");

        Set<String> allWindowIds = driver.getWindowHandles();

        for (String id : allWindowIds)
        {
            if (!parentWindowId.equals(id))
            {
                driver.switchTo().window(id);
                test.pass("Switching to Google Authentication Window.");
            }
        }

        driver.findElement(By.id("identifierId")).sendKeys("mmt.project.team@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
        driver.findElement(By.name("password")).sendKeys("Project@Team10");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
        test.pass("Enter Valid Google Email, Password and Logging in.");

        driver.switchTo().window(parentWindowId);
        test.pass("Switching Back to Make My Trip Window.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_login12.png");

        Assert.assertTrue(homePage.isUserLoggedIn());
        test.pass("Check if User is Logged In.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (dependsOnMethods = "tc_login05", description = "To check if Logout happens or not")
    public void tc_logout01()
    {
        test = extentReports.createTest("tc_logout01", "To check if Logout happens or not");

        homePage.logout();
        test.pass("Go to Profile Page and Click Logout Button.");

        takeScreenshot(object_repository.getProperty("snapshot.module.login") + "tc_logout01.png");

        Assert.assertFalse(homePage.isUserLoggedIn());
        test.pass("Check if User is Logged Out.");
    }

//----------------------------------------------------------------------------------------------------------------------
}
