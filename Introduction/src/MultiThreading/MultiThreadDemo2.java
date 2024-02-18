package MultiThreading;

public class MultiThreadDemo2 extends Thread{
public void run()
{
	System.out.println("No arg run method");
}
public void run(int i)
{
	System.out.println("int arg run method");
}
public static void main(String[] args) {
	MultiThreadDemo2 D=new MultiThreadDemo2();
	D.start();
}
}
