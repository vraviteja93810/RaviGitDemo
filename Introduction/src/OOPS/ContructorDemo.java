package OOPS;

public class ContructorDemo {
	ContructorDemo()
{
	System.out.println(this);
	System.out.println(this.hashCode());
}
	public static void main(String[] args) {
		ContructorDemo c=new ContructorDemo();
	}
}
