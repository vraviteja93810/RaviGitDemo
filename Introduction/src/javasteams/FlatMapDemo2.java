package javasteams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo2 {
public static void main(String[] args) {
	List<String> teamA=Arrays.asList("Scott","Ravi","Pawan");
	List<String> teamB=Arrays.asList("Mary","Jp morgon","Infosys");
	List<String> teamC=Arrays.asList("ken","Jony","Kitty");
	
	List<List<String>> PlayersWorldCup=new ArrayList<List<String>>();
	PlayersWorldCup.add(teamA);
	PlayersWorldCup.add(teamB);
	PlayersWorldCup.add(teamC);
	
	//Without Stream
	for(List<String>team:PlayersWorldCup)
	{
		for(String name:team)
		{
			System.out.println(name);
		}
	}
	System.out.println();
	
	//With stream concept.
	List<String> ActualList = PlayersWorldCup.stream().flatMap(x->x.stream()).collect(Collectors.toList());
	System.out.println(ActualList);
}
}
