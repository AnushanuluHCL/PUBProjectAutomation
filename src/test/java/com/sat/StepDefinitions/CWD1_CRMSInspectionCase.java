package com.sat.StepDefinitions;

import com.sat.Pages.checkListCreationPage;
import com.sat.Pages.commonCRMActions;
import com.sat.Pages.crmsCaseCreationPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class CWD1_CRMSInspectionCase {

    private crmsCaseCreationPage crmsCase = new crmsCaseCreationPage(TestBase.getDriver());
    private originalCaseCreationPage casesPage = new originalCaseCreationPage(TestBase.getDriver());
    private commonCRMActions crmActions = new commonCRMActions(TestBase.getDriver());
    private checkListCreationPage checkListPage = new checkListCreationPage(TestBase.getDriver());

    @And("create a CRMS Case using excel")
    public void createACRMSCaseUsingExcel() throws IOException {
        crmsCase.createCRMSCaseCWD1();
    }

    @And("import CRMS Case")
    public void importCRMSCase() throws InterruptedException {
        crmsCase.importIMBExcelForCWD1();
    }

    @And("verify CRMS Case is created in the system and open it")
    public void verifyCRMSCaseIsCreatedInTheSystemAndOpenIt() throws InterruptedException {
        crmsCase.verifyCRMSCaseCreated();
    }

    @And("user selects {string} list view, search and open the CRMS case")
    public void userSelectsListViewSearchAndOpenTheCRMSCase(String listView) throws InterruptedException {
        crmsCase.searchAndOpenCRMSCase(listView);
    }

    @And("{string} the CRMS Case")
    public void theCRMSCase(String crmsCaseAction) throws InterruptedException {
        crmsCase.selectAcceptOrRejectCRMSCase(crmsCaseAction);
    }

    @Then("verify SIES case status as {string}")
    public void verifySIESCaseStatus(String crmsCaseStatus) throws InterruptedException {
        crmsCase.checkCRMDetails(crmsCaseStatus);
    }

    @Then("verify warning message {string} when more then one notification present")
    public void verifyWarningMessageWhenMoreThenOneNotificationPresent(String warningMessage) throws InterruptedException {
        crmsCase.verifyCRMSCaseWarningMessage(warningMessage);
    }

    @And("click on Save and continue button on unsaved changes popup")
    public void clickOnSaveAndContinueButtonOnUnsavedChangesPopup() throws InterruptedException {
        crmActions.clickSaveNContinueBtn();
    }

    @And("change the Entity value in the CRMSCase")
    public void changeTheEntityValueInTheCRMSCase() throws InterruptedException {
        crmsCase.updateEntityValue();
    }

    @And("enter Landmark and Secondary FIO field as {string} in the CRMSCase")
    public void enterLandmarkAndSecondaryFIOFieldAsInTheCRMSCase(String secondaryFioUser) throws InterruptedException {
        crmsCase.enterLandmarkValue();
        crmsCase.enterSecondaryFioValue(secondaryFioUser);
        crmActions.clickOnSaveButton();
    }

    @And("open {string} WO fill the checklist for Surveillance Checklist {string} for {string} and verify WO status as {string}")
    public void openWOFillTheChecklistForSurveillanceChecklistForAndVerifyWOStatusAs(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkListPage.fillChecklistForSurveillanceChecklistCWD1(status, checkListName, checkListType, completeStatus);
    }

    @And("complete the CRMS Closure Details")
    public void completeTheCRMSClosureDetails() throws InterruptedException {
        crmsCase.completeCRMSClosureDetails();
    }

    @And("click on {string} button on Work Order")
    public void clickOnButtonOnWorkOrder(String approveNRejectButton) throws InterruptedException {
        crmsCase.approveAndRejectWO(approveNRejectButton);
    }

    @Then("verify User Assessment are marked as {string}")
    public void verifyUserAssessmentAreMarkedAs(String value) throws InterruptedException {
        crmActions.checkUserAssessment(value);
    }
}
