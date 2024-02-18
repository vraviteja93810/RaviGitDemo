package stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils{
	ResponseSpecification ResponseSpec;
	RequestSpecification req;
	Response response;
	RequestSpecification requestSpec;
	TestDataBuild data=new TestDataBuild();
	static String place_id;
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String language) throws IOException {
		requestSpec = given().spec(requestSpecification()).body(data.addPlacePayload(name, address,language));
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource,String method) {
		//Calling Enum constructor
		
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource()); 
		ResponseSpec=new ResponseSpecBuilder()
		.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.build(); 
		if(method.equalsIgnoreCase("post"))
		
	 response = requestSpec.when().post(resourceAPI.getResource());
				//.then().spec(ResponseSpec).extract().response();
		
		else if(method.equalsIgnoreCase("GET"))
			response = requestSpec.when().get(resourceAPI.getResource());
					//.then().spec(ResponseSpec).extract().response();
		else if (method.equalsIgnoreCase("DELETE"))
			response = requestSpec.when().delete(resourceAPI.getResource());
			//.then().spec(ResponseSpec).extract().response();
	}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer statusCode) {
		assertEquals(response.getStatusCode(),200);
		
	}
	@Then("{string} in response body is {string}")
	public void is_in_response_body_is(String keyValue, String Expectedvalue) {
     
     assertEquals(getJsonPath(response,keyValue),Expectedvalue);
     
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectName, String resource) throws IOException {
	    //first we have to create request spec.
		 place_id = getJsonPath(response, "place_id");
		requestSpec = given().spec(requestSpecification()).queryParam("place_id",place_id);
		user_calls_with_http_request(resource,"GET");
		String Actualname = getJsonPath(response, "name");
		assertEquals(Actualname,expectName);
	}
	
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
		requestSpec =given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}

}