package com.sat.StepDefinitions;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.Pages.pumpingMainStationsPage;
import com.sat.locators.factoryPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WRN7_IMB_Noncomplaince {

	private commonActionsPage common = new commonActionsPage(TestBase.getDriver());
	private commonCRMActions commoncrm = new commonCRMActions(TestBase.getDriver());
	private pumpingMainStationsPage pumpPage = new pumpingMainStationsPage(TestBase.getDriver());
	private factoryPage factory = new factoryPage(TestBase.getDriver());


	@And("create a new pumping station by giving {string},{string},{string}")
	public void create_a_new_pumping_station_by_giving_(String entityVal, String catchmentValue, String month) {
		//pumpPage.entityCreation(entityVal, catchmentValue, month);
	}
	@And("create a new pumping station by giving {string},{string}")
	public void create_a_new_pumping_station_by_giving(String entityVal, String month) {
		pumpPage.entityCreation(entityVal, month);
	}

	@And("creating {int} chambers")
	public void creating_chambers(int numberOfRecords) {
		pumpPage.chamberCreation(numberOfRecords);
	}

	@Then("verify whether case is created after the job run")
	public void verify_whether_case_is_created_after_the_job_run() throws InterruptedException {
		pumpPage.verifyWRN7NMBCaseCreated();
	}
	@And("open {string} WO and select the {string} booking record and complete all the booking process")
	public void open_WO_and_select_the_booking_record_and_complete_all_the_booking_process(String wostatus, String bookingsttaus) throws InterruptedException {
		commoncrm.multipleBookingFilling(wostatus, bookingsttaus);
	}
	@And("go to Service tasks tab and complete the checklist with {string}")
	public void go_to_Service_tasks_tab_and_complete_the_checklist(String complainceVal) throws InterruptedException {
		pumpPage.fillChecklistWRN7IMB(complainceVal);
	}
	@And("verify SO get notified by alert for approval")
	public void verify_SO_get_notified_by_alert_for_approval() throws InterruptedException {
		factory.approvalNotification();
	}
	@And("go to {string} and verify the email for {string} and {string}")
	public void go_to_and_verify_the_email_for_and(String tab, String email1, String email2) throws InterruptedException {
		commoncrm.navigatingToTab(tab);
		commoncrm.emailCheck(email1);
		commoncrm.emailCheck(email2);
	}
}
