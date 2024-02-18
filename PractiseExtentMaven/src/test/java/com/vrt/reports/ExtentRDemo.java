package com.vrt.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRDemo {
	public static void main(String[] args) throws IOException {
		ExtentReports extent=new ExtentReports();	
		File file = new File("Reports.html");
		ExtentSparkReporter spark=new ExtentSparkReporter(file);
		extent.attachReporter(spark);
		ExtentTest Test1=extent.createTest("Test 1");
		Test1.pass("This is passed");
		ExtentTest Test2=extent.createTest("Test 2");
		Test2.log(Status.FAIL, "This is failed");
		ExtentTest Test3=extent.createTest("Test 3");
		
		extent.createTest("Test 4").skip("This is Skipped");
		
		Test3.log(Status.SKIP, "This is skipped");
		extent.flush();
		Desktop.getDesktop().browse(new File("Reports.html").toURI());
	}

}
