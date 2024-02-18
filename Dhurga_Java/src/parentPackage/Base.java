package parentPackage;

public class Base {
static int i=10;
static
{
	m1();
	System.out.println("Base static block");
}
public static void main(String args[])
{
	m1();
	System.out.println("Base main method");
}
public static void m1()
{
	System.out.println(j);
	
}
static int j=20;
}

//0
//base static block
//20 assigned
//20
//Base main method