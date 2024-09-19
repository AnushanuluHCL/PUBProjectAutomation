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

public class commonCRMActions extends commonActionsPage {

	public commonCRMActions(WebDriver driver) {
		super(driver);
	}

	ThreadLocal<Boolean> isFirstRun = ThreadLocal.withInitial(() -> Boolean.TRUE);

	private static By saveNCloseBtn = By.xpath("//button[@aria-label='Save & Close']");
	private static By refreshBtn = By.xpath("//button[@aria-label='Refresh']");
	private By notificationIcon = By.xpath("//button[@aria-label='Notifications']");
	private static By cancelBtn = By.xpath("//button[@title='Close']");
	private static By pageTitle = By.cssSelector("h1[data-id='header_title']");
	private By workOrderText = By.xpath("//input[@aria-label='Work Order Number']");

	// Locators on WorkOrder tab
	private By saveNContinueBtn = By.xpath("//span[text()='Save and continue']");
	private By durationFieldOnBooking = By.xpath("//input[@aria-label='Duration']");

	// Locators on work order form
	private By bookingTab = By.xpath("//li[text()='Bookings']");
	private By checklistTab = By.xpath("//li[text()='Checklist']");

	// Locators on Bookings home page
	private By checkListNameField = By.xpath("//div[@col-id='msdyn_name']/descendant::a");
	private By maximizeScreenBtn = By.xpath("//button[@aria-label='Enter full screen mode']");
	private By bookingStatusField = By
			.xpath("//div[@class='ms-Dropdown-container'] //div[contains(@data-id,'BookingStatusControl')]");
	private By saveNCloseOnBooking = By
			.xpath("//span[text()='Save and close this Bookable Resource Booking.']/preceding-sibling::button");
	private By saveOnBooking = By
			.xpath("//span[text()='Save this Bookable Resource Booking.']/preceding-sibling::button");
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
	private By moreButtonOnWorkOrder = By.cssSelector("button[aria-label='More commands for Work Order']");
	private By workOrderGridRefresh = By.xpath("//ul[@data-id='OverflowFlyout'] //button[@aria-label='Refresh']");
	private By nextButtonOnWorkOrder = By
			.xpath("//div[contains(@id,'dataSetRoot_WorkOrders')] //button[@aria-label='Next page']");
	private By searchBox = By.cssSelector("input[placeholder='Filter by keyword']");
	private By noRecord = By.xpath("//div[contains(text(),'anything to show here')]");
	private By acknowledgeButton = By.cssSelector("button[aria-label='Acknowledge']");
	private By clickOnProposedInspectionDateCalender = By
			.xpath("//div[contains(@data-id,'pub_proposedinspectiondate.fieldControl.')] //input[@role='combobox']");
	private By saveAndCloseOnManualBooking = By
			.xpath("//div[contains(@id,'dialogPageContainer')] //button[@aria-label='Save & Close']");
	private By selectTodayDateAndTime = By.cssSelector("td[aria-selected='true']");

	// Locators on Bookings tab
	private By resourceField = By.xpath("//div[@col-id='resource']/descendant::a");
	private By starttimeField = By.xpath("(//div[@col-id='starttime']/descendant::label)[2]"); // (//div[@col-id='starttime'])[2]
	private By endtimeField = By.xpath("(//div[@col-id='endtime'])[2]");
	private By durationField = By.xpath("(//div[@col-id='duration'])[2]");
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

	// Locators on case home page
	private By systemAssesmentField = By.xpath("//select[@aria-label='System Assessment']");
	private By userAssesmentField = By.xpath("//select[@aria-label='User Assessment']");

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

	public static By getSaveNCloseBtn() {
		return saveNCloseBtn;
	}

	public By getNoRecord() {
		return noRecord;
	}

	public By getAcknowledgeButton() {
		return acknowledgeButton;
	}

	public By getClickOnProposedInspectionDateCalender() {
		return clickOnProposedInspectionDateCalender;
	}

	public By getSaveAndCloseOnManualBooking() {
		return saveAndCloseOnManualBooking;
	}

	public void resetFirstRunFlag() {
		isFirstRun.set(Boolean.TRUE);
	}

	public By getSelectTodayDateAndTime() {
		return selectTodayDateAndTime;
	}

	public By getMoreCommandButtonForBooking() {
		return moreCommandButtonForBooking;
	}

	public By getBookingRefreshButton() {
		return bookingRefreshButton;
	}

	public static void clickOnSaveNCloseButton() {
		eleUtil.waitTillElementIsDisplayed(getSaveNCloseBtn(), 150);
		eleUtil.doClickLog(getSaveNCloseBtn(), "Click on Save & Close button");
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
				WebElement WOalert = eleUtil.waitTillPresenceOfElementReturn(notificationIDCheck, 30);
				if (WOalert != null && WOalert.isDisplayed()) {
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
					clickOnSaveNCloseButton();
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
		// eleUtil.doActionsClick(notesTab);
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

	public void processWorkOrder(String woNumber, String status) throws InterruptedException {
		if (!isFirstRun.get()) {
			workOrderStatusFilter(status);
		} else {
			isFirstRun.set(Boolean.FALSE); // Set the flag to false after the first run
		}
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
			Thread.sleep(2000);
			processWorkOrder(woNum.get(i), status);
			// Validation on Booking tab
			eleUtil.waitForVisibilityOfElement(getBookingTab(), 30);
			eleUtil.staleElementRefExecClickCRM(getBookingTab());
			eleUtil.doClick(getBookingTab());
			Thread.sleep(2000);
			checkBookingsOrder();
			selectFirstRecord();
			getFirstRecord();
			eleUtil.doElementClickable(getMaximizeScreenBtn(), 10);
			eleUtil.doClick(getMaximizeScreenBtn());
			eleUtil.waitForVisibilityOfElement(bookingStatusField, 100);
			eleUtil.doClickLog(bookingStatusField, "Click on Booking Status");
			By selectAnOption = By.cssSelector("button[title='" + selectBookingStatus + "']");
			By bookingStatus = By
					.xpath("//div[@aria-label='Booking Status Control' and @title='" + selectBookingStatus + "']");
			eleUtil.doClickWithWait(selectAnOption, 40);
			eleUtil.doElementClickable(saveOnBooking, 10);
			eleUtil.doClick(saveOnBooking);
			eleUtil.waitForVisibilityOfElement(bookingStatus, 100);
			if (status.equals("Scheduled")) {
				signTheChecklist();
			}
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
			try {
				clickOnSaveNCloseButton();
			} catch (Exception e) {
				eleUtil.doActionsClick(getSaveNCloseBtn());
			}
		}
		resetFirstRunFlag();
	}

	public void multipleBookingfilling(String status, String selectBookingStatus) throws InterruptedException {
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
				String arialabel = record.getAttribute("aria-label");
				bookingRecordTexts.add(arialabel);
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

				eleUtil.doElementClickable(getMaximizeScreenBtn(), 10);
				eleUtil.doClick(getMaximizeScreenBtn());

				 signTheChecklist();

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
			try {
				clickOnSaveNCloseButton();
			} catch (Exception e) {
				eleUtil.doActionsClick(getSaveNCloseBtn());
			}
		}
		resetFirstRunFlag();
	}

	public void openCheckList(String woNumber, String checkListName, String status) throws InterruptedException {
		Thread.sleep(2000);
		processWorkOrder(woNumber, status);
		eleUtil.doClick(getChecklistTab());
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
		try {
			clickOnSaveNCloseButton();
		} catch (Exception e) {
			eleUtil.doActionsClick(getSaveNCloseBtn());
		}
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
				clickOnSaveNCloseButton();
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
		eleUtil.waitForVisibilityOfElement(workOrderStatusGridHeader, 50);
		eleUtil.doClickLog(workOrderStatusGridHeader, "Click on Work Order Status Column");
		filterViewForStatus(status);
		eleUtil.isPageLoaded(30);
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
			if (eleUtil.elementIsDisplayed(getNoRecord(), "No data available")) {
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
			eleUtil.waitForVisibilityOfElement(getAcknowledgeButton(), 30);
			eleUtil.doClickLog(getAcknowledgeButton(), "click on Acknowledge button");
			eleUtil.waitForVisibilityOfElement(getClickOnProposedInspectionDateCalender(), 30);
			eleUtil.doSendKeysLog(getClickOnProposedInspectionDateCalender(),
					eleUtil.todayDatePlusDays("MM/dd/yyyy", 2), "Enter today's date + 2");
			eleUtil.doClickLog(getSaveAndCloseOnManualBooking(), "click on save and close button on Manual Booking");
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
						clickOnSaveNCloseButton();
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
		resetFirstRunFlag();
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
			clickOnSaveNCloseButton();
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
				eleUtil.waitForVisibilityOfElement(getRefreshBtn(), 50);
				eleUtil.doClickLog(getRefreshBtn(), "Clicked on refresh button");
				navigateToTab("All Activities");
				Thread.sleep(1000); // Wait for 1 second before checking again
			} else {
				Log.info("Email is visible " + subjectName);
				break;
			}
		}
	}

	public void verifySystemAssesmentOnCaseHome(String asses) {
		navigatingToTab("Inspection Case Information");
		clickOnRefreshBtnOnHome();
		eleUtil.waitForVisibilityOfElement(systemAssesmentField, 30);
		String SystemAssesmentVal = eleUtil.doGetElementAttributeLog(systemAssesmentField, "title",
				"Displayed System Assesment is : ");
		assertEquals(SystemAssesmentVal, asses, "System Assesment is not same");

		eleUtil.waitForVisibilityOfElement(userAssesmentField, 0);
		String UserAssesmentVal = eleUtil.doGetElementAttributeLog(userAssesmentField, "title",
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
							+ "')]/ancestor::div[contains(@class, 'ac-container')]//a[contains(text(),'Tap to Open Case')]"));
					tapToOpenBtn.click();
					ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
					Log.info("open tabs: " + tabs.size());
					driver.switchTo().window(tabs.get(1));
					eleUtil.waitForVisibilityOfElement(getPageTitle(), 100);
					String afterTapToOpenBtn = eleUtil.doGetElementAttribute(getPageTitle(), "title");
					Log.info("afterTapToOpenBtn: " + afterTapToOpenBtn);
					assertTrue(afterTapToOpenBtn.contains(text),
							"Record is not the same after clicking on tap to open button");
					clickOnSaveNCloseButton();
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
}
