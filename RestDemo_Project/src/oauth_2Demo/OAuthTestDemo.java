package oauth_2Demo;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OAuthTestDemo {
	public static void main(String[] args) throws InterruptedException {
		String[] courseTItles={"Selenium Webdriver Java","Cypress","Protractor"};

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//		driver.findElement(By.cssSelector("#identifierId")).sendKeys("vraviteja2094@gmail.com");
//		driver.findElement(By.cssSelector("#identifierNext")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("9959738841");
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		String URL=driver.getCurrentUrl();
        String URL="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AfJohXl529h0TxRLYXmRFyuuKX78bZyNOklO_StiW3rpEmfNjTsJmgRVcD1LciXq4XPusg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialcode=URL.split("code=")[1];
		String code=partialcode.split("&scope")[0];
		System.out.println(code);
		
		//To get access token.
		String accessTokenResponse=given()
		.urlEncodingEnabled(false)		
		.log().all().queryParam("code", code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type","authorization_code")
		//.queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js=new JsonPath(accessTokenResponse);
		String accessToken=js.getString("access_token");
		
		
		
		//here we need to give query paramter as access_token
	GetCourse response=given().log().all().queryParam("access_token",accessToken)
	.expect().defaultParser(Parser.JSON)
	.when()
	.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
	
	//Grab the elements using getter method.
	System.out.println(response.getLinkedIn());
	System.out.println(response.getExpertise());
	System.out.println(response.getInstructor());
	System.out.println(response.getServices());
	System.out.println(response.getUrl());
	
	for(int i=0;i<response.getCourses().getApi().size();i++)
	{
		String CourseTitle = response.getCourses().getApi().get(i).getCourseTitle();
		if(CourseTitle.contains("SoapUI Webservices"))
		{
			String Price = response.getCourses().getApi().get(i).getPrice();
			System.out.println(Price);
			break;
		}
	}
	
	//Requirement to print all the courseTitls under web automation.
	ArrayList al=new ArrayList();
	for(int i=0;i<response.getCourses().getWebAutomation().size();i++)
	{
		String CourseTitle = response.getCourses().getWebAutomation().get(i).getCourseTitle();
		System.out.println(CourseTitle);
		al.add(CourseTitle);
		}
	List<String> expectedCourses = Arrays.asList(courseTItles);
	Assert.assertTrue(al.equals(expectedCourses));
	}
}
