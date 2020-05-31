package com.test.Base;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	//Request and Response are the two common things that we need for every Test Case so we can define in Base Class
	public static RequestSpecification httpRequest;
	public static Response httpResponse;
	public String empID= "23"; //Hard Coded the Employee data here
	
/*	private Logger logger = Logger.getLogger(TestBase.class.getName());
	String log4jPropertyFile_Path = "C:\\Users\\ravi_kumar62\\eclipse-workspace\\RestAssured_TestNG\\log4J.properties";*/
			
	@BeforeClass
	public void setUp() {
		
/*		PropertyConfigurator.configure(log4jPropertyFile_Path); //added logger
		logger.setLevel(Level.DEBUG);*/
	}
	

}
