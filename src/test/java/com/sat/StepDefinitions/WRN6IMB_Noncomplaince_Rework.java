package com.sat.StepDefinitions;

import com.sat.Pages.checkListCreationPage;
import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.Pages.constructionsPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WRN6IMB_Noncomplaince_Rework {

	private constructionsPage constructPage = new constructionsPage(TestBase.getDriver());
	private checkListCreationPage checklistpage = new checkListCreationPage(TestBase.getDriver());
	private originalCaseCreationPage casepage = new originalCaseCreationPage(TestBase.getDriver());
	private commonCRMActions commoncrm = new commonCRMActions(TestBase.getDriver());

	@And("create a manual project where Entity Type as {string} and Account Sub Type as {string}")
	public void create_a_manual_project_where_Entity_Type_as_and_Account_Sub_Type_as_(String entityType, String acctype)
			throws InterruptedException {
		constructPage.createManualProject(entityType, acctype);
	}

	@Then("go to {string} tab and enable the {string} field")
	public void go_to_tab_and_enable_the_field(String tab, String value) throws InterruptedException {
		constructPage.enableAffectedByPumpingMain(tab, value);
	}

	@And("go to {string} tab and create a new POWS submission request by giving {string}, {string}")
	public void go_to_tab_and_create_a_new_POWS_submission_request_by_giving(String tab1, String diameter,
			String DCvalue) throws InterruptedException {
		constructPage.createAPOWSReq(tab1, diameter, DCvalue);
	}

	@Then("verify whether case is created after POWS submisison request is approved")
	public void verify_whether_case_is_created_after_POWS_submisison_request_is_approved() {
		constructPage.verifyCaseCreatedFor6IMB();
	}

	@And("go to Service tasks tab and complete the checklist as {string} by selecting {string} selcted is as {string}")
	public void go_to_Service_tasks_tab_and_complete_the_checklist_as_by_selecting_selcted_is_as(
			String complainceStatus, String allWorkComplete, String value) throws InterruptedException {
		checklistpage.fillChecklistForWRN6IMB(complainceStatus, allWorkComplete, value);
	}

	@And("verify FIO get notified by non-complaince notification")
	public void verify_FIO_get_notified_by_non_complaince_notification() throws InterruptedException {
		commoncrm.notificationForTabToOpenCase(commonActionsPage.casenumber, "Inspection Case Information");
	}

	@And("verify recurring work order is getting created")
	public void verify_recurring_work_order_is_getting_created() {
		casepage.verifyRecurringWOCreation();
	}

	@And("open {string} WO and able to provide the rework comments")
	public void open_WO_and_able_to_provide_the_rework_comments(String WOstatus) {
		casepage.rejectWO(WOstatus);
	}

	@Then("verify new booking is created with {string} status and WO status also changed to {string}")
	public void verify_new_booking_is_created_with_status_and_WO_status_also_changed_to(String WOStatus,
			String bookingStatus) throws InterruptedException {
		casepage.verifyNewBooking(WOStatus, bookingStatus);
	}

	@And("open {string} WO and open the checklist and perform the amendments as {string} by selecting {string} selcted is as {string}")
	public void open_WO_and_open_the_checklist_and_perform_the_amendments_as_by_selecting_selcted_is_as(String WOType,
			String complainceStatus, String allWorkComplete, String value) throws InterruptedException {
		checklistpage.performAmendmentFor6IMB(WOType, complainceStatus, allWorkComplete, value);
	}

	@When("AO is able to update deviation remarks")
	public void ao_is_able_to_update_deviation_remarks() {
		casepage.updateDeviationRemarks();
	}

	@And("go to {string} and open the project which is closed above and create a new POWS submission request with {string}, {string}")
	public void go_to_and_open_the_project_which_is_closed_above_and_create_a_new_POWS_submission_request_with(
			String tab1, String diameter, String DCvalue) throws InterruptedException {
		constructPage.createAPOWSReq(tab1, diameter, DCvalue);
	}

	@Then("verify a new case is created")
	public void verify_a_new_case_is_created() {

	}

}
