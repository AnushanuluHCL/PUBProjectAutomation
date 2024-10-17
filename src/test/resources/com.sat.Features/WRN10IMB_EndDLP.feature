@WRN11NMB_AuditInspectionForNonCompliance
Feature: Testing WRN10IMB- EndDLP

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "IMB Case Management"

  Scenario: Create Project for Audit Inspection flow for non-compliance when Account Sub Type as Minor Works Inspection
	Then user change the changearea to "Inspection"
	And user selects entity as "Pumping Mains"
	And create a manual Pumping Mains where Entity Type as "Pumping Main"
	And open "Inspection Cases" tab in "Entity"
	And create a manual case of Case sub type as "End-DLP Pumping Mains Inspection"
	And logout from the application
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "IMB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "All Cases" list view, search and open the case
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO and fill the required checklist for "Pumping Systems Inspection" and fill as "Not In Order"