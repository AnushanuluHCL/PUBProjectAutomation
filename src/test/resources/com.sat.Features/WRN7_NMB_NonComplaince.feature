@WRN7_NMB_Non-Complaince
Feature: Testing WRN7 NMB Noncompliance

  Background: Test CRM Login with valid credentials
    Given User navigates to CRM login page
    #SIT1
    When Login to app with "Admin_userid" and "Admin_pwd"
    #SIT3
    #When Login to app with "SIT3_AOUser" and "SIT3_AOPwd"
    And user selects App "NMB Case Management"

  Scenario: Validate 6 Inspection cases are created and map is working for tunnel and shaft.
    Then user change the changearea to "Inspection"
    And user selects entity as "DTSS"
    And create a DTSS with entity type "DTSS"
    And go to "DTSS Shafts" tab and create a DTSS Shafts with type "Shaft"
    Given User navigates to powerapps cloud flow page in "SIT1" environment
    And Run the automatic cloudflow job for "SIES/WRN7/NMB/CreateCaseWOBooking"
    Given User navigates to CRM login page
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "DTSS"
    And search and open the DTSS
    And navigate to "Inspection Cases" tab
    Then verify 6 cases are created.
    And logout from the application

    ##############Validate non-compliance flow for WRN7 NMB##############
    ## Closing Case 1
    When Login to app with "PAsit2_userid" and "PAsit2_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "DTSS"
    And search and open the DTSS
    And navigate to "Inspection Cases" tab
    And click on next icon page
    And open "DTSS Combing For Contractor - First Inspection" case
    And go to "Work Orders" tab
    And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    And open "In Progress" WO and fill the "Non-Compliance" checklist for DTSS Shaft Inspection "DTSS1 Shaft Inspection and Gas Reading Checklist for Contractor FIO"
    And go to "Inspection Case Information" tab
    Then verify System Assessment and User Assessment are marked as "Non-Compliance"
    Then go to "All Activities" and verify the email for "WO is assigned for the Inspection of pumping station"
    Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    #Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
    Then go to "All Activities" and verify the email for "has observed the following unknown project sites"
    Then go to "Documents" and verify the Document for "Inspection_Report"
    And navigate to Inspection stage and select the Inspection completed value as yes
    And navigate to Inspection stage and fill the respective details and navigate to next stage
    When Login to app with "PAsit2_userid" and "PAsit2_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "Cases"
    And user selects "All Cases" list view, search and open the case
    And Validate that AO or SO get notified by Case
    And navigate to SO Review stage select SO Response as "Approve" and navigate to next stage
    And navigate to Close stage and set Resolve Case as "Yes"
    Then verify case is "Completed" and in read only mode
    And logout from the application

    ## Closing Case 2
    When Login to app with "PAsit2_userid" and "PAsit2_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "DTSS"
    And search and open the DTSS
    And navigate to "Inspection Cases" tab
    And click on next icon page
    And open "DTSS Combing For Contractor - Second Inspection" case
    And go to "Work Orders" tab
    And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    And open "In Progress" WO and fill the "Non-Compliance" checklist for DTSS Shaft Inspection "DTSS1 Shaft Inspection and Gas Reading Checklist for Contractor FIO"
    And go to "Inspection Case Information" tab
    Then verify System Assessment and User Assessment are marked as "Non-Compliance"
    Then go to "All Activities" and verify the email for "WO is assigned for the Inspection of pumping station"
    Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    #Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
    Then go to "All Activities" and verify the email for "has observed the following unknown project sites"
    Then go to "Documents" and verify the Document for "Inspection_Report"
    And navigate to Inspection stage and select the Inspection completed value as yes
    And navigate to Inspection stage and fill the respective details and navigate to next stage
    When Login to app with "PAsit2_userid" and "PAsit2_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "Cases"
    And user selects "All Cases" list view, search and open the case
    And Validate that AO or SO get notified by Case
    And navigate to SO Review stage select SO Response as "Approve" and navigate to next stage
    And navigate to Close stage and set Resolve Case as "Yes"
    Then verify case is "Completed" and in read only mode
    And logout from the application

    ## Closing Case 3
    When Login to app with "PAsit2_userid" and "PAsit2_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "DTSS"
    And search and open the DTSS
    And navigate to "Inspection Cases" tab
    And open "DTSS Combing For PUB - First Inspection" case
    And go to "Work Orders" tab
    And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    And open "In Progress" WO and fill the "Non-Compliance" checklist for DTSS Combing Photo "DTSS1 Combing Photo and Shaft Inspection Checklist"
    And go to "Inspection Case Information" tab
    Then verify System Assessment and User Assessment are marked as "Non-Compliance"
    Then go to "All Activities" and verify the email for "WO is assigned for the Inspection of pumping station"
    Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    ###Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
    Then go to "All Activities" and verify the email for "has observed the following unknown project sites"
    Then go to "Documents" and verify the Document for "Inspection_Report"
    And navigate to Inspection stage and select the Inspection completed value as yes
    And navigate to Inspection stage and fill the respective details and navigate to next stage
    When Login to app with "PAsit2_userid" and "PAsit2_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "Cases"
    And user selects "All Cases" list view, search and open the case
    And Validate that AO or SO get notified by Case
    And navigate to SO Review stage select SO Response as "Approve" and navigate to next stage
    And navigate to Close stage and set Resolve Case as "Yes"
    Then verify case is "Completed" and in read only mode
    And logout from the application

    ## Closing Case 4
    When Login to app with "PAsit2_userid" and "PAsit2_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "DTSS"
    And search and open the DTSS
    And navigate to "Inspection Cases" tab
    And open "DTSS Combing For PUB - Second Inspection" case
    And go to "Work Orders" tab
    And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    And open "In Progress" WO and fill the "Non-Compliance" checklist for DTSS Combing Photo "DTSS1 Combing Photo and Shaft Inspection Checklist"
    And go to "Inspection Case Information" tab
    Then verify System Assessment and User Assessment are marked as "Non-Compliance"
    Then go to "All Activities" and verify the email for "WO is assigned for the Inspection of pumping station"
    Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    ###Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
    Then go to "All Activities" and verify the email for "has observed the following unknown project sites"
    Then go to "Documents" and verify the Document for "Inspection_Report"
    And navigate to Inspection stage and select the Inspection completed value as yes
    And navigate to Inspection stage and fill the respective details and navigate to next stage
    When Login to app with "PAsit2_userid" and "PAsit2_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "Cases"
    And user selects "All Cases" list view, search and open the case
    And Validate that AO or SO get notified by Case
    And navigate to SO Review stage select SO Response as "Approve" and navigate to next stage
    And navigate to Close stage and set Resolve Case as "Yes"
    Then verify case is "Completed" and in read only mode
    And logout from the application

    ## Closing Case 5
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "DTSS"
    And search and open the DTSS
    And navigate to "Inspection Cases" tab
    And open "DTSS Combing First Virtual Inspection" case
    And go to "Work Orders" tab
    And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    And open "In Progress" WO and fill the "Non-Compliance" checklist for DTSS Combing virtual "DTSS Combing virtual checklist for PUB Officer"
    Then go to "All Activities" and verify the email for "WO is assigned for the Inspection of pumping station"
    Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    ###Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
    Then go to "All Activities" and verify the email for "has observed the following unknown project sites"
    Then go to "Documents" and verify the Document for "Inspection_Report"
    And navigate to Inspection stage and select the Inspection completed value as yes
    And navigate to Inspection stage and fill the respective details and navigate to next stage
    When Login to app with "PAsit2_userid" and "PAsit2_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "Cases"
    And user selects "All Cases" list view, search and open the case
    And Validate that AO or SO get notified by Case
    And navigate to SO Review stage select SO Response as "Approve" and navigate to next stage
    And navigate to Close stage and set Resolve Case as "Yes"
    Then verify case is "Completed" and in read only mode
    And logout from the application

    ## Closing Case 6
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "DTSS"
    And search and open the DTSS
    And navigate to "Inspection Cases" tab
    And open "DTSS Combing Second Virtual Inspection" case
    And go to "Work Orders" tab
    And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    And open "In Progress" WO and fill the "Non-Compliance" checklist for DTSS Combing virtual "DTSS Combing virtual checklist for PUB Officer"
    Then go to "All Activities" and verify the email for "WO is assigned for the Inspection of pumping station"
    Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    ###Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
    Then go to "All Activities" and verify the email for "has observed the following unknown project sites"
    Then go to "Documents" and verify the Document for "Inspection_Report"
    And navigate to Inspection stage and select the Inspection completed value as yes
    And navigate to Inspection stage and fill the respective details and navigate to next stage
    When Login to app with "PAsit2_userid" and "PAsit2_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "Cases"
    And user selects "All Cases" list view, search and open the case
    And Validate that AO or SO get notified by Case
    And navigate to SO Review stage select SO Response as "Approve" and navigate to next stage
    And navigate to Close stage and set Resolve Case as "Yes"
    Then verify case is "Completed" and in read only mode
    And logout from the application


