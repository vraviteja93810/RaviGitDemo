import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunningInDifferentBrowsers {
public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\vredd\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\geckodriver.exe");

	WebDriver driver=new FirefoxDriver();
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());    
	driver.quit();

}
}
