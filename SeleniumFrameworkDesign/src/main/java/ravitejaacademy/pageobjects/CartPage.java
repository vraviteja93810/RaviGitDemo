package ravitejaacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ravitejaacademy.abstractcomponents.AbstractComponents;

public class CartPage extends AbstractComponents{
WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> productTitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public boolean verifyProductDisplay(String productName)
	{
		boolean match = productTitles.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	public CheckoutPage clickOnCheckout()
	{
		checkout.click();
		CheckoutPage check=new CheckoutPage(driver);
		return check;
	}
	

}
