package com.sat.StepDefinitions;

import com.sat.Pages.originalCaseCreationPage;
import com.sat.Pages.pumpingSystemCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.*;

public class WRN10IMB_EndDLP {
    private pumpingSystemCreationPage pumpingSystem = new pumpingSystemCreationPage(TestBase.getDriver());
    private originalCaseCreationPage casePage = new originalCaseCreationPage(TestBase.getDriver());

    @And("create a manual Pumping Mains where Entity Type as {string}")
    public void createAManualPumpingMainsWhereEntityTypeAs(String entityType) throws InterruptedException {
        pumpingSystem.createPumpingMain(entityType);
    }

    @And("create a manual case of Case sub type as {string}")
    public void createAManualCaseOfCaseSubTypeAs(String caseSubType) throws InterruptedException {
        casePage.createPumpingMainCase(caseSubType);
    }
}
