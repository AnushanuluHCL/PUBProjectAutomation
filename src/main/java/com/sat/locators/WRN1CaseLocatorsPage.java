package com.sat.locators;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.sat.Pages.CommonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.constants.AppConstants;
import com.sat.testUtil.Log;

public class WRN1CaseLocatorsPage extends CommonActionsPage {
	

	// Locators for BPF
	private By allDocsReceived = By.xpath("//select[@aria-label='All Documents Received']");

	// Locators for Lab report
	private By newLabReportBtn = By.xpath("//button[contains(@aria-label,'New Lab Report')]");
	private By sampleRefNoFieldSearchsymbol = By
			.xpath("//button[contains(@aria-label,'Search records for  Lab Sample Ref No')]");
	private By selectFirstRecord = By.xpath("(//li[contains(@data-id,'pub_labreportheader')])[1]");
	private By reportTypeField = By.xpath("//select[contains(@data-id,'pub_reporttype')]");// GCMS
	private By chemicalLookupField = By.xpath("//input[contains(@aria-label,'Substance/Chemical Name')]");
	private By chemicalLookupvalue = By.xpath("//span[contains(@data-id,'pub_teregulation.fieldControl-pub_name')]");// span[contains(@data-id,'pub_teregulation_resultsLabel')]
	private By concentrationField = By.xpath("//input[contains(@aria-label,'Result')]");
	private By saveNcloseBtnInQuickCreateLabreportForm = By.xpath("//button[@aria-label='Save and Close']");
	private By labReportUploadToggleBtn = By.xpath("//button[contains(@aria-label,'Lab Report Uploaded:')]");
	private By systemAssesment = By.xpath("//select[@aria-label='System Assessment']");

	private By refreshBtn = By.xpath("//button[@aria-label='Refresh']");

	private By caseid = By.xpath("//input[@aria-label='Case ID']");
	private By statusField = By.xpath("//div[text()='Status']/preceding-sibling::div/div");
	 private By workOrderVerify = By.xpath("//div[@col-id='msdyn_name']//a");

	public WRN1CaseLocatorsPage(WebDriver driver) {
		super(driver);
	}

	public void confirmDocuemntsReceived() {
		eleUtil.waitForVisibilityOfElementLog(allDocsReceived, 20, "Waiting for the All Documents Received element");
		eleUtil.createSelectLog(allDocsReceived, "Selected the All Documents Received dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(allDocsReceived, "Yes", "Selected dropdown value is :");
	}

	public void clickOnNewLabReport() {
		eleUtil.waitForVisibilityOfElement(newLabReportBtn, 10);
		eleUtil.doClickLog(newLabReportBtn, "Clicked on new lab report button");
	}

	public void selectLabRefNoVal() {
		eleUtil.waitForVisibilityOfElement(sampleRefNoFieldSearchsymbol, 30);
		eleUtil.doActionsMoveToElement(sampleRefNoFieldSearchsymbol, "Clicked on Lab Sample Reference No. field");
		eleUtil.waitForVisibilityOfElement(selectFirstRecord, 10);
		eleUtil.doClickLog(selectFirstRecord, "Clicked on first record");
	}

	public void selectReportType(String reportTypeval) {
		eleUtil.waitForVisibilityOfElement(reportTypeField, 30);
		eleUtil.createSelectLog(reportTypeField, "Selected the Report Type dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(reportTypeField, reportTypeval,
				"Selected Report Type dropdown value is ");
	}

	public void selectChemicalValue(String chemicalval) throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(chemicalLookupField, 10);
		eleUtil.doClickLog(chemicalLookupField, "Clicked on Substance/Chemical Name field");
		eleUtil.doSendKeysLog(chemicalLookupField, chemicalval, "Substance/Chemical Name is :");
		eleUtil.waitForVisibilityOfElement(chemicalLookupvalue, 10);
		eleUtil.doActionsMoveToElement(chemicalLookupvalue, "clicked on the value");
	}

	public void peakDischargeRate(String concentrationval) {
		eleUtil.waitForVisibilityOfElement(concentrationField, 10);
		eleUtil.doClickLog(concentrationField, "Clicked on Result/Concentration field");
		eleUtil.doClearUsingKeysLog(concentrationField, "Clear the Result/Concentration field");
		eleUtil.doSendKeysLog(concentrationField, concentrationval, "Result/Concentration value is :");
	}

	public void saveNCloseQuickCreateForm() {
		eleUtil.waitForVisibilityOfElement(saveNcloseBtnInQuickCreateLabreportForm, 10);
		eleUtil.doClickLog(saveNcloseBtnInQuickCreateLabreportForm, "Clicked on Save and Close button");
	}

	public void clickOnLabReportToggleBtn() {
		eleUtil.waitForVisibilityOfElement(labReportUploadToggleBtn, 10);
		eleUtil.doClickLog(labReportUploadToggleBtn, "Clicked on Lab report uploaded toggle button");
	}

	public String complainceStatus() {
		String systemAssesmentfieldval = eleUtil.doGetElementAttribute(systemAssesment, "title");
		boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 100000) {
			try {
				eleUtil.waitForVisibilityOfElement(refreshBtn, 10);
				eleUtil.doClickLog(refreshBtn, "clicked on refresh button");
				navigatingToTab("Lab Report Result");
				eleUtil.waitForVisibilityOfElement(systemAssesment, AppConstants.SHORT_DEFAULT_WAIT);
				systemAssesmentfieldval = eleUtil.doGetElementAttribute(systemAssesment, "title");
				if (!systemAssesmentfieldval.isEmpty()) {
					flag = true;
				}
			} catch (Exception e) {
				Log.error("System Assesment is not updated. So clicking on refresh button again");
			}
		}
		return eleUtil.doGetElementAttributeLog(systemAssesment, "title", "System assesment is : ");
	}

	public void caseNamevalue(String startsWithName) {
		//clickOnRefreshBtnOnHome();
		try {
			CommonActionsPage.casenumber = eleUtil.doGetElementAttribute(caseid, "title");
			assertTrue(CommonActionsPage.casenumber.startsWith(startsWithName), "Case number format is not expected");
			Log.info(CommonActionsPage.casenumber);
			return;
		} catch (NoSuchElementException e) {
			Log.error("Case number element not found: " + e.getMessage());
		}
	}
	

    public String getWorkOrderNumber() {
        String workOrder = eleUtil.doElementGetText(workOrderVerify);
        return workOrder;
    }
	
	
	

}



