package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import com.sat.Pages.ApplicationPage;
import com.sat.Pages.caseCreationPage;
import com.sat.Pages.loginPage;
import com.sat.Pages.commonActionsPage;
import com.sat.locators.factoryPage;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class GWComplaintStepdefs{

    // public static String tankercompanyname;

    private Properties prop;
    private TestBase testbase = new TestBase();

    
    private ApplicationPage apppage = new ApplicationPage(TestBase.getDriver());
    private commonActionsPage common = new commonActionsPage(TestBase.getDriver());
    private caseCreationPage casepage = new caseCreationPage(TestBase.getDriver());
    private loginPage loginpage = new loginPage(TestBase.getDriver());

    @And("fill the details in application form for greasy waste type details {string},{string}")
    public void fill_the_details_in_application_form_for_greasy_waste_type_details(String GWSelected, String GWPerMomnth) {
        apppage.amountOfGWWastetypeTanker(GWSelected, GWPerMomnth);
    }

    @And("approve the application")
    public void approve_the_application() throws InterruptedException {
        apppage.approveApp();
    }

    @Then("verify whether case is created")
    public void verify_whether_case_is_created() throws InterruptedException {
        casepage.caseCreationCheck();
    }

    @When("Case is opened verify the fields")
    public void Case_is_opened_verify_the_fields() throws InterruptedException, AWTException, ParseException {
        // casepage.openACase();
        // casepage.searchACase();
        // casepage.permitnumCheck();
        // casepage.uploadDocInCase();

        casepage.caseFormValidation();

    }

    @And("search and open the case")
    public void search_and_open_the_case() throws InterruptedException {
        // casepage.openACase();//later point this is not required
        casepage.searchACase();
        casepage.caseFIOSOAONames();
    }

    @And("go to {string} tab")
    public void go_to_tab(String tabnanme) {
        common.navigatingToTab(tabnanme);
    }

    @And("validate the schedule workorder notification")
    public void validate_the_schedule_workorder_notification() throws InterruptedException {
        casepage.validateWOScheduleNotification();
    }

    @And("fill the details in Bookings section")
    public void fill_the_details_in_Bookings_section() throws InterruptedException, ParseException {
        // casepage.workOrderValidation();
        casepage.fillBookingDetails();
    }

    @And("navigate to Assignment stage and confirm the inspection schedule")
    public void navigate_to_Assignment_stage_and_confirm_the_inspection_schedule() {
        casepage.confirmInspectionSchedule();
    }

    @And("go to Service tasks tab and fill and complete the checklist as {string}")
    public void go_to_Service_tasks_tab_and_fill_and_complet_the_checklist_as(String outcome) throws InterruptedException {
        casepage.fillTheChecklistquestions(outcome);
    }

    @And("verify the WO status field is {string} and verify tanker Iscomplaint? field value as {string} in work order form")
    public void verify_the_wo_status_field_is_and_verify_tanker_iscomplaint_field_value_as_in_work_order_form(String status, String iscomplaint) {
        casepage.complaincecheckInWorkorder(status, iscomplaint);
    }

    @And("verify whether case outcome is complaince by checking Is complaint? field value as {string} in case form")
    public void verify_whether_case_outcome_is_complaince_by_checking_is_complaint_field_value_as_in_case_form(String string) {

    }

    @And("navigate to Assignment stage and fill the respective details and navigate to next stage")
    public void navigate_to_Assignment_stage_and_fill_the_respective_details_and_navigate_to_next_stage() throws InterruptedException {
        // casepage.completeIdentifyStage();
        casepage.completeAssignmnetStage();
    }

    @And("navigate to Inspection stage and select the Inspection completed value as yes")
    public void navigate_to_Inspection_stage_and_select_the_Inspection_completed_value_as_yes() {
        casepage.completeInspection();
    }

    @And("verify permit is generated for the tanker")
    public void verify_permit_is_generated_for_the_tanker() throws ParseException {
        casepage.permitnumCheck();
    }

    @And("verify {string} letter is generated")
    public void verify_letter_is_generated(String lettername) {
        casepage.verifyPermitAgreeementLetters(lettername);
    }

    @And("Validate {string} mail with subject")
    public void Validate_mail_with_subject(String mailType) throws InterruptedException, ParseException {
        // casepage.mailValidation(mailType);
        // casepage.WOStatusChange(); //this can be added when status is not changed to
        // 'scheduled'
        casepage.mailGeneratedOrNot(mailType);
        // casepage.mailValidationNew(mailType);
    }

    @And("navigate to Inspection stage and fill the respective details and navigate to next stage")
    public void navigate_to_Inspection_stage_and_fill_the_respective_details_and_navigate_to_next_stage() throws InterruptedException {
        casepage.completeInspectionStage();
        loginpage.signoutApp();
    }

    @And("verify that {string} mail is generated once Iscomplaint? field value updated to No")
    public void verify_that_mail_is_generated_once_Iscomplaint_field_value_updated_to_No(String mailType) throws InterruptedException, ParseException {
        casepage.mailGeneratedOrNot(mailType);
    }

    @And("verify that {string} is generated")
    public void verify_that_is_generated(String report) {
        casepage.inspectionReportCheck(report);
    }

    @And("create a new manual WO to create the tanker again")
    public void create_a_new_manual_WO_to_create_the_tanker_again() throws ParseException, InterruptedException {
        casepage.manualWOCreation();
        casepage.manualBookableResource();
    }

    @And("search for the case to open it")
    public void search_for_the_case_to_open_it() throws InterruptedException {
        common.openACase();
        common.searchACase();
        // casepage.rolesUpdate();//need to remove once everything is merged
    }

    @And("change the view {string} and search a case")
    public void change_the_view_and_search_a_case(String viewname) throws InterruptedException {
        casepage.openACase();
        casepage.changeView(viewname);
        casepage.searchACase();
    }

    @And("change the assigned users to test users")
    public void change_the_assigned_users_to_test_users() {
        casepage.rolesUpdate();
    }

    @And("Validate that AO or SO get notified by Case or WO complaint notification")
    public void validateThatAOOrSOGetNotifiedByCaseOrWOComplaintNotification() throws InterruptedException {
        casepage.validateCaseComplaintNotification();
    }

    /*@And("Validate that SO get notified by case\\/WO complaint notification")
    public void validate_that_so_get_notified_by_case_wo_complaint_notification() throws InterruptedException {
      casepage.validateCaseComplaintNotification(); //Related to Compliance, For MultipleTankers (Line no51)
    }*/

    @And("Validate that SO get notified to approve the case")
    public void validate_that_so_get_notified_to_approve_the_case() throws InterruptedException {
        casepage.validateSOReviewNotification();
    }

    @And("Validate that SO get notified by WO complaint notification")
    public void Validate_that_SO_get_notified_by_WO_complaint_notification() throws InterruptedException {
        casepage.validateWOComplaintNotification(); //Related to Non-Compliance
    }

    @And("navigate to SO Review stage and fill the respective details and navigate to next stage")
    public void navigate_to_SO_Review_stage_and_fill_the_respective_details_and_navigate_to_next_stage() {
        casepage.completeSOReviewStage();
        loginpage.signoutApp();
    }

    @And("Validate that AO get notified by case\\/WO complaint notification")
    public void validate_that_AO_get_notified_by_case_wo_complaint_notification() throws InterruptedException {
        casepage.validateCaseComplaintNotification(); //For MultipleTankers (Line no57)
    }

    @And("Validate that AO get notified to approve the case")
    public void validate_that_AO_get_notified_to_approve_the_case() throws InterruptedException {
        casepage.validateSOReviewNotification();
    }

    @And("Validate that AO get notified by WO complaint notification")
    public void Validate_that_AO_get_notified_by_WO_complaint_notification() throws InterruptedException {
        casepage.validateWOComplaintNotification(); // For Non-Compliance
    }

    @And("navigate to AO Review stage and fill the respective details and navigate to next stage")
    public void navigate_to_AO_Review_stage_and_fill_the_respective_details_and_navigate_to_next_stage() throws InterruptedException {
        casepage.completeAOReviewStage();
        //factory.clickOnSavingInProgressOkButton();
        loginpage.signoutApp();
    }

    @And("navigate to GenerateEmail stage and fill the respective details and navigate to next stage")
    public void navigate_to_GenerateEmail_stage_and_fill_the_respective_details_and_navigate_to_next_stage() {
        casepage.completeGenerateEmailStage();
    }

    @And("validate the system triggered email {string} to tankercompany once tanker is approved for disposing waste")
    public void validate_the_system_triggered_email_to_tankercompany_once_tanker_is_approved_for_disposing_waste(String mailType) throws InterruptedException, ParseException {
        // casepage.mailValidation(mailType);
        casepage.mailGeneratedOrNot(mailType);
    }

    @And("validate the system triggered email {string} to WRP FD to update the status of Tankers")
    public void validate_the_system_triggered_email_to_WRP_FD_to_update_the_status_of_Tankers(String mailType) throws InterruptedException, ParseException {
        // casepage.mailValidation(mailType);
        casepage.mailGeneratedOrNot(mailType);
    }

    @And("navigate to Close stage and fill the respective details and navigate to next stage")
    public void navigate_to_Close_stage_and_fill_the_respective_details_and_navigate_to_next_stage() {
        casepage.completeResolveStage();

    }

    @And("verify SO is able to provide the rework comments")
    public void verify_SO_is_able_to_provide_the_rework_comments() {
        casepage.SORejectForRework();
        loginpage.signoutApp();
    }

    @And("verify case moved back to Insspection stage and all values changed back to default")
    public void verify_case_moved_back_to_Insspection_stage_and_all_values_changed_back_to_default() {
        casepage.movedBackToInspection();
    }

    @And("Validate that FIO get notified by Rework notification")
    public void Validate_that_FIO_get_notified_by_Rework_notification() throws InterruptedException {
        casepage.validateReworkNotification();
    }

    @And("open the work order and change the work order status to Inprogress")
    public void open_the_work_order_and_change_the_work_order_status_to_Inprogress() throws InterruptedException, ParseException {
        casepage.changeWOFromCompletedToInprogress();
    }

    @And("open the checklist and perform the amendments")
    public void open_the_checklist_and_perform_the_amendments() {
        casepage.amendChecklist();
    }

    @Then("verify the payment validation before creating actual quantities for {int}, {int} and {int}")
    public void verifyThePaymentValidationBeforeCreatingActualQuantitiesForGWPerMonthOSSPerMonthAndOSIPerMonth(int GWPerMonth,int OSSPerMonth, int OSIPerMonth) throws InterruptedException {
        casepage.paymentWasteTypeValidation();
        casepage.paymentRecordBeforeActualQuantitiesValidation(GWPerMonth, OSSPerMonth, OSIPerMonth);
    }

    @And("Create Actual Quantity \\(Disposal) by filling details")
    public void createActualQuantityDisposalByFillingDetails(DataTable typeOfTankersdata) {
        casepage.createActualQuantity(typeOfTankersdata);
    }

    @Then("Verify the payment validation after creating actual quantities for {int}, {int}, {int} {int} and {int}")
    public void verify_the_payment_validation_after_creating_actual_quantities_for_and(int GWPerMonth,int OSSPerMonth, int OSIPerMonth, int GWActual, int OSActual) throws InterruptedException {
        casepage.paymentWasteTypeValidation();
        casepage.paymentRecordAfterActualQuantitiesValidation(GWPerMonth, OSSPerMonth, OSIPerMonth, GWActual, OSActual);
    }

    @And("Update excel with GIRO value as {string} for Deposit Amount calculation")
    public void updateExcelGIROForDepositAmountCalculation(String giro) throws IOException {
        casepage.updateExcelForDepositAmountCal(giro);
    }

    @And("Upload excel file for Deposit Amount calculation with deposit amount as {int} and giro as {string}")
    public void uploadExcelFileForDepositAmountCalculationWithDepositAmountAsAndGiroAs(int deposit, String giro) throws InterruptedException {
        casepage.importExcelForDeposit(deposit, giro);
    }

    @Then("Verify the payment validation after creating deposit quantities for {int}, {int}, {int} {int}, {int} and {int}")
    public void verifyThePaymentValidationAfterCreatingDepositQuantitiesForAnd(int GWPerMonth,int OSSPerMonth, int OSIPerMonth, int GWActual, int OSActual, int expectedDepositAmount) throws InterruptedException {
        casepage.paymentWasteTypeValidation();
        casepage.paymentRecordAfterDepositQuantitiesValidation(GWPerMonth, OSSPerMonth, OSIPerMonth, GWActual, OSActual, expectedDepositAmount);
    }

    @And("verify reregistering with new company as {string}")
    public void verifyReregisteringWithNewCompanyAs(String reregisterWithNewCompany) throws InterruptedException {
        casepage.verifyReregisteringWithNewCompany(reregisterWithNewCompany);

    }

}
