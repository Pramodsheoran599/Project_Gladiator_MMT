package tests.endtoEndTests;

import frameworks.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelPage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EndToEnd_HotelBooking extends BaseTest
{
	
    HomePage homePage;
    LoginPage loginPage;
    HotelPage hotelPage;

//----------------------------------------------------------------------------------------------------------------------

    @Test
    public void endToEndHotelBooking() throws InterruptedException
    {
        test = extentReports.createTest("endToEndHotelBooking", "To Check End-To-End Hotel Booking Feature");

        test.info("Opening Make My Trip Website.");
        driver.get(object_repository.getProperty("homepage_url"));
        homePage = new HomePage(driver);

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


        test.info("Going to Hotels Page.");
        hotelPage = new HotelPage(driver);
        homePage.goto_hotels_page();

        test.info("Selecting Area for the Hotel.");
        hotelPage.selectFromArea();
        hotelPage.searchFromArea("Goa");

        test.info("Selecting Check-In Date.");
        hotelPage.select_check_in_date();
        hotelPage.selectDates("17-08-2021");

        test.info("Selecting Check-Out Date.");
        hotelPage.select_check_out_date();
        hotelPage.selectDates("20-08-2021");

        test.info("Selecting Number of Guests.");
        hotelPage.select_number_of_guests();
        hotelPage.searchadult_count();
        hotelPage.click_it();

        test.info("Clicking on Search Hotels.");
        hotelPage.searchHotels();

        test.info("Clicking on the first Hotel.");
        driver.findElement(By.id("Listing_hotel_1")).click();

        Set<String> Win = driver.getWindowHandles();
        List<String> allWin = new ArrayList<>(Win);

        test.info("Switching to first Hotel's Details Page.");
        driver.switchTo().window(allWin.get(1));

        test.info("Clicking on Book Now Button.");
        Thread.sleep(20000);
        driver.findElement(By.id("detpg_headerright_book_now")).click();

        Thread.sleep(5000);

        test.info("Entering User's Title.");
        WebElement E = driver.findElement(By.id("title"));
        Select title = new Select(E);
        title.selectByVisibleText("Mr");

        test.info("Entering User Details.");
        driver.findElement(By.id("fName")).sendKeys("Pramod");
        driver.findElement(By.id("lName")).sendKeys("Sheoran");
//        driver.findElement(By.id("email")).sendKeys("pramodsheoran599@gmail.com");
        driver.findElement(By.id("mNo")).sendKeys("7021521142");

        test.info("Clicking on Pay Now Button.");
        driver.findElement(By.linkText("PAY NOW")).click();

        Thread.sleep(5000);
    }


    @Test
    public void loginViaGoogle() throws InterruptedException
    {
        driver.get(object_repository.getProperty("homepage_url"));

        homePage = new HomePage(driver);
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

        hotelPage = new HotelPage(driver);
        homePage  = new HomePage(driver);
        homePage.goto_hotels_page();

        hotelPage.selectFromArea();
        hotelPage.searchFromArea("Goa");
        hotelPage.select_check_in_date();
        hotelPage.selectDates("17-08-2021");
        hotelPage.select_check_out_date();
        hotelPage.selectDates("20-08-2021");
        hotelPage.select_number_of_guests();
        hotelPage.searchadult_count();
        hotelPage.click_it();
        hotelPage.searchHotels();


        driver.findElement(By.id("Listing_hotel_1")).click();

        Set<String> Win = driver.getWindowHandles();
        List<String> allWin = new ArrayList<>(Win);

        driver.switchTo().window(allWin.get(1));

        driver.findElement(By.id("detpg_headerright_book_now")).click();

        Thread.sleep(5000);

        WebElement E = driver.findElement(By.id("title"));
        Select title = new Select(E);
        title.selectByVisibleText("Mr");

        driver.findElement(By.id("fName")).sendKeys("Pramod");
        driver.findElement(By.id("lName")).sendKeys("Sheoran");
        driver.findElement(By.id("email")).sendKeys("pramodsheoran599@gmail.com");
        driver.findElement(By.id("mNo")).sendKeys("7021521142");
        driver.findElement(By.linkText("PAY NOW")).click();

        Thread.sleep(5000);
    }
}
