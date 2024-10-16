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
    public void fillChecklistForWRN6IMB(String complainceStatus, String allWorkComplete, String value) throws InterruptedException{
        checkList.fillCheckListQuestionsForWRN6IMB(complainceStatus, allWorkComplete, value);
    }
    public void performAmendmentFor6IMB(String WOType, String complainceStatus, String allWorkComplete, String value) throws InterruptedException {
    	checkList.amendChecklistFor6IMB(WOType,  complainceStatus,  allWorkComplete,  value);
    }
    public void fillChecklistforWRN1TEF() throws InterruptedException {
    	checkList.fillCheckListQuestionsForWRN1TEF();
    }

	public void fillChecklistWRN8NMB() throws InterruptedException {
		checkList.fillCheckListQuestionsForWRN8NMB();
	}

}
