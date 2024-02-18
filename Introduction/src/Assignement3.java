import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignement3 {
	public static void main(String[] args) {
		
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	
	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	driver.findElement(By.id("username")).sendKeys(Keys.CLEAR,"rahulshettyacademy");
	driver.findElement(By.id("password")).sendKeys(Keys.CLEAR,"learning");
	driver.findElement(By.xpath("//div[@class='form-check-inline']/label[2]/span[2]")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
	driver.findElement(By.id("okayBtn")).click();
	//driver.switchTo().alert().accept();
	WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
	Select s=new Select(dropdown);
	s.selectByValue("consult");
	driver.findElement(By.id("terms")).click();
	driver.findElement(By.id("signInBtn")).click();
	//wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//a[text()='ProtoCommerce Home']"), "ProtoCommerce Home"));
	String[] items= {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
	List<String> Mobile_Names = Arrays.asList(items);
	int j=0;
	for(int i=0;i<Mobile_Names.size();i++)
	{
		List<WebElement> Actual_Mobiles = driver.findElements(By.xpath("//h4[@class='card-title']"));
		String Devices = Actual_Mobiles.get(i).getText();
		if(Mobile_Names.contains(Devices))
		{
			j++;
			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
			if(j==Actual_Mobiles.size())
			{
				break;
			}
		}
	}
	driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
}
}
