@WRN8_NMB_Non-Complaince
Feature: Testing WRN7 IMB - Noncomplaince

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	#SIT3
	When Login to app with "sit3_Admin_userid" and "sit3_Admin_pwd"
	#SIT1
	#When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "IMB Case Management"

  Scenario: Inspecting Pumping Main Station- Noncomplaince flow
	When user selects entity as "Pumping Main Stations"
	And create a new pumping station by giving "Pumping Main Stations","Bedok"
	And creating 2 chambers
	Given User navigates to powerapps cloud flow page in "SIT3" environment
	And Run the automatic cloudflow job for "SIES/WRN7/IMB/Pumping Main Station Inspection Case"
	And logout from the powerapps application
	Given User navigates to CRM login page
	And logout from the application
	#SIT1
	#When Login to app with "FIO_userid" and "FIO_pwd"
	#SIT3
	When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
	And user selects App "IMB Case Management"
	Then verify whether case is created after the job run
	
	And change the view "All Cases" and search a case
	And Verify that created case starts with "IMB/PC/I" with status "In Progress"
	And go to "Work Orders" tab
	And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
	And go to Service tasks tab and complete the checklist with "Yes"
	And verify Booking status is "Completed" and WO status field is "Completed"
	Then verify System Assessment and User Assessment are marked as "Non-Compliance" in case form
	And verify that "Inspection Report" is generated
	And logout from the application
	#SIT1
	#When Login to app with "SO_userid" and "SO_pwd"
	#SIT3
	When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
	And user selects App "IMB Case Management"
	And search for the case to open it
    #And verify SO get notified by alert for approval
    #And go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    #And go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review" and "Attention: Any Construction Sites"
    #Then navigate to SO Review stage and fill the respective details and navigate to next stage
    #And navigate to Close stage and set Resolve Case as "Yes"
	#Then verify case is "Completed" and in read only mode
  	#And logout from the application
	  
	  
   
