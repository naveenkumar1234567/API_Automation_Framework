package day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.HashMap;

import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.support.FileReader;
import net.minidev.json.JSONObject;

public class DifferentWaysToCreatePostRequestBody {

	//Post request body using hashmap
	@Test(enabled = false)
	void testPostUsingHashmap()
	{
		HashMap data = new HashMap();
		
		data.put("name", "Naveen");
		data.put("location", "blr");
		data.put("phone", "452");
		String coursesArr[] = {"java", "python"};
		data.put("courses", coursesArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when().post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Naveen"))
		.body("location", equalTo("blr"))
		.body("phone", equalTo("452"))
		.body("courses[0]", equalTo("java"))
		.body("courses[1]", equalTo("python"))
		.log().all()
		;
		
	}
	@Test(enabled = false)
	void deleteRecord() {
		given()
		
		.when().delete("http://localhost:3000/students/2e88")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	//Post request body using org.json librerary
		@Test(enabled = false)
		void testPostUsingOrgJson()
		{
			JSONObject data = new JSONObject();
			
			data.put("name", "Mainak");
			data.put("location", "blr");
			data.put("phone", "452");
			String coursesArr[] = {"java", "python"};
			data.put("courses", coursesArr);
			
			given()
			.contentType("application/json")
			.body(data.toString())
			
			.when().post("http://localhost:3000/students")
			
			.then()
			.statusCode(201)
			.body("name", equalTo("Mainak"))
			.body("location", equalTo("blr"))
			.body("phone", equalTo("452"))
			.body("courses[0]", equalTo("java"))
			.body("courses[1]", equalTo("python"))
			.log().all()
			;
			
		}
		
		//Post request body using POJO class
		@Test(enabled = false)
		void testPostUsingPoJOClass()
		{
			Pojo_PostRequest data = new Pojo_PostRequest();
			
			data.setName("Raghu");
			data.setPhone("452");
			data.setLocation("blr");
			String[] courses = {"java", "python"};
			
			data.setCourses(courses);
			
			given()
			.contentType("application/json")
			.body(data.toString())
			
			.when().post("http://localhost:3000/students")
			
			.then()
			.statusCode(201)
			.body("name", equalTo("Mainak"))
			.body("location", equalTo("blr"))
			.body("phone", equalTo("452"))
			.body("courses[0]", equalTo("java"))
			.body("courses[1]", equalTo("python"))
			.log().all()
			;
			
		}
		
		//Post request body using Json File
				@Test(enabled = true)
				void testPostUsingJsonFile()
				{
//					File file = new File(".\\student.json");
//					
//					FileReader fr = new FileReader();
//					
//					JSONTokener jt = new JSONTokener(fr);
//					
//					JSONObject data = new JSONObject(jt);
					
					
					
//					data.setName("Raghu");
//					data.setPhone("452");
//					data.setLocation("blr");
//					String[] courses = {"java", "python"};
//					
//					data.setCourses(courses);
//					
//					given()
//					.contentType("application/json")
//					.body(data.toString())
//					
//					.when().post("http://localhost:3000/students")
//					
//					.then()
//					.statusCode(201)
//					.body("name", equalTo("Mainak"))
//					.body("location", equalTo("blr"))
//					.body("phone", equalTo("452"))
//					.body("courses[0]", equalTo("java"))
//					.body("courses[1]", equalTo("python"))
//					.log().all()
					;
					
				}
	
}
