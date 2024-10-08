@WRN1_NewWAApplicationCraetion
Feature: Testing WRN4-Noncomplaince functionality

  Background: Test CRM Login with valid credentials
    Given User navigates to CRM login page
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "DQB Case Management"

  Scenario Outline: Testing WRN4-Noncomplaince functionlaity
    When user change the changearea to "Factories"
    And user selects entity as "Eating Establishment"
    And create a manual project where Entity Type as "Eating Establishment"
    
    Examples: 
      | Report_Type | Substance_ChemicalName            | Result_Concentration |
      | WQ          | Biochemical Oxygen Demand as BOD5 |                  300 |
