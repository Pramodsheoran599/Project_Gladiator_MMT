package tests.moduleTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.BaseTest;
import pages.FlightSearchResultsPage;
import pages.Search;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class FlightOneWayTripTests extends BaseTest {

	ExtentTest tc;
    Search search;
    FlightSearchResultsPage flightSearchResults;
    
//----------------------------------------------------------------------------------------------------------------------    

//    @Test
//   	public void report()
//   	{
//   		extentReports=new ExtentReports();
//   		report.attachReporter(new ExtentHtmlReporter("FlightOneWayTripTests.html"));
//   	}
       
//----------------------------------------------------------------------------------------------------------------------
       
    @Test
    public void tc_flight_search02() throws InterruptedException
    {
        driver.get(object_repository.getProperty("homepage_url"));
        search = new Search(driver);

        search.selectFromCity();
        search.searchFromCity("Mumbai");
        search.searchToCity("Mumbai");

        Assert.assertEquals(true, search.isSameCityErrorVisible());
        
        tc=extentReports.createTest("tc_flight_search_02");
  	  	tc.info("valid creds");
    }
    
//----------------------------------------------------------------------------------------------------------------------
    
   
    @Test(dependsOnMethods = "tc_flight_search02")
    public void tc_flight_search01() {

        search.searchOneWayTripFlights("Mumbai", "Delhi", "15-08-2021");
        flightSearchResults = new FlightSearchResultsPage(driver);

        Assert.assertTrue(flightSearchResults.getCountOfFlights() > 0);

        tc=extentReports.createTest("tc_flight_search_01");
  	  	tc.info("valid creds");
    }
}