package restAPIXML;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XMLTest {

	@Test
	public void test1() {
		
		RestAssured.baseURI = "https://chercher.tech/sample/api/books.xml";
		
		RequestSpecification  request = RestAssured.given();
			
		Response response = request.get();
		
		System.out.println("Response is " + response.body().asString());	
        NodeChildrenImpl books = response.then().extract().path("bookstore.book.title");
		
		System.out.println("All the books are " + books.toString());
		System.out.println("First book is " + books.get(0));
		System.out.println("First book is " + books.get(1));
		
		NodeChildrenImpl booksTag = response.then().extract().path("bookstore.book");
		
		for(int i=0;i<booksTag.size();i++) {
			
			System.out.println("The category is " + booksTag.get(i).getAttribute("category"));
		}
		
		NodeChildrenImpl titleTag = response.then().extract().path("bookstore.book.title");

		for(int i=0;i<titleTag.size();i++) {
			
			System.out.println("The language is " + titleTag.get(i).getAttribute("lang"));
		}
			

		

	}
}
