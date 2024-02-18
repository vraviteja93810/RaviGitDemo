import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
	JavascriptExecutor j=(JavascriptExecutor)driver;
	j.executeScript("window.scrollBy(0,300)");
	//Lets first select the date then month
	driver.findElement(By.id("first_date_picker")).click();
	Thread.sleep(3000);
	//select the month first
	while(!driver.findElement(By.cssSelector("div[id='ui-datepicker-div'] [class='ui-datepicker-title']")).getText().contains("October"))
	{
		//Till it reaches October it keeps on clicking the left arrow key. why left arrow key mens i want october month of 2022. that's why i have
		//given the left arrow key. If i need 2-24 then i will give right arrow key.
		driver.findElement(By.cssSelector("[class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all'] [class='ui-icon ui-icon-circle-triangle-w']")).click();
	}
	//[id='ui-datepicker-div'] a[class='ui-datepicker-prev ui-corner-all']
	//[class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all'] [class='ui-icon ui-icon-circle-triangle-w']
	//Here we are selecting the day
	List<WebElement> allDates = driver.findElements(By.className("ui-state-default"));
	for(int i=0;i<allDates.size();i++)
	{
		String allDateValue = driver.findElements(By.className("ui-state-default")).get(i).getText();
		//Now we need to take the all values from that calendar and then we perform if condition to match our value.
		if(allDateValue.equalsIgnoreCase("30"))
		{
			driver.findElements(By.className("ui-state-default")).get(i).click();
			break;
		}
	}
}
}
