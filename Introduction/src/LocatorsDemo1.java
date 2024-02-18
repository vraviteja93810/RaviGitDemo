import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo1 {
public static void main(String[] args) throws AWTException, InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
    Robot r=new Robot();
    r.keyPress(KeyEvent.VK_TAB);
    r.keyRelease(KeyEvent.VK_TAB);
    driver.findElement(By.name("inputPassword")).sendKeys("rahul123");
    //Above randomly we gave. wrong password or user name to capture the error message.
    driver.findElement(By.className("signInBtn")).click();
    System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
    //click on forgot password.
    driver.findElement(By.linkText("Forgot your password?")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ravi");
    driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Ravi@gamil.com");
    driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Ravi@gamil.com");
    driver.findElement(By.xpath("//input[@placeholder='Email' and @type='text']")).clear();
    driver.findElement(By.xpath("//input[ @type='text'][2]")).sendKeys("Ravi@gamil.com");
    driver.findElement(By.xpath("//form/input[3]")).sendKeys("9381051788");
    driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
    System.out.println(driver.findElement(By.cssSelector("form p")).getText());
    driver.findElement(By.cssSelector(".go-to-login-btn")).click();
    Thread.sleep(2000);
    
    //Now we will give all valid details and login to check each and eveything.
    driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Ravi");
    driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
    driver.findElement(By.cssSelector("input#chkboxOne")).click();
    driver.findElement(By.cssSelector("input#chkboxTwo")).click();
    driver.findElement(By.xpath("//button[contains(@class,'submit ')]")).click();
    
}
}
