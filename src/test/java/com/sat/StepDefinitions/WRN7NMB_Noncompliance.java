package com.sat.StepDefinitions;

import com.sat.Pages.*;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WRN7NMB_Noncompliance {

    private checkListCreationPage checkListPage = new checkListCreationPage(TestBase.getDriver());
    private dtssCreationPage dtssPage = new dtssCreationPage(TestBase.getDriver());

    @And("create a DTSS with entity type {string}")
    public void createADTSSWithEntityType(String selectEntityType) {
        dtssPage.createDTSS(selectEntityType);
    }

    @And("go to {string} tab and create a DTSS Shafts with type {string}")
    public void goToTabAndCreateADTSSShaftsWithType(String tab, String shaftType) throws InterruptedException {
        dtssPage.createDTSSShaft(tab ,shaftType);
    }

    @Then("verify {int} cases are created.")
    public void verifyCasesAreCreated(int caseCount) {
        dtssPage.veryCaseCount(caseCount);
    }

    @And("search and open the DTSS")
    public void searchAndOpenTheDTSS() throws InterruptedException {
        dtssPage.searchAndOpenDTSS();
    }

    @And("click on next icon page")
    public void clickOnNextIconPage() {
        dtssPage.clickOnForwardButton();
    }

    @And("open {string} case")
    public void openCase(String caseSubType) {
        dtssPage.OpenACaseInDTSS(caseSubType);
    }

    @And("open {string} WO and fill the {string} checklist for DTSS Combing Photo {string}")
    public void openWOAndFillTheChecklistForDTSSCombingPhoto(String status, String checklistType, String checkListName) throws InterruptedException {
        checkListPage.fillChecklistForWRN7IMBCombingPhoto(status, checklistType, checkListName);
    }

    @And("open {string} WO and fill the {string} checklist for DTSS Combing virtual {string}")
    public void openWOAndFillTheChecklistForDTSSCombingVirtual(String status, String checklistType, String checkListName) throws InterruptedException {
        checkListPage.fillChecklistForWRN7IMBCombingVirtual(status, checklistType, checkListName);
    }
}
