package day8;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertThrows;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class getUser {
	
	
	String goRestToken = "f6d63cbd65277b51369d4c6fd94ab38dbedd53ded556793b7a5d52ffd08fe0e1";

	@Test
	public void test_GetUser(ITestContext context)	{
		
		int id = (int) context.getAttribute("user_id");
		given()
		.header("Authorization", "Bearer "+goRestToken )
		.pathParam("id", id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
	}
	
}
