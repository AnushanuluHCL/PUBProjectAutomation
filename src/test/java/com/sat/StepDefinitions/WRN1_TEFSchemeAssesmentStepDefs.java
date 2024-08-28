package com.sat.StepDefinitions;

import com.sat.Pages.CommonActionsPage;
import com.sat.Pages.WRN1FactoryPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;

public class WRN1_TEFSchemeAssesmentStepDefs {

	private CommonActionsPage common = new CommonActionsPage(TestBase.getDriver());
	private WRN1FactoryPage wrn1Factorypage = new WRN1FactoryPage(TestBase.getDriver());

	@And("verify the factory is fulfilled with the details as {string},{string},{string}")
	public void verify_the_factory_is_fulfilled_with_the_details_as(String tradeGrp, String fpeVal, String WAnumVal) {
		wrn1Factorypage.verifyWANumberStatus(tradeGrp, fpeVal, WAnumVal);
	}

}
