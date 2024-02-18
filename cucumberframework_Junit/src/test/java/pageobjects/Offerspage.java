package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Offerspage {
	WebDriver driver;
	public Offerspage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By searchItem=By.id("search-field");
	private By productName=By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String item)
	{
		driver.findElement(searchItem).sendKeys(item);
	}
	public String getProductName()
	{
		return driver.findElement(productName).getText();	}
}
