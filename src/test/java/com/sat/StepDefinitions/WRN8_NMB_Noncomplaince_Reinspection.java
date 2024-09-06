package com.sat.StepDefinitions;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.WRN1CasePage;
import com.sat.Pages.commonCRMActions;
import com.sat.Pages.constructionsPage;
import com.sat.Pages.factoryCreationPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WRN8_NMB_Noncomplaince_Reinspection {

	private commonActionsPage common = new commonActionsPage(TestBase.getDriver());
	private constructionsPage constructPage = new constructionsPage(TestBase.getDriver());
	private commonCRMActions commoncrm = new commonCRMActions(TestBase.getDriver());

	@And("Update excel with Project title as {string}")
	public void Update_excel_with_Project_title_as(String project_title) {
		constructPage.updateDataIntoExcel(project_title);
	}

	@And("Import the data")
	public void Import_the_data() throws InterruptedException {
		constructPage.importExcelData();
	}
	@And("verify data is updated in the system and open it")
	public void verify_data_is_updated_in_the_system_and_open_it() {
		constructPage.verifyProjCraetionCheck();	
	}
	@Then("go to {string} in project and verify the email for {string}")
    public void go_to_in_project_and_verify_the_email_for(String tab, String subject) throws InterruptedException {
		constructPage.verifyEmailAtProject(tab, subject);
    }
	@And("go to {string} tab and update the Mukim number as {string} and Lot number {string}")
	public void go_to_tab_and_update_the_Mukim_number_as_and_Lot_number(String tab,String mukimValue, String lotValue) {
		constructPage.updateMukimLotValues(tab,mukimValue, lotValue);
	}
	@And("go to {string} tab and update the {string},{string},{string} and {string} GERI response values")
	public void go_to_tab_and_update_the_and_GERI_response_values(String tab, String projMukimLotvalue, String diameterValue, String DTSSValue, String SewerValue) {
		constructPage.GERIResponse(tab, projMukimLotvalue, diameterValue, DTSSValue, SewerValue);
	}
	@And("change the view to {string} and verify created project available in this view")
	public void change_the_view_to_and_verify_created_project_available_in_this_view(String typeOfView) {
		common.changeView(typeOfView);
		constructPage.verifyProjectInShortListView();
	}
}
