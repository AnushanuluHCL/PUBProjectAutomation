package com.sat.StepDefinitions;

import java.text.ParseException;
import java.util.Properties;

import com.sat.Pages.caseCreationPage;
import com.sat.Pages.loginPage;
import com.sat.Pages.commonActionsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.*;

public class TankerDeregisterStepdefs {

    private commonActionsPage common = new commonActionsPage(TestBase.getDriver());
    private caseCreationPage casepage = new caseCreationPage(TestBase.getDriver());
    private loginPage loginpage = new loginPage(TestBase.getDriver());

	private Properties prop;
	private TestBase testbase = new TestBase();

	@Then("create a manual case with case subtype as {string}")
	public void create_a_manual_case_with_case_subtype_as(String casesubtype) throws InterruptedException {
		common.manualCaseCreation(casesubtype);
	}
	@And("select a tanker to deregister it")
	public void select_a_tanker_to_deregister_it() throws InterruptedException {
		casepage.tankerToDeregister();
	}

	@And("navigate to Processing stage and fill the respective details and navigate to next stage")
	public void navigate_to_Processing_stage_and_fill_the_respective_details_and_navigate_to_next_stage() {
		casepage.processingStage();
		loginpage.signoutApp();
	}

	@And("validate that SO get notified by tanker deregister notification")
	public void validate_that_SO_get_notified_by_tanker_deregister_notification() throws InterruptedException {
		casepage.validateDeregisterNotification();
	}

	@And("validate the system triggered {string} email to tankercompany about deregistered tankers")
	public void validate_the_system_triggered_email_to_tankercompany_about_deregistered_tankers(String mailType)
			throws InterruptedException, ParseException {
		casepage.mailGeneratedOrNot(mailType);
	}

	@And("validate the tankerpermitstatus")
	public void validate_the_tankerpermitstatus() {
		casepage.verifyDeregisteredTankers();
	}

}
