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

	// WRN4
	private By EERegStatus = By.xpath("//select[@aria-label='EE Registration Status']");
	private By typeOfGT = By.xpath("//select[@aria-label='Type of GT']");
	private By iAmAware = By
			.xpath("//h5[contains(@aria-label,'I am aware')]/../following-sibling::div//input[@Value='Yes']");
	private By iVerify = By
			.xpath("//h5[contains(@aria-label,'I verify')]/../following-sibling::div//input[@Value='Yes']");

	String todayDate = eleUtil.todayDate("MM/dd/yyyy");
	String yesval = "Yes";
	String noval = "No";
	String value;

	private By samplingConducted = By
			.xpath("//h5[@aria-label='Sampling conducted?']/../following-sibling::div//input[@Value='" + value + "']");
	private By doesEEHaveAGT = By.xpath(
			"//h5[contains(@aria-label,'Does EE have a GT')]/../following-sibling::div//input[@Value='" + value + "']");
	private By doesEENeedAGT = By
			.xpath("//h5[contains(@aria-label,'Does EE need a GT')]/../following-sibling::div//input[@Value='" + value
					+ "']	");
	private By whoMaintainedTheGT = By
			.xpath("//h5[contains(@aria-label,'Who maintains the GT? ')]/../following-sibling::div//input[@Value='"
					+ value + "']");
	private By GTCoverSecureToTheGround = By.xpath(
			"//h5[contains(@aria-label,'GT cover secured to the ground?')]/../following-sibling::div//input[@Value='"
					+ value + "']");

	private By unableToRemoveInnerCoreCover = By.xpath(
			"//h5[contains(@aria-label,'Unable to remove inner core cover?')]/../following-sibling::div//input[@Value='"
					+ value + "']");
	private By innerCoreCoverHandleMissing = By.xpath(
			"//h5[contains(@aria-label,'Inner core cover handle missing?')]/../following-sibling::div//input[@Value='"
					+ value + "']");
	private By conditionInInnerCore = By.xpath(
			"//h5[contains(@aria-label,'Condition in inner core')]/../following-sibling::div//input[@Value='"+value+"']");
	private By GTObstrcuted = By
			.xpath("//h5[contains(@aria-label,'GT access is obstructed')]/../following-sibling::div//input[@Value='"
					+ value + "']");
	
	// Locators for WRN1 TEF
	private By housekeepingPremise = By
			.xpath("//select[@aria-label='A.Premise’s Check: 1.Is the housekeeping of the premises satisfactory?']");
	private By spillageOfChemicals = By.xpath(
			"//select[@aria-label='A.Premise’s Check: 2.Is there any spillages of chemicals / oil found in the premises?']");
	private By objToMeetTheVisitField = By
			.xpath("//textarea[contains(@aria-label,'Objectives to meet for the visit: ')]");

	
	// Locators for WRN8 NMB
		private By constructionActivitiyFound = By
				.xpath("//select[@aria-label='Is there any construction activity found?']");
		private By repName = By.xpath("//input[@aria-label='Contractor’s Rep Name']");
		private By repEmail = By.xpath("//input[contains(@aria-label,\"Contractor's Rep Email Address\")]");
		private By repTelNo = By.xpath("//input[contains(@aria-label,\"Contractor's Rep Tel No\")]");
		private By qpName = By.xpath("//input[@aria-label='QP Rep Name']");
		private By qpEmail = By.xpath("//input[contains(@aria-label,\"QP Rep Email Address\")]");
		private By qpTelNo = By.xpath("//input[contains(@aria-label,\"QP Rep Tel No\")]");
		private By sewerId = By.xpath("//input[@aria-label='Sewer ID']");
		private By sewerDiameter = By.xpath("//input[contains(@aria-label,'Sewer Diameter')]");
		private By sewerOutsideHoarding = By.xpath("//select[contains(@aria-label,'Sewer outside project hoarding?')]");
		private By typeOfActivity = By.xpath("//select[contains(@aria-label,'Type of Specified Activity')]");
		private By depth = By.xpath("//input[contains(@aria-label,'Depth')]");
		private By distance = By.xpath("//input[contains(@aria-label,'Distance')]");
		private By statusOfActivity = By.xpath("//select[contains(@aria-label,'Status of specified activity ')]");
		private By activityCovered = By.xpath("//select[contains(@aria-label,'activity covered in POWS')]");
		private By attachReport = By.xpath("//input[@aria-label='Attach report']/..");// input[@aria-label='Attach
		// report']/..//span[contains(text(),'Choose
		// file')]
		private By sendfileToReport = By.xpath("//input[@aria-label='Attach report']");
	public By getSamplingConducted(String val) {
		return samplingConducted;
	}

	public By getDoesEEHaveAGT(String val) {
		return doesEEHaveAGT;
	}

	public By getDoesEENeedAGT(String val) {
		return doesEENeedAGT;
	}

	public By getWhoMaintainedTheGT(String val) {
		return whoMaintainedTheGT;
	}

	public By getGTCoverSecureToTheGround(String val) {
		return GTCoverSecureToTheGround;
	}

	public By getUnableToRemoveInnerCoreCover(String val) {
		return unableToRemoveInnerCoreCover;
	}

	public By getInnerCoreCoverHandleMissing(String val) {
		return innerCoreCoverHandleMissing;
	}

	public By getConditionInInnerCore(String val) {
		return conditionInInnerCore;
	}
	public By getGTObstrcuted(String val) {
		return GTObstrcuted;
	}

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

	public void sampleLabForAnalysisForWRN4() throws InterruptedException {
		eleUtil.waitTillElementIsDisplayed(factory.clickOnNewSampleLab(), 30);
		eleUtil.doClickLog(factory.clickOnNewSampleLab(), "Click on New Sample For Lab Analysis button");

		eleUtil.waitTillElementIsDisplayed(factory.selectDateAndTime(), 30);
		eleUtil.doSendKeysWithWaitEnter(factory.selectDateAndTime(), todayDate, 100);

		eleUtil.doClickLog(factory.clickOnParametersAnalysed(), "Enter 1st value as Oil & Grease (Hydrocarbon)");
		eleUtil.doClearUsingKeyswithWait(factory.clickOnParametersAnalysed(), 30);
		eleUtil.doSendKeysWithWaitEnter(factory.clickOnParametersAnalysed(), "Oil & Grease (Hydrocarbon)", 30);
		eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");

		eleUtil.doClickLog(factory.clickOnParametersAnalysed(), "Enter 2nd value as Oil & Grease (Non-Hydrocarbon)");
		eleUtil.doSendKeysWithWaitEnter(factory.clickOnParametersAnalysed(), "Oil & Grease (Non-Hydrocarbon)", 50);
		eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");

		eleUtil.doClickLog(factory.clickOnParametersAnalysed(), "Enter 3rd value as Oil & Grease (Total)");
		eleUtil.doSendKeysWithWaitEnter(factory.clickOnParametersAnalysed(), "Oil & Grease (Total)", 50);
		eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");

		eleUtil.doClickLog(factory.clickOnLab(), "Enter 1st value as PUB Laboratory 1");
		eleUtil.doClearUsingKeyswithWait(factory.clickOnLab(), 30);
		eleUtil.doSendKeysWithWaitEnter(factory.clickOnLab(), "PUB Laboratory 1", 30);
		eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");

		eleUtil.waitTillElementIsDisplayed(factory.getSaveAndClose(), 30);
		eleUtil.doClickLog(factory.getSaveAndClose(), "Click on Save and Close button");
	}

	public void selectEERegStatus() {
		eleUtil.waitForVisibilityOfElement(EERegStatus, 40);
		eleUtil.doClickLog(EERegStatus, "Clicked on EE Registration Status");
		eleUtil.selectDropDownValue(EERegStatus, "selectByVisibleText", "Active",
				"Select Active in EE Registration Status");
	}

	public void selectChecklistForWRN4_GTSampling(String complainceStatus, String checklistName) {
		selectEERegStatus();
		if (complainceStatus.equals("Non-Complaince")) {
			eleUtil.waitForVisibilityOfElement(getSamplingConducted(yesval), 40);
			eleUtil.doClickLog(getSamplingConducted(yesval), "Clicked on Sampling Conducted? field : ");
		} else {
			eleUtil.waitForVisibilityOfElement(getSamplingConducted(noval), 40);
			eleUtil.doClickLog(getSamplingConducted(noval), "Clicked on Sampling Conducted? field : ");
		}
		eleUtil.waitForVisibilityOfElement(iAmAware, 20);
		eleUtil.doClickLog(iAmAware,
				"Clicked on I am aware that PUB has collected sample from our grease trap field : ");
		eleUtil.waitForVisibilityOfElement(iVerify, 20);
		eleUtil.doClickLog(iVerify, "Clicked on I verify that I have witnessed the sampling process field : ");
	}

	public void selectChecklistForWRN4_GTNotInstalled(String complainceStatus, String checklistName) {
		selectEERegStatus();
		eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(noval), 40);
		eleUtil.doClickLog(getDoesEEHaveAGT(noval),
				"Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

		eleUtil.waitForVisibilityOfElement(getDoesEENeedAGT(yesval), 40);
		eleUtil.doClickLog(getDoesEENeedAGT(yesval),
				"Clicked on Does EE need a GT / Grease Separator / Grease Interceptor (Portable)? field : ");
	}

	public void selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi1(String complainceStatus, String checklistName) {
		selectEERegStatus();

		eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
		eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
				"Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

		eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
		eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
		eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Small GT", "Select Small GT in Type Of GT");

		eleUtil.waitForVisibilityOfElement(getWhoMaintainedTheGT("Not maintained"), 40);
		eleUtil.doClickLog(getWhoMaintainedTheGT("Not maintained"), "Clicked on Who maintains the GT? field : ");

		eleUtil.waitForVisibilityOfElement(getGTCoverSecureToTheGround(yesval), 40);
		eleUtil.doClickLog(getGTCoverSecureToTheGround(yesval),
				"Clicked on GT cover secured to the ground? (Hence can't access GT internals) field : ");
	}

	public void selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi2(String complainceStatus, String checklistName) {
		selectEERegStatus();
		
		eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval),40);
		eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
				"Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

		eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
		eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
		eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Big GT", "Select Big GT in Type Of GT");

		eleUtil.waitForVisibilityOfElement(getWhoMaintainedTheGT("Not maintained"), 40);
		eleUtil.doClickLog(getWhoMaintainedTheGT("Not maintained"), "Clicked on Who maintains the GT? field : ");

		eleUtil.waitForVisibilityOfElement(getGTCoverSecureToTheGround(noval), 40);
		eleUtil.doClickLog(getGTCoverSecureToTheGround(noval),
				"Clicked on GT cover secured to the ground? (Hence can't access GT internals) field : ");

		eleUtil.waitForVisibilityOfElement(getUnableToRemoveInnerCoreCover(noval), 40);
		eleUtil.doClickLog(getUnableToRemoveInnerCoreCover(noval), "Clicked on Unable to remove inner core cover? field : ");

		eleUtil.waitForVisibilityOfElement(getInnerCoreCoverHandleMissing(noval), 40);
		eleUtil.doClickLog(getInnerCoreCoverHandleMissing(noval), "Clicked on Inner core cover handle missing? field : ");

		eleUtil.waitForVisibilityOfElement(getConditionInInnerCore("Dry"), 40);
		eleUtil.doClickLog(getConditionInInnerCore("Dry"), "Clicked on Condition in inner core field : ");
	}

	public void selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi3(String complainceStatus, String checklistName) {
		selectEERegStatus();		

		eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
		eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
				"Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

		eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
		eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
		eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Grease Separator",
				"Select Grease Separator in Type Of GT");

		eleUtil.waitForVisibilityOfElement(getWhoMaintainedTheGT("Not maintained"), 40);
		eleUtil.doClickLog(getWhoMaintainedTheGT("Not maintained"), "Clicked on Who maintains the GT? field : ");

	}

	public void selectChecklistForWRN4_GTNotMaintained_LegalNot(String complainceStatus, String checklistName) {
		selectEERegStatus();

		eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
		eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
				"Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

		eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
		eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
		eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Big GT", "Select Big GT in Type Of GT");

		eleUtil.waitForVisibilityOfElement(getGTCoverSecureToTheGround(noval), 40);
		eleUtil.doClickLog(getGTCoverSecureToTheGround(noval),
				"Clicked on GT cover secured to the ground? (Hence can't access GT internals) field : ");

		eleUtil.waitForVisibilityOfElement(getUnableToRemoveInnerCoreCover(noval), 40);
		eleUtil.doClickLog(getUnableToRemoveInnerCoreCover(noval), "Clicked on Unable to remove inner core cover? field : ");

		eleUtil.waitForVisibilityOfElement(getInnerCoreCoverHandleMissing(noval), 40);
		eleUtil.doClickLog(getInnerCoreCoverHandleMissing(noval), "Clicked on Inner core cover handle missing? field : ");

		eleUtil.waitForVisibilityOfElement(getConditionInInnerCore("Hardened grease"), 40);
		eleUtil.doClickLog(getConditionInInnerCore("Hardened grease"), "Clicked on Condition in inner core field : ");

	}

	public void selectChecklistForWRN4_GTDamaged_Combination1(String complainceStatus, String checklistName) {
		selectEERegStatus();
		

		eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
		eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
				"Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

		eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
		eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
		eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Big GT", "Select Big GT in Type Of GT");

		eleUtil.waitForVisibilityOfElement(getGTCoverSecureToTheGround(noval), 40);
		eleUtil.doClickLog(getGTCoverSecureToTheGround(noval),
				"Clicked on GT cover secured to the ground? (Hence can't access GT internals) field : ");

		eleUtil.waitForVisibilityOfElement(getGTObstrcuted(yesval), 40);
		eleUtil.doClickLog(getGTObstrcuted(yesval), "Clicked on GT access is obstructed? field : ");
	}

	public void selectChecklistForWRN4_GTDamaged_Combination2(String complainceStatus, String checklistName) {
		selectEERegStatus();
	

		eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
		eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
				"Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

		eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
		eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
		eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Big GT", "Select Big GT in Type Of GT");

		// eleUtil.waitForVisibilityOfElement(greaseImnterceptorObstructed?,
		// 40);//greaseInterceptorObstructed not available in checklist
		// eleUtil.doClickLog(greaseInterceptorObstructed, "Clicked on Grease
		// Interceptor (Portable) access is obstructed field : ");
	}

	public void selectChecklistForWRN4_GTDamaged_Combination3(String complainceStatus, String checklistName) {
		selectEERegStatus();

		eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
		eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
				"Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

		eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
		eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
		eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Big GT", "Select Big GT in Type Of GT");

		// eleUtil.waitForVisibilityOfElement(greaseSeperatorObstructed?,
		// 40);//greaseImterceptorObstructed not available in checklist
		// eleUtil.doClickLog(greaseSeperatorObstructed, "Clicked on Grease Separator
		// access is obstructed? field : ");
	}

	public void fillCheckListQuestionsForWRN4(String complainceStatus, String checklistName)
			throws InterruptedException {
		commonActionsPage.WOnumber = crmActions.getWONumber();
		List<String> woNum = commonActionsPage.WOnumber;
		Thread.sleep(2000);
		Log.info("print wo number " + woNum);
		Log.info("size is:" + woNum.size());
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), "Grease Trap Inspection", "In Progress");
			sampleLabForAnalysisForWRN4();
			if ("GT Sampling".equals(checklistName)) {
				selectChecklistForWRN4_GTSampling(complainceStatus, checklistName);
			} else if ("GT Not Installed".equals(checklistName)) {
				selectChecklistForWRN4_GTNotInstalled(complainceStatus, checklistName);
			} else if ("GT Not Maintained Advisory Letter_Combination1".equals(checklistName)) {
				selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi1(complainceStatus, checklistName);
			} else if ("GT Not Maintained Advisory Letter_Combination2".equals(checklistName)) {
				selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi2(complainceStatus, checklistName);
			} else if ("GT Not Maintained Advisory Letter_Combination3".equals(checklistName)) {
				selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi3(complainceStatus, checklistName);
			} else if ("GT Not Maintained Legal Notice".equals(checklistName)) {
				selectChecklistForWRN4_GTNotMaintained_LegalNot(complainceStatus, checklistName);
			} else if ("GT Damaged_Combination1".equals(checklistName)) {
				selectChecklistForWRN4_GTDamaged_Combination1(complainceStatus, checklistName);
			} else if ("GT Damaged_Combination2".equals(checklistName)) {
				selectChecklistForWRN4_GTDamaged_Combination2(complainceStatus, checklistName);
			} else if ("GT Damaged_Combination3".equals(checklistName)) {
				selectChecklistForWRN4_GTDamaged_Combination3(complainceStatus, checklistName);
			}
			crmActions.saveChecklist();
		}
	}
	
	public void selectChecklistForWRN1TEF() {
		eleUtil.waitTillElementIsDisplayed(factory.getToolboxConducted(), 30);
		eleUtil.selectDropDownValue(factory.getToolboxConducted(), "selectByVisibleText", "Yes",
				"Select Yes Toolbox Briefing Conducted");
		eleUtil.waitTillElementIsDisplayed(factory.selectWrittenApprovalNumber(), 30);
		eleUtil.selectDropDownValue(factory.selectWrittenApprovalNumber(), "selectByVisibleText", "Yes",
				"Select Yes Written Approval Number");
		eleUtil.waitTillElementIsDisplayed(housekeepingPremise, 30);
		eleUtil.selectDropDownValue(housekeepingPremise, "selectByVisibleText", "No",
				"Select No housekeeping of the premises");
		eleUtil.waitTillElementIsDisplayed(spillageOfChemicals, 30);
		eleUtil.selectDropDownValue(spillageOfChemicals, "selectByVisibleText", "No",
				"Select No spillages of chemicals / oil found in the premises");
		eleUtil.waitTillElementIsDisplayed(objToMeetTheVisitField, 20);
		eleUtil.doSendKeysLog(objToMeetTheVisitField, "Test",
				"Passes value to the Objectives to meet for the visit fiedl");
	}

	public void fillCheckListQuestionsForWRN1TEF() throws InterruptedException {
		commonActionsPage.WOnumber = crmActions.getWONumber();
		List<String> woNum = commonActionsPage.WOnumber;
		Thread.sleep(2000);
		Log.info("print wo number " + woNum);
		Log.info("size is:" + woNum.size());
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), "Trade Effluent Inspection", "In Progress");
			factory.sampleLabForAnalysis();
			selectChecklistForWRN1TEF();
			crmActions.saveChecklist();
		}
	}
	
	public void selectChecklistForWRN8NMB() {
		eleUtil.waitTillElementIsDisplayed(constructionActivitiyFound, 30);
		eleUtil.selectDropDownValue(constructionActivitiyFound, "selectByVisibleText", "Yes",
				"Select Yes Is there any construction activity found? field");

		eleUtil.waitTillElementIsDisplayed(repName, 30);
		eleUtil.doClickLog(repName, "Clicked on Contractor’s Rep Name field");
		eleUtil.doClearUsingKeysLog(repName, "Clear the Contractor’s Rep Name field");
		eleUtil.doSendKeysLog(repName, "Tester A", "Contractor’s Rep Name is :");

		eleUtil.waitTillElementIsDisplayed(repEmail, 30);
		eleUtil.doClickLog(repEmail, "Clicked on Contractor's Rep Email Address field");
		eleUtil.doClearUsingKeysLog(repEmail, "Clear the Contractor's Rep Email Address field");
		eleUtil.doSendKeysLog(repEmail, "testera@gmail.com", "Contractor's Rep Email Address is :");

		eleUtil.waitTillElementIsDisplayed(repTelNo, 30);
		eleUtil.doClickLog(repTelNo, "Clicked on Contractor's Rep Tel No field");
		eleUtil.doClearUsingKeysLog(repTelNo, "Clear the Contractor's Rep Tel No field");
		eleUtil.doSendKeysLog(repTelNo, "9090989897", "Contractor's Rep Tel No is :");

		eleUtil.waitTillElementIsDisplayed(qpName, 30);
		eleUtil.doClickLog(qpName, "Clicked on QP Rep Name field");
		eleUtil.doClearUsingKeysLog(qpName, "Clear the QP Rep Name field");
		eleUtil.doSendKeysLog(qpName, "Tester B", "QP Rep Name is :");

		eleUtil.waitTillElementIsDisplayed(qpEmail, 30);
		eleUtil.doClickLog(qpEmail, "Clicked on QP Rep Email Address field");
		eleUtil.doClearUsingKeysLog(qpEmail, "Clear the QP Rep Email Address field");
		eleUtil.doSendKeysLog(qpEmail, "testera@gmail.com", "QP Rep Email Address is :");

		eleUtil.waitTillElementIsDisplayed(qpTelNo, 30);
		eleUtil.doClickLog(qpTelNo, "Clicked on QP Rep Tel No field");
		eleUtil.doClearUsingKeysLog(qpTelNo, "Clear the QP Rep Tel No field");
		eleUtil.doSendKeysLog(qpTelNo, "t9876543210", "QP Rep Tel No is :");

		eleUtil.waitTillElementIsDisplayed(sewerId, 30);
		eleUtil.doClickLog(sewerId, "Clicked on Sewer ID field");
		eleUtil.doClearUsingKeysLog(sewerId, "Clear the Sewer ID field");
		eleUtil.doSendKeysLog(sewerId, "62464", "Sewer ID is :");

		eleUtil.waitTillElementIsDisplayed(sewerDiameter, 30);
		eleUtil.doClickLog(sewerDiameter, "Clicked on Sewer Diameter field");
		eleUtil.doClearUsingKeysLog(sewerDiameter, "Clear the Sewer Diameter field");
		eleUtil.doSendKeysLog(sewerDiameter, "1100", "Sewer Diameter is :");

		eleUtil.waitTillElementIsDisplayed(sewerOutsideHoarding, 30);
		eleUtil.selectDropDownValue(sewerOutsideHoarding, "selectByVisibleText", "Yes",
				"Select Yes Is there any construction activity found? field");

		eleUtil.waitTillElementIsDisplayed(typeOfActivity, 30);
		eleUtil.selectDropDownValue(typeOfActivity, "selectByVisibleText",
				"The excavation of earth, rock or other material by means of explosives",
				"Selected Type of Specified Activity Within Sewer Corridor field");

		eleUtil.waitTillElementIsDisplayed(depth, 30);
		eleUtil.doClickLog(depth, "Clicked on Depth of Specified Activity field");
		eleUtil.doClearUsingKeysLog(depth, "Clear the Depth of Specified Activity field");
		eleUtil.doSendKeysLog(depth, "Tester A", "Depth of Specified Activity is :");

		eleUtil.waitTillElementIsDisplayed(distance, 30);
		eleUtil.doClickLog(distance, "Clicked on Distance of specified activity from sewer field");
		eleUtil.doClearUsingKeysLog(distance, "Clear the Distance of specified activity from sewer field");
		eleUtil.doSendKeysLog(distance, "testera@gmail.com", "Distance of specified activity from sewer is :");

		eleUtil.waitTillElementIsDisplayed(statusOfActivity, 30);
		eleUtil.selectDropDownValue(statusOfActivity, "selectByVisibleText", "on-going",
				"Selected Status of specified activity field");

		eleUtil.waitTillElementIsDisplayed(activityCovered, 30);
		eleUtil.selectDropDownValue(activityCovered, "selectByVisibleText", "No",
				"Selected activity covered in POWS approval? field");

		eleUtil.waitTillElementIsDisplayed(attachReport, 30);
		eleUtil.doClickLog(attachReport, "Clicked on Attach report field");
		try {
			common.uploadFile(sendfileToReport, filePath + "\\src\\test\\resources\\testdata\\UploadForChecklist.xlsx");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fillCheckListQuestionsForWRN8NMB() throws InterruptedException {
		commonActionsPage.WOnumber = crmActions.getWONumber();
		List<String> woNum = commonActionsPage.WOnumber;
		Thread.sleep(2000);
		Log.info("print wo number " + woNum);
		Log.info("size is:" + woNum.size());
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), "BCA Project Site Inspection affecting Public Sewerage System",
					"In Progress");
			selectChecklistForWRN8NMB();
			crmActions.saveChecklist();
		}
	}

	
}
