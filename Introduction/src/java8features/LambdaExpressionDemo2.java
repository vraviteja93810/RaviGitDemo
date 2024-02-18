package java8features;

public class LambdaExpressionDemo2 {
//I need to print two in vlaues input and print its sum using lambda expression.
	//below is normal method.
	public void add(int num1, int num2)
	{ 
		System.out.println(num1+num2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		()->{System.out.println("helllow");}
		
		//(int num1, int num2)->{System.out.println(num1+num2);}
		//Below our compiler will guess data types based on context. so here no need to mention data types as well.
		//(int num1, int num2)-> System.out.println(num1+num2);
		
		(num1, num2)-> System.out.println(num1+num2);
		
	}

}
