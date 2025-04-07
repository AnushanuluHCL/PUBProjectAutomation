@CWD1CRMSReject
Feature: Testing CWD1- CRMS Case Reject.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "CWD Case Management"

  Scenario: CRMS Case Reject
	When user change the changearea to "Inspection"
	And user selects entity as "CRMS Cases"
	And create a CRMS Case using excel
	And import CRMS Case
	Then verify CRMS Case is created in the system and open it
	And logout from the application
	# SIT3 SO User
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "CWD Case Management"
	When user change the changearea to "Inspection"
	And user selects entity as "CRMS Cases"
	And user selects "Pending CRMS Cases" list view, search and open the CRMS case
	And "Reject" the CRMS Case
	And save the Case
	And refresh the page
	Then verify SIES case status as "Rejected"
	And logout from the application
