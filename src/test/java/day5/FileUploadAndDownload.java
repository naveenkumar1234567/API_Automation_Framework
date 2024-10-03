package day5;

import java.io.File;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertThrows;

import org.testng.annotations.Test;

public class FileUploadAndDownload {

	@Test(enabled =false)
	public void signleFileUpload()	{
		File file = new File("C:\\Users\\naveen.kumar\\Downloads\\spring-boot-file-upload-download-rest-api-master\\spring-boot-file-upload-download-rest-api-master\\target\\file-demo-0.0.1-SNAPSHOT.jar");
		
		given()
			.multiPart("file", file)
			.contentType("multipart/form-data")
		.when()
		.post("http://localhost:8080/uploadFile")
		
		.then()
		.log().all();
	}
	
	
	@Test
	public void multipleFilesUpload()	{
		
		File file1 = new File("C:\\Users\\naveen.kumar\\Documents\\1) UX team has reviewed and given f.txt");
		File file2 = new File("C:\\Users\\naveen.kumar\\Documents\\POSH_Completion_Certificate.pdf");
		
		given()
		.multiPart("file", file1)
		.multiPart("file", file2)
		.contentType("multipart/form-data")
		
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		
		.then()
		.statusCode(200)
		.log();
	}
	
	@Test
	public void verifyFIleDownloaded()	{
		
		given()
		
		.when()
		.get("http://localhost:8080/downloadFile/chrome_100_percent.pak")
		.then()
		.statusCode(200);
		
	}
	
}
