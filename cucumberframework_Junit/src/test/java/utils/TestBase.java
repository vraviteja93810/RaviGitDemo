package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	WebDriver driver;
public WebDriver webdriverManager() throws IOException
{
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
	
	Properties p=new Properties();
	p.load(fis);
	String browser_properties=p.getProperty("browser");
	String URL=p.getProperty("QAUrl");
	String Browser_Maven=System.getProperty("browser");
	//Building the conditional operator.
	String browser=Browser_Maven!=null?Browser_Maven:browser_properties;
	if(driver==null)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(URL);
	}
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(URL);
	}
	else if(browser.equalsIgnoreCase("Edge"))
	{
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(URL);
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	return driver;
}
}
