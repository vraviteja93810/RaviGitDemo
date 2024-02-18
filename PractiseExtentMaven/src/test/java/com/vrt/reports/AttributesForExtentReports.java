package com.vrt.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AttributesForExtentReports {
public static void main(String[] args) throws IOException {
	ExtentReports extent=new ExtentReports();	
	File file = new File("Reports.html");
	ExtentSparkReporter spark=new ExtentSparkReporter(file);
	extent.attachReporter(spark);
	
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
