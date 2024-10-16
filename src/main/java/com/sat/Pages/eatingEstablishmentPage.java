package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.sat.constants.AppConstants;
import com.sat.locators.ConstructionLocatorsPage;
import com.sat.locators.WAApplicationLocatorsPage;
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
	commonActionsPage common= new commonActionsPage(driver);
	commonCRMActions commonCRM = new commonCRMActions(driver);
	factoryPage factory = new factoryPage(driver);
	pumpingSystemPage pumpingSystem = new pumpingSystemPage(driver);
	eatingEstablishmentLocatorsPage eepage = new eatingEstablishmentLocatorsPage(driver);
	WAApplicationLocatorsPage waappPage = new WAApplicationLocatorsPage(driver);

	public void createmEatingEstablishment(String entityType, String countOfGts) {
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
	public void getCaseIdAfterEEIdCreation() throws InterruptedException {
		boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 150000) {
			try {
				eleUtil.waitForVisibilityOfElement(eepage.clickRefreshBtnOnHome(), 10);
				eleUtil.doClickLog(eepage.clickRefreshBtnOnHome(), "clicked on refresh button");
				eleUtil.waitForVisibilityOfElement(eepage.getEEId(), AppConstants.SHORT_DEFAULT_WAIT);
				String eeidval=eleUtil.doGetElementAttributeLog(eepage.getEEId(), "value", "Value is : ");
				Log.info("Retrieved EE ID value: '" + eeidval + "'");
				if (!eeidval.equalsIgnoreCase("---")) {
					flag = true;
				}
			} catch (Exception e) {
				Log.error("EE number is not generated. So clicking on refresh button again");
			}
		}
		commonCRM.navigateToTab("Inspection Cases");
		factory.caseVerification("DQB/GT/I");
	}
	public void getTheGTsCountFromEntity() {
		commonCRM.navigatingToTabInProject("GT Details");
		eepage.clickRefreshBtnOnHome();
		String totalWOs = eepage.getTheCreatedGTsCount();
		common.WRN4_GTscount = totalWOs.substring(9, 10);
		Log.info("Total Number of WOs created is :"+common.WRN4_GTscount); 
	}
	
}
