package com.sat.locators;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.sat.Pages.commonActionsPage;
import com.sat.constants.AppConstants;
import com.sat.testUtil.Log;

public class WRN1CaseLocatorsPage extends commonActionsPage {



		// Locators for Lab report
	private By newLabReportBtn = By.xpath("//button[contains(@aria-label,'New Lab Report')]");
	private By sampleRefNoFieldSearchsymbol = By
			.xpath("//button[contains(@aria-label,'Search records for  Lab Sample Ref No')]");
	private By selectFirstRecord = By.xpath("(//li[contains(@data-id,'pub_')])[1]");// (//li[contains(@data-id,'pub_labreportheader')])[1]
	private By reportTypeField = By.xpath("//select[contains(@data-id,'pub_reporttype')]");// GCMS
	private By chemicalLookupField = By.xpath("//input[contains(@aria-label,'Substance/Chemical Name')]");
	private By chemicalLookupvalue = By.xpath("//span[contains(@data-id,'pub_teregulation.fieldControl-pub_name')]");// span[contains(@data-id,'pub_teregulation_resultsLabel')]
	private By concentrationField = By.xpath("//input[contains(@aria-label,'Result')]");
	private By saveNcloseBtnInQuickCreateLabreportForm = By.xpath("//button[@aria-label='Save and Close']");
	private By labReportUploadToggleBtn = By.xpath("//button[contains(@aria-label,'Lab Report Uploaded:')]");
	private By systemAssesment = By
			.xpath("//section[@aria-label='Lab Results for Inspection Case']//select[@aria-label='System Assessment']");

	private By refreshBtn = By.xpath("//button[@aria-label='Refresh']");

	private By caseid = By.xpath("//input[@aria-label='Case ID']");
	private By statusField = By.xpath("//div[text()='Status']/preceding-sibling::div/div");
	private By workOrderVerify = By.xpath("//div[@col-id='msdyn_name']//a");
	private By saveNContinueBtn = By.xpath("//span[text()='Save and continue']");

	// Locators for TEF scheme
	private By interestedIntogleBtn = By.xpath("//button[@aria-label='Interested in TEF Scheme: No']");
	private By waterConsumptionField = By.xpath("//input[contains(@aria-label,'Water Consumption')]");
	private By TEFAccNumField = By.xpath("//input[contains(@aria-label,'TEF account number')]");
	private By monthlyReturnFormfieldsymbol = By
			.xpath("//button[@aria-label='Search records for Monthly Return Form, Lookup field']");

	public WRN1CaseLocatorsPage(WebDriver driver) {
		super(driver);
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

	public void selectChemicalValue(String chemicalval) {
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
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				eleUtil.waitForVisibilityOfElement(refreshBtn, 10);
				eleUtil.doClickLog(refreshBtn, "clicked on refresh button");
				navigatingToTab("Lab Report Result");
				eleUtil.waitForVisibilityOfElement(systemAssesment, AppConstants.SHORT_DEFAULT_WAIT);
				systemAssesmentfieldval = eleUtil.doGetElementAttribute(systemAssesment, "title");
				if (systemAssesmentfieldval.contains("Compliance")
						|| systemAssesmentfieldval.contains("Non-Compliance")) {
					flag = true;
				}
			} catch (Exception e) {
				Log.error("System Assesment is not updated. So clicking on refresh button again");
			}
		}
		return eleUtil.doGetElementAttributeLog(systemAssesment, "title", "System assesment is : ");
	}

	public void caseNamevalue(String startsWithName) {
		clickOnRefreshBtnOnHome();
		eleUtil.isPageLoaded(30);
		try {
			if (eleUtil.elementIsDisplayed(By.xpath("//div[contains(@id,'modalDialogView_')]"),"Save and continue Pop Up")) {
				while (true) {
					try {
						eleUtil.doElementClickable(saveNContinueBtn, 10); // Assuming eleUtil has the doElementClickable
																			// method
						eleUtil.doClick(saveNContinueBtn); // Assuming eleUtil has the doClick method
					} catch (org.openqa.selenium.NoSuchElementException e) {
						break; // Exit the loop if the button is no longer found
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clickOnRefreshBtnOnHome();
		try {
			commonActionsPage.casenumber = eleUtil.doGetElementAttribute(caseid, "title");
			assertTrue(commonActionsPage.casenumber.startsWith(startsWithName), "Case number format is not expected");
			Log.info(commonActionsPage.casenumber);
			return;
		} catch (NoSuchElementException e) {
			Log.error("Case number element not found: " + e.getMessage());
		}
	}

	public String getWorkOrderNumber() {
		String workOrder = eleUtil.doElementGetText(workOrderVerify);
		return workOrder;
	}

	public void clickOnInterestedInTEFToggleBtn() {
		eleUtil.waitForVisibilityOfElement(interestedIntogleBtn, 10);
		eleUtil.doClickLog(interestedIntogleBtn, "Clicked on Interested in TEF Scheme toggle button");
	}

	public void sendWaterConsumptionFieldVal(String value) {
		eleUtil.waitForVisibilityOfElement(waterConsumptionField, 10);
		eleUtil.doClickLog(waterConsumptionField, "Clicked on Water Consumption field");
		eleUtil.doSendKeysLog(waterConsumptionField, value, "Water Consumption is :");
	}

	public void sendTEFAccNumFieldVal(String value) {
		eleUtil.waitForVisibilityOfElement(TEFAccNumField, 10);
		eleUtil.doClickLog(TEFAccNumField, "Clicked on TEF account number field");
		eleUtil.doSendKeysLog(TEFAccNumField, value, "TEF account number is :");
	}

	public void selectMonthlyReturnForm() {
		eleUtil.waitForVisibilityOfElement(monthlyReturnFormfieldsymbol, 30);
		eleUtil.doActionsMoveToElement(monthlyReturnFormfieldsymbol, "Clicked on Monthly Return Form field");
		eleUtil.waitForVisibilityOfElement(selectFirstRecord, 30);
		eleUtil.doActionsMoveToElement(selectFirstRecord, "Clicked on first record");
	}

}
