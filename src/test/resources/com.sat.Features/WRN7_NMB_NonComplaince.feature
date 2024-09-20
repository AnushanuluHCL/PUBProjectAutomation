@WRN7_NMB_Non-Complaince
Feature: Testing WRN7 NMB Noncompliance

  Background: Test CRM Login with valid credentials
    Given User navigates to CRM login page
    #When Login to app with "Admin_userid" and "Admin_pwd"
    #And user selects App "NMB Case Management"

  Scenario: Validate 6 Inspection cases are created and map is working for tunnel and shaft.
    #Then user change the changearea to "Inspection"
    #And user selects entity as "DTSS"
    #And create a DTSS with entity type "DTSS"
    #And go to "DTSS Shafts" tab and create a DTSS Shafts with type "Shaft"
    #Given User navigates to powerapps cloud flow page in "SIT1" environment
    #And Run the automatic cloudflow job for "SIES/WRN7/NMB/CreateCaseWOBooking"
    #Given User navigates to CRM login page
    #And navigate to "Inspection Cases" tab
    #Then verify 8 cases are created.
    #And logout from the application
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "DTSS"
    And search and open the DTSS
    And navigate to "Inspection Cases" tab
    And click on next icon page

    ##############Validate non-compliance flow for WRN7 NMB##############
    ## Closing Case 1
    #And open "DTSS Combing For Contractor - First Inspection" case
    #And go to "Work Orders" tab
    #And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    #And open "In Progress" WO and fill the "Non-Compliance" checklist for "Audit Inspection: Temp Toilet / Minor Works Check"

    ## Closing Case 2
    #And open "DTSS Combing For Contractor - Second Inspection" case
    #And go to "Work Orders" tab
    #And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    #And open "In Progress" WO and fill the "Non-Compliance" checklist for "Audit Inspection: Temp Toilet / Minor Works Check"

    ## Closing Case 3
    #And open "DTSS Combing For PUB - First Inspection" case
    And go to "Work Orders" tab
    And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    And open "In Progress" WO and fill the "Non-Compliance" checklist for DTSS Combing Photo "DTSS1 Combing Photo and Shaft Inspection Checklist"
    And go to "Inspection Case Information" tab
    Then verify System Assessment and User Assessment are marked as "Non-Compliance"
    Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
    Then go to "All Activities" and verify the email for "has observed the following unknown project sites"
    Then go to "Documents" and verify the Document for "Inspection_Report"
    And navigate to Inspection stage and fill the respective details and navigate to next stage
    When Login to app with "SO_userid" and "SO_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "Cases"
    And user selects "All Cases" list view, search and open the case
    And Validate that AO or SO get notified by Case
    And navigate to SO Review stage fill the respective details and navigate to next stage

    ## Closing Case 4
    And open "DTSS Combing For PUB - Second Inspection" case
    And go to "Work Orders" tab
    And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    And open "In Progress" WO and fill the "Non-Compliance" checklist for DTSS Combing Photo "DTSS1 Combing Photo and Shaft Inspection Checklist"
    And go to "Inspection Case Information" tab
    Then verify System Assessment and User Assessment are marked as "Non-Compliance"
    Then go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    Then go to "All Activities" and verify the email for "Work Order has been Submitted for Review"
    Then go to "All Activities" and verify the email for "has observed the following unknown project sites"
    Then go to "Documents" and verify the Document for "Inspection_Report"
    And navigate to Inspection stage and fill the respective details and navigate to next stage
    When Login to app with "SO_userid" and "SO_pwd"
    And user selects App "NMB Case Management"
    Then user change the changearea to "Inspection"
    And user selects entity as "Cases"
    And user selects "All Cases" list view, search and open the case
    And Validate that AO or SO get notified by Case
    And navigate to SO Review stage fill the respective details and navigate to next stage

    ## Closing Case 5
    And open "DTSS Combing First Virtual Inspection" case
    And go to "Work Orders" tab
    And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    And open "In Progress" WO and fill the "Non-Compliance" checklist for DTSS Combing virtual "DTSS1 Combing Photo and Shaft Inspection Checklist"

    ## Closing Case 6
    And open "DTSS Combing Second Virtual Inspection" case
    And go to "Work Orders" tab
    And open "In Progress" WO and select the "In Progress" booking record and complete all the booking process
    And open "In Progress" WO and fill the "Non-Compliance" checklist for DTSS Combing virtual "DTSS1 Combing Photo and Shaft Inspection Checklist"


