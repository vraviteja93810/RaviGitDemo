package javasteams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Terminal_Methods2 {
public static void main(String[] args) {
	List<Integer> numbersList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	//count.
System.out.println(numbersList.stream().filter(num->num%2==0).count());

//Min()
Optional<Integer> minimum = numbersList.stream().min((val1,val2)->{
	                                   return val1.compareTo(val2);
	                                  });
System.out.println(minimum.get());


//Max value.
Optional<Integer> MaxValue = numbersList.stream().max((val1, val2)-> 
                        { 
                        	return val1.compareTo(val2);
                          }
                        );
System.out.println(MaxValue.get());
}
}
