package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
public static void main(String[] args) {
	ArrayList a=new ArrayList();
	for(int i=0;i<=10;i++)
	{
		a.add(i);
	}
	Iterator itr = a.iterator();
	while(itr.hasNext())
	{
		 Integer items = (Integer)itr.next();
		 if(items%2==0)
		 {
			 System.out.println(items);
		 }
		 else
		 {
			 itr.remove();
		 }
		
	}
	 System.out.println(a); 
}
}
