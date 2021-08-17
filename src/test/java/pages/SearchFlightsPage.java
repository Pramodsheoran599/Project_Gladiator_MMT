package pages;

import frameworks.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFlightsPage extends BasePage
{
	public SearchFlightsPage(WebDriver driver)
	{
		super(driver);
	}

	By oneWayTripRadioButton = object_repository.getLocator("flights.oneWayTripRadioButton");
	By roundTripRadioButton  = object_repository.getLocator("flights.roundTripRadioButton");
	By multiCityRadioButton  = object_repository.getLocator("flights.multiCityRadioButton");

	By searchFromCity = object_repository.getLocator("flights.fromCity");
	By searchFromCityInput = object_repository.getLocator("flights.fromCityInput");
	By selectFromCityFirstCity = object_repository.getLocator("flights.firstFromCity");

	By swapCity = object_repository.getLocator("flights.swapCity");

	By searchToCity = object_repository.getLocator("flights.toCity");
	By searchToCityInput = object_repository.getLocator("flights.toCityInput");
	By searchToCityFirstCity = object_repository.getLocator("flights.firstToCity");

	By departureDate = object_repository.getLocator("flights.departureDate");
	By date = object_repository.getLocator("flights.Date");

	By travellers = object_repository.getLocator("flights.travellers");
	By noOfAdults = object_repository.getLocator("flights.Adults");
	By noOfChildren = object_repository.getLocator("flights.Children");
	By noOfInfants = object_repository.getLocator("flights.infants");
	By travelClass = object_repository.getLocator("flights.travel.AllCass");
	By travelApplyButton = object_repository.getLocator("flights.travellers.apply");

	By addAnotherCity = object_repository.getLocator("flights.addAnotherCity");
	By sameCityError = object_repository.getLocator("flights.sameCityError");
	By searchButton = object_repository.getLocator("flights.searchButton");

	By firstFlightPrices = object_repository.getLocator("searchedFlights.viewPrices");
	By firstFlightBookButton = object_repository.getLocator("searchedFlights.BookNow");


	public void selectFromCity(String cityName) throws InterruptedException
	{
		findElement(searchFromCity).click();
		findElement(searchFromCityInput).sendKeys(cityName);
		Thread.sleep(500);
		findElement(selectFromCityFirstCity).click();
	}

	public void selectToCity(String cityName) throws InterruptedException
	{
//		findElement(searchToCity).click();                    //Auto Click Happens From Previous Step
		findElement(searchToCityInput).sendKeys(cityName);
		Thread.sleep(1000);
		findElement(searchToCityFirstCity).click();
	}

	public void swapCities()
	{
		findElement(swapCity).click();
	}

	public void selectDepartureDate()
	{
//		findElement(departureDate).click();					//Auto Click Happens From Previous Step
		findElement(date).click();
	}

	public void selectTravellers()
	{
		findElement(travellers).click();
		findElement(noOfAdults).click();
		findElement(noOfChildren).click();
		findElement(noOfInfants).click();
		findElement(travelClass).click();
		findElement(travelApplyButton).click();
	}

	public void search()
	{
		findElement(searchButton).click();
	}

	public void selectFirstFlight()
	{
		waitTillVisibilityOfElement(firstFlightPrices);
		findElement(firstFlightPrices).click();
		findElement(firstFlightBookButton).click();
	}
}
