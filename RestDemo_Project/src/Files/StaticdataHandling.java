package Files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StaticdataHandling {

	@Test()
	public void addBook() throws IOException
	{
		RestAssured.baseURI="http://216.10.245.166";
		String Response=given().log().all().header("Content-Type","application/json").body(new String(Files.readAllBytes(Paths.get("C:\\Users\\vredd\\OneDrive\\Desktop\\AddBook.json")))).
		when()
		.post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath Js = Reuse_Methods.rawToJson(Response);
		 String id=Js.getString("ID");
		 System.out.println(id);
		 
		 
		 //delete API.
			String Res = given().log().all().header("Content-Type","application/json").body(Payload.deleteBookId(id))
			.when()
			.post("/Library/DeleteBook.php").
			then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
			JsonPath jsResponse = Reuse_Methods.rawToJson(Res);
			String message=jsResponse.getString("msg");
			System.out.println(message);
		 
		
	}
	
}
