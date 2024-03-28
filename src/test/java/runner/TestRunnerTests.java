package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/FeatureFiles/Test.feature", glue = { "stepDefinitions",
		"utilities" }, tags = "@login", plugin = { "pretty", "html:target1/cucumber-reports" }, monochrome = true)

public class TestRunnerTests extends AbstractTestNGCucumberTests {

}
