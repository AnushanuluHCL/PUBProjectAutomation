package com.sat.Pages;

import com.sat.locators.casePage;
import com.sat.locators.checkListPage;
import com.sat.locators.factoryPage;
import org.openqa.selenium.WebDriver;

public class checkListCreationPage extends commonActionsPage {

    public checkListCreationPage(WebDriver driver) {
        super(driver);
    }

    checkListPage checkList = new checkListPage(driver);


    public void fillChecklistForWRN8IMB(String status, String checklistType, String checkListName) throws InterruptedException {
        checkList.checkListForWRN8IMB(status, checklistType, checkListName);
    }

    public void fillChecklistForWRN7IMBCombingPhoto(String status, String checklistType, String checkListName) throws InterruptedException {
        checkList.checkListForWRN7NMBCombingPhoto(status, checklistType, checkListName);
    }

    public void fillChecklistForWRN7IMBCombingVirtual(String status, String checklistType, String checkListName) throws InterruptedException {
        checkList.checkListForWRN7NMBCombingVirtual(status, checklistType, checkListName);
    }

    public void fillChecklistForWRN7IMBShaftInspection(String status, String checklistType, String checkListName) throws InterruptedException {
        checkList.checkListForWRN7NMBShaftInspection(status, checklistType, checkListName);
    }

}
