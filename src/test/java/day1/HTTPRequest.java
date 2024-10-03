package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequest {
	int id;
@Test(enabled=true, priority =0)
void getUser()
{
	given()
	
	.when()
		.get("https://reqres.in/api/users?page=2")
	
	.then().statusCode(200)
	.log().all();
}

@Test(priority = 1)
void createUsers()
{
	HashMap<Object, Object> hm = new HashMap<>();
	
	hm.put("name", "morpheus");
	hm.put("job", "leader");
	
	id=given()
		.contentType("application/json")
		.body(hm)
	.when()
		.post("https://reqres.in/api/api/users")
		.jsonPath().getInt("id");
		
		
//	.then()
//		.statusCode(201)
//		.log().all();
}


@Test(priority=2, dependsOnMethods = "createUsers")
void updateUser() {
	
HashMap<Object, Object> hm = new HashMap<>();
	
	hm.put("name", "Naveen");
	hm.put("job", "commander");
	
	given()
		.contentType("application/json")
		.body(hm)
	.when()
		.put("https://reqres.in/api/api/users/"+id)
	.then()
	.statusCode(200)
	.log().all(); 
		
}
@Test(priority = 3, dependsOnMethods = "updateUser")
void deleteUser() {
	given()
	.when()
		.delete("https://reqres.in/api/users/"+id)
	.then()
		.statusCode(204)
		.log().all();
}
	
}

/*
get single user

https://reqres.in/api/users?page=2

post
https://reqres.in/api/api/users


{
    "name": "morpheus",
    "job": "leader"
}

put update user

https://reqres.in/api/users/2

{
    "name": "morpheus",
    "job": "zion resident"
}

datele
	https://reqres.in/api/users/userID
*/