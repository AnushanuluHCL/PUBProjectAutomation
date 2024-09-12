package com.sat.StepDefinitions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.WAApplicationPage;
import com.sat.Pages.WRN1CasePage;
import com.sat.Pages.factoryCreationPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;

public class WRN1_NewWAApplicationStepDefs {

	private WAApplicationPage wapage = new WAApplicationPage(TestBase.getDriver());
	private commonActionsPage common = new commonActionsPage(TestBase.getDriver());
	private WRN1CasePage wrn1casepage = new WRN1CasePage(TestBase.getDriver());
	private factoryCreationPage factoryCreapage = new factoryCreationPage(TestBase.getDriver());

	@And("fill the details in the WA application form")
	public void fill_the_details_in_the_WA_application_form(String blkno, String unitval, String buildingname,
			String strname, String postalcode, String Accountnum, String activityval, String tradeval,
			String catchmentval) {
		// wapage.fillCompanyDetails(blkno, unitval, buildingname, strname, postalcode,
		// Accountnum, activityval,
		// tradeval, catchmentval);
	}

	@And("fill the details in the WA application form with the following JSON:")
	public void fillTheDetailsInWAApplicationFormWithJson(String json) throws InterruptedException {
		wapage.fillCompanyDetails(json);
	}

	@And("fill the details in the WA application form using data from {string}")
	public void fill_the_details_in_the_WA_application_form_using_data_from(String fileName)
			throws IOException, URISyntaxException, InterruptedException {
		wapage.fillCompanyDetails(fileName);
	}

	@And("change the view to {string}")
	public void change_the_view_to(String typeOfCases) {
		common.changeView(typeOfCases);
	}

	@And("verify the case form fields validation")
	public void verify_the_case_form_fields_validation(String status) {
		wrn1casepage.caseFormFieldsValidation(status);
	}

	@And("Validate the system triggered {string} email to the applicant")
	public void Validate_the_system_triggered_email_to_the_applicant(String mail)
			throws InterruptedException, ParseException {
		wrn1casepage.mailGeneratedOrNotWRN1(mail);
	}

	@And("navigate to Assignment stage and update all documents received data and navigate to next stage")
	public void navigate_to_Assignment_stage_and_update_all_documents_received_data_and_navigate_to_next_stage() {
		wrn1casepage.completeAssignmentStage();
	}

	@And("Create a new lab report by filling {string},{string},{string} details")
	public void Create_a_new_lab_report_by_filling_details(String reportTypeval, String chemicalval,
			String concentrationval) throws InterruptedException {
		wrn1casepage.createNewLabReport(reportTypeval, chemicalval, concentrationval);
	}

	@And("verify the lab report result as {string}")
	public void verify_the_lab_report_result_as_(String status) {
		wrn1casepage.verifyTheResult(status);
	}

	@And("validate that SO get notified to Review WA application")
	public void validate_that_SO_get_notified_to_Review_WA_application() throws InterruptedException {
		wrn1casepage.validateSOReviewnewWANotification();
	}

	@And("validate that AO get notified to Review WA application")
	public void validate_that_AO_get_notified_to_Review_WA_application() throws InterruptedException {
		wrn1casepage.validateAOReviewnewWANotification();
	}

	@And("validate that FIO get notified by AO approval notification and ask FIO to generate email")
	public void validate_that_FIO_get_notified_by_AO_approval_notification_and_ask_FIO_to_generate_email() throws InterruptedException {
		wrn1casepage.validateFIOToGenerateEmailNotification();
	}

	@And("verify the WA status once AO approved is {string}")
	public void verify_the_WA_status_once_AO_approved_is(String status) {
		factoryCreapage.verifyWAStatus(status);
	}
}
