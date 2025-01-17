package com.sat.locators;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class eventPermitApplicationLocators extends commonCRMActions {

    factoryPage factory = new factoryPage(driver);
    commonCRMActions crmActions = new commonCRMActions(driver);
    public eventPermitApplicationLocators(WebDriver driver) {
        super(driver);
    }

    String applicationReferenceNo = "App" + eleUtil.todayDate("yyyy/MM/dd");
    String applicantReferenceName = "PUBApp" + eleUtil.todayDate("yyyy/MM/dd");

    private By searchApplicationBox = By.xpath("//input[@aria-label='Event Permit Application Filter by keyword']");
    private By eventCategory = By.cssSelector("input[aria-label='Event Category, Lookup']");
    private By eventInspectionType = By.xpath("//div[@aria-label='Event Inspection type']//button[@aria-label='Toggle menu']");
    private By selectEventInspectionType = By.xpath("//label[@title='Pre-Event; During Event; Post Event'] //div");
    private By applicationNumber = By.cssSelector("input[aria-label='Application No']");
    private By applicantName = By.cssSelector("input[aria-label='Applicant Name']");
    private By mobileNumber = By.cssSelector("input[aria-label='Mobile Number']");
    private By nameOfOrganisation = By.cssSelector("input[aria-label='Name of Organisation']");
    private By addressOfOrganisation = By.cssSelector("input[aria-label='Registered Address of Organisation']");

    // Date Locators
    private By eventStartDate = By.cssSelector("input[aria-label='Date of Event Start Date']");
    private By eventEndDate = By.cssSelector("input[aria-label='Date of Event End Date']");
    private By waterSetupStartDate = By.cssSelector("input[aria-label='Date of Water Setup Start Date']");
    private By waterSetupEndDate = By.cssSelector("input[aria-label='Date of Water Setup End Date']");
    private By waterTearDownStartDate = By.cssSelector("input[aria-label='Date of Water Tear-Down Start Date']");
    private By waterTearDownEndDate = By.cssSelector("input[aria-label='Date of Water Tear-Down End Date']");
    private By landSetupStartDate = By.cssSelector("input[aria-label='Date of Land Setup Start Date']");
    private By landSetupEndDate = By.cssSelector("input[aria-label='Date of Land Setup End Date']");
    private By landTearDownStartDate = By.cssSelector("input[aria-label='Date of Land Tear-Down Start Date']");
    private By landTearDownEndDate = By.cssSelector("input[aria-label='Date of Land Tear-Down End Date']");

    public By getEventCategory() {
        return eventCategory;
    }
    public By getEventInspectionType() {
        return eventInspectionType;
    }
    public By getSelectEventInspectionType() {
        return selectEventInspectionType;
    }
    public By getApplicationNumber() {
        return applicationNumber;
    }
    public By getApplicantName() {
        return applicantName;
    }
    public By getMobileNumber() {
        return mobileNumber;
    }
    public By getNameOfOrganisation() {
        return nameOfOrganisation;
    }
    public By getAddressOfOrganisation() {
        return addressOfOrganisation;
    }
    public By getEventStartDate() {
        return eventStartDate;
    }
    public By getEventEndDate() {
        return eventEndDate;
    }
    public By getWaterSetupStartDate() {
        return waterSetupStartDate;
    }
    public By getWaterSetupEndDate() {
        return waterSetupEndDate;
    }
    public By getWaterTearDownStartDate() {
        return waterTearDownStartDate;
    }
    public By getWaterTearDownEndDate() {
        return waterTearDownEndDate;
    }
    public By getLandSetupStartDate() {
        return landSetupStartDate;
    }
    public By getLandSetupEndDate() {
        return landSetupEndDate;
    }
    public By getLandTearDownStartDate() {
        return landTearDownStartDate;
    }
    public By getLandTearDownEndDate() {
        return landTearDownEndDate;
    }

    public void selectEventCategory() throws InterruptedException {
        eleUtil.doClearUsingKeysWithWait(getEventCategory(), 30);
        eleUtil.doSendKeysWithWaitEnter(getEventCategory(), "Fireworks Display and set-up", 30);
        eleUtil.waitForVisibilityOfElement(factory.setLookUp(), 30);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
    }

    public void selectEventInspectionType(String eventInspectionType) throws InterruptedException {
        eleUtil.action(getEventInspectionType());
        eleUtil.waitForVisibilityOfElement(getEventInspectionType(), 100);
        eleUtil.doClickLog(getEventInspectionType(), "Click on Event Inspection Type");
        eleUtil.waitForVisibilityOfElement(getSelectEventInspectionType(), 30);
        Thread.sleep(3000);
        eleUtil.doClickLog(getSelectEventInspectionType(), "Select value " + eventInspectionType);
    }

    public void setApplicationNo() throws InterruptedException {
        eleUtil.doClearUsingKeysWithWait(getApplicationNumber(), 30);
        eleUtil.doSendKeysWithWaitEnter(getApplicationNumber(), applicationReferenceNo , 30);
    }

    public void applicationDetails() throws InterruptedException {
        eleUtil.doClearUsingKeysWithWait(getApplicantName(), 30);
        eleUtil.doSendKeysWithWaitEnter(getApplicantName(), applicantReferenceName , 30);
        eleUtil.doClearUsingKeysWithWait(getMobileNumber(), 30);
        eleUtil.doSendKeysWithWaitEnter(getMobileNumber(), "63812121" , 30);
        eleUtil.doClearUsingKeysWithWait(getNameOfOrganisation(), 30);
        eleUtil.doSendKeysWithWaitEnter(getNameOfOrganisation(), "PUBTest" , 30);
        eleUtil.doClearUsingKeysWithWait(getAddressOfOrganisation(), 30);
        eleUtil.doSendKeysWithWaitEnter(getAddressOfOrganisation(), "Singapore PUB" , 30);
    }

    public void enterDateDetails() {
        eleUtil.waitForVisibilityOfElement(getEventStartDate(), 40);
        eleUtil.doClickLog(getEventStartDate(), "Click on Calender Icon");
        eleUtil.waitForVisibilityOfElement(crmActions.getSelectTodayDateAndTime(), 30);
        eleUtil.doClickLog(crmActions.getSelectTodayDateAndTime(), "Select today's date");
        eleUtil.waitForVisibilityOfElement(getEventEndDate(), 30);
        eleUtil.doSendKeysLog(getEventEndDate(),
                eleUtil.todayDatePlusDays("MM/dd/yyyy", 30), "Enter today's date + 30");

        eleUtil.waitForVisibilityOfElement(getWaterSetupStartDate(), 40);
        eleUtil.doClickLog(getWaterSetupStartDate(), "Click on Calender Icon");
        eleUtil.waitForVisibilityOfElement(crmActions.getSelectTodayDateAndTime(), 30);
        eleUtil.doClickLog(crmActions.getSelectTodayDateAndTime(), "Select today's date");
        eleUtil.waitForVisibilityOfElement(getWaterSetupEndDate(), 30);
        eleUtil.doSendKeysLog(getWaterSetupEndDate(),
                eleUtil.todayDatePlusDays("MM/dd/yyyy", 30), "Enter today's date + 30");

        eleUtil.waitForVisibilityOfElement(getWaterTearDownStartDate(), 40);
        eleUtil.doClickLog(getWaterTearDownStartDate(), "Click on Calender Icon");
        eleUtil.waitForVisibilityOfElement(crmActions.getSelectTodayDateAndTime(), 30);
        eleUtil.doClickLog(crmActions.getSelectTodayDateAndTime(), "Select today's date");
        eleUtil.waitForVisibilityOfElement(getWaterTearDownEndDate(), 30);
        eleUtil.doSendKeysLog(getWaterTearDownEndDate(),
                eleUtil.todayDatePlusDays("MM/dd/yyyy", 30), "Enter today's date + 30");

        eleUtil.waitForVisibilityOfElement(getLandSetupStartDate(), 40);
        eleUtil.doClickLog(getLandSetupStartDate(), "Click on Calender Icon");
        eleUtil.waitForVisibilityOfElement(crmActions.getSelectTodayDateAndTime(), 30);
        eleUtil.doClickLog(crmActions.getSelectTodayDateAndTime(), "Select today's date");
        eleUtil.waitForVisibilityOfElement(getLandSetupEndDate(), 30);
        eleUtil.doSendKeysLog(getLandSetupEndDate(),
                eleUtil.todayDatePlusDays("MM/dd/yyyy", 30), "Enter today's date + 30");

        eleUtil.waitForVisibilityOfElement(getLandTearDownStartDate(), 40);
        eleUtil.doClickLog(getLandTearDownStartDate(), "Click on Calender Icon");
        eleUtil.waitForVisibilityOfElement(crmActions.getSelectTodayDateAndTime(), 30);
        eleUtil.doClickLog(crmActions.getSelectTodayDateAndTime(), "Select today's date");
        eleUtil.waitForVisibilityOfElement(getLandTearDownEndDate(), 30);
        eleUtil.doSendKeysLog(getLandTearDownEndDate(),
                eleUtil.todayDatePlusDays("MM/dd/yyyy", 30), "Enter today's date + 30");
    }

    public void searchApplication() throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(searchApplicationBox, 20);
        Thread.sleep(2000);
        eleUtil.doSendKeys(searchApplicationBox, commonActionsPage.applicationNumber);
        eleUtil.isPageLoaded(50);
        Thread.sleep(2000);

        driver.findElement(searchApplicationBox).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        selectFirstRecord();
        getFirstRecord();
    }
}
