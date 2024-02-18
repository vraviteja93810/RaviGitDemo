package RavitejaAcademy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import raviteja.testcomponents.BaseTest;
import ravitejaacademy.pageobjects.CartPage;
import ravitejaacademy.pageobjects.CheckoutPage;
import ravitejaacademy.pageobjects.Confirmation_page;
import ravitejaacademy.pageobjects.OrdersPage;
import ravitejaacademy.pageobjects.ProductCatalogue;

public class StandaloneTest_for_PageObject extends BaseTest{
	public String countryName="india";
	@Test(dataProvider = "getData",groups = "purchase")
	public void submitOrder(HashMap<String,String> input) throws IOException
	{
	//Here we are going to use webdrivermanager.
	
	//login details with mail and password.
	ProductCatalogue prod = landing.login_application(input.get("useremail"), input.get("password"));
    
	List<WebElement> products = prod.getProductList();
	prod.getProductByName(input.get("productName"));
	prod.addProductToCart(input.get("productName"));
	CartPage cart = prod.goToCartPage();
	boolean match = cart.verifyProductDisplay(input.get("productName"));
	Assert.assertTrue(match);
	CheckoutPage check = cart.clickOnCheckout();
	check.selectCountry(countryName);
	Confirmation_page cofirmationPage = check.submitButton();
	String Confirm_Message = cofirmationPage.verifyConfirmation();
	Assert.assertTrue(Confirm_Message.equalsIgnoreCase("Thankyou for the order."));
}
	
@Test(dependsOnMethods = "submitOrder",dataProvider = "getData")
public void ordersHistory(HashMap<String,String> input)
{	
	ProductCatalogue prod = landing.login_application(input.get("useremail"), input.get("password"));
	OrdersPage orders = prod.goToOrdersPage();//--> here by using any page object class we can call goToOrdersPage.
	//Why because this goToOrdersPage is available to AbstractComponents.java. this class is
	//extended by all page object classes.
	Assert.assertTrue(orders.verifyOrderDisplay(input.get("productName")));
}

@DataProvider
public Object[][] getData() throws IOException
{
	
//	HashMap<String,String> map=new HashMap<String,String>();
//	map.put("useremail", "raviteja@gmail.com");
//	map.put("password","Vraviteja@12345");
//	map.put("productName","ZARA COAT 3");
//	
//	HashMap<String,String> map1=new HashMap<String,String>();
//	map1.put("useremail", "reddiprasad@gmail.com");
//	map1.put("password","Vravi@12345");
//	map1.put("productName","ADIDAS ORIGINAL");
	List<HashMap<String, String>> Data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\raviteja\\data\\purchaseOrder.json");
	 return new Object[][] {{Data.get(0)},{Data.get(1)}};

}



}
