package pages;

import frameworks.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CompleteYourFlightBooking extends BasePage
{
    public CompleteYourFlightBooking(WebDriver driver)
    {
        super(driver);
    }

    By insurance    = object_repository.getLocator("completeBooking.insurance");
    By addTraveller = object_repository.getLocator("completeBooking.addTraveller");

    By traveller_firstMiddleName = object_repository.getLocator("completeBooking.traveller_firstMiddleName");
    By traveller_lastName = object_repository.getLocator("completeBooking.traveller_lastName");
    By travellerAdultMale = object_repository.getLocator("completeBooking.travellerAdultMale");
    By travellerChildMale = object_repository.getLocator("completeBooking.travellerChildMale");
    By continueButton     = object_repository.getLocator("completeBooking.continueButton");
    By continueToPayment  = object_repository.getLocator("completeBooking.continueToPayment");
    By confirmButton      = object_repository.getLocator("completeBooking.confirmButton");

    By checkBox  = object_repository.getLocator("completeBooking.allCheckBoxes");
    By payButton = object_repository.getLocator("completeBooking.proceedToPay");

//----------------------------------------------------------------------------------------------------------------------

    public void addInsurance() throws InterruptedException
    {
        scrollTillElement(insurance);
        Thread.sleep(2000);
        findElement(insurance).click();
    }

//----------------------------------------------------------------------------------------------------------------------
    public void addTravellers(List<String> adults, List<String> children) throws InterruptedException
    {
        scrollPageVertically(100);
        List<WebElement> adults_children = driver.findElements(addTraveller);
        Thread.sleep(1000);
        adults_children.get(0).click();
        adults_children.get(1).click();

        List<WebElement> firstMiddleNames = driver.findElements(traveller_firstMiddleName);
        List<WebElement> lastNames = driver.findElements(traveller_lastName);

        firstMiddleNames.get(0).sendKeys(adults.get(0));
        lastNames.get(0).sendKeys(adults.get(1));
        findElement(travellerAdultMale).click();

        firstMiddleNames.get(1).sendKeys(children.get(0));
        lastNames.get(1).sendKeys(children.get(1));
        findElement(travellerChildMale).click();

        driver.findElement(By.className("travellerListText")).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void clickContinue()
    {
        findElement(continueButton).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void continuePayment()
    {
        findElement(continueToPayment).click();
        findElement(By.className("reviewAddonsBtn")).click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void clickConfirm()
    {
        findElement(confirmButton).click();
    }

    public void airportPickupAndDrop() throws InterruptedException
    {
        Thread.sleep(4000);
        List<WebElement> allCheckBoxes = driver.findElements(checkBox);

        for (WebElement checkbox : allCheckBoxes)
        {
            checkbox.click();
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    public void proceedToPay()
    {
        findElement(payButton).click();
    }
}
//----------------------------------------------------------------------------------------------------------------------