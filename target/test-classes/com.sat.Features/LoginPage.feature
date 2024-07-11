@login
Feature: Testing Login Functionality

Background: Test CRM Login with valid credentials
 		Given User navigates to CRM login page
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "DQB - Case Management" 

 Scenario Outline: Test to create NEA list record
    When user change the changearea to "GWC Tanker"
    And user selects entity as "NEA List"
    And fill the details "Company_name","Vehicle_Number","<Vehicle_Type>","<Tankers_Capacity>","<Registration_Deregistration>" in the NEA list record form
 		And user selects entity as "Applications"
		And fill the details in application form for General details "<AddOfCompany>","<AddrOfTanker>","<PhoneNum>","<Email>"
    And fill the details in application form for waste type details "<GW>","<GWPerMonth>","<HW>","<HWType>","<HWPerMonth>","<OSS>","<OSSPerMonth>","<OSI>","<OSIPerMonth>"
   #And fill the details in application form for waste type details
   #|GW|GWPerMonth|HW|HWType|HWPerMonth|OSS|OSSPerMonth|OSI|OSIPerMonth|
   #|Yes|100|Yes|Domestic STPs|100|Yes|100|Yes|100|
  # |Yes|100|Yes|Domestic STPs|100|	|	|Yes|100|
    And create a tanker by filling the details
    |CapacityOfTanker|WasteType|
    |1000|Greasy Waste|
    #|1000|Human Wastewater|
    |1000|OS - Ship|
    #|1000|OS - Industrial|
    Examples:
   #|Vehicle_Type|Tankers_Capacity|Registration_Deregistration|AddOfCompany|AddrOfTanker|PhoneNum|Email|
   #|Tanker|1000|Registration|addr1|addr1|+6512345678|test@gmail.com|
   |Vehicle_Type|Tankers_Capacity|Registration_Deregistration|AddOfCompany|AddrOfTanker|PhoneNum|Email|GW|GWPerMonth|HW|HWType|HWPerMonth|OSS|OSSPerMonth|OSI|OSIPerMonth|
  	|Tanker|1000|Registration|addr1|addr1|+6512345678|test@gmail.com|Yes|100|Yes|Domestic STPs|100|Yes|100|Yes|100|
  