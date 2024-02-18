package JavaInterviewprograms;

import java.util.Scanner;

public class Reverse_Number {
 
	public static void main(String[] args) {
		
		//Basically we have 3 ways to rever the number.
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int num=sc.nextInt(); //1234
		
		//Using some algorithm we can reverse
		int rev=0;
		while(num!=0)
		{
			rev=rev*10 + num%10;
			num=num/10;
			                    //4 remainder we get  4+10*0=4;
			                    //3 remainder we get 3+10*4=43;
			                    //2 remainder we get 2+10*43=432;
			                    //1 remainder we get 1+10*432=4321
		}
		System.out.println(rev);
	}
	
}
