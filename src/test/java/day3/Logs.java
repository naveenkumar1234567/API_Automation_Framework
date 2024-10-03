package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Logs {

	@Test
	public void headerTest()	{
		given()
		
		.when()
		.get("https://www.google.co.in/")
		
		.then()
		.log().body()
		.log().cookies()
		.log().headers();
		
	}

}
