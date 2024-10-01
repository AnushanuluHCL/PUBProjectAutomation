@WRN11NMB_AuditInspectionForNonCompliance
Feature: Testing WRN11NMB- Audit Inspection flow for Non-Compliance.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "NMB Case Management"

  Scenario: Create Project for Audit Inspection flow for non-compliance when Account Sub Type as Minor Works Inspection
	Then user change the changearea to "Inspection"
	And user selects entity as "Projects"
	And create a Project with Account Sub Type as "Minor Works Inspection"
	Then verify Project is created and open the Project
	And enter BPU Officers field in the Project and save the record
	And user selects entity as "1BPU Submissions"
	And create a BPU Submissions for the Project with Account Sub Type as "Minor Works Inspection"
	And user selects entity as "Projects"
	Then verify Project is created and open the Project
	And open "1BPU Submissions" tab in "Entity"
	Then verify BPU Submission is created and associated with the Project
	And open BPU Submission and enter Qualified Person field
	And open "Inspection Cases" tab in "Entity"
	Then verify Case created
	Then verify Work Order created
	And logout from the application
	When Login to app with "FIO_useridNMB" and "FIO_pwdNMB"
	#SIT 3
	#When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "NMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	And open "Unscheduled" WO and create the manual Booking
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	Then go to "All Activities" and verify the email for "Joint Inspection (Minor Works) has been scheduled"
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And open "In Progress" WO and fill the "Non-Compliance" checklist for "Audit Inspection: Temp Toilet / Minor Works Check"
	Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Not In Order"
	And click on Generate Letter button
	Then go to "All Activities" and verify the email for "Project Reference No."
	Then go to "Documents" and verify the Document for "Not_In-Order_Letter_"
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "NMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	And navigate to SO Review stage fill the respective details and navigate to next stage
	Then verify case is "Completed" and in read only mode

  Scenario: Create Project for Audit Inspection flow for non-compliance when Account Sub Type as New Development Inspection
	Then user change the changearea to "Inspection"
	And user selects entity as "Projects"
	And create a Project with Account Sub Type as "New Development Inspection"
	Then verify Project is created and open the Project
	And enter BPU Officers field in the Project and save the record
	And user selects entity as "1BPU Submissions"
	And create a BPU Submissions for the Project with Account Sub Type as "New Development Inspection"
	And user selects entity as "Projects"
	Then verify Project is created and open the Project
	And open "1BPU Submissions" tab in "Entity"
	Then verify BPU Submission is created and associated with the Project
	And open BPU Submission and enter Qualified Person field
	And open "Inspection Cases" tab in "Entity"
	Then verify Case created
	Then verify Work Order created
	And logout from the application
	#When Login to app with "FIO_userDev2" and "FIO_pwdDev2"
	When Login to app with "FIO_useridNMB" and "FIO_pwdNMB"
	And user selects App "NMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	And open "Unscheduled" WO and create the manual Booking
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	Then go to "All Activities" and verify the email for "Joint Inspection (New Development) has been scheduled"
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And open "In Progress" WO and fill the "Non-Compliance" checklist for "WRN 11 NMB Sanitary Inspection"
	Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Not In Order"
	And click on Generate Letter button
	Then go to "All Activities" and verify the email for "Project Reference No."
	Then go to "Documents" and verify the Document for "Not_In-Order_Letter_"
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "NMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	And navigate to SO Review stage fill the respective details and navigate to next stage
	Then verify case is "Completed" and in read only mode

	# Re Inspection Test Cases
  Scenario: Audit Inspection flow for non-compliance. Verify Re inspection Work Order creation when Account Sub Type as New Development Inspection
	Then user change the changearea to "Inspection"
	And user selects entity as "Projects"
	And create a Project with Account Sub Type as "New Development Inspection"
	Then verify Project is created and open the Project
	And enter BPU Officers field in the Project and save the record
	And user selects entity as "1BPU Submissions"
	And create a BPU Submissions for the Project with Account Sub Type as "New Development Inspection"
	And user selects entity as "Projects"
	Then verify Project is created and open the Project
	And open "1BPU Submissions" tab in "Entity"
	Then verify BPU Submission is created and associated with the Project
	And open BPU Submission and enter Qualified Person field
	And open "Inspection Cases" tab in "Entity"
	Then verify Case created
	Then verify Work Order created
	And logout from the application
	#When Login to app with "FIO_userDev2" and "FIO_pwdDev2"
	When Login to app with "FIO_useridNMB" and "FIO_pwdNMB"
	And user selects App "NMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And select Yes for Hydro Test & Low Pressure Air Test Submitted in Case
	And go to "Work Orders" tab
	And open "Unscheduled" WO and create the manual Booking
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	Then go to "All Activities" and verify the email for "Joint Inspection (New Development) has been scheduled"
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And open "In Progress" WO and fill the "Non-Compliance" checklist for "WRN 11 NMB Sanitary Inspection"
	Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Not In Order"
	And click on Generate Letter button
	Then go to "All Activities" and verify the email for "Project Reference No."
	Then go to "Documents" and verify the Document for "Not_In-Order_Letter_"
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "NMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	# Code for Re inspection Work Order creation
	And SO send case for Re-inspection
	And logout from the application
	When Login to app with "FIO_useridNMB" and "FIO_pwdNMB"
	And user selects App "NMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	And create manual Work Order
	And go to "Work Orders" tab
	And open "Unscheduled" WO and create the manual Booking
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	Then go to "All Activities" and verify the email for "Joint Inspection (New Development) has been scheduled"
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And open "In Progress" WO and fill the "Compliance" checklist for "WRN 11 NMB Sanitary Inspection"
	# need to remove signout
	And navigate to Inspection stage and fill the respective details
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "In Order"
	Then verify case is "Completed" and in read only mode

	# Re Inspection Test Cases
  Scenario: Audit Inspection flow for non-compliance. Verify Re inspection Work Order creation when Account Sub Type as Minor Works Inspection
	Then user change the changearea to "Inspection"
	And user selects entity as "Projects"
	And create a Project with Account Sub Type as "Minor Works Inspection"
	Then verify Project is created and open the Project
	And enter BPU Officers field in the Project and save the record
	And user selects entity as "1BPU Submissions"
	And create a BPU Submissions for the Project with Account Sub Type as "Minor Works Inspection"
	And user selects entity as "Projects"
	Then verify Project is created and open the Project
	And open "1BPU Submissions" tab in "Entity"
	Then verify BPU Submission is created and associated with the Project
	And open BPU Submission and enter Qualified Person field
	And open "Inspection Cases" tab in "Entity"
	Then verify Case created
	Then verify Work Order created
	And logout from the application
	When Login to app with "FIO_useridNMB" and "FIO_pwdNMB"
	And user selects App "NMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	And open "Unscheduled" WO and create the manual Booking
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	Then go to "All Activities" and verify the email for "Joint Inspection (Minor Works) has been scheduled"
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And open "In Progress" WO and fill the "Non-Compliance" checklist for "Audit Inspection: Temp Toilet / Minor Works Check"
	Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Not In Order"
	And click on Generate Letter button
	Then go to "All Activities" and verify the email for "Project Reference No."
	Then go to "Documents" and verify the Document for "Not_In-Order_Letter_"
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "NMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	# Code for Re inspection Work Order creation
	And SO send case for Re-inspection
	And logout from the application
	When Login to app with "FIO_useridNMB" and "FIO_pwdNMB"
	And user selects App "NMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	And create manual Work Order
	And go to "Work Orders" tab
	And open "Unscheduled" WO and create the manual Booking
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	Then go to "All Activities" and verify the email for "Joint Inspection (Minor Works) has been scheduled"
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And open "In Progress" WO and fill the "Compliance" checklist for "Audit Inspection: Temp Toilet / Minor Works Check"
	And navigate to Inspection stage and fill the respective details
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "In Order"
	Then verify case is "Completed" and in read only mode