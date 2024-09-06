@WRN8_NMB_Non-Complaince
Feature: Testing WRN8 NMB - Noncomplaince - Reinspection

  Background: Test CRM Login with valid credentials
    Given User navigates to CRM login page
    When Login to app with "AO_userid" and "AO_pwd"
    And user selects App "NMB Case Management"

  Scenario Outline: Inspecting Sewer/DTSS by reinspecting agian when any noncomplaince happend
    When user selects entity as "Construction Sites"
    And change the view to "List of Construction Sites"
    # Include code for creating update data in excel and remove the date update every time after new run
    And Update excel with Project title as "8NMBProject"
    And Import the data
    And verify data is updated in the system and open it
    Then go to "All Activities" in project and verify the email for "8NMBProject" 
    
    #And go to "All Activities" and verify the email for Request for"Request for Mukim/Lot no."
    # These Mukim/Lot no. usually coming from FormSG link from Request for Mukim/Lot no. email. Now updating manually in project
    Then go to "Summary" tab and update the Mukim number as "333" and Lot number "135"
    And go to "POWS Submissions" tab and update the "<Project_Mukim_Lot_No.>","<Diameter>","<Affected by DTSS>" and "<Affected by Sewer>" GERI response values
    And change the view to "List of BCA Projects shortlisted for Inspection" and verify created project available in this view
    And logout from the application
    When Login to app with "SO_userid" and "SO_pwd"
    And user selects App "NMB Case Management"
    And user selects entity as "Construction Sites"
    And change the view to "List of BCA Projects shortlisted for Inspection"
    #And search for the project to open it
    #And approve the project
    #Then verify whether case is created once project is approved
    #And open the case from project
    #And Verify that created case starts with "DQB/TF/I" with status "Scheduled"
    #And go to "Work Orders" tab
    #And verify the WO status "Scheduled"
    #And validate the schedule workorder notification
    #And go to "All Activities" and verify the email for "Inspection Schedule"
    #And navigate to Assignment stage and fill the respective details and navigate to next stage
    #And go to "Work Orders" tab
    #And open WO and fill the Booking details
    #And go to Service tasks tab and fill and complete the checklist as "Non-Complaince"
    #And verify Booking status is "Completed" and WO status field is "Completed"
    #Then verify System Assessment and User Assessment are marked as "Non-Compliance" in case form
    #And verify that "Inspection Report" is generated
    #And verify SO/AO get notified by alert for approval
    #And Verify that SO get notified by no POWS approval notification
    #And navigate to SO Review stage and fill the respective details and navigate to next stage
    #When Login to app with "AO_userid" and "AO_pwd"
    #And user selects App "NMB Case Management"
    #And search for the case to open it
    #And verify SO/AO get notified by alert for approval
    #And Verify that SO get notified by no POWS approval notification
    #And navigate to AO Review stage and fill the respective details and navigate to next stage
    #Then go to "All Activities" and verify the email for Request for "Inspection Case has been Submitted for Review" and "Project Reference Number" and "Please Obtain POWS Approval from PUB"
    #When user click on entity link on case form
    #And chnage the Reinspection date value to ""
    #And Run the automatic cloudflow job for "SIES/WRN8 NMB/Creating WO for Reinspection BCA projects"
    #
    # Reinspection work order
    #When Login to app with "FIO_userid" and "FIO_pwd"
    #And user selects App "NMB Case Management"
    #And search for the case to open it
    #And go to "Work Orders" tab
    #And verify new work order is created with type as "Re-Inspection" after job run and open it
    #Then Click and open the work order
    #And open WO and fill the Booking details
    #And go to Service tasks tab and fill and complete the checklist as "Non-Complaince"
    #And verify Booking status is "Completed" and WO status field is "Completed"
    #Then verify System Assessment and User Assessment are marked as "Compliance" in case form
    #When Login to app with "SO_userid" and "SO_pwd"
    #And user selects App "NMB Case Management"
    #And search for the case to open it
    #And verify SO/AO get notified by alert for approva
    #And navigate to SO Review stage and fill the respective details and navigate to next stage
    #And navigate to Close stage and fill the respective details and navigate to next stage

    Examples: 
      |Project_Mukim_Lot_No.| Diameter | Affected by DTSS | Affected by Sewer |
      |4536456|     1000 | Yes              | Yes               |
