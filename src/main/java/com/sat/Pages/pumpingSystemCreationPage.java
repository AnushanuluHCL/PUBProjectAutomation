package com.sat.Pages;

import com.sat.locators.ConstructionLocatorsPage;
import com.sat.locators.eatingEstablishmentLocatorsPage;
import com.sat.locators.factoryPage;
import com.sat.locators.pumpingSystemPage;
import org.openqa.selenium.WebDriver;

public class pumpingSystemCreationPage extends commonActionsPage {
    public pumpingSystemCreationPage(WebDriver driver) {
        super(driver);
    }

    commonCRMActions crmActions = new commonCRMActions(driver);
    pumpingSystemPage pumpingSystem = new pumpingSystemPage(driver);
    ConstructionLocatorsPage constructionPage = new ConstructionLocatorsPage(driver);
    factoryPage factory = new factoryPage(driver);
    eatingEstablishmentLocatorsPage eePage = new eatingEstablishmentLocatorsPage(driver);

    public void createPumpingSystem(String entityType) throws InterruptedException {
        clickonNewBtn();
        pumpingSystem.selectEntityType(entityType);
        pumpingSystem.enterProjectReferenceNumber();
        pumpingSystem.enterProjectTitle();
        pumpingSystem.enterHouseBlkNumber();
        pumpingSystem.enterPostalCode();
        pumpingSystem.enterRoadName();
        pumpingSystem.enterContractor();
        commonActionsPage.pumpingMain=eleUtil.doGetElementAttributeLog(pumpingSystem.getProjectReferenceNumber(), "title", "Displayed value is : ");
        clickOnSaveBtn();
    }

    public void createBPUSubmission(String submissionType) throws InterruptedException {
        pumpingSystem.clickBPUSubmissionButton();
        pumpingSystem.enterSubmissionNo();
        pumpingSystem.selectSubmissionType(submissionType);
        pumpingSystem.selectInspectionRequired();
        pumpingSystem.enterBPDOfficer();
        pumpingSystem.enterMESystem();
        pumpingSystem.selectPumpedSystem();
        pumpingSystem.enterQualifiedPerson();
        clickOnSaveBtn();
    }

    public void verifySubmissionDate() throws InterruptedException {
        pumpingSystem.checkSubmissionDate();
    }

    public void navigateToTabName(String tabName) {
        crmActions.navigateToTab(tabName);
    }

    public void clickCases() {
        pumpingSystem.clickRelatedCase();
    }

    public void verifyCaseStatus(String status) {
        pumpingSystem.checkCaseStatus(status);
    }

    public void createPumpingMain(String entityType) throws InterruptedException {
        clickonNewBtn();
        pumpingSystem.selectEntityType(entityType);
        pumpingSystem.enterProjectReferenceNumber();
        constructionPage.enterArchitect();
        constructionPage.enterProfEngg();
        factory.selectCatchment();
        pumpingSystem.enterHouseBlkNumber();
        pumpingSystem.enterPostalCode();
        pumpingSystem.enterRoadName();
        commonActionsPage.pumpingMain=eleUtil.doGetElementAttributeLog(pumpingSystem.getProjectReferenceNumber(), "title", "Displayed value is : ");
        clickOnSaveBtn();
    }

    public void searchPumpingMain() throws InterruptedException {
        pumpingSystem.searchAPumpingMain();
    }

}