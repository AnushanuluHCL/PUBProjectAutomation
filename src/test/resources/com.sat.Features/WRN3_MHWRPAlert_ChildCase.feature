@WRN3_MHWRPAlert
Feature: Testing WRN3- Manhole inspection for WRP Alert.Child Case creation and linking with parent Case.

  Background: Test CRM Login with valid credentials
	Given User navigates to CRM login page
	When Login to app with "Admin_userid" and "Admin_pwd"
	And user selects App "DQB Case Management"

  Scenario: Manual Case Creation for WRP Alert
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And create a manual case for WRP catchment as "Ulu Pandan" and alert source as "WRP – VOC"
	Then verify catchment as "Ulu Pandan" and entity as "WRP – VOC", factory list and Manhole list is auto-populated
	And go to "Work Orders" tab
	Then verify work orders are created
	And logout from the application
	#SIT1
	#When Login to app with "FIO_userid" and "FIO_pwd"
	#SIT3
	When Login to app with "sit3_SO_userid" and "sit3_SO_pwdd"
	And user selects App "DQB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And go to "Child Cases" tab
	Then verify whether case is created with reference number "DQB/TE/I" and open child Case
	# Verify Scenario 1
	Then verify the new child cases are created for "High" Risk Factories under "Ulu Pandan" catchment.
	And go to "Work Orders" tab
	Then verify whether child case work order are created
	Then Verify FIO receives alert notification for child case
	Then Verify FIO receives alert notification for child case work order
	And navigate back to parent case
	And go to "Child Cases" tab
	And go to "Work Orders" tab
	And get the count of Work Orders
	# Check the count of WO with filter scheduled till empty
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO and make one work order as Non-Compliance and others as a Compliance for "Manhole Inspection" and "L1"
	And apply "Scheduled" filter in work order
	And get the count of Work Orders
	Then verify count of work order should be 0
	And wait for 120000 milliseconds so all the work order are processed and then click on refresh button
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And open "In Progress" WO and make one work order as a Compliance for "Manhole Inspection" and "L2"
	And apply "In Progress" filter in work order
	And get the count of Work Orders
	Then verify count of work order should be 0
	And go to "Child Cases" tab
	Then verify whether case is created with reference number "DQB/TE/I" and open child Case
	And go to "Work Orders" tab
	And open "Scheduled" WO and fill the Booking details and select "In Progress" status
	And go to Checklist tab create sample for lab analysis details with and fill the required checklist
	# Case Verification
	And go to "Inspection Case Information" tab
	Then verify Abnormality In Chamber and Abnormality in Oil Interceptor fields
	Then go to "All Activities" and verify the email for "Request for Lab report result of samples"
	Then go to "All Activities" and verify the email for "Accept the WO"
	And go to "Lab Report Result" and upload WQ lab report in Prohibited Organic Heavy Metal Compounds section
	Then Verify the sum of heavy metal count and system assessment as Non-Compliance
  	# Click on Lab Report Uploaded
	And upload lab report
	Then verify System Assessment and User Assessment are marked as "Non-Compliance"
	Then go to "All Activities" and verify the email for Request for "Non-compliance Case" and "Inspection Case has been Submitted for Review"
	And logout from the application
	#SIT1
	#When Login to app with "SO_userid" and "SO_pwd"
	#SIT3
	When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
	And user selects App "DQB Case Management"
	# Validate SO notification and move to next stage
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the child case
	And Validate that AO or SO get notified by Child Case
	# Lab result value(s) are higher than expected range
	Then verify notification for lab result
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	#SIT1
	#When Login to app with "AO_userid" and "AO_pwd"
	#SIT3
	When Login to app with "sit3_AO_userid3" and "sit3_AO_pwd3"
	And user selects App "DQB Case Management"
	# Validate AO notification and move to next stage
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the child case
	And Validate that AO or SO get notified by Child Case
	And navigate to AO Review stage and fill the details and navigate to next stage
	Then verify case is "Completed" and in read only mode
	And logout from the application

	#parent case closer we cannot automate

	# Verify Scenario 2
  Scenario: When inspection case for a factory is open under WRN2 but factory is not inspected yet.
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And create a manual case for WRP catchment as "Kranji Ph3" and alert source as "WRP – VOC"
	Then verify catchment as "Kranji Ph3" and entity as "WRP – VOC", factory list and Manhole list is auto-populated
	Then new child case gets created under the "WRN3" parent case.
	# Comment below 2 lines while running in SIT3
	And go to "Work Orders" tab
	Then verify work orders are created
	And logout from the application
	#SIT1
	#When Login to app with "FIO_userid" and "FIO_pwd"
	#SIT3
	When Login to app with "sit3_SO_userid" and "sit3_SO_pwdd"
	And user selects App "DQB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And go to "Child Cases" tab
	Then verify whether case is created with reference number "DQB/TE/I" and open child Case
	Then verify the new child cases are created for "High" Risk Factories under "Kranji" catchment.
	Then verify Parent Case ID is not blank
	Then new child case gets created under the "WRN3" parent case.

	# Verify Scenario 3
  Scenario: When inspection case for a factory is open under WRN2 but factory has been inspected.
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And create a manual case for WRP catchment as "Kranji Ph3" and alert source as "WRP – VOC"
	Then verify catchment as "Kranji Ph3" and entity as "WRP – VOC", factory list and Manhole list is auto-populated
	# Comment below 2 lines while running in SIT3
	And go to "Work Orders" tab
	Then verify work orders are created
	And logout from the application
	#SIT1
	#When Login to app with "FIO_userid" and "FIO_pwd"
	#SIT3
	When Login to app with "sit3_SO_userid" and "sit3_SO_pwdd"
	And user selects App "DQB Case Management"
	Then user change the changearea to "Inspection"
	And user selects entity as "Cases"
	And user selects "Active Cases" list view, search and open the case
	And go to "Child Cases" tab
	Then verify whether case is created with reference number "DQB/TE/I" and open child Case
	Then verify the new child cases are created for "High" Risk Factories under "Kranji" catchment.
	Then verify Case sub type is "Trade Effluent Inspection".
	And go to "Work Orders" tab
	Then verify booking duration is "2 hours" and start time is current time and end time is two hrs later