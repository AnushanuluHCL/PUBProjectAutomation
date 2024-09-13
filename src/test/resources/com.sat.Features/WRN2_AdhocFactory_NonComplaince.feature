@WRN2_AdhocFactoryNonCompliance
Feature: Testing WRN2- Adhoc factory inspection for non-compliance

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "FIO_userid" and "FIO_pwd"
	And user selects App "DQB Case Management"

  Scenario: Creating new ad hoc factories inspection for non-compliance
	When user change the changearea to "Factories"
	And user selects entity as "Factories"
	And create a new Ad hoc factory
	And verify factory is created with "New" status reason
	Then verify in service tab Case created with status "Scheduled" and verify Case notification
	Then verify in service tab Work Order created with status "Scheduled" and verify Work Order notification
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And go to Checklist tab create sample for lab analysis details with and fill the required checklist
	# Case Verification
	Then go to Cases and verify Abnormality In Chamber and Abnormality in Oil Interceptor fields
	Then go to "All Activities" and verify the email for "Request for Lab report result of samples"
	And go to "Lab Report Result" and upload WQ lab report in Prohibited Organic Heavy Metal Compounds section
	Then Verify the sum of heavy metal count and system assessment as Non-Compliance
  	# Click on Lab Report Uploaded
	And upload lab report
	Then verify System Assessment and User Assessment are marked as "Non-Compliance"
	Then go to "All Activities" and verify the email for Request for "Non-compliance Case" and "Inspection Case has been Submitted for Review"
	# Lab result value(s) are higher than expected range
	Then verify notification for lab result
 	And logout from the application
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "DQB Case Management"
	When user change the changearea to "Factories"
	And user selects entity as "Factories"
	# Approve Ad hoc factory
  	And open the above created factory and Approve
	Then verify the status reason is "WA Pending"
	Then verify notification for factory added to AO
	And logout from the application
	When Login to app with "SO_userid" and "SO_pwd"
	And user selects App "DQB Case Management"
	# Validate SO notification and move to next stage
	And search for the case to open it
	And Validate that AO or SO get notified by Case
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	When Login to app with "AO_userid" and "AO_pwd"
	And user selects App "DQB Case Management"
	# Validate SO notification and move to next stage
	And search for the case to open it
	And Validate that AO or SO get notified by Case
	And navigate to AO Review stage and fill the details and navigate to next stage
	Then verify case is "Completed" and in read only mode


















