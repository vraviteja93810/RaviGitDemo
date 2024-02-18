package javasteams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethodsDemo1 {
public static void main(String[] args) {
	List<Integer> list1=Arrays.asList(2,4,1,6,5,7,8);
	List<Integer> sortedList = list1.stream().sorted().collect(Collectors.toList());
	System.out.println(sortedList);
	
	//Reverse order
 List<Integer> NewSortedList = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	System.out.println(NewSortedList);
	
	List<String> names=Arrays.asList("John","Teja","Prasad","Reddi");
	List<String> sortednames = names.stream().sorted().collect(Collectors.toList());
	System.out.println(sortednames);
	
	List<String> ReverseList = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	System.out.println(ReverseList);
}
}
