package com.sdet.lmsApi.stepDefinition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class getByProgramId {
	
	private static final String BaseUrl = "https://lms-backend-service.herokuapp.com/lms";
	Response response;
	RequestSpecification request;
	
	@Given("A Service with {string}")
	public void a_service_with(String string) {
	    RestAssured.baseURI  = BaseUrl;
	    request = RestAssured.given();
	}
	
	

	@When("user sends get request")
	public void user_sends_get_request() {
	    response = request.get("/programs/367");
	}
	

	@Then("user should get successful response code {int}")
	public void user_should_get_successful_response_code(int responseCode) {
	   int statusCode = response.getStatusCode();
	   Assert.assertEquals(statusCode, responseCode);
	
	   	}

}
