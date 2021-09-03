Feature: Employee Details

@SmokeTest
  Scenario: Operations of Employees Details
    Given ViewAllEmployees
    When Creation Of Employee
    And Update Employee Details
    And View Employee Details
    Then Delete the Employee
    
@SmokeTest
  Scenario: Running the script successfully
    Given start the script
    Then script execution in progress
    And Execution completed
