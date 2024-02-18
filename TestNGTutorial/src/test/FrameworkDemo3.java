package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameworkDemo3 {
	
@BeforeClass
public void beforeClass()
{
	System.out.println("Before all test methods.");
}
@Test(groups = "sanity")
public void webLogin()
{
	//webLogin 
	System.out.println("WebLogin");
}

@Test
public void mobileLogin()
{
   // mobile Login	
	System.out.println("mobileLogin");
}

@Test()
public void apiLogin()
{
	System.out.println("apiLogin");
	Assert.assertTrue(false);
	//Api Login
}
@AfterSuite
public void atLast()
{
	System.out.println("I am number last");
}

@AfterClass
public void afterClass() {
	System.out.println("after all the test methods in class.");
}
}
