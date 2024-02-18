package com.vrt.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogsDemo2 {
	public static void main(String[] args) throws IOException {
		ExtentReports extent=new ExtentReports();	
		File file = new File("Reports.html");
		ExtentSparkReporter spark=new ExtentSparkReporter(file);
		extent.attachReporter(spark);
		extent
		.createTest("Test 1")
		.log(Status.INFO,"Text based test")
		.log(Status.INFO,"<b>info 2</b>")
		.log(Status.INFO, "<i>info 3</i>")
		.log(Status.INFO, "<b><i> info 4</i></b>");
		String XMLData="<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		
		
		String JsonData="{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		extent
		.createTest("XML Based Test")
		.info(MarkupHelper.createCodeBlock(XMLData,CodeLanguage.XML));
		
		extent
		.createTest("Json Based Test")
		.log(Status.INFO, MarkupHelper.createCodeBlock(JsonData, CodeLanguage.JSON));
		
		List<String> listData=new ArrayList<String>();
		listData.add("Raviteja");
		listData.add("Prasad");
		listData.add("Reddi Babu");
		
		Map<Integer,String> mapData=new HashMap<>();
		mapData.put(101, "Ravi");
		mapData.put(102, "Reddi");
		mapData.put(103, "Babu");
		
		Set<Integer> setData= mapData.keySet();
		
		extent
		.createTest("List Based Test")
		.info(MarkupHelper.createOrderedList(listData));
		
		extent
		.createTest("Map Based Test")
		.info(MarkupHelper.createUnorderedList(mapData));
		

		extent
		.createTest("Set Based Test")
		.info(MarkupHelper.createUnorderedList(setData));
		
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
		
		Throwable t=new RuntimeException("This is a customized exception");
		extent
		.createTest("Exception Test2")
		.fail(t);
		
		
		extent.flush();
		Desktop.getDesktop().browse(new File("Reports.html").toURI());
	}
}
