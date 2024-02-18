import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Proxy p=new Proxy();
		//for proxy
		p.setHttpProxy("ipaddress:4444");
		ChromeOptions options=new ChromeOptions();
		//we are setting capability to handle proxy
		options.setCapability("proxy",p);
		//if we want to set the directory to donwload the file using selenum
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "Downloads");
		//Here above download is path i have given to download all my files by default available in downloads section.
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("start-maximized");
		options.setAcceptInsecureCerts(true); //--> used to accept the certifications.
		//options.addExtensions();
		options.setCapability("proxy",p);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
