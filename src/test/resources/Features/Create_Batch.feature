Feature: Test the Create Request for LMSAPI

  Scenario: To Create new batch
    Given User ensures to perform POST operation with the body as
  	| batchName | batchDescription | batchStatus |batchNoOfClasses | programId |
		|Jan23-ApiNinja5-SDET-016|Team-16 |Active |7 |1090 |
    When User sends post request using "/batches" as 
    Then Status code should be 201 ok
    Then User performs Delete to clear the porgram for the url "/batches" 