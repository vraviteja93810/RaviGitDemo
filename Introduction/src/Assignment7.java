import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)(driver);
		//Here we performing casting operation.
		
		//To scroll window to reach table.
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		
		//First take the how many rows present in the big table.
		System.out.println("number of rows:"+driver.findElements(By.cssSelector(".table-display tr")).size());
		//Print number of columns
	    System.out.println("Number of columns:"+driver.findElements(By.cssSelector(".table-display tbody tr:nth-child(1) th")).size());
		for(int i=0;i<driver.findElements(By.cssSelector(".table-display tr")).size();i++)
		{
			if(driver.findElements(By.cssSelector(".table-display tr")).size()==2)
			{
			System.out.println(driver.findElements(By.cssSelector(".table-display tr")).get(i).getText());
			break;
			}
			
		}
		
	}

}
