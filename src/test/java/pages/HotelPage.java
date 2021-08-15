package pages;

import com.aventstack.extentreports.reporter.configuration.Theme;
import frameworks.BasePage;
import org.openqa.selenium.NoSuchElementException;
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
    }


    By hotels = object_repository.getLocator("homepage.hotels");

    By searchFromArea = object_repository.getLocator("hotelsPage.searchFromArea");
    By searchFromAreaInput = object_repository.getLocator("hotelsPage.searchFromAreaInput");
    By selectFromAreaFirstArea = object_repository.getLocator("hotelsPage.selectFromAreaFirstArea");

    By check_in_date = object_repository.getLocator("hotelsPage.check_in_date");
    By check_out_date=object_repository.getLocator("hotelsPage.check_out_date");

    By number_of_guests=object_repository.getLocator("hotelsPage.number_of_guests");
    By adult_count = object_repository.getLocator("hotelsPage.adult_count");
    By click = object_repository.getLocator("hotelsPage.click");

    By searchButton = object_repository.getLocator("hotelsPage.searchButton");


    public void goto_hotels_page() throws InterruptedException
    {
        try
        {
            if (driver.findElement(By.cssSelector("div[class='autopop__wrap makeFlex column defaultCursor']")).isDisplayed())
                driver.findElement(object_repository.getLocator("homepage.login_button")).click();

            driver.findElement(hotels).click();
        }
        catch (NoSuchElementException e)
        {
            driver.findElement(hotels).click();
        }

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