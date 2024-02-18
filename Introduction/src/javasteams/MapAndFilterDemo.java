package javasteams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee
{
	int empId;
	String empName;
	int salary;
	
	Employee(int empId, String empName, int salary)
	{
		
	}
}


public class MapAndFilterDemo {
public static void main(String[] args) {
	//One way to add the values into collection 
	//List<Employee> EmployeeList=new ArrayList<Employee>();
	//EmployeeList.add(new Employee(12,"Ravi",231216));
	
	//Another way.
	
	List<Employee> EmployeeList=Arrays.asList(
			new Employee(101,"Alex",12000),
			new Employee(101,"Alex",22000),
			new Employee(101,"Alex",32000),
			new Employee(101,"Alex",1000),
			new Employee(101,"Alex",10000));
	
	//Now we need to print the salaries of employees greater than 20000;
	List<Integer> NewList = EmployeeList.stream().filter(str->str.salary >2000).map(st->st.salary).collect(Collectors.toList());
	System.out.println(NewList);
}
}
