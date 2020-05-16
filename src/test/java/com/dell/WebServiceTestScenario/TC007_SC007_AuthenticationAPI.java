package com.dell.WebServiceTestScenario;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC007_SC007_AuthenticationAPI {
	
	@Test
	public void verify_authenticationAPI() {
		
		//Creating Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/";
		
		//Specify the Authentication
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		//set the userName and Password
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		
		//Specify the type of Authentication we are using in RestAssured
		RestAssured.authentication = authscheme;
			
		//Creating Request Object
		RequestSpecification reqObj = RestAssured.given();
		
		//Hitting the Request and storing in Response
		Response respObj = reqObj.request(Method.GET,"CheckForAuthentication");
		
		//Converting the response Body from JsOn to String format
		String respBody = respObj.getBody().asString();
		System.out.println("The Response Body is :-" +respBody);
		
		//Capturing each node value of response body using JSONPath Class
		JsonPath jsonpath = respObj.jsonPath();
		
		String FaultId = jsonpath.get("FaultId");
		System.out.println("The FaultID is :- " +FaultId);
		Assert.assertEquals(FaultId, "OPERATION_SUCCESS");
		
/*		String Username_password = jsonpath.get("Username:Password");
		System.out.println("The Username_password is :- " +Username_password);
		Assert.assertEquals(Username_password, "ToolsQA:TestPassword");*/
		
/*		String authtype = jsonpath.get("Authentication Type");
		System.out.println("The Auth Type is :- " +authtype);
		Assert.assertEquals(authtype, "Basic");*/
		
		
	}

}
