@WRN5_DepositAmountCalculations
Feature: Testing deposit amount calculations for the tanker

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "DQB Case Management"

  Scenario Outline: Validate the Deposit amount calculation process for the Tanker
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
	 #Give fields in below line based on the submitted type of tankers which required to create an application
	And fill the details in application form for waste type details "<GW>","<GWPerMonth>","<HW>","<HWType>","<HWPerMonth>","<OSS>","<OSSPerMonth>","<OSI>","<OSIPerMonth>"
	And create tankers by filling the details
	  | WasteType        |
	  | Greasy Waste     |
	  | Human Wastewater |
	  | OS - Ship        |
	  | OS - Industrial  |
	And logout from the application
	#Sit1
	#When Login to app with "FIO_userid" and "FIO_pwd"
	#Sit3
	When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
	And user selects App "DQB Case Management"
	And user change the changearea to "GWC Tanker"
	And user selects entity as "Applications"
	And approve the application
	Then verify whether case is created
	When Case is opened verify the fields
	And go to "Work Orders" tab
	And validate the schedule workorder notification
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And navigate to Assignment stage and confirm the inspection schedule
	And Validate "Inspection Schedule" mail with subject
	And go to "Work Orders" tab
	And go to Service tasks tab and fill and complete the checklist as "Compliance"
	And navigate to Assignment stage and fill the respective details and navigate to next stage
	And navigate to Inspection stage and select the Inspection completed value as yes
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	And logout from the application
	#Sit1
	#When Login to app with "SO_userid" and "SO_pwd"
	#SIT3
	When Login to app with "SIT3_SOUser" and "SIT3_SOPwd"
	And user selects App "DQB Case Management"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	#SIT1
	#When Login to app with "AO_userid" and "AO_pwd"
	#SIT3
	When Login to app with "SIT3_AOUser" and "SIT3_AOPwd"
	And user selects App "DQB Case Management"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	And navigate to AO Review stage and fill the respective details and navigate to next stage
	#Sit1
	#When Login to app with "FIO_userid" and "FIO_pwd"
	#Sit3
	When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
	And user selects App "DQB Case Management"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And navigate to GenerateEmail stage and fill the respective details and navigate to next stage
	#And validate the system triggered email "Permit generation" to tankercompany once tanker is approved for disposing waste
	#And validate the system triggered email "Permit WRP email" to WRP FD to update the status of Tankers
	#And navigate to Close stage and fill the respective details and navigate to next stage
	And logout from the application
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "DQB Case Management"
	And user change the changearea to "GWC Tanker"
	And user selects entity as "Payment"
	Then verify the payment validation before creating actual quantities for <GWPerMonth>, <OSSPerMonth> and <OSIPerMonth>
	And user selects entity as "Actual Quantity (Disposal)S"
	And Create Actual Quantity (Disposal) by filling details
	  | WasteType                   | Quantity |
	  | Greasy Waste                | 100      |
	  | Human Wastewater            | 90       |
	  | Organic Sludge – Ships      | 80       |
	  | Organic Sludge – Industries | 70       |
	And user selects entity as "Payment"
	Then Verify the payment validation after creating actual quantities for <GWPerMonth>, <OSSPerMonth>, <OSIPerMonth> <GWActual> and <OSActual>
	And user selects entity as "Deposits"
	# Create excel with GIRO
	And Update excel with GIRO value as "R" for Deposit Amount calculation
	And Upload excel file for Deposit Amount calculation with deposit amount as <DepositAmount> and giro as "R"
	And user selects entity as "Payment"
	# Verify payment validation after creating deposit quantities with GIRO
	Then Verify the payment validation after creating deposit quantities for <GWPerMonth>, <OSSPerMonth>, <OSIPerMonth> <GWActual>, <OSActual> and <DepositAmount>
	And user selects entity as "Deposits"
	# Create excel without GIRO
	And Update excel with GIRO value as "" for Deposit Amount calculation
	And Upload excel file for Deposit Amount calculation with deposit amount as <DepositAmount> and giro as ""
	And user selects entity as "Payment"
	# Verify payment validation after creating deposit quantities without GIRO
	Then Verify the payment validation after creating deposit quantities for <GWPerMonth>, <OSSPerMonth>, <OSIPerMonth> <GWActual>, <OSActual> and <DepositAmount>

	Examples:
	  | AddOfCompany | PhoneNum    | Email          | GW  | GWPerMonth | HW  | HWType        | HWPerMonth | OSS | OSSPerMonth | OSI | OSIPerMonth | GWActual | OSActual | DepositAmount |
	  | addr1        | +6512345678 | test@gmail.com | Yes | 100        | Yes | Domestic STPs | 100        | Yes | 20          | Yes | 30          | 100      | 150      | 500           |