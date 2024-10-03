package day8;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertThrows;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import groovy.util.logging.Log;

public class UpdateUser {
	

	@Test
	public void test_UpdateUser(ITestContext context) {

		int id = (int) context.getAttribute("user_id");
		
		Faker faker = new Faker();
		String goRestToken = "f6d63cbd65277b51369d4c6fd94ab38dbedd53ded556793b7a5d52ffd08fe0e1";

		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("email", faker.internet().emailAddress());
		data.put("gender", "Female");
		data.put("status", "active");

		given().header("Authorization", "Bearer " + goRestToken).contentType("application/json")

				.body(data.toString())
				.pathParam("id", id)

				.when()
				.put("https://gorest.co.in/public/v2/users/{id}")

				.then().statusCode(200).log().all();
	}
}
