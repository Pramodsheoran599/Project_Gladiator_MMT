package tests.endtoEndTests;

import frameworks.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class EndToEnd_FlightBooking extends BaseTest
{
    HomePage homePage;
    LoginPage loginPage;
    SearchFlightsPage searchFlightsPage;

    @Test
    public void endToEndFlightBooking() throws InterruptedException
    {
        test = extentReports.createTest("End-To-End Hotel Booking", "To Check End-To-End Hotel Booking Feature");

        driver.get(object_repository.getProperty("homepage_url"));
        homePage = new HomePage(driver);
        test.pass("Open Make My Trip Website.");

        loginPage = homePage.gotoLoginPage();
        test.pass("Go to Login Page.");

        loginPage.enterUsername(object_repository.getProperty("validEmail"));
        loginPage.clickContinue();
        test.pass("Enter Valid Email-ID and Click Continue.");

        loginPage.enterPassword(object_repository.getProperty("validPassword"));
        loginPage.login();
        test.pass("Enter Valid Password and Click Login.");

        Assert.assertTrue(homePage.isUserLoggedIn());
        test.pass("Check if User is Logged in.");

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Flight_Booking") + "1. Login.png");

        // Close to Verify your Phone number pop-up
        try
        {
            if (driver.findElement(By.cssSelector("span[data-cy='modalClose']")).isDisplayed())
                driver.findElement(By.cssSelector("span[data-cy='modalClose']")).click();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        searchFlightsPage = new SearchFlightsPage(driver);

        searchFlightsPage.selectFromCity("Delhi, India");
        Thread.sleep(500);
        searchFlightsPage.selectToCity("Mumbai, India");

        searchFlightsPage.selectDepartureDate();
        searchFlightsPage.selectTravellers();

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Flight_Booking") + "2. Flight Search");

        searchFlightsPage.search();

        if (isElementDisplayed(object_repository.getLocator("searchedFlights.popUp")))
            driver.findElement(object_repository.getLocator("searchedFlights.popUp")).click();

        searchFlightsPage.selectFirstFlight();

        String parentWindowId = driver.getWindowHandle();
        Set<String> allWindowIds = driver.getWindowHandles();

        for (String id : allWindowIds)
        {
            if (!parentWindowId.equals(id))
            {
                driver.switchTo().window(id);
                test.pass("Switching to Complete Your Booking Window.");
            }
        }

        CompleteYourFlightBooking completeBooking = new CompleteYourFlightBooking(driver);

        completeBooking.addInsurance();

        List<String> adult = Arrays.asList("Pramod", "Sheoran");
        List<String> child = Arrays.asList("Ram", "Shyam");

        completeBooking.addTravellers(adult, child);
        completeBooking.clickContinue();
        completeBooking.clickConfirm();

        Thread.sleep(10000);

        completeBooking.clickContinue();

        completeBooking.airportPickupAndDrop();
        completeBooking.proceedToPay();

        Assert.assertTrue(driver.findElement(object_repository.getLocator("completeBooking.paymentSection")).isDisplayed());

    }
}
