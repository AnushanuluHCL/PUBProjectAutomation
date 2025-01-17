package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.sat.locators.ConstructionLocatorsPage;
import com.sat.locators.WAApplicationLocatorsPage;
import com.sat.locators.pumpingMainStationLocatorsPage;

public class pumpingMainStationsPage extends commonActionsPage {

	ConstructionLocatorsPage constructionpage = new ConstructionLocatorsPage(driver);
	commonCRMActions commonCRM = new commonCRMActions(driver);
	pumpingMainStationLocatorsPage pumpingStation = new pumpingMainStationLocatorsPage(driver);
	WAApplicationLocatorsPage waapp = new WAApplicationLocatorsPage(driver);

	public pumpingMainStationsPage(WebDriver driver) {
		super(driver);
	}

	public void entityCreation(String entityVal, String catchmentValue) {
		clickonNewBtn();
		pumpingStation.entityTypeselection(entityVal);
		pumpingStation.entityName();
		pumpingStation.pumpingStationId();
		waapp.catchment(catchmentValue);
		pumpingStation.selectMonth(eleUtil.getNextMonthName());
		clickOnSaveBtn();
	}

	public void chamberCreation(int numberOfRecords) throws InterruptedException {
		navigatingToTabInEntity("Chambers");
		for (int i = 1; i <= numberOfRecords; i++) {
			pumpingStation.clickonNewBtnInChamber();
			pumpingStation.chamberID();
			pumpingStation.chamberName();
			clickOnSaveBtn();
			clickOnSaveNCloseBtn();
		}
		clickOnSaveNCloseBtn();
		
	}
	public void verifyWRN7NMBCaseCreated() throws InterruptedException {
		changeAreaSelection("Inspection");
		selectEntity("Cases");
		changeView("All Cases");
		constructionpage.entitySelectionInCaseView();
		filterView(commonActionsPage.WRN7NMB_Projname);
		clickOnApplyBtn();
		constructionpage.caseCreationCheck(commonActionsPage.WRN7NMB_Projname);
	}
	public void fillChecklistWRN7IMB(String complainceVal) throws InterruptedException {
		pumpingStation.fillCheckListQuestionsForWRN7IMB(complainceVal);
	}
	
}
