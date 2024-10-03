package day8;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertThrows;
import com.github.javafaker.Faker;

import io.restassured.response.Response;



public class CreateUser {

	String goRestToken = "f6d63cbd65277b51369d4c6fd94ab38dbedd53ded556793b7a5d52ffd08fe0e1";
	@Test
	void test_CreateUser(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName()) ;
		data.put("email", faker.internet().emailAddress());
		data.put("gender", "Male");
		data.put("status", "inactive");
		
	int id =	given()
		.header("Authorization", "Bearer "+goRestToken )
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id")
		
		;
	System.out.println("Generated ID is: "+id);
context.setAttribute("user_id", id);
	
		
	}

	
}
