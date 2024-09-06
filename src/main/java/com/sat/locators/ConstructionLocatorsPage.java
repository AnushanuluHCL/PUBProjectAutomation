package com.sat.locators;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.constants.AppConstants;
import com.sat.testUtil.ExcelUtil;
import com.sat.testUtil.Log;

public class ConstructionLocatorsPage extends commonActionsPage {
	commonCRMActions crmActions = new commonCRMActions(driver);

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
		eleUtil.doSelectDropDownByVisibleTextLog(affectByDtss, value,
				"Selected Affected By DTSS dropdown value is ");
	}
	public void affectedBySewerVal(String value) {
		eleUtil.waitForVisibilityOfElement(affectBySewer, 30);
		eleUtil.createSelectLog(affectBySewer, "Selected the Affected By Sewer dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(affectBySewer, value,
				"Selected Affected By Sewer dropdown value is ");
	}
	
	public void compareProjValue() {
		String ProjectNo = eleUtil.doElementGetTextLog(projValInShortlistView, "Project value ");
		if(ProjectNo.equals(commonActionsPage.WRN8NMB_Projname)) {
			Log.info("Project created is available in shortlist view");
		}
		else {
			Log.info("Project created is not available in shortlist view");
		}
	}

}
