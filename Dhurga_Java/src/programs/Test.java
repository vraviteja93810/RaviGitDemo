package programs;

public class Test {
static int count=0;
{
	count++;
}
Test()
{
	System.out.println("No argument constructor");
}
Test(int i)
{
	System.out.println("Int argument constructor");
}
Test(double d)
{
	System.out.println("double argument constructor");
}
public static void main(String[] args) {
	Test t=new Test();
	Test t1=new Test(12);
	Test t2=new Test(12.9d);
	System.out.println("the number of objects created: "+count);
}
}

