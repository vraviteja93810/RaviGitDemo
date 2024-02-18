import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class NewLocators {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/angularpractice/");
	
	WebElement nameTextBox = driver.findElement(By.cssSelector("[name='name']"));
	//System.out.println(driver.findElement(with(By.tagName("label")).above(nameTextBox)).getText());
	System.out.println(driver.findElement(with(By.tagName("label")).above(nameTextBox)).getText());
	
	WebElement dateofBirth = driver.findElement(By.xpath("//label[text()='Date of Birth']"));
	driver.findElement(with(By.className("form-control")).below(dateofBirth)).click();
	
	
	//Left locator
	WebElement IceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
	driver.findElement(with(By.id("exampleCheck1")).toLeftOf(IceCreamLabel)).click();
	
	//toRight();
	WebElement RadioButton = driver.findElement(By.id("inlineRadio1"));
	driver.findElement(with(By.xpath("//label[text()='Student']")).toRightOf(RadioButton)).click();
}
}
