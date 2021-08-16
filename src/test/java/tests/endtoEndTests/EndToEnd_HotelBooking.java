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
    public void endToEndHotelBooking()
    {
        test = extentReports.createTest("End-To-End Hotel Booking", "To Check End-To-End Hotel Booking Feature");

        driver.get(object_repository.getProperty("homepage_url"));
        homePage = new HomePage(driver);
        test.pass("Open Make My Trip Website.");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername("pramodsheoran599@gmail.com");
        loginPage.clickContinue();
        test.pass("Enter Valid Email-ID and Click Continue.");

        loginPage.enterPassword("Pramod@1234");
        loginPage.login();
        test.pass("Enter Valid Password and Click Login.");

        Assert.assertTrue(homePage.isUserLoggedIn());
        test.pass("Check if User is Logged in.");

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Hotel_Booking") + "1. Login.png");

        hotelPage = new HotelPage(driver);
        homePage.goto_hotels_page();
        test.pass("Go to Hotels Page.");

        hotelPage.selectFromArea();
        hotelPage.searchFromArea("Goa");
        test.pass("Select Area for the Hotel.");

        hotelPage.select_check_in_date();
        hotelPage.selectDates("17-08-2021");
        test.pass("Select Check-In Date.");

        hotelPage.select_check_out_date();
        hotelPage.selectDates("20-08-2021");
        test.pass("Select Check-Out Date.");

        hotelPage.select_number_of_guests();
        hotelPage.searchadult_count();
        hotelPage.click_it();
        test.pass("Select Number of Guests.");

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Hotel_Booking") + "2. Hotel_Search.png");

        hotelPage.searchHotels();
        test.pass("Click on Search Hotels.");

        waitTillVisibilityOf(By.id("Listing_hotel_1"));

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Hotel_Booking") + "3. Searched_Hotels.png");

        driver.findElement(By.id("Listing_hotel_1")).click();
        test.pass("Click on the first Hotel.");

        Set<String> Win = driver.getWindowHandles();
        List<String> allWin = new ArrayList<>(Win);

        driver.switchTo().window(allWin.get(1));
        test.pass("Switch to first Hotel's Details Page.");

        waitTillVisibilityOf(By.id("detpg_headerright_book_now"));

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Hotel_Booking") + "4. Hotel_Details.png");

        driver.findElement(By.id("detpg_headerright_book_now")).click();
        test.pass("Click on Book Now Button.");

        waitTillVisibilityOf(By.id("title"));

        WebElement E = driver.findElement(By.id("title"));
        Select title = new Select(E);
        title.selectByVisibleText("Mr");
        test.pass("Enter User's Title.");

        driver.findElement(By.id("fName")).sendKeys("Pramod");
        driver.findElement(By.id("lName")).sendKeys("Sheoran");
        test.pass("Enter User's First and Last Name.");

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Hotel_Booking") + "5. Review_Booking.png");

        driver.findElement(By.linkText("PAY NOW")).click();
        test.pass("Click on Pay Now Button.");
    }
}