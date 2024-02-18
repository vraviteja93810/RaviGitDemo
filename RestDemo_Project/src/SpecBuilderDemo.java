 import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.Payload;
import Files.Reuse_Methods;

import static io.restassured.RestAssured.*;

public class SpecBuilderDemo {

	public static void main(String[] args) {
		RequestSpecification req = new RequestSpecBuilder()
		.setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key","qaclick123")
		.setContentType(ContentType.JSON)
		.build();
		
		//Response spec builder.
		 ResponseSpecification ResponseSpec = new ResponseSpecBuilder()
		.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.build();
		//Add place API.
		        RequestSpecification Request = given().spec(req).body(Payload.addPlace());
				String Response = Request.when().post("/maps/api/place/add/json")
				.then().spec(ResponseSpec)
		        .body("scope",equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)").extract().asString();
		
		
		JsonPath js=Reuse_Methods.rawToJson(Response);
		String placeId=js.getString("place_id");
		String address=js.getString("address");
		System.out.println(placeId);
		
		
		//Update place API.
		String newAddress="Banglore, Karnataka";
		given().spec(Request).queryParam("place_id",placeId)
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json")
		.then().spec(ResponseSpec).assertThat().body("msg",equalTo("Address successfully updated"));
		
		
		//Get place
		String getPlaceResponse = given().spec(Request).queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().spec(ResponseSpec).extract().asString();
		
		 JsonPath Json = Reuse_Methods.rawToJson(getPlaceResponse);
		 String actualAddress = Json.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(newAddress,actualAddress);
		
	}

}
