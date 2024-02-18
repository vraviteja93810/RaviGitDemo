import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoItDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		String downloadpath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadpath);
		
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("prefs",chromePrefs);
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		Thread.sleep(2000);
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\vredd\\OneDrive\\Documents\\AutoITScripts\\FileUpload.exe");
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#processTask")));
		driver.findElement(By.cssSelector("#processTask")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pickfiles")));
		driver.findElement(By.cssSelector("#pickfiles")).click();
		File f=new File(downloadpath+"/Playwrite introduction.pdf");
		Thread.sleep(10000);
		if(f.exists()){
			Assert.assertTrue(f.exists());
			System.out.println("File found");
			if(f.delete())
			{
				System.out.println("file got deleted");
			}
		}
		else
		{
			System.out.println("File not available");
		}
	}
}
