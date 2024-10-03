package day4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONBody {

	@Test(enabled = false)
	public void parsingJSONBoday() {

		given().contentType(ContentType.JSON)

				.when().get("http://localhost:3000")

				.then().statusCode(200).body("x.students[4].location", equalTo("Evan Green"));
	}

	@Test
	public void ParsingJSONBodyPart() {
		Response res = given().contentType(ContentType.JSON)

				.when().get("http://localhost:3000/collegeStudents");
	
		JSONObject obj = new JSONObject(res.toString());

		for (int i = 0; i <= obj.getJSONArray("students").length(); i++) {
			String nameTitle = obj.getJSONArray("students").getJSONObject(i).get("name").toString();
			System.out.println(nameTitle);
		}

	}
}
