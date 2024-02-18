package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
public AddPlace addPlacePayload(String name, String address, String language)
{
	AddPlace place=new AddPlace();
	place.setAccuracy(50);
	place.setAddress(address);
	place.setLanguage(language);
	Location locat=new Location();
	locat.setLat(-38.383494);
	locat.setLng(33.427362);
	place.setLocation(locat);
	place.setName(name);
	place.setPhone_number("9848263646");
	List<String> mylist=new ArrayList();
	mylist.add("shoe park");
	mylist.add("shop");
	place.setTypes(mylist);
	place.setWebsite("www.ravitejaAcademy.com");
	return place;
}

public String deletePlacePayload(String place_id)
{
	 return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
}
}
