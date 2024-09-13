package com.sat.StepDefinitions;

import com.sat.Pages.originalCaseCreationPage;
import com.sat.Pages.pumpingSystemCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WRN9IMB_InspectionFlowForNotInOrder {

    private pumpingSystemCreationPage pumpingSystem = new pumpingSystemCreationPage(TestBase.getDriver());
    private originalCaseCreationPage casePage = new originalCaseCreationPage(TestBase.getDriver());

    @And("create a manual Pumping System where Entity Type as {string}")
    public void createAManualPumpingSystemWhereEntityTypeAs(String entityType) throws InterruptedException {
        pumpingSystem.createPumpingSystem(entityType);
    }

    @And("navigate to {string} tab")
    public void navigateToTab(String tabName) {
        pumpingSystem.navigateToTabName(tabName);
    }

    @And("create a new BPU Submission record where Submission Type as {string}")
    public void createANewBPUSubmissionRecordWhereSubmissionTypeAs(String submissionType) throws InterruptedException {
        pumpingSystem.createBPUSubmission(submissionType);
    }

    @Then("check Submission Date should be auto populated as today's date")
    public void checkSubmissionDateShouldBeAutoPopulatedAsTodaySDate() throws InterruptedException {
        pumpingSystem.verifySubmissionDate();
    }

    @And("click on Cases button")
    public void clickOnCasesButton() {
        pumpingSystem.clickCases();
    }

    @Then("verify whether Case is created with {string} status and open a Case")
    public void verifyWhetherCaseIsCreatedWithStatusAndOpenACase(String status) {
        pumpingSystem.verifyCaseStatus(status);
    }

    @And("open {string} WO and fill the required checklist for {string} and fill as {string}")
    public void openWOAndFillTheRequiredChecklistForAndFillAs(String status, String checkListName, String systemAssessment) throws InterruptedException {
        casePage.pumpingSystemChecklist(status, checkListName, systemAssessment);
    }

    @Then("verify Last Inspected On as today date")
    public void verifyLastInspectedOnAsTodayDate() throws InterruptedException {
        casePage.verifyLastInspectedOn();
    }


    @And("navigate to AO Review stage and set Recurrence Required as {string} and Frequency as {string} days and navigate to next stage")
    public void navigateToAOReviewStageAndSetRecurrenceRequiredAsAndFrequencyAsDaysAndNavigateToNextStage(String recurrence, String frequency) throws InterruptedException {
        casePage.wrn9AOReviewStage(recurrence, frequency);
    }

    @Then("verify Next Booking Date as today date + {int} days")
    public void verifyNextBookingDateAsTodayDateDays(int days) throws InterruptedException {
        casePage.verifyNextBookingDate(days);
    }

    @And("navigate to Close stage and set Resolve Case as {string}")
    public void navigateToCloseStageAndSetResolveCaseAs(String resolveCase) throws InterruptedException {
        casePage.wrn9ResolveCaseStage(resolveCase);
    }

    @Then("verify {string} this message")
    public void verifyThisMessage(String recurrenceMessage) {
        casePage.verifyRecurrenceMessage(recurrenceMessage);
    }

    @And("refresh the page")
    public void refreshThePage() {
        casePage.refreshRecordPage();
    }
}