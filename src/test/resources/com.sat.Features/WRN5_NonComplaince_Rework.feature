@WRN5_NonComplaince_Rework
Feature: Testing Non-Compalince Rework end to end flow

  Background: Test Non-Compalince end to end flow using Rework
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "DQB Case Management"

  Scenario Outline: Generating a permit by rework on the case after SO reject the Non-Compliance case
	When user change the changearea to "GWC Tanker"
	And user selects entity as "NEA List"
	And fill the details in the NEA list record form
	  | Vehicle_Type | Tankers_Capacity | Registration_Deregistration | Iteration |
	  | Tanker       | 1000             | Registration                | 1         |
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
	And Validate "Inspection Schedule" mail with subject
	And navigate to Assignment stage and fill the respective details and navigate to next stage
	And fill the details in Bookings section
	And go to Service tasks tab and fill and complete the checklist as "Non-Complaince"
	And verify the WO status field is "Completed" and verify tanker Iscomplaint? field value as "No" in work order form
	And navigate to Inspection stage and select the Inspection completed value as yes
	And verify that "Tanker non-complaince" mail is generated once Iscomplaint? field value updated to No
	And verify that "Inspection Report" is generated
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	And logout from the application
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And verify SO is able to provide the rework comments
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And verify case moved back to Insspection stage and all values changed back to default
	And Validate that FIO get notified by Rework notification
	And open the work order and change the work order status to Inprogress
	And open the checklist and perform the amendments

	And verify the WO status field is "Completed" and verify tanker Iscomplaint? field value as "Yes" in work order form
	And navigate to Inspection stage and select the Inspection completed value as yes
	And verify permit is generated for the tanker
	And verify "Permit" letter is generated
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	And logout from the application
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And Validate that AO or SO get notified by Case or WO complaint notification
	And Validate that SO get notified to approve the case
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And Validate that AO or SO get notified by Case or WO complaint notification
	And Validate that AO get notified to approve the case
	And navigate to AO Review stage and fill the respective details and navigate to next stage
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And validate the system triggered email "Permit generation" to tankercompany once tanker is approved for disposing waste
	And validate the system triggered email "Permit WRP email" to WRP FD to update the status of Tankers
	And navigate to GenerateEmail stage and fill the respective details and navigate to next stage
	And navigate to Close stage and fill the respective details and navigate to next stage

	Examples:
	  | Vehicle_Type | Tankers_Capacity | Registration_Deregistration | AddOfTankerYard | PhoneNum    | Email          | OSS | OSSPerMonth |
	  | Tanker       | 1000             | Registration                | addr1           | +6512345678 | test@gmail.com | Yes | 100         |
