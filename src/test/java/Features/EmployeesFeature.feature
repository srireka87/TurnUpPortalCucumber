Feature: As a Turnup Portal User can able to create Employee Records

  Scenario: Create Employee records with valid Credentials
    Given As a user logged into portal succeessfully
    Then navigate to Employees page
    When Create a new Employee records
    Then the new employee record should be created successfully
    