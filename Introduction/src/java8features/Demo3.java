package java8features;

interface FuncationInterface2 {
public void m1();
}

public class Demo3 {
	public static void main(String[] args) {
		FuncationInterface2 f=()->System.out.println("M1 Implementation");
		f.m1();
	}
}
