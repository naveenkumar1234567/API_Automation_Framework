package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Ancient;
import com.github.javafaker.Animal;
import com.github.javafaker.Faker;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertThrows;

public class FakerDataGenerator {

	@Test
	public void testGenerateDummyData() {

		Faker faker = new Faker();

		String fullName = faker.name().fullName();

		String firstName = faker.name().firstName();

		String lastName = faker.name().lastName();

		String userName = faker.name().username();

		String password = faker.internet().password();

		String phnNumber = faker.phoneNumber().cellPhone();
		String email = faker.internet().emailAddress();

		String safeEmail = faker.internet().safeEmailAddress();

		String cardExp = faker.business().creditCardExpiry();

		String animal = faker.animal().name();
		System.out.println(faker+"\n"+fullName+"\n"+firstName+"\n"+lastName+"\n"+userName+"\n"+password+"\n"+phnNumber+"\n"+email+"\n"+safeEmail+"\n"+cardExp+"\n"+animal);
		
		
	}
}
