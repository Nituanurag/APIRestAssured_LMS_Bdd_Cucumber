package com.sdet.lmsApi.stepDefinition;


import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postSavePrg {
	
	private static final String BASEURL = "https://lms-backend-service.herokuapp.com/lms";
	RequestSpecification request;
	Response response;
	String programId;
	
	@Given("A service for {string}")
	public void a_service_for(String string) {
		request = RestAssured.given();
	    request.header("Content-Type", "application/json");
	    request.baseUri(BASEURL);	    	
	}

	@When("I perform POST operation for {string} with body as")
	public void i_perform_post_operation_for_with_body_as(String url, DataTable table) {
		
		List<List<String>> data = table.asLists(String.class);
    	Map<String, Object>  body = new HashMap<String, Object>();
    	body.put("programName", data.get(1).get(0));
    	body.put("programDescription", data.get(1).get(1));
    	body.put("programStatus", data.get(1).get(2));

    	SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    	String stringDate = DateFor.format(new Date());

    	body.put("creationTime", stringDate);
    	body.put("lastModTime", stringDate);
    	
    	request.body(body);

		response = request.post(url);
    	programId = response.getBody().jsonPath().getString("programId");	
	}

	@Then("I validate the response code {int}")
	public void i_validate_the_response_code(int responseCode) {
		Assert.assertEquals(responseCode, response.statusCode());
	}

	@Then("I perform DELETE operation to clear the program data for {string}")
	public void i_perform_delete_operation_to_clear_the_program_data_for(String url) {
		 response = request.delete(url + "/" + programId);
	      if(response.statusCode() == 200) {
	    	  System.out.println("Program id " + programId + " has been deleted successfully.");
	      }
	}


}
