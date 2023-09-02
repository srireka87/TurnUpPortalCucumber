
package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage
    {
        public void GoToTimeMaterialPage (WebDriver driver)

        {
            //Go to Administration tab
            WebElement adminTab = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a"));
            adminTab.click();

            Wait.WaitToBeClickable(driver, "XPath", "/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a", 7);

            //select the Time and Materials option from Administration Drop down menu
            WebElement timeMaterialOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a"));
            timeMaterialOption.click();
        }

        public void GoToEmployeesPage (WebDriver driver)
        {
            //Go to Administration tab
            WebElement adminTab = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a"));
            adminTab.click();

            //select the Employees Option from the drop down
            WebElement employeesOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[2]/a"));
            employeesOption.click();
        }

    }


    

