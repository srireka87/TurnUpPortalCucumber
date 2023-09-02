
package Pages;

import Utilities.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TimeMaterialPage

{
        public void CreateTimeRecord(WebDriver driver)
        {
            //Click Create New Button
            WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
            createNewButton.click();

            //Create New Page -Select the Typecode dropdown option (Time Material)
            WebElement typeCodeDropDown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[1]"));
            typeCodeDropDown.click();

            // Enter Code Value
            WebElement codeTextBox = driver.findElement(By.id("Code"));
            codeTextBox.sendKeys("Task7");

            //Enter Description 
            WebElement descriptionTextBox = driver.findElement(By.id("Description"));
            descriptionTextBox.sendKeys("Task7 Description");

            //Enter Price Unit
            WebElement priceTextBox = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
            priceTextBox.sendKeys("20");

            //Click Save Button
            WebElement saveButton = driver.findElement(By.id("SaveButton"));
            saveButton.click();

            Wait.WaitToBeClickable(driver, "XPath", "//*[@id=\"tmsGrid\"]/div[4]/a[4]/span", 5);

            //Go to the last page
            WebElement goToLastPage = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
            goToLastPage.click();
         
        }
        public void CreateRecordActualDataAssertion(WebDriver driver)
        { //select the last row of the records
            WebElement actualData = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
            Assert.assertEquals(actualData.getText(),"Task7","Time & Material New Record is not Matching" );
        }

        public void EditRecord(WebDriver driver)
        {
            //click the last page arrow button
            Wait.WaitToBeVisible(driver, "XPath", "//*[@id=\"tmsGrid\"]/div[4]/a[4]/span",5);

            WebElement editGoToLastPage = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
            editGoToLastPage.click();


            Wait.WaitToBeClickable(driver, "XPath", "//tbody/tr[last()]/td[5]/a[1]", 5);

            //Click Edit button
            WebElement editButton = driver.findElement(By.xpath("//tbody/tr[last()]/td[5]/a[1]"));
            editButton.click();

            //Select Typo Code
            WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[2]/span"));
            typeCodeDropdown.click();

            WebElement timeTypeCode = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
            timeTypeCode.click();

            //Enter Code
            WebElement editCodeTextBox = driver.findElement(By.id("Code"));
            editCodeTextBox.clear();
            editCodeTextBox.sendKeys("Java");

            //Enter Description
            WebElement editDescriptionTextBox = driver.findElement(By.id("Description"));
            editDescriptionTextBox.clear();
            editDescriptionTextBox.sendKeys("Selenium");

            //Enter Price
            WebElement editPriceOverlappingTag = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
            WebElement editPriceTextBox = driver.findElement(By.id("Price"));
            editPriceOverlappingTag.click();
            editPriceTextBox.clear();
            editPriceOverlappingTag.click();
            editPriceTextBox.sendKeys("500");

            //Click Save button
            WebElement editSaveButton = driver.findElement(By.id("SaveButton"));
            editSaveButton.click();
            
            Wait.WaitToBeVisible(driver, "XPath","//*[@id=\"tmsGrid\"]/div[4]/a[4]/span", 7);
     
            //go to last page and check the edited details
            WebElement editGoToLastPage1 = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
            editGoToLastPage1.click();

        }
        //For the Code Validation ,Returning the Actual Code Data
        public void EditedTMCodeAssertion(WebDriver driver)
        {
            WebElement editedCodeActualData = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
             Assert.assertEquals(editedCodeActualData.getText(),"Java","Edited Time & Material Code is not matching");
        }

        //For the Description Validation, returning the actual description data
        public void EditedTMDescreptionAssertion(WebDriver driver)
        {
            WebElement editedDescreptionActualData = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
            Assert.assertEquals(editedDescreptionActualData.getText(), "Selenium","Edited TM Description is not matching");
        }

        public void CloseTheDriver(WebDriver driver)
        {
            driver.quit();
        }

        public void DeleteRecord(WebDriver driver) throws InterruptedException {
            //Locate the Delete button and Click
            //Go to last page
                WebElement editGoToLastPage1 = driver.findElement(By.xpath(" //*[@id=\"tmsGrid\"]/div[4]/a[4]/span "));
                editGoToLastPage1.click();

                Wait.WaitToBeClickable(driver, "XPath", "//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[2]",5);

                WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
                deleteButton.click();

                //Pop up msg --switching to Alert
                Alert alert = driver.switchTo().alert();
                String alertMsg = driver.switchTo().alert().getText();
                System.out.println(alertMsg);
                Thread.sleep(4000);
                //click Ok
                alert.accept();
                
            }
             public void DeleteTMRecordAssertion(WebDriver driver)
              {
                  WebElement deletedActualData = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
                  System.out.println(deletedActualData.getText());
                 Assert.assertEquals(deletedActualData.getText(),"Java","Expected TM Record Deleted Successfully");
              }
            
    }
