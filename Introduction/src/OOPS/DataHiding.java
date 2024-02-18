package OOPS;

public class DataHiding {
private int id;
private String name;
private String department;

public DataHiding(int id, String name, String department)
{
	this.id=id;
	this.name=name;
	this.department=department;
}
public int getId()
{
	return id;
}
public String getName()
{
	return name;
}
public String getDeartment()
{
	return department;
}
public void setDepartment(String department)
{
	this.department=department;
}
public static void main(String[] args) {
	DataHiding d=new DataHiding(101,"Ravi","Computer");
	System.out.println("employee Id:"+d.id);
	System.out.println("employee Name:"+d.name);
	System.out.println("employee Department:"+d.department);
	System.out.println();
	
	//Update employee department
	d.setDepartment("HR");
	System.out.println("employee Id:"+d.id);
	System.out.println("employee Name:"+d.name);
	System.out.println("employee Department:"+d.department);
}
}
