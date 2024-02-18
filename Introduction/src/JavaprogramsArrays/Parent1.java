package JavaprogramsArrays;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parent1 extends Parent{
	
@Test
public void testRun()
{
	GrantParent g=new GrantParent(3);
	int a=3;
	doThis();//--> Here we are just calling this method from the child
	System.out.println(g.increment());
	System.out.println(g.decrement());
	System.out.println(g.multiplyTwo());
	System.out.println(g.multipleyThree());
}
}
