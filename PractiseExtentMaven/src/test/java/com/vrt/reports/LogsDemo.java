package com.vrt.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogsDemo {
	public static void main(String[] args) throws IOException {
		ExtentReports extent=new ExtentReports();	
		File file = new File("Reports.html");
		ExtentSparkReporter spark=new ExtentSparkReporter(file);
		extent.attachReporter(spark);
		extent
		.createTest("Test 1")
		.log(Status.INFO,"info 1")
		.log(Status.INFO,"info 2")
		.log(Status.INFO, "info 3")
		.log(Status.PASS, "pass")
		.log(Status.WARNING, "Warning 1")
		.log(Status.WARNING, "Warning 2")
		.log(Status.SKIP, "Skip")
		.log(Status.FAIL, "Fail")
		.log(Status.FAIL, "Fail2");
		
		extent.flush();
		Desktop.getDesktop().browse(new File("Reports.html").toURI());
	}
}
