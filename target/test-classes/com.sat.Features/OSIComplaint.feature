@OSIComplaint
Feature: Testing Login Functionality

Background: Test CRM Login with valid credentials
 		Given User navigates to CRM login page
 		When Login to app with "Admin_userid" and "Admin_pwd"
    And user selects App "DQB Case Management" 
    #When Login to app with "FIO_userid" and "FIO_pwd"
    #And user selects App "DQB Case Management" 

 Scenario Outline: Test to create NEA list record
   When user change the changearea to "GWC Tanker"
    And  user selects entity as "NEA List"
    #And  create an NEA record through interface
    And fill the details "Company_name","Vehicle_Number","<Vehicle_Type>","<Tankers_Capacity>","<Registration_Deregistration>" in the NEA list record form
 		And user selects entity as "Applications"
		And fill the details in application form for General details "<AddrOfTanker>","<PhoneNum>","<Email>"	
    And fill the details in application form for organic industries waste type details "<OSI>","<OSIPerMonth>"
    And create a tanker by filling the details
    |CapacityOfTanker|WasteType|
    |1000|OS - Industrial|
    And logout from the admin credentials
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "DQB Case Management" 
    And user change the changearea to "GWC Tanker"
    And user selects entity as "Applications"
    And approve the application
    Then verify whether case is created
    Examples:
   |Vehicle_Type|Tankers_Capacity|Registration_Deregistration|AddrOfTanker|PhoneNum|Email|OSI|OSIPerMonth|
  	|Tanker|1000|Registration|addr1|+6512345678|test@gmail.com|Yes|100|
  