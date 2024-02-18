import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//Broken links
		//we have java methods, used to call URL's then get the status of those URL's.
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		List<WebElement> All_Links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert s=new SoftAssert();
        
		
		for(WebElement Links:All_Links)
		{
			String URL=Links.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(URL).openConnection();

			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode=conn.getResponseCode();
			System.out.println(responseCode);
			s.assertTrue(responseCode<400, "the link with text:"+Links.getText()+"is broken with code"+responseCode);
             //Here we wrote that if response code is <400 in this case it is true. 
			//If the response code is greater than 400 then in this case it returns false.
			//even it got false as return value, still it can continue without fail
			//that failed one informtaion got stored inside it and finally it provides that information.
			
			//without if condition we can handle it in the single line
			}
		s.assertAll();
		
		
	/*	//Below code is if we want to check only one link.
		
		//String URL=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		String URL=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

		HttpURLConnection conn = (HttpURLConnection)new URL(URL).openConnection();

		conn.setRequestMethod("HEAD");
		conn.connect();
		int responseCode=conn.getResponseCode();
		System.out.println(responseCode);
		
	*/	
		
	}

}
