import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class DatadrivenDemo {
public static void main(String[] args) throws IOException {
	DatadrivenTest t=new DatadrivenTest();
	ArrayList<String> LibraryData = t.getData("RestAddbook", "RestAssured");
	Map<String, Object>  jsonAsMap = new HashMap<>();
	jsonAsMap.put("name", LibraryData.get(1));
	jsonAsMap.put("isbn", LibraryData.get(2));
	jsonAsMap.put("aisle", LibraryData.get(3));
	jsonAsMap.put("author", LibraryData.get(4));
//	Map<String, Object> jsonAsMap2=new HashMap<>();
//	jsonAsMap2.put("lat", "-38.585");
//	jsonAsMap2.put("lang", "33.54874");
//	jsonAsMap.put("location", jsonAsMap2);
	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String response = given().log().all().header("Content-Type","application/json")
	.body(jsonAsMap)
	.when().post("/Library/Addbook.php")
	.then().log().all().assertThat().statusCode(200).extract().asString();
	JsonPath js=new JsonPath(response);
	String id=js.getString("ID");
	System.out.println(id);
}
}
