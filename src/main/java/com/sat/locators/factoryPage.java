package com.sat.locators;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.*;
import org.testng.Assert;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.constants.AppConstants;
import com.sat.testUtil.Log;

public class factoryPage extends commonActionsPage {

	public factoryPage(WebDriver driver) {
		super(driver);
	}

	commonCRMActions crmActions = new commonCRMActions(driver);

	private By entityType = By.cssSelector("select[aria-label='Entity Type']");
	private By entityName = By.cssSelector("input[aria-label='Entity Name/Project Reference No']");
	private By catchment = By.cssSelector("select[aria-label='Catchment']");
	private By statusReason = By.cssSelector("div[aria-label='Status Reason']");

	// Service Tab verification
	private By checkCaseCreated = By
			.xpath("//div[contains(@data-id,'pcf_grid_control_container')]//span[text()='No data available']");
	private static By caseNumberVerify = By.xpath("//div[@col-id='title']//a");
	private By caseStatusUnscheduled = By.xpath("//div[@col-id='statuscode'] //label[@aria-label='Unscheduled']");
	private By caseStatusVerify = By.xpath("//div[@col-id='statuscode']//label[@aria-label]");
	private By checkWOCreated = By
			.xpath("//div[@data-id='workorder-pcf_grid_control_container'] //span[text()='No data available']");
	private static By workOrderVerify = By.xpath("//div[@col-id='msdyn_name']//a");
	private By caseGridRefresh = By.xpath("//ul[@aria-label='Case Commands'] //button[@aria-label='Refresh']");
	private By workOrderGridRefresh = By
			.xpath("//ul[@aria-label='Work Order Commands'] //button[@aria-label='Refresh']");
	private By workOrderUnscheduled = By
			.xpath("//div[@col-id='msdyn_systemstatus'] //label[@aria-label='Unscheduled']");
	private By workOrderStatusVerify = By.xpath("//div[@col-id='msdyn_systemstatus']//label[@aria-label]");
	private By sampleForLab = By.xpath("//button[contains(@title,'Add New Sample For Lab Analysis')]");
	private By dateAndTime = By.xpath("//input[contains(@aria-label,'Date of Date And Time')] ");
	private By parametersAnalysed = By.xpath("//input[@aria-label='Parameters Analysed, Multiple Selection Lookup']");
	private By lab = By.xpath("//input[@aria-label='Lab, Lookup']");
	private By saveAndClose = By.xpath("//button[@aria-label='Save and Close']");
	private By toolboxBriefingConducted = By.xpath("//select[@aria-label='Toolbox Briefing Conducted']");
	private By writtenApprovalNumber = By.xpath("//select[@aria-label='Valid Written Approval Number']");
	private By lastInspectionChamber = By
			.xpath("//select[@aria-label='D.Last Inspection Chamber’s Check: 3.Any abnormality observed? "
					+ "If yes, state details in Observation section']");
	private By oilInterceptorCheck = By
			.xpath("//select[@aria-label='C.Oil Interceptor’s Check: 2.Is there any abnormality observed? "
					+ "If yes, state details in Observation section. ']");
	private By meetForVisit = By
			.xpath("//textarea[contains(@aria-label,'Objectives to meet for the visit')]");
	private By selectLookUp = By.cssSelector("ul[tabindex='0']");
	private By calender = By.xpath("//div[contains(@id,'DatePicker-Callout')]");

	private By abnormalityInChamber = By.cssSelector("select[aria-label='Abnormality In Chamber']");
	private By caseType = By.cssSelector("select[aria-label='Case Type']");
	private By fioComments = By.cssSelector("[aria-label='FIO Comments']");

	private By abnormalityChamberCheck = By.xpath("//select[@aria-label='Abnormality In Chamber' and @title='---']");
	private By abnormalityInOilInterceptor = By.cssSelector("select[aria-label='Abnormality in Oil Interceptor']");
	private By abnormalityOilCheck = By
			.xpath("//select[@aria-label='Abnormality in Oil Interceptor' and @title='---']");

	private By moreButtonOnPubLab = By
			.xpath("//div[@data-control-name='pub_labreports']//button[@aria-label='More commands for Lab Report']");
	private By attachButtonOnPubLab = By.xpath("//button[@title='Attach']");
	private By browserButton = By.cssSelector("button[onclick='onClickBrowse()']");
	private By uploadFile = By.xpath("//body[@onload='onLoad()'] //input[@id='pub_wr_file']");
	private By fileUploadButton = By.cssSelector("button[onclick='fileUpload()']");
	private By switchToUploadLabReport = By.cssSelector("iframe[aria-label='LabReportAttachDialog']");
	private By clickOk = By.cssSelector("[aria-label='OK']");
	private By morecommands = By.xpath("//button[@title='More commands for Lab Report']");
	private By refreshOnLabReportTab = By
			.xpath("//button[@aria-label='Refresh' and contains(@data-lp-id,'pub_labreport.RefreshButton')]");
	private By checkPubLab = By.xpath("//div[contains(text(),'find anything to show here')]");
	private By checkSumHeavyMetal = By.xpath("//div[@id='dataSetRoot_heavymetal'] //span[text()='No data available']");
	private By checkNonCompliance = By
			.xpath("//div[@id='dataSetRoot_heavymetal'] //label[contains(@class,'ms-Label optionSetRootStyles')]");
	private By checkSum = By
			.xpath("//div[@id='dataSetRoot_heavymetal'] //label[contains(@class,'ms-Label labelRootStyles')]");
	private By uploadLabReportSwitch = By.cssSelector("[aria-label='Lab Report Uploaded: No']");
	private By emptyUserAssessment = By.xpath("//select[@aria-label='User Assessment' and @title='---']");
	private By emptySystemAssessment = By
			.xpath("//div[@data-id='pub_systemassessment'] //select[@aria-label='System Assessment' and @title='---']");
	private By userAssessment = By.xpath("//select[@aria-label='User Assessment']");
	private By systemAssessment = By
			.xpath("//div[@data-id='pub_systemassessment'] //select[@aria-label='System Assessment']");

	private By caseTitle = By.cssSelector("h1[data-id='header_title']");

	private By listOfFactoryListView = By
			.xpath("//h1[@title='List of Factories'] //span[@data-automationid='splitbuttonprimary']");
	private By searchResults = By.cssSelector("input[aria-labelledby='SearchResults']");
	private By adHocView = By.xpath("//label[text()='List of Ad-hoc Factories']");
	private By factoriesSearchBox = By.cssSelector("input[aria-label='Entity Filter by keyword']");
	private By approveButton = By.cssSelector("button[aria-label='Approve Factory']");

	private By accountNumber = By.cssSelector("input[aria-label='Account Number']");
	private By savingInProgressOkButton = By.xpath("//span[contains(@id,'okButtonText')]");
	private By savingInProgressPopUp = By.xpath("//div[contains(@id,'modalDialogContentContainer')]");

	private By caseReadOnly = By.cssSelector("span[data-id='warningNotification']");
	private By caseStatus = By.xpath("//div[contains(text(),'Completed')]");

	// Locators for Factory record
	private By WADetailsSectionName = By.xpath("//h2[@title='WA Details']");
	private By WAStatusField = By.xpath("//select[@aria-label='WA status']");
	private By fpeField = By.xpath("//select[@aria-label='FPE/Non FPE']");

	// Locators for Factory entity view
	private By entitySelection = By.xpath("//div[@col-id='name' and @role='columnheader']");

	String WQPath = "\\src\\test\\resources\\testdata\\SIT_WQ 2 3 1 2.xlsx";
	String todayDateTime = eleUtil.todayDateAndTime();
	String todayDate = eleUtil.todayDate("MM/dd/yyyy");
	String tefFilePath = "\\src\\test\\resources\\testdata\\WQ_Sample_NC.xlsx";
	String filePath = System.getProperty("user.dir");
	String factoryName = "Factory" + todayDateTime;

	public void selectEntityType(String selectEntityType) {
		eleUtil.waitTillElementIsDisplayed(entityType, 30);
		eleUtil.selectDropDownValue(entityType, "selectByVisibleText", selectEntityType,
				"select entity type as " + selectEntityType);
	}

	public By setLookUp() {
		return selectLookUp;
	}

	public static By getWorkOrderVerify() {
		return workOrderVerify;
	}

	public static By getCaseNumberVerify() {
		return caseNumberVerify;
	}

	public By getSavingInProgressPopUp() {
		return savingInProgressPopUp;
	}

	public By getSearchResults() {
		return searchResults;
	}

	public By getSaveAndClose() {
		return saveAndClose;
	}

	public By getUserAssessment() {
		return userAssessment;
	}

	public By getSystemAssessment() {
		return systemAssessment;
	}

	public By clickOnNewSampleLab() {
		return sampleForLab;
	}

	public By selectDateAndTime() {
		return dateAndTime;
	}

	public By clickOnParametersAnalysed() {
		return parametersAnalysed;
	}

	public By clickOnLab() {
		return lab;
	}
	public By getToolboxConducted() {
		return toolboxBriefingConducted;
	}
	public By selectWrittenApprovalNumber() {
		return writtenApprovalNumber;
	}
	public By selectLastInspectionChamber() {
		return lastInspectionChamber;
	}
	public By selectOilInterceptorCheck() {
		return oilInterceptorCheck;
	}

	public void enterEntityName() {
		eleUtil.waitTillElementIsDisplayed(entityName, 30);
		eleUtil.doClickLog(entityName, "Clicked on Entity Name field");
		eleUtil.doClearUsingKeysLog(entityName, "Clear the Entity Name field");
		eleUtil.doSendKeysLog(entityName, factoryName, "Entity Name is :");
	}

	public void selectCatchment() {
		eleUtil.waitTillElementIsDisplayed(catchment, 30);
		eleUtil.selectDropDownValue(catchment, "selectByVisibleText", "Bedok", "select catchment as Bedok");
	}

	public void getStatusReason(String expectedStatus) {
		eleUtil.waitTillElementIsDisplayed(statusReason, 30);
		eleUtil.textVerificationFormAttribute(statusReason, "title", expectedStatus);
	}

	public static String getCaseNumber() {
		eleUtil.waitForVisibilityOfElement(getCaseNumberVerify(), 100);
		String caseNumber = eleUtil.doElementGetText(getCaseNumberVerify());
		return caseNumber;
	}

	public static String getWorkOrderNumber() {
		eleUtil.waitForVisibilityOfElement(getWorkOrderVerify(), 40);
		String workOrder = eleUtil.doElementGetText(getWorkOrderVerify());
		return workOrder;
	}

	public void caseVerification(String caseNumber) throws InterruptedException {
		eleUtil.waitTillElementIsDisplayed(caseGridRefresh, 30);
		eleUtil.doClickLog(caseGridRefresh, "Clicked on case grid refresh button");
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (System.currentTimeMillis() < endTime) {
			if (eleUtil.elementIsDisplayed(checkCaseCreated, "No data available")) {
				Thread.sleep(3000);
				eleUtil.doClickLog(caseGridRefresh, "Case is not created, click on case grid refresh button");
			} else {
				// If the element is not displayed, execute the else block logic
				try {
					commonActionsPage.casenumber = getCaseNumber();
					assertTrue(commonActionsPage.casenumber.startsWith(caseNumber),
							"Case number format is not expected");
					Log.info(commonActionsPage.casenumber);
					return; // Exit the method if the case number is verified
				} catch (NoSuchElementException e) {
					Log.error("Case number element not found: " + e.getMessage());
				}
			}
		}
	}

	public void verifyCaseStatus(String expectedStatus) throws InterruptedException {
		eleUtil.waitTillElementIsDisplayed(caseStatusVerify, 30);
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (System.currentTimeMillis() < endTime) {
			if (eleUtil.elementIsDisplayed(caseStatusUnscheduled, "Status is unscheduled")) {
				Thread.sleep(3000);
				eleUtil.doClickLog(caseGridRefresh, "Case status is Unscheduled click on case grid refresh button");
			} else {
				try {
					eleUtil.textVerificationFormAttribute(caseStatusVerify, "aria-label", expectedStatus);
					return;
				} catch (NoSuchElementException e) {
					Log.error("Case status is unscheduled: " + e.getMessage());
				}
			}
		}
	}

	public void caseNotification(String tabName) throws InterruptedException {
		commonActionsPage.casenumber = getCaseNumber();
		crmActions.notificationForTabToOpen(commonActionsPage.casenumber, tabName);
	}

	public void workOrderVerification() throws InterruptedException {
		eleUtil.waitTillElementIsDisplayed(workOrderGridRefresh, 30);
		eleUtil.doClickLog(workOrderGridRefresh, "Clicked on work order grid refresh button");
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (System.currentTimeMillis() < endTime) {
			if (eleUtil.elementIsDisplayed(checkWOCreated, "No data available")) {
				Thread.sleep(3000);
				eleUtil.doClickLog(workOrderGridRefresh,
						"Work Order not created click on work order grid refresh button");
			} else {
				// If the element is not displayed, execute the else block logic
				try {
					Log.info("Work Order Number " + getWorkOrderNumber());
					return; // Exit the method if the case number is verified
				} catch (NoSuchElementException e) {
					Log.error("Work Order not Created: " + e.getMessage());
				}
			}
		}
	}

	public void verifyWorkOrderStatus(String expectedStatus) throws InterruptedException {
		eleUtil.waitTillElementIsDisplayed(workOrderStatusVerify, 30);
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (System.currentTimeMillis() < endTime) {
			if (eleUtil.elementIsDisplayed(workOrderUnscheduled, "Status is Unscheduled")) {
				Thread.sleep(3000);
				eleUtil.doClickLog(caseGridRefresh,
						"Work Order status is Unscheduled click on Work Order grid refresh button");
			} else {
				try {
					eleUtil.textVerificationFormAttribute(caseStatusVerify, "aria-label", expectedStatus);
					return;
				} catch (NoSuchElementException e) {
					Log.error("Work Order status is unscheduled: " + e.getMessage());
				}
			}
		}
	}

	public void workOrderNotification(String tabName) throws InterruptedException {
		crmActions.notificationForTabToOpen(getWorkOrderNumber(), tabName);
	}

	public void fillCheckListQuestions() throws InterruptedException {
		commonActionsPage.WOnumber = crmActions.getWONumber();
		List<String> woNum = commonActionsPage.WOnumber;
		Thread.sleep(2000);
		Log.info("print wo number " + woNum);
		Log.info("size is:" + woNum.size());
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), "Trade Effluent Inspection", "In Progress");
			sampleLabForAnalysis();
			selectChecklistForWRN2Report();
			crmActions.saveChecklist();
		}
		crmActions.resetFirstRunFlag();
	}

	public void sampleLabForAnalysis() throws InterruptedException {
		eleUtil.waitTillElementIsDisplayed(getToolboxConducted(), 30);
		eleUtil.waitTillElementIsDisplayed(sampleForLab, 30);
		eleUtil.doClickLog(sampleForLab, "Click on New Sample For Lab Analysis button");
		eleUtil.waitTillElementIsDisplayed(dateAndTime, 30);
		eleUtil.doSendKeysWithWaitEnter(dateAndTime, todayDate, 100);
		eleUtil.doClickLog(parametersAnalysed, "Enter 1st value as Toluene");
		eleUtil.doClearUsingKeyswithWait(parametersAnalysed, 30);
		eleUtil.doSendKeysWithWaitEnter(parametersAnalysed, "Toluene", 30);
		eleUtil.doClickLog(setLookUp(), "Select Look-up value");
		eleUtil.doClickLog(lab, "Enter 1st value as PUB Laboratory 1");
		eleUtil.doClearUsingKeyswithWait(lab, 30);
		eleUtil.doSendKeysWithWaitEnter(lab, "PUB Laboratory 1", 30);
		eleUtil.doClickLog(setLookUp(), "Select Look-up value");
		eleUtil.doClickLog(parametersAnalysed, "Enter 2nd value as Styrene");
		eleUtil.doSendKeysWithWaitEnter(parametersAnalysed, "Styrene", 50);
		eleUtil.doClickLog(setLookUp(), "Select Look-up value");
		eleUtil.waitTillElementIsDisplayed(getSaveAndClose(), 30);
		eleUtil.doClickLog(getSaveAndClose(), "Click on Save and Close button");
	}

	public void selectChecklistForWRN2Report() {
		eleUtil.waitTillElementIsDisplayed(getToolboxConducted(), 30);
		eleUtil.selectDropDownValue(getToolboxConducted(), "selectByVisibleText", "Yes",
				"Select Yes Toolbox Briefing Conducted");
		eleUtil.waitTillElementIsDisplayed(selectWrittenApprovalNumber(), 30);
		eleUtil.selectDropDownValue(selectWrittenApprovalNumber(), "selectByVisibleText", "Yes",
				"Select Yes Written Approval Number");
		eleUtil.waitTillElementIsDisplayed(selectLastInspectionChamber(), 30);
		eleUtil.selectDropDownValue(selectLastInspectionChamber(), "selectByVisibleText", "No",
				"Select No Last Inspection Chamber");
		eleUtil.waitTillElementIsDisplayed(selectOilInterceptorCheck(), 30);
		eleUtil.selectDropDownValue(selectOilInterceptorCheck(), "selectByVisibleText", "No",
				"Select No in Oil Interceptor’s Check");

		// SIT1
		eleUtil.doSendKeysLog(meetForVisit, "Enter To conduct sewer and last IC inspections.",
				"Enter value for others");
	}

	public void openCase() {
		commonActionsPage.casenumber = getCaseNumber();
		By loc = By.xpath("//div[@data-id='cases-pcf_grid_control_container'] //a[@aria-label='"
				+ commonActionsPage.casenumber + "']");
		eleUtil.waitForVisibilityOfElement(loc, 30);
		eleUtil.doClickLog(loc, "Open Case");
	}

	public void wrn2Details() throws InterruptedException {
		eleUtil.waitTillElementIsDisplayed(caseType, 140);
		eleUtil.scrollDownTillElementVisible(abnormalityInChamber);
		eleUtil.waitTillElementIsDisplayed(abnormalityInChamber, 30);
		eleUtil.waitTillElementIsDisplayed(abnormalityInOilInterceptor, 30);
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (System.currentTimeMillis() < endTime) {
			if (eleUtil.elementIsDisplayed(abnormalityChamberCheck, "Abnormality In Chamber is empty")
					&& eleUtil.elementIsDisplayed(abnormalityOilCheck, "Abnormality In Oil Interceptor is empty")) {
				eleUtil.doClickLog(crmActions.getRefreshBtn(), "Click on Refresh button");
				Thread.sleep(1000);// Wait for 1 second before checking again
				eleUtil.scrollDownTillElementVisible(abnormalityInChamber);
			} else {
				try {
					eleUtil.textVerificationFormAttribute(abnormalityInChamber, "title", "No");
					eleUtil.textVerificationFormAttribute(abnormalityInOilInterceptor, "title", "No");
					break;
				} catch (NoSuchElementException e) {
					Log.error("Value for Abnormality In Chamber and Abnormality In Oil Interceptor are empty"
							+ e.getMessage());
				}
			}
		}
	}

	public void openLabReportPopUp() throws InterruptedException {
		eleUtil.scrollDownTillElementVisible(moreButtonOnPubLab);
		eleUtil.waitForVisibilityOfElement(moreButtonOnPubLab, 30);
		eleUtil.doClickLog(moreButtonOnPubLab, "click on More Button on Pub Lab");
		eleUtil.waitForVisibilityOfElement(attachButtonOnPubLab, 30);
		eleUtil.doClickLog(attachButtonOnPubLab, "click on Attach Button on Pub Lab");
	}

	public void uploadReportInPubLab() throws InterruptedException {
		Thread.sleep(2000);
		eleUtil.switchToFrame(switchToUploadLabReport);
		eleUtil.waitForVisibilityOfElement(browserButton, 30);
		// eleUtil.doClickLog(browserButton, "click on Browser Button");
		String path = filePath + WQPath;
		Log.info("final path to upload " + path);
		uploadFile(uploadFile, filePath + WQPath);
		eleUtil.waitForVisibilityOfElement(fileUploadButton, 30);
		eleUtil.doClickLog(fileUploadButton, "click on File Upload Button");
		eleUtil.switchToDefaultContent();
		eleUtil.waitForVisibilityOfElement(clickOk, 100);
		eleUtil.doClickLog(clickOk, "Click on OK button");
	}

	public void pubReportIsUploadAndCheckData() throws InterruptedException {
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (System.currentTimeMillis() < endTime) {
			if (eleUtil.elementIsDisplayed(checkPubLab, "Pub report not upload refresh the page") && eleUtil
					.elementIsDisplayed(checkSumHeavyMetal, "sum of heavy metal is not updated refresh the page")) {
				eleUtil.doClickLog(crmActions.getRefreshBtn(), "Click on Refresh button");
				Thread.sleep(1000);// Wait for 1 second before checking again
				crmActions.navigateToTab("Lab Report Result");
			} else {
				try {
					Log.info("Pub report uploaded successfully");
					eleUtil.textVerificationFormAttribute(checkNonCompliance, "aria-label", "Non-Compliance");
					eleUtil.textVerificationFormAttribute(checkSum, "aria-label", "10.100");
					break;
				} catch (NoSuchElementException e) {
					Log.error("Report is not reflected in the case" + e.getMessage());
				}
			}
		}
	}

	public void clickOnUploadLabReportSwitch() {
		eleUtil.waitForVisibilityOfElement(uploadLabReportSwitch, 30);
		eleUtil.doClickLog(uploadLabReportSwitch, "Click on Lab Report Switch button");
		crmActions.clickOnSaveButton();
	}

	public void checkSystemAndUserAssessment(String value) throws InterruptedException {
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (System.currentTimeMillis() < endTime) {
			if (eleUtil.elementIsDisplayed(emptyUserAssessment, "User Assessment is empty")
					&& eleUtil.elementIsDisplayed(emptySystemAssessment, "System Assessment is empty")) {
				eleUtil.doClickLog(crmActions.getRefreshBtn(), "Click on Refresh button");
				Thread.sleep(1000); // Wait for 1 second before checking again
			} else {
				try {
					eleUtil.textVerificationFormAttribute(getUserAssessment(), "title", value);
					eleUtil.textVerificationFormAttribute(getSystemAssessment(), "title", value);
					break;
				} catch (NoSuchElementException e) {
					Log.error("System and User Assessment are empty: " + e.getMessage());
				}
			}
		}
	}

	public void labResultNotification() throws InterruptedException {
		eleUtil.isPageLoaded(50);
		String beforeTapToOpenBtn = crmActions.setPageTitle();
		By notificationIDCheck = By
				.xpath("//div[@aria-label='Warning notification: Lab result value(s) are higher than expected range']"
						+ "//a[contains(text(), '" + beforeTapToOpenBtn + "')]");
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (System.currentTimeMillis() < endTime) {
			eleUtil.isPageLoaded(50);
			eleUtil.waitForVisibilityOfElement(crmActions.getNotificationIcon(), 50);
			eleUtil.doClick(crmActions.getNotificationIcon());
			eleUtil.waitForVisibilityOfElement(notificationIDCheck, 50);
			if (crmActions.notificationForRecordNumber(notificationIDCheck, beforeTapToOpenBtn,
					"Warning notification: Lab result value(s) are higher than expected range")) {
				break;
			}
			eleUtil.doClickLog(crmActions.getCancelBtn(), "Click on Cancel button");
			eleUtil.doClickLog(crmActions.getRefreshBtn(), "Click on Refresh button");
			Log.error("Actual Case number is not matched with the open Case number");
		}
	}

	public void selectListOfAdHocFactory() {
		eleUtil.waitForVisibilityOfElement(listOfFactoryListView, 100);
		eleUtil.doClickLog(listOfFactoryListView, "Click on Factory list view");
		eleUtil.waitForVisibilityOfElement(getSearchResults(), 100);
		eleUtil.doSendKeysLog(getSearchResults(), "List of Ad-hoc Factories", "Enter List of Ad-hoc Factories");
		eleUtil.waitForVisibilityOfElement(adHocView, 20);
		eleUtil.doClickLog(adHocView, "click on Ad-hoc Factories");
	}

	public void searchFactory() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(factoriesSearchBox, 20);
		Thread.sleep(2000);
		eleUtil.doSendKeys(factoriesSearchBox, factoryName);
		eleUtil.isPageLoaded(50);
		Thread.sleep(2000);
		driver.findElement(factoriesSearchBox).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		selectFirstRecord();
		getFirstRecord();
	}

	public void approveFactory() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(approveButton, 30);
		eleUtil.doClickLog(approveButton, "Click on Approve button");
		eleUtil.acceptAlert(100);
	}

	public void factoryApprovalNotification() throws InterruptedException {
		eleUtil.isPageLoaded(30);
		String beforeTapToOpenBtn = eleUtil.doGetElementAttribute(accountNumber, "title");
		By notificationIDCheck = By.xpath("//div[@aria-label='Informational notification: New Factory Added']"
				+ "//a[contains(text(), '" + beforeTapToOpenBtn + "')]");
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (System.currentTimeMillis() < endTime) {
			eleUtil.isPageLoaded(50);
			eleUtil.waitForVisibilityOfElement(crmActions.getNotificationIcon(), 50);
			eleUtil.doClick(crmActions.getNotificationIcon());
			if (crmActions.notificationForRecordNumber(notificationIDCheck, beforeTapToOpenBtn,
					"Informational notification: New Factory Added")) {
				break;
			}
			eleUtil.doClickLog(crmActions.getCancelBtn(), "Click on Cancel button");
			eleUtil.doClickLog(crmActions.getRefreshBtn(), "Click on Refresh button");
			Log.error("Actual Case number is not matched with the open Case number");
		}
	}

	public void approvalNotification() throws InterruptedException {
		// CommonActionsPage.casenumber= getCaseNumber();
		eleUtil.isPageLoaded(60);
		crmActions.notificationForTabToOpen(commonActionsPage.casenumber, "Inspection Case Information");
	}

	public void approvalChildNotification() throws InterruptedException {
		// CommonActionsPage.casenumber= getCaseNumber();
		eleUtil.isPageLoaded(60);
		crmActions.notificationForTabToOpen(commonActionsPage.childCaseNumber, "Inspection Case Information");
	}

	public void clickOnSavingInProgressOkButton() throws InterruptedException { // remove this code once issue is
																				// resolved
		eleUtil.isPageLoaded(100);
		if (eleUtil.elementIsDisplayed(getSavingInProgressPopUp(), "Saving in Progress Pop Up")) {
			eleUtil.waitForVisibilityOfElement(savingInProgressOkButton, 30);
			while (true) {
				List<WebElement> okButtons = driver.findElements(savingInProgressOkButton);
				if (okButtons.isEmpty()) {
					break;
				}
				for (WebElement button : okButtons) {
					try {
						button.click();
						// Refresh the list of elements after each click
						okButtons = driver.findElements(savingInProgressOkButton);
					} catch (Exception e) {
						Log.error("Error clicking on Ok button: {}" + e.getMessage());
					}
				}
			}
		} else {
			eleUtil.doClickLog(crmActions.getRefreshBtn(), "Click on Refresh button");
		}
	}

	public String getCaseReadOnly() {
		eleUtil.waitForVisibilityOfElement(caseReadOnly, 30);
		String record = eleUtil.doElementGetText(caseReadOnly);
		return record;
	}

	public String getCaseStatus() {
		eleUtil.waitForVisibilityOfElement(caseStatus, 30);
		String status = eleUtil.doElementGetText(caseStatus);
		return status;
	}

	public void checkCaseStatus(String status) {
		eleUtil.doClickLog(crmActions.getRefreshBtn(), "Click on Refresh button");
		String recordStatus = "Read-only This record’s status: Resolved";
		Assert.assertEquals(getCaseReadOnly(), recordStatus, "Status not matched");
		Assert.assertEquals(getCaseStatus(), status, "Status not matched");
	}

	public void WAStatusVal(String WAStatus) {
		eleUtil.waitForVisibilityOfElement(WADetailsSectionName, 10);
		jsutil.scrollIntoView(driver.findElement(WADetailsSectionName));
		eleUtil.waitForVisibilityOfElement(WAStatusField, 10);
		String actualStatus = eleUtil.doGetElementAttribute(WAStatusField, "title");
		assertEquals(actualStatus, WAStatus, "WAApplication status is not same");
	}

	public void WANumberVal(String WAnumVal) {
		By WANumberField = By.xpath("//input[contains(@title,'" + WAnumVal + "')]");
		eleUtil.waitForVisibilityOfElement(WADetailsSectionName, 10);
		jsutil.scrollIntoView(driver.findElement(WADetailsSectionName));
		eleUtil.waitForVisibilityOfElement(WANumberField, 10);
		String actualWANumberValue = eleUtil.doGetElementAttributeLog(WANumberField, "title", "WA Number is : ");
		assertTrue(actualWANumberValue.contains("TER"), "WA Number is empty field");
	}

	public void tradeGrpVal(String tradeGrp) {
		By tradeGroupField = By.xpath("//select[@title='" + tradeGrp + "']");
		eleUtil.waitForVisibilityOfElement(tradeGroupField, 10);
		String actualTradeGroupValue = eleUtil.doGetElementAttributeLog(tradeGroupField, "title",
				"Tradegroup value is : ");
		assertEquals(actualTradeGroupValue, tradeGrp, "WAApplication status is not same");

	}

	public void fpeVal(String fpeVal) {
		eleUtil.waitForVisibilityOfElement(fpeField, 10);
		eleUtil.createSelectLog(fpeField, "Click on the FPE/Non FPE dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(fpeField, fpeVal, "Selected FPE/Non FPE dropdown value is : ");
		String actualFPEValue = eleUtil.doGetElementAttributeLog(fpeField, "title", "FPE value is : ");
		assertEquals(actualFPEValue, fpeVal, "FPE value is not same");
	}

	public void entitySelectionInFactoryView() {
		eleUtil.waitForVisibilityOfElement(entitySelection, 10);
		eleUtil.doElementClickableLog(entitySelection, 20, "Entity field is clickable");
		eleUtil.doClickLog(entitySelection, "Click on Entity/Proj Reference No field in view");
	}

	

	public void uploadReportInPubLabtef(String path) throws InterruptedException {
		Thread.sleep(2000);
		eleUtil.switchToFrame(switchToUploadLabReport);
		eleUtil.waitForVisibilityOfElement(browserButton, 30);
		Log.info("final path to upload " + path);
		uploadFile(uploadFile, path);
		eleUtil.waitForVisibilityOfElement(fileUploadButton, 30);
		eleUtil.doClickLog(fileUploadButton, "click on File Upload Button");
		eleUtil.switchToDefaultContent();
		eleUtil.waitForVisibilityOfElement(clickOk, 100);
		eleUtil.doClickLog(clickOk, "Click on OK button");
		System.out.println("path is " + path);
	}

	public void pubReportIsUploadInHeavyMetalTab() {
		navigatingToTab("Lab Report Result");
		boolean flag = false;
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (!flag && (System.currentTimeMillis() < endTime)) {
			try {
				eleUtil.waitForVisibilityOfElement(morecommands, 30);
				eleUtil.doClickLog(morecommands, "Click on More Commands");
				eleUtil.doClickLog(refreshOnLabReportTab, " Report is not generated. So clicked on Refresh button");
				eleUtil.waitForVisibilityOfElement(checkPubLab, AppConstants.SHORT_DEFAULT_WAIT);
				if (eleUtil.elementIsDisplayed(checkPubLab, "Pub report not uploaded refresh the page")) {
					Log.info("Checking once again");
				} else {
					Log.info("Pub report uploaded successfully");
					break;
				}
			} catch (Exception e) {
				Log.error("Report is not reflected in the case: " + e.getMessage());
			}
		}

	}
}