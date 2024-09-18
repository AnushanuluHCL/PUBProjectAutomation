package com.sat.Pages;

import com.sat.locators.casePage;
import com.sat.locators.checkListPage;
import com.sat.locators.factoryPage;
import org.openqa.selenium.WebDriver;

public class checkListCreationPage extends commonActionsPage {

    public checkListCreationPage(WebDriver driver) {
        super(driver);
    }

    casePage cases = new casePage(driver);
    commonCRMActions crmActions = new commonCRMActions(driver);
    caseCreationPage caseCreation = new caseCreationPage(driver);
    factoryPage factory = new factoryPage(driver);
    checkListPage checkList = new checkListPage(driver);


    public void fillChecklistForWRN8IMB(String status, String checklistType, String checkListName) throws InterruptedException {
        checkList.fillCheckListForWRN8IMB(status, checklistType, checkListName);
    }
}
