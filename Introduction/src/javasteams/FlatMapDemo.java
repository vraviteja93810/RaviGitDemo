package javasteams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {
public static void main(String[] args) {
	
	//Map example.
	List<Integer> list=Arrays.asList(1,2,3,4,5);
	List<Integer> NewList = list.stream().map(n->n+10).collect(Collectors.toList());
	System.out.println(NewList);
	System.out.println();
	
	
//FlatMap()
	List<Integer> list1= Arrays.asList(1,2);
	List<Integer> list2=Arrays.asList(3,4);
	List<Integer> list3=Arrays.asList(5,6);
	
	 List<List<Integer>> mainList=Arrays.asList(list1, list2, list3);
	 //we need to move this mainList to the stream.
	 
	 List<Integer> FinalResult = mainList.stream().flatMap(x->x.stream().map(n->n+10)).collect(Collectors.toList());
	 System.out.println(FinalResult);
	 
}
}
