package java8features;

interface InterfaceDemo 
{
public int getLength(String s);
}
public class Demo6 {

	public static void main(String[] args) {
		InterfaceDemo I=s-> s.length();
		System.out.println(I.getLength("Ravi"));
	}
}
