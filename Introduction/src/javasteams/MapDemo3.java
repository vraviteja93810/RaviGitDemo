package javasteams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo3 {
public static void main(String[] args) {
	List<Integer> numbersList=Arrays.asList(12,45,26,72,15,86,40);
	
	//without streams
	for(int numbers:numbersList)
	{
		//here we are multiply all the values with 3
		System.out.println(numbers*3);
	}
	System.out.println();
	
	//with streams
	numbersList.stream().map(str->str*3).forEach(System.out::println);
	
}
}
