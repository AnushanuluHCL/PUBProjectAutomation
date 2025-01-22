@CWD3&6NonIndustrialPremisesForNonCompliance
Feature: Testing CWD3&6- Non Industrial Premises  for Non-Compliance.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	# SIT3 FIO User
	When Login to app with "sit3_FIO_userid2" and "sit3_FIO_pwd2"
	And user selects App "CWD Case Management"

  Scenario: Non Industrial Premises  for Non-Compliance flow
	Then user change the changearea to "Inspection"
	And user selects entity as "Premises"
	And create an manual Premises where Entity Type as "Non-industrial Premises"
	And open "Inspection Cases" tab in "Entity"
	Then verify Case created with Case Reference Number "CWQ/CM/I"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And click on Refresh button
	And refresh the browser
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for Premises Inspection Checklist "Premises Inspection" for "Non-Compliance" and verify WO status as "Completed"
	Then go to "Documents" and verify the Document for "Advisory Letter"
	Then go to "Documents" and verify the Document for "Chain of Custody Form.pdf"
	Then go to "Documents" and verify the Document for "WorkOrder_Report"
	Then go to "All Activities" and verify the email for "Request for Lab report result of samples"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Non-Compliance"
	And go to "Lab Report Result" tab
	And upload compliance lab report
	Then go to "Documents" and verify the Document for "CWD3&6_LabReport_NonCompliance"
	And go to "Lab Report Result" tab
	And upload lab report
	And click on Refresh button
	And click on Save and continue button on unsaved changes popup
	And click on save button
	And go to "Lab Report Result" tab
	Then verify System Assessment in lab report result as "Non-Compliance"
	And click on Refresh button
	Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
	And logout from the application
	# SIT3 SO User
	When Login to app with "sit3_SO_userid" and "sit3_SO_pwdd"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	Then go to "Documents" and verify the Document for "Warning Letter"
	Then go to "All Activities" and verify the email for "Warning Email Letter"
	Then go to "All Activities" and verify the email for "Rectification required"
	Then verify Case notification in "Inspection Case Information" tab
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	# SIT3 AO User
	When Login to app with "sit3_AO_userid2" and "sit3_AO_pwd2"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	Then verify Case notification in "Inspection Case Information" tab
	And navigate to AO Review stage and fill the details and navigate to next stage
	And click on Refresh button
	Then verify case is "Completed" and in read only mode
	And logout from the application

