package com.sat.locators;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.constants.AppConstants;
import com.sat.testUtil.ExcelUtil;
import com.sat.testUtil.Log;

public class ConstructionLocatorsPage extends commonActionsPage {
	commonCRMActions crmActions = new commonCRMActions(driver);
	commonActionsPage common = new commonActionsPage(driver);

	String filePath = System.getProperty("user.dir");

	private By entityvalue = By.xpath("(//div[@col-id='name\'])[2]//span");

	// Loactors for project
	private By mukimNo = By.xpath("//input[@aria-label='Mukim Number']");
	private By lotNo = By.xpath("//input[@aria-label='Lot Number']");
	private By newBtnforGERIResp = By.xpath("//button[contains(@aria-label,'New CS GERI Response')]");
	private By projMukimLotNumber = By.xpath("//input[@aria-label='Project Mukim Lot Number']");
	private By diameter = By.xpath("//input[@aria-label='Diameter']");
	private By affectByDtss = By.xpath("//select[@aria-label='Affected by DTSS']");
	private By affectBySewer = By.xpath("//select[@aria-label='Affected by Sewer']");
	private By projValInShortlistView = By.xpath("//div[@col-id='name' and @role != 'columnheader']//span");

	// Locators for shortlist view
	private By approveBtn = By.xpath("//button[contains(@aria-label,'Approve')]");

	// Locators for cases entity
	private By entitynameOnCaseForm = By.xpath("(//div[@col-id='customerid']//a)[1]");
	private By caseidOnCaseForm = By.xpath("//div[@col-id='title']//a");
	private By entitydropdown = By.xpath("(//div[@col-id='customerid'])[1]");

	// Locators for checklist
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

	// Locators for updating Reinspection information
	private By reinspectionDate = By.xpath("//input[@aria-label='Date of Re Inspection date']");
	private By reinspection = By.xpath("//select[@aria-label='Re-inspection']");
	private By reinspectinSelectedVal = By.xpath("//select[@aria-label='Re-inspection']/option[@data-selected='true']");

	public ConstructionLocatorsPage(WebDriver driver) {
		super(driver);
	}

	public String getRandomProjName() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		String currentDateTime = formatter.format(date);
		currentDateTime = currentDateTime.replaceAll("\\W", "");
		commonActionsPage.WRN8NMB_Projname = "Projrefno_" + currentDateTime;
		return commonActionsPage.WRN8NMB_Projname;

	}

	public void updateExcelForConstructioncreation(String project_title) {
		try {
			excelUtil = new ExcelUtil(filePath + "\\src\\test\\resources\\testdata\\8NMB_ConstructionCreation.xlsx");
			excelUtil.setSheet("List of Construction Sites"); // Ensure this is the correct sheet name
			excelUtil.setCellValue(1, 3, getRandomProjName()); // Column 3 for "Entity Name/Project Reference No"
			System.out.println("value from updateexcel" + getRandomProjName());
			excelUtil.setCellValue(1, 4, project_title); // Column 4 for "Project Title"
			excelUtil.setCellValue(1, 5, "562567"); // Column 5 for "Postal Code"
			excelUtil.setCellValue(1, 8, "Struct"); // Column 8 for "Type of Work"
			excelUtil.setCellValue(1, 12, "4 Years"); // Column 12 for "Proj Duration"
			excelUtil.setCellValue(1, 15, "Construction sites"); // Column 15 for "Entity Type"
			excelUtil.setCellValue(1, 16, "Covan Coa"); // Column 16 for "Contractor"
			excelUtil.setCellValue(1, 17, "Covan Coa"); // Column 17 for "Professional Engineer"
			excelUtil.saveAndClose();
			Log.error("Excel file updated and closed successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			Log.error("Values are not updated in the excel");

		}
	}

	public void datachecking() {
		boolean isValueVisible = false;
		while (!isValueVisible) {
			try {
				eleUtil.waitForVisibilityOfElement(entityvalue, 40);
				String actualProj = eleUtil.doElementGetText(entityvalue);
				Log.info("Retrieved text: " + actualProj);
				if (actualProj.equals(commonActionsPage.WRN8NMB_Projname)) {
					isValueVisible = true;
					eleUtil.doElementGetTextLog(entityvalue, "Entity name/Project Reference No. is : ");
					Log.info("Field value is now visible and matches the expected value!");
				} else {
					Log.info("Field value does not match expected value. Retrying...");
					eleUtil.doClickLog(crmActions.getRefreshBtn(), "Clicked on refresh button");
				}
			} catch (Exception e) {
				Log.error("Entity Name/Project Reference No. is not updated.So clicking on refresh button again");
			}
		}
	}

	public void mukimVal(String value) {
		eleUtil.waitForVisibilityOfElement(mukimNo, 10);
		eleUtil.doClickLog(mukimNo, "Clicked on Mukim Number field");
		eleUtil.doClearUsingKeysLog(mukimNo, "Clear the Mukim Number field");
		eleUtil.doSendKeysLog(mukimNo, value, "Mukim Number is :");
	}

	public void lotVal(String value) {
		eleUtil.waitForVisibilityOfElement(lotNo, 10);
		eleUtil.doClickLog(lotNo, "Clicked on Lot Number field");
		eleUtil.doClearUsingKeysLog(lotNo, "Clear the Lot Number field");
		eleUtil.doSendKeysLog(lotNo, value, "Lot Number is :");
	}

	public void newGERIResponseBtn() {
		eleUtil.waitForVisibilityOfElement(newBtnforGERIResp, 10);
		eleUtil.doClickLog(newBtnforGERIResp, "Clicked on new button");
	}

	public void projMukimLotNo(String value) {
		eleUtil.waitForVisibilityOfElement(projMukimLotNumber, 10);
		eleUtil.doClickLog(projMukimLotNumber, "Clicked on Project Mukim Lot Number field");
		eleUtil.doClearUsingKeysLog(projMukimLotNumber, "Clear the Project Mukim Lot Number field");
		eleUtil.doSendKeysLog(projMukimLotNumber, value, "Project Mukim Lot Number is :");
	}

	public void diameterVal(String value) {
		eleUtil.waitForVisibilityOfElement(diameter, 10);
		eleUtil.doClickLog(diameter, "Clicked on Diameter field");
		eleUtil.doClearUsingKeysLog(diameter, "Clear the Diameter field");
		eleUtil.doSendKeysLog(diameter, value, "Diameter is :");
	}

	public void affectedByDTSSVal(String value) {
		eleUtil.waitForVisibilityOfElement(affectByDtss, 30);
		eleUtil.createSelectLog(affectByDtss, "Selected the Affected By DTSS dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(affectByDtss, value, "Selected Affected By DTSS dropdown value is ");
	}

	public void affectedBySewerVal(String value) {
		eleUtil.waitForVisibilityOfElement(affectBySewer, 30);
		eleUtil.createSelectLog(affectBySewer, "Selected the Affected By Sewer dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(affectBySewer, value, "Selected Affected By Sewer dropdown value is ");
	}

	public void compareProjValue() {
		eleUtil.waitForVisibilityOfElement(projValInShortlistView, 30);
		String ProjectNo = eleUtil.doElementGetTextLog(projValInShortlistView, "Project value ");
		if (ProjectNo.equals(commonActionsPage.WRN8NMB_Projname)) {
			Log.info("Project created is available in shortlist view");
		} else {
			Log.info("Project created is not available in shortlist view");
		}
	}

	public void approveproj() throws InterruptedException {
		selectFirstRecord();
		eleUtil.waitForVisibilityOfElement(approveBtn, 30);
		eleUtil.doClickLog(approveBtn, "Clicked on approve button");
		// eleUtil.doClickWithWait(approveBtn, AppConstants.LONG_DEFAULT_WAIT);
		eleUtil.isPageLoaded(100);
		eleUtil.acceptJSAlert(50);
		System.out.println("Alert clicked successfully");
		Log.info("Case created successfully");
	}

	public void entitySelectionInCaseView() {
		eleUtil.waitForVisibilityOfElement(entitydropdown, 10);
		eleUtil.doElementClickableLog(entitydropdown, 20, "Entity field is clickable");
		eleUtil.doClickLog(entitydropdown, "Click on Entity/Proj Reference No field in view");
	}

	public void caseCreationCheck() {
		eleUtil.waitForVisibilityOfElement(entitynameOnCaseForm, 30);
		String entitynameonCase = eleUtil.doGetElementAttribute(entitynameOnCaseForm, "aria-label");
		System.out.println(
				"entitynameonCase - " + entitynameonCase + "Project Name - " + commonActionsPage.WRN8NMB_Projname);
		// Assert.assertEquals(entitynameonCase, commonActionsPage.WRN8NMB_Projname);
		Log.info("Case created successfully");
		commonActionsPage.casenumber = eleUtil.doElementGetText(caseidOnCaseForm);
		Log.info("Case number is: " + commonActionsPage.casenumber);
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
		// eleUtil.doSendKeysLog(sendfileToReport, filePath +
		// "\\src\\test\\resources\\testdata\\UploadForChecklist.xlsx", "Attched
		// repport");
		try {
			common.uploadFile(sendfileToReport, filePath + "\\src\\test\\resources\\testdata\\UploadForChecklist.xlsx");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fillCheckListQuestionsforWRN8NMB() throws InterruptedException {
		commonActionsPage.WOnumber = crmActions.getWONumber();
		List<String> woNum = commonActionsPage.WOnumber;
		Thread.sleep(2000);
		Log.info("print wo number " + woNum);
		Log.info("size is:" + woNum.size());
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), "BCA Project Site Inspection affecting Public Sewerage System");
			selectChecklistForWRN8NMB();
			crmActions.saveChecklist();
		}
	}

	public void verifyReinspectionValue() {
		eleUtil.waitForVisibilityOfElement(reinspection, 30);
		String reinspectionVal = eleUtil.doElementGetText(reinspectinSelectedVal);
		Assert.assertEquals(reinspectionVal, "Yes", "Reinspection value is not matching");
	}

	public void verifyReinspectionDate() throws ParseException {
		String reinspectionDateVal = eleUtil.doGetElementAttribute(reinspectionDate, "value");
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MMM/yyyy");
		// LocalDate today = LocalDate.now();
		Date today = new Date();
		String formattedDate = timeFormat.format(today);
		// Date date = timeFormat.parse(today);
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		// cal.add(Calendar.MONTH, 3);
		cal.add(Calendar.DAY_OF_WEEK, 90);
		String result = timeFormat.format(cal.getTime());
		System.out.println("After updation result" + result);
		//Assert.assertEquals(reinspectionDateVal, result, "Reinspection Date is not matching");
	}

	public void updateReinspectionDateVal() {
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MMM/yyyy");
		Date today = new Date();
		String formattedDate = timeFormat.format(today);
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_WEEK, 7);
		String result = timeFormat.format(cal.getTime());
		System.out.println("Date after 7 days is " + result);

		eleUtil.waitForVisibilityOfElement(reinspectionDate, 40);
		eleUtil.doElementClickable(reinspectionDate, 30);
		// eleUtil.doClickLog(reinspectionDate, "Clicked on Reinspection Date field");
		eleUtil.doClearUsingKeysLog(reinspectionDate, "Clear Reinspection Date field");
		eleUtil.doClear(reinspectionDate);
		clickOnSaveBtn();
		eleUtil.waitForVisibilityOfElement(reinspectionDate, 60);
		//eleUtil.doClickLog(reinspectionDate, "Clicked on Reinspection Date field");
		eleUtil.doSendKeysLog(reinspectionDate, result, "Entered value is : ");
		 try {
		        Thread.sleep(2000); // Wait for 2 seconds (adjust as necessary)
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		 clickOnSaveBtn();
		 eleUtil.waitForVisibilityOfElement(reinspectionDate, 60);
	}

	public void verifyNewWoType(String type) {
		List<String> wonum = commonActionsPage.WOnumber;
		System.out.println("Size of wonum list is: " + wonum.size());

		for (int i = 0; i < wonum.size(); i++) {
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.waitForVisibilityOfElement(woele, 30);
			eleUtil.doActionsClick(woele);
			By status = By.xpath("//label[@aria-label='Scheduled']");
			String actualStatusval = eleUtil.doGetElementAttribute(status, "aria-label");
			if (actualStatusval.equals("Scheduled")) {
				String actualWOType = eleUtil.doGetElementAttributeLog(By.xpath("//label[@aria-label='" + type + "']"),
						"aria-label", "New WO type is: is ");
				Assert.assertEquals(actualWOType, type, "WO Type is not matching");
				break;
			}
			
		}
	}

}