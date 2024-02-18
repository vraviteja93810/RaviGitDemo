package javasteams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
//count the number of names starting with alphabet in list
	@Test
	public void regular()
	{
	List<String> name=new ArrayList<String>();
	name.add("Abhijeet");
	name.add("Don");
	name.add("Alekhya");
	name.add("Adam");
	name.add("Ram");
	int count=0;
	
	for(int i=0;i<name.size();i++)
	{
		
		if(name.get(i).startsWith("A"))
		{
			count++;
		}
	}
	System.out.println(count);
	}
	
	
	@Test
	public void streamFilter()
	{
		List<String> name=new ArrayList<String>();
		name.add("Abhijeet");
		name.add("Don");
		name.add("Alekhya");
		name.add("Adam");
		name.add("Ram");
		long Count = name.stream().filter(s->s.startsWith("A")).count();
		System.out.println(Count);
		
		long d = Stream.of("Abhijith","Don","Alekya","Adam","Ram").filter(s->
		{
			s.startsWith("A");
			return false;
		}).count();
		System.out.println(d);
		
		
		//To print all the elements which are having its length greater than 4 using streams.
		//Use collection object to convert that into stream and continue further coding.
		name.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//if we want to print only one result/ first element from the stream.
		name.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		
	}
	
	@Test
	public void streamMap()
	{
		//printing the names which have last letter a and convert them into Upper case.
		Stream.of("Abhijith","Don","Alekya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Print names which have first letter as a with uppercase and sorted.
		Stream.of("Azbhijith","Don","Alekya","Adam","Rama").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
		//Two lists preparation.
		
		List<String> name1 = Arrays.asList("Azbhijith","Don","Alekya","Adam","Rama");//List 1
		List<String> name2=new ArrayList<String>();  //List 2
		name2.add("Ravi");
		name2.add("Prasad");
		name2.add("ReddiBabu");
		name2.add("Kiran");
		name2.add("Alivelu");
		
		Stream<String> NewStream = Stream.concat(name1.stream(), name2.stream());
		//we are sorting and printing
		//NewStream.sorted().forEach(s->System.out.println(s));
		
		boolean flag = NewStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		
	}
	
	@Test
	public void streamCollect()
	{
		//list
		List<String> NewList = Stream.of("Azbhijith","Don","Alekya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		
		//now we need to know the first element from the newList.
		System.out.println(NewList.get(0));
		
		List<Integer>name3=Arrays.asList(3,2,2,7,5,1,9,5);
		//print unique numbers.
		//sort the array.
		
		//name3.stream().distinct().forEach(s->System.out.println(s));
		//Here this Distict() method is used to remove the duplicate values in the stream and allow only unique values.
		
		//Suppose we need sorted and with out duplicates and finally we need to access 3rd index value
		//Here perform all the operations and then convert it back to collection and from that access 3rd index
		List<Integer> modifiedList = name3.stream().sorted().distinct().collect(Collectors.toList());
		System.out.println("3rd index: "+modifiedList.get(3));
	}
}
