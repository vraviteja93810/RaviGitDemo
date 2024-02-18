import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlngDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		
		//Now the new window is opened with that website.
		//Now we need to switch our selenium control from parent to child window.
		//For this we need to know how many windows are avaiable currently.
		//now we need to get the id's of that windows.
		Set<String> windowsIds = driver.getWindowHandles(); //[parent, child]
		Iterator<String> it=windowsIds.iterator();
		String parentId=it.next();
		//if we want child window id, for that perform one more it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		//By using trim and split and trim we can separate the required text.
		 String Actual_email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		 
		 //Now we need to switch back to parent window page.
		 driver.switchTo().window(parentId); //--> here we need to pass our parent window id
		driver.findElement(By.id("username")).sendKeys(Actual_email);
		
		
	}

}
