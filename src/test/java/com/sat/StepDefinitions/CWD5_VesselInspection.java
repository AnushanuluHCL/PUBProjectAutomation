package com.sat.StepDefinitions;

import com.sat.Pages.checkListCreationPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.And;

public class CWD5_VesselInspection {
    private originalCaseCreationPage casesPage = new originalCaseCreationPage(TestBase.getDriver());
    private checkListCreationPage checkListPage = new checkListCreationPage(TestBase.getDriver());

    @And("create a manual case of Case Sub Type as {string} and Entity {string}")
    public void createAManualCaseOfCaseSubTypeAsAndEntity(String caseSubType, String entityValue) throws InterruptedException {
        casesPage.createVesselInspection(caseSubType, entityValue);
    }

    @And("open {string} WO fill the checklist for vessel inspection {string} for {string} and verify WO status as {string}")
    public void openWOFillTheChecklistForVesselInspectionForAndVerifyWOStatusAs(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkListPage.fillChecklistForVesselInspectionCWD5(status, checkListName, checkListType, completeStatus);
    }
}
