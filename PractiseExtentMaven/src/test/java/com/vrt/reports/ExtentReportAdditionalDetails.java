package com.vrt.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportAdditionalDetails {
public static void main(String[] args) throws IOException {
	ExtentReports extent=new ExtentReports();	
	File file = new File("Reports.html");
	ExtentSparkReporter spark=new ExtentSparkReporter(file);
	extent.attachReporter(spark);
	
	
	extent.setSystemInfo("OS",System.getProperty("os.name"));
	extent.setSystemInfo("Java version",System.getProperty("java.version"));
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
	extent.setSystemInfo("Browser",capabilities.getBrowserName()+capabilities.getBrowserVersion());
	extent.setSystemInfo("APP URL","www.raviteja.com");
	extent.setSystemInfo("user Name","Raviteja");
	extent.setSystemInfo("Password", "12345");
	
	extent
	.createTest("Test 1","Test desc")
	.assignAuthor("Raviteja")
	.assignCategory("Smoke")
	.assignDevice("chrome 99")
	.pass("This is a passed test");
	
	extent
	.createTest("Test 2","Test desc")
	.assignAuthor("prasad")
	.assignCategory("Sanity")
	.assignDevice("edge 99")
	.fail("This is a failed test");
	
	extent
	.createTest("Test 3","Test desc")
	.assignCategory("Regression")
	.assignAuthor("Reddibabu")
	.assignDevice("Firefox 80")
	.fail("This is a failed test");
	
	extent
	.createTest("Test 4","Test desc")
	.assignCategory("Regression")
	.assignAuthor("Reddibabu")
	.assignAuthor("Raviteja")
	.assignCategory("Smoke")
	.assignDevice("Chrome 98")
	.assignDevice("Firefox 80")
	.pass("This is a failed test");
	
	extent
	.createTest("Test 5","Test desc")
	.assignAuthor(new String[]{"Reddibabu","Raviteja","Reddiprasad"})
	.assignCategory("Smoke","Reggression","Sanity")
	.assignDevice("Chrome 98","Firefox 80","Edge 121")
	.pass("This is a failed test");
	
	
	extent.flush();
	Desktop.getDesktop().browse(new File("Reports.html").toURI());
}
}
