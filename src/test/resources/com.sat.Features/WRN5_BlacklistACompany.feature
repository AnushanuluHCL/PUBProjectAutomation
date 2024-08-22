@WRN5_BlacklistingACompany
Feature: Testing WRN5-Permit Revocation process by blacklisting a company

  Background: Test CRM Login with valid credentials
    Given User navigates to CRM login page
     When Login to app with "Admin_userid" and "Admin_pwd"
      And user selects App "DQB Case Management"

  Scenario Outline: Revocking permit for the tankercompany by blacklisting it
    When user change the changearea to "GWC Tanker"
     And user selects entity as "NEA List"
     And fill the details in the NEA list record form
      | Vehicle_Type | Tankers_Capacity | Registration_Deregistration | Iteration |
      | Tanker       |             1000 | Registration                |         1 |
     And user selects entity as "Applications"
     And fill the details in application form for General details "<AddOfTankerYard>","<PhoneNum>","<Email>"
     And fill the details in application form for organic ships waste type details "<OSS>","<OSSPerMonth>"
     And create tankers by filling the details
      | WasteType |
      | OS - Ship |
     And logout from the application
    When Login to app with "FIO_userid" and "FIO_pwd"
     And user selects App "DQB Case Management"
     And user change the changearea to "GWC Tanker"
     And user selects entity as "Applications"
     And approve the application
    Then verify whether case is created
     And search and open the case
     And go to "Work Orders" tab
     And validate the schedule workorder notification
     And navigate to Assignment stage and confirm the inspection schedule
     And navigate to Assignment stage and fill the respective details and navigate to next stage
     And fill the details in Bookings section
     And go to Service tasks tab and fill and complete the checklist as "Compliance"
     And verify the WO status field is "Completed" and verify tanker Iscomplaint? field value as "Yes" in work order form
     And navigate to Inspection stage and select the Inspection completed value as yes
     And verify permit is generated for the tanker
     And navigate to Inspection stage and fill the respective details and navigate to next stage
    When Login to app with "SO_userid" and "SO_pwd"
     And user selects App "DQB Case Management"
     And search for the case to open it
     And navigate to SO Review stage and fill the respective details and navigate to next stage
    When Login to app with "AO_userid" and "AO_pwd"
     And user selects App "DQB Case Management"
     And search for the case to open it
     And navigate to AO Review stage and fill the respective details and navigate to next stage
    When Login to app with "FIO_userid" and "FIO_pwd"
     And user selects App "DQB Case Management"
     And search for the case to open it
     And navigate to GenerateEmail stage and fill the respective details and navigate to next stage
     And logout from the application

    When Login to app with "SO_userid" and "SO_pwd"
     And user selects App "DQB Case Management"
     And search for the case to open it
     And update the blacklist field value as yes with date and "<Period Of Blacklisting>" in months
     And validate the tankerpermitstatus after revocation
     And navigate to email messages and verify the cancellation email and blacklist emails are generated

    Examples: 
      | Vehicle_Type | Tankers_Capacity | Registration_Deregistration | AddOfTankerYard | PhoneNum    | Email          | OSS | OSSPerMonth | Period Of Blacklisting |
      | Tanker       |             1000 | Registration                | addr1           | +6512345678 | test@gmail.com | Yes |         100 |                      2 |
