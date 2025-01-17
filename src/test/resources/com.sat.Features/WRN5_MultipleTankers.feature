@WRN5_PermitForMultipleTankers
Feature: Testing WRN5-Generating permit for multiple tankers

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "DQB Case Management"

  Scenario Outline: Generating a permit for multiple tankers
	When user change the changearea to "GWC Tanker"
	And user selects entity as "NEA List"
	And fill the details in the NEA list record form
	  | Vehicle_Type | Tankers_Capacity | Registration_Deregistration | Iteration |
	  | Tanker       | 1000             | Registration                | 1         |
	  | Tanker       | 900              | Registration                | 2         |
	  | Tanker       | 800              | Registration                | 3         |
	  | Tanker       | 700              | Registration                | 4         |
	And user selects entity as "Applications"
	And fill the details in application form for General details "<AddOfCompany>","<PhoneNum>","<Email>"
	And fill the details in application form for waste type details "<GW>","<GWPerMonth>","<HW>","<HWType>","<HWPerMonth>","<OSS>","<OSSPerMonth>","<OSI>","<OSIPerMonth>"
	And create tankers by filling the details
	  | WasteType        |
	  | Greasy Waste     |
	  | Human Wastewater |
	  | OS - Ship        |
	  | OS - Industrial  |
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
   #And Validate "Inspection Schedule" mail with subject
	And navigate to Assignment stage and fill the respective details and navigate to next stage
	And fill the details in Bookings section
	And go to Service tasks tab and fill and complete the checklist as "Compliance"
	 ##And verify the WO status field is "Completed" and verify tanker Iscomplaint? field value as "Yes" in work order form
	And navigate to Inspection stage and select the Inspection completed value as yes
	And verify permit is generated for the tanker
	 ##And verify "Permit" letter is generated
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
	  | AddOfCompany | PhoneNum    | Email          | GW  | GWPerMonth | HW  | HWType        | HWPerMonth | OSS | OSSPerMonth | OSI | OSIPerMonth |
	  | addr1        | +6512345678 | test@gmail.com | Yes | 100        | Yes | Domestic STPs | 100        | Yes | 100         | Yes | 100         |
   