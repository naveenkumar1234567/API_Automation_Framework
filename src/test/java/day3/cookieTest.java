package day3;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class cookieTest {

	@Test(priority = 1, enabled = false)
	public void cookieTest() {
		
		given()
		
		.when()
		.get("https://www.google.co.in/")
		
		.then()
		.cookie("AEC", "AVYB7crCG5yRCWhfBwGPLkvODQ0nceVCi-b_akmymvrZJzOm8QeTPt3qGQ")
		.log().all();
	
		
		
	}
	
	@Test(priority = 2)
	public void getCookie() {
		
	Response res = 	given()
		
		.when()
		.get("https://www.google.co.in/");
		
	String AEC_cookievalue	= res.getCookie("AEC");
		Map<String, String> allCookies =	res.getCookies();
		System.out.println(allCookies.keySet());
	
		System.out.println("AEC value - "+ AEC_cookievalue);
		System.out.println();
		System.out.println(allCookies.keySet());
		
		for(String k: allCookies.keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k+"        "+cookie_value);
		}
		
	}
}
