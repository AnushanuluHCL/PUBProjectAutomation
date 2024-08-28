package com.sat.locators;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sat.Pages.CommonActionsPage;
import com.sat.constants.AppConstants;
import com.sat.testUtil.Log;

public class WRN1FactoryLocatorsPage extends CommonActionsPage {

	// Locators for Factory record
	private By WADetailsSectionName = By.xpath("//h2[@title='WA Details']");
	private By WAStatusField = By.xpath("//select[@aria-label='WA status']");
	// private By WANumberField = By.xpath("//input[@aria-label='WA Number']");
	// private By tradeGroupField = By.xpath("//select[@aria-label='Trade Group']");
	// private By fpeField = By.xpath("//select[@aria-label='FPE/Non FPE']");

	// Locators for Factory entity view
	private By entitySelection = By.xpath("//div[@col-id='name' and @role='columnheader']");

	public WRN1FactoryLocatorsPage(WebDriver driver) {
		super(driver);
	}

	public String WAStatusVal() {
		eleUtil.waitForVisibilityOfElement(WADetailsSectionName, 10);
		jsutil.scrollIntoView(driver.findElement(WADetailsSectionName));
		eleUtil.waitForVisibilityOfElement(WAStatusField, 10);
		return eleUtil.doGetElementAttribute(WAStatusField, "title");
	}

	public String WANumberVal(String WAnumVal) {
		By WANumberField = By.xpath("//input[contains(@title,'" + WAnumVal + "')]");
		eleUtil.waitForVisibilityOfElement(WADetailsSectionName, 10);
		jsutil.scrollIntoView(driver.findElement(WADetailsSectionName));
		eleUtil.waitForVisibilityOfElement(WANumberField, 10);
		return eleUtil.doGetElementAttributeLog(WANumberField, "title","WA Number is : ");
	}

	public String tradeGrpVal(String tradeGrp) {
		By tradeGroupField = By.xpath("//select[@title='" + tradeGrp + "']");
		eleUtil.waitForVisibilityOfElement(tradeGroupField, 10);
		return eleUtil.doGetElementAttributeLog(tradeGroupField, "title","Tradegroup value is : ");
		
	}

	public String fpeVal(String fpeVal) {
		By fpeField = By.xpath("//select[@title='" + fpeVal + "']");
		eleUtil.waitForVisibilityOfElement(fpeField, 10);
		eleUtil.createSelectLog(fpeField, "Click on the FPE/Non FPE dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(fpeField, "FPE", "Selected FPE/Non FPE dropdown value is : ");
		return eleUtil.doGetElementAttributeLog(fpeField, "title","FPE value is : ");

	}

	public void entitySelectionInFactoryView() {
		eleUtil.waitForVisibilityOfElement(entitySelection, 10);
		eleUtil.doElementClickableLog(entitySelection, 20, "Entiry field is clickable");
		eleUtil.doClickLog(entitySelection, "Click on Entity/Proj Reference No field in view");
	}
}
