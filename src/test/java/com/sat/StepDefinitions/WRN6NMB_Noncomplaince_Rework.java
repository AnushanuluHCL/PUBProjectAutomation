package com.sat.StepDefinitions;

import com.sat.Pages.commonCRMActions;
import com.sat.Pages.constructionsPage;
import com.sat.Pages.factoryCreationPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WRN6NMB_Noncomplaince_Rework {

    private constructionsPage constructPage = new constructionsPage(TestBase.getDriver());
    private factoryCreationPage factoryPage = new factoryCreationPage(TestBase.getDriver());
    private commonCRMActions crmActions = new commonCRMActions(TestBase.getDriver());
    private originalCaseCreationPage casePage = new originalCaseCreationPage(TestBase.getDriver());

    @And("go to {string} tab and open POWS Submission record")
    public void goToTabAndOpenPOWSSubmissionRecord(String tabName) throws InterruptedException {
        constructPage.openPOWSSubmission(tabName);
    }

    @And("go to {string} tab and create a new POWS submission Corridor with {string}, {string}")
    public void goToTabAndCreateANewPOWSSubmissionCorridorWith(String tabName, String corridorType, String zoneType) throws InterruptedException {
        factoryPage.navigateToTab(tabName);
        constructPage.createNewPOWSSubCorridor(corridorType, zoneType);
    }

    @Then("verify Case created with Case Number {string}")
    public void verifyCaseCreatedWithCaseNumber(String caseNumber) throws InterruptedException {
        constructPage.checkCaseCreated(caseNumber);
    }

    @And("go to {string} tab and create a new POWS submission request by giving {string}, {string} for NMB")
    public void goToTabAndCreateANewPOWSSubmissionRequestByGivingForNMB(String tabName, String diameterValue, String DCvalue) throws InterruptedException {
        constructPage.createAPOWSReqForWRN6NMB(tabName, diameterValue, DCvalue);
    }

    @And("open work order and go to Bookings tab")
    public void openWorkOrderAndGoToBookingsTab() {
        crmActions.goToBookings();
    }

    @Then("verify {int} bookings are created")
    public void verifyBookingsAreCreated(int count) {
        casePage.verifyBookingCounts(count);
    }
}
