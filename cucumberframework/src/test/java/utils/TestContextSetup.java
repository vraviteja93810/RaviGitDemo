package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageobjects.PageobjectManager;
import stepdefinitions.Hooks;

public class TestContextSetup {
	public WebDriver driver;
	public String HomeproductName;
	public PageobjectManager manager;
	public TestBase testbase;
	public GenericUtils genericUtils;
	public TestContextSetup() throws IOException
	{
		testbase=new TestBase();
		manager=new PageobjectManager(testbase.webdriverManager());
		genericUtils=new GenericUtils(testbase.webdriverManager());
	}
	
}
