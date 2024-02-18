package ravitejaacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ravitejaacademy.abstractcomponents.AbstractComponents;

public class Landingpage extends AbstractComponents{
WebDriver driver;
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Page Factory method.
	@FindBy(id="userEmail")
	private WebElement userEmail;
	
	@FindBy(id="userPassword")
	private WebElement userpassword;
	
	@FindBy(name="login")
	private WebElement submit;
	
	@FindBy(css=".toast-message")
	private WebElement errorMessage;
	
	public ProductCatalogue login_application(String email, String password)
	{
		userEmail.sendKeys(email);
		userpassword.sendKeys(password);
		submit.click();
		ProductCatalogue prod=new ProductCatalogue(driver);
		return prod;
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText(); //--> we are returning the error message
		
	}

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
