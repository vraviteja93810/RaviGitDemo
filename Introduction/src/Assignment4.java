import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://the-internet.herokuapp.com/");
	driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
	driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	Set<String> WindowsIds = driver.getWindowHandles();
	Iterator<String> id = WindowsIds.iterator();
	String ParentId = id.next();
	
	//String childId=id.next();
	//OR directly also we can mention inside of window(id.next())
	driver.switchTo().window(id.next());//--> this also return the child window only
	System.out.println("child window:-"+driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	driver.switchTo().window(ParentId);
	System.out.println("parent window:-"+driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
	driver.quit();
}
}
