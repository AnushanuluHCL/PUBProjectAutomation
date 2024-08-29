package com.sat.Pages;

import com.sat.locators.factoryPage;
import org.openqa.selenium.WebDriver;

public class factoryCreationPage extends CommonActionsPage{
    public factoryCreationPage(WebDriver driver) {
        super(driver);
    }

    factoryPage factory = new factoryPage(driver);
    commonCRMActions crmActions = new commonCRMActions(driver);

    public void createFactory() {
        clickonNewBtn();
        factory.selectEntityType();
        factory.selectCatchment();
        factory.enterEntityName();
        clickOnSaveBtn();
    }

    public void verifyFactoryStatus(String status) {
        clickOnRefrehBtn();
        factory.getStatusReason(status);
    }

    public void navigateToServiceTab() {
        clickOnRefrehBtn();
        crmActions.navigatingToTabFactory("Services");
    }

    public void verifyCaseCreatedWithStatus(String schedule) throws InterruptedException {
        factory.caseVerification();
        factory.verifyCaseStatus(schedule);
    }

    public void verifyCaseNotification() throws InterruptedException {
        factory.caseNotification();
    }

    public void verifyWorkOrderCreatedWithStatus(String schedule) throws InterruptedException {
        factory.workOrderVerification();
        factory.verifyWorkOrderStatus(schedule);
    }

    public void verifyWorkOrderNotification() throws InterruptedException {
        factory.workOrderNotification();
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
        crmActions.navigatingToTabFactory(tab);
    }

    public void verifyEmail(String emailSubject) throws InterruptedException {
        crmActions.emailCheck(emailSubject);
    }

    public void openLabReport() throws InterruptedException {
        factory.openLabReportPopUp();
    }

    public void uploadWQReport() throws InterruptedException {
        factory.uploadWQReportInPubLab();
    }

    public void checkPubReport() throws InterruptedException {
        factory.pubReportIsUploadAndCheckData();
    }

    public void clickUploadLabReportSwitch() {
        factory.clickOnUploadLabReportSwitch();
    }

    public void verifySystemAndUserAssessment() throws InterruptedException {
        factory.checkSystemAndUserAssessment();
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

    public void verifyCaseStatus(String status) throws InterruptedException {
        factory.clickOnSavingInProgressOkButton();
        factory.checkCaseStatus(status);
    }

}
