package raviteja.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import ravitejaacademy.pageobjects.Landingpage;

public class BaseTest {
public WebDriver driver;
public Landingpage landing;

public WebDriver initializeDriver() throws IOException
{
	
	//properties class
	Properties p=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ravitejaacademy\\resources\\GlobalData.properties");
	p.load(fis);
	//now we need to write the logic to read the browser value coming from the Maven through command prompt.
	String browserName	=System.getProperty("browser")!=null?System.getProperty("browser"):p.getProperty("browser");
	//String browserName=p.getProperty("browser");
	if (browserName.contains("chrome")) {

		ChromeOptions options=new ChromeOptions();

		WebDriverManager.chromedriver().setup();

		if(browserName.contains("headless")) {

		options.addArguments("headless");

		}

		driver = new ChromeDriver(options);

		driver.manage().window().setSize(new Dimension(1440, 900));

		}
	else if(browserName.contains("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\geckodriver.exe");
		//WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	}
	else if(browserName.contains("edge"))
	{
		//edge driver related stuff 
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
}

public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
{
	//read json to string
	String JsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	
	//Now we need to conver this above String variable to Hashmap.
	ObjectMapper mapper=new ObjectMapper();
	
	List<HashMap<String,String>>data=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>()
			{
			});
	return data;
	
}

public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File Destination=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	FileUtils.copyFile(source,Destination);
	//return Destination;
	return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
}

@BeforeMethod(alwaysRun = true)
public Landingpage launchApplication() throws IOException
{
	driver=initializeDriver();
	 landing=new Landingpage(driver);
	//URL method
	landing.goTo();
	return landing;
}

@AfterMethod(alwaysRun = true)
public void tearDown()
{
	driver.quit();
}

}
