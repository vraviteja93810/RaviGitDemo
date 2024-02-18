package javasteams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {
public static void main(String[] args) {
	List<String> Names = Arrays.asList("Melisandre","Sansa","Jon","Daenerys","Joffery");
	
	//If the name is greater than 6 and less than 8 (length) then we need to fetch that value.
List<String> longNames=new ArrayList<String>();

longNames=Names.stream().filter(str->str.length()>6&& str.length()<8).collect(Collectors.toList());
System.out.println(longNames);
}
}
