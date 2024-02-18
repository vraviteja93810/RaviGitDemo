import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v114.page.Page.GetAppIdResponse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartEcommerceApp {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

		// First we create one array to store vegetables in that page.
		String[] vegetables_Names = { "Brocolli", "Cucumber" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		addItems(driver, vegetables_Names);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//introducing webdriver wait
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Code applied ..!']")).getText(),
				"Code applied ..!");

	}

	public static void addItems(WebDriver driver, String[] vegetables_Names) {
		int j = 0;
		List<WebElement> allProductNames = driver.findElements(By.cssSelector("h4.product-name"));

		// one way to handle this.
		/*
		 * for (int i = 0; i < allProductNames.size(); i++) 
		 * { if
		 * (allProductNames.get(i).getText().equalsIgnoreCase("Cucumber - 1 Kg")) {
		 * System.out.println(allProductNames.get(i).getText());
		 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
		 * ); break; } }
		 */

		// We have one more way to write same code.
		for (int i = 0; i < allProductNames.size(); i++) {
			String[] name = allProductNames.get(i).getText().split("-");
			// Here we need to separate Cucumber -1 kg. Here we dont need -1 kg word.
			// we need only vegetable name.
			// Here we can use split method directly after getText() because it directly
			// return string only.
			// Here we are going to split this into two pieces. so at what letter we need
			// split into two pieces we need to add that letter.
			// Here we have added - letter. So Cucumber is separated and stored in zero
			// index.
			// 1kg is separated and stored in 1st index.
			// Suppose if we pass 1 in the split, Now Cucumber - is separated and stored in
			// zero index.
			// Kg will be separated and stored in the 1st index of the array internally.
			// Note: when we use split method then it gives us two values in string format.
			// So the type also should be converted from string to string array.
			String FormattedVegtableNames = name[0].trim();
			// Check whether name you extracted is present in array or not.
			// Now convert this array to array list.
			List<String> Vegetables = Arrays.asList(vegetables_Names);

			if (Vegetables.contains(FormattedVegtableNames))
			// Here whatever the text we got in name variable, we just compare it will list
			// If it matches then our code will hit that ADD TO CART based on current index
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == vegetables_Names.length) {
					break;
				}
			}
		}

	}

}