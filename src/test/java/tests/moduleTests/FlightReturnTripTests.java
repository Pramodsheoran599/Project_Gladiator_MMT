package tests.moduleTests;
//
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import frameworks.BaseTest;
//import pages.FlightSearchResultsPage;
//import pages.Search;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
//public class FlightReturnTripTests extends BaseTest {
//
//
//    Search search;
//    FlightSearchResultsPage flightSearchResults;
//
////----------------------------------------------------------------------------------------------------------------------
//
////    @Test
////   	public void report()
////   	{
////   		report=new ExtentReports();
////   		report.attachReporter(new ExtentHtmlReporter("FlightReturnTripTests.html"));
////   	}
//
////----------------------------------------------------------------------------------------------------------------------
//
//
//    @Test
//    public void tc_return_flight_search_01() throws InterruptedException
//    {
//
//        driver.get(object_repository.getProperty("homepage_url"));
//        search = new Search(driver);
//        search.isOneWaySelected();
//        search.selectFromCity();
//        search.searchFromCity("Mumbai");
//        search.searchToCity("Bengaluru");
//        search.selectDate("20-08-2021");
//        driver.findElement(By.cssSelector("div[data-cy='returnArea']")).click();
//        search.selectDate("20-08-2021");
//
//        Assert.assertEquals(true, search.isRoundTripSelected());
//
//
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test(dependsOnMethods = "tc_return_flight_search_01")
//    public void tc_return_flight_search_02()
//    {
//    	test = extentReports.createTest("tc_return_flight_search_02", "To go to ReturnTripFlights Booking Page and check if one way is selected");
//
//        driver.findElement(By.cssSelector(".returnCross.landingSprite")).click();
//
//        Assert.assertEquals(true, search.isOneWaySelected());
//
//
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//
//    @Test(dependsOnMethods = "tc_return_flight_search_02")
//    public void tc_return_flight_search_03()
//    {
//
//        search.selectRoundTrip();
//        search.searchFlights();
//
//        flightSearchResults = new FlightSearchResultsPage(driver);
//
//        Assert.assertTrue(driver.getTitle().equals("MakeMyTrip"));
//        Assert.assertTrue(flightSearchResults.getCountOfFlights() > 0);
//
//
//    }
//}


//package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.BaseTest;
import pages.FlightSearchResultsPage;
import pages.Search;

public class FlightReturnTripTests extends BaseTest {

    Search search;
    FlightSearchResultsPage flightSearchResults;
    
    @Test
    public void tc_return_flight_search_01() throws InterruptedException
    {
        test = extentReports.createTest("tc_flight_search02",
    			"To test flights search with same arrival and departure  destination");
        driver.get(object_repository.getProperty("homepage_url"));
        search = new Search(driver);
        search.isOneWaySelected();
        search.selectFromCity();
        search.searchFromCity("Mumbai");
        search.searchToCity("Bengaluru");
        search.selectDate("20-08-2021");
        driver.findElement(By.cssSelector("div[data-cy='returnArea']")).click();
        search.selectDate("20-08-2021");

        Assert.assertEquals(true, search.isRoundTripSelected());
    }

    @Test(dependsOnMethods = "tc_return_flight_search_01")
    public void tc_return_flight_search_02() {
        driver.findElement(By.cssSelector(".returnCross.landingSprite")).click();

        Assert.assertEquals(true, search.isOneWaySelected());
    }

    @Test(dependsOnMethods = "tc_return_flight_search_02")
    public void tc_return_flight_search_03() {
        search.selectRoundTrip();
        search.searchFromCity("Mumbai");
        search.searchToCity("Bengaluru");
        search.selectDate("20-08-2021");
        driver.findElement(By.cssSelector("div[data-cy='returnArea']")).click();
        search.selectDate("20-08-2021");
        search.searchFlights();

        flightSearchResults = new FlightSearchResultsPage(driver);

        Assert.assertTrue(driver.getTitle().equals("MakeMyTrip"));
        Assert.assertTrue(flightSearchResults.getCountOfFlights() > 0);
    }

    @Test(dependsOnMethods = "tc_return_flight_search_03")
    public void tc_return_flight_select_01() throws InterruptedException {
        driver.findElement(By.cssSelector("span[xpath='1']")).click();
        driver.findElement(By.xpath("//*[@id=\"flightCard-69\"]/div/div[2]/div[2]/span")).click();
        Thread.sleep(5000);
    }

}