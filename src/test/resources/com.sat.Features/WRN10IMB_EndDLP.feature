@WRN10IMB_EndDLP
Feature: Testing WRN10IMB- EndDLP

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	# SIT1
	#When Login to app with "FIO_userid" and "FIO_pwd"
	# SIT3
	When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
	And user selects App "IMB Case Management"

  Scenario: Create Project for Audit Inspection flow for non-compliance when Account Sub Type as Minor Works Inspection
	When user change the changearea to "Inspection"
	And user selects entity as "Pumping Mains"
	And create a manual Pumping Mains where Entity Type as "Pumping Main"
	And open "Inspection Cases" tab in "Entity"
	And create a manual case of Case sub type as "Before-DLP Pumping Mains Inspection"
	And go to "Work Orders" tab
	Then verify Work Order created on Case record
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for "WRN 10 IMB Pumping Main Handing Over Inspection Checklist - Pressure Test" for "In Order" and verify WO status as "Completed"
	Then get and verify the count of Work Orders for Pressure Test and Commissioning Test should be 3
	Then verify count of work order should be 3
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for "WRN 10 IMB Pumping Main Handing Over Inspection Checklist - Pre DLP" for "In Order" and verify WO status as "Completed"
	And logout from the application
	# SIT1
	#When Login to app with "SO_userid" and "SO_pwd"
	# SIT3
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "IMB Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	And navigate to SO Review stage select SO Response as "Approve"
	And logout from the application
	# SIT1
	#When Login to app with "FIO_userid" and "FIO_pwd"
	# SIT3
	When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
	And user selects App "IMB Case Management"
	And user selects entity as "Pumping Mains"
	When search and open the Pumping Main
	And open "Inspection Cases" tab in "Entity"
	And create a manual case of Case sub type as "Pumping Main Abandonment"
	And go to "Work Orders" tab
	Then verify Work Order created on Case record
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for Abandonment "WRN10 IMB Pumping Main Abandonment Checklist" for "In Order" and verify WO status as "Completed"
	And logout from the application
	# SIT1
	#When Login to app with "SO_userid" and "SO_pwd"
	# SIT3
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "IMB Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	And navigate to SO Review stage and click on Next Stage button
	And navigate to Close stage and set Resolve Case as "Yes"
	And user selects entity as "Pumping Mains"
	When search and open the Pumping Main
	And open "Inspection Cases" tab in "Entity"
	And select "SO Review" Case and open the case
	And navigate to SO Review stage and click on Next Stage button
	And navigate to Close stage and set Resolve Case as "Yes"
	And logout from the application
	When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
	And user selects App "IMB Case Management"
	And user selects entity as "Pumping Mains"
	When search and open the Pumping Main
	And open "Inspection Cases" tab in "Entity"
	And create a manual case of Case sub type as "End-DLP Pumping Mains Inspection"
	And go to "Work Orders" tab
	Then verify Work Order created on Case record
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO fill the checklist for "WRN 10 IMB Pumping Main Handing Over Inspection Checklist - Post DLP" for "Not In Order" and verify WO status as "Completed"
	And logout from the application
	# SIT1
	#When Login to app with "SO_userid" and "SO_pwd"
	# SIT3
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "IMB Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And Validate that AO or SO get notified by Case
	And navigate to SO Review stage select SO Response as "Approve" and navigate to next stage
	And navigate to Close stage and set Resolve Case as "Yes"
