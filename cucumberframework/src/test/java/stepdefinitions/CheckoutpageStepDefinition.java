package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Checkout;
import pageobjects.Landingpage;
import pageobjects.PageobjectManager;
import utils.TestContextSetup;

public class CheckoutpageStepDefinition {
	WebDriver driver;
	String HomeproductName;
	TestContextSetup testContextSetup;
	public Checkout checkoutpage;

	public CheckoutpageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutpage = testContextSetup.manager.getCheckoutPage();
	}

	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String vegetable)   {
		checkoutpage.CheckoutItems();
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void And_verify_user_has_ability_to_enter_promo_code_and_place_the_order() {

		Assert.assertTrue(checkoutpage.verifyPromoBtn());
		Assert.assertTrue(checkoutpage.verifyPlaceOrder());
	}

}
