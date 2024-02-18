import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UpdatedDropdown 
{
public static void main(String[] args) throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//performing the assertions.
	Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
	System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
	driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).click();
	Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
	
	//Calendar selecting.
	driver.findElement(By.cssSelector("input.custom_date_pic.required.home-date-pick.valid")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("a.ui-state-default.ui-state-active")).click();
	

	
	
	
	
	/*if(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected())
	{
	driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).click();
	//driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	
	}*/
	List<WebElement> AllCheckboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
	System.out.println("The list of check boxes are:"+AllCheckboxes.size());
	driver.findElement(By.id("divpaxinfo")).click();
	System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	Thread.sleep(2000);
	//While loop
	/*int i=1;
	while(i<5)
	{
		driver.findElement(By.id("hrefIncAdt")).click();
		//after it clicks on + icon then we increase i value to 1.
		i++;
	}
	driver.findElement(By.id("btnclosepaxoption")).click();
    */
	
	//for loop
	for(int i=1;i<5;i++)
	{
		driver.findElement(By.id("hrefIncAdt")).click();
		
	}
	driver.findElement(By.id("btnclosepaxoption")).click();
	Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
	System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
}
}
