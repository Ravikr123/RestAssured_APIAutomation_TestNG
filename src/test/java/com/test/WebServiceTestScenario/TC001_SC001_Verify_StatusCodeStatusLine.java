package com.test.WebServiceTestScenario;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import com.test.Base.*;

public class TC001_SC001_Verify_StatusCodeStatusLine extends TestBase {
	
	@Test
	public void getWeather_Details() {
		
		//Specify the Base URI EndPont
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
		
		//Create request object to send the request to server
		RequestSpecification httpsRequestObj = RestAssured.given();
		
		//Create Response object to store the response after hitting the request with URI
		Response httpResponseObj = httpsRequestObj.request(Method.GET,"/Hyderabad");
		
		//Convert the Response Body from JSon format to String and print in Console window
		String responseBody = httpResponseObj.getBody().asString();
		System.out.println("Response Body :-" +responseBody);
		
		//Validating Status Code
		int statusCode = httpResponseObj.getStatusCode();
		System.out.println("Status Code of Response is :-" +statusCode);
		Assert.assertEquals(200, statusCode);
		
		//Validating the Status Line
		String statusLine = httpResponseObj.getStatusLine();
		System.out.println("Status Line :-" +statusLine);
		
		
	}

}
