package RahulPrograms;

public class NestedLoopDemo {
public static void main(String[] args) {
	for(int i=1;i<4;i++)//this block will run 10 times.  //this is outer loop.
	{
		System.out.println("I am outer loop");
		System.out.println();
		for(int j=0;j<4;j++)//this is inner for loop.
		{
			System.out.println("I am Inner loop");
		}
	}
}
}
