@WRN8IMBNonComplaince
Feature: Testing WRN8 IMB-Noncompliance and Re inspection

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "IMB Case Management"

  Scenario Outline: Inspecting Sewer/DTSS by reinspecting again when any noncompliance happened
	When user selects entity as "Construction Sites"
	And change the view to "List of Construction Sites"
	And create Project with title as "development"
	And import IMB data
	And verify record is created in the system and open it
	Then go to "All Activities" in project and verify the email for "development"
    # These Mukim/Lot no. usually coming from FormSG link from Request for Mukim/Lot no. email. Now updating manually in project
	Then go to "Summary" tab and update the Contractor
	Then go to "Summary" tab and update the Mukim number as "333" and Lot number "135"
	And go to "POWS Submissions" tab and update the "<Project_Mukim_Lot_No.>","<Diameter>","<Affected by DTSS>", "<Affected by Sewer>" and "<Affected Pumping Main>" GERI response values for IMB
	And open "Inspection Cases" tab in "Entity"
	Then verify Case created in Project
	Then verify Work Order created
	And logout from the application
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "IMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And save the Case
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And open "In Progress" WO and fill the "Non-Compliance" checklist for BCA Project "BCA Project Site Inspection affecting pumping mains"
	And verify Booking status is "Completed" and WO status field is "Completed"
	Then verify System Assessment and User Assessment are marked as "Non-Compliance" in case form
	Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
	Then go to "All Activities" and verify the email for "NOTICE UNDER REGULATION"
	Then go to "Documents" and verify the Document for "Inspection_Report"
	And logout from the application
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "IMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "IMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
	And navigate to AO Review stage and fill the respective details
	Then verify case is "Completed" and in read only mode
	#Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review" and "Project Reference Number" and "Please Obtain POWS Approval from PUB"
    ##When user click on entity link on case form
	#And change the Reinspection date value
	#And logout from the application
	#Given User navigates to powerapps cloud flow page
	#When Login to powerapp with "PAsit2_userid" and "PAsit2_pwd"
	#And Run the automatic cloudflow job for "SIES/WRN8 NMB/Creating WO for Reinspection BCA projects"
	#And logout from the powerapps application
    
 # Re inspection work order
	#When Login to app with "FIO_userid" and "FIO_pwd"
	#And user selects App "NMB Case Management"
	#And search for the case to open it
	#And go to "Work Orders" tab
	#And verify new work order is created with type as "Re-Inspection" after job run and open it
    #Then Click and open the work order
    #And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	#And open WO and fill the Booking details
    #And go to Service tasks tab and fill and complete the checklist as "Non-Compliance"
    #And verify Booking status is "Completed" and WO status field is "Completed"
    #Then verify System Assessment and User Assessment are marked as "Compliance" in case form
    #When Login to app with "SO_userid" and "SO_pwd"
    #And user selects App "NMB Case Management"
    #And search for the case to open it
    #And verify SO/AO get notified by alert for approve
    #And navigate to SO Review stage and fill the respective details and navigate to next stage
    #And navigate to Close stage and fill the respective details and navigate to next stage
	Examples:
	  | Project_Mukim_Lot_No. | Diameter | Affected by DTSS | Affected by Sewer | Affected Pumping Main |
	  | 4536456               | 1000     | No               | No                | Yes                   |
