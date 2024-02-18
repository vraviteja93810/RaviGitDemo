package javasteams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Terminal_Methods3 {
public static void main(String[] args) {
	//Reduce method demo
	List<String> stringList=Arrays.asList("A","B","C","D","E","F");
	
	Optional<String> WholeList = stringList.stream().reduce((value,combinedValue)->{
		return combinedValue+value;
	});
	System.out.println(WholeList.get());
	}
}

