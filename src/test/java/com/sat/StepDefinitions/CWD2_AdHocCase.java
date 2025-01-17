package com.sat.StepDefinitions;

import com.sat.Pages.*;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.*;

public class CWD2_AdHocCase {

    private constructionsPage constructPage = new constructionsPage(TestBase.getDriver());
    private commonActionsPage commonActions = new commonActionsPage(TestBase.getDriver());
    private commonCRMActions crmActions = new commonCRMActions(TestBase.getDriver());
    private originalCaseCreationPage casesPage = new originalCaseCreationPage(TestBase.getDriver());
    private checkListCreationPage checkListPage = new checkListCreationPage(TestBase.getDriver());

    @And("create a manual Construction Sites where Entity Type as {string}, Account Sub Type as {string} and Project Title as {string}")
    public void createAManualConstructionSitesWhereEntityTypeAsAccountSubTypeAsAndProjectTitleAs(String entityType, String accountType, String projectTitle)
            throws InterruptedException {
        constructPage.createManualConstruction(entityType, accountType, projectTitle);
    }

    @And("click on new Case button")
    public void clickOnNewCaseButton() {
        commonActions.newCaseButton();
    }

    @And("click on Discard changes button on unsaved changes popup")
    public void clickOnDiscardChangesButtonOnUnsavedChangesPopup() {
        crmActions.clickDiscardChanges();
    }

    @And("click on {string} button on Entity")
    public void clickOnButtonOnEntity(String buttonName) {
        constructPage.approveEntity(buttonName);
    }

    @And("click on Acknowledge button and with the details")
    public void clickOnAcknowledgeButtonAndWithTheDetails() throws InterruptedException {
        crmActions.acknowledgeWorkOrder("dd/MMM/yyyy");
    }

    @And("open {string} WO fill the checklist for ECM Setup and Drainage Work inspection {string} for {string} and verify WO status as {string}")
    public void openWOFillTheChecklistForECMSetupAndDrainageWorkInspectionForAndVerifyWOStatusAs(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkListPage.fillChecklistForECMSetupNDrainageWorkChecklistCWD2(status, checkListName, checkListType, completeStatus);
    }

    @And("select rectification required")
    public void selectRectificationRequired() {
        casesPage.selectRectificationRequired();
    }

    @And("open FormSG form")
    public void openFormSGForm() {
        crmActions.selectFirstRecord();
        crmActions.getFirstRecord();
    }

    @And("click on create reinspection button without create reinspection popup")
    public void clickOnCreateReinspectionButtonWithoutCreateReinspectionPopup() {
        casesPage.createReInspectionWorkOrderWithOutReInspectionPopup();
    }
}
