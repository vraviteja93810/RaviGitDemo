package JavaprogramsArrays;

public class StringDemo {
	public static void main(String[] args) {
		//String Literal
		//Here if the content is same still for s2 it is not going to create new object.
		//S2 is pointing to s object only.
		//This behavior we can observe in String literal.
		String s="Rahul shetty academy";
		String s2="Rahul shetty academy";
		
		//new keyword used to create separate object here for every time.
		//even though the content is same
		String s3=new String("welcome");
		String s4=new String("welcome");
		
		//Generally we can define our string in two ways.
		//1. By using string literal
		//2. By using new operator
		
		//if we want to split the spaces in word given below let see the method for that.
		String s5="Rahul shetty academy";
		String[] splittedString=s5.split(" ");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[2]);
		
		//If we want to split the particular word
		String[] splittedString2=s5.split("shetty");
		System.out.println(splittedString2[0]);
		System.out.println(splittedString2[1]);

		System.out.println(splittedString[1].trim());
		
		//If we want to print the String by character by character.
		for(int i=0;i<s5.length();i++)
		{
			System.out.println(s5.charAt(i));
		}
	}
}
