package MultiThreading;

public class MultiThreadDemo4 extends Thread{
	public void start()
	{
		super.start();
		System.out.println("start method");
	}
public void run()
{
	System.out.println("run method");
}

public static void main(String[] args) {
	MultiThreadDemo4 D=new MultiThreadDemo4();
	D.start();
	System.out.println("Main thread");
	D.start();
}
}
