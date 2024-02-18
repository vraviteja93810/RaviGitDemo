package java8features;

public class Demo4 implements InterfaceExample1 {

	
	public void add(int a, int b) {
		System.out.println(a+b);
		
	}
	public static void main(String[] args) {
		InterfaceExample1 I=new Demo4();
		I.add(10, 20);
	}

}
