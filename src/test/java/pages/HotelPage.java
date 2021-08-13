package pages;

import frameworks.BasePage;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

public class HotelPage extends BasePage
{

    public HotelPage(WebDriver driver) {
        super(driver);
        driver.findElement(By.className("userLoggedOut")).click();
    }

    By hotels_button = By.cssSelector("a[href='https://www.makemytrip.com/hotels/']");

    By searchFromArea = By.id("city");
    By searchFromAreaInput = By.cssSelector("input[placeholder='Enter city/ Hotel/ Area/ Building']");
    By selectFromAreaFirstArea = By.xpath("//p[normalize-space()='Goa, India']");
    By check_in_date = By.id("checkin");
    By check_out_date=By.xpath("//span[@data-cy='selectCheckOutDate']");
    By number_of_guests=By.id("guest");
    By adult_count = By.className("selected");
    By click = By.cssSelector("button[data-cy='submitGuest']");
    By searchButton = By.cssSelector(".primaryBtn.font24.latoBold.widgetSearchBtn");





    public void goto_hotels_page() {
        driver.findElement(hotels_button).click();
    }

    public void selectFromArea() {
        driver.findElement(searchFromArea).click();
    }

    public void searchFromAreaFirstArea() {
        driver.findElement(selectFromAreaFirstArea).click();

    }




    public void searchFromArea(String cityName) {
        waitTillVisibilityOfElement(searchFromAreaInput);
        driver.findElement(searchFromAreaInput).sendKeys(cityName);
        waitTillVisibilityOfElement(selectFromAreaFirstArea);
        driver.findElement(selectFromAreaFirstArea).click();
    }

    public void select_check_in_date() {
        driver.findElement(check_in_date).click();
    }

    public void select_check_out_date() {
        driver.findElement(check_out_date).click();
    }

    public void select_number_of_guests() {
        driver.findElement(number_of_guests).click();

    }
    public void searchadult_count() {
        driver.findElement(adult_count).click();

    }

    public void click_it() {
        driver.findElement(click).click();

    }




    public void selectDates(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateObj = null;
        try {
            dateObj = (Date) dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat dateFormatNew = new SimpleDateFormat("EEE MMM dd yyyy");
        String strDate = dateFormatNew.format(dateObj);

        driver.findElement(By.xpath("//div[@aria-label='" + strDate + "']")).click();
    }

    public void selectDates2(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateObj = null;
        try {
            dateObj = (Date) dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat dateFormatNew = new SimpleDateFormat("EEE MMM dd yyyy");
        String endDate = dateFormatNew.format(dateObj);

        driver.findElement(By.xpath("//div[@aria-label='" + endDate + "']")).click();
    }



    public void searchHotels() {
        driver.findElement(searchButton).click();
    }





}