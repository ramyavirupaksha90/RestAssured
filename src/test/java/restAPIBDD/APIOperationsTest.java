package restAPIBDD;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIOperationsTest {
	String BaseURI = "http://localhost:3000/employees";
	@Test
public void GetOperation()
{
	RestAssured.given()
				.baseUri(BaseURI)
				.when()
				.get()
				.then()
				.log()
				.body()
				.statusCode(200);
}
@Test
public void GetOperationWithParams() {
	
	RestAssured.given()
				.baseUri(BaseURI)
				.when()
				.get("/1")
				.then()
				.log()
				.body()
				.statusCode(200)
				.body("name", Matchers.equalTo("Pankaj"));
	
}
@Test
public void GetOperationWithQuryParams1() {
	
	RestAssured.given()
				.queryParam("CUSTOMER_ID", "68195")
				.queryParam("PASSWORD", "1234!")
				.queryParam("Account_No", "1")
				.baseUri("http://demo.guru99.com/V4/sinkministatement.php")
				.when()
				.get()
				.then()
				.log()
				.body()
				.statusCode(200);
}
@Test
public void PostOperationWithHashMap() {
	
	HashMap<String,String> obj = new HashMap<String,String>();
	
	obj.put("name", "John");
	obj.put("salary", "9000");
	obj.put("id", "10");
	
	RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(obj)
				.baseUri(BaseURI)
				.when()
				.post()
				.then()
				.log()
				.body()
				.statusCode(201);
}


public void PutOperationWithHashMap() {
	
	HashMap<String,String> obj = new HashMap<String,String>();
	
	obj.put("name", "John");
	obj.put("salary", "15000");
	obj.put("id", "10");
	
	RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(obj)
				.baseUri(BaseURI)
				.when()
				.put("/10")
				.then()
				.log()
				.body()
				.statusCode(200);
}




}
  