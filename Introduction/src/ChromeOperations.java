import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOperations {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		//One way to maximize our browser
		 options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 //another way of maximizing our browser
		//driver.manage().window().maximize();
		
		//driver.get("https://www.google.com/");
		//if we want to delete the cookies how?
		
		//Note all browser settings are happened in manage()
		
			
			driver.get("http://www.example.com");
			
			//we can create object for cookie as well.
			Cookie cookie1 =new Cookie("key2", "cookie2");
			
			//add the cookie to current browser context
			driver.manage().addCookie(new Cookie("key", "value"));
			
			
			//get the cookie details with named cookie
			
			Cookie cookieValue = driver.manage().getCookieNamed("key");
			System.out.println(cookieValue);
		
			//get all the cookies
			Set<Cookie> AllCookies = driver.manage().getCookies();
			System.out.println(AllCookies);
			
			
			//we can delete the cookie by providing our cookie name as well.
			driver.manage().deleteCookieNamed("key");
			
			//we can delete the cookie by passing cookie object as well.
			driver.manage().deleteCookie(cookie1);
			
			//we can delete all the cookies
			driver.manage().deleteAllCookies();
		}
		
		
	}


