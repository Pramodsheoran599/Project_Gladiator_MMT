package tests.moduleTests;

import frameworks.BaseTest;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTests extends BaseTest
{
    @Test(description = "To check Account Creation with Valid Email and Invalid OTP")
    public void tc_signup01() throws InterruptedException
    {
        test = extentReports.createTest("tc_signup01", "To SignUp");

        driver.get(object_repository.getProperty("homepage_url"));

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        // Temp Mail Website is Used to Generate a new Disposable Email-ID for Testing Purpose.
        loginPage.enterUsername("jopegas48755@cytsl.com");
        loginPage.clickContinue();
        test.pass("Enter Valid Email-ID and Click Continue.");

        createAccountPage.enterOTP("123456");
        Thread.sleep(1000);
        createAccountPage.clickCreate();
        test.pass("Enter OTP and Click Create.");

        takeScreenshot(object_repository.getProperty("snapshot.CreateAccount") + "Account created.png");

        Assert.assertTrue(isElementDisplayed(createAccountPage.getWrongOtpError()));
        test.pass("Check if Invalid Otp Error is Displayed.");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test(description = "To check Account Creation with Valid Email and OTP")
    public void tc_signup02() throws InterruptedException
    {
        test = extentReports.createTest("tc_signup01", "To SignUp");

        driver.get(object_repository.getProperty("homepage_url"));

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        // Temp Mail Website is Used to Generate a new Disposable Email-ID for Testing Purpose.
        loginPage.enterUsername("yigefi3431@alltekia.com");
        loginPage.clickContinue();
        test.pass("Enter Valid Email-ID and Click Continue.");

        Thread.sleep(30000);                        // Wait For manually entering OTP
        createAccountPage.clickCreate();
        test.pass("Enter OTP and Click Create.");

        createAccountPage.enterFullName("Test");
        createAccountPage.enterPassword("Test@1234");
        test.pass("Enter Full Name and Password.");

        createAccountPage.clickSave();
        test.pass("Click Save.");

        takeScreenshot(object_repository.getProperty("snapshot.CreateAccount") + "Account created.png");

        Assert.assertTrue(homePage.isUserLoggedIn());
        test.pass("Check if User Logged In.");
    }
}
