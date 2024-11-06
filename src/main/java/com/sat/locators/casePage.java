package com.sat.locators;

import com.sat.Pages.commonCRMActions;
import com.sat.constants.AppConstants;
import com.sat.testUtil.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class casePage extends commonCRMActions {

    public casePage(WebDriver driver) {
        super(driver);
    }

    commonCRMActions crmActions = new commonCRMActions(driver);
    factoryPage factory = new factoryPage(driver);
    public String filePath = System.getProperty("user.dir");
    String pngFilePath = "\\src\\main\\resources\\documents\\PumpingSystemsInspection.png";

    // Create creation fields for WRN
    private By caseType = By.cssSelector("select[aria-label='Case Type']");
    private By caseSubType = By.cssSelector("select[aria-label='Case Sub Type']");
    private By wrpSection = By.cssSelector("section[aria-label='WRN 3']");
    private By alertSource = By.cssSelector("select[aria-label='Alert Source']");
    private By wrpCatchment = By.cssSelector("input[aria-label='WRP Catchment, Lookup']");
    private By issueReported = By.cssSelector("input[aria-label='Issue Reported']");
    private By entity = By.xpath("//ul[@title='Entity']//div//div");
    private By manholeListSection = By.cssSelector("section[aria-label='Manhole Mapping Details 1st Level']");
    private By catchment = By.cssSelector("select[aria-label='Catchment']");
    private By riskCategory = By.cssSelector("select[aria-label='RiskCategory']");
    private By factoriesListSection = By.cssSelector("section[aria-label='WRN3']");
    private By checkWOCreated = By.xpath("//div[@data-id='WorkOrders-pcf_grid_control_container'] //span[text()='No data available']");

    private By listViewOfCases = By.xpath("//h1[contains(@title,'Cases')] //span[@data-automationid='splitbuttonprimary']");
    private By workOrderCount = By.xpath("//div[@data-id='WorkOrders-pcf_grid_control_container'] //span[contains(@class,'statusContainer')]");
    private By bookingCount = By.xpath("//div[@data-id='bookings-pcf_grid_control_container'] //span[contains(@class,'statusContainer')]");
    private By noDataAvailableInSingleGrid = By.xpath("//span[text()='No data available']");
    private By childCaseWorkOrderRefresh = By.xpath("//div[@id='dataSetRoot_WorkOrders'] //button[@aria-label='Refresh']");

    private By anyAbnormality = By.cssSelector("select[aria-label='2. Any abnormality observed?']");
    private By remarks = By.cssSelector("input[aria-label='Remarks']");
    private By parentCase = By.xpath("//span[contains(@title,'Parent Case')]");
    private By parentCaseValue = By.cssSelector("div[data-id='parentcaseid.fieldControl-LookupResultsDropdown_parentcaseid_selected_tag_text']");
    private By businessFunction = By.cssSelector("[data-id='pub_businessfunctionid.fieldControl-LookupResultsDropdown_pub_businessfunctionid_selected_tag']");
    private By businessFunctionName = By.cssSelector("input[data-id='pub_name.fieldControl-text-box-text']");
    private By duration = By.cssSelector("input[aria-label='Duration']");
    private By startTime = By.cssSelector("input[aria-label='Time of Start Time']");
    private By endTime = By.cssSelector("input[aria-label='Time of End Time']");
    private By moreCommandButton = By.cssSelector("button[aria-label='More commands for Case']");
    private By caseRemarksField = By.cssSelector("textarea[aria-label='Remarks']");
    private By caseSaved = By.cssSelector("span[aria-label='Save status - Saved']");

    //Pumping System Inspection
    private By pumpingEquipmentAncillariesNA = By.xpath("//input[contains(@name,'Q1_sq_') and @aria-label='NA']");
    private By pumpingEquipmentAncillariesNOtOK = By.xpath("//input[contains(@name,'Q1_sq_') and @aria-label='Not Ok']");
    private By pumpingType = By.cssSelector("select[aria-label='Type']");
    private By calenderIcon = By.xpath("//input[contains(@id,'date-label')]");
    private By uploadPhoto = By.cssSelector("input[aria-label='Upload Photos'] ");

    private By lastInspectedDate = By.cssSelector("input[aria-label='Date of Last Inspected On']");
    private By nextBookingDate = By.cssSelector("input[aria-label='Date of Next Booking Date']");

    //BPF Locators
    private By aoResponseOption = By.xpath("//select[@aria-label='AO Response']");
    private By recurrenceRequired = By.cssSelector("select[aria-label='Recurrence Required']");
    private By frequency = By.cssSelector("input[aria-label='Frequency (days)']");
    private By nextStageBtn = By.xpath("//div[contains(@id,'nextButton')]");
    private By resolveCaseOption = By.cssSelector("select[aria-label='Resolve Case']");
    private By finishBtn = By.cssSelector("button[@aria-label='Finish']");

    private By warningRecurrence = By.cssSelector("h1[aria-label='Warning']");
    private By recurrenceMessageLocator = By.cssSelector("span[data-id='dialogMessageText']");
    private By soResponseOption = By.xpath("//select[@aria-label='SO Response']");

    // WRN11 Locators
    private By choosePhoto = By.cssSelector("input[aria-label='Please take a photo if non-compliance']");
    private By urinalTrapNonCompliance = By.xpath("//input[contains(@name,'Question5_sq_') and @aria-label='No']");
    private By branchDrainNonCompliance = By.xpath("//input[contains(@name,'Question1_sq_') and @aria-label='Non-Compliance']");
    private By branchDrainCompliance = By.xpath("//input[contains(@name,'Question1_sq_') and @aria-label='Complied']");
    private By urinalTrapCompliance = By.xpath("//input[contains(@name,'Question5_sq_') and @aria-label='Yes']");
    private By generateLetter = By.cssSelector("button[aria-label='In-Order/Not In-Order Letter. Generate Letter']");
    private By newWorkOrder = By.cssSelector("button[aria-label='New Work Order. Add New Work Order']");
    private By woType = By.cssSelector("select[aria-label='WO Type']");
    private By hydroAndPressure = By.xpath("//button[contains(@aria-label,'Hydro Test & Low Pressure Air Test Submitted')]");
    private By soReworkComment = By.cssSelector("textarea[aria-label='SO Rework Comments']");

    // WRN11-BPF
    private By emailToCustomer = By.cssSelector("select[aria-label='Email To Customer Sent?']");
    private By approveAndResolveCase = By.cssSelector("select[aria-label='Approve and Resolve Case']");
    private By sendBackToFIO = By.cssSelector("select[aria-label='Send back to FIO']");
    
 	// Locators for ApproveWO
 	private By rejectWOBtn = By.xpath("//button[@aria-label='Reject WO']");
 	private By remarksField = By.xpath("//textarea[@name='remarkComments']");
 	private By submitBtn = By.xpath("//input[@type='submit']");
 	private By approveWOBtn = By.xpath("//button[@aria-label='Accept WO']");

 	private By startTimeCol = By.xpath("//div[text()='Start Time']");
	private By NewToOldCol = By.xpath("//span[text()='Sort newer to older']");
	private By oldToNewCol = By.xpath("//span[text()='Sort older to newer']");
	
    String todayDateTime = eleUtil.todayDateAndTime();

    // WRN6IMB Locators
    private By typeOfWO = By.xpath("//div[@aria-rowindex='2']//div[@col-id='pub_workordertype']//label");
    
    // Locators for deviation remarks
    private By systemAssesmentval = By.xpath("//select[@aria-label='User Assessment']");
	private By deviationRemarks = By.xpath("//input[@aria-label='Deviation Remarks']");
	
	// Locators for verify new case is created?
	private By casenumber = By.xpath("(//div[@col-id='statuscode' and @role='gridcell']//span)[1]");
	private By caseStatus = By.xpath("(//div[@col-id='statecode']//label)[2]");

	// Locators for WRN4
	private By noOfWOs = By.xpath("//div[contains(@data-id,'WorkOrders-pcf_grid')]//span[contains(@class,'statusContainer')]");


    
    public By getCaseType() {
        return caseType;
    }

    public By getWorkOrderCount() {
        return workOrderCount;
    }

    public By getBookingCount() {
        return bookingCount;
    }

    public By getCaseSubType() {
        return caseSubType;
    }

    public By getWRPSection() {
        return wrpSection;
    }

    public By getAlertSource() {
        return alertSource;
    }

    public By getWRPCatchment() {
        return wrpCatchment;
    }

    public By getIssueReported() {
        return issueReported;
    }

    public By getEntity() {
        return entity;
    }

    public By getManholeListSection() {
        return manholeListSection;
    }

    public By getCatchment() {
        return catchment;
    }

    public By getRiskCategory() {
        return riskCategory;
    }

    public By getFactoriesListSection() {
        return factoriesListSection;
    }

    public By getParentCase() {
        return parentCase;
    }

    public By getParentCaseValue() {
        return parentCaseValue;
    }

    public By getBusinessFunction() {
        return businessFunction;
    }

    public By getBusinessFunctionName() {
        return businessFunctionName;
    }

    public By getLastInspectedDate() {
        return lastInspectedDate;
    }

    public By getAOResponseOption() {
        return aoResponseOption;
    }

    public By getNextStageBtn() {
        return nextStageBtn;
    }

    public By getRecurrenceRequired() {
        return recurrenceRequired;
    }

    public By getFrequency() {
        return frequency;
    }

    public By getNextBookingDate() {
        return nextBookingDate;
    }

    public By getResolveCaseOption() {
        return resolveCaseOption;
    }

    public By getFinishBtn() {
        return finishBtn;
    }

    public By getNoDataAvailableInSingleGrid() {
        return noDataAvailableInSingleGrid;
    }

    public By clickGenerateLetter() {
        return generateLetter;
    }

    public By clickMoreCommandButton() {
        return moreCommandButton;
    }

    public By getNewWorkOrder() {
        return newWorkOrder;
    }

    public By getWOType() {
        return woType;
    }

    public By getHydroAndPressure() {
        return hydroAndPressure;
    }
    // This method can be removed once this issue is fixed
    /*public void enableWRPSubType() {
        eleUtil.waitForVisibilityOfElement(getCaseType(), 30);
        eleUtil.selectDropDownValue(getCaseType(), "selectByVisibleText", "Investigation Case", "select Case type as Investigation Case");
        eleUtil.waitForVisibilityOfElement(getCaseType(), 30);
        eleUtil.selectDropDownValue(getCaseType(), "selectByVisibleText", "Inspection Case", "select Case type as Inspection Case");
    }*/

    public void caseCreationForWRP(String wrpCatchment, String alertSource) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(getCaseSubType(), 30);
        eleUtil.selectDropDownValue(getCaseSubType(), "selectByVisibleText", "WRP Alert Inspection", "select Case sub type as WRP Alert Inspection");
        if ((!eleUtil.elementIsDisplayed(getWRPSection(), "WRP Section is not visible"))) {
            eleUtil.waitForVisibilityOfElement(getWRPSection(), 50);
        }
        eleUtil.waitForVisibilityOfElement(getWRPCatchment(), 30);
        eleUtil.doClearUsingKeyswithWait(getWRPCatchment(), 30);
        eleUtil.doSendKeysWithWaitEnter(getWRPCatchment(), wrpCatchment, 30);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
        eleUtil.waitForVisibilityOfElement(getIssueReported(), 30);
        eleUtil.doClearUsingKeyswithWait(getIssueReported(), 30);
        eleUtil.doSendKeysLog(getIssueReported(), "Issue Reported " + todayDateTime, "send some random value in Issue Report");
        eleUtil.waitForVisibilityOfElement(getAlertSource(), 30);
        eleUtil.selectDropDownValue(getAlertSource(), "selectByVisibleText", alertSource, "select alert source as WRP – VOC");
    }

    public void checkCaseCreationForWRP(String wrpCatchment, String alertSource) throws InterruptedException {
        eleUtil.textVerificationFormAttribute(getEntity(), "title", alertSource);
        eleUtil.textVerificationFormAttribute(getCatchment(), "title", wrpCatchment);
        eleUtil.elementIsDisplayed(getFactoriesListSection(), "Factories List Section is visible");
        eleUtil.elementIsDisplayed(getManholeListSection(), "Manhole List Section is visible");
        commonCRMActions.casenumber = crmActions.setPageTitle();
    }

    public void checkWorkOrderCreated() throws InterruptedException {
        eleUtil.waitTillElementIsDisplayed(crmActions.getMoreButtonOnWorkOrder(), 30);
        eleUtil.doClickLog(crmActions.getMoreButtonOnWorkOrder(), "Clicked on work order grid refresh button");
        eleUtil.waitTillElementIsDisplayed(crmActions.getWorkOrderGridRefresh(), 30);
        eleUtil.doClickLog(crmActions.getWorkOrderGridRefresh(), "Clicked on work order grid refresh button");
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(checkWOCreated, "No data available")) {
                Thread.sleep(3000);
                eleUtil.waitTillElementIsDisplayed(crmActions.getMoreButtonOnWorkOrder(), 30);
                eleUtil.doClickLog(crmActions.getMoreButtonOnWorkOrder(), "Clicked on work order grid refresh button");
                eleUtil.doClickLog(crmActions.getWorkOrderGridRefresh(), "Work Order not created click on work order grid refresh button");
            } else {
                // If the element is not displayed, execute the else block logic
                try {
                    Log.info("Work Order Number " + factory.getWorkOrderNumber());
                    return; // Exit the method if the case number is verified
                } catch (NoSuchElementException e) {
                    Log.error("Work Order not Created: " + e.getMessage());
                }
            }
        }
    }

    public void selectListOfActiveCases(String listView) {
        eleUtil.waitForVisibilityOfElement(listViewOfCases, 100);
        eleUtil.doClickLog(listViewOfCases, "Click on list view of Cases");
        eleUtil.waitForVisibilityOfElement(factory.getSearchResults(), 100);
        eleUtil.doSendKeysLog(factory.getSearchResults(), listView, "Enter List View Name");
        By selectView = By.xpath("//label[text()='" + listView + "']");
        eleUtil.waitForVisibilityOfElement(selectView, 20);
        eleUtil.doClickLog(selectView, "click on Active Cases View");
    }

    public int workOrderCount() {
        eleUtil.waitForVisibilityOfElement(getWorkOrderCount(), 40);
        String workOrder = eleUtil.doElementGetText(getWorkOrderCount());
        Log.info("print work order " + workOrder);
        Log.info("After extract " + eleUtil.extractLastValue(workOrder));
        return eleUtil.extractLastValue(workOrder);
    }

    public void childCaseVerification() throws InterruptedException {
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(getNoDataAvailableInSingleGrid(), "No data available")) {
                Thread.sleep(3000);
                eleUtil.doClickLog(crmActions.getRefreshBtn(), "Click on Refresh button");
                navigatingToTab("Child Cases");
            } else {
                // If the element is not displayed, execute the else block logic
                try {
                    commonCRMActions.childCaseNumber = factoryPage.getCaseNumber();
                    assertTrue(commonCRMActions.childCaseNumber.startsWith("DQB/TE/I"), "Case number format is not expected");
                    Log.info(commonCRMActions.childCaseNumber);
                    return; // Exit the method if the case number is verified
                } catch (NoSuchElementException e) {
                    Log.error("Case number element not found: " + e.getMessage());
                }
            }
        }
    }

    public void openChildCaseOrCase() {
        eleUtil.waitForVisibilityOfElement(factoryPage.getCaseNumberVerify(), 30);
        eleUtil.doClickLog(factoryPage.getCaseNumberVerify(), "Open Child Case or Case");
    }

    public static String getChildWorkOrderNumber() {
        String workOrder = eleUtil.doElementGetText(factoryPage.getWorkOrderVerify());
        return workOrder;
    }

    public void childCaseWorkOrderVerification() throws InterruptedException {
        eleUtil.waitTillElementIsDisplayed(childCaseWorkOrderRefresh, 30);
        eleUtil.doClickLog(childCaseWorkOrderRefresh, "Clicked on work order grid refresh button");
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(checkWOCreated, "No data available")) {
                Thread.sleep(3000);
                eleUtil.doClickLog(childCaseWorkOrderRefresh, "Work Order not created click on work order grid refresh button");
            } else {
                // If the element is not displayed, execute the else block logic
                try {
                    Log.info("Work Order Number " + getChildWorkOrderNumber());
                    return; // Exit the method if the case number is verified
                } catch (NoSuchElementException e) {
                    Log.error("Work Order not Created: " + e.getMessage());
                }
            }
        }
    }

    public void childCaseNotification() throws InterruptedException {
        crmActions.notificationForTabToOpen(commonCRMActions.childCaseNumber, "Inspection Case Information");
    }

    public void childCaseWorkOrderNotification() throws InterruptedException {
        crmActions.notificationForTabToOpen(getChildWorkOrderNumber(), "Work Orders");
    }

    public void fillCheckListForMHWRP(String status, String checkListName, String level) throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        String nextButton;
        // Store all WOs from the first page
        commonCRMActions.WOnumber = crmActions.getWONumber();
        woNum.addAll(commonCRMActions.WOnumber);
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is: " + woNum.size());
        // Check if there is a next button and click it if enabled
        nextButton = eleUtil.doGetElementAttributeLog(crmActions.getNextButtonOnWorkOrder(), "aria-disabled", "Check next button is true/false");
        while (nextButton.contains("false")) {
            eleUtil.doClickLog(crmActions.getNextButtonOnWorkOrder(), "click on next button on Work Order");
            Thread.sleep(2000);
            // Store all WOs from the next page
            commonCRMActions.WOnumber = crmActions.getWONumber();
            woNum.addAll(commonCRMActions.WOnumber);
            Log.info("print wo number " + woNum);
            Log.info("size is: " + woNum.size());
            // Check the next button status again
            nextButton = eleUtil.doGetElementAttributeLog(crmActions.getNextButtonOnWorkOrder(), "aria-disabled", "Check next button is true/false");
        }
        for (int i = 0; i < woNum.size(); i++) {
            eleUtil.waitTillElementIsDisplayed(getMoreButtonOnWorkOrder(), 30);
            eleUtil.doClickLog(getMoreButtonOnWorkOrder(), "Clicked on work order grid refresh button");
            eleUtil.doClickLog(getWorkOrderGridRefresh(), "Work Order not created click on work order grid refresh button");
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            if (i < woNum.size() - 1 || level.equals("L2")) {
                selectChecklistForMHWRPReport("No");
            } else {
                selectChecklistForMHWRPReport("Yes");
            }
            crmActions.saveChecklist();
        }
        crmActions.resetFirstRunFlag();
    }

    public void selectChecklistForMHWRPReport(String abnormalityValue) {
        eleUtil.waitTillElementIsDisplayed(anyAbnormality, 30);
        eleUtil.selectDropDownValue(anyAbnormality, "selectByVisibleText", abnormalityValue, "Select Yes Toolbox Briefing Conducted");
        eleUtil.waitForVisibilityOfElement(remarks, 30);
        eleUtil.doSendKeysLog(remarks, todayDateTime, "send any value for remarks field");
    }

    public void hardWaitForWorkOrder(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void checkScenario1(String riskCategory, String catchment) {
        eleUtil.textVerificationFormAttribute(getCatchment(), "title", catchment);
        eleUtil.textVerificationFormAttribute(getRiskCategory(), "title", riskCategory);
        eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
    }

    public void checkWorkOrderCountAfterL2(int workOrderCountL2) {
        Assert.assertEquals(workOrderCount(), workOrderCountL2, "Count is not matched " + workOrderCountL2);
    }

    public void checkParentIdNotBlank() throws InterruptedException {
        eleUtil.isPageLoaded(30);
        eleUtil.scrollDownTillElementVisible(getParentCase());
        String parentCaseId = eleUtil.doElementGetTextLog(getParentCaseValue(), "get Parent Case Id ");
        Assert.assertNotNull(parentCaseId, "Parent Case Id is empty");
        eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
    }

    public void checkCaseBusinessFunction(String wrn3) {
        eleUtil.waitForVisibilityOfElement(getBusinessFunction(), 30);
        eleUtil.doClickLog(getBusinessFunction(), "click on Business Function");
        eleUtil.isPageLoaded(30);
        eleUtil.waitForVisibilityOfElement(getBusinessFunctionName(), 40);
        String businessFunctionName = eleUtil.doGetElementAttributeLog(getBusinessFunctionName(), "title", "get Business Function Name ");
        Assert.assertEquals(businessFunctionName, wrn3, "Business Function Name not matched");
        eleUtil.doClickLog(crmActions.getSaveNCloseBtn(), "Click on Save & Close button");
        eleUtil.isPageLoaded(30);
    }

    public void checkChildCaseSubType(String caseSubType) {
        eleUtil.waitForVisibilityOfElement(getCaseSubType(), 40);
        String childCaseSubType = eleUtil.doGetElementAttributeLog(getCaseSubType(), "title", "get Case Sub Type ");
        Assert.assertEquals(childCaseSubType, caseSubType, "Case Sub Type not matched");
    }

    public void openBookingRecord() throws InterruptedException {
        crmActions.workOrderStatusFilter("Scheduled");
        List<String> woNum = new ArrayList<>();
        commonCRMActions.WOnumber = crmActions.getWONumber();
        woNum.addAll(commonCRMActions.WOnumber);
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is: " + woNum.size());
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.processWorkOrder(woNum.get(i), "Scheduled");
            // Validation on Booking tab
            eleUtil.staleElementRefExecClickCRM(crmActions.getBookingTab());
            eleUtil.doClick(crmActions.getBookingTab());
            Thread.sleep(2000);
            selectFirstRecord();
            getFirstRecord();
            // Uncomment below code while running in SIT3
            //eleUtil.doElementClickable(crmActions.getMaximizeScreenBtn(), 10);
            //eleUtil.doClick(crmActions.getMaximizeScreenBtn());
        }
    }

    public void checkTimeDurationAndStartTime(String timeDuration) throws InterruptedException {
        openBookingRecord();
        eleUtil.waitForVisibilityOfElement(duration, 50);
        String durationValue = eleUtil.doGetElementAttributeLog(duration, "value", "get Duration Value ");
        String startTimeValue = eleUtil.doGetElementAttributeLog(startTime, "value", "get Start Time ");
        String endTimeValue = eleUtil.doGetElementAttributeLog(endTime, "value", "get End Time ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        LocalTime expectedStartTime = LocalTime.parse(eleUtil.getSingaporeCurrentTime(), formatter);
        LocalTime actualStartTime = LocalTime.parse(startTimeValue, formatter);
        LocalTime expectedEndTime = LocalTime.parse(eleUtil.getSingaporeCurrentTimePlusTwoHours(), formatter);
        LocalTime actualEndTime = LocalTime.parse(endTimeValue, formatter);

        long startTimeDifference = ChronoUnit.MINUTES.between(expectedStartTime, actualStartTime);
        long endTimeDifference = ChronoUnit.MINUTES.between(expectedEndTime, actualEndTime);

        int toleranceMinutes = 5; // Allowable difference in minutes
        Assert.assertEquals(durationValue, timeDuration, "Duration Time not matched");
        Assert.assertTrue(Math.abs(startTimeDifference) <= toleranceMinutes, "Start Time and Current time not matched within tolerance");
        Assert.assertTrue(Math.abs(endTimeDifference) <= toleranceMinutes, "End Time and Current time +2 hrs not matched within tolerance");
    }

    public void fillCheckListForPumpingSystem(String status, String checkListName, String systemAssessment) throws InterruptedException {
        commonCRMActions.WOnumber = crmActions.getWONumber();
        List<String> woNum = commonCRMActions.WOnumber;
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is:" + woNum.size());
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            pumpingSystemChecklist(systemAssessment);
            crmActions.saveChecklist();
        }
    }

    public void pumpingSystemChecklist(String systemAssessment) throws InterruptedException {
        eleUtil.selectDropDownValue(pumpingType, "selectByVisibleText", "Pumping Station", "select entity type as Pumping Station");
        if (systemAssessment.equals("Not In Order")) {
            eleUtil.waitForVisibilityOfElement(pumpingEquipmentAncillariesNOtOK, 30);
            eleUtil.doClickLog(pumpingEquipmentAncillariesNOtOK, "Select Not OK for Pumping Equipment and ancillaries");
            String path = filePath + pngFilePath;
            Log.info("final path to upload " + path);
            uploadFile(uploadPhoto, path);
        } else {
            eleUtil.doClickLog(pumpingEquipmentAncillariesNA, "Select NA for Pumping Equipment and ancillaries");
        }
        for (int i = 2; i <= 12; i++) {
            By inOrder = By.xpath("//input[contains(@name,'Q" + i + "_sq_') and @aria-label='NA']");
            eleUtil.doClickLog(inOrder, "Select NA for for all the WRN9 IMB Pumping Systems Inspection Checklist");
        }
        eleUtil.waitForVisibilityOfElement(calenderIcon, 40);
        eleUtil.doClickLog(calenderIcon, "Click on Calender Icon");
        eleUtil.waitForVisibilityOfElement(crmActions.getSelectTodayDateAndTime(), 30);
        eleUtil.doClickLog(crmActions.getSelectTodayDateAndTime(), "Select today's date");
    }

    public void checkLastInspectedOn() throws InterruptedException {
        eleUtil.scrollDownTillElementVisible(getLastInspectedDate());
        String inspectedDate = eleUtil.doGetElementAttributeLog(getLastInspectedDate(), "value", "get Last Inspected Date ");
        Assert.assertEquals(eleUtil.todayDate("M/d/yyyy"), inspectedDate, "Last Inspected Date not matched with today's date");
    }

    public void completeWRN9AOReviewStage(String recurrence, String frequency) {
        navigatingToStage("AO Review");
        eleUtil.waitForVisibilityOfElement(getAOResponseOption(), 10);
        eleUtil.createSelect(getAOResponseOption());
        eleUtil.selectDropDownValue(getAOResponseOption(), "selectByVisibleText", "Approve", "Select Approve in AO Response");
        eleUtil.selectDropDownValue(getRecurrenceRequired(), "selectByVisibleText", recurrence, "Select " + recurrence + " in Recurrence Required");
        if (recurrence.equals("Yes")) {
            eleUtil.doSendKeysLog(getFrequency(), frequency, "Enter Frequency as " + frequency + " numbers of days");
        }
        eleUtil.doElementClickable(crmActions.getSaveBtn(), 10);
        eleUtil.doActionsClick(crmActions.getSaveBtn());
        navigatingToStage("AO Review");
        eleUtil.doElementClickable(getNextStageBtn(), 10);
        eleUtil.doClick(getNextStageBtn());
    }

    public void checkNextBookingDate(int days) throws InterruptedException {
        clickOnRefreshBtn();
        eleUtil.scrollDownTillElementVisible(getNextBookingDate());
        String nextBooking = eleUtil.doGetElementAttributeLog(getNextBookingDate(), "value", "get Next Booking Date ");
        Assert.assertEquals(eleUtil.todayDatePlusDays("M/d/yyyy", days), nextBooking, "Next Booking Date not matched ");
    }

    public void CompleteWRN9ResolveCaseStage(String resolveCase) throws InterruptedException {
        navigatingToStage("Close");
        eleUtil.waitForVisibilityOfElement(getResolveCaseOption(), 10);
        eleUtil.selectDropDownValue(getResolveCaseOption(), "selectByVisibleText", resolveCase, "Select " + resolveCase + " in Resolve Case");
        eleUtil.isPageLoaded(50);
        if (eleUtil.elementIsDisplayed(warningRecurrence, "Saving in Progress Pop Up")) {
            eleUtil.waitForVisibilityOfElement(warningRecurrence, 30);
        } else {
            clickOnRefreshBtn();
        }
    }

    public void checkRecurrenceMessage(String recurrenceMessage) {
        String actualRecurrenceMessage = eleUtil.doElementGetTextLog(recurrenceMessageLocator, "get Recurrence Message ");
        Assert.assertEquals(recurrenceMessage, actualRecurrenceMessage, "Recurrence Message not matched");
    }

    public void checkWorkOrderNotification(String tabName) throws InterruptedException {
        crmActions.notificationForTabToOpen(factory.getWorkOrderNumber(), tabName);
    }

    public void fillCheckListForWRN11AuditInspection(String status, String checklistType, String checkListName) throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            WRN11NonCompChecklistAuditInspection(checklistType, checkListName);
            crmActions.saveChecklist();
        }
    }

    public void WRN11NonCompChecklistAuditInspection(String checklistType, String checkListName) throws InterruptedException {
        String path = filePath + pngFilePath;
        Log.info("final path to upload " + path);
        if ("WRN 11 NMB Sanitary Inspection".equals(checkListName)) {
            if ("Non-Compliance".equals(checklistType)) {
                eleUtil.waitForVisibilityOfElement(branchDrainNonCompliance, 40);
                eleUtil.doClickLog(branchDrainNonCompliance, "Select Non-Compliance for Branch drain-lines / Main drain lines: The minimum diameter of branch drain lines");
                uploadFile(choosePhoto, path);
            } else if ("Compliance".equals(checklistType)) {
                eleUtil.waitForVisibilityOfElement(branchDrainCompliance, 40);
                eleUtil.doClickLog(branchDrainCompliance, "Select Compliance for Branch drain-lines / Main drain lines: The minimum diameter of branch drain lines");
            }
        } else if ("Audit Inspection: Temp Toilet / Minor Works Check".equals(checkListName)) {
            if ("Non-Compliance".equals(checklistType)) {
                eleUtil.waitForVisibilityOfElement(urinalTrapNonCompliance, 40);
                eleUtil.doClickLog(urinalTrapNonCompliance, "Select No for Urinals provided with urinal trap");
                uploadFile(choosePhoto, path);
            } else if ("Compliance".equals(checklistType)) {
                eleUtil.waitForVisibilityOfElement(urinalTrapCompliance, 40);
                eleUtil.doClickLog(urinalTrapCompliance, "Select Yes for Urinals provided with urinal trap");
            }
        }
    }

    public void checkCaseNotification(String tabName) throws InterruptedException {
        crmActions.notificationForTabToOpen(commonCRMActions.casenumber, tabName);
    }

    public void soReviewForWRN11() {
        navigatingToStage("SO Review");
        eleUtil.waitForVisibilityOfElement(emailToCustomer, 10);
        eleUtil.selectDropDownValue(emailToCustomer, "selectByVisibleText", "Yes", "Select Yes in Email TO Customer Sent");
        eleUtil.selectDropDownValue(approveAndResolveCase, "selectByVisibleText", "Yes", "Select Yes in Approve and Resolve Case");
        eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
        navigatingToStage("SO Review");
        eleUtil.doElementClickable(getNextStageBtn(), 10);
        eleUtil.doClickLog(getNextStageBtn(), "Click on Next Stage button");
    }

    public void inOrderNNotInOrderButton() {
        eleUtil.waitForVisibilityOfElement(clickMoreCommandButton(), 10);
        eleUtil.doClickLog(clickMoreCommandButton(), "Click on More Command button on Cases");
        eleUtil.waitForVisibilityOfElement(clickGenerateLetter(), 10);
        eleUtil.doClickLog(clickGenerateLetter(), "Click on More Command button on Cases");
        clickOnRefreshBtn();
    }

    public void soReviewForWRN11ReInspection() {
        eleUtil.doSendKeysLog(soReworkComment, "Sending back to FIO", "Enter value in SO Rework Comments");
        navigatingToStage("SO Review");
        eleUtil.waitForVisibilityOfElement(emailToCustomer, 10);
        eleUtil.selectDropDownValue(emailToCustomer, "selectByVisibleText", "Yes", "Select Yes in Email TO Customer Sent");
        eleUtil.selectDropDownValue(sendBackToFIO, "selectByVisibleText", "Yes", "Select Yes in Send Back To FIO");
        eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
    }

    public void manualWOWRN11() {
        eleUtil.waitForVisibilityOfElement(getNewWorkOrder(), 10);
        eleUtil.doClickLog(getNewWorkOrder(), "Click on New Work Order button");
        eleUtil.selectDropDownValue(getWOType(), "selectByVisibleText", "Re-Inspection", "Select Re-Inspection in WO Type");
        eleUtil.waitTillElementIsDisplayed(factory.getSaveAndClose(), 30);
        eleUtil.doClickLog(factory.getSaveAndClose(), "Click on Save and Close button");
        clickOnRefreshBtn();
    }

    public void hydroTestLowPressureAirTest() {
        eleUtil.waitForVisibilityOfElement(getHydroAndPressure(), 50);
        eleUtil.doClickLog(getHydroAndPressure(), "Click on Hydro Test & Low Pressure Air Test Submitted toggle button");
        eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
    }

    public void reInspectionForWRN11() throws InterruptedException {
        navigatingToStage("Inspection");
        clickOnNextStageBtn();
        factory.clickOnSavingInProgressOkButton();
        eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
    }

    public void soReviewForWRN7NMB(String soValue) {
        navigatingToStage("SO Review");
        eleUtil.waitForVisibilityOfElement(soResponseOption, 10);
        eleUtil.selectDropDownValue(soResponseOption, "selectByVisibleText", soValue, "Select " + soValue + " SO Response");
        eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
        navigatingToStage("SO Review");
        eleUtil.doElementClickable(getNextStageBtn(), 10);
        eleUtil.doClickLog(getNextStageBtn(), "Click on Next Stage button");
    }
    
    public void verifyWOType() {
		navigatingToTab("Work Orders");
		eleUtil.waitTillElementIsDisplayed(typeOfWO, 30);
		String WOTypeVal=eleUtil.doGetElementAttributeLog(typeOfWO, "aria-label", "Selected WO type field value is : ");
		if(WOTypeVal.equals("Recurring Inspection")) {
			Log.info("Recurring Work order got created");
		}
		else {
			Log.info("Recurring Work order not getting created");
		}
	}
    
    public void clickOnRejectWOBtn() {
		eleUtil.waitForVisibilityOfElement(rejectWOBtn, 40);
		eleUtil.doClickLog(rejectWOBtn, "Click on Reject WO button");
	}

	public void enterRemarks() {
		eleUtil.waitTillElementIsDisplayed(remarksField, 30);
		eleUtil.doClickLog(remarksField, "Clicked on SO Remarks field");
		eleUtil.doClearUsingKeysLog(remarksField, "Clear the SO Remarks field");
		eleUtil.doSendKeysLog(remarksField, "546", "Passing value to SO Remarks field");
	}

	public void clickOnAccepttWOBtn() {
		eleUtil.waitForVisibilityOfElement(approveWOBtn, 40);
		eleUtil.doClickLog(approveWOBtn, "Click on Approve WO button");
	}

	public void clickOnSubmitBtn() {
		eleUtil.waitForVisibilityOfElement(submitBtn, 40);
		eleUtil.doClickLog(submitBtn, "Click on submit button");
	}
	
	public void sortFromNewToOld() {
		sortTheRecords(startTimeCol, NewToOldCol, AppConstants.LONG_DEFAULT_WAIT);
	}
	
	public void rejectingWO(String WOstatus) {
		By status = By.xpath("//label[@aria-label='" + WOstatus + "']");
		eleUtil.waitForVisibilityOfElement(status, 10);
		String actualStatusval = eleUtil.doGetElementAttributeLog(status, "aria-label",
				"WO Status value from case home page is : ");
		if (actualStatusval.equals(WOstatus)) {
			selectFirstRecord();
			getFirstRecord();
			clickOnRejectWOBtn();
			enterRemarks();
			clickOnSubmitBtn();
			clickOnSaveBtn();
		}
	}
	public void acceptingWO(String WOstatus) {
		By status = By.xpath("//label[@aria-label='" + WOstatus + "']");
		eleUtil.waitForVisibilityOfElement(status, 10);
		String actualStatusval = eleUtil.doGetElementAttributeLog(status, "aria-label",
				"WO Status value from case home page is : ");
		if (actualStatusval.equals(WOstatus)) {
			selectFirstRecord();
			getFirstRecord();
			clickOnAccepttWOBtn();
			clickOnSubmitBtn();
			clickOnSaveBtn();
		}
	}

	public void verifyNewBookingCreated(String bookingStatus, String WOStatus) throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(crmActions.getBookingTab(), 30);
		eleUtil.staleElementRefExecClickCRM(crmActions.getBookingTab());
		eleUtil.doClick(crmActions.getBookingTab());
		Thread.sleep(2000);
		By bookingRecord = By.xpath("//div[@col-id='bookingstatus' and @role='gridcell']//a");
		List<WebElement> bookingRecords = driver.findElements(bookingRecord);
		System.out.println("no of booking records bA" + bookingRecords.size());
		// Collecting all the booking resource texts
		for (WebElement record : bookingRecords) {
			String ariaLabel = record.getAttribute("aria-label");
			sortFromNewToOld();
			if (ariaLabel.equals(bookingStatus)) {
				Log.info("New Booking created after Reject");
			} else {
				Log.info("New Booking is not created after Reject");
			}
		}
		crmActions.clickOnSaveNCloseButton();
		crmActions.navigateToTab("Sumamry");
		By WOstatusInWOform = By.xpath(
				"//select[@aria-label='WO Status']//ancestor::div[@data-lp-id='MscrmControls.FieldControls.OptionSet|msdyn_systemstatus.fieldControl|msdyn_workorder']//select");
		eleUtil.waitForVisibilityOfElement(WOstatusInWOform, 10);
		String actualStatusval = eleUtil.doGetElementAttributeLog(WOstatusInWOform, "aria-label",
				"WO Status value from case home page is : ");
		assertEquals(actualStatusval, WOStatus, "WO status is not same");
	}
	
	public void updateSystemAssesmentVal() {
		eleUtil.waitForVisibilityOfElement(systemAssesmentval, 20);
		String SystemAssesmentVal = eleUtil.doGetElementAttributeLog(systemAssesmentval, "title",
				"Displayed System Assesment is : ");
        eleUtil.selectDropDownValue(systemAssesmentval, "selectByVisibleText", "Compliance",
				"Select Compliance in User Assesment field");
		
	}
	public void updateDeviationRemarks() {
		eleUtil.waitForVisibilityOfElement(deviationRemarks, 20);
		eleUtil.doSendKeysLog(deviationRemarks, "Remarks entered", "Sending value to the Deviation Remarks filed : ");
	}
	public void newCaseCheck() {
		String caseNo = eleUtil.doElementGetTextLog(casenumber, "case number is : ");
		String Status = eleUtil.doElementGetTextLog(caseStatus, "Status reason is : ");
		if(caseNo.contains("IMB/RP/I") && Status.equals("Active")) {
			Log.info("New case got created");
		}
		else {
			Log.info("New case is not created");
			
		}
	}

    public int bookingCount() {
        eleUtil.waitForVisibilityOfElement(getBookingCount(), 40);
        String booking = eleUtil.doElementGetText(getBookingCount());
        Log.info("print work order " + booking);
        Log.info("After extract " + eleUtil.extractLastValue(booking));
        return eleUtil.extractLastValue(booking);
    }

    public void checkBookingCount(int bookingCount) {
        Assert.assertEquals(bookingCount(), bookingCount, "Count is not matched " + bookingCount);
        eleUtil.doClickLog(crmActions.getSaveNCloseBtn(), "Click on Save & Close button");
    }
	public String getTheNoOfWOs() {
		eleUtil.waitForVisibilityOfElement(noOfWOs, 50);
		String totalWOs=eleUtil.doElementGetTextLog(noOfWOs, "Text in the application is : ");
		String totalcount = totalWOs.substring(9, 10);
		Log.info("Total Number of WOs created is :"+totalcount);
		return totalcount;
	}

    public void caseCreationForPumpingMain(String caseSubType) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(getCaseSubType(), 30);
        eleUtil.selectDropDownValue(getCaseSubType(), "selectByVisibleText", caseSubType, "select Case sub type " +  caseSubType);
        eleUtil.scrollDownTillElementVisible(caseRemarksField);
        eleUtil.doClearUsingKeysLog(caseRemarksField, "Clear Remarks field");
        eleUtil.doSendKeysLog(caseRemarksField, caseSubType + " Case", "send any value for remarks field");
    }

    public void waitCaseSaveStatus() {
        eleUtil.waitForVisibilityOfElement(caseSaved, 200);
        commonCRMActions.casenumber = crmActions.setPageTitle();
    }

    public void workOrderVerificationOnCase() throws InterruptedException {
        eleUtil.waitTillElementIsDisplayed(getMoreButtonOnWorkOrder(), 30);
        eleUtil.doClickLog(getMoreButtonOnWorkOrder(), "Clicked on work order grid refresh button");
        eleUtil.doClickLog(getWorkOrderGridRefresh(), "Work Order not created click on work order grid refresh button");
        Thread.sleep(2000);
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(checkWOCreated, "No data available")) {
                Thread.sleep(3000);
                eleUtil.doClickLog(getMoreButtonOnWorkOrder(), "Clicked on work order grid refresh button");
                eleUtil.doClickLog(getWorkOrderGridRefresh(), "Work Order not created click on work order grid refresh button");
            } else {
                // If the element is not displayed, execute the else block logic
                try {
                    Log.info("Work Order Number " + factory.getWorkOrderNumber());
                    return; // Exit the method if the case number is verified
                } catch (NoSuchElementException e) {
                    Log.error("Work Order not Created: " + e.getMessage());
                }
            }
        }
    }

    public int workOrderCountForWRN10(int woCount) throws InterruptedException {
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        eleUtil.waitForVisibilityOfElement(getWorkOrderCount(), 40);
        String workOrder = eleUtil.doElementGetText(getWorkOrderCount());
        Log.info("print work order " + workOrder);
        int extractedValue = eleUtil.extractLastValue(workOrder);
        Log.info("After extract " + extractedValue);
        while (System.currentTimeMillis() < endTime) {
            if (woCount != extractedValue) {
                Thread.sleep(3000);
                eleUtil.doClickLog(getMoreButtonOnWorkOrder(), "Clicked on work order grid refresh button");
                eleUtil.doClickLog(getWorkOrderGridRefresh(), "Work Order not created click on work order grid refresh button");
                workOrder = eleUtil.doElementGetText(getWorkOrderCount());
                extractedValue = eleUtil.extractLastValue(workOrder);
            } else {
                break;
            }
        }
        return extractedValue;
    }

}