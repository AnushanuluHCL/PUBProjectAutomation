package com.sat.StepDefinitions;

import com.sat.Pages.checkListCreationPage;
import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.Pages.constructionsPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WRN6IMB_Noncomplaince_Rework {

	private constructionsPage constructPage = new constructionsPage(TestBase.getDriver());
	private checkListCreationPage checklistpage = new checkListCreationPage(TestBase.getDriver());
	private originalCaseCreationPage casepage = new originalCaseCreationPage(TestBase.getDriver());
	private commonCRMActions commoncrm = new commonCRMActions(TestBase.getDriver());

	@And("create a manual project where Entity Type as {string} and Account Sub Type as {string}")
	public void create_a_manual_project_where_Entity_Type_as_and_Account_Sub_Type_as_(String entityType, String acctype)
			throws InterruptedException {
		constructPage.createmanualProject(entityType, acctype);
	}

	@Then("go to {string} tab and enable the {string} field")
	public void go_to_tab_and_enable_the_field(String tab, String value) {
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

	@And("go to Service tasks tab and complete the checklist by selecting {string} selcted is as {string}")
	public void go_to_Service_tasks_tab_and_complete_the_checklist_by_selecting_selcted_is_as(String allWorkComplete,
			String value) throws InterruptedException {
		checklistpage.fillChecklistForWRN6IMB(allWorkComplete, value);
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
		casepage.enterReworkComments(WOstatus);
		}

}
