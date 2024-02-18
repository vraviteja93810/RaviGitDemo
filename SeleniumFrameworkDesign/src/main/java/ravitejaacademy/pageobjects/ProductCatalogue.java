package ravitejaacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ravitejaacademy.abstractcomponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement>products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	
	//we wrote this action method to retun all the list of products.
	By product=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By tostMessage=By.cssSelector("#toast-container");
	public List<WebElement> getProductList()
	{
		//before it reutns all the products we need to wait for sometime.
		waitForElementToAppear(product);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement ActualProd = getProductList().stream().filter(product->
		product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return ActualProd;
	}
	
	public void addProductToCart(String productName)
	{ 
		WebElement ActualProd = getProductByName(productName);
		ActualProd.findElement(addToCart).click();
		waitForElementToAppear(tostMessage);
		waitForElementToDisappear(spinner);
	}
	
	
	
}
