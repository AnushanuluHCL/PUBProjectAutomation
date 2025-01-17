package com.sat.StepDefinitions;

import com.sat.Pages.checkListCreationPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.*;


public class CWD4_AdHocCase {

    private originalCaseCreationPage casesPage = new originalCaseCreationPage(TestBase.getDriver());
    private checkListCreationPage checkListPage = new checkListCreationPage(TestBase.getDriver());

    @And("store the Case Number")
    public void storeTheCaseNumber() {
        casesPage.getNStoreCaseNumber();
    }

    @And("open {string} WO fill the checklist for Raw Water Main Pipeline inspection {string} for {string} and verify WO status as {string}")
    public void openWOFillTheChecklistForRawWaterMainPipelineInspectionForAndVerifyWOStatusAs(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkListPage.fillChecklistForRawWaterMainPipelineChecklistCWD4(status, checkListName, checkListType, completeStatus);
    }
}
