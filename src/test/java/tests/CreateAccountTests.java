package tests;

import frameworks.BaseTest;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTests extends BaseTest
{
    @Test(description = "To check Account Creation with Valid Email and OTP")
    public void tc_signup03() throws InterruptedException
    {
        driver.get(object_repository.getProperty("homepage_url"));
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goto_login_page();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        loginPage.enter_username("menoc92605@asmm5.com");
        loginPage.click_continue();

        Thread.sleep(30000);
        createAccountPage.clickCreate();

        createAccountPage.enterFullName("Test");
        createAccountPage.enterPassword("Test@1234");
        createAccountPage.clickSave();

        Thread.sleep(8000);
        Assert.assertTrue(homePage.is_user_logged_in());
    }

//----------------------------------------------------------------------------------------------------------------------
}
