@CWD2AdHocCaseForReInspectionAccept
Feature: Testing CWD2- AdHoc Case for Non-Compliance.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	# SIT3 Admin User
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "CWD Case Management"

  Scenario: AdHoc Case for Non-Compliance ReInspection Accept flow
	When user change the changearea to "Inspection"
	When user selects entity as "Construction Sites"
	And create a manual Construction Sites where Entity Type as "Construction sites", Account Sub Type as "DTSS/Trunk Sewer BCA Projects Inspection" and Project Title as "development"
	And click on save button
	And click on Refresh button
	Then go to "All Activities" in project and verify the email for "development"
	And open "Inspection Cases" tab in "Entity"
	And create a manual case of Case sub type as "ECM Setup and Drainage Work"
	And logout from the application
	# SIT3 FIO User
	When Login to app with "sit3_FIO_userid2" and "sit3_FIO_pwd2"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	And open "ECM Setup and Drainage Work Inspection" work order with filter Incident Type
	And click on Acknowledge button and with the details
	And click on Refresh button
	And click on Save&Close button
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for ECM Setup and Drainage Work inspection "ECM Setup and Drainage Work Inspection" for "Non-Compliance" and verify WO status as "Completed"
	Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Non-Compliance"
	And navigate to "Inspection" stage and navigate to next stage
	Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
	And logout from the application
	#Re inspection process
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "FormSG Submission" tab
	#And enter rectification due date and select rectification required
	And select rectification required
	And click on save button
	And click on Refresh button
	And go to "FormSG Submission" tab
	And create a new Form SG
	And logout from the application
	# SIT3 FIO User
	When Login to app with "sit3_FIO_userid2" and "sit3_FIO_pwd2"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "FormSG Submission" tab
	And open FormSG form
	And click on "Approve" button
	And click on Refresh button
	Then go to "Documents" and verify the Document for "Inspection_Report"
	Then go to "All Activities" and verify the email for "New Form SG Submission related"
	Then go to "All Activities" and verify the email for "Submission of Rectification Report for"
	And go to "FormSG Submission" tab
	Then verify Rectification Submission status is marked as "Accepted"
	Then verify Rectification Documents Verified is marked as "---" and Rectification Required is marked as "No"
	And logout from the application
	# SIT3 SO User
	When Login to app with "sit3_SO_userid2" and "sit3_SO_pwd2"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	Then verify Case notification in "Inspection Case Information" tab
	And navigate to SO Review stage select SO Response as "Approve"
	#Comment the code below
	And click on save button
	And click on Refresh button
	And logout from the application
	# Admin user
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	#Comment the till here
	And navigate to "SO Review" stage and navigate to next stage
	And logout from the application
	# SIT3 AO User
	When Login to app with "sit3_AO_userid2" and "sit3_AO_pwd2"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	Then verify Case notification in "Inspection Case Information" tab
	And navigate to AO Review stage and fill the details and navigate to next stage
	And click on Refresh button
	Then verify case is "Closed" and in read only mode
	And logout from the application