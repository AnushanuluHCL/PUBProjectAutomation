@WRN8_NMB_Non-Complaince
Feature: Testing WRN6 IMB - Noncomplaince - Rework

  Background: Test CRM Login with valid credentials
    Given User navigates to CRM login page
    When Login to app with "AO_userid" and "AO_pwd"
    And user selects App "IMB Case Management"

  Scenario Outline: Inspecting Pumping main constrcution sites Noncomplaince - Rework
    When user selects entity as "Construction Sites"
    And create a manual project where Entity Type as "Construction sites" and Account Sub Type as "Pumping Main Construction Site"
    Then go to "Summary" tab and enable the "Affected by Pumping Mains?" field
    And logout from the application
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "IMB Case Management"
    And user selects entity as "Construction Sites"
    
    
    And go to "POWS Submissions" tab and create a new POWS submission request by giving "<Diameter>", "<DC_Status>"
    Then verify whether case is created after POWS submisison request is approved
    And change the view "All Cases" and search a case
    And Verify that created case starts with "IMB/RP/I" with status "Scheduled"
    And go to "Work Orders" tab
    And validate the schedule workorder notification
    And go to "All Activities" and verify the email for "System assigns WOs to FIO"
    And go to "Work Orders" tab
    # need to add changing booking status to inprogress code in the method
    And open "Scheduled" WO and select the "Scheduled" booking record and complete all the booking process
    # update the checklist according to 6IMB
      And go to Service tasks tab and complete the checklist as "Non-Complaince" by selecting "All Work Complete?" selcted is as "No"
      And go to "All Activities" and verify the email for "NO POWS / POWS Deviation Email for Enforcement Action"
      And verify FIO get notified by non-complaince notification
    Then verify recurring work order is getting created
    And verify System Assessment and User Assessment are marked as "Non-Compliance" in case form
    And verify that "Inspection Report" is generated
    And logout from the application
    When Login to app with "SO_userid" and "SO_pwd"
    And user selects App "IMB Case Management"
    And search for the case to open it
    Then open "Completed" WO and able to provide the rework comments
    Then verify new booking is created with "Scheduled" status and WO status also changed to "Scheduled"
    And logout from the application
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "IMB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab   
    And open "Scheduled" WO and select the "Scheduled" booking record and complete all the booking process
    And open "First Inspection" WO and open the checklist and perform the amendments as "Non-Complaince" by selecting "All Work Complete?" selcted is as "Yes"
    And go to Service tasks tab and complete the checklist as "Non-Complaince" by selecting "All Work Complete?" selcted is as "Yes"
    # need to add changing booking status to inprogress code in the method
    #And open "Scheduled" WO and select the "Scheduled" booking record and complete all the booking process
    #  And go to Service tasks tab and complete the checklist by selecting "All Work Complete?" selcted is as "Yes"
    And verify Booking status is "Completed" and WO status field is "Completed"
    And logout from the application
    When Login to app with "SO_userid" and "SO_pwd"
    And user selects App "IMB Case Management"
    And search for the case to open it
    And verify SO/AO get notified by alert for approval
    And go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
   And navigate to SO Review stage and fill the respective details and navigate to next stage
    And logout from the application
    When Login to app with "AO_userid" and "AO_pwd"
    And user selects App "IMB Case Management"
    And search for the case to open it
    Then open "Completed" WO and able to provide the rework comments
    Then verify new booking is created with "Scheduled" status and WO status also changed to "Scheduled"
    And logout from the application
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "IMB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    And open "Scheduled" WO and select the "Scheduled" booking record and complete all the booking process
    And open "First Inspection" WO and open the checklist and perform the amendments as "Complaince" by selecting "All Work Complete?" selcted is as "Yes"
    And go to Service tasks tab and complete the checklist as "Complaince" by selecting "All Work Complete?" selcted is as "Yes"
    And verify Booking status is "Completed" and WO status field is "Completed"
    And logout from the application
    When Login to app with "SO_userid" and "SO_pwd"
    And user selects App "IMB Case Management"
    And search for the case to open it
    And verify SO/AO get notified by alert for approval
    And go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    And navigate to SO Review stage and fill the respective details and navigate to next stage
    And logout from the application
    When Login to app with "AO_userid" and "AO_pwd"
    And user selects App "IMB Case Management"
    And search for the case to open it
    And verify SO/AO get notified by alert for approval
    And go to "All Activities" and verify the email for "Inspection Case has been Submitted for Review"
    And AO is able to update deviation remarks
    And navigate to AO Review stage and fill the respective details and navigate to next stage
    And navigate to Close stage and set Resolve Case as "Yes"
    Then verify case is "Completed" and in read only mode
    # Take a project having case which is already closed
    #	When user selects entity as "Construction Sites"
    #	And Open the project and create a new POWS submission request
    #	And verify a new case is created
    Examples: 
      | Diameter | DC_Status |
      |      600 | Approved  |
