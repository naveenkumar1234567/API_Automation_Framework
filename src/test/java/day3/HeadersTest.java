package day3;

import org.testng.annotations.Test;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersTest {

	@Test
	public void headerTest()	{
		given()
		
		.when()
		.get("https://www.google.co.in/")
		
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1");
		
	}


	}

