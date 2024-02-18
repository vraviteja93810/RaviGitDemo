package javasteams;

import java.util.Arrays;
import java.util.List;

public class ArrayOfMethod {
public static void main(String[] args) {
	List<String> stringList=Arrays.asList("A","B","C","D","E","F");
	
	Object[] Array = stringList.stream().toArray();
	for(int i=0;i<Array.length;i++)
	{
		System.out.println(Array[i]);
	}
}
}
