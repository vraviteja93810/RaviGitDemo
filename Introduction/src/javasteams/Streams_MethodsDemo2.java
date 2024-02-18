package javasteams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams_MethodsDemo2 {
public static void main(String[] args) {
	//anyMatch
	Set<String> fruites=new HashSet();
	fruites.add("one Apple");
	fruites.add("one mango");
	fruites.add("Two apples");
	fruites.add("More grapes");
	fruites.add("two guavas");
//anyMatch	
boolean Result1 = fruites.stream().anyMatch(value->{return value.startsWith("one");});
System.out.println(Result1);

//allMatch
boolean Result2 = fruites.stream().allMatch(value->{return value.startsWith("one");});
System.out.println(Result2);

//noneMatch
boolean Result3 = fruites.stream().noneMatch(value->{return value.startsWith("one");});
System.out.println(Result3);

//findAny
Optional<String> Result4 = fruites.stream().findAny();
System.out.println(Result4.get());

//findAll
Optional<String> Result5 = fruites.stream().findFirst();
System.out.println(Result5.get());

//Stream concatenation.
List<String> animalsList=Arrays.asList("DOG","CAT","ELEPHANT");
Stream<String> stream1 = animalsList.stream();

List<String>birdsList=Arrays.asList("peackock","parrot","crow");
Stream<String> stream2 = birdsList.stream();

//now we need to concatenate these two streams.
//use stream class from that use concat method.
 List<String> FinalStream = Stream.concat(stream1, stream2).collect(Collectors.toList());
System.out.println(FinalStream);

}
}
