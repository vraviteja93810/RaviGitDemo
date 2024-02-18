package javasteams;

import java.util.ArrayList;
import java.util.List;


	public class FilterDemo4{
		public static void main(String[] args) {
			
			List<FilterDemo3> products=new ArrayList<FilterDemo3>();
			//Below inside of products list we are directly giving the values.
		    products.add(new FilterDemo3(10,"Ravi",10));
		    products.add(new FilterDemo3(10,"Ravi2",100));
		    products.add(new FilterDemo3(10,"Rav3",1000));
		    products.add(new FilterDemo3(10,"Rav4",10000));
		    products.add(new FilterDemo3(10,"Rav5",100000));

		    products.stream().filter(str->str.price>2500).forEach(str->System.out.println(str.price));
		    
		}
	}


