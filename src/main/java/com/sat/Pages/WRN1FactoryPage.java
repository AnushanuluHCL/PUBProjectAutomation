package com.sat.Pages;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sat.locators.WRN1FactoryLocatorsPage;
import com.sat.testUtil.Log;

public class WRN1FactoryPage extends CommonActionsPage {

	public WRN1FactoryPage(WebDriver driver) {
		super(driver);
	}

	WRN1FactoryLocatorsPage factory = new WRN1FactoryLocatorsPage(driver);

	public void verifyWAStatus() {
		navigatingToTab("Inspection Case Information");
		clickOnEntityOnCaseForm();
		factory.WAStatusVal();
		assertEquals(factory.WAStatusVal(), "Approved", "WAApplication status is not same");
	}

	public void verifyWANumberStatus(String tradeGrp, String fpeVal, String WAnumVal) {
		factory.entitySelectionInFactoryView();
		filterView(CommonActionsPage.WRN1_factoryname);
		//filterView("Testcomp270824081515");
		selectFirstRecord();
		getFirstRecord();
		String actualTradeGroupValue=factory.tradeGrpVal(tradeGrp);
		assertEquals(actualTradeGroupValue, tradeGrp, "WAApplication status is not same");
		String actualFPEValue=factory.fpeVal(fpeVal);
		assertEquals(actualFPEValue, fpeVal, "WAApplication status is not same");
		String actualWANumberValue=factory.WANumberVal(WAnumVal);
		assertTrue(actualWANumberValue.contains("TER"), "WA Number is empty field");
		clickonSaveAndCloseBtn();
	}

}
