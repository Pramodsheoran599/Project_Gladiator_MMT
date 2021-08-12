package frameworks;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;


public abstract class MenuDriven
{
    public abstract void loadWebsite(WebDriver driver, String url) throws Exception;


    public void mainMenu(String url) throws Exception
    {
        WebDriver driver;
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("----------------------------------");
            System.out.println("      Make My Trip Testing       |");
            System.out.println("----------------------------------");
            System.out.println("                                 |");
            System.out.println(" 1. Test with Chrome             |");
            System.out.println(" 2. Test with FireFox.           |");
            System.out.println(" 3. Test with Internet Explorer. |");
            System.out.println(" 4. Exit.                        |");
            System.out.print  ("\n  Enter Your Choice : ");

            int choice = sc.nextInt();

            System.out.println("====================================\n");

            switch (choice)
            {
                case 1: driver = AllWebDrivers.setupDriver("chrome");
                        loadWebsite(driver, url);
                        break;

                case 2: driver = AllWebDrivers.setupDriver("firefox");
                        loadWebsite(driver, url);
                        break;

                case 3: driver = AllWebDrivers.setupDriver("internet_explorer");
                        loadWebsite(driver, url);
                        break;

                case 4: sc.close();
                        System.exit(0);

                default: System.out.println("Invalid Choice.");
            }
        }
    }
}

