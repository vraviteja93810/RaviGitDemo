package ravitejaacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import ravitejaacademy.abstractcomponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	By countryList=By.cssSelector(".ta-item:nth-of-type(2)");
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectcountry;
	
	@FindBy(css=".btnn")
	WebElement submit;
	
	
	public void selectCountry(String CountryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country,CountryName).build().perform();
		//here we are waiting explicitly
		waitForElementToAppear(countryList);
		selectcountry.click();
	}
	
	public Confirmation_page submitButton()
	{
		submit.click();
		Confirmation_page confirmation=new Confirmation_page(driver);
		return confirmation;
	}
	
}
