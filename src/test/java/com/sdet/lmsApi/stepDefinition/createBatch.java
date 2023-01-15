package com.sdet.lmsApi.stepDefinition;


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

public class createBatch {
	
	private static final String BaseUrl =  "https://lms-backend-service.herokuapp.com/lms";
	RequestSpecification request;
	Response response;
	
	
	@Given("A service with url {string}")
	public void a_service_with_url(String string) {
	    RestAssured.baseURI = BaseUrl;
	    request = RestAssured.given();
	    request.header("Content-Type", "application/json");
	}

	@When("user send post request for batch creation\"\\/batches\"  with body")
	public void user_send_post_request_for_batch_creation_batches_with_body(DataTable table)throws Throwable  {
	 		
	
		List<List<String>> data = table.asLists(String.class);
		Map<String, Object>  body = new HashMap<String, Object>();
		body.put("batchName", data.get(1).get(0));
    	body.put("batchDescription", data.get(1).get(1));
    	body.put("batchStatus", data.get(1).get(2));
		body.put("batchNoOfClasses",  data.get(1).get(3));
		
		
//    	SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//    	String stringDate = DateFor.format(new Date());
//    	
//    	body.put("creationTime", stringDate);
//    	body.put("lastModTime", stringDate);
    	body.put("programId", data.get(1).get(4));
    	request.body(body);

		response = request.post("/batches");
		
	}

	@Then("validate the  status code {int}")
	public void validate_the_status_code(int responseCode) {
		Assert.assertEquals(responseCode, response.statusCode());
		if(response.statusCode() == 201) {
	    	  System.out.println("Batch is  has been created successfully.");
	      }
	}


}
