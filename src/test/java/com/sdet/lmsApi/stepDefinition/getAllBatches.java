package com.sdet.lmsApi.stepDefinition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class getAllBatches {
	
	private static final String  BaseUrl = "https://lms-backend-service.herokuapp.com/lms";
	Response response;
	RequestSpecification request;
	
	@Given("user set the url {string}")
	public void user_set_the_url(String string) {
	   RestAssured.baseURI = BaseUrl;
	   request = RestAssured.given();
	}

	@When("user send the get request")
	public void user_send_the_get_request() {
	   response = request.get("/batches");
	}

	@Then("user should get status code {int}")
	public void user_should_get_status_code(int responseCode) {
	    int statusCode = response.getStatusCode();
	    Assert.assertEquals(statusCode, responseCode);
	    System.out.println("status code = " + statusCode);
	}


}
