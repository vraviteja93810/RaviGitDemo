package ravitejaacademy.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ravitejaacademy.pageobjects.CartPage;
import ravitejaacademy.pageobjects.OrdersPage;

public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver)
			{
		this.driver=driver;
		PageFactory.initElements(driver,this);
			}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartIcon;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	public OrdersPage goToOrdersPage()
	{
		orderHeader.click();
		OrdersPage Order=new OrdersPage(driver);
		return Order;
	}
	
	public CartPage goToCartPage()
	{
		cartIcon.click();
		CartPage cart=new CartPage(driver);
		return cart;
	}
	public void waitForElementToAppear(By findBy)
	{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement element)
	{
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
	
}
