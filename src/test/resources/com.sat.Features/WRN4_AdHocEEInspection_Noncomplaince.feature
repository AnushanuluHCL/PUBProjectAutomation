@WRN4_Noncomplaince
Feature: Testing WRN4-Noncomplaince functionality

  Background: Test CRM Login with valid credentials
    Given User navigates to CRM login page
    When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
    And user selects App "DQB Case Management"

  Scenario Outline: Testing WRN4-Noncomplaince functionlaity
    When user change the changearea to "Eating Establishment"
    And user selects entity as "Eating Establishment"
    And create a manual project where Entity Type as "Eating Establishment" with "<Number_of_Gts>"
    Then user change the changearea to "Inspection"
    And user selects entity as "Cases"
    And user selects "Active Cases" list view, search and open the case
    And go to "Work Orders" tab
    And wait for 120000 milliseconds so all the work order are processed and then click on refresh button
    And go to "Work Orders" tab
    Then Verify the number of work orders are matching with the number of Gts
    #Then verify Work Order notification in "Work Orders" tab
    And open "Scheduled" WO and fill the Booking details and select "In Progress" status
    
    ## GT Sampling -  Noncomplaince(Pending Lab)
    And go to Service tasks tab and complete the checklist as "Non-Complaince" for "GT Sampling"
    And Create a new lab report by filling "<Report_Type>","<Substance_ChemicalName>","<Result_Concentration>" details
    And verify the lab report result as "Non-Compliance"
    Then logout from the application
    When Login to app with "sit3_SO_userid" and "sit3_SO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And verify that "Warning Letter" is generated
    
    
    ## GT Not Installed -  Noncomplaince
    And go to "Work Orders" tab
    And go to Service tasks tab and complete the checklist as "Non-Complaince" for "GT Not Installed"
    Then logout from the application
    When Login to app with "sit3_SO_userid" and "sit3_SO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And verify that "Legal Notice" is generated
    
    
    
    ## GT Not Maintained(Advisory Letter)- Combination1 -  Noncomplaince
    And go to "Work Orders" tab
    And go to Service tasks tab and complete the checklist as "Non-Complaince" for "GT Not Maintained Advisory Letter_Combination1"
    Then logout from the application
    When Login to app with "sit3_SO_userid" and "sit3_SO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And verify that "Advisory Letter" is generated
    
    
    ## GT Not Maintained(Advisory Letter)- Combination2 -  Noncomplaince(Pending Lab)
    And go to "Work Orders" tab
    And go to Service tasks tab and complete the checklist as "Non-Complaince" for "GT Not Maintained Advisory Letter_Combination2"
    Then logout from the application
    When Login to app with "sit3_SO_userid" and "sit3_SO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And verify that "Advisory Letter" is generated
    
    
    ## GT Not Maintained(Advisory Letter)- Combination3 -  Noncomplaince(Pending Lab)
    And go to "Work Orders" tab
    And go to Service tasks tab and complete the checklist as "Non-Complaince" for "GT Not Maintained Advisory Letter_Combination3"
    Then logout from the application
    When Login to app with "sit3_SO_userid" and "sit3_SO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And verify that "Advisory Letter" is generated
    
    
    ## GT Not Maintained(Legal Notice) -  Noncomplaince
    And go to "Work Orders" tab
    And go to Service tasks tab and complete the checklist as "Non-Complaince" for "GT Not Maintained Legal Notice"
    Then logout from the application
    When Login to app with "sit3_SO_userid" and "sit3_SO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And verify that "Legal Notice" is generated
    
    
    ## GT Damaged(Advisory Letter)- Combination1 - Noncomplaince
    And go to "Work Orders" tab
    And go to Service tasks tab and complete the checklist as "Non-Complaince" for "GT Damaged_Combination1"
    Then logout from the application
    When Login to app with "sit3_SO_userid" and "sit3_SO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And verify that "Advisory Letter" is generated
    
    
    ## GT Damaged(Advisory Letter)- Combination2 - Noncomplaince
    And go to "Work Orders" tab
    And go to Service tasks tab and complete the checklist as "Non-Complaince" for "GT Damaged_Combination2"
    Then logout from the application
    When Login to app with "sit3_SO_userid" and "sit3_SO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And verify that "Advisory Letter" is generated
    
    
    ## GT Damaged(Advisory Letter)- Combination3 - Noncomplaince
    And go to "Work Orders" tab
    And go to Service tasks tab and complete the checklist as "Non-Complaince" for "GT Damaged_Combination3"
    Then logout from the application
    When Login to app with "sit3_SO_userid" and "sit3_SO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And go to "Work Orders" tab
    Then open "Completed" WO and accept the WO
    Then logout from the application
    When Login to app with "sit3_FIO_userid" and "sit3_FIO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And verify that "Advisory Letter" is generated
    
    
    And navigate to Inspection stage and fill the respective details and navigate to next stage
    When Login to app with "sit3_SO_userid" and "sit3_SO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And navigate to SO Review stage and fill the respective details and navigate to next stage
    When Login to app with "sit3_AO_userid" and "sit3_AO_pwd"
    And user selects App "DQB Case Management"
    And search for the case to open it
    And navigate to AO Review stage and fill the respective details and navigate to next stage
    And navigate to Close stage and fill the respective details and navigate to next stage
    Then verify case is "Completed" and in read only mode

    Examples: 
      | Number_of_Gts | Report_Type | Substance_ChemicalName         | Result_Concentration |
      |             9 | GT          | Oil & Grease (Non-Hydrocarbon) |                  300 |
