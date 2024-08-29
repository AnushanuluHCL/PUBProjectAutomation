@WRN1_TEFSchemeAssesment
Feature: Testing WRN1-TEF Scheme Assesment functionality

  Background: Test CRM Login with valid credentials
    Given User navigates to CRM login page
     When Login to app with "FIO_userid" and "FIO_pwd"
      And user selects App "DQB Case Management"

  Scenario Outline: Performing TEF Scheme Assesment
    When user change the changearea to "Factories"
     And user selects entity as "WA Applications"
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
          "SSIC":"20242",
          "Peak Discharge Rate (litre / second)":"90",
          "Number of working days per month":"20 (5-day work week)",
          "Operating Hours per Day":"8"
          
        }
      ]
      """
    Then user change the changearea to "Inspection"
     And user selects entity as "Cases"
     And change the view to "Active Cases"
     And search and open the case
     And navigate to Processing stage and navigate to next stage
     And navigate to Assignment stage and update all documents received data and navigate to next stage
     And Create a new lab report by filling "<Report_Type>","<Substance_ChemicalName>","300" details
     And verify the lab report result
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
     And Validate the system triggered "Written Approval Documents" email to the applicant
     And navigate to Close stage and fill the respective details and navigate to next stage
     When user change the changearea to "Factories"
     And verify the factory is fulfilled with the details as "Food-related","FPE","TER"
     Then user change the changearea to "Inspection"
     And user selects entity as "Cases"
     Then create a manual case with case subtype as "TEF Scheme assessment"

    Examples: 
      | Report_Type | Substance_ChemicalName        | Result_Concentration |
      | WQ        | Total Suspended Solids as TSS |                  700 |