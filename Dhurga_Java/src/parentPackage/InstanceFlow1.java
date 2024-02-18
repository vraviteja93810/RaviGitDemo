package parentPackage;

public class InstanceFlow1 {
int i=10;
{
	m1();
	System.out.println("First instance block");
}
InstanceFlow1()
{
	System.out.println("Constructor");
}
public static void main(String args[])
{
    InstanceFlow1 i=new InstanceFlow1();
	System.out.println("Main method");
}
public void m1()
{
	System.out.println(j);
}
{
	System.out.println("Second instance block");
}
int j=20;
}
