
@tag
Feature: Create Batch
  

  @tag2
  Scenario: Create Batch
    Given A service with url "/batches" 
    When user send post request for batch creation"/batches"  with body
    					 | batchName  | batchDescription | batchStatus  |batchNoOfClasses  | programId |
      					|Jan23-ApiNinja5-SDET-016|Team-16	|Active		|7							|1090 |
    					
    Then validate the  status code 201
  

 
     
