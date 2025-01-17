package com.sat.Pages;

import com.sat.locators.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class originalCaseCreationPage extends commonActionsPage {
	public originalCaseCreationPage(WebDriver driver) {
		super(driver);
	}

	casePage cases = new casePage(driver);
	commonCRMActions crmActions = new commonCRMActions(driver);
	commonActionsPage common= new commonActionsPage(driver);
	caseCreationPage caseCreation = new caseCreationPage(driver);
	factoryPage factory = new factoryPage(driver);

	public void createWRNCase(String wrpCatchment, String alertSource) throws InterruptedException {
		clickonNewBtn();
		// cases.enableWRPSubType();
		cases.caseCreationForWRP(wrpCatchment, alertSource);
		Thread.sleep(2000);
		clickOnSaveBtn();
	}

	public void verifyWRNCase(String wrpCatchment, String alertSource) throws InterruptedException {
		cases.checkCaseCreationForWRP(wrpCatchment, alertSource);
	}

	public void verifyWorkOrderCreated() throws InterruptedException {
		cases.checkWorkOrderCreated();
	}

	public void searchAndOpenCase(String listView) throws InterruptedException {
		cases.selectCasesListView(listView);
		caseCreation.searchACase();
	}

	public void searchAndOpenChildCase(String listView) throws InterruptedException {
		cases.selectCasesListView(listView);
		caseCreation.searchChildCase();
	}

	public void workOrderCountAfterSplit() {
		cases.workOrderCount();
	}

	public void verifyChildCase(String childCaseRefNumber) throws InterruptedException {
		cases.childCaseVerification(childCaseRefNumber);
		cases.openChildCaseOrCase();
	}

	public void verifyChildCaseWorkOrder() throws InterruptedException {
		cases.childCaseWorkOrderVerification();
	}

	public void verifyNotificationForChildCase() throws InterruptedException {
		cases.childCaseNotification();
	}

	public void verifyNotificationForChildCaseWorkOrder() throws InterruptedException {
		cases.childCaseWorkOrderNotification();
	}

	public void navigateToParentCase() {
		clickOnSaveNCloseBtn();
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

	public void pumpingSystemChecklist(String status, String checkListName, String systemAssessment)
			throws InterruptedException {
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

	public void createManualWO(String workOrderType) {
		cases.manualWOCreation(workOrderType);
	}

	public void clickHydroTestLowPressureAirTest() {
		cases.hydroTestLowPressureAirTest();
	}

	public void completeReInspectionForWRN11() throws InterruptedException {
		cases.reInspectionForWRN11();
	}

	public void completeSOReviewForWRN7NMB(String soValue) throws InterruptedException {
		cases.soReviewForWRN7NMB(soValue);
		factory.clickOnSavingInProgressOkButton();
	}

	public void verifyRecurringWOCreation() {
		cases.verifyWOType();
	}

	public void rejectWO(String WOstatus) {
		navigatingToTab("Work Orders");
		cases.rejectingWO(WOstatus);
		clickOnSaveBtn();
	}
	
	public void acceptWO(String WOstatus) {
		navigatingToTab("Work Orders");
		cases.acceptingWO(WOstatus);
		clickOnSaveBtn();
	}

	public void verifyNewBooking(String bookingStatus, String WOStatus) throws InterruptedException {
		cases.verifyNewBookingCreated(bookingStatus, WOStatus);
	}

	public void updateDeviationRemarks() {
		cases.updateSystemAssesmentVal();
		cases.updateDeviationRemarks();
		clickOnSaveBtn();
	}
	public void verifyIfNewCaseCreated() {
		cases.newCaseCheck();
	}
	public void verifyWOsCount() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		crmActions.getMoreButtonOnWorkOrder();
		crmActions.getWorkOrderGridRefresh();
		String countFromCasepage=cases.getTheNoOfWOs();
		Assert.assertEquals(countFromCasepage, common.WRN4_GTscount ,"Count is not matching");
	}

	public void verifyBookingCounts(int bookingCount) {
		cases.checkBookingCount(bookingCount);
	}

	public void createPumpingMainCase(String caseSubType) throws InterruptedException {
		newCaseButton();
		cases.caseCreationForPumpingMain(caseSubType);
		Thread.sleep(2000);
		clickOnSaveBtn();
		cases.waitForCaseFormToSaveNGetCaseNumber();
	}

	public void verifyWorkOrderVerificationOnCase() throws InterruptedException {
		cases.workOrderVerificationOnCase();
	}

	public void workOrderCountAfterSplitForWRN10(int woCount) throws InterruptedException {
		cases.workOrderCountForWRN10(woCount);
	}

	public void completeSOReviewForWRN10IMBDLPPumping(String soValue) throws InterruptedException {
		cases.soReviewForWRN10IMBDLPPumping(soValue);
	}

	public void completeSOReviewForWRN10IMBAbandonmentCase() throws InterruptedException {
		cases.soReviewForWRN10IMBAbandonmentCase();
	}

	public void caseStatusReasonFilter(String caseStatus) throws InterruptedException {
		cases.caseStatusFilter(caseStatus);
		Thread.sleep(3000);
		selectFirstRecord();
		getFirstRecord();
	}

	public void checkCaseCreation(String caseRefNumber) throws InterruptedException {
		factory.caseVerification(caseRefNumber);
	}

	public void completeProcessingStage() {
		navigatingToStage("Processing");
		cases.confirmApplicationDetailsReviewed();
		cases.confirmDocumentsReceived();
		cases.confirmGenerateDraftEventPermit();
	}

	public void clickGeneratePermitLetterYesButton() {
		cases.clickOnGeneratePermitLetterYesButton();
	}

	public void verifyEventPermitWarningMessage(String warningMessage) {
		cases.eventPermitWarningMessage(warningMessage);
	}

	public void clickAcknowledgmentConfirmationYesButton() throws InterruptedException {
		cases.clickOnAcknowledgmentConfirmationYesButton();
	}

	public void selectRectificationDueDate() throws InterruptedException {
		cases.rectificationDueDate();
	}

	public void selectRectificationRequired() {
		cases.rectificationRequired();
	}

	public void createNewFormSG() {
		cases.newFormSG();
	}

	public void selectFormSGApproveAndReject(String buttonName) {
		cases.formSGApproveAndReject(buttonName);
	}

	public void checkRectificationSubmissionStatus(String rectificationStatus) {
		cases.verifyRectificationSubmissionStatus(rectificationStatus);
	}

	public void checkRectificationDetails(String rectificationDocuments, String rectificationRequired) {
		cases.verifyRectificationDetails(rectificationDocuments, rectificationRequired);
	}

	public void openWorkOrderForReInspection(String checkListName) throws InterruptedException {
		cases.openWorkOrder(checkListName);
	}

	public void createReInspectionWorkOrder() {
		cases.clickReInspectionButton();
		cases.createReInspection();
	}

	public void clickResultDialogOkButton() {
		cases.clickOnResultDialogOkButton();
	}

	public void createVesselInspection(String caseSubType, String entityValue) throws InterruptedException {
		newCaseButton();
		cases.enterCaseSubType(caseSubType);
		cases.selectEntityOnCase(entityValue);
		clickOnSaveBtn();
		Thread.sleep(2000);
		cases.waitForCaseFormToSaveNGetCaseNumber();
	}

	public void createReInspectionWorkOrderWithOutReInspectionPopup() {
		cases.clickReInspectionButton();
		cases.waitForReInspectionWorkOrderCreated();
	}

	public void getNStoreCaseNumber() {
		cases.waitForCaseFormToSaveNGetCaseNumber();
	}
}