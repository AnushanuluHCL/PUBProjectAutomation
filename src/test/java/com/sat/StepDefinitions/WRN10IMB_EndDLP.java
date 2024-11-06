package com.sat.StepDefinitions;

import com.sat.Pages.checkListCreationPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.Pages.pumpingSystemCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.*;

public class WRN10IMB_EndDLP {
    private pumpingSystemCreationPage pumpingSystem = new pumpingSystemCreationPage(TestBase.getDriver());
    private originalCaseCreationPage casePage = new originalCaseCreationPage(TestBase.getDriver());
    private checkListCreationPage checkListPage = new checkListCreationPage(TestBase.getDriver());

    @And("create a manual Pumping Mains where Entity Type as {string}")
    public void createAManualPumpingMainsWhereEntityTypeAs(String entityType) throws InterruptedException {
        pumpingSystem.createPumpingMain(entityType);
    }

    @And("create a manual case of Case sub type as {string}")
    public void createAManualCaseOfCaseSubTypeAs(String caseSubType) throws InterruptedException {
        casePage.createPumpingMainCase(caseSubType);
    }

    @Then("verify Work Order created on Case record")
    public void verifyWorkOrderCreatedOnCaseRecord() throws InterruptedException {
        casePage.verifyWorkOrderVerificationOnCase();
    }

    @And("open {string} WO fill the checklist for {string} for {string} and verify WO status as {string}")
    public void openWOFillTheChecklistForForAndVerifyWOStatusAs(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkListPage.fillChecklistForWRN10(status, checkListName, checkListType, completeStatus);
    }

        @Then("get and verify the count of Work Orders for Pressure Test and Commissioning Test should be {int}")
    public void getAndVerifyTheCountOfWorkOrdersForPressureTestAndCommissioningTestShouldBe(int woCount) throws InterruptedException {
        casePage.workOrderCountAfterSplitForWRN10(woCount);
        casePage.verifyWorkOrderCountAfterL2(woCount);
    }
}
