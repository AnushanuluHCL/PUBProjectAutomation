package com.sat.Pages;

import com.sat.locators.casePage;
import com.sat.locators.factoryPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

public class factoryCreationPage extends commonActionsPage {
	public factoryCreationPage(WebDriver driver) {
		super(driver);
	}

	factoryPage factory = new factoryPage(driver);
	commonCRMActions crmActions = new commonCRMActions(driver);
	casePage cases = new casePage(driver);

	// String WQPath = "\\src\\test\\resources\\testdata\\SIT_WQ 2 3 1 2.xlsx";
	// String tefFilePath ="\\src\\test\\resources\\testdata\\WQ_Sample_NC.xlsx";
	String tefFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata/WQ_Sample_NC.xlsx";

	// String filePath = System.getProperty("user.dir");

	public void createFactory() {
		clickonNewBtn();
		factory.selectEntityType("Factory");
		factory.selectCatchment();
		factory.enterEntityName("Factory");
		clickOnSaveBtn();
	}

	public void verifyFactoryStatus(String status) {
		clickOnRefreshBtn();
		factory.getStatusReason(status);
	}

	public void navigateToServiceTab(String tabName) {
		clickOnRefreshBtn();
		crmActions.navigateToTab(tabName);
	}

	public void verifyCaseCreatedWithStatus(String schedule) throws InterruptedException {
		factory.caseVerification("DQB/TE/I");
		factory.verifyCaseStatus(schedule);
	}

	public void verifyCaseNotification(String tabName) throws InterruptedException {
		factory.caseNotification(tabName);
	}

	public void verifyWorkOrderCreatedWithStatus(String schedule) throws InterruptedException {
		factory.workOrderVerification();
		factory.verifyWorkOrderStatus(schedule);
	}

	public void verifyWorkOrderNotification(String tabName) throws InterruptedException {
		factory.workOrderNotification(tabName);
	}

	public void fillChecklist() throws InterruptedException {
		factory.fillCheckListQuestions();
	}

	public void openCurrentCase() {
		factory.openCase();
	}

	public void verifyWRN2Details() throws InterruptedException {
		factory.wrn2Details();
	}

	public void navigateToTab(String tab) {
		crmActions.navigateToTab(tab);
	}

	public void verifyEmail(String emailSubject) throws InterruptedException {
		crmActions.emailCheck(emailSubject);
	}

	public void openLabReport() throws InterruptedException {
		factory.openLabReportPopUp();
	}

	public void uploadWQReport() throws InterruptedException {
		String WQPath ="\\src\\test\\resources\\testdata\\SIT_WQ 2 3 1 2.xlsx";
		factory.uploadReportInPubLab(WQPath);
	}

	public void checkPubReport() throws InterruptedException {
		factory.pubReportIsUploadAndCheckData();
	}

	public void clickUploadLabReportSwitch() {
		factory.clickOnUploadLabReportSwitch();
	}

	public void verifySystemAndUserAssessment(String value) throws InterruptedException {
		crmActions.checkSystemAndUserAssessment(value);
	}

	public void verifyNotificationForLabReport() throws InterruptedException {
		factory.labResultNotification();
	}

	public void approveFactory() throws InterruptedException {
		factory.selectListOfAdHocFactory();
		factory.searchFactory();
		factory.approveFactory();
	}

	public void verifyFactoryApprovalNotification() throws InterruptedException {
		factory.factoryApprovalNotification();
	}

	public void verifyApprovalNotification() throws InterruptedException {
		factory.approvalNotification();
	}

	public void verifyApprovalChildCaseNotification() throws InterruptedException {
		factory.approvalChildNotification();
	}

	public void verifyCaseStatus(String status) throws InterruptedException {
		crmActions.clickOnSavingInProgressOkButton();
		cases.checkCaseStatus(status);
	}

	public void verifyWAStatus(String status) {
		navigatingToTab("Inspection Case Information");
		clickOnEntityOnCaseForm();
		factory.WAStatusVal(status);
	}

	public void verifyWANumberStatus(String tradeGrp, String fpeVal, String WAnumVal) {
		factory.entitySelectionInFactoryView();
		filterView(commonActionsPage.WRN1_factoryname);
		// filterView("Testcomp270824081515");
		selectFirstRecord();
		getFirstRecord();
		factory.tradeGrpVal(tradeGrp);
		factory.fpeVal(fpeVal);
		factory.WANumberVal(WAnumVal);
		clickOnSaveNCloseBtn();
	}

	public void uploadTEFReport(String tefFilePath) throws InterruptedException {
		tefFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\WQ_Sample_NC.xlsx";
		factory.uploadReportInPubLabtef(tefFilePath);
		System.out.println(" uploadTEFReport from calling page : " + tefFilePath);
	}

	public void verifyUploadedLabReport() throws InterruptedException {
		factory.pubReportIsUploadInHeavyMetalTab();
	}

}
