package Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/Features", 
glue = "stepdefinations", 
dryRun = false,
plugin = {
		"pretty",
"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },
tags = "not @skip"
		)

public class runner extends AbstractTestNGCucumberTests {
	// This class serves as an entry point for the test execution
}