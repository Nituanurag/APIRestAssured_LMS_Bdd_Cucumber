Feature: Update program by id
  Test the update operation

@tag3
Scenario: Verify POST operation
  Given A service for "/saveprogram"
  When I perform POST operation for "/saveprogram" with body as
  	| programName | programDescription | programStatus | 
  	| Cucumber 62 | Cucumber testing   | Active        |
  Then I validate the response code 201
	Then I perform DELETE operation to clear the program data for "/deletebyprogid"