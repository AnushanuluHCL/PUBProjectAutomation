package com.sat.StepDefinitions;

import com.sat.Pages.caseCreationPage;
import com.sat.Pages.loginPage;
import com.sat.Pages.commonCRMActions;
import com.sat.Pages.factoryCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.*;

public class WRN2_AdHocaFactoryNonComplainceStepDefs {

    private factoryCreationPage factoryPage = new factoryCreationPage(TestBase.getDriver());
    private commonCRMActions crmActions = new commonCRMActions(TestBase.getDriver());
    private caseCreationPage casepage = new caseCreationPage(TestBase.getDriver());
    private loginPage loginpage = new loginPage(TestBase.getDriver());

    @And("create a new Ad hoc factory")
    public void createANewAdHocFactory() {
        factoryPage.createFactory();
    }

    @And("verify factory is created with {string} status reason")
    public void verifyFactoryIsCreatedWithNewStatusReason(String status) {
        factoryPage.verifyFactoryStatus(status);
    }

    @Then("verify in service tab Case created with status {string} and verify Case notification")
    public void verifyInServiceTabCaseCreatedWithStatusAndVerifyCaseNotification(String schedule) throws InterruptedException {
        factoryPage.navigateToServiceTab();
        factoryPage.verifyCaseCreatedWithStatus(schedule);
        factoryPage.verifyCaseNotification();
    }

    @Then("verify in service tab Work Order created with status {string} and verify Work Order notification")
    public void verifyInServiceTabWorkOrderCreatedWithStatusAndVerifyWorkOrderNotification(String schedule) throws InterruptedException {
        factoryPage.verifyWorkOrderCreatedWithStatus(schedule);
        factoryPage.verifyWorkOrderNotification();
    }

    @And("open {string} WO and fill the Booking details and select {string} status")
    public void openWOAndFillTheBookingDetailsAndSelectStatus(String status, String selectBookingStatus) throws InterruptedException  {
        crmActions.fillBookingDetails(status, selectBookingStatus);
    }

    @And("go to Checklist tab create sample for lab analysis details with and fill the required checklist")
    public void goToChecklistTabCreateSampleForLabAnalysisDetailsWithAndFillTheRequiredChecklist() throws InterruptedException {
        factoryPage.fillChecklist();
    }

    @Then("go to Cases and verify Abnormality In Chamber and Abnormality in Oil Interceptor fields")
    public void goToCasesAndVerifyAbnormalityInChamberAndAbnormalityInOilInterceptorFields() throws InterruptedException {
        factoryPage.openCurrentCase();
        factoryPage.verifyWRN2Details();
    }

    @Then("go to {string} and verify the email for {string}")
    public void goToAndVerifyTheEmailFor(String tab, String subject) throws InterruptedException {
        factoryPage.navigateToTab(tab);
        factoryPage.verifyEmail(subject);
    }

    @And("go to {string} and upload WQ lab report in Prohibited Organic Heavy Metal Compounds section")
    public void goToAndUploadWQLabReportInProhibitedOrganicHeavyMetalCompoundsSection(String tab) throws InterruptedException {
        factoryPage.navigateToTab(tab);
        factoryPage.openLabReport();
        factoryPage.uploadWQReport();
    }

    @Then("Verify the sum of heavy metal count and system assessment as Non-Compliance")
    public void verifyTheSumOfHeavyMetalCountAndSystemAssessmentAsNonCompliance() throws InterruptedException {
        factoryPage.checkPubReport();
    }

    @And("upload lab report")
    public void uploadLabReport() {
        factoryPage.clickUploadLabReportSwitch();
    }

    @Then("verify System Assessment and User Assessment are marked as {string}")
    public void verifySystemAssessmentAndUserAssessmentAreMarkedAs(String value) throws InterruptedException {
        factoryPage.verifySystemAndUserAssessment(value);
    }

    @Then("go to {string} and verify the email for Request for {string} and {string}")
    public void goToAndVerifyTheEmailForRequestForAnd(String tab, String email1, String email2) throws InterruptedException {
        factoryPage.navigateToTab(tab);
        factoryPage.verifyEmail(email1);
        factoryPage.verifyEmail(email2);
    }

    @Then("verify notification for lab result")
    public void verifyNotificationForLabResult() throws InterruptedException {
        factoryPage.verifyNotificationForLabReport();
    }

    @And("open the above created factory and Approve")
    public void openTheAboveCreatedFactoryAndApprove() throws InterruptedException {
        factoryPage.approveFactory();
    }

    @Then("verify the status reason is {string}")
    public void verifyTheStatusReasonIs(String status) {
        factoryPage.verifyFactoryStatus(status);
    }

    @Then("verify notification for factory added to AO")
    public void verifyNotificationForFactoryAddedToAO() throws InterruptedException {
        factoryPage.verifyFactoryApprovalNotification();
    }

    @And("Validate that AO or SO get notified by Case")
    public void validateThatAOOrSOGetNotifiedByCase() throws InterruptedException {
        factoryPage.verifyApprovalNotification();
    }

    @And("navigate to AO Review stage and fill the details and navigate to next stage")
    public void navigateToAOReviewStageAndFillTheDetailsAndNavigateToNextStage() throws InterruptedException {
        casepage.completeAOReviewStage();
    }

    @Then("verify case is {string} and in read only mode")
    public void verifyCaseIsAndInReadOnlyMode(String status) throws InterruptedException {
        factoryPage.verifyCaseStatus(status);
        loginpage.signoutApp();
    }


}
