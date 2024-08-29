package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import java.util.List;

import com.sat.testUtil.Log;
import org.openqa.selenium.*;

import com.sat.constants.AppConstants;
import org.openqa.selenium.interactions.Actions;

public class commonCRMActions extends CommonActionsPage {

    public commonCRMActions(WebDriver driver) {
        super(driver);
    }

    long endTime = System.currentTimeMillis() + 5 * 60 * 1000;

    private static By saveCloseBtn = By.xpath("//button[@aria-label='Save & Close']");
    private static By refreshBtn = By.xpath("//button[@aria-label='Refresh']");
    private By firstRecord = By.xpath("(//input[contains(@aria-label,'elect or deselect the row')])[1]");
    private By notificationIcon = By.xpath("//button[@aria-label='Notifications']");
    private static By cancelBtn = By.xpath("//button[@title='Close']");
    private static By pageTitle = By.cssSelector("h1[data-id='header_title']");
    private By workordertext = By.xpath("//input[@aria-label='Work Order Number']");

    // Locators on WorkOrder tab
    private By saveNContinueBtn = By.xpath("//span[text()='Save and continue']");

    // Locators on work order form
    private By bookingTab = By.xpath("//li[text()='Bookings']");
    private By checklistTab = By.xpath("//li[text()='Checklist']");

    // Locators on Bookings home page
    private By checkListNameField = By.xpath("//div[@col-id='msdyn_name']/descendant::a");
    private By maximizeScreenBtn = By.xpath("//button[@aria-label='Enter full screen mode']");
    private By bookingStatusField = By.cssSelector("div[class='ms-Dropdown-container']");
    private By saveNCloseOnBooking = By
            .xpath("//span[text()='Save and close this Bookable Resource Booking.']/preceding-sibling::button");
    private By saveOnBooking = By
            .xpath("//span[text()='Save this Bookable Resource Booking.']/preceding-sibling::button");
    private By notestab = By.xpath("//li[@aria-label='Notes']");
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


    public By getSaveBtn() {
        return saveBtn;
    }

    public By getChecklistTab() {
        return checklistTab;
    }

    public By getWorkOrderText() {
        return workordertext;
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

    public static By getSaveCloseBtn() {
        return saveCloseBtn;
    }

    public void clickOnSaveButton() {
        eleUtil.waitTillElementIsDisplayed(getSaveBtn(), 30);
        eleUtil.doClickLog(getSaveBtn(), "Clicked on Save Button");
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
                WebElement WOalert = eleUtil.waitTillPresenceOfElementReturn(notificationIDCheck, 30);
                if (WOalert != null && WOalert.isDisplayed()) {
                    WebElement tapToOpenBtn = driver.findElement(By.xpath("//p[contains(text(), '" + text + "')]/ancestor::div[contains(@class, 'ac-container')]//a[contains(text(),'Tap to')]"));
                    tapToOpenBtn.click();
                    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                    Log.info("open tabs: " + tabs.size());
                    driver.switchTo().window(tabs.get(1));
                    eleUtil.waitForVisibilityOfElement(getPageTitle(), 100);
                    String afterTapToOpenBtn = eleUtil.doGetElementAttribute(getPageTitle(), "title");
                    Log.info("afterTapToOpenBtn: " + afterTapToOpenBtn);
                    assertTrue(afterTapToOpenBtn.contains(text), "Record is not the same after clicking on tap to open button");
                    eleUtil.doElementClickable(getSaveCloseBtn(), 20);
                    eleUtil.doClick(getSaveCloseBtn());
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
            navigatingToTabFactory(tab);
            Log.error("Actual Case number is not matched with the open Case number");
        }
    }

    public void navigatingToTabFactory(String tabName) {
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

    public void signTheChecklist() {
        // Below 2 steps need to be included once signature box is moved to checklist
        // selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
        // getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
        eleUtil.isPageLoaded(50);
        eleUtil.doElementClickable(notestab, 100);
        eleUtil.doActionsClick(notestab);
        eleUtil.doElementClickable(signature_box, 20);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(driver.findElement(signature_box), 135, 0).build().perform();
        eleUtil.doElementClickable(confirmBtn, 30);
        eleUtil.doClick(confirmBtn);
        eleUtil.waitForVisibilityOfElement(nameOfAssignee, 30);
        eleUtil.doSendKeys(nameOfAssignee, "FIO");
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

    public void processWorkOrder(String woNumber) throws InterruptedException {
        By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + woNumber + "']");
        eleUtil.doActionsClick(woele);
        eleUtil.waitForVisibilityOfElement(getWorkOrderText(), 30);
        String actualWO = eleUtil.doGetElementAttribute(getWorkOrderText(), "value");
        Log.info("actual WO:" + actualWO);
        Log.info("expected wo:" + woNumber);
        assertTrue(actualWO.contains(woNumber), "WO is not same");
    }

    public void fillBookingDetails() throws InterruptedException {
        CommonActionsPage.WOnumber = getWONumber();
        List<String> woNum = CommonActionsPage.WOnumber;
        Thread.sleep(2000);
        System.out.println("print wo number " + woNum);
        Log.info("size is:" + woNum.size());
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            processWorkOrder(woNum.get(i));
            // Validation on Booking tab
            eleUtil.staleElementRefExecClickCRM(bookingTab);
            eleUtil.doClick(bookingTab);
            Thread.sleep(2000);
            selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
            getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
            eleUtil.doElementClickable(getMaximizeScreenBtn(), 10);
            eleUtil.doClick(getMaximizeScreenBtn());
            eleUtil.waitForVisibilityOfElement(bookingStatusField, 100);
            eleUtil.doClickLog(bookingStatusField, "Click on Booking Status");
            By selectAnOption = By.xpath("//button[@title='In Progress']");
            eleUtil.waitForVisibilityOfElement(selectAnOption, 100);
            eleUtil.doClick(selectAnOption);
            eleUtil.doElementClickable(saveOnBooking, 10);
            eleUtil.doClick(saveOnBooking);
            Thread.sleep(7000);
            signTheChecklist();
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
            try {
                eleUtil.doClick(saveCloseBtn);
            } catch (Exception e) {
                eleUtil.doActionsClick(saveCloseBtn);
            }
        }
    }

    public void openCheckList(String woNumber) throws InterruptedException {
        CommonActionsPage.WOnumber = getWONumber();
        List<String> woNum = CommonActionsPage.WOnumber;
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is:" + woNum.size());
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            processWorkOrder(woNum.get(i));
            eleUtil.doClick(getChecklistTab());
            String actualName = eleUtil.doGetElementAttribute(getCheckListNameField(), "aria-label");
            assertTrue(actualName.contains("Trade Effluent Inspection"), "Checklist name is not matching");
            eleUtil.doElementClickable(getCheckListNameField(), 20);
            eleUtil.doClick(getCheckListNameField());
            eleUtil.doElementClickable(getMaximizeScreenBtn(), 10);
            eleUtil.doClick(getMaximizeScreenBtn());
        }
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
        try {
            eleUtil.doClickWithWait(saveCloseBtn, 100);
        } catch (Exception e) {
            eleUtil.doActionsClick(saveCloseBtn);
        }
    }

    public void emailCheck(String subjectName) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        By loc = By.xpath("//a[contains(@aria-label,'" + subjectName + "')]");
        while (System.currentTimeMillis() < endTime) {
            if (!eleUtil.elementIsDisplayed(loc, subjectName)) {
                eleUtil.doClickLog(moreButtonEmail, "Click on More Email button");
                eleUtil.waitForVisibilityOfElement(emailRefreshButton, 50);
                eleUtil.doClickLog(emailRefreshButton, "Click on Refresh button");
                Thread.sleep(1000); // Wait for 1 second before checking again
            } else {
                Log.info("Email is visible "+ subjectName);
                break;
            }
        }
    }

    public boolean notificationForRecordNumber(By notificationIDCheck, String beforeTapToOpenBtn, String notificationType) {
        String titleOnParentPage = eleUtil.doGetElementAttribute(getPageTitle(), "title");
        try {
            WebElement woAlert = eleUtil.waitTillPresenceOfElementReturn(notificationIDCheck, 30);
            if (woAlert != null && woAlert.isDisplayed()) {
                WebElement tapToOpenBtn = driver.findElement(By.xpath("//div[@aria-label='" + notificationType + "']" +
                        "//a[contains(text(), '" + beforeTapToOpenBtn + "')]"));
                tapToOpenBtn.click();
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                Log.info("open tabs: " + tabs.size());
                driver.switchTo().window(tabs.get(1));
                eleUtil.waitForVisibilityOfElement(getPageTitle(), 100);
                String afterTapToOpenBtn = eleUtil.doGetElementAttribute(getPageTitle(), "title");
                Log.info("afterTapToOpenBtn: " + afterTapToOpenBtn);
                assertTrue(afterTapToOpenBtn.contains(titleOnParentPage), "Record is not the same after clicking on tap to open button");
                eleUtil.waitForVisibilityOfElement(getSaveCloseBtn(),30);
                eleUtil.doElementClickable(getSaveCloseBtn(), 20);
                eleUtil.doClick(getSaveCloseBtn());
                driver.switchTo().window(tabs.get(0));
                eleUtil.waitForVisibilityOfElement(getCancelBtn(),30);
                eleUtil.doClick(getCancelBtn());
                return true;
            }
        } catch (TimeoutException e) {
            Log.error("Timeout waiting for element: " + notificationIDCheck);
        }
        return false;
    }
}
