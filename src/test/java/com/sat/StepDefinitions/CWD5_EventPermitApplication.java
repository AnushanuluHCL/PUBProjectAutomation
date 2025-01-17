package com.sat.StepDefinitions;

import com.sat.Pages.checkListCreationPage;
import com.sat.Pages.commonActionsPage;
import com.sat.Pages.eventPermitApplicationPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CWD5_EventPermitApplication {

    private commonActionsPage commonActions = new commonActionsPage(TestBase.getDriver());
    private eventPermitApplicationPage eventPermitPage = new eventPermitApplicationPage(TestBase.getDriver());
    private originalCaseCreationPage casesPage = new originalCaseCreationPage(TestBase.getDriver());
    private checkListCreationPage checkListPage = new checkListCreationPage(TestBase.getDriver());

    @And("click on new button")
    public void clickOnNewButton() {
        commonActions.clickonNewBtn();
    }

    @And("create an Application from Javascript")
    public void createAnApplicationFromJavascript() {
        eventPermitPage.createApplicationFromJS();
    }

    @And("create a Application with Event Inspection type as {string}")
    public void createAApplicationWithEventInspectionTypeAs(String eventInspectionType) throws InterruptedException {
        eventPermitPage.createEventPermitApplication(eventInspectionType);
    }

    @And("click on save button")
    public void clickOnSaveButton() {
        commonActions.clickOnSaveBtn();
    }

    @And("click on {string} tab")
    public void clickOnTab(String tabName) throws InterruptedException {
        commonActions.navigatingToTabInEntity(tabName);
    }

    @Then("verify Case created with Case Reference Number {string}")
    public void verifyCaseCreatedWithCaseReferenceNumber(String caseRefNumber) throws InterruptedException {
        casesPage.checkCaseCreation(caseRefNumber);
    }

    @And("click on Processing Stage and fill the respective details for Event Permit Application Case")
    public void clickOnProcessingStageAndFillTheRespectiveDetailsForEventPermitApplicationCase() {
        casesPage.completeProcessingStage();
    }

    @And("click on Yes button on generate permit letter popup")
    public void clickOnYesButtonOnGeneratePermitLetterPopup() {
        casesPage.clickGeneratePermitLetterYesButton();
    }

    @And("click on Refresh button")
    public void clickOnRefreshButton() {
        commonActions.clickOnRefreshBtn();
    }

    @Then("verify warning message {string}")
    public void verifyWarningMessage(String warningMessage) {
        casesPage.verifyEventPermitWarningMessage(warningMessage);
    }

    @And("search and open the application")
    public void searchAndOpenTheApplication() throws InterruptedException {
        eventPermitPage.searchAndOpenApplication();
    }

    @And("open {string} WO fill the checklist for event inspection {string} for {string} and verify WO status as {string}")
    public void openWOFillTheChecklistForEventInspectionForAndVerifyWOStatusAs(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkListPage.fillChecklistForEventPermitCWD5(status, checkListName, checkListType, completeStatus);
    }

    @And("enter rectification due date and select rectification required")
    public void enterRectificationDueDateAndSelectRectificationRequired() throws InterruptedException {
        casesPage.selectRectificationDueDate();
        casesPage.selectRectificationRequired();
    }

    @And("create a new Form SG")
    public void createANewFormSG() {
        casesPage.createNewFormSG();
    }

    @And("click on {string} button")
    public void clickOnButton(String buttonName) {
        casesPage.selectFormSGApproveAndReject(buttonName);
    }

    @Then("verify Rectification Submission status is marked as {string}")
    public void verifyRectificationSubmissionStatusIsMarkedAs(String rectificationStatus) {
        casesPage.checkRectificationSubmissionStatus(rectificationStatus);
    }

    @Then("verify Rectification Documents Verified is marked as {string} and Rectification Required is marked as {string}")
    public void verifyRectificationDocumentsVerifiedIsMarkedAsAndRectificationRequiredIsMarkedAs(String rectificationDocuments, String rectificationRequired) {
        casesPage.checkRectificationDetails(rectificationDocuments, rectificationRequired);
    }

    @And("click on Yes button on Acknowledgment Confirmation popup")
    public void clickOnYesButtonOnAcknowledgmentConfirmationPopup() throws InterruptedException {
        casesPage.clickAcknowledgmentConfirmationYesButton();
    }

    @And("open {string} WO fill the checklist for event inspection rework process {string} for {string} and verify WO status as {string}")
    public void openWOFillTheChecklistForEventInspectionReworkProcessForAndVerifyWOStatusAs(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkListPage.fillChecklistForEventPermitCWD5Rework(status, checkListName, checkListType, completeStatus);
    }

    @And("open {string} work order with filter Incident Type")
    public void openWorkOrderWithFilterIncidentType(String checkListName) throws InterruptedException {
        casesPage.openWorkOrderForReInspection(checkListName);
    }

    @And("click on create reinspection button")
    public void clickOnCreateReinspectionButton() {
        casesPage.createReInspectionWorkOrder();
    }

    @And("click on OK button on Result Dialog")
    public void clickOnOKButtonOnResultDialog() {
        casesPage.clickResultDialogOkButton();
    }

    @And("click on Save&Close button")
    public void clickOnSaveCloseButton() {
        commonActions.clickOnSaveNCloseBtn();
    }
}
