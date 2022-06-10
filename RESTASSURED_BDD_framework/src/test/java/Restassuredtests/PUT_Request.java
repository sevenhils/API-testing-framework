package Restassuredtests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PUT_Request {

	public static HashMap map=new HashMap();
	
	int id=9;
	@BeforeClass
	public void Setdata() {
		map.put("Name", RestUtils.getName());
		map.put("Job",RestUtils.getJob() );
		map.put("Salary", RestUtils.getSalary());
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/2"+id;
	}
	@Test
	public void testPUT() {
		given()
		.contentType("application/json")
		.body(map)
		.when()
		  .put()
		  .then()
		   .statusCode(200)
		   .and()
		   .log().all()
		   .and()
		  .statusLine("HTTP/1.1 200 OK");
		
	}

	
}
