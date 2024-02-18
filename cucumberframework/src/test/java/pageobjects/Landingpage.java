package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class Landingpage {
	public WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By search=By.cssSelector(".search-keyword");
	private By productName=By.cssSelector("h4.product-name");
	private By TopDeals=By.xpath("//a[text()='Top Deals']");
	private By Increment=By.cssSelector("a.increment");
	private By addToCart=By.cssSelector(".product-action button");
	
	public void searchItem(String shortName)
	{
		driver.findElement(search).sendKeys(shortName);
	}
	public String getProductName()
	{
		 return driver.findElement(productName).getText();
	}
	public void selectTopDealsPage()
	{
		driver.findElement(TopDeals).click();
	}
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	public void incrementQuantity(int Quantity)
	{
		//Quantity is 3.
		int i=Quantity-1;
		while(i>0)
		{
			driver.findElement(Increment).click();
			i--;
		}
	}
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
	
}
