package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.sat.constants.AppConstants;
import com.sat.testUtil.ElementUtil;
import com.sat.testUtil.ExcelUtil;
import com.sat.testUtil.JavaScriptUtil;
import com.sat.testUtil.Log;
import com.sat.testbase.TestBase;

public class CommonActionsPage {

	protected WebDriver driver;
	protected Properties prop;
	protected ElementUtil eleUtil;
	protected ExcelUtil excelUtil;
	protected TestBase testbase;
	protected JavaScriptUtil jsutil;
	protected SoftAssert softassert;

	public static List<String> WOnumber;
	public static String TankerName, TankerCapacity, casenumber, Tankercompanyname, starttimeval, startdateval,
			permitnum, permitExpiryDate, GWCReferenceNum, case_FIO, case_SO, case_AO, oldSealNumber, newSealNumber,
			resealReason, WRN1_factoryname;
	private static Map<String, String> sharedValues = new HashMap<>();
	private static Map<String, List<String>> sharedValuesList = new HashMap<>();
	protected static Map<Integer, String> tankerNumber = new HashMap<>();
	protected static Map<Integer, String> tankcapacity = new HashMap<>();
	protected static Map<String, Integer> tankerNumberSize = new HashMap<>();
	protected static Map<String, String> permitnums = new TreeMap<>();

	private By saveBtn = By.xpath("//button[@aria-label='Save (CTRL+S)']");
	private By saveCloseBtn = By.xpath("//button[@aria-label='Save & Close']");
	private By refreshBtn = By.xpath("//button[@aria-label='Refresh']");
	private By changeAreaLocatoin = By.id("areaSwitcherId");

	private By newBtn = By.xpath("//button[@aria-label='New' or @aria-label='New Case']");
	private By createdonCol = By.xpath("//div[text()='Created On']");
	// div[text()='Created On']/ancestor::div[@data-testid='columnHeader']
	private By NewToOldCol = By.xpath("//span[text()='Sort newer to older']");
	private By firstRecord = By.xpath("(//input[contains(@aria-label,'elect or deselect the row')])[1]");
	private By searchbox = By.xpath("//input[@aria-label='Case Filter by keyword']");
	private By changeViewIcon = By.xpath("//span[text()='Open popup to change view.']//following-sibling::i");
	private By nextstageBtn = By.xpath("//div[contains(@id,'nextButton')]");
	private By closeBtnOnBPF = By.xpath("//button[@title='Close']");

	private By BusinessFunctionField = By.xpath("//ul[@title='Business Function']");// div[contains(@data-id,'pub_businessfunctionid_selected_tag')]
	private By casetypeField = By.xpath("//select[@aria-label='Case Type']");
	private By caseSubtypeField = By.xpath("//select[@aria-label='Case Sub Type']");
	private By statusField = By.xpath("//div[text()='Status']/preceding-sibling::div/div");
	private By entityLink = By.xpath("//ul[@title='Entity']//div[contains(@data-id,'customerid_selected_tag_text')]");
	private By notificationIcon = By.xpath("//button[@aria-label='Notifications']");
	private By cancelBtn = By.xpath("//i[@data-icon-name='Cancel']");
	private By entityLookupField = By.xpath("//input[@aria-label='Entity, Lookup']");
	private By caseid = By.xpath("//input[@aria-label='Case ID']");

	// Locators for View
	private By filterBy = By.xpath("//span[text()='Filter by']");
	private By filterbyinputbox = By.xpath("//input[@aria-label='Filter by value']");

    public CommonActionsPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
        jsutil = new JavaScriptUtil(this.driver);
        //excelUtil = new ExcelUtil();
        prop = eleUtil.readProperties();
        softassert = new SoftAssert();
    }

	public static void setSharedValue(String key, String value) {
		sharedValues.put(key, value);
	}

	public static String getSharedValue(String key) {
		return sharedValues.get(key);
	}

	public static void tankerNumber(Integer key, String value) {
		tankerNumber.put(key, value);
	}

	public static String tankerNumber(String key) {
		return tankerNumber.get(key);
	}

	public static Integer tankerNumberSize(String key, Integer value) {
		return tankerNumberSize.put(key, value);
	}

	public static String permitnums(String key, String value) {
		return permitnums.put(key, value);
	}

	public static void setSharedValuesList(String key, List<String> value) {
		List<String> vals = new ArrayList<>();
		sharedValuesList.put(key, vals);
	}

	public static List<String> getSharedValueList(String key) {
		return sharedValuesList.get(key);
	}

	public void changeAreaSelection(String changearea) {
		eleUtil.waitForVisibilityOfElement(changeAreaLocatoin, 30);
		eleUtil.doClickLog(changeAreaLocatoin, "Click on changearea");
		By changeareaname = By.xpath("//li[@role='menuitemradio']//span[text()='" + changearea + "']");
		eleUtil.doClickLog(changeareaname, "Changearea selected is : " + changearea);

	}

	public void clickOnSaveBtn() {
		eleUtil.doElementClickable(saveBtn, 30);
		try {
			eleUtil.doClickLog(saveBtn, "Save button clciked using click");
		} catch (Exception e) {
			eleUtil.doActionsClickLog(saveBtn, "Save button clciked using actions click");
		}
	}

	public void clickonSaveAndCloseBtn() {
		eleUtil.doElementClickable(saveCloseBtn, 30);
		try {
			eleUtil.doClickLog(saveCloseBtn, "Save & Close button clciked using click");
		} catch (Exception e) {
			eleUtil.doActionsClickLog(saveCloseBtn, "Save & Close button clciked using actions click");
		}
	}

	public void clickOnRefreshBtn() {
		Boolean flag = false;
		while (!flag) {
			try {
				Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
				System.out.println("refresh button clicked");
				flag = true;
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}

	public void clickOnRefreshBtnOnHome() {
		eleUtil.waitForVisibilityOfElement(refreshBtn, 30);
		eleUtil.doClickLog(refreshBtn, "Clicked on refresh button present on the home page");
	}

	public void sortTheRecords(By Locator1, By Locator2, int tiemout) {

		try {
			Thread.sleep(3000);
			eleUtil.doElementClickable(Locator1, tiemout);
			eleUtil.doActionsClick(Locator1);
			// Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			eleUtil.doElementClickable(Locator2, tiemout);
			eleUtil.doActionsClick(Locator2);
			// Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

	public void getFirstRecord() {
		eleUtil.doDoubleClick(firstRecord);
		Log.info("clicked on first record");
	}

	public void selectFirstRecord() {
		try {
			Thread.sleep(2000);
			eleUtil.doActionsClick(firstRecord);
		} catch (InterruptedException e) {
			e.getMessage();
		}
		Log.info("selected the first record");
	}

	public void selectEntity(String entityname) {
		clickOnRefreshBtn();
		eleUtil.isPageLoaded(10);
		By nameoftheentity = By.xpath("//div[@title='" + entityname + "']");
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.getMessage(); }
		 */
		eleUtil.waitForVisibilityOfElement(nameoftheentity, 40);
		eleUtil.doElementClickable(nameoftheentity, 30);
		eleUtil.doClickLog(nameoftheentity, "Entity selected is " + entityname);
	}

	public void clickonNewBtn() {
		eleUtil.doElementClickable(newBtn, 30);
		eleUtil.doClickLog(newBtn, "Clicked on new button");
	}

	public void openACase() {
		changeAreaSelection("Inspection");
		selectEntity("Cases");
	}

	public void searchACase() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(searchbox, 20);
		Thread.sleep(2000);
		eleUtil.doSendKeysLog(searchbox, CommonActionsPage.casenumber, "Sending search crieteria to the textbox ");
		eleUtil.isPageLoaded(50);
		Thread.sleep(2000);
		driver.findElement(searchbox).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		selectFirstRecord();
		getFirstRecord();
	}

	public void changeView(String typeOfCases) {
		eleUtil.waitForVisibilityOfElement(changeViewIcon, 20);
		eleUtil.doElementClickable(changeViewIcon, 30);
		eleUtil.doClickLog(changeViewIcon, "Clicked on change view icon");
		By viewXpath = By.xpath("//label[contains(text(),'" + typeOfCases + "')]");
		eleUtil.waitForVisibilityOfElement(viewXpath, 20);
		eleUtil.doClickLog(viewXpath, "Clicked on " + typeOfCases);
	}

	public void navigatingToTab(String tabName) {

		By loc = By.xpath("//ul[@aria-label='Case Form']//li[@aria-label='" + tabName + "']");
		eleUtil.waitForVisibilityOfElement(loc, 30);
		eleUtil.doClickLog(loc, "Clicked on " + tabName);
	}

	public void navigatingToStage(String stageName) {
		By clickOnStage = By.xpath("//div[contains(@id,'stageNameContainer') and @title='" + stageName + "']");
		try {

			// Attempt standard click
			if (attemptStandardClick(clickOnStage)) {
				return; // Exit if standard click is successful
			}

			// Attempt JavaScript click
			if (attemptJavaScriptClick(clickOnStage)) {
				return; // Exit if Actions click is successful
			}

			// Attempt Actions click
			attemptActionsClick(clickOnStage);

		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}

	}

	private boolean attemptStandardClick(By locator) {
		try {
			eleUtil.doElementClickable(locator, 30);
			eleUtil.doClickLog(locator, "Clicked the element");
			Log.info("Standard click succeeded");
			return true; // Click was successful
		} catch (Exception e) {
			Log.error("Standard click failed: " + e.getMessage());
			return false; // Click failed
		}
	}

	private void attemptActionsClick(By locator) {
		try {
			eleUtil.doActionsClickLog(locator, "Clicked the element");
			Log.info("Actions click succeeded");

		} catch (Exception e) {
			Log.error("Actions click failed: " + e.getMessage());

		}
	}

	private boolean attemptJavaScriptClick(By locator) {
		try {
			jsutil.clickElementByJSLog(driver.findElement(locator), "Clicked the element");
			Log.info("JavaScript click succeeded");
			return true; // Click was successful
		} catch (Exception e) {
			Log.error("JavaScript click failed: " + e.getMessage());
			return false; // Click failed
		}
	}

	public void clickOnNextStageBtn() {
		eleUtil.waitForVisibilityOfElement(nextstageBtn, 10);
		eleUtil.doElementClickableLog(nextstageBtn, 10, "Next Stage button is clickable");
		eleUtil.doClickLog(nextstageBtn, "Clicked on next stage button");
	}

	public void clickOnloseIconOnBPF() {
		eleUtil.isPageLoadedLog(20, "Load the page in ");
		eleUtil.waitForVisibilityOfElement(closeBtnOnBPF, 30);
		eleUtil.doElementClickableLog(closeBtnOnBPF, 10, "Close icon is clickable");
		eleUtil.doActionsClickLog(closeBtnOnBPF, "Clicked on close button on BPF");
	}

	public String verifyBUField() {
		eleUtil.waitForVisibilityOfElement(BusinessFunctionField, 10);
		String BUField = eleUtil.doElementGetTextLog(BusinessFunctionField,
				"Selecte value in Business Function field is : ");
		return BUField;
	}

	public String verifyCaseTypeField() {
		eleUtil.waitForVisibilityOfElement(casetypeField, 10);
		String Casetype = eleUtil.doGetElementAttributeLog(casetypeField, "title",
				"Selecte value in Case Type field is : ");
		return Casetype;
	}

	public String verifyCaseSubTypeField() {
		eleUtil.waitForVisibilityOfElement(caseSubtypeField, 10);
		String CaseSubtype = eleUtil.doGetElementAttributeLog(caseSubtypeField, "title",
				"Selecte value in Case Sub Type field is : ");
		return CaseSubtype;
	}

	public String verifyCaseStatus() {
		String status = eleUtil.doElementGetText(statusField);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 30000) {
			try {
				Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
				eleUtil.waitForVisibilityOfElement(statusField, AppConstants.SHORT_DEFAULT_WAIT);
				status = eleUtil.doElementGetText(statusField);
				if (status.equals("Scheduled")) {
					flag = true;
				}
			} catch (Exception e) {
				Log.error("Status is not updated. So clicking on refresh button again");
			}
		}
		Log.info("Status is : " + eleUtil.doElementGetText(statusField));
		return eleUtil.doElementGetText(statusField);
	}

	public void clickOnEntityOnCaseForm() {
		eleUtil.waitForVisibilityOfElement(entityLink, 20);
		eleUtil.doClickLog(entityLink, "Clicked on entity link from Entity field present in case home page");
	}

	public void filterView(String value) {
		eleUtil.doClick(filterBy);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleUtil.doSendKeys(filterbyinputbox, value);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
	}

	public void clickOnNotificationIcon() {
		eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
		eleUtil.doClickLog(notificationIcon, "Clicked on notification bell icon");
	}

	public void clickOnCancelIconOnNotification() {
		try {
			eleUtil.doClickLog(cancelBtn, "Clicked on cancel icon on notification");
		} catch (Exception e) {
			eleUtil.doActionsClickLog(cancelBtn, "Clicked on cancel icon on notification");
		}
	}

	public void validateAlertContent(String alertText, String expectedContent) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By alertElement = By.xpath("//p[contains(text(),'" + alertText + "')]");
		wait.until(ExpectedConditions.elementToBeClickable(alertElement));
		String actualContent = driver.findElement(alertElement).getText();
		Log.info("Actual Alert Text is: " + actualContent);
		Log.info("Expected Alert Text is: " + expectedContent);
		assertTrue(actualContent.contains(expectedContent), "Alert content is not same");
	}

	public void handleNewTab(String attrVal, String caseNumber) {
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println("Open tabs: " + tabs.size());
		driver.switchTo().window(tabs.get(1));
		eleUtil.waitForVisibilityOfElement(By.xpath("//input[@title='" + caseNumber + "']"), 100);
		String valueAfterTaptoopenBtn = eleUtil.doGetElementAttribute(By.xpath("//input[@title='" + caseNumber + "']"),
				attrVal);
		System.out.println("After tap to open button: " + valueAfterTaptoopenBtn);
		assertTrue(valueAfterTaptoopenBtn.contains(caseNumber),
				"Case is not same after clicking on tap to open button");
		clickonSaveAndCloseBtn();
	}

	public void closeCurrentTabAndSwitchBack() {
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}

	public void tapToOpenBtn(String notificationText) {
		By tapToOpenButton = By
				.xpath("//p[contains(text(),'" + notificationText + "')]/../following-sibling::div//p/a");
		// p[contains(text(),'" + notificationText + "')]/a
		eleUtil.waitForVisibilityOfElement(tapToOpenButton, 100);
		eleUtil.doClickLog(tapToOpenButton, "Clicked on tap to open link");
	}

	public void validateNotification(String notificationText, String alertText, String expectedAlertContent, String val,
			String attrVal) throws InterruptedException {
		eleUtil.isPageLoaded(100);
		clickOnNotificationIcon();
		boolean isNotificationFound = false;
		long startTime = System.currentTimeMillis();

		while (!isNotificationFound && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);
				WebElement notificationElement = eleUtil
						.getElement(By.xpath("//p[contains(text(),'" + notificationText + "')]"));

				if (eleUtil.isClickable(notificationElement, 10)) {
					validateAlertContent(alertText, expectedAlertContent);
					tapToOpenBtn(notificationText);
					isNotificationFound = true;

					handleNewTab(attrVal, val);
					closeCurrentTabAndSwitchBack();
					clickOnCancelIconOnNotification();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!isNotificationFound) {
				System.out.println("Notification not found within 5 minutes, canceling.");
				clickOnCancelIconOnNotification();
			}
		}
	}

	public void manualCaseCreation(String caseSubType) throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(newBtn, 50);
		eleUtil.doElementClickable(newBtn, 20);
		jsutil.clickElementByJSLog(driver.findElement(newBtn),"Clicked on New button");
		eleUtil.waitForVisibilityOfElement(caseSubtypeField, 30);
		eleUtil.doElementClickableLog(caseSubtypeField, 30,"Element is clickable");
		eleUtil.createSelectLog(caseSubtypeField,"Clicked on Case Sub Type field");
		eleUtil.doSelectDropDownByVisibleTextLog(caseSubtypeField, caseSubType, "Selected dropdown value is : ");

		eleUtil.waitForVisibilityOfElement(entityLookupField, 50);
		eleUtil.doClickLog(entityLookupField, "Clicked on entity lookup field");
		eleUtil.doClearLog(entityLookupField,"Clear the field");

		if (BusinessFunctionField.equals("TP")) {
			System.out.println(CommonActionsPage.Tankercompanyname);
			eleUtil.doSendKeysLog(entityLookupField, CommonActionsPage.Tankercompanyname,"Entered text is : ");
		} else {
			System.out.println(CommonActionsPage.WRN1_factoryname);
			eleUtil.doSendKeysLog(entityLookupField, CommonActionsPage.WRN1_factoryname,"Entered text is : ");
		}
		Thread.sleep(25000);
		By tankercompanyxpath = By.xpath("//li[contains(@data-id,'customerid')]");
		eleUtil.doActionsMoveToElement(tankercompanyxpath,"Selected the value from lookup");
		clickOnSaveBtn();

		eleUtil.isPageLoaded(30);

		Thread.sleep(4000);
		CommonActionsPage.casenumber = eleUtil.doGetElementAttribute(caseid, "title");
		Log.info("updated case number : " + CommonActionsPage.casenumber);
	}

}
