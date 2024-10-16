package com.sat.locators;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.constants.AppConstants;
import com.sat.testUtil.Log;

public class eatingEstablishmentLocatorsPage extends commonActionsPage {

	// Locators for EE project creation
	private By contactEmail = By.xpath("//input[@aria-label='Contact Email']");
	private By primaryContact = By.xpath("//input[contains(@aria-label,'Primary Contact')]");
	private By primaryContactsearchBtn = By
			.xpath("//button[@aria-label='Search records for Primary Contact, Lookup field']");
	private By firstContactRecord = By.xpath("(//li[contains(@data-id,'primary')])[1]");
	private By noOfGts = By.xpath("//input[@aria-label='No. of GTs']");
	private By levelNumber = By.xpath("//input[@aria-label='Level Number']");
	private By unitNumber = By.xpath("//input[@aria-label='Unit Number']");
	private By SFALicenceNumber = By.xpath("//input[@aria-label='SFA License Number']");
	private By EEId = By.xpath("//input[@aria-label='EE ID']");
	private By refreshBtn = By.xpath("//button[contains(@aria-label,'Refresh')]");

	private By countOfCreatedGts = By
			.xpath("//div[contains(@data-id,'Subgrid')]//span[contains(@class,'statusContainer')]");

	public eatingEstablishmentLocatorsPage(WebDriver driver) {
		super(driver);
	}

	public By getContactEmail() {
		return contactEmail;
	}

	public By getPrimaryContact() {
		return primaryContactsearchBtn;
	}

	public By selectingFirstRecord() {
		return firstContactRecord;
	}

	public By getNoOfGts() {
		return noOfGts;
	}
	public By countOfGts() {
		return countOfCreatedGts;
	}

	public By getLevelNumber() {
		return levelNumber;
	}

	public By getUnitNumber() {
		return unitNumber;
	}

	public By getSFALicenceNumber() {
		return SFALicenceNumber;
	}

	public By getEEId() {
		return EEId;
	}

	public By clickRefreshBtnOnHome() {
		return refreshBtn;
	}

	public void enterContactEmail() {
		eleUtil.waitTillElementIsDisplayed(getContactEmail(), 30);
		eleUtil.doClickLog(getContactEmail(), "Clicked on Contact Email field");
		eleUtil.doClearUsingKeysLog(getContactEmail(), "Clear the Contact Email  field");
		eleUtil.doSendKeysLog(getContactEmail(), "test@gmail.com", " Contact Email  is : ");
	}

	public void enterPrimaryContact() {
		eleUtil.waitTillElementIsDisplayed(primaryContact, 30);
		eleUtil.doActionsMoveToElement(getPrimaryContact(), "Clicked on Primary Contact field");
		eleUtil.waitForVisibilityOfElement(selectingFirstRecord(), 30);
		eleUtil.doActionsMoveToElement(selectingFirstRecord(), "Clicked on first record");
	}

	public void enterNoOfGts(String countOfGts) {
		eleUtil.waitTillElementIsDisplayed(getNoOfGts(), 30);
		eleUtil.doClickLog(getNoOfGts(), "Clicked on No. of GTs field");
		eleUtil.doClearUsingKeysLog(getNoOfGts(), "Clear the No. of GTs  field");
		eleUtil.doSendKeysLog(getNoOfGts(), countOfGts, " Entered number is :" + countOfGts);
	}

	public void enterLevelNumber() {
		eleUtil.waitTillElementIsDisplayed(getLevelNumber(), 30);
		eleUtil.doClickLog(getLevelNumber(), "Clicked on Level Number field");
		eleUtil.doClearUsingKeysLog(getLevelNumber(), "Clear the Level Number  field");
		eleUtil.doSendKeysLog(getLevelNumber(), "7", " Level Number  is : ");
	}

	public void enterUnitNumber() {
		eleUtil.waitTillElementIsDisplayed(getUnitNumber(), 30);
		eleUtil.doClickLog(getUnitNumber(), "Clicked on Unit Number field");
		eleUtil.doClearUsingKeysLog(getUnitNumber(), "Clear the Unit Number field");
		eleUtil.doSendKeysLog(getUnitNumber(), "33", " Unit Number is : ");
	}

	public void enterSFALicenceNumber() {
		eleUtil.waitTillElementIsDisplayed(getSFALicenceNumber(), 30);
		eleUtil.doClickLog(getSFALicenceNumber(), "Clicked on SFA License Number field");
		eleUtil.doClearUsingKeysLog(getSFALicenceNumber(), "Clear the SFA License Number field");
		eleUtil.doSendKeysLog(getSFALicenceNumber(), "SFA" + eleUtil.randomNumber(), " SFA License Number  is : ");
	}

	public String getTheCreatedGTsCount() {
		eleUtil.waitTillElementIsDisplayed(countOfGts(), 30);
		return eleUtil.doElementGetTextLog(countOfGts(), "Count of created GTs is : ");
	}

}
