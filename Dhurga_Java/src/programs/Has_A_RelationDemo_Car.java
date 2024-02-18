package programs;

public class Has_A_RelationDemo_Car {
private String color;
private int maxSpeed;
public static void main(String args[])
{
	Has_A_RelationDemo_Car Tata=new Has_A_RelationDemo_Car();
	Tata.setColor("RED");
	Tata.setMaxSpeed(500);
	Tata.carInfo();
	Maserati quattroporte=new Maserati();
	quattroporte.MaseratiStartDemo();
	
}
public void setMaxSpeed(int maxSpeed)
{
	this.maxSpeed=maxSpeed;
}
public void setColor(String color)
{
	this.color=color;
}
public void carInfo()

{
System.out.println("car color="+color+" "+"Maxspeed:"+maxSpeed);

}
}
