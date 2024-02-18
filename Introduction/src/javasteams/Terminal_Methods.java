package javasteams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Terminal_Methods {
public static void main(String[] args) {
	//distinct()  limit()     count()
	List<String> VehiclesList = Arrays.asList("Bus","Car","Bycle","Bus","Car","Bike");
	List<String> ActualVehicleList = VehiclesList.stream().distinct().collect(Collectors.toList());
	System.out.println(ActualVehicleList);
	
	System.out.println(VehiclesList.stream().distinct().count());
	
	//below by using limit we are just fetching 4 objects only.
	System.out.println(VehiclesList.stream().limit(4).collect(Collectors.toList()));
}
}
