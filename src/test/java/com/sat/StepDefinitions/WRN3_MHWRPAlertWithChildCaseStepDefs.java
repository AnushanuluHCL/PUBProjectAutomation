package com.sat.StepDefinitions;

import com.sat.Pages.LoginPage;
import com.sat.Pages.factoryCreationPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.*;

public class WRN3_MHWRPAlertWithChildCaseStepDefs {

    private originalCaseCreationPage casePage = new originalCaseCreationPage(TestBase.getDriver());
    private LoginPage loginpage = new LoginPage(TestBase.getDriver());
    private factoryCreationPage factoryPage = new factoryCreationPage(TestBase.getDriver());

    @And("create a manual case for WRP catchment as {string} and alert source as {string}")
    public void createAManualCaseForWRPCatchmentAsAndAlertSourceAs(String wrpCatchment, String alertSource) throws InterruptedException {
        casePage.createWRNCase(wrpCatchment, alertSource);
    }

    @Then("verify catchment as {string} and entity as {string}, factory list and Manhole list is auto-populated")
    public void verifyCatchmentAsAndEntityAsFactoryListAndManholeListIsAutoPopulated(String wrpCatchment, String alertSource) throws InterruptedException {
        casePage.verifyWRNCase(wrpCatchment, alertSource);
    }

    @Then("verify work orders are created")
    public void verifyWorkOrdersAreCreated() throws InterruptedException {
        casePage.verifyWorkOrderCreated();
    }

    @Then("verify whether case is created and open child Case")
    public void verifyWhetherCaseIsCreatedAndOpenChildCase() throws InterruptedException {
        casePage.verifyChildCase();
    }

    @Then("verify the new child cases are created for {string} Risk Factories under {string} catchment.")
    public void verifyTheNewChildCasesAreCreatedForRiskFactoriesUnderCatchment(String riskCategory, String catchment) {
        casePage.verifyScenario1(riskCategory, catchment);
    }

    @Then("verify whether child case work order are created")
    public void verifyWhetherChildCaseWorkOrderAreCreated() throws InterruptedException {
        casePage.verifyChildCaseWorkOrder();
    }

    @And("user selects {string} list view, search and open the case")
    public void userSelectsListViewSearchAndOpenTheCase(String listView) throws InterruptedException {
        casePage.searchAndOpenCase(listView);
    }

    @Then("Verify FIO receives alert notification for child case and work order.")
    public void verifyFIOReceivesAlertNotificationForChildCaseAndWorkOrder() throws InterruptedException {
        casePage.verifyNotificationForChildCaseAndWorkOrder();
    }

    @And("navigate back to parent case")
    public void navigateBackToParentCase() {
        casePage.navigateToParentCase();
    }

    @And("get the count of Work Orders")
    public void getTheCountOfWorkOrders() {
        casePage.workOrderCountAfterSplit();
    }

    @And("apply {string} filter in work order")
    public void applyFilterInWorkOrder(String status) throws InterruptedException {
        casePage.applyWorkOrderStatusFilter(status);
    }

    @And("open {string} WO and make one work order as Non-Compliance and others as a Compliance for {string} and {string}")
    public void openWOAndMakeOneWorkOrderAsNonComplianceAndOthersAsAComplianceForAnd(String status, String checkListName, String level)
            throws InterruptedException {
        casePage.fillChecklistForMHWRP(status, checkListName, level);
    }

    @And("wait for {int} milliseconds so all the work order are processed and then click on refresh button")
    public void waitForMillisecondsSoAllTheWorkOrderAreProcessedAndThenClickOnRefreshButton(int time) throws InterruptedException {
        casePage.waitForWorkOrder(time);
    }

    @And("open {string} WO and make one work order as a Compliance for {string} and {string}")
    public void openWOAndMakeOneWorkOrderAsAComplianceForAnd(String status, String checkListName, String level)
            throws InterruptedException {
        casePage.fillChecklistForMHWRP(status, checkListName, level);
    }

    @Then("verify count of work order should be {int}")
    public void verifyCountOfWorkOrderShouldBe(int workOrderCount) {
        casePage.verifyWorkOrderCountAfterL2(workOrderCount);
    }

    @Then("verify Abnormality In Chamber and Abnormality in Oil Interceptor fields")
    public void verifyAbnormalityInChamberAndAbnormalityInOilInterceptorFields() throws InterruptedException {
        factoryPage.verifyWRN2Details();
    }

    @Then("verify Parent Case ID is not blank")
    public void verifyParentCaseIDIsNotBlank() throws InterruptedException {
        casePage.verifyParentIdNotBlank();
    }

    @Then("new child case gets created under the {string} parent case.")
    public void newChildCaseGetsCreatedUnderTheParentCase(String wrn3) {
        casePage.verifyCaseBusinessFunction(wrn3);
    }

    @Then("verify Case sub type is {string}.")
    public void verifyCaseSubTypeIs(String caseSubType) {
        casePage.verifyChildCaseSubType(caseSubType);
    }

    @Then("verify booking duration is {string} and start time is current time and end time is two hrs later")
    public void verifyBookingDurationIsAndStartTimeIsCurrentTimeAndEndTimeIsTwoHrsLater(String durationTime) throws InterruptedException {
        casePage.verifyTimeDurationAndStartTime(durationTime);
    }

}
