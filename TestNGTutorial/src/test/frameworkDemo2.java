package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class frameworkDemo2 {
@Test(groups = "sanity")
public void frame()
{
	System.out.println("Hellow");
}
@BeforeTest
public void prerequisite()
{
	System.out.println("I will execute first");
}
@AfterTest
public void postrequisite()
{
	System.out.println("I will execute at last");
}

@BeforeSuite
public void Initialize()
{
	System.out.println("I am no.1");
}
}
