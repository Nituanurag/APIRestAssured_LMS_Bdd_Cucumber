
@tag
Feature: Delete by program name
 

  @tag1
  Scenario: Delete by program name
    Given user use the url "https://lms-backend-service.herokuapp.com/lms/deletebyprogname/Ninjaguys002"
    When user send the delete request
   Then user should get success code 200
    And user should get success message

  