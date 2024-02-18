package com.vrt.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfiguration {

	public static void main(String[] args) throws IOException {
		ExtentReports extent=new ExtentReports();	
		File file = new File("Reports.html");
		ExtentSparkReporter spark=new ExtentSparkReporter(file);
//		ExtentSparkReporterConfig config = spark.config();
//		config.setTheme(Theme.DARK);
//		config.setReportName("Report name");
//		config.setDocumentTitle("Doc Title");
//		config.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
//		config.setCss(".badge-primary{background-color: #ffc107}");
//		//we want to make this logo got disappear.
//		config.setJs("document.getElementsByClassName('logo')[0].style.display='none'");
		
		spark.loadJSONConfig(new File("./src/test/resources/extent-reports-config.json"));
//		spark.loadJSONConfig("{\r\n"
//				+ "    \"theme\": \"dark\",\r\n"
//				+ "    \"encoding\": \"utf-8\",\r\n"
//				+ "    \"protocol\": \"HTTPS\",\r\n"
//				+ "    \"timelineEnabled\": false,\r\n"
//				+ "    \"offlineMode\": true,\r\n"
//				+ "    \"thumbnailForBase64\": false,\r\n"
//				+ "    \"documentTitle\": \"Doc Title\",\r\n"
//				+ "    \"reportName\": \"Report name\",\r\n"
//				+ "    \"timeStampFormat\": \"dd-MM-yyyy hh:mm:ss\",\r\n"
//				+ "    \"js\": \"document.getElementsByClassName('logo')[0].style.display='none'\",\r\n"
//				+ "    \"css\": \".badge-primary{background-color: #ffc107}\"\r\n"
//				+ "}");
//		
		
		//spark.loadXMLConfig(new File("./src/test/resources/Extent-reports-config.xml"));
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
