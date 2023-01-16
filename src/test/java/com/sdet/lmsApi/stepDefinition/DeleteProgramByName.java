package com.sdet.lmsApi.stepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;


public class DeleteProgramByName {
	
	private static final String BASE_URL="https://lms-backend-service.herokuapp.com/lms";
	RequestSpecification request;
	Response response;
	String jsonString;
	String program;
	Map<String, Object>  body;
	JSONObject  jsonbody;
	

@Given("User ensures to perform POST operation with body as")
public void user_ensures_to_perform_post_operation_with_body_as(DataTable table) throws Throwable {
	
	List<List<String>> data = table.asLists(String.class);
	//Map<String, Object>  body = new HashMap<String, Object>();
	
	//List<List<String>> data = table.asLists(String.class);
	body = new HashMap<String, Object>();
	body.put("programName", data.get(1).get(0));
	body.put("programDescription", data.get(1).get(1));
	body.put("programStatus", data.get(1).get(2));

	SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	String stringDate = DateFor.format(new Date());
	body.put("lastModTime", stringDate);
	body.put("creationTime", stringDate);

	jsonbody = new JSONObject(body);
}

@When("User sends the post request using {string} as")
public void user_sends_the_post_request_using_as(String url) {
	request = RestAssured.given();	
	request.header("Content-Type", "application/json");
	request.body(jsonbody.toString());
	request.baseUri(BASE_URL);

	response = request.post(url);
	program = response.getBody().jsonPath().getString("programName");
	System.out.println("Response status code: " + response.statusCode());
}

@Then("Status code should come as {int} ok")
public void status_code_should_come_as_ok(Integer int1) {
	int statusCode=((ResponseOptions<Response>) response).getStatusCode();
    Assert.assertEquals(201, statusCode);
}

@Then("User performs Delete operation to clear the porgram for the url {string}")
public void user_performs_delete_operation_to_clear_the_porgram_for_the_url(String url) {
	Response response = request.delete(url + "/" + program);
	
	if(response.statusCode() == 201) {
  	  System.out.println("Delete Program by name " + program + " has been deleted successfully.");
}
}

}
