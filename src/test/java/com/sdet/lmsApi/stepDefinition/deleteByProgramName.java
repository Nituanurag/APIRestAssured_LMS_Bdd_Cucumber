package com.sdet.lmsApi.stepDefinition;

import org.asynchttpclient.Request;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class deleteByProgramName {
	
	
	private static final String BaseUrl = "https://lms-backend-service.herokuapp.com/lms";
	Response response;
	RequestSpecification request; 
	String programname;

	@Given("user use the url {string}")
	public void user_use_the_url(String string) {
	    RestAssured.baseURI = BaseUrl;
	    request = RestAssured.given();
	    
	}

	@When("user send the delete request")
	public void user_send_the_delete_request() {	
	  response = request.delete("/deletebyprogname/Ninjaguys002");
	  
	}

	@Then("user should get success code {int}")
	public void user_should_get_success_code(int responseCode) {
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(responseCode, statusCode);
	    
	}

	@Then("user should get success message")
	public void user_should_get_success_message() {
		if (response.statusCode()==200) {
	   System.out.println("Program Name" + programname+" deleted Successfully!");
		}
	  
	}

}
