import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {
	public static void main(String[] args) throws InterruptedException 
	{
		
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.rahulshettyacademy.com/angularpractice/");
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//form/div[1]/input")).sendKeys("Ravi");
	driver.findElement(By.name("name")).sendKeys("Ravi");
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("raviteja@gmail.com");
	driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("Ravi12345");
	driver.findElement(By.cssSelector("#exampleCheck1")).click();
	WebElement gender = driver.findElement(By.cssSelector("select[id='exampleFormControlSelect1']"));
	gender.click();
	Select s=new Select(gender);
	s.selectByIndex(0);
	driver.findElement(By.id("inlineRadio1")).click();
	driver.findElement(By.name("bday")).sendKeys("05061999");
	driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();
	System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText(),"Success! The Form has been submitted successfully!.");
}
}
