import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
		System.out.println(driver.findElement(By.xpath("//label[@for='benz']")).getText());
		String Value = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		
		 WebElement Dropdown = driver.findElement(By.id("dropdown-class-example"));
		 Select s=new Select(Dropdown);
		 s.selectByVisibleText(Value);
		driver.findElement(By.id("name")).sendKeys(Value);
		driver.findElement(By.id("alertbtn")).click();
		Assert.assertEquals(driver.switchTo().alert().getText(),"Hello "+Value+", "+"share this practice page and share your knowledge");
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		
		
	}

}
