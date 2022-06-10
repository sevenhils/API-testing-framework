package Restassuredtests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.*;


public class POST_Request {
	
	public static HashMap map=new HashMap();
	@BeforeClass
	public void Setdata() {
		map.put("Name", RestUtils.getName());
		map.put("Job",RestUtils.getJob() );
		map.put("Salary", RestUtils.getSalary());
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
	} 
	
	
	@Test
	public void testPOST() {  
		given()
		.contentType("application/json")
		.body(map)
		.when()
		  .post()
		  .then()
		   .statusCode(201)
		   .and()
		  .statusLine("HTTP/1.1 201 Created");
	}

}
