@CWD3&6DischargeIntoWaterWaysForNonCompliance
Feature: Testing CWD3&6- Discharge into Water Ways  for Non-Compliance.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "CWD Case Management"

  Scenario: Discharge into Water Ways for Non-Compliance flow
	Then user change the changearea to "Inspection"
	And user selects entity as "CRMS Cases"
	And create a CRMS Case for C&W-Drainage Ops- Pollution in waterways algae in waterways using excel
	And import CRMS Case for C&W-Drainage Ops
	And verify CRMS Case is created in the system and open it
	And logout from the application
	#SIT3 SO User
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "CRMS Cases"
	And user selects "Pending CWD3&6 CRMS Cases" list view, search and open the CRMS case
	And "Accept" the CRMS Case
	And save the Case
	And refresh the page
	Then verify SIES case status as "Accepted"
	And open "SIES Case Details" tab in "CRMS Case"
	Then verify Case created with Case Reference Number "CWQ/RS/I"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And click on Save and continue button on unsaved changes popup
	Then verify warning message "Please remember to update Entity from anonymous, send the documents to CRMS & fill-in case closure details before closing the case"
	And logout from the application
	#SIT3 FIO User
	When Login to app with "AO_userid" and "AO_pwd"
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
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for Discharge into Waterways Checklist "Discharge into Waterways" for "Non-Compliance" and verify WO status as "Completed"
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
	And click on save button
	And click on Refresh button
	And click on Save and continue button on unsaved changes popup
	And click on save button
	And go to "Lab Report Result" tab
	Then verify System Assessment in lab report result as "Non-Compliance"
	And go to "Inspection Case Information" tab
	And select User Assessment as "Compliance" and Enter Deviation Remarks
	And click on Refresh button
	Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
	And logout from the application
	# SIT3 SO User
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	And navigate to SO Review stage fill Approve and Resolve Case and navigate to next stage
	Then verify case is "Completed" and in read only mode
	And logout from the application