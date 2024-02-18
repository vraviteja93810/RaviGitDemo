package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorDemo {
public static void main(String[] args) {
	LinkedList list =new LinkedList();
	list.add("Balakrishna");
	list.add("Venki");
	list.add("chiru");
	list.add("nag");
	System.out.println(list);
	ListIterator litr = list.listIterator();
	while(litr.hasNext())
	{
		String value = (String)litr.next();
		if(value.equals("Venki"))
		{
			litr.remove();
		}
		else if(value.equals("nag"))
		{
			litr.add("Chai");
		}
		else if(value.equals("chiru")) {
			litr.add("charan");
		}
		
	}
	System.out.println(list);
	System.out.println(litr.getClass().getName());
	ArrayList a=new ArrayList();
	Iterator itr = a.iterator();
	System.out.println(itr.getClass().getName());
}
}
