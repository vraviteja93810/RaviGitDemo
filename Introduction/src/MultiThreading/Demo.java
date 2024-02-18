package MultiThreading;

public class Demo {
	public static void main(String[] args) {
		MultiThreadDemo1 m=new MultiThreadDemo1();	
		m.start();
		for(int i=0;i<10;i++)
		{
			System.out.println("Main thread");
		}
	}
}
