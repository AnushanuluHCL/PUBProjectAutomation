@POC
Feature: Testing Login Functionality

Background: Test CRM Login with valid credentials
 		Given User navigates to CRM login page
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "DQB - Case Management" 

 Scenario Outline: Generating a permit by creating a new permit application
  When user change the changearea to "GWC Tanker"
  And user selects entity as "NEA List"
  And fill the details "Company_name","Vehicle_Number","<Vehicle_Type>","<Tankers_Capacity>","<Registration_Deregistration>" in the NEA list record form
 	And user selects entity as "Applications"
	And fill the details in application form for General details "<AddOfTankerYard>","<PhoneNum>","<Email>"
  And fill the details in application form for Human waste type details "<HW>","<HWType>","<HWPerMonth>"
  And create a tanker by filling the details
    |WasteType|
    |Human Wastewater|
  And approve the application
  Then verify whether case is created
  And search and open the case
  And go to "Work Orders" tab
  And validate the schedule workorder notification
  And navigate to Assignment stage and confirm the inspection schedule
  And Validate "Inspection Schedule" mail with subject 
  And fill the details in Bookings section
  And go to Service tasks tab and fill and complete the checklist as "Complaince"
And verify the WO status field is "Completed" and verify tanker Iscomplaint? field value as "Yes" in work order form 
#And verify whether case outcome is complaince by checking Is complaint? field value as "Yes" in case form
  #And navigate to Assignment stage and fill the respective details and navigate to next stage
	#And navigate to Inspection stage and select the Inspection completed value as yes
	#And verify permit is generated for the tanker
	#And verify "Permit" letter is generated
  #And navigate to Inspection stage and fill the respective details and navigate to next stage
  #When Login to app with "SO_userid" and "SO_pwd"
  #And user selects App "DQB - Case Management" 
  #And search for the case to open it
  #And Validate that SO get notified by case/WO complaint notification
  #And Validate that SO get notified to approve the case
  
	
    Examples:
   |Vehicle_Type|Tankers_Capacity|Registration_Deregistration|AddOfTankerYard|PhoneNum|Email|HW|HWType|HWPerMonth|
   |Tanker|500|Registration|addr1|+6512345678|test@gmail.com|Yes|Domestic STPs|100|