@WRN1_NewWAApplicationCraetion
Feature: Testing WRN1-New WA Application creation functionality

  Background: Test CRM Login with valid credentials
    Given User navigates to CRM login page
     When Login to app with "FIO_userid" and "FIO_pwd"
      And user selects App "DQB Case Management"

  Scenario: Creating new WA Application
    When user change the changearea to "Factories"
     And user selects entity as "WA Applications"
    # And fill the details in the WA application form "<compname>", "<blkno>", "<unitval>", "<buildingname>", "<strname>","<postalcode>", "<Accountnum>", "<activityval">, "<tradeval>", "<catchmentval>"
     And fill the details in the WA application form with the following JSON:
      """
      [
        {
          "Block/House No": "123",
          "Unit": "456",
          "Building Name": "Tower A",
          "Street Name": "Main St",
          "Postal Code": "764536",
          "SP Services Account No.1": "7890",
          "Describe Manufacturing or Service Activities Conducted in the Factory": "Activity X",
          "Describe Activities/Processes in which Trade Effluent is Generated": "Trade Y",
          "Catchment": "Bedok",
          "Salutation": "Mrs",
          "Applicant Name":"TesterA",
          "ID Type":"NRIC",
          "Applicant Email Address":"testera@gmail.com",
          "Mobile Number":"9876543210",
          "Postal Code at CompRep":"123456",
          "Block/House No at CompRep":"4567",
          "Street Name at CompRep":"Street 248",
          "Building Name at CompRep":"Tower B",
          "SSIC":"20242"
          
        }
      ]
      """
  # And fill the details in the WA application form using data from "data.csv"
