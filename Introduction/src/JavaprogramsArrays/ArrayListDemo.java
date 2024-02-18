package JavaprogramsArrays;

import java.util.*;

public class ArrayListDemo {
	public static void main(String[] args) {
		
ArrayList<String> al=new ArrayList<String>();
al.add("Rahul");
al.add("Shetty");
al.add("Academy");
al.add("Selenium");
for(int i=0;i<al.size();i++) //-> size method used to return the size of arraylist
{
	System.out.println(al.get(i));	
}
System.out.println(al.contains("Selenium")); //--> this contains method is
//used to search the any value in arraylist.


al.remove(2); //--> remove used to remove the value from the array list using index
String value = al.get(2);//--> Here we use get to extract value from the index
System.out.println(value);	


}
}
