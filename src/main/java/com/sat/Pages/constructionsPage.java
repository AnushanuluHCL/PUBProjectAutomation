package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;

import com.sat.locators.ConstructionLocatorsPage;
import com.sat.locators.factoryPage;
import com.sat.locators.pumpingSystemPage;

public class constructionsPage extends commonActionsPage {
	String path = "\\src\\test\\resources\\testdata\\8NMB_ConstructionCreation.xlsx";

	public constructionsPage(WebDriver driver) {
		super(driver);
	}

	ConstructionLocatorsPage constructionpage = new ConstructionLocatorsPage(driver);
	commonCRMActions commonCRM = new commonCRMActions(driver);
	factoryPage factory = new factoryPage(driver);
	pumpingSystemPage pumpingSystem = new pumpingSystemPage(driver);

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

	public void updateMukimLotValues(String tab, String mukimValue, String lotValue) throws InterruptedException {
		commonCRM.navigatingToTabInProject(tab);
		constructionpage.mukimVal(mukimValue);
		constructionpage.lotVal(lotValue);
		clickOnSaveBtn();
	}

	public void GERIResponse(String tab, String projMukimLotValue, String diameterValue, String DTSSValue,
			String sewerValue, String pumpingMain) throws InterruptedException {
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


	public void POWSapprovalNotification() throws InterruptedException {
		eleUtil.isPageLoaded(60);
		commonCRM.notificationForTabToOpenCase(commonActionsPage.casenumber, "Inspection Case Information");
	}

	public void updateReInspectionDate() throws ParseException, InterruptedException {
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

	public void GERIResponseForIMB(String tab, String projMukimLotValue, String diameterValue, String DTSSValue,
			String sewerValue, String pumpingMain) throws InterruptedException {
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

	public void createManualProject(String entityType, String accType) throws InterruptedException {
		clickonNewBtn();
		pumpingSystem.selectEntityType(entityType);
		constructionpage.selectAccountSubTypeVal(accType);
		pumpingSystem.enterProjectReferenceNumber();
		pumpingSystem.enterProjectTitle();
		pumpingSystem.enterContractor();
		constructionpage.enterArchitect();
		//constructionpage.enterProfEngg();//Remove when we are executing in SIT1/SIT3
		factory.selectCatchment();
		pumpingSystem.enterHouseBlkNumber();
		pumpingSystem.enterPostalCode();
		pumpingSystem.enterRoadName();
		commonActionsPage.WRN6NMB_Enttiyval=eleUtil.doGetElementAttributeLog(pumpingSystem.getProjectReferenceNumber(), "title", "Displayed value is : ");
		clickOnSaveBtn();
	}

	public void enableAffectedByPumpingMain(String tab, String value) throws InterruptedException {
		commonCRM.navigatingToTabInProject(tab);
		constructionpage.affectedByPumpingMainToggle(value);
		clickOnSaveBtn();
	}

	public void createAPOWSReq(String tab1, String diameterValue, String DCvalue) throws InterruptedException {
		constructionpage.entitySelectionInCaseView();
		filterView(commonActionsPage.WRN6NMB_Enttiyval);
		selectFirstRecord();
		getFirstRecord();
		commonCRM.navigatingToTabInProject(tab1);
		constructionpage.newPOWSSubBtn();
		pumpingSystem.enterSubmissionNo();
		constructionpage.selectApprovalDate();
		constructionpage.diameterVal(diameterValue);
		commonCRM.navigatingToTabInProject("System related information (Hidden)");
		constructionpage.enterSewerPipeType();
		constructionpage.enterSewerDepth();
		constructionpage.enterNearestDistance();
		constructionpage.selectDCStatus(DCvalue);
		constructionpage.selectInspectionDate();
		constructionpage.selectInsScheduleDate();
		constructionpage.selectPOWSApprovedval();
		clickOnSaveBtn();
		clickonSaveAndCloseBtn();
	}

	public void verifyCaseCreatedFor6IMB() {
		changeAreaSelection("Inspection");
		selectEntity("Cases");
		changeView("All Cases");
		constructionpage.entitySelectionInCaseView();
		filterView(commonActionsPage.WRN6NMB_Enttiyval);
		constructionpage.caseCreationCheck(commonActionsPage.WRN6NMB_Enttiyval);
	}
	
	public void openPOWSSubmission(String tabName) throws InterruptedException {
		commonCRM.navigatingToTabInProject(tabName);
		selectFirstRecord();
		getFirstRecord();
	}

	public void createNewPOWSSubCorridor(String corridorType, String zoneType) throws InterruptedException {
		constructionpage.newPOWSSubCorridorBtn();
		constructionpage.enterCorridorType(corridorType);
		constructionpage.enterZoneType(zoneType);
		clickOnSaveBtn();
		clickonSaveAndCloseBtn();
		constructionpage.waitForPOWSContactsTab();
		clickonSaveAndCloseBtn();
	}

	public void checkCaseCreated(String caseNumber) throws InterruptedException {
		factory.caseVerificationInEntity(caseNumber);
	}

	public void createAPOWSReqForWRN6NMB(String tabName, String diameterValue, String DCvalue) throws InterruptedException {
		constructionpage.entitySelectionInCaseView();
		filterView(commonActionsPage.WRN6NMB_Enttiyval);
		selectFirstRecord();
		getFirstRecord();
		commonCRM.navigatingToTabInProject(tabName);
		constructionpage.newPOWSSubBtn();
		pumpingSystem.enterSubmissionNo();
		constructionpage.selectApprovalDate();
		constructionpage.diameterVal(diameterValue);
		constructionpage.setPowsSubApprovalStatus();
		commonCRM.navigatingToTabInProject("System related information (Hidden)");
		constructionpage.enterSewerPipeType();
		constructionpage.enterSewerDepth();
		constructionpage.enterNearestDistance();
		constructionpage.selectDCStatus(DCvalue);
		constructionpage.selectInspectionDate();
		constructionpage.selectInsScheduleDate();
		clickOnSaveBtn();
		constructionpage.waitForPOWSContactsTab();
		clickonSaveAndCloseBtn();
	}
}