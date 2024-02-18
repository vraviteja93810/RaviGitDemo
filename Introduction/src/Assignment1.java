import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	driver.findElement(By.xpath("//input[@value='option1']")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
	driver.findElement(By.xpath("//input[@value='option1']")).click();
	Assert.assertFalse(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
	List<WebElement> AllCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	System.out.println("The list of chec boxes are:-"+AllCheckBoxes.size());
	
	

}
}
