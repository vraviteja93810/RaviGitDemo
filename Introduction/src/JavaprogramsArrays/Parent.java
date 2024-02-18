package JavaprogramsArrays;

import org.testng.annotations.BeforeMethod;

public class Parent {
public void doThis()
{
	System.out.println("I am here from parent");
}
@BeforeMethod
public void beforeMethod()
{
	System.out.println("Run me first");
}
}
