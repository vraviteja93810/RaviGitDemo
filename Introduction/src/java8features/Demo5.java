package java8features;
interface Argument
{
	public void add(int a, int b);
}
public class Demo5 {
public static void main(String[] args) {
	Argument A=(a,b)->System.out.println("Sum of a+b: "+(a+b));
	A.add(10, 20);
	A.add(30, 40);
	
}
}
