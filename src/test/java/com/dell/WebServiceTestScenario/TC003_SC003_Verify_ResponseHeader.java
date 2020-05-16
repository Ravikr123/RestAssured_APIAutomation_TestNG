package com.dell.WebServiceTestScenario;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_SC003_Verify_ResponseHeader {
	
	@Test
	public void getListOfSuperMarket() {
		
		RestAssured.baseURI ="https://maps.googleapis.com";
		
		//Creating a Request Object
		RequestSpecification httpRequesuetObj = RestAssured.given();
		
		//Sending the Request with Query Parameter
		Response httpReponseObj = httpRequesuetObj.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Convert the Response Body from JSon format to String and print in Console window
		String responseBody = httpReponseObj.getBody().asString();
		System.out.println("The Response Body :-" +responseBody);
		
		//Capture and Validate Response Header
		String responseHeader_contentType = httpReponseObj.header("Content-Type");
		System.out.println("Reponse Header Content Type is :-" +responseHeader_contentType);
		Assert.assertEquals("application/xml; charset=UTF-8", responseHeader_contentType);
		
/*		String responseHeader_Date = httpReponseObj.header("Date");
		System.out.println("Response Header Date :-" +responseHeader_Date);
		Assert.assertEquals("Sat, 02 May 2020 06:48:00 GMT", responseHeader_Date);*/
		
		String responseHeader_ContentEncoding = httpReponseObj.header("Content-Encoding");
		System.out.println("Response header Content Encoding :-" +responseHeader_ContentEncoding);
		Assert.assertEquals("gzip", responseHeader_ContentEncoding);
		
		
		
	}

}
