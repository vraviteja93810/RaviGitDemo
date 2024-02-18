import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LocatorsDemo2 {
	public static void main(String[] args) throws AWTException, InterruptedException {
		String Username="Ravi";
		
		//google chrome
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		//firefox
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		
		//edgebrowser
		System.setProperty("webdriver.gecko.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String password = getpassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(Username);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit ')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+Username+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.quit();
	}
	public static String getpassword(WebDriver driver) throws InterruptedException
	{
	    driver.get("https://rahulshettyacademy.com/locatorspractice/");
	    driver.findElement(By.linkText("Forgot your password?")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	    String passwordText=driver.findElement(By.cssSelector("form p")).getText();
	    //Please use temporary password 'rahulshettyacademy' to Login.
	    //Now we need to split the above string based on single quote character.
	    //If we split at single quote, then split function breaks the above entaire line into two pieces.
	    //Here while mentioning the character to break, that character should be enclosed with double quotes.
	    String[] Passwordarray=passwordText.split("'");
	    //String[] Passwordarray2=Passwordarray[1].split("'");
	    //Again we need to split the line at '( from single quote). 
	    //now 0th index it will store --> rahulshettyacademy
	    //1st index  it will store the value from right side of the single quote --> to login
	    //Now we need to extract this rahulshettyacademy that means 0th index value we need to take.
	    String ActualPassword=Passwordarray[1].split("'")[0];
	    return ActualPassword;
	    
	}
	
}