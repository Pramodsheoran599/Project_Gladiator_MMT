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

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Checking if Login Page is Displayed By Verifying its Heading.");
        Assert.assertTrue(loginPage.isDisplayed());
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 2, description = "To Check Login Feature With Blank Username")
    public void tc_login02()
    {
        test = extentReports.createTest("tc_login02", "To Check Login Feature With Blank Username.");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Checking if Continue Button is Disabled By Default.");
        Assert.assertFalse(isElementEnabled(loginPage.getContinue_button()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 3, description = "To Check Login Feature With Blank Password Entered")
    public void tc_login03()
    {
        test = extentReports.createTest("tc_login03", "To Check Login Feature With Blank Password Entered.");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Entering Valid Email-ID and Clicking Continue.");
        loginPage.enterUsername("pramodsheoran599@gmail.com");
        loginPage.clickContinue();

        test.info("Checking if Login Button is Disabled by Default.");
        Assert.assertFalse(isElementEnabled(loginPage.getLogin_button()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 4, description = "To check Login Feature with Invalid Email-ID")
    public void tc_login04()
    {
        test = extentReports.createTest("tc_login04", "To check Login Feature with Invalid Email-ID");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Entering Invalid Email-ID.");
        loginPage.enterUsername("mmt.project.team@gmailcom");

        test.info("Checking if Continue button is disabled after entering Invalid Email-ID.");
        Assert.assertFalse(isElementEnabled(loginPage.getContinue_button()));

        test.info("Clicking anywhere on the Login Page (as Continue button is disabled).");
        driver.findElement(By.className("modalMain")).click();

        test.info("Checking if Invalid Email-ID Error is Displayed.");
        Assert.assertTrue(isElementDisplayed(loginPage.getInvalidIdError()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 5, description = "To Check Login Feature with Valid Email and Valid Password")
    public void tc_login05()
    {
        test = extentReports.createTest("tc_login05", "To Check Login Feature with Valid Email and Valid Password");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Entering Valid Email-ID and Clicking Continue.");
        loginPage.enterUsername("pramodsheoran599@gmail.com");
        loginPage.clickContinue();

        test.info("Entering Valid Password and Clicking Login.");
        loginPage.enterPassword("Pramod@1234");
        loginPage.login();

        test.info("Checking if User is Logged in.");
        Assert.assertTrue(homePage.isUserLoggedIn());
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 6, description = "To check Login Feature with Valid Email-ID and Invalid Password")
    public void tc_login06()
    {
        test = extentReports.createTest("tc_login06", "To check Login Feature with Valid Email-ID and Invalid Password");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Entering Valid Email-ID and Clicking Continue.");
        loginPage.enterUsername("pramodsheoran599@gmail.com");
        loginPage.clickContinue();

        test.info("Entering Invalid Password and Clicking Login.");
        loginPage.enterPassword("Pramod@134");
        loginPage.login();

        test.info("Checking if Invalid Password Error is Displayed.");
        Assert.assertTrue(isElementDisplayed(loginPage.getError()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 7, description = "To check Login Feature with Invalid Mobile Number")
    public void tc_login07()
    {
        test = extentReports.createTest("tc_login07", "To check Login Feature with Invalid Mobile Number");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Entering Invalid Mobile Number and Clicking Continue.");
        loginPage.enterUsername("70215211422");
        loginPage.clickContinue();

        test.info("Checking if Invalid MobileNumber Error is Displayed.");
        Assert.assertTrue(isElementDisplayed(loginPage.getError()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 8, description = "To Check Login Feature with Valid Mobile Number and Valid Password")
    public void tc_login08()
    {
        test = extentReports.createTest("tc_login08", "To Check Login Feature with Valid Mobile Number and Valid Password");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Entering Valid Mobile Number and Clicking Continue.");
        loginPage.enterUsername("7021521142");
        loginPage.clickContinue();

        test.info("Clicking Login Via Password Link.");
        loginPage.clickLoginViaPassword();

        test.info("Entering Valid Password and Clicking Login.");
        loginPage.enterPassword("Pramod@1234");
        loginPage.login();

        test.info("Checking if User is Logged in.");
        Assert.assertTrue(homePage.isUserLoggedIn());
        homePage.logout();
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 9, description = "To check Login Feature with Valid Mobile Number and Invalid Password")
    public void tc_login09()
    {
        test = extentReports.createTest("tc_login09", "To check Login Feature with Valid Mobile Number and Invalid Password");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Entering Valid Mobile Number and Clicking Continue.");
        loginPage.enterUsername("7021521142");
        loginPage.clickContinue();

        test.info("Clicking Login Via Password Link.");
        loginPage.clickLoginViaPassword();

        test.info("Entering Invalid Password and Clicking Login.");
        loginPage.enterPassword("Pramod@134");
        loginPage.login();

        test.info("Checking if Invalid Password Error is Displayed.");
        Assert.assertTrue(isElementDisplayed(loginPage.getError()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 10, description = "To check Login Feature with Valid Mobile Number and valid OTP")
    public void tc_login10() throws Exception
    {
        test = extentReports.createTest("tc_login10", "To check Login Feature with Valid Mobile Number and valid OTP");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Entering Valid Mobile Number and Clicking Continue.");
        loginPage.enterUsername("7021521142");
        loginPage.clickContinue();

        test.info("Waiting for Manual Input of OTP and then Clicking Login.");
        Thread.sleep(30000);
        loginPage.login();

        test.info("Checking if User is Logged in.");
        Assert.assertTrue(homePage.isUserLoggedIn());
        homePage.logout();
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 11, description = "To check Login Feature with Valid Mobile Number and Invalid OTP")
    public void tc_login11()
    {
        test = extentReports.createTest("tc_login11", "To check Login Feature with Valid Mobile Number and Invalid OTP");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();

        test.info("Entering Valid Mobile Number and Clicking Continue.");
        loginPage.enterUsername("7021521142");
        loginPage.clickContinue();

        test.info("Entering Invalid OTP and Clicking Login Button.");
        loginPage.enterOTP("12356");
        loginPage.login();

        test.info("Checking if Invalid OTP Error is Displayed.");
        Assert.assertTrue(isElementDisplayed(loginPage.getInvalidOtpError()));
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (priority = 12, description = "To check Login Feature with 'Login with Google' Button")
    public void tc_login12() throws Exception
    {

        test = extentReports.createTest("tc_login12", "To check Login Feature with 'Login with Google' Button");

        test.info("Going to Login Page.");
        loginPage = homePage.gotoLoginPage();
        String parentWindowId = driver.getWindowHandle();

        test.info("Clicking Login Via Google Button.");
        loginPage.clickLoginViaGoogle();

        Set<String> allWindowIds = driver.getWindowHandles();

        test.info("Switching to Google Authentication Window.");
        for (String id : allWindowIds)
        {
            if (!parentWindowId.equals(id))
                driver.switchTo().window(id);
        }

        test.info("Entering Valid Google Email, Password and Logging in.");
        driver.findElement(By.id("identifierId")).sendKeys("mmt.project.team@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
        driver.findElement(By.name("password")).sendKeys("Project@Team10");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();

        test.info("Switching Back to Make My Trip Window.");
        driver.switchTo().window(parentWindowId);

        test.info("Checking if User is Logged In.");
        Assert.assertTrue(homePage.isUserLoggedIn());
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test (dependsOnMethods = "tc_login05", description = "To check if Logout happens or not")
    public void tc_logout01()
    {
        test = extentReports.createTest("tc_logout01", "To check if Logout happens or not");

        test.info("Going to Profile Page and Clicking Logout Button.");
        homePage.logout();

        test.info("Checking if User is Logged Out.");
        Assert.assertFalse(homePage.isUserLoggedIn());
    }

//----------------------------------------------------------------------------------------------------------------------
}
