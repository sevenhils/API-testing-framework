package Restassuredtests;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicValidation_xml {
	
	@Test(priority=1)
	public void testsingleContent() {
		
		given()
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		
		.then()
		.body("CUSTOMER.ID", equalTo("15"))
		.log().all();
		
	}

	@Test(priority=2)
	public void testMulitpleContents() {
		
		given()
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		
		.then()
		.body("CUSTOMER.ID", equalTo("15"))
		.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
		.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
		.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
		.body("CUSTOMER.CITY", equalTo("Seattle"))
		.log().all();
		
	}

	@Test(priority=3)
	public void testMulitpleContentsoneGo() {
		
		given()
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		
		.then()
		.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"))
		.log().all();
		
	}
	
	@Test(priority=4)
	public void testUsingXpath1() {
		
		given()
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		
		.then()
		//.body("CUSTOMER/FIRSTNAME", equalTo("Bill"))//way1
		 .body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")))
		.log().all();
		
	}
	@Test(priority=5)
	public void testUsingXpath2() {
		
		given()
		.when()
		.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		
		.then()
		//.body("CUSTOMER/FIRSTNAME", equalTo("Bill"))//way1
		.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
		.log().all();
		
	}

	
}
