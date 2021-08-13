package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingPage 
{
    WebDriver driver;

    public BookingPage(WebDriver driver)
    {
        this.driver = driver;
    }
    
    // checking for view details button
    By ViewPrices   = By.xpath("//*[@id=\"bookbutton-RKEY:e96aced1-667f-4637-8a5a-25134c7020d5:0_0\"]/span[1]");
   //checking for book button
    By BookNow = By.xpath("//*[@id=\"bookbutton-RKEY:e96aced1-667f-4637-8a5a-25134c7020d5:0_0\"]");
   

    public void goto_Booking_Page()
    {
        driver.findElement(ViewPrices).click();
    }

    public void goto_BookingPage() 
    {
        driver.findElement(BookNow).click();
    }

   
}
