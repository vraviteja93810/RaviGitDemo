package stepdefinitions;



import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Landingpage;
import pageobjects.PageobjectManager;
import utils.TestContextSetup;

public class LandingpageStepDefinition {
	WebDriver driver;
	String HomeproductName;
	TestContextSetup testContextSetup;
	Landingpage Lpage;
	public LandingpageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.Lpage = testContextSetup.manager.getLandingPage();
	}
	@Given("user is on Greenkart landing page.")
	public void user_is_on_greenkart_landing_page() {
		
		Assert.assertTrue(Lpage.getTitleLandingPage().contains("GreenKart"));
	}
	@When("^user search with shortname (.+) and extract actual name of product$")
	public void user_search_with_shortname_and_extract_actual_name_of_product(String shortName) throws InterruptedException {
		//PageobjectManager POB=new PageobjectManager(testContextSetup.driver);
		
		Lpage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.HomeproductName =Lpage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.HomeproductName+"is extracted from Home page");

	}
	@When("Added {string} items of the selected product to cart")
	public void Added_items_of_the_selected_product_to_cart(String quantity)
	{
		Lpage.incrementQuantity(Integer.parseInt(quantity));
		Lpage.addToCart();
	}

}
