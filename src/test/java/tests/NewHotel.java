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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class NewHotel extends BaseTest {
	
	ExtentTest tc;
    HotelPage hotelPage;
    HomePage homepage;

//----------------------------------------------------------------------------------------------------------------------
   
    @Test
	public void report()
	{
		report=new ExtentReports();
		report.attachReporter(new ExtentHtmlReporter("NewHotel.html"));
	}
    
//----------------------------------------------------------------------------------------------------------------------

    
    @Test(priority=1 , description="Home page should be displayed")			//for Searching Page
    public void tc_hotel_search01() throws Exception
    {
        driver.get(object_repository.getProperty("homepage_url"));

        hotelPage = new HotelPage(driver);
        homepage = new HomePage(driver);
        homepage.goto_hotels_page();
        
        tc=report.createTest("tc_hotel_search01");
  	  	tc.info("valid creds");
  	  
        
    }
    
//----------------------------------------------------------------------------------------------------------------------    
    
    @Test(priority=2, description="Hotels page should be displayed")			//for filling details Page
    public void tc_hotel_search02() throws Exception
    {
       
    

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
        
        tc=report.createTest("tc_hotel_search02");
  	  	tc.info("valid creds");
    }
    
//----------------------------------------------------------------------------------------------------------------------
    

    @Test(priority=3, description="To book a hotel")		//for Booking Page
    public void tc_hotel_book01() throws InterruptedException {
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
        
        tc=report.createTest("tc_hotel_book01");
        tc.info("valid creds");
  	  

        Thread.sleep(5000);
    }
}
