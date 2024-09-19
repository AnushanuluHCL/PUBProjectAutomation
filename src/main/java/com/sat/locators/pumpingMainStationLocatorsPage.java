package com.sat.locators;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.testUtil.ExcelUtil;
import com.sat.testUtil.Log;

public class pumpingMainStationLocatorsPage extends commonActionsPage {
	commonCRMActions crmActions = new commonCRMActions(driver);
	commonActionsPage common = new commonActionsPage(driver);
	int i = 1;

	String filePath = System.getProperty("user.dir");

	// Loactors for entity creation
	private By entityType = By.xpath("//select[@aria-label='Entity Type']");
	private By projName = By.xpath("//input[contains(@aria-label,'Station Name')]");
	private By pumpingMainID = By.xpath("//textarea[@aria-label='Pumping Main Station ID']");
	private By catchment = By.xpath("//select[@aria-label='Catchment']");

	// LOcators for chamber creation
	private By newChamberBtn = By.xpath("//button[contains(@aria-label,'New Chambers Details')]");
	private By chamberId = By.xpath("//input[@aria-label='Chamber ID']");
	private By chamberName = By.xpath("//input[@aria-label='Chamber Name']");

	// Locators for checklist
	private By takeChamber = By.xpath("//input[@aria-label='Take Chamber Photo']/..");
	private By takeChamberUpload = By.xpath("//input[@aria-label='Take Chamber Photo']");
	private By takeUpstream = By.xpath("//input[@aria-label='Take Upstream Chamber Photo']/..");
	private By takeUpstreamUpload = By.xpath("//input[@aria-label='Take Upstream Chamber Photo']");
	private By takeDownstream = By.xpath("//input[@aria-label='Take Downstream Chamber Photo']/..");
	private By takeDownstreamUpload = By.xpath("//input[@aria-label='Take Downstream Chamber Photo']");
	private By anySewageSmell = By.xpath("//select[contains(@aria-label,'Any Sewage smell')]");
	private By anyWaterPonding = By.xpath("//select[contains(@aria-label,'Any Water Ponding')]");
	private By anySlopeFalure = By.xpath("//select[contains(@aria-label,'Any Slope Failure')]");
	private By anyConstructionZone = By.xpath("//select[contains(@aria-label,'Any Construction Sites')]");
	private By anythingToHeilight = By.xpath("//select[contains(@aria-label,'Anything to highlight')]");
	private By anyComments = By.xpath("//input[@aria-label='Any Other Comments']");
	private By photo1 = By.xpath("//div[@name='Question2']//descendant::input[@aria-label='Photo']/..");
	// h5[contains(@aria-label,'Anything to
	// highlight')]//descendant::input[@aria-label='Photo']/..

	public pumpingMainStationLocatorsPage(WebDriver driver) {
		super(driver);
	}

	public void entityTypeselection(String entityVal) {
		eleUtil.waitForVisibilityOfElement(entityType, 30);
		eleUtil.createSelectLog(entityType, "Selected the Entity Type dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(entityType, entityVal, "Selected Entity Type dropdown value is ");
	}

	public void clickonNewBtnInChamber() {
		eleUtil.doElementClickable(newChamberBtn, 30);
		eleUtil.doClickLog(newChamberBtn, "Clicked on new button");
	}

	public void entityName() {
		eleUtil.waitForVisibilityOfElement(projName, 10);
		eleUtil.doClickLog(projName, "Clicked on Pumping Main Station Name field");
		eleUtil.doClearUsingKeysLog(projName, "Clear the Pumping Main Station Name field");
		commonActionsPage.WRN7NMB_Projname = "Proj7nmb_" + eleUtil.todayDateAndTime();
		eleUtil.doSendKeysLog(projName, commonActionsPage.WRN7NMB_Projname, "Pumping Main Station Name is :");
		Log.info("project is : " + commonActionsPage.WRN7NMB_Projname);
	}

	public void pumpingStationId() {
		eleUtil.waitForVisibilityOfElement(pumpingMainID, 10);
		eleUtil.doClickLog(pumpingMainID, "Clicked on Pumping Main Station ID field");
		eleUtil.doClearUsingKeysLog(pumpingMainID, "Clear the Pumping Main Station ID field");
		eleUtil.doSendKeysLog(pumpingMainID, commonActionsPage.WRN7NMB_Projname, "Pumping Main Station ID is :");
	}

	public void selectMonth(String month) {
		By monthConfig = By.xpath("//span[@title='" + month + "']/../../following-sibling::div/descendant::select");
		eleUtil.waitForVisibilityOfElement(monthConfig, 30);
		eleUtil.createSelectLog(monthConfig, "Selected the Month dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(monthConfig, "Yes", "Selected Month dropdown value is ");
	}

	public void chamberSelection(int numberOfRecords) {
		for (int i = 1; i <= numberOfRecords; i++) {
			eleUtil.waitForVisibilityOfElement(chamberId, 10);
			eleUtil.doClickLog(chamberId, "Clicked on Chamber Id field");
			eleUtil.doClearUsingKeysLog(chamberId, "Clear the Chamber Id field");

			commonActionsPage.chamberId.put(+i, "ch_" + eleUtil.todayDateAndTime());
			eleUtil.doSendKeysLog(chamberId, commonActionsPage.chamberId.get(i), "Chamber Id is :");

			eleUtil.waitForVisibilityOfElement(chamberName, 10);
			eleUtil.doClickLog(chamberName, "Clicked on Chamber Id field");
			eleUtil.doClearUsingKeysLog(chamberName, "Clear the Chamber Id field");
			eleUtil.doSendKeysLog(chamberName, commonActionsPage.chamberId.get(i), "Chamber Id is :");
		}
	}

	public void chamberID() {
		eleUtil.waitForVisibilityOfElement(chamberId, 10);
		eleUtil.doClickLog(chamberId, "Clicked on Chamber Id field");
		eleUtil.doClearUsingKeysLog(chamberId, "Clear the Chamber Id field");
		commonActionsPage.chamberId.put(+i, "ch_" + eleUtil.todayDateAndTime());
		eleUtil.doSendKeysLog(chamberId, commonActionsPage.chamberId.get(i), "Chamber Id is :");
	}

	public void chamberName() {
		eleUtil.waitForVisibilityOfElement(chamberName, 10);
		eleUtil.doClickLog(chamberName, "Clicked on Chamber Id field");
		eleUtil.doClearUsingKeysLog(chamberName, "Clear the Chamber Id field");
		eleUtil.doSendKeysLog(chamberName, commonActionsPage.chamberId.get(i), "Chamber Id is :");
	}

	public void selectChecklistForWRN7NMB(String complainceval) throws InterruptedException {

		eleUtil.waitTillElementIsDisplayed(takeChamber, 30);
		eleUtil.doClickLog(takeChamber, "Clicked on Choose File for Take Chamber field");
		common.uploadFile(takeChamberUpload, filePath + "\\src\\test\\resources\\testdata\\UploadForChecklist.xlsx");

		eleUtil.waitTillElementIsDisplayed(takeUpstream, 30);
		eleUtil.doClickLog(takeUpstream, "Clicked on Choose File for Take Upstream Chamber field");
		common.uploadFile(takeUpstreamUpload, filePath + "\\src\\test\\resources\\testdata\\UploadForChecklist.xlsx");

		eleUtil.waitTillElementIsDisplayed(takeDownstream, 30);
		eleUtil.doClickLog(takeDownstream, "Clicked on Choose File for Take Downstream Chamber field");
		common.uploadFile(takeDownstreamUpload, filePath + "\\src\\test\\resources\\testdata\\UploadForChecklist.xlsx");

		eleUtil.waitTillElementIsDisplayed(anySewageSmell, 30);
		eleUtil.selectDropDownValue(anySewageSmell, "selectByVisibleText", complainceval,
				"Select " + complainceval + " Any Sewage smell? field");

		eleUtil.waitTillElementIsDisplayed(anyWaterPonding, 30);
		eleUtil.selectDropDownValue(anyWaterPonding, "selectByVisibleText", complainceval,
				"Select " + complainceval + " Any Water Ponding? field");

		eleUtil.waitTillElementIsDisplayed(anySlopeFalure, 30);
		eleUtil.selectDropDownValue(anySlopeFalure, "selectByVisibleText", complainceval,
				"Select " + complainceval + " Any Slope Failure? field");

		eleUtil.waitTillElementIsDisplayed(anyConstructionZone, 30);
		eleUtil.selectDropDownValue(anyConstructionZone, "selectByVisibleText", complainceval,
				"Select " + complainceval + " Any Construction Sites / Work within Protection Zone? field");

		eleUtil.waitTillElementIsDisplayed(anythingToHeilight, 30);
		eleUtil.selectDropDownValue(anythingToHeilight, "selectByVisibleText", complainceval,
				"Select " + complainceval + " Anything to highlight? field");

		eleUtil.waitTillElementIsDisplayed(anyComments, 30);
		eleUtil.doClickLog(anyComments, "Clicked on Any Other Comment field");
		eleUtil.doClearUsingKeysLog(anyComments, "Clear the Any Other Comment field");
		eleUtil.doSendKeysLog(anyComments, "Tester A", "Any Other Comment is :");

		if (complainceval.equals("Yes")) {
			By remarksField = By.xpath("//input[contains(@aria-label,'Remarks')]");
			By photoUpload = By.xpath("//input[@aria-label=' Photo' or @aria-label='Photo']");
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

		} else {
			System.out.println("Test");
		}
	}

	public void fillCheckListQuestionsForWRN7NMB(String complainceval) throws InterruptedException {
		commonActionsPage.WOnumber = crmActions.getWONumber();
		List<String> woNum = commonActionsPage.WOnumber;
		Thread.sleep(2000);
		Log.info("print wo number " + woNum);
		Log.info("size is:" + woNum.size());
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			crmActions.openCheckList(woNum.get(i), "WRN7 IMB Pumping Main Alignment Walk", "In Progress");
			selectChecklistForWRN7NMB(complainceval);
			crmActions.saveChecklist();
		}
	}

}
