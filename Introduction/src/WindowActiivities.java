import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActiivities {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().fullscreen();
	driver.get("https://www.google.com/");
	driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
	driver.navigate().back();
	driver.navigate().forward();
	driver.navigate().refresh();
}
}
