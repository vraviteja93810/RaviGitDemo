package java8features;

public class LambdaExpressionDemo3 {
//I need to print length of string using lambda expressions.
	/*
	public int add(String name)
	{ 
		System.out.println(name.length());
		return name.length();
	}
	*/
	
	public static void main(String[] args) {
		
		//(String name)->{return name.length()}
		//Some more siplified manner
		//(name)-> return name.length();
		
		//(name)-> name.length();
		//More simplified manner below.
		
		name-> name.length();
		
	}
	

}
