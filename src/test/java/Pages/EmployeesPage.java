
package Pages;
import Utilities.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class EmployeesPage extends Wait
    {
        public void CreateEmployees(WebDriver driver) throws InterruptedException {

          //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //Click Create  Button for New Employees details

            WebElement createEmployeesButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
            createEmployeesButton.click();

            //Enter Employees Name
            WebElement employeeNameTextBox = driver.findElement(By.id("Name"));
            employeeNameTextBox.sendKeys("Joe");

            //Enter Username
            WebElement employeeUserNameTextBox = driver.findElement(By.id("Username"));
            employeeUserNameTextBox.sendKeys("Joe");

           //select Edit Contact button
            WebElement employeeEditContactButton = driver.findElement(By.id("EditContactButton"));
            employeeEditContactButton.click();

            //In create Employee --->EditContact fields-->Switching to new frame to enter Edit Contact Details

            //Switching to EditContact Page 
            driver.switchTo().frame(0);

            Wait.WaitToBeVisible(driver, "Id", "FirstName", 3);
            //Enter First Name in Edit Contact Employees Page
            WebElement firstNameEditContactTextBox = driver.findElement(By.id("FirstName"));
            firstNameEditContactTextBox.sendKeys("Joe");

            //Enter Last Name
            WebElement lastNameEditContactTextBox = driver.findElement(By.id("LastName"));
            lastNameEditContactTextBox.sendKeys("Zoe");

            //Enter Prefered Name
            WebElement preferdNameEditContactTeXtBox = driver.findElement(By.id("PreferedName"));
            preferdNameEditContactTeXtBox.sendKeys("bestie");

            //Enter Phone number
            WebElement phoneEditContactTeXtBox = driver.findElement(By.id("Phone"));
            phoneEditContactTeXtBox.sendKeys("86756456");

            //Enter Mobile number
            WebElement mobileEditContactTeXtBox = driver.findElement(By.id("Mobile"));
            mobileEditContactTeXtBox.sendKeys("67567576");

            //Enter Email number
            WebElement emailEditContactTeXtBox = driver.findElement(By.id("email"));
            emailEditContactTeXtBox.sendKeys("best@gmail.com");

            //Enter Fax number
            WebElement faxEditContactTeXtBox = driver.findElement(By.id("Fax"));
            faxEditContactTeXtBox.sendKeys("3223532");

            //Enter Address
            WebElement addressEditContactTeXtBox = driver.findElement(By.id("autocomplete"));
            // addressEditContactTeXtBox.SendKeys("34,sea street");

            //Enter Street
            WebElement streetEditContactTeXtBox = driver.findElement(By.id("Street"));
            streetEditContactTeXtBox.sendKeys(" 34,sea street");

            //Enter City
            WebElement cityEditContactTeXtBox = driver.findElement(By.id("City"));
            cityEditContactTeXtBox.sendKeys("CA");

            //Enter PostCode
            WebElement postEditContactTeXtBox = driver.findElement(By.id("Postcode"));
            postEditContactTeXtBox.sendKeys("3434");

            //EnterCountry
            WebElement countryEditContactTeXtBox = driver.findElement(By.id("Country"));
            countryEditContactTeXtBox.sendKeys("USA");

            //Click Save Contact button
            WebElement saveEditContactButton = driver.findElement(By.id("submitButton"));
            saveEditContactButton.click();

            //switching to origin window
            driver.switchTo().defaultContent();

            Wait.WaitToBeVisible(driver, "Id", "Password", 3);

            //Enter Password
            WebElement employeePasswordTextBox = driver.findElement(By.id("Password"));
            employeePasswordTextBox.sendKeys("Ready@go1");

            //Enter Retype Password
            WebElement employeeReTypePasswordTextBox = driver.findElement(By.id("RetypePassword"));
            employeeReTypePasswordTextBox.sendKeys("Ready@go1");

            //Check IsAdmin Check box
            WebElement employeeIsAdminCheckBox = driver.findElement(By.id("IsAdmin"));
            employeeIsAdminCheckBox.click();

            //Enter Vehicle
            WebElement employeeVehicleTextBox = driver.findElement(By.name("VehicleId_input"));
            employeeVehicleTextBox.sendKeys("swift");

            //Select  Groups dropdown list

            Wait.WaitToBeVisible(driver, "XPath", "//div[@class='k-multiselect-wrap k-floatwrap']", 3);
            WebElement groupLists = driver.findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']"));
            groupLists.click();
          
          //Select the Group from the list
            Wait.WaitToBeVisible(driver, "XPath", "//div[@id='groupList-list']/ul/li[3]",5);
            WebElement listoption1 = driver.findElement(By.xpath("//div[@id='groupList-list']/ul/li[3]"));
            listoption1.click();
            Thread.sleep(4000);

            //Click Save Contact Button
            WebElement employeeSaveButton = driver.findElement(By.id("SaveButton"));
            employeeSaveButton.click();
            Wait.WaitToBeClickable(driver, "Id", "SaveButton", 3);

            WebElement backToListLink = driver.findElement(By.linkText("Back to List"));
            backToListLink.click();

            Wait.WaitToBeVisible(driver,"XPath","//*[@id=\"usersGrid\"]/div[4]/a[4]/span",3);

            //GoToLastPage arrowbutton click
            WebElement goToLastPage = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[4]/a[4]/span"));
            goToLastPage.click();

            //Validation with actual Employee data with Expected data ,in this case"Emma"
            Wait.WaitToBeVisible(driver,"XPath", "//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]",3);

            //Finding the ActualData after Creating a new Employee
            WebElement actualCreateEmployeeData = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
            System.out.println(actualCreateEmployeeData.getText());


          Assert.assertEquals(actualCreateEmployeeData.getText() == "Joe","New Employee record was Unsuccessful");
        }

        public void EditEmployees(WebDriver driver)
        {
            //GotoLastPage
            WebElement goToLastPageArrowButton = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[4]/a[4]/span"));
            goToLastPageArrowButton.click();

            //Click the Edit Button
            WebElement editEmployeesButton = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[1]"));
            editEmployeesButton.click();

            //Enter EditEmployees Name
            WebElement employeeNameTextBox = driver.findElement(By.id("Name"));
             employeeNameTextBox.clear();
            employeeNameTextBox.sendKeys("Mercy");

            //Enter EditUsername
            WebElement employeeUserNameTextBox = driver.findElement(By.id("Username"));
            employeeUserNameTextBox.clear();
            employeeUserNameTextBox.sendKeys("Mercy");

            //select Edit Contact button
            WebElement employeeEditContactButton = driver.findElement(By.id("EditContactButton"));
            employeeEditContactButton.click();

            // Switching to EditContact Page
            driver.switchTo().frame(0);

            Wait.WaitToBeVisible(driver, "Id", "FirstName", 3);
            //Enter First Name in Edit Contact Employees Page
            WebElement firstNameEditContactTextBox = driver.findElement(By.id("FirstName"));
            firstNameEditContactTextBox.clear();
            firstNameEditContactTextBox.sendKeys("Mercy");

            //Enter Last Name
            WebElement lastNameEditContactTextBox = driver.findElement(By.id("LastName"));
            lastNameEditContactTextBox.clear();
            lastNameEditContactTextBox.sendKeys("Sweety");

            //Enter Prefered Name
            WebElement preferdNameEditContactTeXtBox = driver.findElement(By.id("PreferedName"));
            preferdNameEditContactTeXtBox.clear();
            preferdNameEditContactTeXtBox.sendKeys("beautifulful");

            //Enter Phone number
            WebElement phoneEditContactTeXtBox = driver.findElement(By.id("Phone"));
            phoneEditContactTeXtBox.clear();
            phoneEditContactTeXtBox.sendKeys("5555555");

            //Enter Mobile number
            WebElement mobileEditContactTeXtBox = driver.findElement(By.id("Mobile"));
            mobileEditContactTeXtBox.clear();
            mobileEditContactTeXtBox.sendKeys("3333333");

            //Enter Email number
            WebElement emailEditContactTeXtBox = driver.findElement(By.id("email"));
            emailEditContactTeXtBox.clear();
            emailEditContactTeXtBox.sendKeys("beauty@gmail.com");

            //Enter Fax number
            WebElement faxEditContactTeXtBox = driver.findElement(By.id("Fax"));
            faxEditContactTeXtBox.clear();
            faxEditContactTeXtBox.sendKeys("3223532");

            //Enter Address
            WebElement addressEditContactTeXtBox = driver.findElement(By.id("autocomplete"));
            //addressEditContactTeXtBox.SendKeys("34,sea street");

            //Enter Street
            WebElement streetEditContactTeXtBox = driver.findElement(By.id("Street"));
            streetEditContactTeXtBox.clear();
            streetEditContactTeXtBox.sendKeys(" 44,seaview street");

            //Enter City
            WebElement cityEditContactTeXtBox = driver.findElement(By.id("City"));
            cityEditContactTeXtBox.clear();
            cityEditContactTeXtBox.sendKeys("Florida");

            //Enter PostCode
            WebElement postEditContactTeXtBox = driver.findElement(By.id("Postcode"));
            postEditContactTeXtBox.clear();
            postEditContactTeXtBox.sendKeys("4545");

            //EnterCountry
            WebElement countryEditContactTeXtBox = driver.findElement(By.id("Country"));
            countryEditContactTeXtBox.clear();
            countryEditContactTeXtBox.sendKeys("USA");

            //Click Save Contact button
            WebElement saveEditContactButton = driver.findElement(By.id("submitButton"));
            saveEditContactButton.click();

            //switching to origin window
            driver.switchTo().defaultContent();

            Wait.WaitToBeVisible(driver, "Id", "Password", 3);

            //Enter Password
            WebElement employeePasswordTextBox = driver.findElement(By.id("Password"));
            employeePasswordTextBox.clear();
            employeePasswordTextBox.sendKeys("Steady@go1");

            //Enter Retype Password
            WebElement employeeReTypePasswordTextBox = driver.findElement(By.id("RetypePassword"));
            employeeReTypePasswordTextBox.clear();
            employeeReTypePasswordTextBox.sendKeys("Steady@go1");

            //Check IsAdmin Check box
            WebElement employeeIsAdminCheckBox = driver.findElement(By.id("IsAdmin"));
            employeeIsAdminCheckBox.click();

            //Enter Vehicle
            WebElement employeeVehicleTextBox = driver.findElement(By.name("VehicleId_input"));
            employeeVehicleTextBox.clear();
            employeeVehicleTextBox.sendKeys("BMW");

            //Group
            //UnSelect  Groups dropdown list

            Wait.WaitToBeVisible(driver, "XPath", "//div[@class='k-multiselect-wrap k-floatwrap']", 3);
            WebElement groupLists = driver.findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']"));
            groupLists.click();

            //unSelect the Group from the list
            WebElement deselectList = driver.findElement(By.xpath("//*[@id='groupList_taglist']/li/span[2]"));
            Wait.WaitToBeVisible(driver, "XPath", "//*[@id='groupList_taglist']/li/span[2]", 4);
            deselectList.click();
           // Thread.Sleep(4000);

            //Click Save Contact Button
            WebElement employeeSaveButton = driver.findElement(By.id("SaveButton"));
            employeeSaveButton.click();
            Wait.WaitToBeClickable(driver, "Id", "SaveButton", 3);

            WebElement backToListLink = driver.findElement(By.linkText("Back to List"));
            backToListLink.click();

            Wait.WaitToBeVisible(driver, "XPath", "//*[@id=\"usersGrid\"]/div[4]/a[4]/span", 5);

            //go to last page and check the edited details
            WebElement editGoToLastPage1 = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[4]/a[4]/span"));
            editGoToLastPage1.click();

            WebElement afterEditingActualData = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
            Assert.assertEquals(afterEditingActualData.getText() == "Mercy", "Actual Data and Expected Data are not matching");
        }
        public void DeleteEmployees(WebDriver driver) throws InterruptedException {
            //Go to last page 
            WebElement editGoToLastPage1 = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[4]/a[4]/span"));
            editGoToLastPage1.click();


            Wait.WaitToBeVisible(driver, "XPath", "//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[2]",5);

            //Locating Delete Button
            WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[2]"));
            deleteButton.click();

            Thread.sleep(3000);

            Alert alert = driver.switchTo().alert();

            String alertText = driver.switchTo().alert().getText();
            System.out.println(alertText);

            alert.accept();
            
           // Validation
            WebElement deleteActualData =driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
            Assert.assertEquals(deleteActualData.getText() !="Mercy","Expected Employee Records undeleted");
        } 
    }
