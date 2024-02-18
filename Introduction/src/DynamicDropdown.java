import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
public static void main(String[] args) throws InterruptedException {
	
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//-->//a[@value='BLR'] --> this is from location city
//-->//a[@value='MAA'] --> xpath for chennei 
// -->(//a[@value='MAA'])[2]
Thread.sleep(2000);
driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
driver.findElement(By.xpath("//a[@value='BLR']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

}
}
