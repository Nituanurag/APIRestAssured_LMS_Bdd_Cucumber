package com.sdet.lmsApi.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:/Users/nituk/Desktop/API_Git_RestAssure/Jan23-ApiNinja5-SDET-016/Features/"},
		glue   =  {"com.sdet.lmsApi.stepDefinition"},
		plugin = {"pretty", "json:target/Cucumber.json",
				        "html:target/Cucumber-html-report"
		},
		dryRun = false
		//tags = "@tag1"
	
		
		)

public class TestRunner {

}
