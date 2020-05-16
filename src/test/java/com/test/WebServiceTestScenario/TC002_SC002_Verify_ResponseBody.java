package com.test.WebServiceTestScenario;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_SC002_Verify_ResponseBody {
	
	@Test
	public void verify_RegisterCustomer() {
		
		//Specify the Base URI EndPoint
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		
		//Creating Request Object
		RequestSpecification httpResquestObj = RestAssured.given();
		
		//Creating JOSN Request Body/PayLoad to send along with POST Request
		JSONObject requestBodyparam = new JSONObject();
		requestBodyparam.put("FirstName", "Ravi");
		requestBodyparam.put("LastName", "Kumar");
		requestBodyparam.put("UserName", "Ravi_Kumar2");
		requestBodyparam.put("Password", "12@ravikr");
		requestBodyparam.put("Email", "Ravikr143296@gmail.com");
		
		//Specify the type of Data as part of Header
		httpResquestObj.header("Content-Type","application/json");
		
		//Add the JSON data to Request Body in JOSN format
		httpResquestObj.body(requestBodyparam.toJSONString());
		
		
		//Sending the Request with above data and saving in Response
		Response httpResponseObj = httpResquestObj.request(Method.POST,"/register");
		
		//Convert the Response Body from JSon format to String and print in Console window
		String responseBody = httpResponseObj.getBody().asString();
		System.out.println("The Response Body :-" +responseBody);
		
		//Validating Status Code
		int statusCode = httpResponseObj.getStatusCode();
		System.out.println("Status Code of Response is :-" +statusCode);
		Assert.assertEquals(201, statusCode);
		
		//Validating the Status Line
		String statusLine = httpResponseObj.getStatusLine();
		System.out.println("Status Line :-" +statusLine);
		
		
		//Extracting the Response Body
		String SuccessCode = httpResponseObj.jsonPath().get("SuccessCode");
		System.out.println("Success Code is :-" +SuccessCode);
		Assert.assertEquals("OPERATION_SUCCESS", SuccessCode);
		
		
		
		
		
	}

}
