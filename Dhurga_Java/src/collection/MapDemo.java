package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class MapDemo {
private static Object m2;

public static void main(String[] args) {
	Map m=new HashMap();
	m.put("Chiranjeevi","100");
	m.put("Nagarjuna", 200);
	m.put("Venky",300);
	m.put("Raviteja", 600);
	System.out.println(m);
	Set s=m.keySet();
	System.out.println(s);
	Collection c = m.values();
	System.out.println(c);
	Set entry = m.entrySet();
	System.out.println(entry);
	Iterator itr = c.iterator();
	while(itr.hasNext())
	{
		  java.util.Map.Entry e1 = (Map.Entry)itr.next();
		  System.out.println(e1.getKey()+"  "+e1.getValue());
		  if(e1.getKey().equals("Raviteja"))
		  {
			  e1.setValue(10000);
		  }
	}
	System.out.println(m);
}
}
