import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunningInDifferentBrowsers2 {
public static void main(String[] args) {
	System.setProperty("webdriver.edge.driver","C:\\Users\\vredd\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\msedgedriver.exe");
	WebDriver driver=new EdgeDriver();
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());    
	driver.quit();

}
}
