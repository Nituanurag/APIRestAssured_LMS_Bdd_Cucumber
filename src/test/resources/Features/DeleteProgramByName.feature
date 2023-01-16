Feature: Test the put  Request for LMSAPI

  Scenario: To Delete Program By ProgramName
    Given User ensures to perform POST operation with body as
  	| programName  | programDescription | programStatus | 
  	| PostgreSQL215 | Learn PostgreSql14 | Active        |
    When User sends the post request using "/saveprogram" as 
    Then Status code should come as 201 ok
    Then User performs Delete operation to clear the porgram for the url "/deletebyprogname" 