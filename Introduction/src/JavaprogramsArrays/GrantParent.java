package JavaprogramsArrays;

public class GrantParent extends Parent2{
	int a;
public GrantParent(int a) {
	    super(a);//parent class constructor got invoked
		this.a=a;
	}

public int increment()
{
	
	a=a+1;
	return a;
}

public int decrement()
{
	a=a-1;
	return a;
}
}
