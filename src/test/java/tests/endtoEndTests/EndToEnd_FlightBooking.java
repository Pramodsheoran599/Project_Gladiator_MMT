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
        test.pass("Close Popup if displayed.");

        searchFlightsPage = new SearchFlightsPage(driver);

        searchFlightsPage.selectFromCity("Delhi, India");
        test.pass("Enter From City.");

        Thread.sleep(500);
        searchFlightsPage.selectToCity("Mumbai, India");
        test.pass("Enter To City.");

        searchFlightsPage.selectDepartureDate();
        test.pass("Select Departure Dates.");

        searchFlightsPage.selectTravellers();
        test.pass("Select Travellers.");

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Flight_Booking") + "2. Flight Search");

        searchFlightsPage.search();

        if (isElementDisplayed(object_repository.getLocator("searchedFlights.popUp")))
            driver.findElement(object_repository.getLocator("searchedFlights.popUp")).click();

        test.pass("Close Popup if displayed.");

        searchFlightsPage.selectFirstFlight();

        String parentWindowId = driver.getWindowHandle();
        Set<String> allWindowIds = driver.getWindowHandles();

        for (String id : allWindowIds)
        {
            if (!parentWindowId.equals(id))
            {
                driver.switchTo().window(id);
                test.pass("Switch to Complete Your Booking Window.");
            }
        }

        CompleteYourFlightBooking completeBooking = new CompleteYourFlightBooking(driver);

        completeBooking.addInsurance();
        test.pass("Add Insurance.");

        List<String> adult = Arrays.asList("Pramod", "Sheoran");
        List<String> child = Arrays.asList("Ram", "Shyam");

        completeBooking.addTravellers(adult, child);
        test.pass("Add Traveller Details.");

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Flight_Booking") + "3. Traveller.png");

        completeBooking.clickContinue();
        test.pass("Click Continue.");

        completeBooking.clickConfirm();
        test.pass("Click Confirm.");

        Thread.sleep(5000);

        if (isElementDisplayed(By.xpath("//*[@id=\"root\"]/div/div[2]/div[4]/div/div/div[3]/span")))
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[4]/div/div/div[3]/span")).click();
        test.pass("Close Popup if displayed.");

        completeBooking.continuePayment();
        test.pass("Click Continue.");

        completeBooking.airportPickupAndDrop();
        test.pass("Add Pick Up and Drop Details.");

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Flight_Booking") + "4. PickUp.png");

        completeBooking.proceedToPay();
        test.pass("Click Proceed To Pay.");

        Thread.sleep(5000);

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"));

        takeScreenshot(object_repository.getProperty("snapshot.EndToEnd.Flight_Booking") + "5. Checkout.png");
    }
}
