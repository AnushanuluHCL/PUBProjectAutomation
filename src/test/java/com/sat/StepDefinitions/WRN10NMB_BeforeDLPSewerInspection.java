package com.sat.StepDefinitions;

import com.sat.Pages.checkListCreationPage;
import com.sat.Pages.originalCaseCreationPage;
import com.sat.Pages.projectCreationPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WRN10NMB_BeforeDLPSewerInspection {

    private projectCreationPage projectPage = new projectCreationPage(TestBase.getDriver());
    private checkListCreationPage checkListPage = new checkListCreationPage(TestBase.getDriver());
    private originalCaseCreationPage casesPage = new originalCaseCreationPage(TestBase.getDriver());

    @And("create a manual Public Sewer where Entity Type as {string}")
    public void createAManualPublicSewerWhereEntityTypeAs(String entityType) throws InterruptedException {
        projectPage.createManualPublicSewer(entityType);
    }

    @And("open {string} WO fill the checklist for before DLP {string} for {string} and verify WO status as {string}")
    public void openWOFillTheChecklistForBeforeDLPForAndVerifyWOStatusAs(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkListPage.fillChecklistForBeforeDLPSewerInspectionWRN10IMB(status, checkListName, checkListType, completeStatus);
    }

    @When("search and open the Public Sewer")
    public void searchAndOpenThePublicSewer() throws InterruptedException {
        projectPage.searchPublicSewer();
    }

    @And("navigate to Inspection stage select the Inspection completed and submit SO review as yes")
    public void navigateToInspectionStageSelectTheInspectionCompletedAndSubmitSOReviewAsYes() {
        casesPage.completeInspectionStageWithSOReview();
    }

    @And("navigate to GenerateEmail stage and fill the respective details for M&C Letter and navigate to next stage")
    public void navigateToGenerateEmailStageAndFillTheRespectiveDetailsForMCLetterAndNavigateToNextStage() {
        casesPage.completeGenerateEmailStageWithMnCLetter();

    }

    @And("click on Generate IO and NIO Letter button")
    public void clickOnGenerateIOAndNIOLetterButton() {
        casesPage.clickGenerateIONIOLetter();
    }

    @And("click on Okay button on Generate IO and NIO Letter pop up")
    public void clickOnOkayButtonOnGenerateIOAndNIOLetterPopUp() {
        casesPage.clickGenerateIONIOLetterPopUpOkayButton();
    }

    @And("enter Commissioning Letter issued date")
    public void enterCommissioningLetterIssuedDate() {
        casesPage.commissioningLetterIssuedDate();
    }

    @And("click on OK button")
    public void clickOnOKButton() {
        casesPage.clickOKButton();
    }
}
