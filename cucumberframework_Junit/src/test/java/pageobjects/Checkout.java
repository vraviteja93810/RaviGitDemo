package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class Checkout {
	public WebDriver driver;
	
	public Checkout(WebDriver driver)
	{
		this.driver=driver;
	}

	private By search=By.cssSelector(".search-keyword");
	private By productName=By.cssSelector("h4.product-name");
	private By CartIcon=By.cssSelector(".cart-icon");
	private By proceedToCheckout=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	private By promoBtn=By.cssSelector(".promoBtn");
	private By placeOrder=By.xpath("//button[text()='Place Order']");
	
//	public void searchItem(String shortName)
//	{
//		driver.findElement(search).sendKeys(shortName);
//	}
//	public String getProductName()
//	{
//		 return driver.findElement(productName).getText();
//	}
	public void CheckoutItems()
	{
		driver.findElement(CartIcon).click();
		driver.findElement(proceedToCheckout).click();
		
	}
	public boolean verifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	

}
