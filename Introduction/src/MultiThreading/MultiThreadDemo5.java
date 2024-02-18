package MultiThreading;

public class MultiThreadDemo5 implements Runnable{
	
public void run()
{
	for(int i=0;i<10;i++)
	{
		System.out.println("Child thread");
	}
}

public static void main(String[] args) {
	MultiThreadDemo5 D=new MultiThreadDemo5();
	Thread t=new Thread(D);
	t.start();
	//now we have two threads.
	//1. Main thread   2. Child thread
	for(int i=0;i<10;i++)
	{
	System.out.println("Main thread");
	}
}
}
