
@tag
Feature: Get All Batches

@tag1
  Scenario: Get All Batches
    Given user set the url "https://lms-backend-service.herokuapp.com/lms/batches"
   When user send the get request
   Then user should get status code 200
    

