@WRN5_DeregisterandReregisterTanker
Feature: Testing WRN5-Deregister and Reregister a tanker Functionality

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "DQB Case Management"

  Scenario Outline: Deregister a tanker from the tanker company
	When user change the changearea to "GWC Tanker"
	And user selects entity as "NEA List"
	And fill the details in the NEA list record form
	  | Vehicle_Type | Tankers_Capacity | Registration_Deregistration | Iteration |
	  | Tanker       | 1000             | Registration                | 1         |
	And user selects entity as "Applications"
	And fill the details in application form for General details "<AddOfTankerYard>","<PhoneNum>","<Email>"
	And fill the details in application form for Human waste type details "<HW>","<HWType>","<HWPerMonth>"
	And create tankers by filling the details
	  | WasteType        |
	  | Human Wastewater |
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
	And navigate to Close stage and fill the respective details and navigate to next stage

	#Creating Manual Case with Case type as Tanker Deregistration
	Then create a manual case to with case subtype as "Tanker Deregistration"
	And select a tanker to deregister it
	And navigate to Processing stage and fill the respective details and navigate to next stage
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And validate that SO get notified by tanker deregister notification
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And validate that SO get notified by tanker deregister notification
	And navigate to AO Review stage and fill the respective details and navigate to next stage
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And validate the system triggered "Tanker Deregistration" email to tankercompany about deregistered tankers
	And validate the tankerpermitstatus
	And navigate to Close stage and fill the respective details and navigate to next stage

	Examples:
	  | AddOfTankerYard | PhoneNum    | Email          | HW  | HWType        | HWPerMonth |
	  | addr1           | +6512345678 | test@gmail.com | Yes | Domestic STPs | 100        |


    #Re registration code is started from below
  Scenario Outline:Reregister a tanker from the tanker company
	When user change the changearea to "GWC Tanker"
	And user selects entity as "NEA List"
	And fill the details in the NEA list record form
	  | Vehicle_Type | Tankers_Capacity | Registration_Deregistration | Iteration |
	  | oldTanker    | 1000             | Registration                | 1         |
	And user selects entity as "Applications"
	And fill the details in application form for General details "<AddOfTankerYard>","<PhoneNum>","<Email>"
	And fill the details in application form for Human waste type details "<HW>","<HWType>","<HWPerMonth>"
	And create tankers by filling the details
	  | WasteType        |
	  | Human Wastewater |
	And logout from the admin credentials
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
	And verify reregistering with new company as "Yes"

	Examples:
	  | AddOfTankerYard | PhoneNum    | Email          | HW  | HWType        | HWPerMonth |
	  | addr1           | +6512345678 | test@gmail.com | Yes | Domestic STPs | 100        |


