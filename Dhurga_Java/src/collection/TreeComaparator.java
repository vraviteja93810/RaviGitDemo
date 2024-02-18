package collection;

import java.util.Comparator;

public class TreeComaparator implements Comparator{

	
	public int compare(Object o1, Object o2) {
		String s1=(String)o1;
		String s2=(String)o2;
		int slLength=s1.length();
		int s2Length=s2.length();
		if(slLength<s2Length)
		{
			return -1;
		}
		else if (slLength>s2Length)
		{
			return 1;
		}
		else 
		{
		return s1.compareTo(s2)	;
		}
		}

}
