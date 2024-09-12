package com.sat.StepDefinitions;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.WRN1CasePage;
import com.sat.Pages.commonCRMActions;
import com.sat.Pages.factoryCreationPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;

public class WRN1_TEFSchemeAssesmentStepDefs {

	private commonActionsPage common = new commonActionsPage(TestBase.getDriver());
	private factoryCreationPage factoryCreaPage = new factoryCreationPage(TestBase.getDriver());
	private WRN1CasePage wrn1casepage = new WRN1CasePage(TestBase.getDriver());
	private commonCRMActions commoncrm = new commonCRMActions(TestBase.getDriver());

	@And("verify the factory is fulfilled with the details as {string},{string},{string}")
	public void verify_the_factory_is_fulfilled_with_the_details_as(String tradeGrp, String fpeVal, String WAnumVal) {
		factoryCreaPage.verifyWANumberStatus(tradeGrp, fpeVal, WAnumVal);
	}

	@And("Verify that case is created starts with {string} created with status {string} and verify Case notification")
	public void Verify_that_case_is_created_starts_with_created_with_status_and_verify_Case_notification(
			String startsWithName, String schedule) throws InterruptedException {
		wrn1casepage.verifyCaseFormat(startsWithName);
		common.verifyCaseStatusonCaseForm(schedule);
		wrn1casepage.caseNotification();
	}

	@And("verify the WO status {string}")
	public void verify_the_WO_status(String status) {
		commoncrm.verifyWOStatusOnCaseHomepage(status);
	}

	@And("go to Checklist tab create sample for lab analysis details and fill the required checklist")
	public void go_to_Checklist_tab_create_sample_for_lab_analysis_details_and_fill_the_required_checklist()
			throws InterruptedException {
		factoryCreaPage.fillChecklistforWRN1TEF();
	}

	@And("go to {string} and upload lab report {string} in Prohibited Organic Heavy Metal Compounds section")
	public void go_to_and_upload_lab_report_in_Prohibited_Organic_Heavy_Metal_Compounds_section(String tab,
			String WQPath) throws InterruptedException {
		factoryCreaPage.navigateToTab(tab);
		factoryCreaPage.openLabReport();
		factoryCreaPage.uploadTEFReport(WQPath);
	}

	@And("Verify uplaoded report dispalyed in the Prohibited Organic Heavy Metal Compounds section")
	public void Verify_uplaoded_report_dispalyed_in_the_Prohibited_Organic_Heavy_Metal_Compounds_section()
			throws InterruptedException {
		factoryCreaPage.verifyUploadedLabReport();
	}

	@And("select Interested in TEF Scheme field value")
	public void select_Interested_in_TEF_Scheme_field_value() {
		wrn1casepage.interestedInTEFScheme();
	}

	@And("update the consumption details as {string},{string}")
	public void update_the_consumption_details_as_(String consumptionval, String number) {
		wrn1casepage.selectDepositValue(consumptionval, number);
	}

}
