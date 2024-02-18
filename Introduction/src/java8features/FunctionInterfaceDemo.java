package java8features;

@FunctionalInterface
public interface FunctionInterfaceDemo {
	
public void m1();
public void m4();

default void m2()
{
	System.out.println("Hi");
}
public static void m3()
{
	
}


}
