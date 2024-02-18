package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	@Before("@NetBanking")
	public void netBankingSetup() {
		System.out.println("****************************************************");
		System.out.println("setup the entries in database in Netbanking database");
	}

	@Before("@Mortgage")
	public void mortageSetup() {
		System.out.println("****************************************************");
		System.out.println("setup the entries in database in Mortage database.");
	}

	@After
	public void tearDown() {
		System.out.println("Clear the entries");
	}

}
