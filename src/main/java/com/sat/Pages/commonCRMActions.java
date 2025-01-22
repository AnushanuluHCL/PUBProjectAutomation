package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.sat.constants.AppConstants;
import com.sat.testUtil.Log;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class commonCRMActions extends commonActionsPage {


    public commonCRMActions(WebDriver driver) {
        super(driver);
    }

    ThreadLocal<Boolean> isFirstRun = ThreadLocal.withInitial(() -> Boolean.TRUE);

    private static By refreshBtn = By.xpath("//button[@aria-label='Refresh']");
    private By notificationIcon = By.xpath("//button[@aria-label='Notifications']");
    private static By cancelBtn = By.xpath("//button[@title='Close']");
    private static By pageTitle = By.cssSelector("h1[data-id='header_title']");
    private By workOrderText = By.xpath("//input[@aria-label='Work Order Number']");
    private By notificationSection = By.xpath("//div[contains(@class,'ms-Panel-main main')]");
    private By timelineRefresh = By.cssSelector("button[title='Refresh timeline']");

    // Locators on WorkOrder tab
    private By saveNContinueBtn = By.cssSelector("button[aria-label='Save and continue']");
    private By discardChangesBtn = By.cssSelector("button[aria-label='Discard changes']");
    private By durationFieldOnBooking = By.xpath("//input[@aria-label='Duration']");

    // Locators on work order form
    private By bookingTab = By.xpath("//li[text()='Bookings']");
    private By checklistTab = By.cssSelector("li[aria-label='Checklist']");
    private By emptyUserAssessment = By.xpath("//select[@aria-label='User Assessment' and @title='---']");
    private By emptySystemAssessment = By
            .xpath("//div[@data-id='pub_systemassessment'] //select[@aria-label='System Assessment' and @title='---']");
    private By userAssessment = By.cssSelector("select[aria-label='User Assessment']");
    private By systemAssessment = By
            .xpath("//div[@data-id='pub_systemassessment'] //select[@aria-label='System Assessment']");
    private By formSGStatusGridHeader = By.cssSelector("div[data-testid='pub_rectificationstatus']");
    private By moreButtonOnFormSG = By.cssSelector("button[aria-label='More commands for Form SG']");

    // Locators on Bookings home page
    private By checkListNameField = By.xpath("//div[@col-id='msdyn_name']/descendant::a");
    private By maximizeScreenBtn = By.xpath("//button[@aria-label='Enter full screen mode']");
    private By bookingStatusField = By
            .xpath("//div[@class='ms-Dropdown-container'] //div[contains(@data-id,'BookingStatusControl')]");
    private By saveNCloseOnBooking = By
            .xpath("//span[text()='Save and close this Bookable Resource Booking.']/preceding-sibling::button");
    private By workOrderForm = By.cssSelector("ul[aria-label='Work Order Form']");
    private By bookingSavedStatus = By.xpath("//span[text()='Bookable Resource Booking']/ancestor::div[contains(@class, 'flexbox')]//span[@aria-label='Save status - Saved']");
    private By saveOnBooking = By
            .xpath("//button[contains(@title,'Save this Bookable Resource Booking.')]");
    private By unsavedChangesPopup = By.cssSelector("h1[title='Unsaved changes']");
    private By loadingWithSaving = By.xpath("//span[text()='Saving...']");
    private By notesTab = By.xpath("//li[@aria-label='Notes']");
    private By signature_box = By.xpath("//div[contains(@data-id,'msdyn_signature')]//canvas");
    private By confirmBtn = By.xpath("//span[text()='Confirm']");
    private By nameOfAssignee = By.xpath("//input[contains(@data-id,'pub_nameofsignee')]");

    private By markCompleteBtn = By.xpath("//button[contains(@title,'Set Task as fully completed')]");
    private By saveBtnInChklist = By.xpath("//button[contains(@title,'Save this Work Order Service Task.')]");
    private By saveNCloseBtnInChklist = By
            .xpath("//button[contains(@title,'Save and close this Work Order Service Task.')]");
    private By saveBtn = By.xpath("//button[@aria-label='Save (CTRL+S)']");
    private By emailRefreshButton = By.xpath("//button[contains(@id,'email') and @aria-label='Refresh']");
    private By moreButtonEmail = By.cssSelector("button[aria-label='More commands for Email']");
    private By documentRefreshButton = By.xpath("//button[contains(@id,'document') and @aria-label='Refresh']");
    private By moreButtonDocument = By.cssSelector("button[aria-label='More commands for SIES Document']");
    private By workOrderStatusGridHeader = By.xpath("//div[@role='columnheader' and @col-id='msdyn_systemstatus']");
    private By bookingStatusGridHeader = By.xpath("//div[@role='columnheader' and @col-id='bookingstatus']");
    private By workOrderIncidentTypeGridHeader = By.xpath("//div[@role='columnheader' and @col-id='msdyn_primaryincidenttype']");
    private By workOrderTypeGridHeader = By.xpath("//div[@role='columnheader' and @col-id='pub_workordertype']");
    private By moreButtonOnWorkOrder = By.cssSelector("button[aria-label='More commands for Work Order']");
    private By workOrderGridRefresh = By.xpath("//ul[@data-id='OverflowFlyout'] //button[@aria-label='Refresh']");
    private By nextButtonOnWorkOrder = By
            .xpath("//div[contains(@id,'WorkOrders')] //button[@aria-label='Next page']");
    private By searchBox = By.cssSelector("input[placeholder='Filter by keyword']");
    private By noRecord = By.xpath("//div[contains(text(),'anything to show here')]");
    private By noDataAvailableInSingleGrid = By.xpath("//span[text()='No data available']");
    private By acknowledgeButton = By.cssSelector("button[aria-label='Acknowledge']");
    private By clickOnProposedInspectionDateCalender = By
            .xpath("//div[contains(@data-id,'pub_proposedinspectiondate.fieldControl.')] //input[@role='combobox']");
    private By saveAndCloseWOAcknowledgePopup = By
            .xpath("//div[contains(@id,'dialogPageContainer')] //button[@aria-label='Save & Close']");
    private By selectTodayDateAndTime = By.cssSelector("td[aria-selected='true']");

    // Locators on Bookings tab
    private By WOstatusInWOform = By.xpath(
            "//select[@aria-label='WO Status']//ancestor::div[@data-lp-id='MscrmControls.FieldControls.OptionSet|msdyn_systemstatus.fieldControl|msdyn_workorder']//select");
    private By checkBOCreated = By
            .xpath("//div[@data-id='bookings-pcf_grid_control_container'] //span[text()='No data available']");
    private By moreCommandButtonForBooking = By
            .xpath("button[aria-label='More commands for Bookable Resource Booking']");
    private By bookingRefreshButton = By
            .xpath("//button[contains(@id,'bookableresourcebooking') and @aria-label='Refresh']");
    private By startTimeCol = By.xpath("//div[text()='Start Time']");
    private By NewToOldCol = By.xpath("//span[text()='Sort newer to older']");
    private By oldToNewCol = By.xpath("//span[text()='Sort older to newer']");
    private By bookingSsatusGridHeader = By.xpath("//div[@role='columnheader' and @col-id='bookingstatus']");

    // Locators on case home page
    private By systemAssessmentField = By.xpath("//select[@aria-label='System Assessment']");

    // Locators on checklist page
    private By clearResponseBtn = By.xpath("//button[@aria-label='Clear Responses']");
    private By okBtn = By.xpath("//span[text()='OK']");
    private By checklistRefreshButton = By.xpath("//ul[@aria-label='Commands']//button[@aria-label='Refresh' and contains(@id,'workorderservicetask')]");

    //This code can be removed after Booking Issue is fixed
    private By bookingDuration = By.cssSelector("input[aria-label='Duration']");
    private By recordFormPageToSaved = By.cssSelector("span[aria-label='Save status - Saved']");
    private By checklistPageToSaved = By.cssSelector("//span[text()='Work Order Service Task']/ancestor::div[contains(@class, 'flexbox')]//span[@aria-label='Save status - Saved']");
    private By woStatusFilterSelected = By.xpath("//div[@aria-label='WO Status filtered by eq undefined']//i[@data-icon-name='FilterSolid']");
    private By savingInProgressPopUp = By.xpath("//div[contains(@id,'modalDialogContentContainer')]");
    private By savingInProgressOkButton = By.xpath("//span[contains(@id,'okButtonText')]");

    public By getWOStatusFilterSelected() {
        return woStatusFilterSelected;
    }

    public By getDiscardChangesBtn() {
        return discardChangesBtn;
    }

    public By getUserAssessment() {
        return userAssessment;
    }

    public By getSystemAssessment() {
        return systemAssessment;
    }

    public By getBookingTab() {
        return bookingTab;
    }

    public By getSearchBox() {
        return searchBox;
    }

    public By getNextButtonOnWorkOrder() {
        return nextButtonOnWorkOrder;
    }

    public By getSaveBtn() {
        return saveBtn;
    }

    public By getMoreButtonOnWorkOrder() {
        return moreButtonOnWorkOrder;
    }

    public By getWorkOrderGridRefresh() {
        return workOrderGridRefresh;
    }

    public By getChecklistTab() {
        return checklistTab;
    }

    public By getWorkOrderText() {
        return workOrderText;
    }

    public By getCheckListNameField() {
        return checkListNameField;
    }

    public By getMaximizeScreenBtn() {
        return maximizeScreenBtn;
    }

    public By getMarkCompleteBtn() {
        return markCompleteBtn;
    }

    public By getSaveBtnInChklist() {
        return saveBtnInChklist;
    }

    public By getSaveNCloseBtnInChklist() {
        return saveNCloseBtnInChklist;
    }

    public static By getRefreshBtn() {
        return refreshBtn;
    }

    public By getNotificationIcon() {
        return notificationIcon;
    }

    public static By getPageTitle() {
        return pageTitle;
    }

    public static By getCancelBtn() {
        return cancelBtn;
    }

    public By getNoRecord() {
        return noRecord;
    }

    public By getNoDataAvailableInSingleGrid() {
        return noDataAvailableInSingleGrid;
    }

    public By getAcknowledgeButton() {
        return acknowledgeButton;
    }

    public By getClickOnProposedInspectionDateCalender() {
        return clickOnProposedInspectionDateCalender;
    }

    public By getSaveAndCloseWOAcknowledgePopup() {
        return saveAndCloseWOAcknowledgePopup;
    }

    public By getSavingInProgressPopUp() {
        return savingInProgressPopUp;
    }

    /*public void resetFirstRunFlag() {
        isFirstRun.set(Boolean.TRUE);
    }*/

    public By getSelectTodayDateAndTime() {
        return selectTodayDateAndTime;
    }

    public By getMoreCommandButtonForBooking() {
        return moreCommandButtonForBooking;
    }

    public By getBookingRefreshButton() {
        return bookingRefreshButton;
    }

    public By getChecklistRefreshButton() {
        return checklistRefreshButton;
    }

    public void clickOnSaveButton() {
        eleUtil.waitTillElementIsDisplayed(getSaveBtn(), 30);
        eleUtil.doClickLog(getSaveBtn(), "Clicked on Save Button");
    }

    public static String setPageTitle() {
        eleUtil.waitForVisibilityOfElement(getPageTitle(), 100);
        String pageTitle = eleUtil.doGetElementAttribute(getPageTitle(), "title");
        return pageTitle;
    }

    public void notificationForTabToOpen(String text, String tab) throws InterruptedException {
        By notificationIDCheck = By.xpath("//p[contains(text(), '" + text + "')]");
        long endTime = System.currentTimeMillis() + 300000;
        while (System.currentTimeMillis() < endTime) {
            eleUtil.isPageLoaded(100);
            eleUtil.waitForVisibilityOfElement(getNotificationIcon(), 100);
            eleUtil.doClick(getNotificationIcon());
            Thread.sleep(3000);
            try {
                WebElement WOalert = eleUtil.waitForVisibilityOfElementLog(notificationIDCheck, 30, "Wait for the element");
                if (WOalert == null || !WOalert.isDisplayed()) {
                    eleUtil.scrollDownNotification(notificationSection);
                    WOalert = eleUtil.waitForVisibilityOfElementLog(notificationIDCheck, 30, "Wait for the element");
                    if (WOalert == null || !WOalert.isDisplayed()) {
                        eleUtil.doClickLog(getCancelBtn(), "Click on Cancel button");
                        eleUtil.doClickLog(getRefreshBtn(), "Click on Refresh button");
                        navigatingToTab(tab);
                        Log.error("Actual Case number is not matched with the open Case number");
                        continue; // Restart the while loop
                    }
                }
                // WOalert is found and displayed
                WebElement tapToOpenBtn = driver.findElement(By.xpath("//p[contains(text(), '" + text
                        + "')]/ancestor::div[contains(@class, 'ac-container')]//a[contains(text(),'Tap to')]"));
                tapToOpenBtn.click();
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                Log.info("open tabs: " + tabs.size());
                driver.switchTo().window(tabs.get(1));
                eleUtil.waitForVisibilityOfElement(getPageTitle(), 100);
                String afterTapToOpenBtn = setPageTitle();
                Log.info("afterTapToOpenBtn: " + afterTapToOpenBtn);
                assertTrue(afterTapToOpenBtn.contains(text),
                        "Record is not the same after clicking on tap to open button");
                clickOnSaveNCloseBtn();
                driver.switchTo().window(tabs.get(0));
                eleUtil.doClick(getCancelBtn());
                break;
            } catch (TimeoutException e) {
                Log.error("Timeout waiting for element: " + notificationIDCheck);
            }
        }
    }


    public void navigateToTabWithEntity(String tabName, String entityName) {
        By loc = By.xpath("//ul[@aria-label='" + entityName + " Form']//li[@aria-label='" + tabName + "']");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eleUtil.waitForVisibilityOfElement(loc, 20);
        WebElement tab = driver.findElement(loc);
        tab.click();
    }

    public void navigateToTab(String tabName) {
        By loc = By.xpath("//li[@aria-label='" + tabName + "']");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eleUtil.waitForVisibilityOfElement(loc, 20);
        WebElement tab = driver.findElement(loc);
        tab.click();
    }

    public void signTheChecklist() throws InterruptedException {
        // Below 2 steps need to be included once signature box is moved to checklist
        // selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
        // getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
        Thread.sleep(7000);
        eleUtil.waitForVisibilityOfElement(notesTab, 100);
        jsutil.clickElementByJS(driver.findElement(notesTab));
        eleUtil.doElementClickable(signature_box, 20);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(driver.findElement(signature_box), 135, 0).build().perform();
        eleUtil.doElementClickable(confirmBtn, 30);
        eleUtil.doClickLog(confirmBtn, "Click on Confirm button");
        eleUtil.waitForVisibilityOfElement(nameOfAssignee, 30);
        eleUtil.doSendKeysLog(nameOfAssignee, "FIO", "Enter Name of Assignee");
    }

    public List<String> getWONumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<WebElement> myList = driver.findElements(By.xpath("//div[@col-id='msdyn_name']//descendant::a"));
        List<String> all_elements_text = new ArrayList<>();
        for (int i = 1; i <= myList.size(); i++) {
            By ele2 = By.xpath("(//div[@col-id='msdyn_name']//descendant::a)[" + i + "]");
            String wonumlist = eleUtil.doGetElementAttribute(ele2, "aria-label");
            all_elements_text.add(wonumlist);
        }
        Log.info("List of work orders is :" + all_elements_text);
        return all_elements_text;
    }

    public void processWorkOrder(String woNumber, String status) throws InterruptedException {
        if (!eleUtil.elementIsDisplayed(getWOStatusFilterSelected(), "No data available")) {
            workOrderStatusFilter(status);
        }
        /*if (!isFirstRun.get()) {
            workOrderStatusFilter(status);
        } else {
            isFirstRun.set(Boolean.FALSE); // Set the flag to false after the first run
        }*/
        By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + woNumber + "']");
        eleUtil.waitForVisibilityOfElement(woele, 50);
        eleUtil.doActionsClick(woele);
        eleUtil.waitForVisibilityOfElement(getWorkOrderText(), 30);
        String actualWO = eleUtil.doGetElementAttribute(getWorkOrderText(), "value");
        Log.info("actual WO:" + actualWO);
        Log.info("expected wo:" + woNumber);
        assertTrue(actualWO.contains(woNumber), "WO is not same");
    }

    public void checkBookingsOrder() throws InterruptedException {
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(checkBOCreated, "No data available")) {
                Thread.sleep(3000);
                eleUtil.waitTillElementIsDisplayed(getBookingRefreshButton(), 30);
                eleUtil.doClickLog(getBookingRefreshButton(),
                        "Booking not created click on Booking grid refresh button");
            } else {
                // Exit the loop if data is available
                break;
            }
        }
    }

    public void fillBookingDetails(String status, String selectBookingStatus) throws InterruptedException {
        workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        String nextButton;
        // Store all WOs from the first page
        commonCRMActions.WOnumber = getWONumber();
        woNum.addAll(commonCRMActions.WOnumber);
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is: " + woNum.size());
        // Check if there is a next button and click it if enabled
        nextButton = eleUtil.doGetElementAttributeLog(getNextButtonOnWorkOrder(), "aria-disabled",
                "Check next button is true/false");
        while (nextButton.contains("false")) {
            eleUtil.doClickLog(getNextButtonOnWorkOrder(), "click on next button on Work Order");
            Thread.sleep(2000);
            // Store all WOs from the next page
            commonCRMActions.WOnumber = getWONumber();
            woNum.addAll(commonCRMActions.WOnumber);
            Log.info("print wo number " + woNum);
            Log.info("size is: " + woNum.size());
            // Check the next button status again
            nextButton = eleUtil.doGetElementAttributeLog(getNextButtonOnWorkOrder(), "aria-disabled",
                    "Check next button is true/false");
        }
        // Process all collected WOs
        for (int i = 0; i < woNum.size(); i++) {
            eleUtil.waitTillElementIsDisplayed(getMoreButtonOnWorkOrder(), 30);
            eleUtil.doClickLog(getMoreButtonOnWorkOrder(), "Clicked on work order grid refresh button");
            eleUtil.doClickLog(getWorkOrderGridRefresh(), "Work Order not created click on work order grid refresh button");
            Thread.sleep(4000);
            processWorkOrder(woNum.get(i), status);
            // Validation on Booking tab
            eleUtil.waitForVisibilityOfElement(getBookingTab(), 30);
            eleUtil.staleElementRefExecClickCRM(getBookingTab());
            eleUtil.doClick(getBookingTab());
            Thread.sleep(2000);
            checkBookingsOrder();
            bookingsStatusFilter(status);
            selectFirstRecord();
            getFirstRecord();
            //SIT1 code-Comment getMaximizeScreenBtn while running in SIT3
            //eleUtil.doElementClickable(getMaximizeScreenBtn(), 30);
            //eleUtil.doClick(getMaximizeScreenBtn());
            Thread.sleep(4000);
            eleUtil.waitForVisibilityOfElement(bookingStatusField, 100);
            attemptsDifferentClicks(bookingStatusField);
            By selectAnOption = By.cssSelector("button[title='" + selectBookingStatus + "']");
            eleUtil.doClickWithWait(selectAnOption, 40);
            //bookingIssue(); // This method can be removed once Booking issue is resolved
            if (status.equals("Scheduled")) {
                signTheChecklist();
            }
            Log.info("------Booking Saving Process Started-------");
            while (!eleUtil.elementIsDisplayed(bookingSavedStatus, "Booking is not in Saved status")) {
                try { // Comment the below code once this issue got resolved
                    Thread.sleep(2000);
                    if (eleUtil.elementIsDisplayed(unsavedChangesPopup, "Unsaved Changes popup")) {
                        eleUtil.waitForVisibilityOfElement(saveNContinueBtn, 30);
                        while (true) {
                            List<WebElement> saveNContinueButtons = driver.findElements(saveNContinueBtn);
                            if (saveNContinueButtons.isEmpty()) {
                                break;
                            }
                            for (WebElement button : saveNContinueButtons) {
                                try {
                                    button.click();
                                    Log.info("Popup Closed");
                                    // Refresh the list of elements after each click
                                    saveNContinueButtons = driver.findElements(saveNContinueBtn);
                                } catch (Exception e) {
                                    Log.error("Error clicking on Save and Continue button: {}" + e.getMessage());
                                }
                            }
                        }
                    } else {
                        eleUtil.doClickLog(saveOnBooking, "Click on Save button");
                        eleUtil.waitForInVisibilityOfElement(loadingWithSaving, 30);
                    }
                } catch (Exception e) {
                    Log.error("An unexpected error occurred");
                }
            }
            eleUtil.waitForVisibilityOfElement(saveNCloseOnBooking, 30);
            eleUtil.doClickLog(saveNCloseOnBooking, "Click on Save and Close button on Bookings page");
            eleUtil.waitForVisibilityOfElement(workOrderForm, 40);
            clickOnSaveNCloseBtn();
        }
        //resetFirstRunFlag();
    }

    public void multipleBookingFilling(String status, String selectBookingStatus) throws InterruptedException {
        workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        String nextButton;
        // Store all WOs from the first page
        commonCRMActions.WOnumber = getWONumber();
        woNum.addAll(commonCRMActions.WOnumber);
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is: " + woNum.size());
        // Check if there is a next button and click it if enabled
        nextButton = eleUtil.doGetElementAttributeLog(getNextButtonOnWorkOrder(), "aria-disabled",
                "Check next button is true/false");
        while (nextButton.contains("false")) {
            eleUtil.doClickLog(getNextButtonOnWorkOrder(), "click on next button on Work Order");
            Thread.sleep(2000);
            // Store all WOs from the next page
            commonCRMActions.WOnumber = getWONumber();
            woNum.addAll(commonCRMActions.WOnumber);
            Log.info("print wo number " + woNum);
            Log.info("size is: " + woNum.size());
            // Check the next button status again
            nextButton = eleUtil.doGetElementAttributeLog(getNextButtonOnWorkOrder(), "aria-disabled",
                    "Check next button is true/false");
        }
        // Process all collected WOs

        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            processWorkOrder(woNum.get(i), status);
            // Validation on Booking tab
            eleUtil.waitForVisibilityOfElement(getBookingTab(), 30);
            eleUtil.staleElementRefExecClickCRM(getBookingTab());
            eleUtil.doClick(getBookingTab());
            Thread.sleep(2000);
            By bookingRecord = By.xpath("//div[@col-id='resource' and @role='gridcell']/descendant::a");
            List<WebElement> bookingRecords = driver.findElements(bookingRecord);
            System.out.println("no of booking records" + bookingRecords.size());
            // Collecting all the bokking resource texts
            List<String> bookingRecordTexts = new LinkedList<>();
            for (WebElement record : bookingRecords) {
                String ariaLabel = record.getAttribute("aria-label");
                bookingRecordTexts.add(ariaLabel);
            }
            System.out.println("bookingRecordTexts is : " + bookingRecordTexts);

            // Click on each booking and sign the checklist
            for (int k = 0; k < bookingRecords.size(); k++) {
                int rowIndex = k + 2;
                String currEle = bookingRecordTexts.get(k);
                bookingRecordTexts.add(eleUtil.doGetElementAttribute(bookingRecord, "aria-label"));
                sortTheRecords(startTimeCol, oldToNewCol, AppConstants.LONG_DEFAULT_WAIT);
                WebElement dynamicElement = driver
                        .findElement(By.xpath("//div[@aria-rowindex='" + rowIndex + "']//a[@aria-label='" + currEle
                                + "']/ancestor::div[@col-id='resource']/preceding-sibling::div"));
                Actions a = new Actions(driver);
                a.moveToElement(dynamicElement).click().build().perform();
                a.doubleClick(dynamicElement).build().perform();
                //eleUtil.doElementClickable(getMaximizeScreenBtn(), 10);
                //eleUtil.doClick(getMaximizeScreenBtn());
                if (selectBookingStatus.equals("Scheduled")) {
                    eleUtil.waitForVisibilityOfElement(bookingStatusField, 100);
                    eleUtil.doClickLog(bookingStatusField, "Click on Booking Status");
                    By selectAnOption = By.cssSelector("button[title='In Progress']");
                    By bookingStatus = By.xpath("//div[@aria-label='Booking Status Control' and @title='In Progress']");
                    eleUtil.doClickWithWait(selectAnOption, 40);
                    eleUtil.doElementClickable(saveOnBooking, 10);
                    eleUtil.doClick(saveOnBooking);
                    eleUtil.waitForInVisibilityOfElement(loadingWithSaving, 100);
                }
                signTheChecklist();
                Thread.sleep(5000);
                eleUtil.waitForVisibilityOfElement(saveNCloseOnBooking, 100);
                eleUtil.doElementClickable(saveNCloseOnBooking, 10);
                eleUtil.doClick(saveNCloseOnBooking);
                while (true) {
                    try {
                        eleUtil.doElementClickable(saveNContinueBtn, 10);
                        eleUtil.doClick(saveNContinueBtn);
                    } catch (org.openqa.selenium.NoSuchElementException e) {
                        break;
                    }
                }
            }
            clickOnSaveNCloseBtn();
        }
        //resetFirstRunFlag();
    }

    public void openCheckList(String woNumber, String checkListName, String status) throws InterruptedException {
        Thread.sleep(2000);
        processWorkOrder(woNumber, status);
        eleUtil.waitForVisibilityOfElement(getChecklistTab(), 30);
        eleUtil.staleElementRefExecClickCRM(getChecklistTab());
        eleUtil.doClickLog(getChecklistTab(), "Click on Checklist tab");
        String actualName = eleUtil.doGetElementAttribute(getCheckListNameField(), "aria-label");
        assertTrue(actualName.contains(checkListName), "Checklist name is not matching");
        eleUtil.doElementClickable(getCheckListNameField(), 20);
        eleUtil.doClick(getCheckListNameField());
        eleUtil.doElementClickable(getMaximizeScreenBtn(), 10);
        eleUtil.doClick(getMaximizeScreenBtn());
    }

    public void saveChecklist() throws InterruptedException {
        eleUtil.doClick(getSaveBtnInChklist());
        System.out.println("clicked on save button");
        Thread.sleep(3000);
        eleUtil.doElementClickable(getMarkCompleteBtn(), 40);
        try {
            eleUtil.doClick(getMarkCompleteBtn());
        } catch (Exception e) {
            eleUtil.doActionsClick(getMarkCompleteBtn());
        }
        eleUtil.staleElementRefExecClickCRM(getSaveNCloseBtnInChklist());
        Thread.sleep(2000);
        eleUtil.doClickWithWait(getSaveNCloseBtnInChklist(), 150);
        clickOnSaveNCloseBtn();
    }

    public void emailCheck(String subjectName) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        By loc = By.xpath("//a[contains(@aria-label,'" + subjectName + "')]");
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (!eleUtil.elementIsDisplayed(loc, subjectName)) {
                eleUtil.doClickLog(moreButtonEmail, "Click on More Email button");
                eleUtil.waitForVisibilityOfElement(emailRefreshButton, 50);
                eleUtil.doClickLog(emailRefreshButton, "Click on Refresh button");
                Thread.sleep(1000); // Wait for 1 second before checking again
            } else {
                Log.info("Email is visible " + subjectName);
                break;
            }
        }
    }

    public void documentCheck(String documentName) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        By loc = By.xpath("//a[contains(@aria-label,'" + documentName + "')]");
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (!eleUtil.elementIsDisplayed(loc, documentName)) {
                eleUtil.doClickLog(moreButtonDocument, "Click on More Document button");
                eleUtil.waitForVisibilityOfElement(documentRefreshButton, 50);
                eleUtil.doClickLog(documentRefreshButton, "Click on Refresh button");
                Thread.sleep(1000); // Wait for 1 second before checking again
            } else {
                Log.info("Document is visible " + documentName);
                break;
            }
        }
    }

    public static boolean notificationForRecordNumber(By notificationIDCheck, String beforeTapToOpenBtn,
                                                      String notificationType) {
        String titleOnParentPage = setPageTitle();
        try {
            WebElement woAlert = eleUtil.waitTillPresenceOfElementReturn(notificationIDCheck, 30);
            if (woAlert != null && woAlert.isDisplayed()) {
                WebElement tapToOpenBtn = driver.findElement(By.xpath("//div[@aria-label='" + notificationType + "']"
                        + "//a[contains(text(), '" + beforeTapToOpenBtn + "')]"));
                tapToOpenBtn.click();
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                Log.info("open tabs: " + tabs.size());
                driver.switchTo().window(tabs.get(1));
                eleUtil.waitForVisibilityOfElement(getPageTitle(), 100);
                String afterTapToOpenBtn = setPageTitle();
                Log.info("afterTapToOpenBtn: " + afterTapToOpenBtn);
                assertTrue(afterTapToOpenBtn.contains(titleOnParentPage),
                        "Record is not the same after clicking on tap to open button");
                clickOnSaveNCloseBtn();
                driver.switchTo().window(tabs.get(0));
                eleUtil.waitForVisibilityOfElement(getCancelBtn(), 30);
                eleUtil.doClick(getCancelBtn());
                return true;
            }
        } catch (TimeoutException e) {
            Log.error("Timeout waiting for element: " + notificationIDCheck);
        } catch (Exception e) {
            Log.error("An error occurred: " + e.getMessage());
        }
        return false;
    }

    public void workOrderStatusFilter(String status) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(workOrderStatusGridHeader, 100);
        Thread.sleep(3000);
        attemptsDifferentClicks(workOrderStatusGridHeader);
        filterViewForStatus(status);
        eleUtil.doClickLog(getMoreButtonOnWorkOrder(), "Clicked on work order grid refresh button");
        eleUtil.doClickLog(getWorkOrderGridRefresh(), "Work Order not created click on work order grid refresh button");
        eleUtil.isPageLoaded(30);
        Thread.sleep(2000);
    }

    public void searchRecord(String recordNumber) throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(getSearchBox(), 20);
        Thread.sleep(2000);
        eleUtil.doSendKeysLog(getSearchBox(), recordNumber, "Enter record number " + recordNumber);
        eleUtil.isPageLoaded(50);
        Thread.sleep(2000);
        driver.findElement(getSearchBox()).sendKeys(Keys.ENTER);
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(getNoRecord(), "Nothing to Show here ") ||
                    eleUtil.elementIsDisplayed(getNoDataAvailableInSingleGrid(), "No data available ")) {
                Thread.sleep(3000);
                eleUtil.doClickLog(getRefreshBtn(), "Click on Refresh button");
            } else {
                // If the element is not displayed, execute the else block logic
                try {
                    Thread.sleep(3000);
                    selectFirstRecord();
                    getFirstRecord();
                    return; // Exit the method if the case number is verified
                } catch (NoSuchElementException e) {
                    Log.error("Project is not created: " + e.getMessage());
                }
            }
        }
    }

    public void openWOCreateManualBooking(String status) throws InterruptedException {
        eleUtil.waitForLoad(40, "wait for page to be loaded");
        workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        String nextButton;
        // Store all WOs from the first page
        commonActionsPage.WOnumber = getWONumber();
        woNum.addAll(commonActionsPage.WOnumber);
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is: " + woNum.size());
        // Check if there is a next button and click it if enabled
        nextButton = eleUtil.doGetElementAttributeLog(getNextButtonOnWorkOrder(), "aria-disabled",
                "Check next button is true/false");
        while (nextButton.contains("false")) {
            eleUtil.doClickLog(getNextButtonOnWorkOrder(), "click on next button on Work Order");
            Thread.sleep(2000);
            // Store all WOs from the next page
            commonActionsPage.WOnumber = getWONumber();
            woNum.addAll(commonActionsPage.WOnumber);
            Log.info("print wo number " + woNum);
            Log.info("size is: " + woNum.size());
            // Check the next button status again
            nextButton = eleUtil.doGetElementAttributeLog(getNextButtonOnWorkOrder(), "aria-disabled",
                    "Check next button is true/false");
        }
        // Process all collected WOs
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            processWorkOrder(woNum.get(i), status);
            // create Booking Manually
            acknowledgeWorkOrder("MM/dd/yyyy");
            eleUtil.waitForVisibilityOfElement(getRefreshBtn(), 100);
            eleUtil.doClickLog(getRefreshBtn(), "Click on Refresh button");
            long endTime = System.currentTimeMillis() + 5 * 60 * 1000; // 5 minutes from now
            while (System.currentTimeMillis() < endTime) {
                try {
                    if (eleUtil.elementIsDisplayed(getAcknowledgeButton(), "Acknowledge button is available")) {
                        Thread.sleep(3000); // Wait for 3 seconds
                        eleUtil.doClickLog(getRefreshBtn(), "Click on Refresh button");
                    } else {
                        // If the element is not displayed, execute the else block logic
                        clickOnSaveNCloseBtn();
                        return; // Exit the method
                    }
                } catch (NoSuchElementException e) {
                    Log.error("Booking Order is not created: " + e.getMessage());
                    return; // Exit the method if NoSuchElementException is caught
                } catch (InterruptedException e) {
                    Log.error("Thread was interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt(); // Restore the interrupted status
                    return; // Exit the method if InterruptedException is caught
                } catch (Exception e) {
                    Log.error("An unexpected error occurred: " + e.getMessage());
                    return; // Exit the method if any other exception is caught
                }
            }
        }
        //resetFirstRunFlag();
    }

    public void verifyBookingStatus(String WOstatus) {
        List<String> wonum = commonActionsPage.WOnumber;
        System.out.println("Size of wonum list is: " + wonum.size());

        for (int i = 0; i < wonum.size(); i++) {
            By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
            eleUtil.waitForVisibilityOfElement(woele, 30);
            eleUtil.doActionsClick(woele);
            By status = By.xpath("//select[@title='" + WOstatus + "']");
            String actualStatusval = eleUtil.doGetElementAttribute(WOstatusInWOform, "title");
            boolean flag = false;
            long startTime = System.currentTimeMillis();
            while (!flag && (System.currentTimeMillis() - startTime) < 180000) {
                try {
                    // Wait for visibility of the status element
                    eleUtil.waitForVisibilityOfElement(WOstatusInWOform, 10);

                    // Get the actual status value
                    actualStatusval = eleUtil.doGetElementAttribute(WOstatusInWOform, "title");

                    // Check if the status matches the expected value
                    if (actualStatusval.equals(WOstatus)) {
                        flag = true;
                    } else {
                        // Refresh the page or re-click the work order if status does not match
                        eleUtil.doClick(refreshBtn);
                        // Wait for status element again after refreshing
                        eleUtil.waitForVisibilityOfElement(status, 10);
                    }
                } catch (StaleElementReferenceException e) {
                    System.out.println("catching the exception");
                } catch (Exception e) {
                    System.out.println("Button is not present");
                }
            }
            // eleUtil.waitForVisibilityOfElement(status, 10);
            // String actualStatusval = eleUtil.doGetElementAttributeLog(status,
            // "aria-label", "WO Status value is : ");
            assertEquals(actualStatusval, WOstatus, "WO status is not same");
            Log.info("Booking sttaus is : " + actualStatusval);
            clickOnSaveNCloseBtn();
        }
    }

    public void verifyWOStatusOnCaseHomepage(String WOstatus) {
        navigatingToTab("Work Orders");
        By status = By.xpath("//label[@aria-label='" + WOstatus + "']");
        eleUtil.waitForVisibilityOfElement(status, 10);
        String actualStatusval = eleUtil.doGetElementAttributeLog(status, "aria-label",
                "WO Status value from case home page is : ");
        assertEquals(actualStatusval, WOstatus, "WO status is not same");

    }

    public void emailCheckAtProject(String subjectName) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        By loc = By.xpath("//label[contains(text(),'" + subjectName + "')]");
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (!eleUtil.elementIsDisplayed(loc, subjectName)) {
                eleUtil.waitForVisibilityOfElement(timelineRefresh, 50);
                eleUtil.doClickLog(timelineRefresh, "Clicked on refresh timeline button");
                Thread.sleep(1000); // Wait for 1 second before checking again
            } else {
                Log.info("Email is visible " + subjectName);
                break;
            }
        }
    }

    public void verifySystemAssessmentOnCaseHome(String asses) {
        navigatingToTab("Inspection Case Information");
        clickOnRefreshBtnOnHome();
        eleUtil.waitForVisibilityOfElement(systemAssessmentField, 30);
        String SystemAssesmentVal = eleUtil.doGetElementAttributeLog(systemAssessmentField, "title",
                "Displayed System Assesment is : ");
        assertEquals(SystemAssesmentVal, asses, "System Assesment is not same");

        eleUtil.waitForVisibilityOfElement(getUserAssessment(), 0);
        String UserAssesmentVal = eleUtil.doGetElementAttributeLog(getUserAssessment(), "title",
                "Displayed User Assesment is : ");
        assertEquals(UserAssesmentVal, asses, "System Assesment is not same");
    }

    public void notificationForTabToOpenCase(String text, String tab) throws InterruptedException {
        By notificationIDCheck = By.xpath("//p[contains(text(), '" + text + "')]");
        long endTime = System.currentTimeMillis() + 300000;
        while (System.currentTimeMillis() < endTime) {
            eleUtil.isPageLoaded(100);
            eleUtil.waitForVisibilityOfElement(getNotificationIcon(), 100);
            eleUtil.doClick(getNotificationIcon());
            Thread.sleep(3000);
            try {
                WebElement WOalert = eleUtil.waitTillPresenceOfElementReturn(notificationIDCheck, 30);
                if (WOalert != null && WOalert.isDisplayed()) {
                    WebElement tapToOpenBtn = driver.findElement(By.xpath("//p[contains(text(), '" + text
                            + "')]/ancestor::div[contains(@class, 'ac-container')]//a[contains(text(),'Case')]"));
                    tapToOpenBtn.click();
                    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                    Log.info("open tabs: " + tabs.size());
                    driver.switchTo().window(tabs.get(1));
                    eleUtil.waitForVisibilityOfElement(getPageTitle(), 100);
                    String afterTapToOpenBtn = eleUtil.doGetElementAttribute(getPageTitle(), "title");
                    Log.info("afterTapToOpenBtn: " + afterTapToOpenBtn);
                    assertTrue(afterTapToOpenBtn.contains(text),
                            "Record is not the same after clicking on tap to open button");
                    clickOnSaveNCloseBtn();
                    driver.switchTo().window(tabs.get(0));
                    eleUtil.doClick(getCancelBtn());
                    break;
                }
            } catch (TimeoutException e) {
                Log.error("Timeout waiting for element: " + notificationIDCheck);
            }
            // If the element is not found or not displayed, execute the else block logic
            eleUtil.doClickLog(getCancelBtn(), "Click on Cancel button");
            eleUtil.doClickLog(getRefreshBtn(), "Click on Refresh button");
            navigateToTab(tab);
            Log.error("Actual Case number is not matched with the open Case number");
        }
    }

    public void fetchWorkOrderNumbers(List<String> woNum) throws InterruptedException {
        String nextButton;
        do {
            commonCRMActions.WOnumber = getWONumber();
            woNum.addAll(commonCRMActions.WOnumber);
            Log.info("print wo number " + woNum);
            Log.info("size is: " + woNum.size());
            nextButton = eleUtil.doGetElementAttributeLog(getNextButtonOnWorkOrder(), "aria-disabled",
                    "Check next button is true/false");
            if (nextButton.contains("false")) {
                eleUtil.doClickLog(getNextButtonOnWorkOrder(), "click on next button on Work Order");
                Thread.sleep(2000);
            }
        } while (nextButton.contains("false"));
    }

    public void clearResponseInChecklist() {

        eleUtil.waitForVisibilityOfElement(clearResponseBtn, 10);
        eleUtil.doClickLog(clearResponseBtn, "Click on Clear Response button");
        eleUtil.waitForVisibilityOfElement(okBtn, 10);
        eleUtil.doClickLog(okBtn, "Click on Ok button");
    }

    public void workOrderTypeFilter(String WOType) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(workOrderTypeGridHeader, 50);
        eleUtil.doClickLog(workOrderTypeGridHeader, "Click on Work Order type Column");
        filterViewForStatus(WOType);
        eleUtil.isPageLoaded(30);
    }

    public void bookingStatusFilter(String bookingStatus) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(bookingSsatusGridHeader, 50);
        eleUtil.doClickLog(bookingSsatusGridHeader, "Click on Booking status Column");
        filterViewForStatus(bookingStatus);
        eleUtil.isPageLoaded(30);
    }

    public void selectWOBasedOnType(String WOType)
            throws InterruptedException {
        // workOrderTypeFilter(WOType);
        commonCRMActions.WOnumber = getWONumber();
        List<String> woNum = new ArrayList<>();
        String nextButton;
        woNum.addAll(commonCRMActions.WOnumber);
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is: " + woNum.size());
        // Check if there is a next button and click it if enabled
        nextButton = eleUtil.doGetElementAttributeLog(getNextButtonOnWorkOrder(), "aria-disabled",
                "Check next button is true/false");
        while (nextButton.contains("false")) {
            eleUtil.doClickLog(getNextButtonOnWorkOrder(), "click on next button on Work Order");
            Thread.sleep(2000);
            // Store all WOs from the next page
            commonCRMActions.WOnumber = getWONumber();
            woNum.addAll(commonCRMActions.WOnumber);
            Log.info("print wo number " + woNum);
            Log.info("size is: " + woNum.size());
            // Check the next button status again
            nextButton = eleUtil.doGetElementAttributeLog(getNextButtonOnWorkOrder(), "aria-disabled",
                    "Check next button is true/false");
        }
        // Process all collected WOs
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            workOrderTypeFilter(WOType);
            /*if (!isFirstRun.get()) {
                workOrderTypeFilter(WOType);
            } else {
                isFirstRun.set(Boolean.FALSE); // Set the flag to false after the first run
            }*/
            By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + woNum.get(i) + "']");
            eleUtil.waitForVisibilityOfElement(woele, 50);
            eleUtil.doActionsClick(woele);

        }
        //resetFirstRunFlag();
    }

    public void openWOGoToBookings(String tabName) {
        By workOrderTabs = By.xpath("//li[text()='" + tabName + "']");
        selectFirstRecord();
        getFirstRecord();
        eleUtil.waitForVisibilityOfElement(workOrderTabs, 30);
        eleUtil.staleElementRefExecClickCRM(workOrderTabs);
        eleUtil.doClick(workOrderTabs);
    }

    // This method can be removed once Booking issue is resolved
    public void bookingIssue() throws InterruptedException {
        Thread.sleep(1000);
        attemptsDifferentClicks(bookingDuration);
        eleUtil.doClearUsingKeysLog(bookingDuration, "Clear Booking value");
        eleUtil.doSendKeysWithWait(bookingDuration, "2 hours", 30);
    }

    public void checkWOStatus(String completeStatus) throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(WOstatusInWOform, 10);
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            String actualStatusVal = eleUtil.doGetElementAttribute(WOstatusInWOform, "title");
            if (actualStatusVal.equals(completeStatus)) {
                break;
            } else {
                Thread.sleep(2000);
                eleUtil.doClick(refreshBtn);
            }
        }
        String finalStatusVal = eleUtil.doGetElementAttribute(WOstatusInWOform, "title");
        Assert.assertEquals(finalStatusVal, completeStatus, "Status Not Matched");
    }

    public void checkSystemAndUserAssessment(String value) throws InterruptedException {
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(emptyUserAssessment, "User Assessment is empty")
                    && eleUtil.elementIsDisplayed(emptySystemAssessment, "System Assessment is empty")) {
                eleUtil.doClickLog(getRefreshBtn(), "Click on Refresh button");
                Thread.sleep(1000); // Wait for 1 second before checking again
            } else {
                try {
                    eleUtil.textVerificationFormAttribute(getUserAssessment(), "title", value);
                    eleUtil.textVerificationFormAttribute(getSystemAssessment(), "title", value);
                    break;
                } catch (NoSuchElementException e) {
                    Log.error("System and User Assessment are empty: " + e.getMessage());
                }
            }
        }
    }

    public void saveAndMarkCompleteChecklist() throws InterruptedException {
        eleUtil.doClickLog(getSaveBtnInChklist(), "click on Save Checklist button");
        waitForChecklistPageToSaved();
        if (eleUtil.elementIsDisplayed(saveNContinueBtn, "Save and Continue button is displayed")) {
            eleUtil.doClickLog(saveNContinueBtn, "click on Save and Continue button");
            eleUtil.waitForInVisibilityOfElement(saveNContinueBtn, 30);
            Thread.sleep(3000);
        }
        eleUtil.doElementClickable(getMarkCompleteBtn(), 50);
        attemptsDifferentClicks(getMarkCompleteBtn());
        if (eleUtil.elementIsDisplayed(saveNContinueBtn, "Save and Continue button is displayed")) {
            eleUtil.doClickLog(saveNContinueBtn, "click on Save and Continue button");
            eleUtil.waitForInVisibilityOfElement(saveNContinueBtn, 30);
            Thread.sleep(3000);
        }
        eleUtil.staleElementRefExecClickCRM(getSaveNCloseBtnInChklist());
        Thread.sleep(2000);
        eleUtil.doClickWithWait(getSaveNCloseBtnInChklist(), 150);
    }

    public void checkWOSystemAndUserDetails(String completeStatus, String value) throws InterruptedException {
        navigateToTab("Summary");
        checkWOStatus(completeStatus);
        checkSystemAndUserAssessment(value);
    }

    public void workOrderIncidentTypeFilter(String checkListName) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(workOrderIncidentTypeGridHeader, 100);
        Thread.sleep(3000);
        attemptsDifferentClicks(workOrderIncidentTypeGridHeader);
        filterViewForTextValueType(checkListName);
        eleUtil.doClickLog(getMoreButtonOnWorkOrder(), "Clicked on work order grid refresh button");
        eleUtil.doClickLog(getWorkOrderGridRefresh(), "Work Order not created click on work order grid refresh button");
        eleUtil.isPageLoaded(30);
        Thread.sleep(2000);
    }

    public void clickSaveNContinueBtn() throws InterruptedException {
        try {
            eleUtil.waitForVisibilityOfElement(saveNContinueBtn, 90);
            eleUtil.doClick(saveNContinueBtn);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Handle the exception, for example, log the error or take some other action
            Log.error("Element not found: " + e.getMessage());
        }
        // Comment the below code this is a fix of a bug
        clickOnSavingInProgressOkButton();
    }

    public void clickDiscardChanges() {
        try {
            eleUtil.waitForVisibilityOfElement(getDiscardChangesBtn(), 90);
            eleUtil.doClick(getDiscardChangesBtn());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Handle the exception, for example, log the error or take some other action
            Log.error("Element not found: " + e.getMessage());
        }
    }

    public void bookingsStatusFilter(String status) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(bookingStatusGridHeader, 100);
        Thread.sleep(3000);
        attemptsDifferentClicks(bookingStatusGridHeader);
        filterViewForTextValueType(status);
        eleUtil.waitTillElementIsDisplayed(getBookingRefreshButton(), 30);
        eleUtil.doClickLog(getBookingRefreshButton(),
                "Booking not created click on Booking grid refresh button");
        eleUtil.isPageLoaded(30);
        Thread.sleep(2000);
    }

    public void waitForRecordFormPageToSaved() {
        eleUtil.waitForVisibilityOfElement(recordFormPageToSaved, 200);
    }

    public void waitForChecklistPageToSaved() {
        eleUtil.waitForVisibilityOfElement(checklistPageToSaved, 200);
    }

    public void checkUserAssessment(String value) throws InterruptedException {
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(emptyUserAssessment, "User Assessment is empty")) {
                eleUtil.doClickLog(getRefreshBtn(), "Click on Refresh button");
                Thread.sleep(1000); // Wait for 1 second before checking again
            } else {
                try {
                    eleUtil.textVerificationFormAttribute(getUserAssessment(), "title", value);
                    break;
                } catch (NoSuchElementException e) {
                    Log.error("System and User Assessment are empty: " + e.getMessage());
                }
            }
        }
    }

    public void acknowledgeWorkOrder(String format) throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(getAcknowledgeButton(), 30);
        eleUtil.doClickLog(getAcknowledgeButton(), "click on Acknowledge button");
        eleUtil.waitForVisibilityOfElement(getClickOnProposedInspectionDateCalender(), 30);
        eleUtil.doSendKeysLog(getClickOnProposedInspectionDateCalender(),
                eleUtil.todayDatePlusDays(format, 2), "Enter today's date + 2");
        eleUtil.doClickLog(getSaveAndCloseWOAcknowledgePopup(), "click on save and close button on Manual Booking");
        Thread.sleep(2000);
    }

    public void formSGStatusFilter(String rectificationStatus) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        eleUtil.waitForVisibilityOfElement(formSGStatusGridHeader, 100);
        Thread.sleep(3000);
        attemptsDifferentClicks(formSGStatusGridHeader);
        filterViewForCheckbox(rectificationStatus);
        eleUtil.doClickLog(moreButtonOnFormSG, "Clicked on Form SG grid refresh button");
        eleUtil.doClickLog(getWorkOrderGridRefresh(), "Form SG not created click on Form SG grid refresh button");
        eleUtil.isPageLoaded(30);
        Thread.sleep(2000);
    }

    public void clickOnSavingInProgressOkButton() throws InterruptedException { // remove this code once issue is
        // resolved
        eleUtil.isPageLoaded(100);
        if (eleUtil.elementIsDisplayed(getSavingInProgressPopUp(), "Saving in Progress Pop Up")) {
            eleUtil.waitForVisibilityOfElement(savingInProgressOkButton, 30);
            while (true) {
                List<WebElement> okButtons = driver.findElements(savingInProgressOkButton);
                if (okButtons.isEmpty()) {
                    break;
                }
                for (WebElement button : okButtons) {
                    try {
                        button.click();
                        // Refresh the list of elements after each click
                        okButtons = driver.findElements(savingInProgressOkButton);
                    } catch (Exception e) {
                        Log.error("Error clicking on Ok button: {}" + e.getMessage());
                    }
                }
            }
        } else {
            eleUtil.doClickLog(getRefreshBtn(), "Click on Refresh button");
        }
    }


}
