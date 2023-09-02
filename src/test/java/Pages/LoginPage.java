package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage
    {
        public void LoginFunction(WebDriver driver)
        {

            driver.manage().window().maximize();
            driver.navigate().to("http://horse.industryconnect.io/Account/Login?ReturnUrl=%2f");
    
            WebElement usernameTextbox = driver.findElement(By.id("UserName"));
            usernameTextbox.sendKeys("hari");

            WebElement passwordTextbox= driver.findElement(By.id("Password"));
            passwordTextbox.sendKeys("123123");

            Wait.WaitToBeClickable(driver, "XPath", "//*[@id=\"loginForm\"]/form/div[3]/input[1]", 5);

            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/input[1]"));
            loginButton.click();


            WebElement hariHari = driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul/li/a"));

           Assert.assertEquals(hariHari.getText(), "Hello hari!", "Login Unsuccessful");

           
           
        }


    }

