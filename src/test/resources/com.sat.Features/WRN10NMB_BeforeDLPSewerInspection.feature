@WRN1ONMB_BeforeDLPSewerInspection
Feature: Testing WRN10IMB- BeforeDLPSewerInspection

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	# SIT1 SO User
	When Login to app with "sit3_SO_userid" and "sit3_SO_pwdd"
	And user selects App "NMB Case Management"

  Scenario: Create adhoc case against Public Sewer for In-Order when Account Sub Type as Before DLP Sewer Inspection
	When user change the changearea to "Inspection"
	When user selects entity as "Public Sewer"
	And create a manual Public Sewer where Entity Type as "Public Sewer"
	And click on Refresh button
	And logout from the application
	# SIT1 FIO User
	When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
	And user selects App "NMB Case Management"
	When user change the changearea to "Inspection"
	When user selects entity as "Public Sewer"
	When search and open the Public Sewer
	And navigate to "Inspection Cases" tab
	And create a manual case of Case sub type as "Before-DLP Sewer Inspection"
	#And click on Save and continue button on unsaved changes popup
	And click on Save&Close button
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	And create manual Work Order of Work Order Type "First Inspection"
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And go to "Inspection Case Information" tab
	Then verify Case notification in "Inspection Case Information" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for before DLP "WRN10NMB-Before DLP Checklist" for "In Order" and verify WO status as "Completed"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "In Order"
	Then go to "All Activities" and verify the email for "WO is assigned to Inspection"
	Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
	Then go to "Documents" and verify the Document for "Inspection_Report"
	# Click Generate IO/NIO Letter
	And click on Generate IO and NIO Letter button
	And click on Okay button on Generate IO and NIO Letter pop up
	Then go to "All Activities" and verify the email for "Before DLP Inspection is In Order"
	Then go to "Documents" and verify the Document for "Sewer Inspection In Order letter.docx"
	# Enter Commissioning Letter issued date
	And go to "Inspection Case Information" tab
	And enter Commissioning Letter issued date
	And click on OK button
	And click on save button
	And refresh the page
	Then go to "Documents" and verify the Document for "NMB Maintenance Control Letter.docx"
	And navigate to Inspection stage select the Inspection completed and submit SO review as yes
	And logout from the application
	# SIT1 SO User
	When Login to app with "sit3_SO_userid" and "sit3_SO_pwdd"
	And user selects App "NMB Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	Then go to "Documents" and verify the Document for "Sewer Inspection In Order letter.pdf"
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And navigate to SO Review stage select SO Response as "Approve" and navigate to next stage
	Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
	And logout from the application
	# SIT1 AO User
	When Login to app with "sit3_SO_userid" and "sit3_SO_pwdd"
	And user selects App "NMB Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	Then verify Work Order notification in "Work Orders" tab
	And navigate to AO Review stage and fill the details and navigate to next stage
	Then go to "Documents" and verify the Document for "NMB Maintenance Control Letter.pdf"
	Then go to "All Activities" and verify the email for "Maintenance & Control Letter"
	And logout from the application
	# SIT1 FIO User
	When Login to app with "sit3_SO_userid" and "sit3_SO_pwdd"
	And user selects App "NMB Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And navigate to GenerateEmail stage and fill the respective details for M&C Letter and navigate to next stage
	And click on Refresh button
	Then verify case is "Closed" and in read only mode
	And logout from the application








