import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		//giving knowledge about the frames to our selenium to handle
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//Switching our selenium control inside of frame using its address.
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		//Switch to frame using its index
		driver.switchTo().frame(0);
		
		//Selenium reach inside of iframe.
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		//to perform drag and drop we need to go head with Actions class.
		Actions a=new Actions(driver);
		a.dragAndDrop(source, destination).build().perform();
		driver.switchTo().defaultContent();
	}

}
