package OOPS;

public class InheritanceDemo2 extends InheritanceDemo{
int rollno;
int marks;
InheritanceDemo2(String name, int age, int rollno, int marks)
{
	super(name, age);
	this.rollno=rollno;
	this.marks=marks;
}
public static void main(String[] args) {
	InheritanceDemo2 i1=new InheritanceDemo2("Ravi",25,20,100);
}
}

