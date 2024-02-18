package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageobjectManager {
	public Landingpage landingPage;
	public Offerspage Ofpage;
	public WebDriver driver;
	public Checkout Checkpage;
	public PageobjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	public Landingpage getLandingPage()
	{
		landingPage=new Landingpage(driver);
		return landingPage;
	}
	public Offerspage getOffersPage()
	{
		Ofpage=new Offerspage(driver);
		return Ofpage;
	}
	public Checkout getCheckoutPage()
	{
		Checkpage=new Checkout(driver);
		return Checkpage;
	}
	 
}
