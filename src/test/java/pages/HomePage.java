package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    By login_button   = By.cssSelector("li[data-cy='account']");
    By flights_button = By.cssSelector("a[href='https://www.makemytrip.com/flights/']");
    By hotels_button  = By.cssSelector("a[href='https://www.makemytrip.com/hotels/']");


    public LoginPage goto_login_page()
    {
        driver.findElement(login_button).click();
        driver.findElement(login_button).click();
        return new LoginPage(driver);
    }

    public void goto_flights_page()
    {
        driver.findElement(flights_button).click();
    }

    public void goto_hotels_page()
    {
        driver.findElement(hotels_button).click();
    }
}
