@CWD1CRMSAcceptInspectionCaseReject
Feature: Testing CWD1- CRMS Case Accept Inspection Case Reject.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "CWD Case Management"

  Scenario: CRMS Case Accept Inspection Case Reject
	Then user change the changearea to "Inspection"
	And user selects entity as "CRMS Cases"
	And create a CRMS Case using excel
	And import CRMS Case
	And verify CRMS Case is created in the system and open it
	And logout from the application
	#SIT3 SO User
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "CRMS Cases"
	And user selects "Pending CRMS Cases" list view, search and open the CRMS case
	And "Accept" the CRMS Case
	And save the Case
	And refresh the page
	Then verify SIES case status as "Accepted"
	And open "SIES Case Details" tab in "CRMS Case"
	Then verify Case created with Case Reference Number "CWQ/IM/I"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And click on Save and continue button on unsaved changes popup
	Then verify warning message "Please close the CRMS case before proceeding." when more then one notification present
	Then verify warning message "Please remember to update the correct Reservoir/Waterways instead of 'Anonymous'." when more then one notification present
	And change the Entity value in the CRMSCase
	And enter Landmark and Secondary FIO field as "siesuser 6" in the CRMSCase
	And click on save button
	And click on Refresh button
	And logout from the application
	#SIT3 FIO User
	When Login to app with "sit3_FIO_userid2" and "sit3_FIO_pwd2"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And go to "CRMS Case" tab
	And complete the CRMS Closure Details
	And click on save button
	And logout from the application
	#SIT3 SO User
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for Surveillance Checklist "Surveillance Checklist for Illegal Fishing" for "Non-Compliance" and verify WO status as "Completed"
	And open work order and go to Bookings tab
	And click on "Reject" button on Work Order
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for Surveillance Checklist "Surveillance Checklist for Illegal Fishing" for "Rework" and verify WO status as "Completed"
	And open work order and go to Bookings tab
	And click on "Approve" button on Work Order
	Then go to "Documents" and verify the Document for "Inspection_Report"
	Then go to "All Activities" and verify the email for "has been submitted for review"
	And go to "Inspection Case Information" tab
	Then verify User Assessment are marked as "Compliance"
	And navigate to Close stage and set Resolve Case as "Yes"
	Then verify case is "Completed" and in read only mode
	And logout from the application