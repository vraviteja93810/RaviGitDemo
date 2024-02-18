package JavaInterviewprograms;

public class SwapNumberDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*-----------------------LOGIC 1 of swapping-------------------
		//swaping means interchanging the values.
		//5ways to swap the numbers.
		//1st way:-
		  
		  
		 
		int a=10, b=20;
		System.out.println("Before swapping values are:"+a+" "+b);
		// 1st way:- here we store one of the value inside of temparory variable
		int t=a;
		a=b;
		b=t;
		System.out.println("After swapping values are:"+a+" "+b);
		
		
*/
		
/*		
		
		//----------------LOGIC 2 of swapping----------------
	//Instead of using third variable( temp variable) we use - and + operators.
		int a=10, b=20;
		System.out.println("Before swapping values are:"+a+" "+b);
		a=a+b;//--> 30=10+20
		b=a-b;//--> 10=30-20
		a=a-b;//--> 20=30-10
		
		System.out.println("After swapping values are:"+a+" "+b);
*/
		
//------------------LOGIC 3 of swapping--------------------
		//Here instead of using - & + and third variable, we use * and / operators.
		
		int a=10, b=20;
		System.out.println("Before swapping values are:"+a+" "+b);
		//Here a and b values should not be zero. then only this above logic will work
		a=a*b; // 200=10*20;
		b=a/b;//  10=200/20;
		a=a/b;//  20=200/10;
		System.out.println("After swapping values are:"+a+" "+b);
		
	}

}
