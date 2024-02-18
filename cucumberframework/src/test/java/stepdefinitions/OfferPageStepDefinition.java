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
import pageobjects.Landingpage;
import pageobjects.Offerspage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	WebDriver driver;
	String HomeproductName;
	String offerproductName;
	TestContextSetup testContextSetup;
	public OfferPageStepDefinition(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
	}

	@Then("^user search for (.+) shortname in offers page$")
	public void user_search_for_shortname_in_offers_page(String ofshortName) throws InterruptedException {
		switchTooffersPage();
		Offerspage Opage=testContextSetup.manager.getOffersPage();
		Opage.searchItem(ofshortName);
	    Thread.sleep(2000);
	    offerproductName = Opage.getProductName();
	    System.out.println(offerproductName);
	}
	public void switchTooffersPage()
	{
		//if(testContextSetup.driver.getCurrentUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		Landingpage Lpage=testContextSetup.manager.getLandingPage();
		Lpage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWinodwToChild();
	}
	
	@Then("validate productname in offerspage with homepage productname")
	public void validate_productname_in_offerspage_with_homepage_productname() {
		Assert.assertEquals(offerproductName, testContextSetup.HomeproductName);
	}
}
