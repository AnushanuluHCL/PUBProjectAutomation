package com.sat.locators;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	private By contactEmail = By.xpath("");
	private By primaryContact = By.xpath("");
	private By noOfGts = By.xpath("");
	private By levelNumber = By.xpath("");
	private By unitNumber = By.xpath("");
	private By SFALicenceNumber = By.xpath("");

	public eatingEstablishmentLocatorsPage(WebDriver driver) {
		super(driver);
	}

	public By getContactEmail() {
		return contactEmail;
	}
	public By getPrimaryContact() {
		return primaryContact;
	}
	public By getNoOfGts() {
		return noOfGts;
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
	
	public void enterContactEmail() {
		eleUtil.waitTillElementIsDisplayed(getContactEmail(), 30);
		eleUtil.doClickLog(getContactEmail(), "Clicked on Contact Email field");
		eleUtil.doClearUsingKeysLog(getContactEmail(), "Clear the Contact Email  field");
		eleUtil.doSendKeysLog(getContactEmail(), "test@gmail.com", " Contact Email  is :test@gmail.com");
	}

	public void enterPrimaryContact() {
		eleUtil.waitTillElementIsDisplayed(getContactEmail(), 30);
		eleUtil.doClickLog(getContactEmail(), "Clicked on Primary Contact field");
		eleUtil.doClearUsingKeysLog(getContactEmail(), "Clear the Primary Contact  field");
		eleUtil.doSendKeysLog(getContactEmail(), "9876543210", " Primary Contact  is :9876543210");
	}

	public void enterNoOfGts(String countOfGts){
		eleUtil.waitTillElementIsDisplayed(getContactEmail(), 30);
		eleUtil.doClickLog(getContactEmail(), "Clicked on No. of GTs field");
		eleUtil.doClearUsingKeysLog(getContactEmail(), "Clear the No. of GTs  field");
		eleUtil.doSendKeysLog(getContactEmail(), countOfGts, " Entered number is :"+countOfGts);
	}

	public void enterLevelNumber(){
		eleUtil.waitTillElementIsDisplayed(getContactEmail(), 30);
		eleUtil.doClickLog(getContactEmail(), "Clicked on Level Number field");
		eleUtil.doClearUsingKeysLog(getContactEmail(), "Clear the Level Number  field");
		eleUtil.doSendKeysLog(getContactEmail(), "7", " Level Number  is :7");
	}

	public void enterUnitNumber(){
		eleUtil.waitTillElementIsDisplayed(getContactEmail(), 30);
		eleUtil.doClickLog(getContactEmail(), "Clicked on Unit Number field");
		eleUtil.doClearUsingKeysLog(getContactEmail(), "Clear the Unit Number field");
		eleUtil.doSendKeysLog(getContactEmail(), "33", " Unit Number is :33");
	}

	public void enterSFALicenceNumber(){
		eleUtil.waitTillElementIsDisplayed(getContactEmail(), 30);
		eleUtil.doClickLog(getContactEmail(), "Clicked on SFA License Number field");
		eleUtil.doClearUsingKeysLog(getContactEmail(), "Clear the SFA License Number field");
		eleUtil.doSendKeysLog(getContactEmail(), "764543", " SFA License Number  is :764543");
	}

}
