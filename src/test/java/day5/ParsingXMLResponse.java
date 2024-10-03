package day5;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertThrows;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingXMLResponse {

	@Test
	public void parsingXMLResponse()	{
		
		given()
		
		.when()
		.get("https://mocktarget.apigee.net/xml")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")

		.body("root.firstName", equalTo("John"));
//		.log().all();
		
	}
	
	
	@Test
	public void parsingXMLResponseWithVar()	{
		
	Response res =	given()
		
		.when()
		.get("https://mocktarget.apigee.net/xml")
	;
	
	Assert.assertEquals(res.statusCode(), 200);
	
	Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		
	}
}
