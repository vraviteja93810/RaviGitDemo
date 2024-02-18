package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinitions",monochrome = true, 
tags="@Smoke or @Regression",dryRun=true,plugin= {"pretty","html:target/cucumber.html",
		"json:target/cucumber.json"})
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
