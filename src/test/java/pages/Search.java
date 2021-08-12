package pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search extends BasePage {

	public Search(WebDriver driver) {
		super(driver);
		driver.findElement(By.className("userLoggedOut")).click();
	}

	By oneWayTripRadioButton = By.cssSelector("li[data-cy='oneWayTrip']");
	By roundTripRadioButton = By.cssSelector("li[data-cy='roundTrip']");
	By multiCityRadioButton = By.cssSelector("li[data-cy='mulitiCityTrip']");

	By searchFromCity = By.className("searchCity");
	By searchFromCityInput = By.cssSelector("input[placeholder='From']");
	By selectFromCityFirstCity = By.id("react-autowhatever-1-section-0-item-0");

	By searchToCity = By.className("searchToCity");
	By searchToCityInput = By.cssSelector("input[placeholder='To']");
	By searchToCityFirstCity = By.id("react-autowhatever-1-section-0-item-0");

	By addAnotherCity = By.cssSelector("button[data-cy='addAnotherCity']");

	By searchButton = By.cssSelector(".primaryBtn.font24.latoBold.widgetSearchBtn");

	public void selectDate(String date) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date dateObj = null;
		try {
			dateObj = (Date) dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat dateFormatNew = new SimpleDateFormat("EEE MMM dd yyyy");
		String strDate = dateFormatNew.format(dateObj);

		driver.findElement(By.cssSelector("div[aria-label='" + strDate + "']")).click();
	}

	public void selectOneWayTrip() {
		if (!isOneWaySelected()) {
			driver.findElement(oneWayTripRadioButton).click();
		}
	}

	public void selectRoundTrip() {
		if (!isRoundTripSelected()) {
			driver.findElement(roundTripRadioButton).click();
		}
	}

	public void selectMultiCityTrip() {
		if (!isMultiCityTripSelected()) {
			driver.findElement(multiCityRadioButton).click();
		}
	}

	public void selectFromCity() {
		driver.findElement(searchFromCity).click();
	}

	public void selectToCity() {
		driver.findElement(searchToCity).click();
	}

	public boolean isOneWaySelected() {
		WebElement oneWayRadio = driver.findElement(oneWayTripRadioButton);
		String classes = oneWayRadio.getAttribute("class");
		return classes.contains("selected");
	}

	public boolean isRoundTripSelected() {
		WebElement roundTripRadio = driver.findElement(roundTripRadioButton);
		String classes = roundTripRadio.getAttribute("class");
		return classes.contains("selected");
	}

	public boolean isMultiCityTripSelected() {
		WebElement multiCityRadio = driver.findElement(multiCityRadioButton);
		String classes = multiCityRadio.getAttribute("class");
		return classes.contains("selected");
	}

	public void searchFromCity(String cityName) {
		waitTillVisibilityOfElement(searchFromCityInput);
		driver.findElement(searchFromCityInput).sendKeys(cityName);
		waitTillVisibilityOfElement(selectFromCityFirstCity);
		driver.findElement(selectFromCityFirstCity).click();
	}

	public void searchToCity(String cityName) {
		waitTillVisibilityOfElement(searchToCityInput);
		driver.findElement(searchToCityInput).sendKeys(cityName);
		waitTillVisibilityOfElement(searchToCityFirstCity);
		driver.findElement(searchToCityFirstCity).click();
	}

	public void searchFlights() {
		driver.findElement(searchButton).click();
	}

	public void addAnotherCity() {
		driver.findElement(addAnotherCity).click();
	}

	public void searchOneWayTripFlights(String from, String to, String departureDate) {
		selectOneWayTrip();
		driver.findElement(searchFromCity).click();
		searchFromCity(from);
		driver.findElement(searchToCity).click();
		searchToCity(to);
		selectDate(departureDate);
		searchFlights();
	}

	public void searchRoundTripFlights(String from, String to, String departureDate, String returnDate) {
		selectRoundTrip();
		driver.findElement(searchFromCity).click();
		searchFromCity(from);
		driver.findElement(searchToCity).click();
		searchToCity(to);
		selectDate(departureDate);
		selectDate(returnDate);
		searchFlights();
	}

	public void searchMultiCityTripFlights(List<String> cities, List<String> dates) {
		int noOfTrips = cities.size() - 1;
		selectMultiCityTrip();
		for (int i = 0; i < noOfTrips; i++) {
			driver.findElement(By.cssSelector("label[for='fromAnotherCity" + i + "']")).click();
			searchFromCity(cities.get(i));
			searchToCity(cities.get(i + 1));
			selectDate(dates.get(i));
//			if (noOfTrips > 2 && i >= 1) {
//				addAnotherCity();
//			}
			scrollPageVertically(100);
			System.out.println(i);
		}
		searchFlights();
	}
}
