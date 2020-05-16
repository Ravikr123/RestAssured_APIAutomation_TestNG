package com.dell.WebServiceTestScenario;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_SC005_Validate_AnyDataIn_JSONResponseBody {
	
	@Test
	public void verify_AnyDataInResponseBody() {
		
		//Creating a Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Creating a Request Object
		RequestSpecification requestObj = RestAssured.given();
		
		//Hitting the request and storing the response in Response
		Response responseObj = requestObj.request(Method.GET,"/Delhi");
		
		//Converting the Response Body from JSON to String and print it
		String jsonresponseBody = responseObj.getBody().asString();
		System.out.println("The JSON Response Body is :-" +jsonresponseBody);
	
		//Validate if in Response body delhi value is there or not
		Assert.assertEquals(true, jsonresponseBody.contains("Delhi"));
	}

}
