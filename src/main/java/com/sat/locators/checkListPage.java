package com.sat.locators;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.testUtil.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class checkListPage extends commonCRMActions {
	public checkListPage(WebDriver driver) {
		super(driver);
	}

	commonCRMActions crmActions = new commonCRMActions(driver);
	commonActionsPage common = new commonActionsPage(driver);
	factoryPage factory = new factoryPage(driver);
	String filePath = System.getProperty("user.dir");
	String pngFilePath = "\\src\\main\\resources\\documents\\PumpingSystemsInspection.png";

	// WRN8IMB
	private By sizeOfPumping = By
			.xpath("//textarea[contains(@aria-label,'What are the size of pumping main based on the SIP?')]");
	private By photo1 = By.xpath("//input[@type='file']");
	private By remark1 = By.xpath("//input[@aria-label='Remarks']");
	private By sewerCorridorZone = By.xpath(
			"//select[contains(@aria-label,'Are there works carried out within the sewer corridor zone or setback zone?')]");
	private By photo2 = By.xpath("//div[@name='Question5'] //input[@type='file']");
	private By remark2 = By.xpath("//div[@name='Question10'] //input[@aria-label='Remarks']");
	private By setbackZoneWithoutPOWS = By.xpath(
			"//select[contains(@aria-label,'Did the site commence an activity within the sewer corridor zone or setback zone without POWS approval?')]");
	private By photo3 = By.xpath("//div[@name='Question6'] //input[@type='file']");
	private By remark3 = By.xpath("//div[@name='Question7'] //input[@aria-label='Remarks']");

	// WRN7NMB_DTSS1 Combing Photo and Shaft Inspection Checklist
	private By projectSiteNonComplianceCombingPhoto = By
			.xpath("//input[contains(@name,'Question11_sq') and @value='Yes']");
	private By detailsObtained = By.xpath("//input[contains(@aria-label,' If yes, state the details obtained')]");
	private By photoForProjectSite = By.xpath("//input[contains(@aria-label,'Take Photo of the project site')]");
	private By ableToAccessCombingPhoto = By.xpath("//input[contains(@name,'Question4_sq') and @value='Yes']");
	private By photoForUpstreamDirection = By
			.xpath("//input[contains(@aria-label,'Photo showing upstream direction')]");
	private By photoForDownstreamDirection = By
			.xpath("//input[contains(@aria-label,'Photo showing downstream direction')]");
	private By photoForShowingShaft = By.xpath("//input[contains(@aria-label,'Photo showing shaft')]");
	private By boltsTightened = By.xpath("//select[contains(@aria-label,'BOLTS/NUTS TIGHTENED?')]");
	private By rustyCover = By.xpath("//select[contains(@aria-label,'RUSTY/CRACK COVER?')]");
	private By roofSlab = By.xpath("//select[contains(@aria-label,'CRACK ON ROOF SLAB?')]");
	private By concreteSlab = By
			.xpath("//select[contains(@aria-label,'HOLES IN SEALANT/BITUMEN LAYER AT CONCRETE SLAB?')]");
	private By manholeCover = By.xpath("//select[contains(@aria-label,'HOLES IN BITUMEN LAYER ON MANHOLE COVER?')]");
	private By odourDetected = By.xpath("//select[contains(@aria-label,'ODOUR DETECTED?')]");

	// WRN7NMB_DTSS Combing virtual checklist for PUB Officer
	private By ltaEMASCCTVCamera = By.xpath("//input[contains(@aria-label,'No. of LTA EMAS CCTV camera viewed')]");
	private By pubCCTVCamera = By.xpath("//input[contains(@aria-label,'No. of PUB CCTV camera viewed')]");
	private By unknownProjectSiteObserved = By.xpath("//input[contains(@name,'Question5_sq') and @value='Yes']");
	private By cameraNumber1 = By.xpath("//input[contains(@aria-label,'Camera Number 1')]");
	private By projectSite = By
			.xpath("//div[@name='Question12'] //input[contains(@aria-label,'Location of project site')]");
	private By screenshotFromCamera = By
			.xpath("//div[@name='Question11'] //input[contains(@aria-label,'Screenshot from the camera')]");

	// WRN7NMB_DTSS1 DTSS1 Shaft Inspection and Gas Reading Checklist for Contractor
	// FIO
	private By ableToAccessShaftInspection = By.xpath("//input[contains(@name,'Question2_sq') and @value='Yes']");
	private By manholeCoverKeyhole = By
			.xpath("//input[contains(@aria-label,'H2S GAS READING AT MANHOLE COVER KEYHOLE')]");
	private By concreteShaftReam = By.xpath("//input[contains(@aria-label,'H2S GAS READING AT CONCRETE SHAFT REAM')]");
	private By projectSiteNonComplianceShaftInspection = By
			.xpath("//input[contains(@name,'Question1_sq') and @value='Yes']");

	// WRN6IMB
	private By physicalActivityCorrectlyStated = By
			.xpath("//select[contains(@aria-label,'physical work activity is correctly stated')]");
	private By PEQPMethodStatement = By.xpath("//select[contains(@aria-label,'PE/QP method statement')]");
	private By anyStructure = By.xpath("//select[contains(@aria-label,'Any structure')]");
	private By anySewageSmell = By.xpath("//select[contains(@aria-label,'Any sewage smell')]");
	private By anyPumpingMainExposed = By.xpath("//select[contains(@aria-label,'Any pumping')]");
	private By markerField = By.xpath("//select[contains(@aria-label,'Marker')]");
	private By worksiteWithin = By.xpath("//select[contains(@aria-label,'work site within')]");
	private By nearingTheStage = By.xpath("//select[contains(@aria-label,'nearing the stage')]");
	private By alWorkComplete = By.xpath("//select[contains(@aria-label,'All Work Complete')]");
	private By remarks = By.xpath("//input[contains(@aria-label,'Remarks')]");

	public void checkListForWRN8IMB(String status, String checklistType, String checkListName)
			throws InterruptedException {
		crmActions.workOrderStatusFilter(status);
		List<String> woNum = new ArrayList<>();
		crmActions.fetchWorkOrderNumbers(woNum);
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), checkListName, status);
			WRN8IMBChecklist(checklistType, checkListName);
			crmActions.saveChecklist();
		}
	}

	public void WRN8IMBChecklist(String checklistType, String checkListName) throws InterruptedException {
		String path = filePath + pngFilePath;
		Log.info("final path to upload " + path);
		if ("Non-Compliance".equals(checklistType)) {
			eleUtil.waitForVisibilityOfElement(sizeOfPumping, 40);
			eleUtil.doSendKeysLog(sizeOfPumping, "100",
					"send value in What are the size of pumping main based on the SIP?");
			uploadFile(photo1, path);
			eleUtil.doSendKeysLog(remark1, "Remarks for size of pumping main based on the SIP",
					"Enter Remark for size of pumping main based on the SIP");

			eleUtil.selectDropDownValue(sewerCorridorZone, "selectByVisibleText", "Yes",
					"select Yes in sewer corridor zone or setback zone?");
			uploadFile(photo2, path);
			eleUtil.doSendKeysLog(remark2, "Remarks for sewer corridor zone or setback zone?",
					"Enter Remark for sewer corridor zone or setback zone?");

			eleUtil.selectDropDownValue(setbackZoneWithoutPOWS, "selectByVisibleText", "Yes",
					"select Yes in sewer corridor zone or setback zone without POWS approval");
			uploadFile(photo3, path);
			eleUtil.doSendKeysLog(remark3, "Remarks for sewer corridor zone or setback zone without POWS approval",
					"Enter Remark for sewer corridor zone or setback zone without POWS approval");

		} else {
			// Write Compliance code
		}
	}

	public void checkListForWRN7NMBCombingPhoto(String status, String checklistType, String checkListName)
			throws InterruptedException {
		crmActions.workOrderStatusFilter(status);
		List<String> woNum = new ArrayList<>();
		crmActions.fetchWorkOrderNumbers(woNum);
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), checkListName, status);
			WRN7NMBCombingPhotoChecklist(checklistType);
			crmActions.saveChecklist();
		}
	}

	public void WRN7NMBCombingPhotoChecklist(String checklistType) throws InterruptedException {
		String path = filePath + pngFilePath;
		Log.info("final path to upload " + path);
		if ("Non-Compliance".equals(checklistType)) {
			eleUtil.waitForVisibilityOfElement(projectSiteNonComplianceCombingPhoto, 30);
			eleUtil.doClickLog(projectSiteNonComplianceCombingPhoto, "Select Yes for Observed unknown project site?");
			eleUtil.doSendKeysLog(detailsObtained, "WRN7 NMBNon-Compliance",
					"send value in If yes, state the details obtained");
			uploadFile(photoForProjectSite, path);
			eleUtil.waitForVisibilityOfElement(ableToAccessCombingPhoto, 30);
			eleUtil.doClickLog(ableToAccessCombingPhoto, "Select Yes for ABLE TO ACCESS?");
			uploadFile(photoForUpstreamDirection, path);
			uploadFile(photoForDownstreamDirection, path);
			uploadFile(photoForShowingShaft, path);
			eleUtil.selectDropDownValue(boltsTightened, "selectByVisibleText", "Yes",
					"Select Yes in BOLTS/NUTS TIGHTENED?");
			eleUtil.selectDropDownValue(rustyCover, "selectByVisibleText", "Yes", "Select Yes in RUSTY/CRACK COVER?");
			eleUtil.selectDropDownValue(roofSlab, "selectByVisibleText", "Yes", "Select Yes in CRACK ON ROOF SLAB?");
			eleUtil.selectDropDownValue(concreteSlab, "selectByVisibleText", "Yes",
					"Select Yes in HOLES IN SEALANT/BITUMEN LAYER AT CONCRETE SLAB?");
			eleUtil.selectDropDownValue(manholeCover, "selectByVisibleText", "Yes",
					"Select Yes in HOLES IN BITUMEN LAYER ON MANHOLE COVER?");
			eleUtil.selectDropDownValue(odourDetected, "selectByVisibleText", "Yes", "Select Yes in ODOUR DETECTED?");

		} else {
			// Write Compliance code
		}
	}

	public void checkListForWRN7NMBCombingVirtual(String status, String checklistType, String checkListName)
			throws InterruptedException {
		crmActions.workOrderStatusFilter(status);
		List<String> woNum = new ArrayList<>();
		crmActions.fetchWorkOrderNumbers(woNum);
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), checkListName, status);
			WRN7NMBCombingVirtualChecklist(checklistType);
			crmActions.saveChecklist();
		}
	}

	public void WRN7NMBCombingVirtualChecklist(String checklistType) throws InterruptedException {
		String path = filePath + pngFilePath;
		Log.info("final path to upload " + path);
		if ("Non-Compliance".equals(checklistType)) {
			eleUtil.waitForVisibilityOfElement(ltaEMASCCTVCamera, 40);
			eleUtil.doSendKeysLog(ltaEMASCCTVCamera, "100", "send value in No. of LTA EMAS CCTV camera viewed");
			eleUtil.doSendKeysLog(pubCCTVCamera, "100", "send value in No. of PUB CCTV camera viewed");
			eleUtil.doClickLog(unknownProjectSiteObserved,
					"Select Yes for Are there any unknown project site observed?");
			eleUtil.doSendKeysLog(cameraNumber1, "Test Camera", "send value in Camera Number 1");
			eleUtil.doSendKeysLog(projectSite, "Test Project", "send value in Location of project site");
			uploadFile(screenshotFromCamera, path);
		} else {
			// Write Compliance code
		}
	}

	public void checkListForWRN7NMBShaftInspection(String status, String checklistType, String checkListName)
			throws InterruptedException {
		crmActions.workOrderStatusFilter(status);
		List<String> woNum = new ArrayList<>();
		crmActions.fetchWorkOrderNumbers(woNum);
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), checkListName, status);
			WRN7NMBShaftInspectionChecklist(checklistType);
			crmActions.saveChecklist();
		}
	}

	public void WRN7NMBShaftInspectionChecklist(String checklistType) throws InterruptedException {
		String path = filePath + pngFilePath;
		Log.info("final path to upload " + path);
		if ("Non-Compliance".equals(checklistType)) {
			eleUtil.waitForVisibilityOfElement(ableToAccessShaftInspection, 40);
			eleUtil.doClickLog(ableToAccessShaftInspection, "Select Yes for ABLE TO ACCESS?");
			eleUtil.selectDropDownValue(boltsTightened, "selectByVisibleText", "Yes",
					"Select Yes in BOLTS/NUTS TIGHTENED?");
			eleUtil.selectDropDownValue(rustyCover, "selectByVisibleText", "Yes", "Select Yes in RUSTY/CRACK COVER?");
			eleUtil.selectDropDownValue(roofSlab, "selectByVisibleText", "Yes", "Select Yes in CRACK ON ROOF SLAB?");
			eleUtil.selectDropDownValue(concreteSlab, "selectByVisibleText", "Yes",
					"Select Yes in HOLES IN SEALANT/BITUMEN LAYER AT CONCRETE SLAB?");
			eleUtil.selectDropDownValue(manholeCover, "selectByVisibleText", "Yes",
					"Select Yes in HOLES IN BITUMEN LAYER ON MANHOLE COVER?");
			eleUtil.selectDropDownValue(odourDetected, "selectByVisibleText", "Yes", "Select Yes in ODOUR DETECTED?");
			eleUtil.doSendKeysLog(manholeCoverKeyhole, "100", "send value in H2S GAS READING AT MANHOLE COVER KEYHOLE");
			eleUtil.doSendKeysLog(concreteShaftReam, "100", "send value in H2S GAS READING AT CONCRETE SHAFT REAM");
			uploadFile(photoForUpstreamDirection, path);
			uploadFile(photoForDownstreamDirection, path);
			uploadFile(photoForShowingShaft, path);
			eleUtil.doClickLog(projectSiteNonComplianceShaftInspection,
					"Select Yes for Observed unknown project site?");
			eleUtil.waitForVisibilityOfElement(detailsObtained, 30);
			eleUtil.doSendKeysLog(detailsObtained, "WRN7 NMBNon-Compliance",
					"send value in If yes, state the details obtained");
		} else {
			// Write Compliance code
		}
	}

	public void fillCheckListQuestionsForWRN6IMB(String complainceStatus, String allWorkComplete, String value)
			throws InterruptedException {
		commonActionsPage.WOnumber = crmActions.getWONumber();
		List<String> woNum = commonActionsPage.WOnumber;
		Thread.sleep(2000);
		Log.info("print wo number " + woNum);
		Log.info("size is:" + woNum.size());
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), "WRN 6 IMB Pumping Main Construction Site Inspection Checklist",
					"In Progress");
			selectChecklistForWRN6IMB(complainceStatus, allWorkComplete, value);
			crmActions.saveChecklist();
		}
	}

	public void selectChecklistForWRN6IMB(String complainceStatus, String allWorkComplete, String value)
			throws InterruptedException {
		By alWorkComplete = By.xpath("//select[contains(@aria-label,'" + allWorkComplete + "')]");
		By remarksField = By.xpath("//input[contains(@aria-label,'Remarks')]");
		By photoUpload = By.xpath("//input[@aria-label=' Photo' or @aria-label='Photo']");
		if (complainceStatus.equals("Non-Complaince")) {
			eleUtil.waitForVisibilityOfElement(physicalActivityCorrectlyStated, 40);
			eleUtil.doClickLog(physicalActivityCorrectlyStated,
					"Verify physical work activity is correctly stated based on POWS submission");
			eleUtil.selectDropDownValue(physicalActivityCorrectlyStated, "selectByVisibleText", "No",
					"Select No in Verify physical work activity is correctly stated based on POWS submission");
			eleUtil.selectDropDownValue(PEQPMethodStatement, "selectByVisibleText", "NA",
					"Select NA in Physical work activity is done according to PE/QP method statement and at correct location");
			eleUtil.selectDropDownValue(anyStructure, "selectByVisibleText", "NA",
					"Select NA in Any structure (e.g. heavy load) is on top of our pumping main?");
			eleUtil.selectDropDownValue(anySewageSmell, "selectByVisibleText", "NA",
					"Select NA in Any sewage smell /leak/water ponding at site?");
			eleUtil.selectDropDownValue(anyPumpingMainExposed, "selectByVisibleText", "NA",
					"Select NA in Any pumping main is exposed?");
			eleUtil.selectDropDownValue(markerField, "selectByVisibleText", "NA",
					"Select NA in Marker, Pegging or any other form of identification to demarcate the presence of pumping main is correct within worksite (provide photos)");
			eleUtil.selectDropDownValue(worksiteWithin, "selectByVisibleText", "NA",
					"Select NA in  For work site within and near pumping installation, any signs of cracks/settlement found within the installation?");
			eleUtil.selectDropDownValue(nearingTheStage, "selectByVisibleText", "NA",
					"Select NA in Does the work require standing supervision (e.g. excavation is nearing the stage of exposing the PM, specified activity has high risk of damaging PM, etc.)?");

		} else {
			eleUtil.waitForVisibilityOfElement(physicalActivityCorrectlyStated, 40);
			eleUtil.doClickLog(physicalActivityCorrectlyStated,
					"Verify physical work activity is correctly stated based on POWS submission");
			eleUtil.selectDropDownValue(physicalActivityCorrectlyStated, "selectByVisibleText", "Yes",
					"Select Yes in Verify physical work activity is correctly stated based on POWS submission");
			eleUtil.selectDropDownValue(PEQPMethodStatement, "selectByVisibleText", "Yes",
					"Select Yes in Physical work activity is done according to PE/QP method statement and at correct location");
			eleUtil.selectDropDownValue(anyStructure, "selectByVisibleText", "No",
					"Select No in Any structure (e.g. heavy load) is on top of our pumping main?");
			eleUtil.selectDropDownValue(anySewageSmell, "selectByVisibleText", "No",
					"Select No in Any sewage smell /leak/water ponding at site?");
			eleUtil.selectDropDownValue(anyPumpingMainExposed, "selectByVisibleText", "No",
					"Select No in Any pumping main is exposed?");
			eleUtil.selectDropDownValue(markerField, "selectByVisibleText", "Yes",
					"Select Yes in Marker, Pegging or any other form of identification to demarcate the presence of pumping main is correct within worksite (provide photos)");
			eleUtil.selectDropDownValue(worksiteWithin, "selectByVisibleText", "NA",
					"Select NA in  For work site within and near pumping installation, any signs of cracks/settlement found within the installation?");
			eleUtil.selectDropDownValue(nearingTheStage, "selectByVisibleText", "NA",
					"Select NA in Does the work require standing supervision (e.g. excavation is nearing the stage of exposing the PM, specified activity has high risk of damaging PM, etc.)?");

		}

		eleUtil.selectDropDownValue(alWorkComplete, "selectByVisibleText", value, "Select NA in All Work Complete?");
		eleUtil.doSendKeysLog(remarks, "WRN6 IMB Non-Compliance", "Enter remarks in Other observations/Remarks");
		List<WebElement> noOfEles = driver.findElements(remarksField);
		System.out.println("noOfEles" + noOfEles.size());

		for (int i = 0; i < noOfEles.size(); i++) {
			WebElement currEle = noOfEles.get(i);
			currEle.clear();
			currEle.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			currEle.sendKeys("Test");
		}
		List<WebElement> noOfEles1 = driver.findElements(photoUpload);
		System.out.println("noOfEles1" + noOfEles1.size());
		for (int j = 1; j <= noOfEles1.size(); j++) {
			By photoUpload1 = By.xpath("(//input[@aria-label=' Photo' or @aria-label='Photo'])[" + j + "]");
			common.uploadFile(photoUpload1, filePath + "\\src\\test\\resources\\testdata\\UploadForChecklist.xlsx");

		}

	}

	public void amendChecklistFor6IMB(String WOType, String complainceStatus, String allWorkComplete, String value)
			throws InterruptedException {
		selectWOBasedOnType(WOType);
		eleUtil.doClick(getChecklistTab());
		String actualName = eleUtil.doGetElementAttribute(getCheckListNameField(), "aria-label");
		assertTrue(actualName.contains("WRN 6 IMB Pumping Main Construction Site Inspection Checklist"),
				"Checklist name is not matching");
		eleUtil.doElementClickable(getCheckListNameField(), 20);
		eleUtil.doClick(getCheckListNameField());
		eleUtil.doElementClickable(getMaximizeScreenBtn(), 10);
		eleUtil.doClick(getMaximizeScreenBtn());
		clearResponseInChecklist();
		selectChecklistForWRN6IMB(complainceStatus, allWorkComplete, value);
		crmActions.saveChecklist();
	}

}
