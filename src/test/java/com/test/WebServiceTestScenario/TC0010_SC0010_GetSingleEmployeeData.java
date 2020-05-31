package com.test.WebServiceTestScenario;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.Base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC0010_SC0010_GetSingleEmployeeData extends TestBase{
	
	@BeforeClass
	public void getSingle_Employee() throws InterruptedException {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		httpRequest.request(Method.GET,"/employee/"+empID);
		Thread.sleep(1000);	
	}
	
	@Test
	public void verify_ResponseCode() {
		int response_statusCode = httpResponse.getStatusCode();
		Assert.assertEquals(200, response_statusCode);
	}
	
	@Test
	public void verify_responseBody() {
		String response_Body = httpResponse.getBody().asString();
		Assert.assertTrue(response_Body!=null);
		Assert.assertEquals(response_Body.contains(empID), true);
	}
	


}
