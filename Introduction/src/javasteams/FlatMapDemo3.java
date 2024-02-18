package javasteams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
	String name;
	int sid;
	char grade;

	Student(String name, int sid, char grade) {
		this.name = name;
		this.sid = sid;
		this.grade = grade;
	}
}

public class FlatMapDemo3 {
	public static void main(String[] args) {
		List<Student> StudentList1 = Arrays.asList(new Student("Ravi", 10, 'A'), 
				new Student("Prasad", 11, 'A'),
				new Student("Babu", 12, 'B'));

		List<Student> StudentList2 = Arrays.asList(new Student("RaviTeja", 10, 'A'),
				new Student("ReddiPrasad", 11, 'A'), 
				new Student("ReddiBabu", 12, 'B'));

		List<Student> StudentList3 = Arrays.asList(new Student("VRavi", 10, 'A'), 
				new Student("VPrasad", 11, 'A'),
				new Student("VBabu", 12, 'B'));
		
		List<List<Student>> AllStudentList=Arrays.asList(StudentList1, StudentList2, StudentList3);
		//Fetch the name of the students.
		List<String> ActualStudentList = AllStudentList.stream().flatMap(x->x.stream().map(y->y.name)).collect(Collectors.toList());
		System.out.println(ActualStudentList);
	}
}
