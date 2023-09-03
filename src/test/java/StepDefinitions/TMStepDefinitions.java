package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TimeMaterialPage;
import Utilities.CommonDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TMStepDefinitions extends CommonDriver {
    LoginPage loginPageObj = new LoginPage();
    HomePage homePageObj = new HomePage();
    TimeMaterialPage timeMaterialPageObj = new TimeMaterialPage();

    @Given("I logged in to Turn Up Portal successfully")
    public void i_logged_in_to_turn_up_portal_successfully() {
        driver = new ChromeDriver();
        loginPageObj.LoginFunction(driver);

    }
    @Given("I navigate to Time and Materials Page")
    public void i_navigate_to_time_and_materials_page() {
        homePageObj.GoToTimeMaterialPage(driver);
    }

    @When("I create a new time records")
    public void i_create_a_new_time_records() {
        timeMaterialPageObj.CreateTimeRecord(driver);
    }
    @Then("the new record should be created successfully")
    public void the_new_record_should_be_created_successfully() {
        String newActualData = timeMaterialPageObj.GetActualData(driver);
        Assert.assertEquals(newActualData, "Task7", "New Record is not matching and Unsuccessful");
        timeMaterialPageObj.CloseTheDriver(driver);
    }

    @When("I  update {string} {string}on existing Time Records")
    public void iUpdateCodeDescriptionOnExistingTimeRecords(String code,String description) {
        timeMaterialPageObj.EditRecord(driver, code,description);
    }
    @Then("the record should have updated {string} {string}")
    public void theRecordShouldHaveUpdatedCodeDescription(String code,String description) {
        String editActualcode = timeMaterialPageObj.GetEditedCode(driver);
        String editActualDescription = timeMaterialPageObj.GetEditedDescrption(driver);
        Assert.assertEquals(editActualcode, code, "Actual code and Expected Code are not matching");
        Assert.assertEquals(editActualDescription, description, "Actual Descriptions and Edited Descriptions are not matching");
        timeMaterialPageObj.CloseTheDriver(driver);
    }
    @When("I delete a New Time Material Record")
    public void iDeleteANewTimeMaterialRecord() throws InterruptedException {
        timeMaterialPageObj.DeleteRecord(driver);
    }

    @Then("The existing record should be deleted successfully")
    public void theExistingRecordShouldBeDeletedSuccessfully() {
        String deletedActualData1 = timeMaterialPageObj.GetDeleteTMRecord(driver);
        Assert.assertEquals(deletedActualData1, "Paper45@", "Expected Time and Records undeleted");
        timeMaterialPageObj.CloseTheDriver(driver);
    }
}
