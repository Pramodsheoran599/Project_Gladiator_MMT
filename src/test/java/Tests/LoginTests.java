package Tests;

import Frameworks.BaseTest;
import Pages.HomePage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest
{
    @Test
    public void tc_login01()
    {
        driver.get("https://www.makemytrip.com");
        HomePage homePage = new HomePage(driver);

        homePage.goto_login_page();
    }
}
