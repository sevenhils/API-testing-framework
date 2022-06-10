package Restassuredtests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GET_Request {
	@Test
	public void getAlluserDetails() {
		
		given()
		.when()
		   .get("https://reqres.in/api/users?page=2")
	.then()
	   .statusCode(200)
	   .statusLine("HTTP/1.1 200 OK")
	 .assertThat().body("x.data[0].email",equalTo("michael.lawson@reqres.in"))
	   .header("Content-Type", "application/json; charset=utf-8");
	}

}  
