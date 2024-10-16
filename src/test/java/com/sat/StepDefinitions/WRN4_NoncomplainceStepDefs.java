package com.sat.StepDefinitions;

import java.util.Properties;
import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.caseCreationPage;
import com.sat.Pages.commonActionsPage;
import com.sat.Pages.eatingEstablishmentPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.locators.checkListPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.*;

public class WRN4_NoncomplainceStepDefs {

	private eatingEstablishmentPage eepage = new eatingEstablishmentPage(TestBase.getDriver());
	private originalCaseCreationPage casepage=new originalCaseCreationPage(TestBase.getDriver());
	private checkListPage chklistPage = new checkListPage(TestBase.getDriver());

	@When("create a manual project where Entity Type as {string} with {string}")
	public void create_a_manual_project_where_entity_type_as_with(String entityType, String countOfGts) throws InterruptedException {
		eepage.createmEatingEstablishment(entityType, countOfGts);
		eepage.getCaseIdAfterEEIdCreation();
		eepage.getTheGTsCountFromEntity();
	}
	@Then("Verify the number of work orders are matching with the number of Gts")
	public void Verify_the_number_of_work_orders_are_matching_with_the_number_of_Gts() {
		casepage.verifyWOsCount();
	}
	@Then("go to Service tasks tab and complete the checklist as {string} for {string}")
	public void go_to_Service_tasks_tab_and_complete_the_checklist_as_for(String complainceStatus, String checklistName)
			throws InterruptedException {
		chklistPage.fillCheckListQuestionsForWRN4(complainceStatus, checklistName);
	}
	@Then("open {string} WO and accept the WO")
	public void open_WO_and_accept_the_WO(String WOstatus) {
		casepage.acceptWO(WOstatus);
	}

}
