@CWD5VesselInspectionForCompliance
Feature: Testing CWD5- Vessel Inspection for Compliance.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	# SIT3 FIO User
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "CWD Case Management"

  Scenario: Vessel Inspection for Compliance flow
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And create a manual case of Case Sub Type as "Vessel Inspection" and Entity "Bedok"
	Then go to "All Activities" and verify the email for "Inspection Case Assigned for FIO Review"
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for vessel inspection "Vessel Inspection" for "Compliance" and verify WO status as "Completed"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Compliance"
	Then go to "Documents" and verify the Document for "Inspection_Report"
	Then go to "All Activities" and verify the email for "Inspection Case is approved"
	And navigate to Close stage and set Resolve Case as "Yes"
	Then verify case is "Completed" and in read only mode
	And logout from the application
