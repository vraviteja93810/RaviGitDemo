package MultiThreading;

public class MultiThreadDemo1 extends Thread{
	
	//Here run method belongs to the Thread class.
	//below we are overrind the child method called run() method.
public void run()
{
	for(int i=0;i<10;i++)
	{
		System.out.println("Child thread");
	}
}
}

