package parentPackage;

public class Derived extends Base{
static int x=100;
static
{
	m2();
	System.out.println("Derived first static block");
	
}
public static void main(String args[])
{
	m2();
	System.out.println("Derived main method");
}
public static void m2()
{
	System.out.println(y);
}
static
{
	System.out.println("Derived second static block");
}
static int y=200;
}
