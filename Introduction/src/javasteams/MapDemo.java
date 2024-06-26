package javasteams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {
public static void main(String[] args) {
	List<String> vehicles=Arrays.asList("Bus","Bicycle","Flight","Train");
	List<String>VehiclesUppercase=new ArrayList<String>();
	/*
	//we need to convert the above words into upper case.
	//without using Streams.
	List<String>VehiclesUppercase=new ArrayList<String>();
	
	for(String name:vehicles)
	{
		VehiclesUppercase.add(name.toUpperCase());
		
	}
	System.out.println(VehiclesUppercase);
	*/
	
	
	//Another way using streams.
	VehiclesUppercase=vehicles.stream().map(str->str.toUpperCase()).collect(Collectors.toList());
	System.out.println(VehiclesUppercase);
	
}
}
