package raviacadamey.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
@BeforeMethod
public void config()
{
	//ExtentReports , ExtentSparkReporter
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Ravi teja");
	
}
	@Test
public void initialDemo()
{
	ExtentTest test=extent.createTest("Initial Demo");
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com");
	System.out.println(driver.getTitle());
	test.fail("Results do not match");
	extent.flush();
}
}
