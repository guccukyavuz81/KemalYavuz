#Auther: Omar
Feature: Office Location
  @smoke
  Scenario: View all Office Lecation
    Given user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee id "20984A"
    And click on search button
    And click on firstname which desplyed in the table
    And click in job button
    And click location button
		Then user see all the office location