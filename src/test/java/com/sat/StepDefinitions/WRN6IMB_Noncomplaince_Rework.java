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

public class WRN6IMB_Noncomplaince_Rework {

	private commonActionsPage common = new commonActionsPage(TestBase.getDriver());
	private constructionsPage constructPage = new constructionsPage(TestBase.getDriver());
	private commonCRMActions commoncrm = new commonCRMActions(TestBase.getDriver());
	private WRN1CasePage wrn1casepage = new WRN1CasePage(TestBase.getDriver());
	private factoryPage factory = new factoryPage(TestBase.getDriver());
	private PowerAppsAutomateFlowPage powerapppage = new PowerAppsAutomateFlowPage(TestBase.getDriver());

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

}
