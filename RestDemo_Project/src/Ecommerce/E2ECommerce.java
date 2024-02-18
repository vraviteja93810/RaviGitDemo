package Ecommerce;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.OrderDetails;
import pojo.orders;

public class E2ECommerce {
	public static void main(String[] args) {
		RequestSpecification Req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		LoginReqestPojo Request=new LoginReqestPojo();
		Request.setUserEmail("raviteja@gmail.com");
		Request.setUserPassword("Vraviteja@12345");
		RequestSpecification ReqLogin=given().relaxedHTTPSValidation().log().all().spec(Req).body(Request);
		LoginResponse_Deserialization loginResponse = ReqLogin.when().post("api/ecom/auth/login")
				.then().log().all().extract().response().as(LoginResponse_Deserialization.class);
		System.out.println(loginResponse.getToken());
		String token=loginResponse.getToken();
		String userId = loginResponse.getUserId();
		System.out.println(loginResponse.getUserId());
		System.out.println(loginResponse.getMessage());

		//Add product
		RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token)
				.build();
		RequestSpecification reqAddProduct = given().log().all().spec(addProductBaseReq)
				.param("productName","Laptop")
				.param("productAddedBy", userId)
				.param("productCategory", "Fashion")
				.param("productSubCategory","electronincs")
				.param("productPrice","72000")
				.param("productDescription", "Pavilion series")
				.param("productFor", "employees")
				.multiPart("productImage",new File("C:\\Users\\vredd\\Downloads\\playwright.png"));

		String addProductResponse = reqAddProduct.when().post("api/ecom/product/add-product")
				.then().log().all().extract().response().asString();
		JsonPath js=new JsonPath(addProductResponse);
		String productId = js.getString("productId");
		String message = js.getString("message");


		//Create Order
		RequestSpecification createOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token)
				.setContentType(ContentType.JSON)
				.build();

		
		OrderDetails details=new OrderDetails();
		details.setCountry("India");
		details.setProductOrderedId(productId);
		List<OrderDetails> OrderDetailsList =new ArrayList<OrderDetails>();
		OrderDetailsList.add(details);
		orders order=new orders();
		order.setOrders(OrderDetailsList);
		RequestSpecification createOrderRequest = given().log().all().spec(createOrderBaseReq).body(order);
		String createOrderResponse = createOrderRequest.when().post("/api/ecom/order/create-order")	
				.then().log().all().extract().response().asString();
		System.out.println(createOrderResponse);

//Delete product.
		RequestSpecification DeleteOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token)
				.setContentType(ContentType.JSON)
				.build();
		
		RequestSpecification DeleteOrderRequest = given().log().all().spec(DeleteOrderBaseReq)
		.pathParam("productId",productId);
		String DeleteOrderResponse = DeleteOrderRequest.when().delete("api/ecom/product/delete-product/{productId}")
		.then().log().all().extract().response().asString();
		JsonPath js2=new JsonPath(DeleteOrderResponse);
		js2.getString("message");
		
		
		Assert.assertEquals(js2.getString("message"), "Product Deleted Successfully");
	}
}
