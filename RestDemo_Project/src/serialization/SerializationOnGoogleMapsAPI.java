package serialization;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SerializationOnGoogleMapsAPI {
public static void main(String[] args) {
	AddPlace place=new AddPlace();
	place.setAccuracy(50);
	place.setAddress("2-141, BTM layout, cohen 09");
	place.setLanguage("Telugu");
	Location locat=new Location();
	locat.setLat(-38.383494);
	locat.setLng(33.427362);
	place.setLocation(locat);
	place.setName("Kalikirii");
	place.setPhone_number("9848263646");
	List<String> mylist=new ArrayList();
	mylist.add("shoe park");
	mylist.add("shop");
	place.setTypes(mylist);
	place.setWebsite("www.ravitejaAcademy.com");
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String Res=given().log().all().queryParam("key","qaclick123").body(place)
	.when().post("/maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(Res);
}
}
