package ravitejaacademy.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import ravitejaacademy.abstractcomponents.AbstractComponents;

public class Confirmation_page extends AbstractComponents{
WebDriver driver;
	public Confirmation_page(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationtext;
	
	public String verifyConfirmation()
	{
		String Confirm_Message = confirmationtext.getText();
		return Confirm_Message;
	}
	
}
