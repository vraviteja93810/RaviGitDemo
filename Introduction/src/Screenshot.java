import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.google.com/");
		 TakesScreenshot t = ((TakesScreenshot)driver);
		 File source = t.getScreenshotAs(OutputType.FILE);
		 //Here we are writing method getScreenshotAs() to take the screenshot and provide the output of that screenshot as file type.
		 //If the output is type file means we can able to view that file.
		 //That we stored inside of that source variable.
		 
		 FileUtils.copyFile(source,new File("D://screenshot.png"));
		 	   
//                   Or same above two steps we write in single line as well. below		 
		// File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
	}

}
