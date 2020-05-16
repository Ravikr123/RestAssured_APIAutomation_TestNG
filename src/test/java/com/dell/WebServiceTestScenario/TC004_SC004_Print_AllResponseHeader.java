package com.dell.WebServiceTestScenario;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_SC004_Print_AllResponseHeader {
	
	@Test
	public void printAllResponseHeader() {
		
		//Specify the Base URI EndPont
		RestAssured.baseURI ="https://maps.googleapis.com";
		
		//Creating the request Object
		RequestSpecification httpRequestObj = RestAssured.given();
		
		//Create Response object to store the response after hitting the request with URI
		Response httpResponseObj = httpRequestObj.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Convert the Response Body from JSon format to String and print in Console window
		String responseBody = httpResponseObj.getBody().asString();
		System.out.println("The Response Bodu is :-" +responseBody);
		
		//Get All the Response Headers 
		Headers listOfheaders = httpResponseObj.headers();
		
		//read and iterate each header value and print it
		for(Header allheader:listOfheaders)
		{
			System.out.println(allheader.getName() +"     "+allheader.getValue());
		}
		
		
	}

}
