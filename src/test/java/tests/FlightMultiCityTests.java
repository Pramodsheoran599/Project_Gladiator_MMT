package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.BaseTest;
import pages.FlightSearchResultsPage;
import pages.Search;


public class FlightMultiCityTests extends BaseTest {

    Search search;
    FlightSearchResultsPage flightSearchResults;
    
    @Test
    public void tc_multicity_flight_select02() {
        driver.get(object_repository.getProperty("homepage_url"));
        search = new Search(driver);

        List<String> cities = Arrays.asList(new String[] { "Mumbai", "Mumbai"});
        List<String> dates = Arrays.asList(new String[] { "20-08-2021"});
        search.searchMultiCityTripFlights(cities, dates);

        Assert.assertEquals(true, search.isSameCityErrorVisible());
    }

    @Test(dependsOnMethods="tc_multicity_flight_select02")
    public void tc_multicity_flight_select01() {
    	List<String> cities = Arrays.asList(new String[] { "Mumbai", "Delhi", "Bengaluru" });
        List<String> dates = Arrays.asList(new String[] { "20-08-2021", "23-08-2021" });
        search.searchMultiCityTripFlights(cities, dates);
        search.searchFlights();

        flightSearchResults = new FlightSearchResultsPage(driver);

        Assert.assertTrue(flightSearchResults.getCountOfFlights(true) > 0);
    }
}
