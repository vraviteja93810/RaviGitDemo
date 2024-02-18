package javasteams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FitlerDemo2 {
public static void main(String[] args) {
	//we filter the null values from the collections. we need to remove the null from the collection.
	List<String> words=Arrays.asList("Cup",null,"forest",null,"theatre");
	List<String> ActualWords=words.stream().filter(str->str!=null).collect(Collectors.toList()); 
		System.out.println(ActualWords);
}
}
