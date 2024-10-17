package com.sat.locators;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.testUtil.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class pumpingSystemPage extends commonActionsPage {

    public pumpingSystemPage(WebDriver driver) {
        super(driver);
    }

    commonCRMActions crmActions = new commonCRMActions(driver);
    factoryPage factory = new factoryPage(driver);

    //Pumping System with Entity Type as Pumping System
    private By entityType = By.cssSelector("select[aria-label='Entity Type']");
    private By projectReferenceNumber = By.xpath("//input[contains(@aria-label,'Project Reference N')]");
    private By projectTitle = By.cssSelector("textarea[aria-label='Project Title']");
    private By contractor = By.cssSelector("input[aria-label*='Contractor']");
    private By houseBlkNumber = By.cssSelector("input[aria-label='House Blk Number']");
    private By postalCode = By.cssSelector("input[aria-label='Postal Code']");
    private By roadName = By.cssSelector("input[aria-label='Road Name']");

    //1BPU Submission with Submission Type as Pumping System Inspection
    private By submissionNo = By.xpath("//input[contains(@aria-label,'Submission No')]");
    private By submissionType = By.cssSelector("select[aria-label='Submission Type']");
    private By bpdOfficer = By.cssSelector("input[aria-label='BPD Officer in charge, Lookup']");
    private By meSystem = By.cssSelector("input[aria-label='No. of M&E System']");
    private By pumpedSystem = By.cssSelector("select[aria-label='Purpose of Pumped System']");
    private By qualifiedPerson = By.cssSelector("input[aria-label='Qualified Person (QP/LP/CP), Lookup']");
    private By bpuSubmissionButton = By.cssSelector("button[aria-label='New 1BPU Submission. Add New 1BPU Submission']");
    private By submissionDate = By.cssSelector("input[data-id='pub_submissiondate.fieldControl-date-time-input']");
    private By inspectionRequired = By.cssSelector("select[aria-label='Inspection Required']");

    //Open related Entity
    private By relatedCase = By.cssSelector("div[aria-label='Cases Related - Common']");
    private By caseStatus = By.cssSelector("[aria-label='Active']");

    public By getProjectReferenceNumber() {
        return projectReferenceNumber;
    }

    public By getProjectTitle() {
        return projectTitle;
    }

    public By getContractor() {
        return contractor;
    }

    public By getHouseBlkNumber() {
        return houseBlkNumber;
    }

    public By getPostalCode() {
        return postalCode;
    }

    public By getRoadName() {
        return roadName;
    }

    public By getSubmissionNo() {
        return submissionNo;
    }

    public By getBPDOfficer() {
        return bpdOfficer;
    }

    public By getMESystem() {
        return meSystem;
    }

    public By getQualifiedPerson() {
        return qualifiedPerson;
    }

    public By getSubmissionDate() {
        return submissionDate;
    }

    public By getCaseStatus() {
        return caseStatus;
    }

    public void selectEntityType(String type) {
        eleUtil.waitTillElementIsDisplayed(entityType, 100);
        eleUtil.selectDropDownValue(entityType, "selectByVisibleText", type, "select entity type as" + type);
    }

    public void selectSubmissionType(String type) {
        eleUtil.waitTillElementIsDisplayed(submissionType, 30);
        eleUtil.selectDropDownValue(submissionType, "selectByVisibleText", type, "select entity type as" +type);
    }

    public void selectPumpedSystem() {
        eleUtil.waitTillElementIsDisplayed(pumpedSystem, 30);
        eleUtil.selectDropDownValue(pumpedSystem, "selectByVisibleText", "State Overpumping", "select entity type as State Overpumping");
    }

    public void enterProjectReferenceNumber() {
        eleUtil.waitTillElementIsDisplayed(getProjectReferenceNumber(), 30);
        eleUtil.doClickLog(getProjectReferenceNumber(), "Clicked on Project Reference Number field");
        eleUtil.doClearUsingKeysLog(getProjectReferenceNumber(), "Clear the Project Reference Number field");
        eleUtil.doSendKeysLog(getProjectReferenceNumber(),"A" +eleUtil.currentDateTime("ddMMyyyy"), " Project Reference Number is : A" +eleUtil.currentDateTime("ddMMyyyy"));
    }

    public void enterProjectTitle() {
        eleUtil.waitTillElementIsDisplayed(getProjectTitle(), 30);
        eleUtil.doClickLog(getProjectTitle(), "Clicked on Project Title field");
        eleUtil.doClearUsingKeysLog(getProjectTitle(), "Clear the Project Title Number field");
        eleUtil.doSendKeysLog(getProjectTitle(),"ProjectTitle" +eleUtil.randomNumber() , " Project Title Number is :ProjectTitle" +eleUtil.randomNumber());
    }

    public void enterContractor() throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(getContractor(), 30);
        eleUtil.doClearUsingKeysLog(getContractor(), "Clear the Contractor field");
        eleUtil.doSendKeysWithWaitEnter(getContractor(), "QP Contractor" , 30);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
    }

    public void enterHouseBlkNumber() {
        eleUtil.waitTillElementIsDisplayed(getHouseBlkNumber(), 30);
        eleUtil.doClickLog(getHouseBlkNumber(), "Clicked on House Blk Number field");
        eleUtil.doClearUsingKeysLog(getHouseBlkNumber(), "Clear the House Blk Number field");
        eleUtil.doSendKeysLog(getHouseBlkNumber(),"BLK Number" +eleUtil.randomNumber() , " House Blk Number is :BLK Number" +eleUtil.randomNumber());
    }

    public void enterPostalCode() {
        eleUtil.waitTillElementIsDisplayed(getPostalCode(), 30);
        eleUtil.doClickLog(getPostalCode(), "Clicked on Postal Code field");
        eleUtil.doClearUsingKeysLog(getPostalCode(), "Clear the Postal Code field");
        eleUtil.doSendKeysLog(getPostalCode(), "491821", " Postal Code is : ");
    }

    public void enterRoadName() {
        eleUtil.waitTillElementIsDisplayed(getRoadName(), 30);
        eleUtil.doClickLog(getRoadName(), "Clicked on Road Name field");
        eleUtil.doClearUsingKeysLog(getRoadName(), "Clear the Road Name field");
        eleUtil.doSendKeysLog(getRoadName(),"RoadName" +eleUtil.randomNumber() , " Road Name is :RoadName" +eleUtil.randomNumber());
    }

    public void clickBPUSubmissionButton() {
        eleUtil.waitForVisibilityOfElement(bpuSubmissionButton, 30);
        eleUtil.doClickLog(bpuSubmissionButton, "Click on BPU Submission Button");
    }

    public void enterSubmissionNo() {
        eleUtil.waitTillElementIsDisplayed(getSubmissionNo(), 30);
        eleUtil.doClickLog(getSubmissionNo(), "Clicked on Road Name field");
        eleUtil.doClearUsingKeysLog(getSubmissionNo(), "Clear the Road Name field");
        eleUtil.doSendKeysLog(getSubmissionNo(),"ES"+eleUtil.currentDateTime("yyyyMMdd"), " Submission No :ES"+eleUtil.currentDateTime("yyyyddMM"));
    }

    public void selectInspectionRequired() {
        eleUtil.waitTillElementIsDisplayed(inspectionRequired, 30);
        eleUtil.selectDropDownValue(inspectionRequired, "selectByVisibleText", "Yes", "select Inspection Required as Yes" );
    }

    public void enterBPDOfficer() throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(getBPDOfficer(), 30);
        eleUtil.doClearUsingKeyswithWait(getBPDOfficer(), 30);
        eleUtil.doSendKeysWithWaitEnter(getBPDOfficer(), "BPD SANITY" , 30);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
    }

    public void enterMESystem() {
        eleUtil.waitTillElementIsDisplayed(getMESystem(), 30);
        eleUtil.doClickLog(getMESystem(), "Clicked on Road Name field");
        eleUtil.doClearUsingKeysLog(getMESystem(), "Clear the Road Name field");
        eleUtil.doSendKeysLog(getMESystem(), "1", " MESystem is 1");
    }

    public void enterQualifiedPerson() throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(getQualifiedPerson(), 30);
        eleUtil.doClearUsingKeyswithWait(getQualifiedPerson(), 30);
        eleUtil.doSendKeysWithWaitEnter(getQualifiedPerson(), "QP Contractor" , 40);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
    }

    public void checkSubmissionDate() throws InterruptedException {
        eleUtil.waitTillElementIsDisplayed(crmActions.getRefreshBtn(), 220);
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            String submissionDateValue = eleUtil.doGetElementAttributeLog(getSubmissionDate(), "value", "get Submission Date");
            Log.info("Submission Date is " + submissionDateValue);
            if (submissionDateValue == null || submissionDateValue.isEmpty()) {
                Thread.sleep(3000);
                clickOnRefreshBtn();
            } else {
                // If the element is displayed, execute the else block logic
                try {
                    Assert.assertEquals(submissionDateValue, eleUtil.todayDate("M/d/yyyy"), "Submission Date not matched");
                    Log.info("Submission Date is " + submissionDateValue);
                    return; // Exit the method if the case number is verified
                } catch (NoSuchElementException e) {
                    Log.error("Submission Date is not reflected: " + e.getMessage());
                }
            }
            eleUtil.waitTillElementIsDisplayed(getSubmissionDate(), 220);
            submissionDateValue = eleUtil.doGetElementAttributeLog(getSubmissionDate(), "value", "get Submission Date");
            Log.info("Re-evaluated Submission Date is " + submissionDateValue);
        }
    }

    public void clickRelatedCase() {
        eleUtil.waitForVisibilityOfElement(relatedCase, 30);
        eleUtil.doClickLog(relatedCase, "click on Cases Entity");
    }

    public void checkCaseStatus(String status) {
        eleUtil.waitForVisibilityOfElement(caseStatus, 30);
        String caseStatus = eleUtil.doElementGetText(getCaseStatus());
        Assert.assertEquals(caseStatus, status, "Case Status not Matched");
        selectFirstRecord();
        getFirstRecord();
        commonActionsPage.casenumber = crmActions.setPageTitle();
    }

}