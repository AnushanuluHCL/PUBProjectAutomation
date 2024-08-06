package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sat.Pages.ApplicationPage;
import com.sat.Pages.CasecreationPage;
import com.sat.Pages.LoginPage;
import com.sat.Pages.NEAListPage;
import com.sat.Pages.CommonActionsPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class GWComplaintStepdefs extends BaseStepDefs {

    // private LoginPage loginpage = new LoginPage(TestBase.getDriver());
    // private NEAListPage neapage = new NEAListPage(TestBase.getDriver());
    private ApplicationPage apppage = new ApplicationPage(TestBase.getDriver());
    private CommonActionsPage common = new CommonActionsPage(TestBase.getDriver());
    private CasecreationPage casepage = new CasecreationPage(TestBase.getDriver());
    private LoginPage loginpage = new LoginPage(TestBase.getDriver());
    // public static String tankercompanyname;

    private Properties prop;
    private TestBase testbase = new TestBase();

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
        casepage.caseCreatioCheck();
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
        casepage.navigatingtotab(tabnanme);
    }

    @And("validate the schedule workorder notification")
    public void validate_the_schedule_workorder_notification() throws InterruptedException {
        casepage.validateWOScheduleNotification();
    }

    @And("fill the details in Bookings section")
    public void fill_the_details_in_Bookings_section() throws InterruptedException, ParseException {
        // casepage.workOrderValidation();
        casepage.fillBookingDeatils();
    }

    @And("navigate to Assignment stage and confirm the inspection schedule")
    public void navigate_to_Assignment_stage_and_confirm_the_inspection_schedule() {
        casepage.confirmInspectionSchedule();
    }

    @And("go to Service tasks tab and fill and complete the checklist as {string}")
    public void go_to_Service_tasks_tab_and_fill_and_complet_the_checklist_as(String outcome) throws InterruptedException {
        // casepage.fillTheChecklistquestions(Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10,
        // Q11, Q12, Q13, Q14, Q15, Q16, Q17,Ack);
        casepage.fillTheChecklistquestions(outcome);
        /*
         * If("gwcompalint"){ String str="Yes"; //
         * casepage.fillTheChecklistquestions(str); } else {
         * casepage.fillTheChecklistquestions(Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10,
         * Q11, Q12, Q13, Q14, Q15, Q16, Q17, Ack); }
         */
    }

    @And("verify the WO status field is {string} and verify tanker Iscomplaint? field value as {string} in work order form")
    public void verify_the_wo_status_field_is_and_verify_tanker_iscomplaint_field_value_as_in_work_order_form(String status, String iscomplaint) {
        casepage.complaincecheckInWorkorderAnusha(status, iscomplaint);
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
    public void navigate_to_Inspection_stage_and_fill_the_respective_details_and_navigate_to_next_stage() {
        casepage.completeInspectionStage();
        loginpage.signoutApp();
    }

    @And("verify that {string} mail is generated once Iscomplaint? field value updated to No")
    public void verify_that_mail_is_generated_once_Iscomplaint_field_value_updated_to_No(String mailType) throws InterruptedException, ParseException {
        casepage.mailGeneratedOrNot(mailType);
    }

    @And("verify that inspection report is generated")
    public void verify_that_inspection_report_is_generated() {
        casepage.inspectionReportCheck();
    }

    @And("create a new manual WO to create reinspection of the tanker again")
    public void create_a_new_manual_WO_to_create_reinspection_of_the_tanker_again() throws ParseException, InterruptedException {
        casepage.manualWOCreation();
        casepage.manualBookableResource();
    }

    @And("search for the case to open it")
    public void search_for_the_case_to_open_it() throws InterruptedException {
        casepage.openACase();
        casepage.searchACase();
        // casepage.rolesUpdate();//need to remove once everything is merged
    }

    @And("change the view and search a case")
    public void change_the_view_and_search_a_case() throws InterruptedException {
        casepage.openACase();
        casepage.changeView();
        casepage.searchACase();
    }

    @And("change the assigned users to test users")
    public void change_the_assigned_users_to_test_users() {
        casepage.rolesUpdate();
    }

    @And("Validate that SO get notified by case\\/WO complaint notification")
    public void validate_that_so_get_notified_by_case_wo_complaint_notification() throws InterruptedException {
        casepage.validateCaseComplaintNotification();
    }

    @And("Validate that SO get notified to approve the case")
    public void validate_that_so_get_notified_to_approve_the_case() throws InterruptedException {
        casepage.validateSOReviewNotification();
    }

    @And("Validate that SO get notified by WO complaint notification")
    public void Validate_that_SO_get_notified_by_WO_complaint_notification() throws InterruptedException {
        casepage.validateWOComplaintNotification();
    }

    @And("navigate to SO Review stage and fill the respective details and navigate to next stage")
    public void navigate_to_SO_Review_stage_and_fill_the_respective_details_and_navigate_to_next_stage() {
        casepage.completeSOReviewStage();
        loginpage.signoutApp();
    }

    @And("Validate that AO get notified by case\\/WO complaint notification")
    public void validate_that_AO_get_notified_by_case_wo_complaint_notification() throws InterruptedException {
        casepage.validateCaseComplaintNotification();
    }

    @And("Validate that AO get notified to approve the case")
    public void validate_that_AO_get_notified_to_approve_the_case() throws InterruptedException {
        casepage.validateSOReviewNotification();
        ;
    }

    @And("Validate that AO get notified by WO complaint notification")
    public void Validate_that_AO_get_notified_by_WO_complaint_notification() throws InterruptedException {
        casepage.validateWOComplaintNotification();
    }

    @And("navigate to AO Review stage and fill the respective details and navigate to next stage")
    public void navigate_to_AO_Review_stage_and_fill_the_respective_details_and_navigate_to_next_stage() {
        casepage.completeAOReviewStage();
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

    @And("verify the payment record validaton for {string}")
    public void verify_the_payment_record_validaton_for(String OSSPerMonth, String OSIPerMonth, String GWPerMonth, String wastetype) throws InterruptedException {
        casepage.paymentRecordValidation(OSSPerMonth, OSIPerMonth, GWPerMonth, wastetype);
    }
}
