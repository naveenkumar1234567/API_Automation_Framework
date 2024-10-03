package day3;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQuiryParameter {

	@Test
	public void pathAndQueryParameter() {
		
		//https://reqres.in/api/users?page=2
		
		given()
		.pathParam("Path", "users")
		.queryParam("page", 2)
		.queryParam("id", 2)
		.when()
		.get("https://reqres.in/api/{Path}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
}
