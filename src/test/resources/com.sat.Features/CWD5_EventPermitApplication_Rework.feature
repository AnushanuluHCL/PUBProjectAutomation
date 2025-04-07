@CWD5EventPermitApplicationForRework
Feature: Testing CWD5- Event Permit Application for Rework.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "CWD Case Management"

  Scenario: Event Permit Application for Non-Compliance Rework flow
	When user change the changearea to "Inspection"
	And user selects entity as "Application"
	#And click on new button
	And create an Application from Javascript
	#And create a Application with Event Inspection type as "Pre-Event; During Event; Post Event"
	#And click on save button
	And search and open the application
	And click on "Cases" tab
	Then verify Case created with Case Reference Number "IFA/WA/I"
	#And logout from the application
	# SIT3 FIO User
	#When Login to app with "AO_userid" and "AO_pwd"
	#And user selects App "CWD Case Management"
	#When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And click on Processing Stage and fill the respective details for Event Permit Application Case
	And click on Yes button on generate permit letter popup
	And click on save button
	Then verify warning message "We are processing Event Permit Document. Please check in Document section"
	And click on Refresh button
	Then go to "Documents" and verify the Document for "PUB INDEMNITY FORM.docx"
	Then go to "Documents" and verify the Document for "Post Event Report.docx"
	And navigate to "Processing" stage and navigate to next stage
	And logout from the application
	# SIT3 SO User
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	# Notification is not triggered
	#And Validate that AO or SO get notified by Case
	And navigate to SO Review stage select SO Response as "Approve"
	And navigate to "SO Review" stage and navigate to next stage
	And go to "Child Cases" tab
	Then verify whether case is created with reference number "IFA/WA/I" and open child Case
	And logout from the application
	# SIT3 FIO User
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the child case
	Then Verify FIO receives alert notification for child case
	And go to "Work Orders" tab
	#Then Verify FIO receives alert notification for child case work order
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	# checklist need to update- First apply sorting, then complete it for "Pre-Event Inspection Checklist"
	And open "In Progress" WO fill the checklist for event inspection "Pre-Event Inspection" for "Compliance" and verify WO status as "Completed"
	# checklist need to update- First apply sorting, then complete it for "During Event Inspection Checklist"
	And open "In Progress" WO fill the checklist for event inspection "During Event Inspection" for "Compliance" and verify WO status as "Completed"
	# checklist need to update- First apply sorting, then complete it for "Post-Event Inspection Checklist"
	And open "In Progress" WO fill the checklist for event inspection "Post-Event Inspection" for "Non-Compliance" and verify WO status as "Completed"
	Then verify System Assessment and User Assessment are marked as "Non-Compliance"
	Then go to "Documents" and verify the Document for "Warning Letter"
	And navigate to Inspection stage and select the Inspection completed value as yes
	And navigate to Inspection stage and fill the respective details and navigate to next stage
	And logout from the application
	When Login to app with "sit3_SO_userid3" and "sit3_SO_pwd3"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the child case
	And navigate to SO Review stage select SO Response as "Reject"
	And logout from the application
	# SIT3 FIO User
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the child case
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	# checklist need to update- First apply sorting, then complete it for "Post-Event Inspection Checklist"
	And open "In Progress" WO fill the checklist for event inspection rework process "Post-Event Inspection" for "Compliance" and verify WO status as "Completed"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Compliance"
	And navigate to Close stage and set Resolve Case as "Yes"
	Then verify case is "Completed" and in read only mode
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And navigate to Close stage and set Resolve Case as "Yes"
	And click on Yes button on Acknowledgment Confirmation popup
	Then verify case is "Completed" and in read only mode
	And logout from the application


