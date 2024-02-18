package ravitejaacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ravitejaacademy.abstractcomponents.AbstractComponents;

public class OrdersPage extends AbstractComponents{
WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productTList;
	
	
	public boolean verifyOrderDisplay(String productName)
	{
		boolean match = productTList.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
}
