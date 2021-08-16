package tests.moduleTests;

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


public class NewHotel extends BaseTest 

{
    HotelPage hotelPage;
    HomePage homepage;
    
//----------------------------------------------------------------------------------------------------------------------
    
    @Test(priority=1 , description="Home page should be displayed")			//for Searching Page
    public void tc_hotel_search01() throws Exception
    {
    	test = extentReports.createTest("tc_hotel_search01", "To go to Hotel Booking Page");
    	
        driver.get(object_repository.getProperty("homepage_url"));

        hotelPage = new HotelPage(driver);
        homepage = new HomePage(driver);
        homepage.goto_hotels_page();  
    }
    
//----------------------------------------------------------------------------------------------------------------------    
    
    @Test(priority=2, description="Hotels page should be displayed")		//for filling details Page
    public void tc_hotel_search02() throws Exception
    {
    	test = extentReports.createTest("tc_hotel_search02", "To fill the Hotel Booking details");
    	
        hotelPage.selectFromArea();
        hotelPage.searchFromArea("Goa");
        hotelPage.select_check_in_date();
        hotelPage.selectDates("19-08-2021");
        hotelPage.select_check_out_date();
        hotelPage.selectDates("22-08-2021");
        hotelPage.select_number_of_guests();
        hotelPage.searchadult_count();
        hotelPage.click_it();
        hotelPage.searchHotels();     
    }
    
//----------------------------------------------------------------------------------------------------------------------
    
    @Test(priority=3, description="To book a hotel")						//for Booking Page
    public void tc_hotel_book01() throws InterruptedException
    {
    	test = extentReports.createTest("tc_hotel_book01", "To fill the tavellers Hotel Booking details");
        driver.findElement(By.id("Listing_hotel_1")).click();

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
