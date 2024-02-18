package Files;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class JiraTest {
public static void main(String[] args) {
	
	SessionFilter session=new SessionFilter();
	
	//Login API
	RestAssured.baseURI="http://localhost:8080";
	String Response=given().relaxedHTTPSValidation().log().all().header("Content-Type","application/json")
	.body("{ \r\n"
			+ "    \"username\": \"vraviteja2094\", \r\n"
			+ "\"password\": \"Vraviteja@12345\" \r\n"
			+ "}").filter(session).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();
	
	
	//Adding Comment to the issue
	String expectedMessage="Hi how are you?";
	String CommentsDetails=given().pathParam("id","10004").log().all().header("Content-Type","application/json")
	.body("{\r\n"
			+ "    \"body\": \""+expectedMessage+"\",\r\n"
			+ "    \"visibility\": {\r\n"
			+ "        \"type\": \"role\",\r\n"
			+ "        \"value\": \"Administrators\"\r\n"
			+ "    }\r\n"
			+ "}").filter(session).when().post("/rest/api/2/issue/{id}/comment").then().log().all()
	.assertThat().statusCode(201).extract().response().asString();
	JsonPath js2=new JsonPath(CommentsDetails);
	String commentId = js2.getString("id");
	
	
	//Add attachment.
	given()
	.pathParam("id","10004").log().all()
	.header("X-Atlassian-Token","no-check")
	.filter(session)
	.header("Content-Type","multipart/form-data")
	.multiPart("file", new File("jira.txt"))
	.when().post("/rest/api/2/issue/{id}/attachments")
	.then().log().all().assertThat().statusCode(200);
	
	//Get Issue
	String IssueDetails = given().log().all()
	.filter(session)
	.pathParam("id", "10004")
	.queryParam("fields","comment")
	.when().get("/rest/api/2/issue/{id}")
	.then().log().all().extract().response().asString();
	System.out.println(IssueDetails);
	
	//Validate added comment
	JsonPath js=new JsonPath(IssueDetails);
	int CommentsCount=js.getInt("fields.comment.comments.size()");
	for(int i=0;i<CommentsCount;i++)
	{
		System.out.println(js.getInt("fields.comment.comments["+i+"].id"));
		String commentIdIssue=js.get("fields.comment.comments["+i+"].id").toString();
		if(commentIdIssue.equalsIgnoreCase(commentId))
		{
			String message=js.get("fields.comment.comments["+i+"].body").toString();
			Assert.assertEquals(message,expectedMessage);
		}
	}
	
	
}
}
