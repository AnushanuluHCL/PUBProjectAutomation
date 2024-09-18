package com.sat.StepDefinitions;

import com.sat.Pages.caseCreationPage;
import com.sat.Pages.checkListCreationPage;
import com.sat.Pages.constructionsPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.*;

import java.io.IOException;

public class WRN8IMB_Noncompliance_ReInspection {

    private constructionsPage constructPage = new constructionsPage(TestBase.getDriver());
    private originalCaseCreationPage casePage = new originalCaseCreationPage(TestBase.getDriver());
    private checkListCreationPage checkListPage = new checkListCreationPage(TestBase.getDriver());
    private caseCreationPage casepage = new caseCreationPage(TestBase.getDriver());

    @And("create Project with title as {string}")
    public void createProjectWithTitleAs(String projectTitle) throws IOException {
        constructPage.createWRN8IMBProject(projectTitle);
    }

    @And("import IMB data")
    public void importWRNIMBData() throws InterruptedException {
        constructPage.importIMBExcel();
    }

    @And("verify record is created in the system and open it")
    public void verifyRecordIsCreatedInTheSystemAndOpenIt() throws InterruptedException {
        constructPage.verifyWRN8IMBProjectCreated();
    }

    @Then("go to {string} tab and update the Contractor")
    public void goToTabAndUpdateTheContractor(String tabName) throws InterruptedException {
        constructPage.updateContractorValues(tabName);
    }

    @And("go to {string} tab and update the {string},{string},{string}, {string} and {string} GERI response values")
    public void goToTabAndUpdateTheAndGERIResponseValues(String tab, String projMukimLotValue,
                                                         String diameterValue, String DTSSValue, String sewerValue, String pumpingMain) {
        constructPage.GERIResponse(tab, projMukimLotValue, diameterValue, DTSSValue, sewerValue, pumpingMain);
    }

    @And("go to {string} tab and update the {string},{string},{string}, {string} and {string} GERI response values for IMB")
    public void goToTabAndUpdateTheAndGERIResponseValuesForIMB(String tab, String projMukimLotValue, String diameterValue, String DTSSValue, String sewerValue, String pumpingMain) {
        constructPage.GERIResponseForIMB(tab, projMukimLotValue, diameterValue, DTSSValue, sewerValue, pumpingMain);
    }

    @Then("verify Case created in Project")
    public void verifyCaseCreatedInProject() throws InterruptedException {
        constructPage.verifyCaseCreatedInProject();
    }

    @And("save the Case")
    public void saveTheCase() {
        constructPage.saveCaseRecord();
    }

    @And("open {string} WO and fill the {string} checklist for BCA Project {string}")
    public void openWOAndFillTheChecklistForBCAProject(String status, String checklistType, String checkListName) throws InterruptedException {
        checkListPage.fillChecklistForWRN8IMB(status, checklistType, checkListName);
    }

    @And("navigate to AO Review stage and fill the respective details")
    public void navigateToAOReviewStageAndFillTheRespectiveDetails() {
        casepage.completeAOReviewStage();
    }
}
