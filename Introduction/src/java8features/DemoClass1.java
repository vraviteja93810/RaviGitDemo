package java8features;

public class DemoClass1 implements FuncationalInterface1{

	
	public void m1() {
		System.out.println("M1 method implementation.");
		
	}
	public static void main(String[] args) {
		FuncationalInterface1 f=new DemoClass1();
		f.m1();
	}

}
