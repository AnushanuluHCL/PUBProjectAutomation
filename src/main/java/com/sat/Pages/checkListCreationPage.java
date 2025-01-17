package com.sat.Pages;

import com.sat.locators.checkListPage;
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
	public void fillTheChecklistquestionsWRN5(String outcome) throws InterruptedException {
		checkList.fillTheChecklistQuestions(outcome);
	}
	public void amendChecklistForWRN5() {
		checkList.amendChecklist();
	}

    public void fillChecklistForWRN10(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkList.checkListForWRN10IMBDLP(status, checkListName, checkListType, completeStatus);
    }

    public void fillChecklistForWRN10Abandonment(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkList.checkListForWRN10IMBAbandonment(status, checkListName, checkListType, completeStatus);
    }

    public void fillChecklistForEventPermitCWD5(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkList.checkListForEventPermitCWD5(status, checkListName, checkListType, completeStatus);
    }

    public void fillChecklistForEventPermitCWD5Rework(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkList.checkListForEventPermitCWD5Rework(status, checkListName, checkListType, completeStatus);
    }

    public void fillChecklistForVesselInspectionCWD5(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkList.checkListForVesselInspectionCWD5(status, checkListName, checkListType, completeStatus);
    }

    public void fillChecklistForSurveillanceChecklistCWD1(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkList.checkListForSurveillanceChecklistCWD1(status, checkListName, checkListType, completeStatus);
    }

    public void fillChecklistForECMSetupNDrainageWorkChecklistCWD2(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkList.checkListForECMSetupNDrainageWorkChecklistCWD2(status, checkListName, checkListType, completeStatus);
    }

    public void fillChecklistForRawWaterMainPipelineChecklistCWD4(String status, String checkListName, String checkListType, String completeStatus) throws InterruptedException {
        checkList.checkListForRawWaterMainPipelineChecklistCWD4(status, checkListName, checkListType, completeStatus);
    }
}
