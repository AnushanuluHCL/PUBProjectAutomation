@NonComplaince
Feature: Testing Non-Compalince end to end flow

  Background: Test Non-Compalince end to end flow using Rework
	Given User navigates to CRM login page
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "DQB Case Management"

  Scenario Outline: Generating a permit by rework on the case after SO reject the Non-Compliance case
	When user change the changearea to "GWC Tanker"
	And user selects entity as "NEA List"
	And fill the details "Company_name","Vehicle_Number","<Vehicle_Type>","<Tankers_Capacity>","<Registration_Deregistration>" in the NEA list record form
	And user selects entity as "Applications"
	And fill the details in application form for General details "<AddOfTankerYard>","<PhoneNum>","<Email>"
	And fill the details in application form for Human waste type details "<HW>","<HWType>","<HWPerMonth>"
	And create a tanker by filling the details
	  | WasteType        |
	  | Human Wastewater |
	And approve the application
	Then verify whether case is created
	And search and open the case
	And go to "Work Orders" tab
	And validate the schedule workorder notification
	And navigate to Assignment stage and confirm the inspection schedule
 #And Validate "Inspection Schedule" mail with subject
	And navigate to Assignment stage and fill the respective details and navigate to next stage
	And fill the details in Bookings section
	And go to Service tasks tab and fill and complete the checklist as "Non-Complaince"
 #And verify the WO status field is "Completed" and verify tanker Iscomplaint? field value as "No" in work order form
	And navigate to Inspection stage and select the Inspection completed value as yes
 #And verify that inspection report is generated
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And verify SO is able to provide the rework comments
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
 #And verify case moved back to Insspection stage and all values changed back to default
 #And Validate that FIO get notified by Rework notification
	And open the work order and change the work order status to Inprogress
	And open the checklist and perform the amendments









	Examples:
	  | Vehicle_Type | Tankers_Capacity | Registration_Deregistration | AddOfTankerYard | PhoneNum    | Email          | HW  | HWType        | HWPerMonth |
	  | Tanker       | 1000             | Registration                | addr1           | +6512345678 | test@gmail.com | Yes | Domestic STPs | 100        |