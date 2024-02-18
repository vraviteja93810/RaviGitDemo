import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//give me the count of links on the page.
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// To find count of links present in page the below code is enough.
		System.out.println("All the links in entire page: " + driver.findElements(By.tagName("a")).size());

		// Find the count of links present at only footer level.
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out
				.println("All the links present in footer level: " + footerDriver.findElements(By.tagName("a")).size());

		// selecting the links only at the specific column in footer section.
		WebElement ColumnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("Column level links: " + ColumnDriver.findElements(By.tagName("a")).size());

		// here i vlaue we took 1. because in the page, 0th index link is not working,
		// that's why we took from 1st index.
		for (int i = 1; i < ColumnDriver.findElements(By.tagName("a")).size(); i++) {
			String clickonLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			// Keys.chord(Keys.CONTROL,Keys.ENTER); --> This is used to press control button
			// and enter.

			// If i run only below one line then we get error. Because if we click on first
			// link then control reach to that page.
			// In that page now selenium find to click another link, but this link is in
			// previous page. Hence we get error.
			// To resolve this issue better we open the each link in a separate tab.
			ColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLink);

			// Take the titles of each window
			Thread.sleep(5000L);
		}
			Set<String> Windows = driver.getWindowHandles();
			Iterator<String> it = Windows.iterator();

			while (it.hasNext()) // This has next() tells us like whether do we have next index present or not.
			{
				// Here it.next() moves to that index that's it.
				driver.switchTo().window(it.next()); // --this will start finding/ moving from 0th index to nth index
														// every iteration.
				// Actually this it.next() method will return window id. that's why we put
				// inside of window to transfer the control
				System.out.println(driver.getTitle());
			}

		}
	}


