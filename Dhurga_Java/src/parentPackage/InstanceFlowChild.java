package parentPackage;

public class InstanceFlowChild extends InstanceFlowParent{
int x=100;
{
	m2();
	System.out.println("Child first instance block");
}
InstanceFlowChild()
{
	System.out.println("Child constructor");
}
public static void main(String[] args) {
	InstanceFlowChild child=new InstanceFlowChild();
	System.out.println("Child main method");
}
public void m2()
{
	System.out.println(y);
}
{
	System.out.println("Child second instance block");
}
int y=20;
}
