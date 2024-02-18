package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	WebDriver driver;
	TestContextSetup testcontextsetup;
public Hooks(TestContextSetup testcontextsetup)
{
	this.testcontextsetup=testcontextsetup;
}
	@After
	public void AfterScenario() throws IOException
	{
		testcontextsetup.testbase.webdriverManager().quit();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException
	{
		driver = testcontextsetup.testbase.webdriverManager();
		if(scenario.isFailed())
		{
			 
			System.out.println("I am here");
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(src);
            scenario.attach(fileContent,"image/png/jpg","image");
		}
		
	}
}
