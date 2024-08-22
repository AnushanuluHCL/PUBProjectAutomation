@WRN5_AuditInspectionFlow
Feature: Testing WRN5-Tanker Audit inspection Functionality

  Scenario: Test Powerapps Login with valid credentials
    Given User navigates to powerapps cloud flow page
     When Login to app with "Admin_userid" and "Admin_pwd"
      And Run the automatic cloudflow job for "SIES/WRN5/Audit Inspection for all Tankers -Scheduled Flow Yearly"
     When User navigates to CRM login page
      And user selects App "DQB Case Management"
      And change the configuration to create cases today
    Given User navigates to powerapps cloud flow page
      And Run the automatic cloudflow job for "SIES/WRN5/Creating case  for Audit inspection of Tankers"
     When User navigates to CRM login page
      And user selects App "DQB Case Management"
      And verify that tanker audit cases are created
