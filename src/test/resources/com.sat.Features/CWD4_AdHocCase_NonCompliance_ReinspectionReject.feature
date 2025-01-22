@CWD4AdHocCaseForNonComplianceReInspectionReject
Feature: Testing CWD4- AdHoc Case for Non-Compliance.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	# SIT3 Admin User
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "CWD Case Management"

  Scenario: AdHoc Case for Non-Compliance flow ReInspection Reject flow
	Then user change the changearea to "Inspection"
	When user selects entity as "Construction Sites"
	And create a manual Construction Sites where Entity Type as "Construction sites", Account Sub Type as "DTSS/Trunk Sewer BCA Projects Inspection" and Project Title as "development"
	And click on save button
	And click on Refresh button
	Then go to "All Activities" in project and verify the email for "development"
	And open "Inspection Cases" tab in "Entity"
	And create a manual case of Case sub type as "Raw Water Main Pipeline Inspection"
	And logout from the application
	# SIT3 FIO User- FIO & Admin users are same
	When Login to app with "Admin_userid" and "Admin_pwd"
	# Comment- Uncomment the below line while running in different environment
	#And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	Then verify Case notification in "Inspection Case Information" tab
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for Raw Water Main Pipeline inspection "Raw Water Main Pipeline Inspection" for "ReInspection" and verify WO status as "Completed"
	And refresh the page
	Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Non-Compliance"
	Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
	Then go to "All Activities" and verify the email for "Rectification Required for construction site"
	Then go to "All Activities" and verify the email for "Stop Work Order Declaration to construction site"
	Then go to "Documents" and verify the Document for "Inspection_Report"
	And logout from the application
	#Re inspection process- Is different in CWD4
	When Login to app with "Admin_userid" and "Admin_pwd"
	#And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	And open work order and go to "Summary" tab
	Then verify Rectification Email Sent is marked as "No" and Rectification Required is marked as "Yes"
	And open "FormSG Submission" tab in "Work Order"
	# In CWD4 Cases and Entity is not auto populated
	And create a new Form SG with details
	And refresh the page
	# ReInspection Reject Process
	And click on "Reject" button
	And click on Refresh button
	And click on Save&Close button
	And click on Refresh button
	Then verify Rectification Email Sent is marked as "No" and Rectification Required is marked as "Yes"
	And click on Save&Close button
	Then go to "All Activities" and verify the email for "New Form SG Submission related"
	Then go to "All Activities" and verify the email for "[Rectification Rejected]"
	And go to "Work Orders" tab
	And open work order and go to "FormSG Submission" tab
	Then verify Rectification Submission status is marked as "Rejected"
	# ReInspection Approve Process
	And create a new Form SG with details
	And refresh the page
	And click on "Approve" button
	And click on Refresh button
	Then go to "All Activities" and verify the email for "New Form SG Submission related"
	Then go to "All Activities" and verify the email for "[Rectification Approved]"
	And go to "Work Orders" tab
	And open work order and go to "Summary" tab
	Then verify Rectification Email Sent is marked as "No" and Rectification Required is marked as "No"
	And open "FormSG Submission" tab in "Work Order"
	Then verify Rectification Submission status is marked as "Accepted"
	And logout from the application
	# SIT3 SO User
	When Login to app with "sit3_SO_userid2" and "sit3_SO_pwd2"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	Then verify Case notification in "Inspection Case Information" tab
	And navigate to SO Review stage select SO Response as "Approve"
	And navigate to "SO Review" stage and navigate to next stage
	And logout from the application
	# SIT3 AO User
	When Login to app with "sit3_AO_userid2" and "sit3_AO_pwd2"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	Then verify Case notification in "Inspection Case Information" tab
	And navigate to AO Review stage and fill the details and navigate to next stage
	And click on Refresh button
	Then verify case is "Closed" and in read only mode
	And logout from the application