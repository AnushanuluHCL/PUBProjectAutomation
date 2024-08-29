package com.sat.Pages;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sat.locators.WRN1CaseLocatorsPage;
import com.sat.testUtil.Log;

public class WRN1CasePage extends CommonActionsPage {

	public WRN1CasePage(WebDriver driver) {
		super(driver);
	}

	WRN1CaseLocatorsPage wrn1case = new WRN1CaseLocatorsPage(driver);

	public void caseFormFieldsValidation() {
		assertEquals(verifyBUField(), "WA& TEF", "Business Function is not same");
		assertEquals(verifyCaseTypeField(), "Inspection Case", "Case  Type is not same");
		assertEquals(verifyCaseSubTypeField(), "New WA Application", "Case Sub Type is not same");
		assertEquals(verifyCaseStatus(), "Scheduled", "Case status is not same");
	}

	public void mailGeneratedOrNotWRN1(String mailType) throws InterruptedException, ParseException {
		clickOnRefreshBtn();
		navigatingToTab("Timeline");
		Thread.sleep(2000);
		By ele;
		String mailTrigger;
		switch (mailType) {
		case "WA Application Received":
			ele = By.xpath("//label[contains(text(),'WA Application Received')]");
			eleUtil.waitForVisibilityOfElementLog(ele, 20, "Waiting for the email WA Application Received");
			mailTrigger = eleUtil.doElementGetText(ele);
			assertTrue(mailTrigger.contains("WA Application Received"), "Mail is not generated");
			break;
		case "Request for additonal Docs":
			ele = By.xpath("//label[contains(text(),'Additional Documentation Required ')]");
			eleUtil.waitForVisibilityOfElementLog(ele, 20, "Waiting for the email WA Application Received");
			mailTrigger = eleUtil.doElementGetText(ele);
			assertTrue(mailTrigger.contains("Additional Documentation Required"), "Mail is not generated");
			break;
		case "Written Approval Documents":
			ele = By.xpath("//label[contains(text(),'Written Approval Documents')]");
			eleUtil.waitForVisibilityOfElementLog(ele, 20, "Waiting for the email Written Approval Documents");
			mailTrigger = eleUtil.doElementGetText(ele);
			assertTrue(mailTrigger.contains("Written Approval Documents"), "Mail is not generated");
			break;

		}

	}

	public void validateSOReviewnewWANotification() throws InterruptedException {
		eleUtil.isPageLoaded(100);
		clickOnNotificationIcon();
		boolean isNotificationFound = false;
		long startTime = System.currentTimeMillis();

		while (!isNotificationFound && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);
				WebElement notificationElement = eleUtil
						.getElement(By.xpath("//p[contains(text(),'" + CommonActionsPage.casenumber + "')]"));
				if (eleUtil.isClickable(notificationElement, 10)) {
					validateAlertContent(CommonActionsPage.casenumber,
							CommonActionsPage.casenumber + " is waiting for SO Approval");
					tapToOpenBtn(CommonActionsPage.casenumber);
					isNotificationFound = true;
					handleNewTab("Value", CommonActionsPage.casenumber);
					closeCurrentTabAndSwitchBack();
					clickOnCancelIconOnNotification();
				}
			} catch (Exception e) {
				Log.error("Notification is not generated. So continue andcheck the notification within 5minuites of time");
			}

			if (!isNotificationFound) {
				System.out.println("Notification not found within 5 minutes, canceling.");
				clickOnCancelIconOnNotification();
			}
		}
	}
	public void validateAOReviewnewWANotification() throws InterruptedException {
		eleUtil.isPageLoaded(100);
		clickOnNotificationIcon();
		boolean isNotificationFound = false;
		long startTime = System.currentTimeMillis();

		while (!isNotificationFound && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);
				WebElement notificationElement = eleUtil
						.getElement(By.xpath("//p[contains(text(),'" + CommonActionsPage.casenumber + "')]"));

				if (eleUtil.isClickable(notificationElement, 10)) {
					validateAlertContent(CommonActionsPage.casenumber,
							CommonActionsPage.casenumber + " is pending for AO Approval");
					tapToOpenBtn(CommonActionsPage.casenumber);
					isNotificationFound = true;
					handleNewTab("Value", CommonActionsPage.casenumber);
					closeCurrentTabAndSwitchBack();
					clickOnCancelIconOnNotification();
				}
			} catch (Exception e) {
				Log.error("Notification is not generated. So continue andcheck the notification within 5minuites of time");
			}

			if (!isNotificationFound) {
				System.out.println("Notification not found within 5 minutes, canceling.");
				clickOnCancelIconOnNotification();
			}
		}
	}

	public void validateFIOToGenerateEmailNotification() throws InterruptedException {
		eleUtil.isPageLoaded(100);
		clickOnNotificationIcon();
		boolean isNotificationFound = false;
		long startTime = System.currentTimeMillis();

		while (!isNotificationFound && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);
				WebElement notificationElement = eleUtil
						.getElement(By.xpath("//p[contains(text(),'" + CommonActionsPage.casenumber + "')]"));

				if (eleUtil.isClickable(notificationElement, 10)) {
					validateAlertContent(CommonActionsPage.casenumber,
							CommonActionsPage.casenumber + " is approved by AO, Please generate email");
					tapToOpenBtn(CommonActionsPage.casenumber);
					isNotificationFound = true;
					handleNewTab("Value", CommonActionsPage.casenumber);
					closeCurrentTabAndSwitchBack();
					clickOnCancelIconOnNotification();
				}
			} catch (Exception e) {
				Log.error("Notification is not generated. So continue andcheck the notification within 5minuites of time");
			}

			if (!isNotificationFound) {
				System.out.println("Notification not found within 5 minutes, canceling.");
				clickOnCancelIconOnNotification();
			}
		}
	}

	public void completeAssignmentStage() {
		navigatingToStage("Assignment");
		wrn1case.confirmDocuemntsReceived();
		clickOnSaveBtn();
		navigatingToStage("Assignment");
		clickOnNextStageBtn();
		clickOnloseIconOnBPF();
	}

	public void createNewLabReport(String reportTypeval, String chemicalval, String concentrationval)
			throws InterruptedException {
		navigatingToTab("Lab Report Result");
		wrn1case.clickOnNewLabReport();
		wrn1case.selectLabRefNoVal();
		wrn1case.selectReportType(reportTypeval);
		wrn1case.selectChemicalValue(chemicalval);
		wrn1case.peakDischargeRate(concentrationval);
		wrn1case.saveNCloseQuickCreateForm();
		eleUtil.isPageLoadedLog(30, "Load the page in ");
	}

	public void verifyTheResult() {
		clickOnRefreshBtnOnHome();
		navigatingToTab("Lab Report Result");
		wrn1case.clickOnLabReportToggleBtn();
		clickOnSaveBtn();
		wrn1case.complainceStatus();
		assertEquals(wrn1case.complainceStatus(), "Compliance", "System Assesment is not same");
	}

	public void verifyWAStatus() {
		navigatingToTab("Inspection Case Information");
		clickOnEntityOnCaseForm();
		wrn1case.WAStatusVal();
		assertEquals(wrn1case.WAStatusVal(), "Approved", "WAApplication status is not same");
	}
	
}