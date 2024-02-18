package programs;

public class Static_Flow {
static int i=10;
static
{
	m1();
	System.out.println("Frist static block");
}
public static void main(String args[])
{
	m1();
	System.out.println("Main method");
}
public static void m1()
{
	System.out.println(j);
}
static
{
	System.out.println("Second static block");
}
static int j=20;
}


//20;
//First Static block
//20
//main method
//Second static block
