package tests;

import frameworks.BaseTest;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class CreateAccountTests extends BaseTest
{
	
	ExtentTest tc;
	
//----------------------------------------------------------------------------------------------------------------------	
	
	  @Test
		public void report()
		{
			report=new ExtentReports();
			report.attachReporter(new ExtentHtmlReporter("NewHotel.html"));
		}
	   
//----------------------------------------------------------------------------------------------------------------------


//    @Test (description = "To check Create account fe")

    @Test(description = "To check Account Creation with Valid Email and OTP")
    public void tc_signup01() throws InterruptedException
    {
        driver.get(object_repository.getProperty("homepage_url"));
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.gotoLoginPage();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        loginPage.enterUsername("menoc92605@asmm5.com");
        loginPage.clickContinue();

        Thread.sleep(30000);                        // Wait For manually entering OTP
        createAccountPage.clickCreate();

        createAccountPage.enterFullName("Test");
        createAccountPage.enterPassword("Test@1234");
        createAccountPage.clickSave();

        Assert.assertTrue(homePage.isUserLoggedIn());
        
        tc=report.createTest("tc_signup01");
  	  	tc.info("valid creds");
  	  
    }

//----------------------------------------------------------------------------------------------------------------------
}
