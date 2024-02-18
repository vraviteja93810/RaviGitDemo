import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameBox = driver.findElement(By.name("name"));
		nameBox.sendKeys("Ravi");
		File source = nameBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("webEelement.png"));
		
		//Taking web element height and width.
		System.out.println("height: "+nameBox.getRect().getDimension().getHeight());
		System.out.println("width: "+nameBox.getRect().getDimension().getWidth());
	}
}
