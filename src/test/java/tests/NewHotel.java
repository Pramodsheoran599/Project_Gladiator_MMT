package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import frameworks.BaseTest;
import pages.HomePage;
import pages.HotelPage;

public class NewHotel extends BaseTest {

    HotelPage hotelPage;
    HomePage homepage;


    @Test(priority=1)			//for Searching Page
    public void tc_hotel_book01() throws Exception
    {
        driver.get(object_repository.getProperty("homepage_url"));

        hotelPage = new HotelPage(driver);
        homepage = new HomePage(driver);
        homepage.goto_hotels_page();

        hotelPage.selectFromArea();
        hotelPage.searchFromArea("Goa");
        hotelPage.select_check_in_date();
        hotelPage.selectDates("17-08-2021");
        hotelPage.select_check_out_date();
        hotelPage.selectDates("20-08-2021");
        hotelPage.select_number_of_guests();
        hotelPage.searchadult_count();
        hotelPage.click_it();
        hotelPage.searchHotels();

    }

    @Test(priority=2)		//for Booking Page
    public void tc_hotel_book02() throws InterruptedException {
        driver.findElement(By.id("Listing_hotel_1")).click();

        // Thread.sleep(5000);

        Set<String> Win = driver.getWindowHandles();
        List<String> allWin = new ArrayList<>(Win);

        driver.switchTo().window(allWin.get(1));

        driver.findElement(By.id("detpg_headerright_book_now")).click();

        Thread.sleep(5000);

        WebElement E = driver.findElement(By.id("title"));
        Select title = new Select(E);
        title.selectByVisibleText("Mr");

        driver.findElement(By.id("fName")).sendKeys("Pramod");
        driver.findElement(By.id("lName")).sendKeys("Sheoran");
        driver.findElement(By.id("email")).sendKeys("pramodsheoran599@gmail.com");
        driver.findElement(By.id("mNo")).sendKeys("7021521142");
        driver.findElement(By.linkText("PAY NOW")).click();

        Thread.sleep(5000);
    }
}
