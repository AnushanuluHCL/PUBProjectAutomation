package com.sat.StepDefinitions;

import com.sat.Pages.*;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class CWD3N6_InspectionCase {

    private crmsCaseCreationPage crmsCase = new crmsCaseCreationPage(TestBase.getDriver());
    private checkListCreationPage checkListPage = new checkListCreationPage(TestBase.getDriver());
    private originalCaseCreationPage casesPage = new originalCaseCreationPage(TestBase.getDriver());
    private projectCreationPage projectPage = new projectCreationPage(TestBase.getDriver());
    private PowerAppsAutomateFlowPage powerapppage = new PowerAppsAutomateFlowPage(TestBase.getDriver());

    @And("create a CRMS Case for C&W-Drainage Ops- Pollution in waterways algae in waterways using excel")
    public void createACRMSCaseForCWDrainageOpsPollutionInWaterwaysAlgaeInWaterwaysUsingExcel() throws IOException {
        crmsCase.createCRMSCaseCWD3N6();
    }

    @And("import CRMS Case for C&W-Drainage Ops")
    public void importCRMSCaseForCWDrainageOps() throws InterruptedException {
        crmsCase.importIMBExcelForCWD3N6();
    }

    @And("open {string} WO fill the checklist for Discharge into Waterways Checklist {string} for {string} and verify WO status as {string}")
    public void openWOFillTheChecklistForDischargeIntoWaterwaysChecklistForAndVerifyWOStatusAs(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkListPage.fillChecklistForDischargeIntoWaterwaysChecklistCWD3N6(status, checkListName, checkListType, completeStatus);
    }

    @And("select User Assessment as {string} and Enter Deviation Remarks")
    public void selectUserAssessmentAsAndEnterDeviationRemarks(String userAssessment) {
        crmsCase.UserAssessmentNDeviationRemark(userAssessment);
    }

    @And("upload compliance lab report")
    public void uploadComplianceLabReport() throws InterruptedException {
        crmsCase.labReportPopUpForCWD3N6();
        crmsCase.uploadPUBLabReport();
    }

    @Then("verify System Assessment in lab report result as {string}")
    public void verifySystemAssessmentInLabReportResultAs(String systemAssessment) {
        crmsCase.checkSystemAssessmentInLabReportResult(systemAssessment);
    }

    @And("navigate to SO Review stage fill Approve and Resolve Case and navigate to next stage")
    public void navigateToSOReviewStageFillApproveAndResolveCaseAndNavigateToNextStage() {
        casesPage.completeSOReviewForCWD3N6();
    }

    @And("create an manual Premises where Entity Type as {string}")
    public void createAnManualPremisesWhereEntityTypeAs(String entryType) throws InterruptedException {
        projectPage.createManualPremisesForNonIndustrialPremises(entryType);
    }

    @And("open {string} WO fill the checklist for Premises Inspection Checklist {string} for {string} and verify WO status as {string}")
    public void openWOFillTheChecklistForPremisesInspectionChecklistForAndVerifyWOStatusAs(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkListPage.fillChecklistForPremisesInspectionChecklistCWD3N6(status, checkListName, checkListType, completeStatus);
    }

    @And("refresh the browser")
    public void refreshTheBrowser() {
        powerapppage.setRefresh();
    }
}
