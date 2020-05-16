package com.test.WebServiceTestScenario;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC006_SC006_ExtractvalueFromEachNodeFrom_RespBody {
	
	@Test
	public void extractEachNodeDataFrom_RespBody() {
		
		//Creating the Base URI
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city/";
		//Creating the Request Object
		RequestSpecification reqObj = RestAssured.given();
		//Hitting the Request and storing the response
		Response respObj = reqObj.request(Method.GET,"Delhi");
		//Converting the response Body from JsOn to String format
		String respBody = respObj.getBody().asString();
		System.out.println("The Response Body is :-" +respBody);
		
		//Capturing each node value of response body using JSONPath Class
		JsonPath jsonpath = respObj.jsonPath();
		
		String City = jsonpath.get("City");
		System.out.println("The City is :- " +City);
		Assert.assertEquals(City, "Delhi");
		
		String tempreture = jsonpath.get("Temperature");
		System.out.println("The tempreture is :- " +tempreture);
		
		String humidity = jsonpath.get("Humidity");
		System.out.println("The Humidity is :- " +humidity);
		
		String WeatherDescription = jsonpath.get("WeatherDescription");
		System.out.println("The WeatherDescription is :- " +WeatherDescription);
		
		String WindSpeed = jsonpath.get("WindSpeed");
		System.out.println("The WindSpeed is :- " +WindSpeed);
		
		String WindDirectionDegree = jsonpath.get("WindDirectionDegree");
		System.out.println("The WindDirectionDegree is:- " +WindDirectionDegree);
	}

}
