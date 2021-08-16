package tests.moduleTests;

import frameworks.BaseTest;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;


public class CreateAccountTests extends BaseTest
{
    @Test(description = "To check Account Creation with Valid Email and OTP")
    public void tc_signup01() throws InterruptedException
    {
    	test = extentReports.createTest("tc_signup01", "To SignUp");
    	
        driver.get(object_repository.getProperty("homepage_url"));
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.gotoLoginPage();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        loginPage.enterUsername("jacemir442@alltekia.com");
        loginPage.clickContinue();

        Thread.sleep(30000);                        // Wait For manually entering OTP
        createAccountPage.clickCreate();

        createAccountPage.enterFullName("Test");
        createAccountPage.enterPassword("Test@1234");
        createAccountPage.clickSave();

        Assert.assertTrue(homePage.isUserLoggedIn());
    }

//----------------------------------------------------------------------------------------------------------------------
}
