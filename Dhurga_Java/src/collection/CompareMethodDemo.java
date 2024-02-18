package collection;

import java.util.Comparator;
import java.util.TreeSet;

public class CompareMethodDemo {
public static void main(String[] args) {
	TreeSet t=new TreeSet(new ComparatorDemo());
	t.add(10);
	t.add(11);
	t.add(45);
	t.add(12);
	t.add(48);
	t.add(70);
	System.out.println(t);
}
}
