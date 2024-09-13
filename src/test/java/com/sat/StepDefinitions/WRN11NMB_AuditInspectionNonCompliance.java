package com.sat.StepDefinitions;

import com.sat.Pages.commonCRMActions;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.Pages.projectCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.*;

import java.io.IOException;

public class WRN11NMB_AuditInspectionNonCompliance {

    private projectCreationPage projectPage = new projectCreationPage(TestBase.getDriver());
    private commonCRMActions crmAction = new commonCRMActions(TestBase.getDriver());
    private originalCaseCreationPage casePage = new originalCaseCreationPage(TestBase.getDriver());

    @And("create a Project with Account Sub Type as {string}")
    public void createAProjectWithAccountSubTypeAs(String accountSubType) throws IOException, InterruptedException {
        projectPage.createProject(accountSubType);
    }

    @Then("verify Project is created and open the Project")
    public void verifyProjectIsCreatedAndOpenTheProject() throws InterruptedException {
        projectPage.verifyProjectCreated();
    }

    @And("enter BPU Officers field in the Project and save the record")
    public void enterBPUOfficersFieldInTheProjectAndSaveTheRecord() throws InterruptedException {
        projectPage.enterBPUOfficerAndSave();
    }

    @And("create a BPU Submissions for the Project with Account Sub Type as {string}")
    public void createABPUSubmissionsForTheProjectWithAccountSubTypeAs(String accountSubType) throws IOException, InterruptedException {
        projectPage.createBPUSubmission(accountSubType);
    }

    @And("open {string} tab in {string}")
    public void openTabIn(String tabName, String entityName) {
        crmAction.navigateToTabWithEntity(tabName, entityName);
    }

    @Then("verify BPU Submission is created and associated with the Project")
    public void verifyBPUSubmissionIsCreatedAndAssociatedWithTheProject() throws InterruptedException {
        projectPage.verifyBPUSubmissionCreated();
    }

    @And("open BPU Submission and enter Qualified Person field")
    public void openBPUSubmissionAndEnterQualifiedPersonField() throws InterruptedException {
        projectPage.enterQualifiedPersonAndSave();
    }

    @Then("verify Case created")
    public void verifyCaseCreated() throws InterruptedException {
        projectPage.verifyCaseCreated();
    }

    @Then("verify Case created and verify Case notification")
    public void verifyCaseCreatedAndVerifyCaseNotification() throws InterruptedException {
        projectPage.verifyCaseCreated();
    }

    @Then("verify Work Order created")
    public void verifyWorkOrderCreated() throws InterruptedException {
        projectPage.verifyWorkOrderCreated();
    }

    @And("open {string} WO and create the manual Booking")
    public void openWOAndCreateTheManualBooking(String status) throws InterruptedException {
        casePage.createManualBooking(status);
    }

    @Then("verify Work Order notification in {string} tab")
    public void verifyWorkOrderNotificationInTab(String tabName) throws InterruptedException {
        casePage.verifyWorkOrderNotification(tabName);
    }

    @And("open {string} WO and fill the {string} checklist for {string}")
    public void openWOAndFillTheChecklistFor(String status, String checklistType, String checkListName) throws InterruptedException {
        casePage.fillChecklist(status, checklistType, checkListName);
    }

    @Then("verify Case notification in {string} tab")
    public void verifyCaseNotificationInTab(String tabName) throws InterruptedException {
        casePage.verifyCaseNotification(tabName);
    }

    @And("navigate to SO Review stage fill the respective details and navigate to next stage")
    public void navigateToSOReviewStageFillTheRespectiveDetailsAndNavigateToNextStage() throws InterruptedException {
        casePage.completeSOReviewForWRN11();
    }

    @And("click on Generate Letter button")
    public void clickOnGenerateLetterButton() {
        casePage.clickInOrderNNotInOrderButton();
    }

    @Then("go to {string} and verify the Document for {string}")
    public void goToAndVerifyTheDocumentFor(String tab, String document) throws InterruptedException {
        casePage.navigateToTab(tab);
        casePage.verifyDocument(document);
    }

    @And("SO send case for Re-inspection")
    public void soSendCaseForReInspection() {
        casePage.completeSOReviewForWRN11ReInspection();
    }

    @And("create manual Work Order")
    public void createManualWorkOrder() {
        casePage.createManualWOWRN11();
    }

}
