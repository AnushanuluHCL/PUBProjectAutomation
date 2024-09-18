package com.sat.StepDefinitions;

import java.text.ParseException;

import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.WRN1CasePage;
import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.Pages.constructionsPage;
import com.sat.locators.factoryPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WRN8_NMB_Noncomplaince_Reinspection {

	private commonActionsPage common = new commonActionsPage(TestBase.getDriver());
	private constructionsPage constructPage = new constructionsPage(TestBase.getDriver());
	private commonCRMActions commoncrm = new commonCRMActions(TestBase.getDriver());
	private WRN1CasePage wrn1casepage = new WRN1CasePage(TestBase.getDriver());
	private factoryPage factory = new factoryPage(TestBase.getDriver());
	private PowerAppsAutomateFlowPage powerapppage = new PowerAppsAutomateFlowPage(TestBase.getDriver());

	@And("Update excel with Project title as {string}")
	public void Update_excel_with_Project_title_as(String project_title) {
		constructPage.updateDataIntoExcel(project_title);
	}

	@And("Import the data")
	public void Import_the_data() throws InterruptedException {
		constructPage.importExcelData();
	}

	@And("verify data is updated in the system and open it")
	public void verify_data_is_updated_in_the_system_and_open_it() {
		constructPage.verifyProjCraetionCheck();
	}

	@Then("go to {string} in project and verify the email for {string}")
	public void go_to_in_project_and_verify_the_email_for(String tab, String subject) throws InterruptedException {
		constructPage.verifyEmailAtProject(tab, subject);
	}

	@And("go to {string} tab and update the Mukim number as {string} and Lot number {string}")
	public void go_to_tab_and_update_the_Mukim_number_as_and_Lot_number(String tab, String mukimValue,
			String lotValue) {
		constructPage.updateMukimLotValues(tab, mukimValue, lotValue);
	}

	@And("go to {string} tab and update the {string},{string},{string} and {string} GERI response values")
	public void go_to_tab_and_update_the_and_GERI_response_values(String tab, String projMukimLotvalue,
			String diameterValue, String DTSSValue, String SewerValue) {
		constructPage.GERIResponse(tab, projMukimLotvalue, diameterValue, DTSSValue, SewerValue);
	}

	@And("change the view to {string} and verify created project available in this view")
	public void change_the_view_to_and_verify_created_project_available_in_this_view(String typeOfView) {
		common.changeView(typeOfView);
		constructPage.searchForAProject();
		constructPage.verifyProjectInShortListView();
	}

	@And("search for the project to open it")
	public void search_for_the_project_to_open_it() {
		constructPage.searchForAProject();
	}

	@And("approve the project")
	public void approve_the_project() throws InterruptedException {
		constructPage.approveProject();
	}

	@And("verify whether case is created once project is approved")
	public void verify_whether_case_is_created_once_project_is_approved() {
		constructPage.verifyCaseCreated();
	}

	@And("Verify that created case starts with {string} with status {string}")
	public void Verify_that_created_case_starts_with_with_status(String startsWithName, String statusOnCase) {
		wrn1casepage.verifyCaseFormat(startsWithName);
		common.verifyCaseStatusonCaseForm(statusOnCase);
	}

	@And("go to Service tasks tab and fill and complete the checklist with {string}")
	public void go_to_Service_tasks_tab_and_fill_and_complete_the_checklist(String activityCoveredIs) throws InterruptedException {
		constructPage.fillChecklistWRN8NMB(activityCoveredIs);
	}

	@And("verify Booking status is {string} and WO status field is {string}")
	public void verify_Booking_status_is_and_WO_status_field_is(String bookingStatus, String WOStatus) {
		commoncrm.verifyBookingStatus(bookingStatus);
		commoncrm.verifyWOStatusOnCaseHomepage(WOStatus);
	}

	@And("verify System Assessment and User Assessment are marked as {string} in case form")
	public void verify_System_Assessment_and_User_Assessment_are_marked_as_in_case_form(String assesment) {
		commoncrm.verifySystemAssesmentOnCaseHome(assesment);
	}

	@And("verify SO and AO get notified by alert for approval")
	public void verify_SO_AO_get_notified_by_alert_for_approval() throws InterruptedException {
		factory.approvalNotification();
	}

	@And("Verify that SO and AO get notified by no POWS approval notification")
	public void Verify_that_SO_AO_get_notified_by_no_POWS_approval_notification() throws InterruptedException {
		constructPage.POWSapprovalNotification();
	}

	@Then("go to {string} and verify the email for {string} and {string} and {string}")
	public void go_to_and_verify_the_email_for_and_and(String tab, String email1, String email2, String email3)
			throws InterruptedException {
		commoncrm.navigatingToTab(tab);
		commoncrm.emailCheck(email1);
		commoncrm.emailCheck(email2);
		commoncrm.emailCheck(email3);

	}

	@And("change the Reinspection date value")
	public void change_the_Reinspection_date_value() throws ParseException {
		constructPage.updateReinspectionDate();
	}

	@And("verify new work order is created with type as {string} after job run and open it")
	public void verify_new_work_order_is_created_with_type_as_after_job_run_and_open_it(String type) {
		constructPage.verifyTypeOFWO(type);
	}

	@And("Login to powerapp with {string} and {string}")
	public void Login_to_powerapp_with_and(String username, String password) {
		powerapppage.loginPowerApp(username, password);
	}
	
	@And("logout from the powerapps application")
	public void logout_from_the_powerapps_application() {
		powerapppage.logoutPowerApp();
	}

}
