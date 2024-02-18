package javasteams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo2 {
public static void main(String[] args) {
	List<String> vehicles=Arrays.asList("Bus","Bicycle","Flight","Train");
	List<Integer>VehiclesUppercase=new ArrayList<Integer>();
	
	//with for loop without using streams.
	for(String names:vehicles)
	{
		System.out.print(names.length()+" ");
	}
	System.out.println();
	
	//Here we want to fetch the all lengths of the above elements.
	//with using streams.
	vehicles.stream().map(str->str.length()).forEach(System.out::print);
	
	
}
}
