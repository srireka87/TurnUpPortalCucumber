package Utilities;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Java IntelliJDE TestAutomation//TurnUpPortalCucumber//src//test//java//Features//TimeMaterialsFeature.feature",
        glue = {"StepDefinitions"}
)

public class TestRunner {

}


