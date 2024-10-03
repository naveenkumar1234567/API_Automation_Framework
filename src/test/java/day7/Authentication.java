package day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertThrows;

import org.apache.http.auth.AUTH;

public class Authentication {
	
	@Test(priority =1)
	public void testBasicAuthentication()	{
		
		given()
		.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
	}
	
	
	@Test(priority =2)
	public void testDigestAuthentication()	{
		
		given()
		.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
	}
	
	
	@Test(priority =3)
	public void testPreemptiveAuthentication()	{
		
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
	}
	
	@Test(priority = 4)
	public void testBearerToken()	{
		
		String bearerToeknForGitHub = "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";
		given()
		.headers("Authorization", "Bearer "+bearerToeknForGitHub)
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	@Test(priority = 5, enabled = false)
	public void testOauth1Toekn()	{
		
		String bearerToeknForGitHub = "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";
		given()
		.auth().oauth("Consumerkey", "ConsumerSecret", "accessToekn", "TokenSecret")
		
		.when()
		.get("URL")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	@Test(priority = 5, enabled = true)
	public void testOauth2Toekn()	{
		
		String bearerToeknForGitHub = "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";
		given()
		.auth().oauth2(bearerToeknForGitHub)
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
		System.out.println("OAUTH 2.0");
	}
	
	@Test(priority = 6, enabled = true)
	public void testAPIKeyAuthentication()	{
			
		String apiKey = "155588cafd34165798d492e085439f4f";

		given()
		.queryParam("appid", apiKey)
		
		.when()
		.get("https://api.openweathermap.org/data/2.5/forecast?appid={API key}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
}
