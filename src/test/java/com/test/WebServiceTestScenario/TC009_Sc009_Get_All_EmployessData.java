package com.test.WebServiceTestScenario;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC009_Sc009_Get_All_EmployessData extends TestBase {
	
	private Logger logger = Logger.getLogger(TC009_Sc009_Get_All_EmployessData.class.getName());
	
	//Here we are only hitting the request and store the response
	@BeforeClass
	public void getAlEmployess() throws InterruptedException {
		
		logger.info("....Started TC009_Sc009_Get_All_EmployessData....");
		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
		httpRequest = RestAssured.given();
		httpResponse = httpRequest.request(Method.GET,"employees");
		Thread.sleep(1000);
	}
	
	@Test
	public void verify_ResponseCode() {
		
		logger.info("....Checking the Status Code....");
		int response_statusCode = httpResponse.getStatusCode();
		logger.info("The Status Code is == " +response_statusCode);
		Assert.assertEquals(200, response_statusCode);
	}
	
	@Test
	public void verify_responseBody() {
		
		logger.info("....Checking the Response Body....");
		String response_Body = httpResponse.getBody().asString();
		logger.info("....The Response Body is == " +response_Body);
		Assert.assertTrue(response_Body!=null);
	}
	
	@Test
	public void verify_responsetime() {
		
		logger.info("....Checking the Response Time....");
		long response_Time = httpResponse.getTime();
		logger.info("....The Response Time is = " +response_Time);	
	}
	
/*	@Test
	public void verify_statusLine() {
		logger.info("....Checking the Status Line....");
		String response_statusLine =httpResponse.getStatusLine();
		logger.info("....The Response Status Line is = " +response_statusLine);
		Assert.assertEquals(response_statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void verify_contentType() {
		logger.info("....Checking the Content Type....");
		String response_contentType = httpResponse.header("Content-Type");
		logger.info("....The Response OCntent Type is = " +response_contentType);
		Assert.assertEquals(response_contentType, "text/html;charset=utf-8");
	}*/
	
	@AfterClass
	public void tearDown() {
		logger.info("....Finished the Tes Case TC009_Sc009_Get_All_EmployessData.... ");
		
	}

}
