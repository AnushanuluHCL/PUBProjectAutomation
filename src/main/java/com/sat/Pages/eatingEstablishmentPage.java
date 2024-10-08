package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.sat.locators.ConstructionLocatorsPage;
import com.sat.locators.eatingEstablishmentLocatorsPage;
import com.sat.locators.factoryPage;
import com.sat.locators.pumpingSystemPage;
import com.sat.testUtil.Log;

public class eatingEstablishmentPage extends commonActionsPage {
	String path = "\\src\\test\\resources\\testdata\\8NMB_ConstructionCreation.xlsx";

	public eatingEstablishmentPage(WebDriver driver) {
		super(driver);
	}

	ConstructionLocatorsPage constructionpage = new ConstructionLocatorsPage(driver);
	commonCRMActions commonCRM = new commonCRMActions(driver);
	factoryPage factory = new factoryPage(driver);
	pumpingSystemPage pumpingSystem = new pumpingSystemPage(driver);
	eatingEstablishmentLocatorsPage eepage = new eatingEstablishmentLocatorsPage(driver);

	public void createmEatingEstablishment(String entityType, String countOfGts) throws InterruptedException {
		clickonNewBtn();
		pumpingSystem.selectEntityType(entityType);
		pumpingSystem.enterProjectReferenceNumber();
		eepage.enterContactEmail();
		eepage.enterPrimaryContact();
		factory.selectCatchment();
		eepage.enterNoOfGts(countOfGts);
		pumpingSystem.enterHouseBlkNumber();
		eepage.enterLevelNumber();
		eepage.enterUnitNumber();
		pumpingSystem.enterPostalCode();
		pumpingSystem.enterRoadName();
		eepage.enterSFALicenceNumber();
		commonActionsPage.WRN6NMB_Enttiyval=eleUtil.doGetElementAttributeLog(pumpingSystem.getProjectReferenceNumber(), "title", "Displayed value is : ");
		clickOnSaveBtn();
	}
	
	
}