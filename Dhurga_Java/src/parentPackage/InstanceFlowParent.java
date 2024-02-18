package parentPackage;

public class InstanceFlowParent {
int i=10;
{
	m1();
	System.out.println("Parent instance block");
	
}
InstanceFlowParent()
{
	System.out.println("Parent constructor");
}
public static void main(String[] args) {
	InstanceFlowParent p=new InstanceFlowParent();
	System.out.println("Parent main");
}
public void m1()
{
	System.out.println(j);
}
int j=20;
}
