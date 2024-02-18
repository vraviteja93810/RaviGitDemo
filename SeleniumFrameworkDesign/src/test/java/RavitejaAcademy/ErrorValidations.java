package RavitejaAcademy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import raviteja.testcomponents.BaseTest;
import ravitejaacademy.pageobjects.CartPage;
import ravitejaacademy.pageobjects.CheckoutPage;
import ravitejaacademy.pageobjects.Confirmation_page;
import ravitejaacademy.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest{
	
	@Test(retryAnalyzer= raviteja.testcomponents.Retry.class)
	public void loginErrorValidation() throws IOException
	{
	//Here we are going to use webdrivermanager.
	String productName="ZARA COAT 3";
	String countryName="india";
	//login details with mail and password.
	landing.login_application("raviteja@gmail.com", "Vraviteja@12");
    Assert.assertEquals("Incorrect password.",landing.getErrorMessage());
    //Incorrect email or password.
   
}
	@Test
	public void submitOrder() throws IOException
	{
	//Here we are going to use webdrivermanager.
	String productName="ZARA COAT 3";
	String countryName="india";
	//login details with mail and password.
	ProductCatalogue prod = landing.login_application("raviteja@gmail.com", "Vraviteja@12345");
    
	List<WebElement> products = prod.getProductList();
	prod.getProductByName(productName);
	prod.addProductToCart(productName);
	CartPage cart = prod.goToCartPage();
}	
}
