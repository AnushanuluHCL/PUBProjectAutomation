package com.sat.StepDefinitions;

import com.sat.Pages.CommonActionsPage;
import com.sat.Pages.WRN1CasePage;
import com.sat.Pages.factoryCreationPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;

public class WRN1_TEFSchemeAssesmentStepDefs {

	private CommonActionsPage common = new CommonActionsPage(TestBase.getDriver());
	private factoryCreationPage factoryCreaPage = new factoryCreationPage(TestBase.getDriver());
	private WRN1CasePage wrn1casepage = new WRN1CasePage(TestBase.getDriver());

	@And("verify the factory is fulfilled with the details as {string},{string},{string}")
	public void verify_the_factory_is_fulfilled_with_the_details_as(String tradeGrp, String fpeVal, String WAnumVal) {
		factoryCreaPage.verifyWANumberStatus(tradeGrp, fpeVal, WAnumVal);
	}

	@And("Verify that case is created starts with {string} created with status {string} and verify Case notification")
	public void Verify_that_case_is_created_starts_with_created_with_status_and_verify_Case_notification(
			String startsWithName, String schedule) throws InterruptedException {
		wrn1casepage.verifyCaseFormat(startsWithName);
		common.verifyCaseStatus();
		wrn1casepage.caseNotification();
	}

}
