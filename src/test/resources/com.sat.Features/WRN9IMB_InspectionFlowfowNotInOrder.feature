@WRN9IMB_NotInOrder
Feature: Testing WRN9IMB- Inspection Flow for Not-In-Order.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	#Sit1
	#When Login to app with "FIO_userid" and "FIO_pwd"
	#Sit3
	When Login to app with "SIT3_FIOUser" and "SIT3_FIOPwd"
	And user selects App "IMB Case Management"

  Scenario: Create Project for Pumping System Inspection flow for Not-In-Order Recurring WO
	Then user change the changearea to "Inspection"
	And user selects entity as "Pumping Systems"
	And create a manual Pumping System where Entity Type as "Pumping Systems"
	And navigate to "Pumping System Submissions" tab
	And create a new BPU Submission record where Submission Type as "Pumping System Inspection"
	Then check Submission Date should be auto populated as today's date
	And navigate to "Related" tab
	And click on Cases button
	Then verify whether Case is created with "Active" status and open a Case
	Then verify Case sub type is "Pumping System Inspection".
	Then go to "All Activities" and verify the email for "New Case is Created for"
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO and fill the required checklist for "Pumping Systems Inspection" and fill as "Not In Order"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Not In Order"
	Then verify Last Inspected On as today date
	And refresh the page
	And go to "Work Orders" tab
	And open "In Progress" WO and fill the Booking details and select "Completed" status
	And logout from the application
	#SIT1
	#When Login to app with "AO_userid" and "AO_pwd"
	#SIT3
	When Login to app with "SIT3_AOUser" and "SIT3_AOPwd"
	And user selects App "IMB Case Management"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
	And navigate to AO Review stage and set Recurrence Required as "Yes" and Frequency as "3" days and navigate to next stage
	And go to "Inspection Case Information" tab
	And refresh the page
	Then verify Next Booking Date as today date + 3 days
	And Validate that AO or SO get notified by Case
	And navigate to Close stage and set Resolve Case as "Yes"
	Then verify "Recurrence required still marked as yes. Please set to no before closing the case" this message

  Scenario: Create Project for Pumping System Inspection flow for Not-In-Order
	Then user change the changearea to "Inspection"
	And user selects entity as "Pumping Systems"
	And create a manual Pumping System where Entity Type as "Pumping Systems"
	And navigate to "Pumping System Submissions" tab
	And create a new BPU Submission record where Submission Type as "Pumping System Inspection"
	Then check Submission Date should be auto populated as today's date
	And navigate to "Related" tab
	And click on Cases button
	Then verify whether Case is created with "Active" status and open a Case
	Then verify Case sub type is "Pumping System Inspection".
	Then go to "All Activities" and verify the email for "New Case is Created for"
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO and fill the required checklist for "Pumping Systems Inspection" and fill as "Not In Order"
	And go to "Inspection Case Information" tab
	Then verify System Assessment and User Assessment are marked as "Not In Order"
	Then verify Last Inspected On as today date
	And refresh the page
	And go to "Work Orders" tab
	And open "In Progress" WO and fill the Booking details and select "Completed" status
	And logout from the application
	#SIT1
	#When Login to app with "AO_userid" and "AO_pwd"
	#SIT3
	When Login to app with "SIT3_AOUser" and "SIT3_AOPwd"
	And user selects App "IMB Case Management"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
	And navigate to AO Review stage and set Recurrence Required as "No" and Frequency as "3" days and navigate to next stage
	And Validate that AO or SO get notified by Case
	And navigate to Close stage and set Resolve Case as "Yes"
	Then verify case is "Completed" and in read only mode