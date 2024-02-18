package stepDefinitions;

import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainSteps {
	@Given("user is on NetBanking landing page")
	public void user_is_on_net_banking_landing_page() {
	    System.out.println("User landed on netbanking page");
	}
	@Given("user is on  practise landing page")
	public void user_is_on_practise_landing_page() {
	   
	}
	
	@When("user signup into application")
	public void user_signup_into_application(List<String> data) {
	    //driver.findelement(sendkeys(data.get(0))
		System.out.println(data.get(0));
	}
	
	@When("user login into application with {string} and password {string}")
	public void user_login_into_application_with_and_password(String usrename, String password) {
	    System.out.println(usrename+ "and password:"+password);
	}
	@When("^user login into application with (.+) and password (.+) combination$")
	public void user_login_into_application_with_debituser_and_password_duser12_combination(String usrename, String password) {
	    
	}

	
	@Then("Home page is displayed")
	public void home_page_is_displayed() {
	    System.out.println("Home page is displayed");
	}
	@Then("cards are displayed.")
	public void cards_are_displayed() {
	    System.out.println("cards are displayed.");
	}
	
	@Given ("setup the entries in database")
	public void setup_the_entries_in_database()
	{
		System.out.println("***********************");
	}
	
	@And("launch the browser from config variables")
	public void launch_the_browser_from_config_variables()
	{
		System.out.println("*************************");
	}
	@And("hit the home page url of banking site.")
	public void hit_the_home_page_url_of_banking_site() {
	    System.out.println("*********************");
	}
	
	
}
