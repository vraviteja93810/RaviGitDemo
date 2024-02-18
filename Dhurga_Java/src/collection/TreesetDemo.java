package collection;

import java.util.TreeSet;

public class TreesetDemo {
public static void main(String[] args) {
	TreeSet t=new TreeSet(new TreeComaparator());
	t.add("A");
	t.add(new StringBuffer("ABC"));
	t.add(new StringBuffer("AA"));
	t.add("x");
	t.add("zz");
	
	}
}
