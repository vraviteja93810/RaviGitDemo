package raviteja.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import raviteja.testcomponents.BaseTest;
import ravitejaacademy.pageobjects.CartPage;
import ravitejaacademy.pageobjects.CheckoutPage;
import ravitejaacademy.pageobjects.Confirmation_page;
import ravitejaacademy.pageobjects.Landingpage;
import ravitejaacademy.pageobjects.ProductCatalogue;

public class stepDefinitionImplementation extends BaseTest{
public Landingpage landingpage;
public ProductCatalogue prod;
public Confirmation_page confirmationPage;
public CartPage cart;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		 landingpage = launchApplication();
	}
	
	@Given ("^logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		 prod = landingpage.login_application(username, password);

	}
	@When ("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName)
	{
		List<WebElement> products = prod.getProductList();
		//prod.getProductByName(productName);
		prod.addProductToCart(productName);
	}
	@And ("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_order(String productName)
	{
		 cart = prod.goToCartPage();
		boolean match = cart.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage check = cart.clickOnCheckout();
		check.selectCountry("india");
		 confirmationPage = check.submitButton();
	}
	
	@Then("{string} message is displayed on confirmation.")
	public void message_is_displayed_on_confirmation(String string) {
		String Confirm_Message = confirmationPage.verifyConfirmation();
		Assert.assertTrue(Confirm_Message.equalsIgnoreCase(string));
	driver.quit();
	   // throw new io.cucumber.java.PendingException();
	}
//	@Then("{string} message is displayed on confirmation")
//	public void message_displayed_on_confirmation(String string)
//	{
//		System.out.println(string);
//		
//	}
}
