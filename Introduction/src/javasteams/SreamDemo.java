package javasteams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SreamDemo {
	public static void main(String[] args) {
	
ArrayList<Integer> Marks=new ArrayList<Integer>();
Marks.add(25);
Marks.add(50);
Marks.add(70);
Marks.add(80);
Marks.add(85);
Marks.add(95);
//The above is arraylist.

//from the above collection we have to filter only even numbers.
System.out.println(Marks);
List<Integer> UpatedMarks = Marks.stream().map(i->i+5).collect(Collectors.toList());
//List<Integer> List2 = Marks.stream().filter(i->i%2==0).collect(Collectors.toList());
System.out.println(UpatedMarks);
	}
}
