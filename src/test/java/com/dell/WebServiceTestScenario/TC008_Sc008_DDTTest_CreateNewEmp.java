package com.dell.WebServiceTestScenario;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC008_Sc008_DDTTest_CreateNewEmp {
	
	@Test(dataProvider="EmpDataProvider")
	public void addNewEmp(String name, String sal, String age) {
		//Specify Base URL
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		//Creating Request object
		RequestSpecification reqObj = RestAssured.given();
		
		//Creating JSON Request body to send along with Request
		JSONObject jsonReqbody = new JSONObject();
		jsonReqbody.put("name", name);
		jsonReqbody.put("salary", sal);
		jsonReqbody.put("age", age);
		
		//Specify the type of data we are sending in Header
		reqObj.header("Content-Type","application/json");
		
		//Add the created above json data to the body of the request in JSON format
		reqObj.body(jsonReqbody.toJSONString());
		
		//Hitting the request and storing the response
		Response response  = reqObj.request(Method.POST,"create");
		
		//Converting the response Body from JSOn to String
		String respBody = response.getBody().asString();
		System.out.println("The Response body is :- " +respBody);
		
		//Verifying the Response Code
		int status_Code = response.getStatusCode();
		//Assert.assertEquals(200, status_Code);
		
		//Capturing the node value from response body and validating
		JsonPath jpath = response.jsonPath();
		String respstatus = jpath.get("status");
	
	}
	
	@DataProvider(name="EmpDataProvider")
	public String[][] getEmpDetail() {
		String empdata[][] = { 
								{"ram123","2100","21"},
								{"ram124","2180","31"},
								{"ram125","2190","51"}
							};
		return empdata;
		}

}
