@WRN1_TEFSchemeAssesment
Feature: Testing WRN1-TEF Scheme Assesment functionality

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
    #SIT3- Use FIO_userid
	#When Login to app with "FIO_userid" and "FIO_pwd"
    #SIT1 - Admin
	When Login to app with "Admin_userid" and "Admin_pwd"
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
	# comment below 3 line while running the scripts in SIT3
	#And logout from the application
	#When Login to app with "FIO_userid" and "FIO_pwd"
	#And user selects App "DQB Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And navigate to Processing stage and fill all the details and navigate to next stage
	And navigate to Assignment stage and update all documents received data and navigate to next stage
	And Create a new lab report by filling "<Report_Type>","<Substance_ChemicalName>","300" details
	And verify the lab report result as "Compliance"
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	And logout from the application
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "DQB Case Management"
	And search for the case to open it
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "DQB Case Management"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And navigate to AO Review stage and fill the respective details and navigate to next stage
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "DQB Case Management"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And navigate to GenerateEmail stage and fill the respective details and navigate to next stage
	And Validate the system triggered "Written Approval Documents" email to the applicant
	And navigate to Close stage and fill the respective details and navigate to next stage
	When user change the changearea to "Factories"
	And verify the factory is fulfilled with the details as "Food-related","FPE","TER"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	Then create a manual case with case subtype as "TEF Scheme assessment"
	Then Verify that case is created starts with "DQB/TF/I" created with status "Scheduled" and verify Case notification
	And go to "Work Orders" tab
	And validate the schedule workorder notification
	And navigate to Assignment stage and fill the respective details and navigate to next stage
	And go to "Work Orders" tab
	And verify the WO status "Scheduled"
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And go to Checklist tab create sample for lab analysis details and fill the required checklist
	And verify that "COC Document" is generated
	Then go to "All Activities" and verify the email for "Request for Lab report result of samples"
	And go to "Lab Report Result" and upload lab report "file" in Prohibited Organic Heavy Metal Compounds section
	Then Verify uplaoded report dispalyed in the Prohibited Organic Heavy Metal Compounds section
	And verify the lab report result as "Non-Compliance"
	And select Interested in TEF Scheme field value
	Then go to "All Activities" and verify the email for "TEF Scheme Assesment"
	And update the consumption details as "123","476"
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	And logout from the application
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "DQB Case Management"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And validate that SO get notified to Review WA application
	Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "DQB Case Management"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And validate that AO get notified to Review WA application
	And navigate to AO Review stage and fill the respective details and navigate to next stage
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "DQB Case Management"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	Then go to "All Activities" and verify the email for Request for "Inspection Case has been Submitted for Review" and "Monthly return form and GIRO form to compan"
	And navigate to Close stage and fill the respective details and navigate to next stage
	Then verify case is "Completed" and in read only mode
	And logout from the application

	Examples:
	  | Report_Type | Substance_ChemicalName        | Result_Concentration |
	  | WQ          | Total Suspended Solids as TSS | 700                  |
