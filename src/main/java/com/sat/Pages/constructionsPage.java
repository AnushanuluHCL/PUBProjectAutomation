package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;

import com.sat.locators.ConstructionLocatorsPage;
import com.sat.locators.factoryPage;

public class constructionsPage extends commonActionsPage {
	String path = "\\src\\test\\resources\\testdata\\8NMB_ConstructionCreation.xlsx";

	public constructionsPage(WebDriver driver) {
		super(driver);
	}

	ConstructionLocatorsPage constructionpage = new ConstructionLocatorsPage(driver);
	commonCRMActions commonCRM = new commonCRMActions(driver);
	factoryPage factory = new factoryPage(driver);

	public void updateDataIntoExcel(String project_title) {
		constructionpage.updateExcelForConstructionCreation(project_title);
	}

	public void importExcelData() throws InterruptedException {
		importExcel(path);
	}

	public void verifyProjCreationCheck() {
		constructionpage.dataChecking();
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

	public void GERIResponse(String tab, String projMukimLotValue, String diameterValue, String DTSSValue, String sewerValue, String pumpingMain) {
		commonCRM.navigatingToTabInProject(tab);
		constructionpage.newGERIResponseBtn();
		constructionpage.projMukimLotNo(projMukimLotValue);
		constructionpage.diameterVal(diameterValue);
		constructionpage.affectedByDTSSVal(DTSSValue);
		constructionpage.affectedBySewerVal(sewerValue);
		constructionpage.affectedByPumpingMain(pumpingMain);
		clickonSaveAndCloseBtn();
		clickOnSaveBtn();
		clickonSaveAndCloseBtn();
	}
	public void searchForAProject() {
		factory.entitySelectionInFactoryView();
		filterView(commonActionsPage.WRN8NMB_Projname);
	}
	public void verifyProjectInShortListView() {
		constructionpage.compareProjValue();
	}
	public void approveProject() throws InterruptedException {
		constructionpage.approveProj();
	}
	public void verifyCaseCreated() {
		changeAreaSelection("Inspection");
		selectEntity("Cases");
		constructionpage.entitySelectionInCaseView();
		filterView(commonActionsPage.WRN8NMB_Projname);
		constructionpage.caseCreationCheck(commonActionsPage.WRN8NMB_Projname);
	}
	public void fillChecklistWRN8NMB() throws InterruptedException {
		constructionpage.fillCheckListQuestionsForWRN8NMB();
	}
	public void POWSapprovalNotification() throws InterruptedException {
		// CommonActionsPage.casenumber= getCaseNumber();
		eleUtil.isPageLoaded(60);
		commonCRM.notificationForTabToOpenCase(commonActionsPage.casenumber, "Inspection Case Information");
	}
	
	public void updateReInspectionDate() throws ParseException {
		navigatingToTab("Inspection Case Information");
		clickOnEntityOnCaseForm();
		commonCRM.navigatingToTabInProject("System related information");
		constructionpage.verifyReInspectionValue();
		constructionpage.verifyReInspectionDate();
		constructionpage.updateReInspectionDateVal();
		clickOnSaveBtn();
	}
	public void verifyTypeOFWO(String type) {
		constructionpage.verifyNewWoType(type);
	}

	public void createWRN8IMBProject(String projectTitle) throws IOException {
		constructionpage.updateExcelConstructionWRN8IMB(projectTitle);
	}

	public void importIMBExcel() throws InterruptedException {
		constructionpage.importWRN8IMBExcelData();
	}

	public void verifyWRN8IMBProjectCreated() throws InterruptedException {
		constructionpage.checkWRN8IMBProjectCreated();
	}

	public void updateContractorValues(String tab) throws InterruptedException {
		commonCRM.navigatingToTabInProject(tab);
		constructionpage.enterContractor();
	}

	public void GERIResponseForIMB(String tab, String projMukimLotValue, String diameterValue, String DTSSValue, String sewerValue, String pumpingMain) {
		commonCRM.navigatingToTabInProject(tab);
		constructionpage.newGERIResponseBtn();
		constructionpage.projMukimLotNo(projMukimLotValue);
		constructionpage.diameterVal(diameterValue);
		constructionpage.affectedByDTSSVal(DTSSValue);
		constructionpage.affectedBySewerVal(sewerValue);
		constructionpage.affectedByPumpingMain(pumpingMain);
		clickonSaveAndCloseBtn();
		clickOnSaveBtn();
	}

	public void verifyCaseCreatedInProject() throws InterruptedException {
		constructionpage.checkCaseCreated();
	}

	public void saveCaseRecord() {
		clickOnSaveBtn();
	}
}
