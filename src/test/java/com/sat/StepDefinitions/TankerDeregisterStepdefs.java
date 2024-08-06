package com.sat.StepDefinitions;

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
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class TankerDeregisterStepdefs extends BaseStepDefs {

    private CommonActionsPage common = new CommonActionsPage(TestBase.getDriver());
    private CasecreationPage casepage = new CasecreationPage(TestBase.getDriver());
    private LoginPage loginpage = new LoginPage(TestBase.getDriver());

    private Properties prop;
    private TestBase testbase = new TestBase();

	@Then("create a manual case to with case subtype as {string}")
	public void create_a_manual_case_to_with_case_subtype_as(String caseSubType) throws InterruptedException {
		casepage.manualCaseCreation(caseSubType);
	}
	@And("select a tnaker to deregister it")
	public void select_a_tnaker_to_deregister_it() throws InterruptedException {
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
	public void validate_the_system_triggered_email_to_tankercompany_about_deregistered_tankers(String mailType) throws InterruptedException, ParseException {
		casepage.mailGeneratedOrNot(mailType);
	}
	@And("validate the tankerpermitstatus")
	public void validate_the_tankerpermitstatus() {
		casepage.verifyDeregisteredTankers();
	}

}
