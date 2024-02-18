package test;

import org.testng.annotations.Test;

public class FramewordDemo {
@Test(groups = "smoke")
public void demo()
{
	System.out.println("Hellow");
}

@Test(enabled=false)
public void Demo2()
{
	System.out.println("hi");
}
}
