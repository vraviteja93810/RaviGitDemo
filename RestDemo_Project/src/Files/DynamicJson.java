package Files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class DynamicJson {

	@Test(dataProvider="getBooksData")
	public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String Response=given().log().all().header("Content-Type","application/json").body(Payload.Addbook(isbn,aisle)).
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
	
	@DataProvider
	public Object[][] getBooksData()
	{
	  return new Object[][] {{"ijsstye","9532487"}, {"dersvasd","843757"}, {"efwresdre","78968614"}};
	}
}
