package com.sat.locators;

import com.sat.Pages.commonActionsPage;
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
    String todayDateTime = eleUtil.todayDateAndTime();

    // Locators for BPF
    private By allDocsReceived = By.xpath("//select[@aria-label='All Documents Received']");
    private By generateDraftEventPermit = By.cssSelector("select[aria-label='Generate Draft Event Permit']");
    private By applicationDetailsReviewed = By.cssSelector("select[aria-label='Application Details Reviewed']");

    // Create creation fields for WRN
    private By warningMessageOnCase = By.cssSelector("span[data-id='warningNotification']");

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
    private By childCaseRefresh = By.xpath("//button[@title='Refresh' and contains(@id,'SubGridStandard')]");

    private By listViewOfCases = By.xpath("//h1[contains(@title,'Cases')] //span[@data-automationid='splitbuttonprimary']");
    private By workOrderCount = By.xpath("//div[@data-id='WorkOrders-pcf_grid_control_container'] //span[contains(@class,'statusContainer')]");
    private By bookingCount = By.xpath("//div[@data-id='bookings-pcf_grid_control_container'] //span[contains(@class,'statusContainer')]");
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
    private By caseRemarksField = By.xpath("//textarea[contains(@aria-label,'Remarks')]");

    //Pumping System Inspection
    private By pumpingEquipmentAncillariesNA = By.xpath("//input[contains(@name,'Q1_sq_') and @aria-label='NA']");
    private By pumpingEquipmentAncillariesNOtOK = By.xpath("//input[contains(@name,'Q1_sq_') and @aria-label='Not Ok']");
    private By pumpingType = By.cssSelector("select[aria-label='Type']");
    private By calenderIcon = By.xpath("//input[contains(@id,'date-label')]");
    private By uploadPhoto = By.cssSelector("input[aria-label='Upload Photos'] ");
    private By entityLookupField = By.xpath("//input[@aria-label='Entity, Lookup']");
    private By lastInspectedDate = By.cssSelector("input[aria-label='Date of Last Inspected On']");
    private By nextBookingDate = By.cssSelector("input[aria-label='Date of Next Booking Date']");

    //BPF Locators
    private By aoResponseOption = By.xpath("//select[@aria-label='AO Response']");
    private By recurrenceRequired = By.cssSelector("select[aria-label='Recurrence Required']");
    private By frequency = By.cssSelector("input[aria-label='Frequency (days)']");
    private By nextStageBtn = By.xpath("//div[contains(@id,'nextButton')]");
    private By resolveCaseOption = By.cssSelector("select[aria-label='Resolve Case']");
    private By finishBtn = By.cssSelector("button[@aria-label='Finish']");
    private By submitSOReviewBtn = By.xpath("//select[contains(@id,'header') and @aria-label='Submit for SO Review']");
    private By inspectionCompletedOption = By.xpath("//select[@aria-label='Inspection Completed?']");
    private By emailSentToCustomer = By.cssSelector("label[aria-label='Email Sent to Customer?']");
    private By sendMnCLetter = By.cssSelector("label[aria-label='Send M&C Letter']");

    private By warningRecurrence = By.cssSelector("h1[aria-label='Warning']");
    private By recurrenceMessageLocator = By.cssSelector("span[data-id='dialogMessageText']");
    private By soResponseOption = By.xpath("//select[@aria-label='SO Response']");
    private By reworkCommentsBox = By.xpath("//textarea[@id='reworkComments']");

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
    private By acceptWOBtn = By.xpath("//button[@aria-label='Accept WO']");
    private By approveWOBtn = By.cssSelector("button[aria-label='Approve WO']");

    private By startTimeCol = By.xpath("//div[text()='Start Time']");
    private By NewToOldCol = By.xpath("//span[text()='Sort newer to older']");
    private By oldToNewCol = By.xpath("//span[text()='Sort older to newer']");

    // Rectification- Form SG Submission
    private By rectificationDueDate = By.xpath("//input[@aria-label='Date of Rectification Due Date']/following-sibling::i[@data-icon-name='Calendar']");
    private By rectificationRequired = By.xpath("//button[@aria-label='Rectification Required: No']");
    private By rectificationConfirmation = By.cssSelector("h1[aria-label='Rectification Confirmation']");
    private By okBtn = By.xpath("//button[@aria-label='OK']");
    private By newFormSG = By.cssSelector("button[aria-label='New Form SG. Add New Form SG']");
    private By caseId = By.cssSelector("input[aria-label='Case ID, Lookup']");
    private By rectificationSubmissionStatus = By.xpath("//div[@col-id='pub_rectificationstatus' and @role='gridcell']//div[@role='none']");
    private By rectificationRequiredAfterSubmission = By.xpath("//button[contains(@aria-label,'Rectification Required')]/following-sibling::label[contains(@for,'Toggle')]");
    private By rectificationDocumentVerified = By.cssSelector("select[aria-label='Rectification Documents Verified']");
    private By rectificationTab = By.cssSelector("li[aria-label='Rectification']");
    private By commentOnSIES = By.cssSelector("textarea[aria-label='Approve / Reject Reason. Recommended.']");
    private By sendEmailButton = By.cssSelector("button[aria-label='Send Email']");
    private By rectificationDueDateValidation = By.xpath("//span[text()='Rectification Due Date: Required fields must be filled in.']");
    private By rectificationValidationOkButton = By.cssSelector("button[data-id='okButton']");
    private By rectificationRequiredCWD4 = By.xpath("//select[@aria-label='Rectification Required']/ancestor::div[2]");
    private By rectificationEmailSent = By.xpath("//button[contains(@aria-label,'Rectification Email Sent')]/following-sibling::label[contains(@for,'Toggle')]");

    // WRN6IMB Locators
    private By typeOfWO = By.xpath("//div[@aria-rowindex='2']//div[@col-id='pub_workordertype']//label");

    // Locators for deviation remarks
    private By systemAssesmentval = By.xpath("//select[@aria-label='User Assessment']");
    private By deviationRemarks = By.xpath("//input[@aria-label='Deviation Remarks']");

    // Locators for verify new case is created?
    private By caseNumber = By.xpath("(//div[@col-id='statuscode' and @role='gridcell']//span)[1]");
    //private By caseStatus = By.xpath("(//div[@col-id='statecode']//label)[2]");
    private By caseStatus = By.xpath("//div[text()='Status'] /parent::div/div/div");

    // Locators for WRN4
    private By noOfWOs = By.xpath("//div[contains(@data-id,'WorkOrders-pcf_grid')]//span[contains(@class,'statusContainer')]");

    private By caseStatusReasonGridHeader = By.xpath("//div[@role='columnheader' and @col-id='msdyn_systemstatus']");

    // CWD5 Related Locators
    private By generatePermitLetter = By.cssSelector("h1[aria-label='Generate Permit Letter.']");
    private By yesButton = By.cssSelector("button[aria-label='Yes']");
    private By acknowledgmentConfirmation = By.cssSelector("h1[aria-label='Acknowledgment Confirmation']");
    private By createReInspectionButton = By.cssSelector("button[aria-label='CREATE REINSPECTION']");
    private By createWOForReInspectionProcessing = By.xpath("//span[contains(@aria-label,'Creating Work Order for Re-inspection')]");
    private By createReInspectionPopup = By.cssSelector("h1[aria-label='Create Reinspection']");
    private By proposedInspectionDate = By.cssSelector("input[id='pub_wr_date']");
    private By createButton = By.cssSelector("button[id='pub_wr_create']");
    private By resultDialog = By.cssSelector("h1[aria-label='Result Dialog']");
    private By okButton = By.cssSelector("button[aria-label='OK']");
    private By confirmDialog = By.cssSelector("h1[aria-label='Confirm']");

    // WRN10-NMB Locators
    private By generateIONIOLetter = By.cssSelector("button[aria-label='Generate IO/NIO Letter']");
    private By generateIONIOLetterPopUp = By.cssSelector("h1[aria-label='Generate IO/NIO Letter']");
    private By okayButton = By.cssSelector("button[aria-label='Okay']");
    private By commissioningLetterDate = By.xpath("//input[@aria-label='Date of Commissioning Letter issued date']/following-sibling::i[@data-icon-name='Calendar']");

    public By getOkBtn() {
        return okBtn;
    }

    public By getApproveWOBtn() {
        return approveWOBtn;
    }

    public By getRejectWOBtn() {
        return rejectWOBtn;
    }

    public By getAllDocsReceived() {
        return allDocsReceived;
    }

    public By getGenerateDraftEventPermit() {
        return generateDraftEventPermit;
    }

    public By getApplicationDetailsReviewed() {
        return applicationDetailsReviewed;
    }

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

    public By getEntityLookupField() {
        return entityLookupField;
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

    public By getGeneratePermitLetter() {
        return generatePermitLetter;
    }

    public By getAcknowledgmentConfirmation() {
        return acknowledgmentConfirmation;
    }

    public By getResultDialog() {
        return resultDialog;
    }

    public By getConfirmDialog() {
        return confirmDialog;
    }

    public By getYesButton() {
        return yesButton;
    }

    public By getOkButton() {
        return okButton;
    }

    public By getCaseRemarksField() {
        return caseRemarksField;
    }

    public By getSubmitSOReviewBtn() {
        return submitSOReviewBtn;
    }

    public By getInspectionCompletedOption() {
        return inspectionCompletedOption;
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
        eleUtil.doClearUsingKeysWithWait(getWRPCatchment(), 30);
        eleUtil.doSendKeysWithWaitEnter(getWRPCatchment(), wrpCatchment, 30);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
        eleUtil.waitForVisibilityOfElement(getIssueReported(), 30);
        eleUtil.doClearUsingKeysWithWait(getIssueReported(), 30);
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

    public void selectCasesListView(String listView) {
        eleUtil.waitForVisibilityOfElement(listViewOfCases, 100);
        eleUtil.doClickLog(listViewOfCases, "Click on list view of Cases");
        eleUtil.waitForVisibilityOfElement(factory.getSearchResults(), 100);
        eleUtil.doSendKeysLog(factory.getSearchResults(), listView, "Enter List View Name");
        By selectView = By.xpath("//label[text()='" + listView + "']");
        eleUtil.waitForVisibilityOfElement(selectView, 20);
        eleUtil.doClickLog(selectView, "click on Cases View");
    }

    public int workOrderCount() {
        eleUtil.waitForVisibilityOfElement(getWorkOrderCount(), 40);
        String workOrder = eleUtil.doElementGetText(getWorkOrderCount());
        Log.info("print work order " + workOrder);
        Log.info("After extract " + eleUtil.extractLastValue(workOrder));
        return eleUtil.extractLastValue(workOrder);
    }

    public void childCaseVerification(String childCaseRefNumber) throws InterruptedException {
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(crmActions.getNoDataAvailableInSingleGrid(), "No data available")) {
                Thread.sleep(3000);
                eleUtil.doClickLog(childCaseRefresh, "Click on Child Case Refresh button");
            } else {
                // If the element is not displayed, execute the else block logic
                try {
                    commonCRMActions.childCaseNumber = factoryPage.getCaseNumber();
                    assertTrue(commonCRMActions.childCaseNumber.startsWith(childCaseRefNumber), "Case number format is not expected");
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
        //crmActions.resetFirstRunFlag();
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
        clickOnSaveNCloseBtn();
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
        clickOnSaveButton();
        navigatingToStage("Close");
        eleUtil.waitForVisibilityOfElement(getResolveCaseOption(), 10);
        eleUtil.selectDropDownValue(getResolveCaseOption(), "selectByVisibleText", resolveCase, "Select " + resolveCase + " in Resolve Case");
        eleUtil.isPageLoaded(50);
        if (eleUtil.elementIsDisplayed(warningRecurrence, "Saving in Progress Pop Up")) {
            eleUtil.waitForVisibilityOfElement(warningRecurrence, 30);
        } else {
            clickOnSaveButton();
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
        eleUtil.doClickLog(clickGenerateLetter(), "Click on Generate Letter on Cases");
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

    public void manualWOCreation(String workOrderType) {
        eleUtil.waitForVisibilityOfElement(getNewWorkOrder(), 10);
        eleUtil.doClickLog(getNewWorkOrder(), "Click on New Work Order button");
        eleUtil.waitForVisibilityOfElement(getWOType(), 30);
        eleUtil.selectDropDownValue(getWOType(), "selectByVisibleText", workOrderType, "Select "  + workOrderType + " in WO Type");
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
        crmActions.clickOnSavingInProgressOkButton();
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
        String WOTypeVal = eleUtil.doGetElementAttributeLog(typeOfWO, "aria-label", "Selected WO type field value is : ");
        if (WOTypeVal.equals("Recurring Inspection")) {
            Log.info("Recurring Work order got created");
        } else {
            Log.info("Recurring Work order not getting created");
        }
    }

    public void clickOnRejectWOBtn() {
        eleUtil.waitForVisibilityOfElement(getRejectWOBtn(), 40);
        eleUtil.doClickLog(getRejectWOBtn(), "Click on Reject WO button");
    }

    public void clickOnApproveWOBtn() {
        eleUtil.waitForVisibilityOfElement(getApproveWOBtn(), 40);
        eleUtil.doClickLog(getApproveWOBtn(), "Click on Approve WO button");
    }

    public void clickOnOkButton() {
        eleUtil.waitForVisibilityOfElement(getOkButton(), 40);
        eleUtil.doClickLog(getOkButton(), "Click on OK button");
    }

    public void enterRemarks() {
        eleUtil.waitTillElementIsDisplayed(remarksField, 30);
        eleUtil.doClickLog(remarksField, "Clicked on SO Remarks field");
        eleUtil.doClearUsingKeysLog(remarksField, "Clear the SO Remarks field");
        eleUtil.doSendKeysLog(remarksField, "546", "Passing value to SO Remarks field");
    }

    public void clickOnAcceptWOBtn() {
        eleUtil.waitForVisibilityOfElement(acceptWOBtn, 40);
        eleUtil.doClickLog(acceptWOBtn, "Click on Approve WO button");
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
            clickOnAcceptWOBtn();
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
        clickOnSaveNCloseBtn();
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
        String caseNo = eleUtil.doElementGetTextLog(caseNumber, "case number is : ");
        String Status = eleUtil.doElementGetTextLog(caseStatus, "Status reason is : ");
        if (caseNo.contains("IMB/RP/I") && Status.equals("Active")) {
            Log.info("New case got created");
        } else {
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
        clickOnSaveNCloseBtn();
    }

    public String getTheNoOfWOs() {
        eleUtil.waitForVisibilityOfElement(noOfWOs, 50);
        String totalWOs = eleUtil.doElementGetTextLog(noOfWOs, "Text in the application is : ");
        String totalcount = totalWOs.substring(9, 10);
        Log.info("Total Number of WOs created is :" + totalcount);
        return totalcount;
    }

    public void caseCreationForPumpingMain(String caseSubType) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(getCaseSubType(), 30);
        eleUtil.selectDropDownValue(getCaseSubType(), "selectByVisibleText", caseSubType, "select Case sub type " + caseSubType);
        eleUtil.scrollDownTillElementVisible(getCaseRemarksField());
        eleUtil.doClearUsingKeysLog(getCaseRemarksField(), "Clear Remarks field");
        eleUtil.doSendKeysLog(getCaseRemarksField(), caseSubType + " Case", "send any value for remarks field");
    }

    public void waitForCaseFormToSaveNGetCaseNumber() {
        crmActions.waitForRecordFormPageToSaved();
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

    public void soReviewForWRN10IMBDLPPumping(String soValue) {
        try {
            navigatingToStage("SO Review");
            eleUtil.waitForVisibilityOfElement(soResponseOption, 10);
            eleUtil.selectDropDownValue(soResponseOption, "selectByVisibleText", soValue, "Select " + soValue + " SO Response");
            if ("Reject".equals(soValue)) {
                eleUtil.waitForFrameByIDOrName("FullPageWebResource", 30);
                eleUtil.doSendKeys(reworkCommentsBox, "Rework comments by SO");
                eleUtil.doClick(submitBtn);
                eleUtil.switchToDefaultContent();
                clickSaveNContinueBtn();
            }
            waitForRecordFormPageToSaved();
            eleUtil.waitForVisibilityOfElement(crmActions.getSaveBtn(), 100);
            eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
        } catch (Exception e) {
            System.err.println("An error occurred during SO Review: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void soReviewForWRN10IMBAbandonmentCase() throws InterruptedException {
        navigatingToStage("SO Review");
        clickOnNextStageBtn();
        crmActions.clickOnSavingInProgressOkButton();
        eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
    }

    public void caseStatusFilter(String status) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(caseStatusReasonGridHeader, 100);
        Thread.sleep(3000);
        attemptsDifferentClicks(caseStatusReasonGridHeader);
        filterViewForStatus(status);
        eleUtil.isPageLoaded(30);
        Thread.sleep(2000);
    }

    // Click on More button to verify the Case creation
    public void validateCaseCreationWithMoreButton(String caseRefNumber) throws InterruptedException {
        eleUtil.waitTillElementIsDisplayed(clickMoreCommandButton(), 30);
        eleUtil.doClickLog(clickMoreCommandButton(), "Clicked on case grid refresh button");
        eleUtil.waitTillElementIsDisplayed(crmActions.getWorkOrderGridRefresh(), 30);
        eleUtil.doClickLog(crmActions.getWorkOrderGridRefresh(), "Clicked on case grid refresh button");
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(factory.getCheckCaseCreated(), "No data available")) {
                Thread.sleep(3000);
                eleUtil.doClickLog(crmActions.getWorkOrderGridRefresh(), "Case is not created, click on case grid refresh button");
            } else {
                // If the element is not displayed, execute the else block logic
                try {
                    commonActionsPage.casenumber = factory.getCaseNumber();
                    assertTrue(commonActionsPage.casenumber.startsWith(caseRefNumber),
                            "Case number format is not expected");
                    Log.info(commonActionsPage.casenumber);
                    return; // Exit the method if the case number is verified
                } catch (NoSuchElementException e) {
                    Log.error("Case number element not found: " + e.getMessage());
                }
            }
        }
    }

    public void confirmDocumentsReceived() {
        eleUtil.waitForVisibilityOfElementLog(getAllDocsReceived(), 30, "Waiting for the All Documents Received element");
        eleUtil.selectDropDownValue(getAllDocsReceived(), "selectByVisibleText", "Yes", "Selected dropdown value is :");
    }

    public void confirmGenerateDraftEventPermit() {
        eleUtil.doElementClickableLog(getGenerateDraftEventPermit(), 50, "Waiting for the Generate Draft Event Permit");
        eleUtil.selectDropDownValue(getGenerateDraftEventPermit(), "selectByVisibleText", "Yes", "select Yes for Generate Draft Event Permit");
    }

    public void confirmApplicationDetailsReviewed() {
        eleUtil.waitForVisibilityOfElementLog(getApplicationDetailsReviewed(), 30, "Waiting for the Application Details Reviewed");
        eleUtil.selectDropDownValue(getApplicationDetailsReviewed(), "selectByVisibleText", "Yes", "select Yes Application Details Reviewed");
    }

    public void clickOnGeneratePermitLetterYesButton() {
        eleUtil.isPageLoaded(100);
        eleUtil.waitForVisibilityOfElement(getGeneratePermitLetter(), 50);
        eleUtil.waitForVisibilityOfElement(getYesButton(), 30);
        eleUtil.doClickLog(getYesButton(), "Click on Yes button on Generate Permit Letter");
    }

    public String getWarningMessageOnCase() {
        eleUtil.waitForVisibilityOfElement(warningMessageOnCase, 30);
        String record = eleUtil.doElementGetText(warningMessageOnCase);
        return record;
    }

    public String getCaseStatus() {
        eleUtil.waitForVisibilityOfElement(caseStatus, 30);
        String status = eleUtil.doElementGetText(caseStatus);
        return status;
    }

    public void checkCaseStatus(String status) {
        eleUtil.waitForVisibilityOfElementLog(crmActions.getRefreshBtn(), 30, "wait for Refresh button");
        eleUtil.doClickLog(crmActions.getRefreshBtn(), "Click on Refresh button");
        String recordStatus = "Read-only This record’s status: Resolved";
        Assert.assertEquals(getWarningMessageOnCase(), recordStatus, "Status not matched");
        Assert.assertEquals(getCaseStatus(), status, "Status not matched");
    }

    public void eventPermitWarningMessage(String warningMessage) {
        Assert.assertEquals(getWarningMessageOnCase(), warningMessage, "Message not matched");
    }

    public void rectificationDueDate() throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(rectificationDueDate, 40);
        eleUtil.doClickLog(rectificationDueDate, "Click on Calendar Icon");
        eleUtil.waitForVisibilityOfElement(crmActions.getSelectTodayDateAndTime(), 30);
        eleUtil.doClickLog(crmActions.getSelectTodayDateAndTime(), "Select today's date");
        // Loop to handle the pop-up if it appears multiple times
        while (eleUtil.elementIsDisplayed(rectificationDueDateValidation, "Rectification Due Date Validation pop-up is displayed")) {
            eleUtil.doClickLog(rectificationValidationOkButton, "Click on Ok button");
            clickOnRefreshBtn();
            navigatingToTab("FormSG Submission");
            eleUtil.doClickLog(rectificationDueDate, "Click on Calendar Icon");
            eleUtil.waitForVisibilityOfElement(crmActions.getSelectTodayDateAndTime(), 30);
            eleUtil.doClickLog(crmActions.getSelectTodayDateAndTime(), "Select today's date again");
        }
    }

    public void rectificationRequired() {
        eleUtil.waitForVisibilityOfElement(rectificationRequired, 40);
        eleUtil.doClickLog(rectificationRequired, "Click on Rectification Required");
        eleUtil.isPageLoaded(100);
        eleUtil.waitForVisibilityOfElement(rectificationConfirmation, 50);
        eleUtil.waitForVisibilityOfElement(getYesButton(), 30);
        eleUtil.doClickLog(getYesButton(), "Click on Yes button on Rectification Confirmation");
        eleUtil.waitForVisibilityOfElement(getOkBtn(), 10);
        eleUtil.doClickLog(getOkBtn(), "Click on ok button");
    }

    public void newFormSG() {
        eleUtil.waitForVisibilityOfElement(newFormSG, 50);
        eleUtil.doClickLog(newFormSG, "Click on New Form SG button");
        clickOnSaveBtn();
        waitForRecordFormPageToSaved();
        eleUtil.waitForVisibilityOfElement(rectificationTab, 40);
        eleUtil.doClickLog(rectificationTab, "click on Rectification tab");
        eleUtil.waitForVisibilityOfElement(commentOnSIES, 40);
        eleUtil.doSendKeysLog(commentOnSIES, "Rectification test", "Enter value in SIES");
        clickOnSaveBtn();
        waitForRecordFormPageToSaved();
    }

    public void formSGApproveAndReject(String buttonName) {
        By button = By.cssSelector("button[aria-label='" + buttonName + "']");
        eleUtil.waitForVisibilityOfElement(button, 40);
        eleUtil.doClickLog(button, "Click on " + buttonName + " button");
        if ("Reject".equals(buttonName)) {
            eleUtil.waitForVisibilityOfElement(sendEmailButton, 40);
            eleUtil.doClickLog(sendEmailButton, "click on Send Email Button");
            clickOnSaveNCloseBtn();
        }
    }

    public String getRectificationSubmissionStatus() {
        eleUtil.waitForVisibilityOfElement(rectificationSubmissionStatus, 30);
        String status = eleUtil.doElementGetText(rectificationSubmissionStatus);
        return status;
    }

    public void verifyRectificationSubmissionStatus(String rectificationStatus) throws InterruptedException {
        crmActions.formSGStatusFilter(rectificationStatus);
        Assert.assertEquals(getRectificationSubmissionStatus(), rectificationStatus, "Status not matched");
    }

    public String getRectificationRequiredAfterSubmission() {
        eleUtil.waitForVisibilityOfElement(rectificationRequiredAfterSubmission, 30);
        String value = eleUtil.doElementGetText(rectificationRequiredAfterSubmission);
        return value;
    }

    public void verifyRectificationDetails(String rectificationDocuments, String rectificationRequired) {
        eleUtil.textVerificationFormAttribute(rectificationDocumentVerified, "title", rectificationDocuments);
        Assert.assertEquals(getRectificationRequiredAfterSubmission(), rectificationRequired, "Rectification Required not matched");
    }

    public void clickOnAcknowledgmentConfirmationYesButton() throws InterruptedException {
        Thread.sleep(3000);
        if (eleUtil.elementIsDisplayed(getAcknowledgmentConfirmation(), "Rectification Due Date Validation pop-up is displayed")) {
            eleUtil.waitForVisibilityOfElement(getAcknowledgmentConfirmation(), 50);
            eleUtil.waitForVisibilityOfElement(getYesButton(), 30);
            eleUtil.doClickLog(getYesButton(), "Click on Yes button on Generate Permit Letter");
        }
    }

    public void openWorkOrder(String checkListName) throws InterruptedException {
        crmActions.workOrderIncidentTypeFilter(checkListName);
        Thread.sleep(3000);
        selectFirstRecord();
        getFirstRecord();
    }

    public void clickReInspectionButton() {
        eleUtil.waitTillElementIsDisplayed(createReInspectionButton, 30);
        eleUtil.doClickLog(createReInspectionButton, "Clicked on work order grid refresh button");
    }

    public void waitForReInspectionWorkOrderCreated() {
        eleUtil.waitForInVisibilityOfElement(createWOForReInspectionProcessing, 50);
    }

    public void createReInspection() {
        eleUtil.waitForVisibilityOfElement(createReInspectionPopup, 30);
        driver.switchTo().frame("FullPageWebResource");
        eleUtil.doSendKeysLog(proposedInspectionDate, eleUtil.todayDate("MM/dd/yyyy"), "Enter Today Date " + eleUtil.todayDate("MM/dd/yyyy"));
        eleUtil.waitForVisibilityOfElement(createButton, 30);
        eleUtil.doClickLog(createButton, "click on Create button");
        driver.switchTo().defaultContent();
        eleUtil.waitForInVisibilityOfElement(createReInspectionPopup, 100);
    }

    public void clickOnResultDialogOkButton() {
        eleUtil.isPageLoaded(100);
        eleUtil.waitForVisibilityOfElement(getResultDialog(), 50);
        eleUtil.waitForVisibilityOfElement(getOkButton(), 40);
        eleUtil.doClickLog(getOkButton(), "Click on OK button");
    }

    public void selectEntityOnCase(String entityValue) {
        eleUtil.waitForVisibilityOfElement(getEntityLookupField(), 30);
        eleUtil.doClearUsingKeysLog(getEntityLookupField(), "clear Entity Values");
        eleUtil.doSendKeysLog(getEntityLookupField(), entityValue, "Enter Entity value " + entityValue);
        eleUtil.waitTillElementIsDisplayed(factory.setLookUp(), 50);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
    }

    public void enterCaseSubType(String caseSubType){
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(getCaseSubType(), 30);
        eleUtil.selectDropDownValue(getCaseSubType(), "selectByVisibleText", caseSubType, "select Case sub type " + caseSubType);
    }

    public void enterCaseType(String caseType) {
        eleUtil.waitForInVisibilityOfElement(getCaseType(), 30);
        eleUtil.selectDropDownValue(getCaseType(), "selectByVisibleText", caseType, "select Case sub type " + caseSubType);
    }

    public String getRectificationEmailSent() {
        eleUtil.waitForVisibilityOfElement(rectificationEmailSent, 30);
        String value = eleUtil.doElementGetText(rectificationEmailSent);
        return value;
    }

    public void verifyRectificationDetailsCWD4(String rectificationEmailSent, String rectificationRequired) {
        eleUtil.textVerificationFormAttribute(rectificationRequiredCWD4, "title", rectificationRequired);
        Assert.assertEquals(getRectificationEmailSent(), rectificationEmailSent, "Rectification Email Sent not matched");
    }

    public void newFormSGWithCase() {
        eleUtil.waitForVisibilityOfElement(newFormSG, 50);
        eleUtil.doClickLog(newFormSG, "Click on New Form SG button");
        eleUtil.waitForVisibilityOfElement(caseId, 30);
        eleUtil.doClearUsingKeysLog(caseId, "clear Entity Values");
        eleUtil.doSendKeysLog(caseId, commonActionsPage.casenumber, "Enter Entity value " + commonActionsPage.casenumber);
        //eleUtil.doSendKeysLog(caseId, "IFA/PE/I/2025/538", "Enter Entity value " + "IFA/PE/I/2025/538");
        eleUtil.waitTillElementIsDisplayed(factory.setLookUp(), 50);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
        clickOnSaveBtn();
        waitForRecordFormPageToSaved();
        eleUtil.waitForVisibilityOfElement(rectificationTab, 40);
        eleUtil.doClickLog(rectificationTab, "click on Rectification tab");
        eleUtil.waitForVisibilityOfElement(commentOnSIES, 40);
        eleUtil.doSendKeysLog(commentOnSIES, "Rectification test", "Enter value in SIES");
        clickOnSaveBtn();
        waitForRecordFormPageToSaved();
    }

    public void soReviewForCWD3N6() {
        navigatingToStage("SO Review");
        eleUtil.selectDropDownValue(approveAndResolveCase, "selectByVisibleText", "Yes", "Select Yes in Approve and Resolve Case");
        eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
        navigatingToStage("SO Review");
        clickOnNextStageBtn();
    }

    public void completedInspectionWithSOReview() {
        navigatingToStage("Inspection");
        eleUtil.waitForVisibilityOfElement(getInspectionCompletedOption(), 10);
        eleUtil.createSelect(getInspectionCompletedOption());
        eleUtil.doSelectDropDownByVisibleText(getInspectionCompletedOption(), "Yes");
        eleUtil.waitForVisibilityOfElement(getSubmitSOReviewBtn(), 10);
        eleUtil.createSelect(getSubmitSOReviewBtn());
        eleUtil.doSelectDropDownByVisibleText(getSubmitSOReviewBtn(), "Yes");
        eleUtil.doClickLog(crmActions.getSaveBtn(), "Click on Save button");
        eleUtil.isPageLoaded(10);
        navigatingToStage("Inspection");
        clickOnNextStageBtn();
    }

    public void completedGenerateEmailWithMnCLetter() {
        navigatingToStage("Generate Email");
        eleUtil.waitForVisibilityOfElement(emailSentToCustomer, 10);
        if (eleUtil.doElementGetText(emailSentToCustomer).equals("No")) {
            eleUtil.doClickLog(emailSentToCustomer, "Toggle as Yes");
        } else {
            Log.info("already value selected as Yes");
        }
        if (eleUtil.doElementGetText(sendMnCLetter).equals("No")) {
            eleUtil.doClickLog(sendMnCLetter, "Toggle as Yes");
        } else {
            Log.info("This field is not available in this BPF");
        }
        clickOnSaveBtn();
        clickOnRefreshBtnOnHome();
        navigatingToStage("Generate Email");
        clickOnNextStageBtn();
    }

    public void generateIONIOLetter() {
        eleUtil.waitForVisibilityOfElement(generateIONIOLetter, 10);
        eleUtil.doClickLog(generateIONIOLetter, "Click on Generate IO/NIO Letter");
    }

    public void clickOnGenerateIONIOLetterOkayButton() {
        eleUtil.isPageLoaded(100);
        eleUtil.waitForVisibilityOfElement(generateIONIOLetterPopUp, 50);
        eleUtil.waitForVisibilityOfElement(okayButton, 40);
        eleUtil.doClickLog(okayButton, "Click on Okay button");
    }

    public void selectCommissioningLetterIssuedDate() {
        eleUtil.waitForVisibilityOfElement(commissioningLetterDate, 40);
        eleUtil.doClickLog(commissioningLetterDate, "Click on Calendar Icon");
        eleUtil.waitForVisibilityOfElement(crmActions.getSelectTodayDateAndTime(), 30);
        eleUtil.doClickLog(crmActions.getSelectTodayDateAndTime(), "Select today's date");
    }
}

