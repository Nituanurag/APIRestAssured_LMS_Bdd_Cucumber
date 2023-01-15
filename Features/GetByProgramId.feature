Feature: Get program by Id

@test
Scenario: Get program by Id
  Given A Service with "https://lms-backend-service.herokuapp.com/lms/programs/367"
  When user sends get request
  Then user should get successful response code 200