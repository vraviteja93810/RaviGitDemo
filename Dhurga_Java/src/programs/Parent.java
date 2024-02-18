package programs;

public class Parent {
protected void m1()

{
	System.out.println("Most missunderstanding modifier is protected.");
	}
static int x=10;
int y=20;
transient String password;
public static void main(String[] args) {
	Parent p=new Parent();
	p.x=2222;
	p.y=999;
	System.out.println("value of x: "+p.x+" y vlaue is: "+p.y);
	Parent p2=new Parent();
	System.out.println("value of x: "+p2.x+" y vlaue is: "+p2.y);
			
}
}
