import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.Payload;
import Files.Reuse_Methods;

import static io.restassured.RestAssured.*;

public class Basics {

	public static void main(String[] args) {
		//Add place API.
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String Response=given().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(Payload.addPlace()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
		      .body("scope",equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)").extract().asString();
		System.out.println(Response);
		
		JsonPath js=Reuse_Methods.rawToJson(Response);
		String placeId=js.getString("place_id");
		String address=js.getString("address");
		System.out.println(placeId);
		
		
		//Update place API.
		String newAddress="Banglore, Karnataka";
		given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId).header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		
		//Get place
		String getPlaceResponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().extract().asString();
		
		 JsonPath Json = Reuse_Methods.rawToJson(getPlaceResponse);
		 String actualAddress = Json.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(newAddress,actualAddress);
		
	}

}
