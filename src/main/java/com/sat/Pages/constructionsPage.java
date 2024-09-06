package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sat.locators.ConstructionLocatorsPage;
import com.sat.locators.WRN1CaseLocatorsPage;
import com.sat.locators.factoryPage;
import com.sat.testUtil.Log;
import com.sat.testbase.TestBase;

public class constructionsPage extends commonActionsPage {
	String path = "\\src\\test\\resources\\testdata\\8NMB_ConstructionCreation.xlsx";

	public constructionsPage(WebDriver driver) {
		super(driver);
	}

	ConstructionLocatorsPage constructionpage = new ConstructionLocatorsPage(driver);
	commonCRMActions commonCRM = new commonCRMActions(driver);
	factoryPage factory = new factoryPage(driver);

	public void updateDataIntoExcel(String project_title) {
		constructionpage.updateExcelForConstructioncreation(project_title);

	}

	public void importExcelData() throws InterruptedException {
		importExcel(path);
	}

	public void verifyProjCraetionCheck() {
		constructionpage.datachecking();
		openProject();
	}

	public void openProject() {
		factory.entitySelectionInFactoryView();
		filterView(commonActionsPage.WRN8NMB_Projname);
		selectFirstRecord();
		getFirstRecord();
	}

	public void verifyEmailAtProject(String tab, String subject) throws InterruptedException {
		commonCRM.navigatingToTabInProject(tab);
		commonCRM.emailCheckAtProject(subject);
	}

	public void updateMukimLotValues(String tab, String mukimValue, String lotValue) {
		commonCRM.navigatingToTabInProject(tab);
		constructionpage.mukimVal(mukimValue);
		constructionpage.lotVal(lotValue);
		clickOnSaveBtn();
	}

	public void GERIResponse(String tab, String projMukimLotvalue, String diameterValue, String DTSSValue, String SewerValue) {
		commonCRM.navigatingToTabInProject(tab);
		constructionpage.newGERIResponseBtn();
		constructionpage.projMukimLotNo(projMukimLotvalue);
		constructionpage.diameterVal(diameterValue);
		constructionpage.affectedByDTSSVal(DTSSValue);
		constructionpage.affectedBySewerVal(SewerValue);
		clickonSaveAndCloseBtn();
		eleUtil.isPageLoaded(50);
		clickonSaveAndCloseBtn();
	}
	public void verifyProjectInShortListView() {
		factory.entitySelectionInFactoryView();
		filterView(commonActionsPage.WRN8NMB_Projname);
		constructionpage.compareProjValue();
	}
}
