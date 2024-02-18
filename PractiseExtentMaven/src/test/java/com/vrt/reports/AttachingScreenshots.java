package com.vrt.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.ProcessHandle.Info;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttachingScreenshots {
static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		ExtentReports extent=new ExtentReports();	
		File file = new File("Reports.html");
		ExtentSparkReporter spark=new ExtentSparkReporter(file);
		extent.attachReporter(spark);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		String path = captureScreenshot("Google.jpg");
		
		
		extent.createTest("Screenshot Test1","This is for attaching the screenshots to Test at Test level")
		.info("This is info message")
		.addScreenCaptureFromBase64String(captureScreenshot());
		
		extent.createTest("Screenshot Test2","This is for attaching the screenshots to Test at Test level")
		.info("This is info message")
		.addScreenCaptureFromBase64String(captureScreenshot(), "Google Home page1")
		.addScreenCaptureFromBase64String(captureScreenshot(), "Google Home page2")
		.addScreenCaptureFromBase64String(captureScreenshot(), "Google Home page3")
		.addScreenCaptureFromBase64String(captureScreenshot(), "Google Home page4");
		

		extent.createTest("Screenshot Test3","This is for attaching the screenshots to Test at Test level")
		.info("This is info message")
		.addScreenCaptureFromPath(path, "Google Home page1")
		.addScreenCaptureFromPath(path, "Google Home page2")
		.addScreenCaptureFromPath(path, "Google Home page3")
		.addScreenCaptureFromPath(path, "Google Home page4");
		
		extent.createTest("Screenshot Test4","This is for attaching the screenshots to Test at Test level")
		.info("This is info message")
		.addScreenCaptureFromPath(path);
		
		
		
		//Adding screenshots at log level.
		extent.createTest("Screenshot Test5","This is for attaching the screenshots to Test at Log level")
		.info("This is info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot()).build());
		
		extent.createTest("Screenshot Test6","This is for attaching the screenshots to Test at Log level")
		.info("This is info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot(),"Google image").build());
		
		
		extent.createTest("Screenshot Test7","This is for attaching the screenshots to Test at Log level")
		.info("This is info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		extent.createTest("Screenshot Test8","This is for attaching the screenshots to Test at Log level")
		.info("This is info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google Home").build());
		
		
		
		//Lets use fail overloaded methods now.
		extent.createTest("Screenshot Test9","This is for attaching the screenshots to Test at Log level")
		.info("This is info message")
		.fail("This is fail message", MediaEntityBuilder.createScreenCaptureFromBase64String(path,"google image").build());
		
		
		Throwable t=new Throwable("This is throwable exception");
		extent.createTest("Screenshot Test9","This is for attaching the screenshots to Test at Log level")
		.info("This is info message")
		.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(path,"google image").build());
		
		
		extent.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("Reports.html").toURI());
			 
	}
	public static String captureScreenshot()
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		String base64code = screenshot.getScreenshotAs(OutputType.BASE64);
		return base64code;
	}
	
	 public static String captureScreenshot(String fileName)
		{
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File Dest=new File("./Screenshots/"+ fileName);
			try {
				FileUtils.copyFile(source, Dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Dest.getAbsolutePath();
		}

}
