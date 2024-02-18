import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {
public static void main(String[] args) {
	
	//Invoking Browser
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");

	ChromeDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());    
	driver.quit();
}
}
