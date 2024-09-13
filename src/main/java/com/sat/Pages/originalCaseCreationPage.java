package com.sat.Pages;

import com.sat.locators.casePage;
import com.sat.locators.factoryPage;
import org.openqa.selenium.WebDriver;

public class originalCaseCreationPage extends commonActionsPage{
    public originalCaseCreationPage(WebDriver driver) {
        super(driver);
    }

    casePage cases = new casePage(driver);
    commonCRMActions crmActions = new commonCRMActions(driver);
    caseCreationPage caseCreation = new caseCreationPage(driver);
    factoryPage factory = new factoryPage(driver);

    public void createWRNCase(String wrpCatchment, String alertSource) throws InterruptedException {
        clickonNewBtn();
        //cases.enableWRPSubType();
        cases.caseCreationForWRP(wrpCatchment, alertSource);
        clickOnSaveBtn();
    }

    public void verifyWRNCase(String wrpCatchment, String alertSource) throws InterruptedException {
        cases.checkCaseCreationForWRP(wrpCatchment, alertSource);
    }

    public void verifyWorkOrderCreated() throws InterruptedException {
        cases.checkWorkOrderCreated();
    }

    public void searchAndOpenCase(String listView) throws InterruptedException {
        cases.selectListOfActiveCases(listView);
        caseCreation.searchACase();
    }

    public void workOrderCountAfterSplit() {
        cases.workOrderCount();
    }

    public void verifyChildCase() throws InterruptedException {
        cases.childCaseVerification();
        cases.openChildCaseOrCase();
    }

    public void verifyChildCaseWorkOrder() throws InterruptedException {
        cases.childCaseWorkOrderVerification();
    }

    public void verifyNotificationForChildCaseAndWorkOrder() throws InterruptedException {
        cases.childCaseNotification();
        cases.childCaseWorkOrderNotification();
    }

    public void navigateToParentCase() {
        clickonSaveAndCloseBtn();
    }

    public void applyWorkOrderStatusFilter(String status) throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
    }

    public void fillChecklistForMHWRP(String status, String checkListName, String level) throws InterruptedException {
        cases.fillCheckListForMHWRP(status, checkListName, level);
    }

    public void waitForWorkOrder(int time) throws InterruptedException {
        cases.hardWaitForWorkOrder(time);
        clickOnRefreshBtn();
    }

    public void verifyScenario1(String riskCategory, String catchment) {
        cases.checkScenario1(riskCategory, catchment);
    }

    public void verifyWorkOrderCountAfterL2(int workOrderCountL2) {
        cases.checkWorkOrderCountAfterL2(workOrderCountL2);
    }

    public void verifyParentIdNotBlank() throws InterruptedException {
        cases.checkParentIdNotBlank();
    }

    public void verifyCaseBusinessFunction(String wrn3) {
        cases.checkCaseBusinessFunction(wrn3);
    }

    public void verifyChildCaseSubType(String caseSubType) {
        cases.checkChildCaseSubType(caseSubType);
    }

    public void verifyTimeDurationAndStartTime(String durationTime) throws InterruptedException {
        cases.checkTimeDurationAndStartTime(durationTime);
    }

    public void pumpingSystemChecklist(String status, String checkListName, String systemAssessment) throws InterruptedException {
        cases.fillCheckListForPumpingSystem(status, checkListName, systemAssessment);
    }

    public void verifyLastInspectedOn() throws InterruptedException {
        cases.checkLastInspectedOn();
    }

    public void wrn9AOReviewStage(String recurrence, String frequency) throws InterruptedException {
        cases.completeWRN9AOReviewStage(recurrence, frequency);
        factory.clickOnSavingInProgressOkButton();
    }

    public void verifyNextBookingDate(int days) throws InterruptedException {
        cases.checkNextBookingDate(days);
    }

    public void wrn9ResolveCaseStage(String resolveCase) throws InterruptedException {
        cases.CompleteWRN9ResolveCaseStage(resolveCase);
    }

    public void verifyRecurrenceMessage(String recurrenceMessage) {
        cases.checkRecurrenceMessage(recurrenceMessage);
    }

    public void refreshRecordPage() {
        clickOnRefreshBtn();
    }

    public void createManualBooking(String status) throws InterruptedException {
        crmActions.openWOCreateManualBooking(status);
    }

    public void verifyWorkOrderNotification(String tabName) throws InterruptedException {
        cases.checkWorkOrderNotification(tabName);
    }

    public void fillChecklist(String status, String checklistType, String checkListName) throws InterruptedException {
        cases.fillCheckListForWRN11AuditInspection(status, checklistType, checkListName);
    }

    public void verifyCaseNotification(String tabName) throws InterruptedException {
        cases.checkCaseNotification(tabName);
    }

    public void completeSOReviewForWRN11() throws InterruptedException {
        cases.soReviewForWRN11();
    }

    public void clickInOrderNNotInOrderButton() {
        cases.inOrderNNotInOrderButton();
    }

    public void verifyDocument(String subjectName) throws InterruptedException {
        crmActions.documentCheck(subjectName);
    }

    public void navigateToTab(String tab) {
        crmActions.navigateToTab(tab);
    }

    public void completeSOReviewForWRN11ReInspection() {
        cases.soReviewForWRN11ReInspection();
    }

    public void createManualWOWRN11() {
        cases.manualWOWRN11();
    }
}