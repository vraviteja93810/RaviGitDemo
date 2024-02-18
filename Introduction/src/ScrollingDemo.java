import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingDemo {
	public static void main(String[] args) throws InterruptedException {
		
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	JavascriptExecutor js=(JavascriptExecutor)(driver);
	//Here we performing casting operation.
	
	//To scroll window to reach table.
	js.executeScript("window.scrollBy(0,700)");
	Thread.sleep(2000);
	
	
	//Scroll the content inside of the table.
	js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	int sum=0;
	for(int i=0;i<driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")).size();i++)
	{
		int values=Integer.parseInt(driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")).get(i).getText());
		 sum=sum+values;
	}
	System.out.println("The whole values:"+sum);
	int Actual_Value = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
	
	Assert.assertEquals(Actual_Value,sum);
}
}
