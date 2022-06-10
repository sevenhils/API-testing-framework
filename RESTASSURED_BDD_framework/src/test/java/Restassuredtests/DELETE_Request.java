package Restassuredtests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class DELETE_Request {
	@Test
public void DeleteUser() {
	RestAssured.baseURI="https://reqres.in/api/users";
	RestAssured.basePath="/9";
	Response response=
	given()
	.when()
	.delete()
	.then()
	.statusCode(204)
	.and()
	.statusLine("HTTP/1.1 204 No Content")
	.log().all()
	.extract().response();
	String JsonString=response.asString();
	Assert.assertEquals(JsonString.contains(""), true);

	
	
	
}
}
