@WRN5_DepositAmountCalculations
Feature: Testing deposit amount calculatons for the tanker

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "DQB Case Management"

  Scenario Outline: Test to create NEA list record
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
	 #Give fields in below line based on the submiited type of tankers which required to create an application
	And fill the details in application form for waste type details "<GW>","<GWPerMonth>","<HW>","<HWType>","<HWPerMonth>","<OSS>","<OSSPerMonth>","<OSI>","<OSIPerMonth>"
	And create tankers by filling the details
	  | WasteType        |
	  | Greasy Waste     |
	  | Human Wastewater |
	  | OS - Ship        |
	  | OS - Industrial  |
	And logout from the admin credentials
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "DQB Case Management"
	And user change the changearea to "GWC Tanker"
	And user selects entity as "Applications"
	And approve the application
	Then verify whether case is created
	And user change the changearea to "GWC Tanker"
	And user selects entity as "Payment"
	And verify the payment record validaton for "Graesy Waste and Organic Sludge"

	Examples:
	  | AddOfCompany | PhoneNum    | Email          | GW  | GWPerMonth | HW  | HWType        | HWPerMonth | OSS | OSSPerMonth | OSI | OSIPerMonth |
	  | addr1        | +6512345678 | test@gmail.com | Yes | 100        | Yes | Domestic STPs | 100        | Yes | 20          | Yes | 30          |
   #|addr1|+6512345678|test@gmail.com|Yes|100|| | | | |Yes|100|