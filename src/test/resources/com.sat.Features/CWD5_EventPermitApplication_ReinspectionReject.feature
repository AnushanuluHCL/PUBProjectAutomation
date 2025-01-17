@CWD5EventPermitApplicationForReInspectionReject
Feature: Testing CWD5- Event Permit Application for Compliance.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "CWD Case Management"

  Scenario: Event Permit Application for Non-Compliance ReInspection Reject flow
	Then user change the changearea to "Inspection"
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
	#Then user change the changearea to "Inspection"
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
	Then user change the changearea to "Inspection"
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
	Then user change the changearea to "Inspection"
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
	#Re inspection process
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the child case
	And go to "FormSG Submission" tab
	And enter rectification due date and select rectification required
	And click on save button
	And click on Refresh button
	And go to "FormSG Submission" tab
	And create a new Form SG
	And click on "Reject" button
	And logout from the application
	# SIT3 FIO User
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the child case
	And click on Refresh button
	And go to "FormSG Submission" tab
	Then verify Rectification Submission status is marked as "Rejected"
	#Then verify Rectification Documents Verified is marked as "Yes" and Rectification Required is marked as "No"
	And go to "Work Orders" tab
	And open "Post-Event Inspection" work order with filter Incident Type
	And click on create reinspection button
	And click on OK button on Result Dialog
	And click on Save&Close button
	Then go to "All Activities" and verify the email for "[Rectification Rejected]"
	Then go to "All Activities" and verify the email for "New Form SG Submission related"
	Then go to "All Activities" and verify the email for "[Rectification Required] Event Inspection of Fire Work Display and Setup Event"
	#Then Verify FIO receives alert notification for child case work order
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	# checklist need to update- First apply sorting, then complete it for "Pre-Event Inspection Checklist"
	And open "In Progress" WO fill the checklist for event inspection "CWD 5 Re-Inspection" for "Compliance" and verify WO status as "Completed"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Compliance"
	And logout from the application
	# SIT3 SO User
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the child case
	#And Validate that AO or SO get notified by Child Case
	And navigate to SO Review stage select SO Response as "Approve"
	And navigate to "SO Review" stage and navigate to next stage
	And click on save button
	And click on Refresh button
	Then verify case is "Completed" and in read only mode
	And logout from the application
	# SIT3 FO User
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "CWD Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And navigate to Close stage and set Resolve Case as "Yes"
	#And click on Yes button on Acknowledgment Confirmation popup
	Then verify case is "Completed" and in read only mode
	And logout from the application
