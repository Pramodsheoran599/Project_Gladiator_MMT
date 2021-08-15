package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.BaseTest;
import pages.FlightSearchResultsPage;
import pages.Search;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class FlightMultiCityTests extends BaseTest {

	ExtentTest tc;
    Search search;
    FlightSearchResultsPage flightSearchResults;
    
//----------------------------------------------------------------------------------------------------------------------
    
    @Test
   	public void report()
   	{
   		report=new ExtentReports();
   		report.attachReporter(new ExtentHtmlReporter("FlightMultiCityTripTests.html"));
   	}
       
//----------------------------------------------------------------------------------------------------------------------

       
    @Test
    public void tc_multicity_flight_select02() {
        driver.get(object_repository.getProperty("homepage_url"));
        search = new Search(driver);

        List<String> cities = Arrays.asList(new String[] { "Mumbai", "Mumbai"});
        List<String> dates = Arrays.asList(new String[] { "20-08-2021"});
        search.searchMultiCityTripFlights(cities, dates);

        Assert.assertEquals(true, search.isSameCityErrorVisible());
        
        tc=report.createTest("tc_multicity_flight_select02");
  	  	tc.info("valid creds");
        
    }

//----------------------------------------------------------------------------------------------------------------------


    @Test(dependsOnMethods="tc_multicity_flight_select02")
    public void tc_multicity_flight_select01() {
    	List<String> cities = Arrays.asList(new String[] { "Mumbai", "Delhi", "Bengaluru" });
        List<String> dates = Arrays.asList(new String[] { "20-08-2021", "23-08-2021" });
        search.searchMultiCityTripFlights(cities, dates);
        search.searchFlights();

        flightSearchResults = new FlightSearchResultsPage(driver);

        Assert.assertTrue(flightSearchResults.getCountOfFlights(true) > 0);
        
        tc=report.createTest("tc_multicity_flight_select01");
  	  	tc.info("valid creds");
    }
}
