@WRN5_Resealing
Feature: Testing WRN5-Tanker Resealing Functionality

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "DQB Case Management"

  Scenario Outline: Resealing of the tanker
	When user change the changearea to "GWC Tanker"
	And user selects entity as "NEA List"
	And fill the details in the NEA list record form
	  | Vehicle_Type | Tankers_Capacity | Registration_Deregistration | Iteration |
	  | Tanker       | 1000             | Registration                | 1         |
	And user selects entity as "Applications"
	And fill the details in application form for General details "<AddOfTankerYard>","<PhoneNum>","<Email>"
	And fill the details in application form for organic industries waste type details "<OSI>","<OSIPerMonth>"
	And create tankers by filling the details
	  | WasteType       |
	  | OS - Industrial |
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
	And logout from the application
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
	And navigate to Close stage and fill the respective details and navigate to next stage

	Then create a manual case with case subtype as "Tanker Resealing"
	And go to "Work Orders" tab
	And create a new manual WO to create the tanker again
	And go to Service tasks tab and fill and complete the checklist as "Resealing"

	And navigate to "Processing" stage and navigate to next stage
	And navigate to Assignment stage and confirm the inspection schedule
	And navigate to Assignment stage and fill the respective details and navigate to next stage
	And navigate to Inspection stage and select the Inspection completed value as yes
	And navigate to Inspection stage and fill the respective details and navigate to next stage
    And logout from the application
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And validate that SO/AO get notified by resealing notification
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And validate that SO/AO get notified by resealing notification
	And navigate to AO Review stage and fill the respective details and navigate to next stage
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And navigate to GenerateEmail stage and fill the respective details and navigate to next stage
	And validate the system triggered "Tanker Resealing" email to tankercompany about resealed tankers
	And validate the resealing tanker information
	And navigate to Close stage and fill the respective details and navigate to next stage

	Examples:
	  | Vehicle_Type | Tankers_Capacity | Registration_Deregistration | AddOfTankerYard | PhoneNum    | Email          | OSI | OSIPerMonth |
	  | Tanker       | 1000             | Registration                | addr1           | +6512345678 | test@gmail.com | Yes | 100         |