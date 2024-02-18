package com.vrt.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ModifyTabsInExtentReports {
public static void main(String[] args) throws IOException {
	ExtentReports extent=new ExtentReports();	
	File file = new File("Reports.html");
	ExtentSparkReporter spark1=new ExtentSparkReporter("AllTest.html");
	ExtentSparkReporter spark2=new ExtentSparkReporter("Failed.html");
	spark2.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
	ExtentSparkReporter spark3=new ExtentSparkReporter("Skip.html");
	spark3.filter().statusFilter().as(new Status[] {Status.SKIP}).apply();
	ExtentSparkReporter spark4=new ExtentSparkReporter("warning.html");
	spark4.filter().statusFilter().as(new Status[] {Status.WARNING}).apply();
	extent.attachReporter(spark1,spark2,spark3,spark4);
	
	
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
	.skip("This is a skipped test");
	
	extent
	.createTest("Test 4","Test desc")
	.assignCategory("Regression")
	.assignAuthor("Reddibabu")
	.assignAuthor("Raviteja")
	.assignCategory("Smoke")
	.assignDevice("Chrome 98")
	.assignDevice("Firefox 80")
	.warning("This is a warning test");
	
	extent
	.createTest("Test 5","Test desc")
	.assignAuthor(new String[]{"Reddibabu","Raviteja","Reddiprasad"})
	.assignCategory("Smoke","Reggression","Sanity")
	.assignDevice("Chrome 98","Firefox 80","Edge 121")
	.pass("This is a failed test");
	extent
	.createTest("Highlight log Test")
	.info("This is not highlighted message message")
	.info(MarkupHelper.createLabel("This is Highlighted message", ExtentColor.ORANGE));
	
	try {
		int i=1/0;
	}
	catch (Exception e) {
		extent
		.createTest("Exception Test1")
		.fail(e);
		
	}
	
	extent.flush();
	Desktop.getDesktop().browse(new File("AllTest.html").toURI());
	Desktop.getDesktop().browse(new File("Failed.html").toURI());
	Desktop.getDesktop().browse(new File("Skip.html").toURI());
	Desktop.getDesktop().browse(new File("warning.html").toURI());
}
}
