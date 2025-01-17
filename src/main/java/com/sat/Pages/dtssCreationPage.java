package com.sat.Pages;

import com.sat.locators.dtssPage;
import com.sat.locators.factoryPage;
import org.openqa.selenium.WebDriver;

public class dtssCreationPage extends commonActionsPage{

    public dtssCreationPage(WebDriver driver) {
        super(driver);
    }

    factoryPage factory = new factoryPage(driver);
    dtssPage dtss = new dtssPage(driver);
    commonCRMActions crmActions = new commonCRMActions(driver);

    public void createDTSS(String selectEntityType) {
        clickonNewBtn();
        dtss.changeListView();
        factory.selectEntityType(selectEntityType);
        dtss.enterDTSSID();
        clickOnSaveBtn();
    }

    public void createDTSSShaft(String tab, String shaftType) throws InterruptedException {
        crmActions.navigateToTab(tab);
        dtss.clickDTSSShaftButton();
        dtss.enterDTSSShaft(shaftType);
        clickOnSaveNCloseBtn();
    }

    public void veryCaseCount(int caseCountAfterJob) {
        dtss.checkCaseCount(caseCountAfterJob);
    }

    public void searchAndOpenDTSS() throws InterruptedException {
        dtss.searchADTSS();
    }

    public void clickOnForwardButton() {
        dtss.forwardButton();
    }

    public void OpenACaseInDTSS(String caseSubType) {
        dtss.caseInDTSS(caseSubType);
    }
}
