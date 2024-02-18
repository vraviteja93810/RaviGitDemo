package JavaprogramsArrays;

import java.util.*;

public class ArrayListDemo2 {
	public static void main(String[] args) {
		
ArrayList<String> al=new ArrayList<String>();
al.add("Rahul");
al.add("Shetty");
al.add("Academy");
al.add("Selenium");
String[] name= {"Rhusl", "Shetty", "Academy"};
//Now we will convert the String array to Arraylist.
List<String> nameArrayList = Arrays.asList(name);
//Here Arrays.asList(name of the String array we need to give here);
//Then store it in local variable.
System.out.println(nameArrayList.contains("Shetty"));

}
}
