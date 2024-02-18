package parallelstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
	String name;
	int score;

	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}
}

public class parallel_Streams1 {

	public static void main(String[] args) {

		List<Student> studentList = Arrays.asList(new Student("Ravi", 90), new Student("Prasad", 95),
				new Student("kiran", 94), new Student("Babu", 100), new Student("Seki", 92), new Student("Muni", 93),
				new Student("Teja", 80));
		// Normal Stream.
		studentList.stream().filter(result -> result.score > 80).limit(3)
				.forEach(R -> System.out.println(R.getName() + " " + R.getScore()));
		System.out.println("............................................");

		// Parallel Stream.
		System.out.println("************Parallel stream************");
		studentList.parallelStream().filter(result -> result.score > 80).limit(3)
				.forEach(R -> System.out.println(R.getName() + " " + R.getScore()));

		System.out.println("************Parallel stream************");
		// Parallel method usage
		// By using parallel method i am converting this sequential stream to parallel
		// stream.
		studentList.stream().parallel().filter(result -> result.score > 80).limit(3)
				.forEach(R -> System.out.println(R.getName() + " " + R.getScore()));
	}
}
