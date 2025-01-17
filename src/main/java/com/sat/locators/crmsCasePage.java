package com.sat.locators;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.testUtil.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class crmsCasePage extends commonActionsPage {

    casePage cases = new casePage(driver);
    factoryPage factory = new factoryPage(driver);
    commonCRMActions crmAction = new commonCRMActions(driver);

    String cwd1CRMSCaseCreationFile = "\\src\\test\\resources\\testdata\\CWD1_CRMSCasesCreation.xlsx";
    String siesCaseID = "SIES-CWD1" + eleUtil.todayDate("yyyy") + eleUtil.randomNumber();
    String crmsCaseNumber = "CRMS-CWD1" + eleUtil.todayDate("yyyy") + eleUtil.randomNumber();

    public crmsCasePage(WebDriver driver) {
        super(driver);
    }

    private By searchCRMSCase = By.cssSelector("input[aria-label='CRMS Case Filter by keyword']");
    private By acceptButton = By.cssSelector("button[aria-label='Accept']");
    private By rejectButton = By.cssSelector("button[aria-label='Reject']");
    private By rejectionReason = By.cssSelector("textarea[aria-label='Rejection Reason']");
    private By emptySIESCaseStatus = By.xpath("//select[@aria-label='SIES Case Status' and @title='---']");
    private By siesCaseStatus = By.cssSelector("select[aria-label='SIES Case Status']");

    // CRMS Case Creation Locations
    private By notificationExpandIcon = By.cssSelector("span[id='notificationExpandIcon']");
    private By deleteAnonymous = By.cssSelector("button[aria-label='Delete Anonymous']");
    private By landmarkLookup = By.cssSelector("input[aria-label='Landmark, Lookup']");
    private By secondaryFioLookup = By.cssSelector("input[aria-label='Secondary FIO, Lookup']");
    private By jobUpdates = By.cssSelector("textarea[aria-label='Job Updates']");
    private By instructionActionParty = By.cssSelector("textarea[aria-label='Instruction for Action Party']");
    private By replyCustomer = By.cssSelector("textarea[aria-label='Reply to Customer']");
    private By crmsCaseAcceptPopup = By.cssSelector("h1[aria-label='CRMS Case']");

    public void updateExcelCRMSCaseCWD1() throws IOException {
        excelUtil = new ExcelUtil(cases.filePath + cwd1CRMSCaseCreationFile);
        excelUtil.setSheet("CRMSCases"); // Ensure this is the correct sheet name
        excelUtil.setCellValue(1, 3, siesCaseID);
        excelUtil.setCellValue(1, 4, crmsCaseNumber);
        excelUtil.saveAndClose();
    }

    public void importCWD1ExcelData() throws InterruptedException {
        importExcel(cwd1CRMSCaseCreationFile);
    }

    public void checkCRMSCaseCreated() throws InterruptedException {
        crmAction.searchRecord(crmsCaseNumber);
    }

    public void searchCRMSCase() throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(searchCRMSCase, 20);
        Thread.sleep(2000);
        eleUtil.doSendKeysLog(searchCRMSCase, crmsCaseNumber, crmsCaseNumber);
        //eleUtil.doSendKeysLog(searchCRMSCase, "CRMS-CWD1202563663", "CRMS-CWD1202563663");
        eleUtil.isPageLoaded(50);
        Thread.sleep(2000);
        driver.findElement(searchCRMSCase).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        selectFirstRecord();
        getFirstRecord();
    }

    public void acceptOrRejectCRMSCase(String crmsCaseAction) throws InterruptedException {
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        if (crmsCaseAction.equals("Reject")) {
            handleRejection(endTime);
        } else {
            handleAcceptance(endTime);
        }
    }

    private void handleRejection(long endTime) throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(rejectButton, 20);
        eleUtil.doClickLog(rejectButton, "click on Reject button");
        eleUtil.waitForVisibilityOfElement(rejectionReason, 30);
        eleUtil.doSendKeysLog(rejectionReason, "CRMS Reject", "Enter Rejection Reason");
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(rejectButton, "Reject button is visible")) {
                eleUtil.doClickLog(rejectButton, "click on Reject button");
                Thread.sleep(3000);
                eleUtil.doClickLog(crmAction.getRefreshBtn(), "Click on Refresh button");
            } else {
                clickOnSaveBtn();
                break;
            }
        }
    }

    private void handleAcceptance(long endTime) throws InterruptedException {
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(acceptButton, "Accept button is visible")) {
                eleUtil.doClickLog(acceptButton, "click on Accept button");
                if (eleUtil.elementIsDisplayed(crmsCaseAcceptPopup, "CRMS Case pop up")) {
                    eleUtil.doClickLog(cases.getOkButton(), "Click on OK button");
                }
                Thread.sleep(3000);
                eleUtil.doClickLog(crmAction.getRefreshBtn(), "Click on Refresh button");
            } else {
                clickOnSaveBtn();
                break;
            }
        }
    }

    public void verifyCRMDetails(String crmsCaseStatus) throws InterruptedException {
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            eleUtil.scrollDownTillElementVisible(siesCaseStatus);
            if (eleUtil.elementIsDisplayed(emptySIESCaseStatus, "Value is not updated ")) {
                Thread.sleep(3000);
                eleUtil.doClickLog(crmAction.getRefreshBtn(), "Click on Refresh button");
            } else {
                Assert.assertEquals(eleUtil.getSelectedValueFromDropdown(siesCaseStatus), crmsCaseStatus, "Status not matched");
                break;
            }
        }
    }

    public void crmsCaseWarningMessage(String warningMessage) throws InterruptedException {
        toggleNotificationIcon();
        By warningMessageForCloseCRMSCase = By.xpath("//span[contains(@id,\"" + warningMessage + "\")]/ancestor::li//span[@data-id]");
        eleUtil.waitForVisibilityOfElement(warningMessageForCloseCRMSCase, 30);
        String record = eleUtil.doElementGetText(warningMessageForCloseCRMSCase);
        Assert.assertEquals(record, warningMessage, "Message not matched");
        toggleNotificationIcon();
    }

    private void toggleNotificationIcon() throws InterruptedException {
        if (eleUtil.elementIsDisplayed(notificationExpandIcon, "Notification Expand Icon is visible")) {
            eleUtil.doClickLog(notificationExpandIcon, "Click on Notification Icon");
            Thread.sleep(3000);
        }
    }

    public void deleteAndEnterValueInEntity() throws InterruptedException {
        eleUtil.action(cases.getEntity());
        eleUtil.doClickLog(deleteAnonymous, "delete Anonymous value for Entity Field");
        cases.selectEntityOnCase("Bedok");
    }

    public void selectLandmark() throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(landmarkLookup, 30);
        eleUtil.doClearUsingKeysWithWait(landmarkLookup, 30);
        eleUtil.doSendKeysWithWaitEnter(landmarkLookup, "Bedok Reservoir Fishing Deck", 30);
    }

    public void selectSecondaryFio(String secondaryFioUser) throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(secondaryFioLookup, 30);
        eleUtil.doClearUsingKeysWithWait(secondaryFioLookup, 30);
        eleUtil.doSendKeysWithWaitEnter(secondaryFioLookup, secondaryFioUser, 30);
    }

    public void selectComplianceInformation(String userAssessment) throws InterruptedException {
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (!eleUtil.elementIsDisplayed(cases.getApproveWOBtn(), "Check Approve Button")) {
                eleUtil.doClickLog(crmAction.getRefreshBtn(), "Click on Refresh button");
            } else {
                eleUtil.waitForVisibilityOfElement(crmAction.getUserAssessment(), 30);
                eleUtil.selectDropDownValue(crmAction.getUserAssessment(), "selectByVisibleText", userAssessment, "Select " + userAssessment);
                clickOnSaveBtn();
                break;
            }
        }
    }

    public void crmsClosureDetails() throws InterruptedException {
        eleUtil.scrollDownTillElementVisible(jobUpdates);
        eleUtil.waitForVisibilityOfElement(jobUpdates, 30);
        eleUtil.doSendKeysLog(jobUpdates, "Job Update", "Enter value in Job Update");
        eleUtil.doSendKeysLog(instructionActionParty, "Instruction for Action Party", "Enter value in Instruction for Action Party");
        eleUtil.doSendKeysLog(replyCustomer, "Reply to Customer", "Enter value in Reply to Customer");
        clickOnSaveBtn();
    }

    public void workOrderApproveAndReject(String approveNReject) throws InterruptedException {
        if (approveNReject.equals("Approve")) {
            cases.clickOnApproveWOBtn();
            eleUtil.waitForVisibilityOfElement(cases.getConfirmDialog(), 50);
            cases.clickOnOkButton();
        } else {
            cases.clickOnRejectWOBtn();
            eleUtil.waitForFrameByIDOrName("FullPageWebResource", 30);
            cases.enterRemarks();
            cases.clickOnSubmitBtn();
            eleUtil.switchToDefaultContent();
            crmAction.waitForRecordFormPageToSaved();
            clickOnRefreshBtn();
            clickOnSaveNCloseBtn();
            Thread.sleep(5000);
        }
        clickOnSaveNCloseBtn();
    }
}
