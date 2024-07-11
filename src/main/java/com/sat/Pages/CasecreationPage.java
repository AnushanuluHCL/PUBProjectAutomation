package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.constants.AppConstants;

public class CasecreationPage extends CommonActionsPage {
	/*
	 * private WebDriver driver; private Properties prop; private ElementUtil
	 * eleUtil; private TestBase testbase; private JavaScriptUtil jsutil; private
	 * CommonActionsPage common; private ApplicationPage apppage;
	 */
	// public static String WOnumber, casenumber, starttimeval;
	// public static List<String> WOnumberlist;
	// Locators on application page
	private By createdApp = By.xpath("(//div[@col-id='pub_gwccompany']//descendant::a)[2]"); // (//div[@col-id='pub_gwccompany'])[2]
	private By changeViewIcon = By.xpath("//span[text()='Open popup to change view.']//following-sibling::i");
	private By AcceptedApplicaion = By.xpath("//label[text()='Accepted applications']");

	// Locators from case form'
	private By entitydropdown = By.xpath("(//div[@col-id='customerid'])[1]");
	private By entityName = By.xpath("(//div[@col-id='customerid'])[2]");
	private By filterBy = By.xpath("//span[text()='Filter by']");
	private By filterbyinputbox = By.xpath("//input[@aria-label='Filter by value']");
	private By suggestionbox = By.xpath("//div[contains(@class,'suggestionTextOverflow')]");
	private By applyBtn = By.xpath("//span[text()='Apply']");
	private By entitynameOnCaseForm = By.xpath("(//div[@col-id='customerid']//a)[1]");
	private By caseidOnCaseForm = By.xpath("//div[@col-id='title']//a"); // (//div[@col-id='title'])[2]
	private By entityIdOnCaseHome = By.xpath("//ul[@title='Entity']");

	private By firstRecord = By.xpath("(//input[contains(@aria-label,'elect or deselect the row')])[1]");
	// "(//input[@aria-label='Select or deselect the row'])[1] |
	// (//input[@aria-label='select or deselect the row'])[1]");
	private By saveBtn = By.xpath("//button[@aria-label='Save (CTRL+S)']");
	private By saveCloseBtn = By.xpath("//button[@aria-label='Save & Close']");
	private By createdonCol = By.xpath("//div[text()='Created On']");
	private By NewToOldCol = By.xpath("//span[text()='Sort newer to older']");
	private By refreshBtn = By.xpath("//button[@aria-label='Refresh']");
	private By backBtn = By.xpath("//button[@title='Go back']");

	// Locators on case form home page
	private By searchbox = By.xpath("//input[@aria-label='Case Filter by keyword']");
	private By caseid = By.xpath("//input[@aria-label='Case ID']");
	private By BusinessFunctionField = By.xpath("//ul[@title='Business Function']");
	private By casetypeField = By.xpath("//select[@aria-label='Case Type']");
	private By caseSubtypeField = By.xpath("//select[@aria-label='Case Sub Type']");
	private By createdonField = By.xpath("//input[@aria-label='Date of Created On']");
	private By caseSOField = By.xpath("//ul[@title='Case SO']");
	private By caseAOField = By.xpath("//ul[@title='Case AO']");
	private By caseFIOField = By.xpath("//ul[@title='Case FIO']");
	private By statusField = By.xpath("//div[text()='Status']/preceding-sibling::div");
	private By caseSubtypefromTop = By.xpath("//div[text()='Case Sub Type']/preceding-sibling::div");
	private By ownerField = By.xpath("//div[text()='Owner']/preceding-sibling::div");
	private By caseIDAtTop = By.xpath("//div[text()='Case ID']/preceding-sibling::div");
	private By GwcRefNum = By.xpath("//input[@aria-label='GWC Reference Number']");

	// user roles update
	private By SOname = By.xpath("//input[contains(@aria-label,'Case SO, Lookup')]"); // div[contains(@data-id,'pub_caseso.fieldControl')]
	private By AOname = By.xpath("//div[contains(@data-id,'pub_caseao.fieldControl')]");
	private By FIOname = By.xpath("//div[contains(@data-id,'pub_casefio.fieldControl')]");

	// button[contains(@aria-label,'Search records for Case FIO')] - search records
	// for casse FIO field
	// Locators on case form tabs
	private By workorderTab = By.xpath("//ul[@aria-label='Case Form']//li[@aria-label='Work Orders']");
	private By allTabs = By.xpath("//ul[@aria-label='Case Form']");
	private By wostatusField = By.xpath("(//div[@col-id='msdyn_systemstatus'])[2]");

	// Locators on BPF stage on case form
	private By nextstageBtn = By.xpath("//div[contains(@id,'nextButton')]");
	private By assignmentStage = By.xpath("//div[@title='Assignment']");
	private By confirmInspectionScheduleOption = By.xpath("//select[@aria-label='Confirm Inspection Schedule']"); // visible
																													// text
																													// Yes/No
	private By InspectionStage = By.xpath("//div[@title='Inspection']");
	private By inspectionCompletedOption = By.xpath("//select[@aria-label='Inspection Completed?']"); // visible text
																										// Yes/No
	private By generateInspectionReportOption = By.xpath("//select[@aria-label='Generate Inspection Report']"); // visible
																												// text
	private By closeBtnOnBPF = By.xpath("//button[@title='Close']"); // Yes/No
	private By submitSOreviewBtn = By.xpath("//select[contains(@id,'header') and @aria-label='Submit for SO Review']");
	private By SOreviewStage = By.xpath("//div[@title='SO Review']");
	private By systemassesmentOption = By.xpath("//select[@aria-label='System Assessment']"); // visible text Yes/No
	private By userassesmentOption = By.xpath("//select[@aria-label='User Assessment']"); // visible text Yes/No
	private By submitAOreviewBtn = By
			.xpath("//select[contains(@id,'header') and @aria-label='Approve and Send for AO Review']"); // visible text
	// Yes/No
	private By AOreviewStage = By.xpath("//div[@title='AO Review']");
	private By AOresponseOption = By.xpath("//select[@aria-label='AO Response']"); // visible text Yes/No
	private By generateemailStage = By.xpath("//div[@title='Generate Email']");
	private By generateemailOption = By.xpath("//select[@aria-label='Generate Email']"); // visible text Yes/No
	private By emailtocustomerOption = By.xpath("//select[@aria-label='Email Sent to Customer?']"); // visible text
																									// Yes/No
	private By endoresementreceivedOption = By.xpath("//select[@aria-label='Endoresement Received?']"); // visible text
																										// Yes/No
	private By closeStage = By.xpath("//div[@title='Close']");
	private By resolvecaseOption = By.xpath("//select[@aria-label='Resolve Case']"); // visible text Yes/No
	private By finishBtn = By.xpath("//button[@aria-label='Finish']");

	// Locators for Alerts
	private By notificationIcon = By.xpath("//button[@aria-label='Notifications']");
	private By scheduleWOAlert = By.xpath("//p[text()='You Have been scheduled for  Work Order 03543. ']");
	// private By taptoopenBtn = By.xpath("//p[text()='You Have been scheduled for
	// Work Order 03543. ']/a");
	private By cancelBtn = By.xpath("//i[@data-icon-name='Cancel']");
	private By workordertext = By.xpath("//input[@aria-label='Work Order Number']");

	// Locators on WorkOrder tab
	private By WONumber = By.xpath("//div[@col-id='msdyn_name']//descendant::a");// (//div[@col-id='msdyn_name'])[2]
	private By appTankerName = By.xpath("//div[@col-id='pub_applicationtankerid']//descendant::a");
	private By gwctankername = By.xpath("//div[@col-id='pub_tankerid']//descendant::a");
	private By wostatus = By.xpath("(//div[@col-id='msdyn_systemstatus'])[2]");
	private By isComplaintchk = By.xpath("//label[contains(@class,'ms-Label twoOptionRootStyles-')]");

	// Locators on work order form
	private By bookingTab = By.xpath("//li[text()='Bookings']");
	private By servicetasksTab = By.xpath("//li[text()='Checklist']");// li[text()='Service Tasks']
	private By summaryTab = By.xpath("//li[text()='Summary']");
	private By WOstatusInWOform = By.xpath(
			"//select[@aria-label='WO Status']//ancestor::div[@data-lp-id='MscrmControls.FieldControls.OptionSet|msdyn_systemstatus.fieldControl|msdyn_workorder']");
	private By isComplaintchkInWOfrom = By.xpath("//select[@aria-label='Is Compliant?']");
	private By tankerNumberInWOform = By
			.xpath("//ul[@title='Tanker']//descendant::div[contains(@data-id,'pub_tankerid')]//child::div");
	private By tankerregno = By.xpath("//label[text()='Tanker Registration No.']");
	// Locators on tanker form
	private By permitnum = By.xpath("(//div[contains(@col-id,'pub_permit')])[2]//a");// div[@col-id='pub_permit']//a
	private By letterdate = By.xpath("(//div[contains(@col-id,'pub_letterdate')])[2]//label");
	private By expirydate = By.xpath("(//div[contains(@col-id,'pub_expirydate')])[2]//label");

	// Locators on Bookings tab
	private By resourceField = By.xpath("//div[@col-id='resource']/descendant::a");
	private By starttimeField = By.xpath("(//div[@col-id='starttime']/descendant::label)[2]"); // (//div[@col-id='starttime'])[2]
	private By endtimeField = By.xpath("(//div[@col-id='endtime'])[2]");
	private By durationField = By.xpath("(//div[@col-id='duration'])[2]");

	// Locators on Bookings home page
	private By maximizescreenBtn = By.xpath("//button[@aria-label='Enter full screen mode']");
	private By bookingStatusField = By.xpath("//div[contains(@data-id,'CC_BookingStatusControl_Title_')]");// div[contains(@data-id,'CC_BookingStatusControl_Title_')]
	private By bookingStatusOption = By.xpath("//div[@aria-label='Booking Status Control']");

	private By startDateField = By.xpath("//input[@aria-label='Date of Start Time']");
	private By startTimeonBooking = By.xpath("//input[@aria-label='Time of Start Time']");
	private By actualDateField = By.xpath("//input[@aria-label='Date of Actual Arrival Time']");
	private By actualTimeField = By.xpath("//input[@aria-label='Time of Actual Arrival Time']");
	private By durationFieldOnBooking = By.xpath("//input[@aria-label='Duration']");
	private By selectStartdateVal = By.xpath("//td[@aria-current='date']");
	private By selectStarttimeval = By.xpath("//input[@aria-label='Time of Start Time']/following-sibling::button");
	private By selectactualtimeVal = By
			.xpath("//input[@aria-label='Time of Actual Arrival Time']/following-sibling::button");
	private By saveNCloseOnBooking = By
			.xpath("//span[text()='Save and close this Bookable Resource Booking.']/preceding-sibling::button");
	private By saveOnBooking = By
			.xpath("//span[text()='Save this Bookable Resource Booking.']/preceding-sibling::button");
	private By notestab = By.xpath("//li[@aria-label='Notes']");
	private By signature_box = By.xpath("//div[contains(@data-id,'msdyn_signature')]//canvas"); // canvas[@aria-label='Signature']
	private By confirmBtn = By.xpath("//span[text()='Confirm']"); // span[text()='Confirm']/ancestor::button
	private By servicetab = By.xpath("//li[@aria-label='Service']");

	// Locators on service tasks home page
	private By checklisttypeField = By.xpath("//div[@col-id='msdyn_inspection']/descendant::a");
	private By checklistNameField = By.xpath("//div[@col-id='msdyn_name']/descendant::a");

	// Locators on checklist questions home page
	private By oldSealnumField = By.xpath("//td[@title='Old Seal Number']");
	private By newSealnumField = By.xpath("//input[@aria-label='New Seal Number']");
	private By photosTakendropdownField = By.xpath("//select[@aria-label='Photos taken']"); // visible text Yes/No
	private By markcompleteBtn = By.xpath("//button[contains(@title,'Set Task as fully completed')]");// button[contains(@title,'Set
																										// task as fully
																										// completed and
																										// save and
																										// close
																										// record')]
	private By saveBtnInChklsit = By.xpath("//button[contains(@title,'Save this Work Order Service Task.')]");
	private By saveNCloseBtnInChklsit = By
			.xpath("//button[contains(@title,'Save and close this Work Order Service Task.')]");

	// Locators mail
	private By viewmoreBtn = By.xpath("//a[@aria-label='Open Record']");
	private By mailFrom = By.xpath("//ul[@title='From']//li/child::div");
	private By mailTo = By
			.xpath("//ul[@title='To']//li/child::div[contains(@id,'to.fieldControl-LookupResultsDropdown')]");
	private By mailSubject = By.xpath("//input[@aria-label='Subject']");
	private By mailBody = By.xpath("//body[@aria-label='Press ALT 0 for help']");
	private By mailframeLoc = By.xpath("//iframe[@aria-label='Description rich text editor']");
	private By attachment = By.xpath("//button[contains(@class,'ms-Link')]/div"); // div[contains(@class,'ms-List-page')]

	// Locators on Docuemnts tab
	private By attachBtn = By.xpath("//span[text()='Attach']/ancestor::button");
	private By browseBtn = By.xpath("//span[text()='Browse']/ancestor::button");
	private By browsefield = By.xpath("(//span[text()='Browse']/ancestor::div[@style])[3]//input");
	private By uploadBtn = By.xpath("//span[text()='Upload']/ancestor::button");

	private By okBtn = By.xpath("//button[@aria-label='OK']");

	public CasecreationPage(WebDriver driver) {
		super(driver);
		/*
		 * this.driver = driver; eleUtil = new ElementUtil(this.driver); jsutil = new
		 * JavaScriptUtil(this.driver); prop = eleUtil.readProperties(); common = new
		 * CommonActionsPage(TestBase.getDriver()); apppage = new
		 * ApplicationPage(TestBase.getDriver());
		 */
	}

	public void caseCreatioCheck() throws InterruptedException {
		// sortTheRecords(createdonCol, NewToOldCol, AppConstants.LONG_DEFAUTT_WAIT);
		eleUtil.doClick(changeViewIcon);
		eleUtil.doClick(AcceptedApplicaion);
		eleUtil.waitForVisibilityOfElement(createdApp, 50);
		String entitynameFromApplication = eleUtil.doGetElementAttribute(createdApp, "aria-label");
		changeAreaSelection("Inspection");
		selectEntity("Cases");
		// sortTheRecords(createdonCol, NewToOldCol, AppConstants.LONG_DEFAUTT_WAIT);
		eleUtil.waitForVisibilityOfElement(entityName, 50);
		eleUtil.doElementClickable(entitydropdown, 20);
		eleUtil.doClick(entitydropdown);
		eleUtil.doClick(filterBy);
		eleUtil.doSendKeys(filterbyinputbox, CommonActionsPage.Tankercompanyname);
		Thread.sleep(3000);
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
		eleUtil.doClick(applyBtn);
		// selectFirstRecord(firstRecord, 20);
		eleUtil.waitForVisibilityOfElement(entitynameOnCaseForm, 30);
		String entitynameonCase = eleUtil.doGetElementAttribute(entitynameOnCaseForm, "aria-label");
		System.out.println("entitynameonCase - " + entitynameonCase + "tankercompanyname - "
				+ CommonActionsPage.Tankercompanyname);
		Assert.assertEquals(entitynameonCase, CommonActionsPage.Tankercompanyname);
		System.out.println("Case created successfully");
		CommonActionsPage.casenumber = getcaseID();
		assertTrue(CommonActionsPage.casenumber.startsWith("DQB/TP/I"), "Case number format is not expected");
		System.out.println(CommonActionsPage.casenumber);
	}

	public String getcaseID() {
		String str = eleUtil.doElementGetText(caseidOnCaseForm);
		return str;
	}

	public String getTankercompanyname() {
		String str = eleUtil.doElementGetText(entitynameOnCaseForm);
		return str;
	}

	public List<String> getWONumber() {

		/*
		 * eleUtil.waitForVisibilityOfElement(WONumber, 10); String str f=
		 * eleUtil.doElementGetText(WONumber); System.out.println("work order number is"
		 * + str); return str;
		 */

		// By ele = By.xpath("//div[@col-id='msdyn_name']//descendant::a");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> myList = driver.findElements(By.xpath("//div[@col-id='msdyn_name']//descendant::a"));
		List<String> all_elements_text = new ArrayList<>();
		// System.out.println(myList.size());
		for (int i = 1; i <= myList.size(); i++) {
			By ele2 = By.xpath("(//div[@col-id='msdyn_name']//descendant::a)[" + i + "]");
			String wonumlist = eleUtil.doGetElementAttribute(ele2, "aria-label");
			all_elements_text.add(wonumlist);
		}
		System.out.println("List of work orders is :" + all_elements_text);
		return all_elements_text;

	}

	/*
	 * public String getTankername() {
	 * 
	 * eleUtil.waitForVisibilityOfElement(appTankerName, 10); String str =
	 * eleUtil.doElementGetText(appTankerName);
	 * System.out.println("Tanker number is" + str); return str;
	 * 
	 * }
	 */

	public void caseFormValidation() throws InterruptedException {
		// selectFirstRecord(firstRecord, AppConstants.SHORT_DEFAUTT_WAIT);
		// getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAUTT_WAIT);
		eleUtil.isPageLoaded(100);
		eleUtil.doClick(caseidOnCaseForm);
		Thread.sleep(1000);

		eleUtil.waitForVisibilityOfElement(BusinessFunctionField, 10);
		String BUField = eleUtil.doElementGetText(BusinessFunctionField);
		String casenumber = eleUtil.doGetElementAttribute(caseid, "value");
		System.out.println("case number from FIO user:" + casenumber);
		String Casetype = eleUtil.doElementGetText(casetypeField);
		String CaseSubtype = eleUtil.doElementGetText(caseSubtypeField);
		String Createdon = eleUtil.doGetElementAttribute(createdonField, "Value");
		String CaseSO = eleUtil.doElementGetText(caseSOField);
		String CaseAO = eleUtil.doElementGetText(caseAOField);
		String CaseFIO = eleUtil.doElementGetText(caseFIOField);
		String status = eleUtil.doElementGetText(statusField);
		System.out.println("status field" + status);
		String caseSubtypeonTop = eleUtil.doElementGetText(caseSubtypefromTop);
		/*
		 * String ownerFiledVal = eleUtil.doElementGetText(ownerField);
		 * System.out.println("Owner field" + ownerFiledVal);
		 */ // change happen in 03/03- this field is removed and in that place case id came
		String caseIDfieldval = eleUtil.doElementGetText(caseIDAtTop);
		System.out.println("case id at top" + caseIDfieldval);
		String GWCRefNumVal = eleUtil.doElementGetText(GwcRefNum);

		assertTrue(BUField.contains("WRN5"), "BU is not same");
		assertTrue(Casetype.contains("Inspection Case"), "Case type is not same");
		assertTrue(CaseSubtype.contains("Tanker Permit Inspection"), "Case sub type is not same");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
		// String currentDateTime = formatter.format(date);
		// java.util.Calendar.getInstance(java.util.TimeZone.getDefault()).getTime();
		Date d = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("IST")).getTime(); // UTC
		String currentDateTime = formatter.format(d);
		// assertTrue(Createdon.contains(currentDateTime), "Created on is not same");
		assertTrue(CaseSO.contains("SIES DEV3"), "SO is not same");
		assertTrue(CaseAO.contains("SIES DEV1"), "AO is not same");
		assertTrue(CaseFIO.contains("SIES DEV2"), "FIO is not same");

		/*
		 * Thread.sleep(3000);
		 * 
		 * eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAUTT_WAIT);
		 * eleUtil.waitForVisibilityOfElement(statusField,AppConstants.
		 * SHORT_DEFAUTT_WAIT); Thread.sleep(3000);
		 */
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 30000) {
			// Boolean flag = false;
			// while (!flag) {
			try {
				Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAUTT_WAIT);
				eleUtil.waitForVisibilityOfElement(statusField, AppConstants.SHORT_DEFAUTT_WAIT);
				status = eleUtil.doElementGetText(statusField);
				if (status.equals("Scheduled")) {
					flag = true;
					// assertTrue(status.contains("Scheduled"), "status is not same");
					softassert.assertTrue(status.contains("Scheduled"), "status is not same");
					break;
				}
			} catch (Exception e) {
				// e.getMessage();
				System.out.println("Exceptrion:" + e);
			}
		}
		// System.out.println("status is :" + status);
		// assertTrue(status.contains("Scheduled"), "status is not same");

		// assertTrue(ownerFiledVal.contains("SIES DEV2"), "Owner field value is not
		// matching");
		// softassert.assertTrue(ownerFiledVal.contains("SIES DEV2"), "Owner field value
		// is not matching");
		softassert.assertAll();
		assertTrue(caseSubtypeonTop.contains("Tanker Permit Inspection"), "Case sub type from top is not same");
		CommonActionsPage.GWCReferenceNum = GWCRefNumVal;
	}

	public void rolesUpdate() {
		// driver.findElement(By.xpath("//div[contains(@data-id,'pub_caseso.fieldControl')]")).clear();
		// button[@aria-label="Delete # Nabeela Almas Khan Zubair Ahmed Khan"]
		// data-id="pub_caseso.fieldControl-LookupResultsDropdown_pub_caseso_selected_tag_delete"
		// eleUtil.doClick(SOname);
		// WebElement ele=driver.findElement(By.xpath("//ul[@title='Case SO']"));
		// jsutil.scrollIntoView(driver.findElement(By.xpath("//ul[@title='Case
		// SO']")));
		// JavascriptExecutor js=(JavascriptExecutor)driver;

		eleUtil.waitForVisibilityOfElement(By.xpath("//ul[@title='Case SO']"), 50);
		// js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//ul[@title='Case SO']"))).build().perform();
		// eleUtil.waitForVisibilityOfElement(By.xpath("//ul[@title='Case SO']"), 20);
		// eleUtil.doClearUsingKeys(By.xpath("//ul[@title='Case SO']"));
		eleUtil.doClick(By.xpath("//button[contains(@aria-label,'Delete')]"));
		// eleUtil.doClick(By.xpath("//span[contains(@data-id,'searchButton')]"));// -->
		// search
		eleUtil.waitForVisibilityOfElement(SOname, 20);
		eleUtil.doClick(SOname);
		eleUtil.doSendKeys(SOname, "Siesdev3@PUBSIES.onmicrosoft.com");
		System.out.println("about to click");
		driver.findElement(SOname).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		System.out.println("clicked");
		/*
		 * try { eleUtil.doSendKeys(SOname, "Siesdev3@PUBSIES.onmicrosoft.com");
		 * eleUtil.doClear(AOname); eleUtil.doSendKeys(AOname,
		 * "svc_sies_test_user1@PUB003.onmicrosoft.com"); eleUtil.doClear(FIOname);
		 * eleUtil.doSendKeys(FIOname, "svc_sies_test_user2@PUB003.onmicrosoft.com"); }
		 * catch (Exception e) { System.out.println("method failed"); }
		 */
	}

	public void openACase() {
		changeAreaSelection("Inspection");
		selectEntity("Cases");
		// sortTheRecords(createdonCol, NewToOldCol,
		// AppConstants.LONG_DEFAUTT_WAIT);//commented on 02/14
	}

	public void searchACase() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(searchbox, 20);
		Thread.sleep(2000);
		eleUtil.doSendKeys(searchbox, CommonActionsPage.casenumber);

		// eleUtil.doSendKeys(searchbox, "DQB/TP/I/2024/11744"); // DQB/TP/I/2024/4226
		// eleUtil.isPageLoaded(50);
		Thread.sleep(2000);

		driver.findElement(searchbox).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		selectFirstRecord(firstRecord, AppConstants.SHORT_DEFAUTT_WAIT);
		getFirstRecord(firstRecord, AppConstants.SHORT_DEFAUTT_WAIT);
	}

	public void navigatingtotab(String tabName) {
		/*
		 * eleUtil.waitForVisibilityOfElement(workorderTab, 10);
		 * eleUtil.doClick(workorderTab);
		 */

		By loc = By.xpath("//ul[@aria-label='Case Form']//li[@aria-label='" + tabName + "']");
		// eleUtil.isPageLoaded(20);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eleUtil.waitForVisibilityOfElement(loc, 20);
		WebElement tab = driver.findElement(loc);
		tab.click();
		// CommonActionsPage.WOnumber = getWONumber();
		// CommonActionsPage.TankerName = getTankername();
	}

	public void navigatingtoStage(String stageName) {
		By clickOnStage = By.xpath("//div[@title='" + stageName + "']");
		eleUtil.doElementClickable(clickOnStage, 30);
		try {
			eleUtil.doClick(clickOnStage);
		} catch (Exception e) {
			eleUtil.doActionsClick(clickOnStage);
		}

	}

	public void validateWOScheduleNotification() throws InterruptedException {

		CommonActionsPage.WOnumber = getWONumber();// This is place we need to declare wonumber once alerts code is
													// included
		List<String> wonum = CommonActionsPage.WOnumber;
		for (int i = 0; i < wonum.size(); i++) {
			eleUtil.isPageLoaded(100);
			eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
			eleUtil.doClick(notificationIcon);
			Boolean flag = false;
			long startTime = System.currentTimeMillis();
			while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
				try {
					Thread.sleep(3000);
					WebElement WOalert = driver.findElement(
							By.xpath("//p[text()='You Have been scheduled for  Work Order " + wonum.get(i) + ". ']"));
					if (eleUtil.isClickable(WOalert, 10)) {
						String actualAlertcontent = WOalert.getText();
						// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAUTT_WAIT);
						System.out.println("actualAlertcontent" + actualAlertcontent);
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						wait.until(ExpectedConditions.elementToBeClickable(WOalert));

						/*
						 * if (!actualAlertcontent.isEmpty()) { // flag = true; actualAlertcontent =
						 * WOalert.getText(); // break;
						 * 
						 * }
						 */
						String ExpectedAlertContent = "You Have been scheduled for Work Order " + wonum.get(i)
								+ ". \"Tap to open\".";
						System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
						assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
						WebElement taptoopenBtn = driver.findElement(By.xpath(
								"//p[text()='You Have been scheduled for  Work Order " + wonum.get(i) + ". ']/a"));
						taptoopenBtn.click();
						flag = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			System.out.println("open tabs" + tabs.size());
			driver.switchTo().window(tabs.get(1));
			// Thread.sleep(10000);
			eleUtil.waitForVisibilityOfElement(workordertext, 100);
			String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(workordertext, "Value");
			System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
			assertTrue(afterTaptoOpenBtn.contains(wonum.get(i)), "WO is not same after clicking on tap to open button");
			System.out.println(tabs.size() - 1);
			// driver.switchTo().window(tabs.get(tabs.size() - 2));
			eleUtil.doElementClickable(saveCloseBtn, 20);
			eleUtil.doClick(saveCloseBtn);
			driver.switchTo().window(tabs.get(0));
			eleUtil.doClick(cancelBtn);
		}
	}

	public void switchTab() {
		// driver.get("http://yahoo.com");
		JavascriptExecutor we = ((JavascriptExecutor) driver);
		we.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// driver.close();
		// driver.get("http://google.com");
		// System.out.println("in new tab method");

	}

	public void switchToActiveTab() {
		// driver.get("http://yahoo.com");
		JavascriptExecutor we = ((JavascriptExecutor) driver);
		we.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());
		System.out.println(tabs.size() - 1);
		driver.switchTo().window(tabs.get(tabs.size() - 1));
	}

	public void fillBookingDeatils() throws InterruptedException {
		navigatingtotab("Work Orders");
		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("size is:" + wonum.size());
		for (int i = 0; i < wonum.size(); i++) {
			Thread.sleep(2000);
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);
			eleUtil.waitForVisibilityOfElement(workordertext, 30);
			String actualWO = eleUtil.doGetElementAttribute(workordertext, "value");
			System.out.println("actual WO:" + actualWO);
			System.out.println("expected wo:" + wonum.get(i));
			assertTrue(actualWO.contains(wonum.get(i)), "WO is not same");

			// Validation on Booking tab
			eleUtil.doClick(bookingTab);
			Thread.sleep(2000);
			selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAUTT_WAIT);
			getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAUTT_WAIT);
			// clickOnRefrehBtn();
			eleUtil.doElementClickable(maximizescreenBtn, 10);
			eleUtil.doClick(maximizescreenBtn);
			eleUtil.doElementClickable(bookingStatusField, 30);
			eleUtil.doClick(bookingStatusField);
			// eleUtil.doClick(bookingStatusOption);
			By selectAnOption = By.xpath("//button[@title='In Progress']");
			eleUtil.waitForVisibilityOfElement(selectAnOption, 100);
			eleUtil.doClick(selectAnOption);

			eleUtil.doElementClickable(saveOnBooking, 10);
			eleUtil.doClick(saveOnBooking);
			Thread.sleep(5000);
			signTheChecklist();

			/*
			 * eleUtil.doElementClickable(servicetab, 100);
			 * eleUtil.doActionsClick(servicetab); fillTheChecklistquestions(outcome);
			 */

			eleUtil.doElementClickable(saveNCloseOnBooking, 10);
			eleUtil.doClick(saveNCloseOnBooking);

			try {
				eleUtil.doClick(saveCloseBtn);
			} catch (Exception e) {
				eleUtil.doActionsClick(saveCloseBtn);
			}

		}
	}

	public void workOrderValidation() throws InterruptedException, ParseException {
		// CommonActionsPage.WOnumber = getWONumber();// this line should be removed
		// when we are including code for alert
		// validation
		// CommonActionsPage.TankerName = getTankername(); //this code added in NEA list
		// as per new changes
		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("size is:" + wonum.size());
		for (int i = 0; i < wonum.size(); i++) {
			Thread.sleep(2000);
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);
			By ele = By.xpath("//button[@aria-label='Dismiss Teaching Bubble']");
			Thread.sleep(5000);
			List<WebElement> li = driver.findElements(By.xpath("//button[@aria-label='Dismiss Teaching Bubble']"));
			System.out.println(li.size());
			if (li.size() > 0) {
				eleUtil.waitForVisibilityOfElement(ele, AppConstants.LONG_DEFAUTT_WAIT);
				li.get(0).click();
			} else {
				System.out.println("no alert present");
			}

			// driver.findElement(ele).click();
			String actualWO = eleUtil.doGetElementAttribute(workordertext, "title");
			System.out.println("actual WO:" + actualWO);
			System.out.println("expected wo:" + wonum.get(i));
			assertTrue(actualWO.contains(wonum.get(i)), "WO is not same");

			// Validation on Booking tab
			eleUtil.doClick(bookingTab);
			eleUtil.waitForVisibilityOfElement(ele, 30);
			// System.out.println(li.size());
			if (li.size() > 0) {
				eleUtil.waitForVisibilityOfElement(ele, AppConstants.MEDIUM_DEFAUTT_WAIT);
				li.get(0).click();
			} else {
				System.out.println("no alert present");
			}
			eleUtil.waitForVisibilityOfElement(starttimeField, 10);
			String starttimeval = eleUtil.doElementGetText(starttimeField);
			String durationVal = eleUtil.doElementGetText(durationField);
			if (starttimeval.contains("9:00 am")) {
				System.out.println("start time is " + starttimeval);
			} else {
				System.out.println("start time is not 9 AM");
			}
			assertEquals(durationVal, "2 hours", "WO duration is not 2 hours");

			Thread.sleep(2000);
			selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAUTT_WAIT);
			getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAUTT_WAIT);
			// clickOnRefrehBtn();
			eleUtil.doElementClickable(maximizescreenBtn, 10);
			eleUtil.doClick(maximizescreenBtn);
			eleUtil.doElementClickable(bookingStatusField, 30);
			eleUtil.doClick(bookingStatusField);
			// eleUtil.doClick(bookingStatusOption);
			By selectAnOption = By.xpath("//button[@title='In Progress']");
			eleUtil.waitForVisibilityOfElement(selectAnOption, 100);
			eleUtil.doClick(selectAnOption);

			String startDatevalOnHome = eleUtil.doGetElementAttribute(startDateField, "Value");
			String starttimevalOnHome = eleUtil.doGetElementAttribute(startTimeonBooking, "Value");
			String durationValOnHome = eleUtil.doGetElementAttribute(durationFieldOnBooking, "title");
			System.out.println("start date on bookings page:" + startDatevalOnHome);

			// assertTrue(starttimevalOnHome.contains("9:00 AM"), "WO start time is not 9:00
			// AM");
			assertTrue(durationValOnHome.contains("2 hours"), "WO duration is not 2 hours");

			eleUtil.doClearUsingKeys(actualDateField);
			eleUtil.doSendKeys(actualDateField, startDatevalOnHome);
			driver.findElement(actualDateField).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			System.out.println("starttimevalOnHome" + starttimevalOnHome);
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm a");
			// SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
			Date date = timeFormat.parse(starttimevalOnHome);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MINUTE, 10);
			String result = timeFormat.format(cal.getTime());
			System.out.println(result);

			// eleUtil.doClick(actualTimeField);
			// eleUtil.doClick(selectactualtimeVal);
			eleUtil.doElementClickable(actualTimeField, 30);
			eleUtil.doClick(actualTimeField);
			By actualtime = By.xpath("//input[contains(@id,'msdyn_actualarrivaltime_fabric_combobox')]");
			eleUtil.doClearUsingKeys(actualtime);
			eleUtil.doSendKeys(actualtime, result);

			eleUtil.doElementClickable(saveOnBooking, 10);
			eleUtil.doClick(saveOnBooking);
			Thread.sleep(5000);
			signTheChecklist();

			eleUtil.doElementClickable(saveNCloseOnBooking, 10);
			eleUtil.doClick(saveNCloseOnBooking);

			/*
			 * List<WebElement> li =
			 * driver.findElements(By.xpath(."//button[@aria-label='Save & Close']")); for
			 * (int k = 0; k < li.size(); k++) { if (eleUtil.isClickable(li.get(i), 10)) {
			 * System.out.println(eleUtil.isClickable(li.get(i), 10)); //li.get(i).click();
			 * Actions a=new Actions(driver);
			 * a.moveToElement(li.get(i)).click().build().perform(); } }
			 */

			CommonActionsPage.starttimeval = getStarttime();
			System.out.println("start time after creating a booking record is:" + CommonActionsPage.starttimeval);
			CommonActionsPage.startdateval = getStartdate();
			System.out.println("start date after creating a booking record is:" + CommonActionsPage.startdateval);
			Thread.sleep(5000);
			eleUtil.doClick(saveCloseBtn);

			// eleUtil.isPageLoaded(50);

		}
	}

	public String getStartdate() {
		String val = eleUtil.doElementGetText(starttimeField);
		System.out.println("Length is: " + val.length());
		if (val.length() == 16) {
			String startdateval = val.substring(0, 8);// 1/3/2024 9:00 amountOfGWWastetypeTanker}
			System.out.println("startdateval" + startdateval);
			return startdateval;
		} else {
			String startdateval = val.substring(0, 9);
			System.out.println("startdateval" + startdateval);
			return startdateval;
		}

	}

	public String getStarttime() {
		String val = eleUtil.doElementGetText(starttimeField);
		if (val.length() == 16) {
			String starttimeval = val.substring(9);// 1/3/2024 9:00 am 11/3/2024 9:00 am
			return starttimeval;
		} else {
			String starttimeval = val.substring(10);
			return starttimeval;
		}
	}

	public void signTheChecklist() {
		// Below 2 steps need to be included once signature box is moved to checklist
		// selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAUTT_WAIT);
		// getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAUTT_WAIT);
		eleUtil.doElementClickable(notestab, 100);
		eleUtil.doActionsClick(notestab);
		eleUtil.doElementClickable(signature_box, 20);
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(driver.findElement(signature_box), 135, 0).build().perform();
		eleUtil.doElementClickable(confirmBtn, 30);
		eleUtil.doClick(confirmBtn);
	}

	public void fillTheChecklistquestions(String outcome) {
		/*
		 * List<Map<String, String>> data = chklistdata.asMaps(String.class,
		 * String.class); for (Map<String, String> form : data) { String Q1Val =
		 * form.get("Q1"); String Q2Val = form.get("Q2"); String Q3Val = form.get("Q3");
		 * String Q4Val = form.get("Q4"); String Q5Val = form.get("Q5"); String Q6Val =
		 * form.get("Q6"); String Q7Val = form.get("Q7"); String Q8Val = form.get("Q8");
		 * String Q9Val = form.get("Q9"); String Q10Val = form.get("Q10"); String Q11Val
		 * = form.get("Q11"); String Q12Val = form.get("Q12"); String Q13Val =
		 * form.get("Q13"); String Q14Val = form.get("Q14"); String Q15Val =
		 * form.get("Q15"); String Q16Val = form.get("Q16"); String Q17Val =
		 * form.get("Q17"); String ackVal = form.get("acknowledgement");
		 */
		// eleUtil.isPageLoaded(50);
		/*
		 * try { Thread.sleep(600000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		String yesval = "Yes";
		String noval = "No";
		// need the below code when checklist is filling seperately
		selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAUTT_WAIT);
		getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAUTT_WAIT);
		eleUtil.waitForVisibilityOfElement(servicetasksTab, 30);
		eleUtil.doClick(servicetasksTab);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualname = eleUtil.doGetElementAttribute(checklistNameField, "aria-label");
		String actualTemplatename = eleUtil.doGetElementAttribute(checklisttypeField, "aria-label");
		assertTrue(actualname.contains("Tanker Permit Inspection"), "Checklist name is not matching");
		assertTrue(actualTemplatename.contains("WRN5 Tanker Permit Inspection Checklist"),
				"Template name is not matching");

		eleUtil.doElementClickable(checklistNameField, 20);
		eleUtil.doClick(checklistNameField);
		eleUtil.doElementClickable(maximizescreenBtn, 10);
		eleUtil.doClick(maximizescreenBtn);

		if (outcome.equalsIgnoreCase("Complaince")) {
			By chklistQ1 = By.xpath("//input[contains(@name,'Q1_sq_') and @value='" + yesval + "']");
			By chklistQ2 = By.xpath("//input[contains(@name,'Q2_sq_') and @value='" + yesval + "']");
			By chklistQ3 = By.xpath("//input[contains(@name,'Q3_sq_') and @value='" + yesval + "']");
			By chklistQ4 = By.xpath("//input[contains(@name,'Q4_sq_') and @value='" + yesval + "']");
			By chklistQ5 = By.xpath("//input[contains(@name,'Q5_sq_') and @value='" + yesval + "']");
			By chklistQ6 = By.xpath("//input[contains(@name,'Q6_sq_') and @value='" + yesval + "']");
			By chklistQ7 = By.xpath("//input[contains(@name,'Q7_sq_') and @value='" + yesval + "']");
			By chklistQ8 = By.xpath("//input[contains(@name,'Q8_sq_') and @value='" + yesval + "']");
			By chklistQ9 = By.xpath("//input[contains(@name,'Q9_sq_') and @value='" + yesval + "']");
			By chklistQ10 = By.xpath("//input[contains(@name,'Q10_sq_') and @value='" + yesval + "']");
			By chklistQ11 = By.xpath("//input[contains(@name,'Q11_sq_') and @value='" + yesval + "']");
			By chklistQ12 = By.xpath("//input[contains(@name,'Q12_sq_') and @value='" + yesval + "']");
			By chklistQ13 = By.xpath("//input[contains(@name,'Q13_sq_') and @value='" + yesval + "']");
			By chklistQ14 = By.xpath("//input[contains(@name,'Q14_sq_') and @value='" + yesval + "']");
			By chklistQ15 = By.xpath("//input[contains(@name,'Q15_sq_') and @value='" + yesval + "']");
			By chklistQ16 = By.xpath("//input[contains(@name,'Q16_sq_') and @value='" + yesval + "']");
			By chklistQ17 = By.xpath("//input[contains(@name,'Q17_sq_') and @value='" + yesval + "']");

			eleUtil.waitForVisibilityOfElement(chklistQ1, 20);
			eleUtil.doClick(chklistQ1);
			eleUtil.doClick(chklistQ2);
			eleUtil.doClick(chklistQ3);
			eleUtil.doClick(chklistQ4);
			eleUtil.doClick(chklistQ5);
			eleUtil.doClick(chklistQ6);
			eleUtil.doClick(chklistQ7);
			eleUtil.doClick(chklistQ8);
			eleUtil.doClick(chklistQ9);
			eleUtil.doClick(chklistQ10);
			eleUtil.doClick(chklistQ11);
			eleUtil.doClick(chklistQ12);
			eleUtil.doClick(chklistQ13);
			eleUtil.doClick(chklistQ14);
			eleUtil.doClick(chklistQ15);
			eleUtil.doClick(chklistQ16);
			eleUtil.doClick(chklistQ17);

		} else {
			By chklistQ1 = By.xpath("//input[contains(@name,'Q1_sq_') and @value='" + yesval + "']");
			By chklistQ2 = By.xpath("//input[contains(@name,'Q2_sq_') and @value='" + yesval + "']");
			By chklistQ3 = By.xpath("//input[contains(@name,'Q3_sq_') and @value='" + yesval + "']");
			By chklistQ4 = By.xpath("//input[contains(@name,'Q4_sq_') and @value='" + yesval + "']");
			By chklistQ5 = By.xpath("//input[contains(@name,'Q5_sq_') and @value='" + yesval + "']");
			By chklistQ6 = By.xpath("//input[contains(@name,'Q6_sq_') and @value='" + yesval + "']");
			By chklistQ7 = By.xpath("//input[contains(@name,'Q7_sq_') and @value='" + yesval + "']");
			By chklistQ8 = By.xpath("//input[contains(@name,'Q8_sq_') and @value='" + noval + "']");
			By chklistQ9 = By.xpath("//input[contains(@name,'Q9_sq_') and @value='" + yesval + "']");
			By chklistQ10 = By.xpath("//input[contains(@name,'Q10_sq_') and @value='" + yesval + "']");
			By chklistQ11 = By.xpath("//input[contains(@name,'Q11_sq_') and @value='" + yesval + "']");
			By chklistQ12 = By.xpath("//input[contains(@name,'Q12_sq_') and @value='" + noval + "']");
			By chklistQ13 = By.xpath("//input[contains(@name,'Q13_sq_') and @value='" + yesval + "']");
			By chklistQ14 = By.xpath("//input[contains(@name,'Q14_sq_') and @value='" + yesval + "']");
			By chklistQ15 = By.xpath("//input[contains(@name,'Q15_sq_') and @value='" + yesval + "']");
			By chklistQ16 = By.xpath("//input[contains(@name,'Q16_sq_') and @value='" + yesval + "']");
			By chklistQ17 = By.xpath("//input[contains(@name,'Q17_sq_') and @value='" + yesval + "']");

			eleUtil.waitForVisibilityOfElement(chklistQ1, 20);
			eleUtil.doClick(chklistQ1);
			eleUtil.doClick(chklistQ2);
			eleUtil.doClick(chklistQ3);
			eleUtil.doClick(chklistQ4);
			eleUtil.doClick(chklistQ5);
			eleUtil.doClick(chklistQ6);
			eleUtil.doClick(chklistQ7);
			eleUtil.doClick(chklistQ8);
			eleUtil.doClick(chklistQ9);
			eleUtil.doClick(chklistQ10);
			eleUtil.doClick(chklistQ11);
			eleUtil.doClick(chklistQ12);
			eleUtil.doClick(chklistQ13);
			eleUtil.doClick(chklistQ14);
			eleUtil.doClick(chklistQ15);
			eleUtil.doClick(chklistQ16);
			eleUtil.doClick(chklistQ17);

		}

		int number = ThreadLocalRandom.current().nextInt();
		System.out.println("random  number before absolute:" + number);
		int randomNumber = Math.abs(number);
		String strform = String.valueOf(randomNumber);
		System.out.println("random number is:" + strform);
		jsutil.scrollIntoView(driver.findElement(newSealnumField));
		eleUtil.doSendKeys(newSealnumField, strform);
		By acknowledmentOption = By.xpath("//input[contains(@name,'Question2_sq_') and @value='" + yesval + "']");
		eleUtil.doClick(acknowledmentOption);
		eleUtil.doClick(saveBtnInChklsit);
		System.out.println("clicked on save button");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eleUtil.doElementClickable(markcompleteBtn, 30);
		try {
			eleUtil.doClick(markcompleteBtn);
		} catch (Exception e) {
			eleUtil.doActionsClick(markcompleteBtn);
		}

		// eleUtil.doClickWithWait(markcompleteBtn, 20);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		eleUtil.doClick(saveNCloseBtnInChklsit);

		eleUtil.doClick(saveCloseBtn);
		// complaincecheck();
	}

	public void complaincecheckInWorkorder(String status, String iscomplaint) {

		/*
		 * try { Thread.sleep(4000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } clickOnRefrehBtn();
		 */
		navigatingtotab("Work Orders");

		// eleUtil.doClick(summaryTab);
		// clickOnRefrehBtn();
		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("size is:" + wonum.size());
		for (int i = 0; i < wonum.size(); i++) {
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);
			Boolean flag = false;
			while (!flag) {
				// c++;
				try {
					Thread.sleep(3000);
					eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAUTT_WAIT);
					eleUtil.waitForVisibilityOfElement(tankerregno, AppConstants.SHORT_DEFAUTT_WAIT);
					if (driver.findElement(tankerregno).isDisplayed()) {
						// flag = true;
						break;
					}

				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}
			// clickOnRefrehBtn();
			By isComplaintchkInWOfrom = By
					.xpath("//select[@aria-label='Is Compliant?']/option[text()='" + status + "']");
			eleUtil.waitForVisibilityOfElement(isComplaintchkInWOfrom, 100);
			String isComplaintVal = eleUtil.doElementGetText(isComplaintchkInWOfrom);
			System.out.println("complaince check - " + isComplaintVal);
			if (isComplaintVal.equals(iscomplaint)) {
				System.out.println("Tanker is Complaince");
			} else {
				System.out.println("Tanker is Non-Complaince");
			}
			assertEquals(eleUtil.doGetElementAttribute(WOstatusInWOform, "title"), status, "WO status not matching");
			eleUtil.doClick(saveCloseBtn);
		}
	}

	public void complaincecheckInCase(String iscomplaint) {

	}

	public void completeIdentifyStage() {
		navigatingtoStage("Identify");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void confirmInspectionSchedule() {
		navigatingtoStage("Assignment");
		eleUtil.waitForVisibilityOfElement(confirmInspectionScheduleOption, 10);
		eleUtil.createSelect(confirmInspectionScheduleOption);
		eleUtil.doSelectDropDownByVisibleText(confirmInspectionScheduleOption, "Yes");
		eleUtil.doClick(saveBtn);
	}

	public void completeAssignmnetStage() throws InterruptedException {
		navigatingtoStage("Assignment");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void completeInspection() {
		navigatingtoStage("Inspection"); // This step need to be removed once
		// everything is merged
		eleUtil.waitForVisibilityOfElement(inspectionCompletedOption, 10);
		eleUtil.createSelect(inspectionCompletedOption);
		eleUtil.doSelectDropDownByVisibleText(inspectionCompletedOption, "Yes");
		eleUtil.doClick(saveBtn);
		navigatingtoStage("Inspection");
		eleUtil.waitForVisibilityOfElement(generateInspectionReportOption, 10);
		eleUtil.createSelect(generateInspectionReportOption);
		eleUtil.doSelectDropDownByVisibleText(generateInspectionReportOption, "No");
		eleUtil.doClick(saveBtn);
		// eleUtil.doClick(closeBtnOnBPF);
		clickOnRefrehBtn();
		/*
		 * try { permitnumCheck(); } catch (ParseException e) { // TODO Auto-generated
		 * e.printStackTrace(); }
		 */

	}

	public void verifyPermitAgreeementLetters(String lettername) {
		eleUtil.waitForVisibilityOfElement(allTabs, 50);
		eleUtil.doElementClickable(workorderTab, 30);
		navigatingtotab("Timeline");
		By ele = By.xpath(
				"//label[text()='Note modified by']//ancestor::div[contains(@id,'timeline_record')]//descendant::div[contains(text(),'"
						+ lettername + "')]");
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 30000) {
			try {
				// Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAUTT_WAIT);
				navigatingtotab("Timeline");
				eleUtil.waitForVisibilityOfElement(ele, 30);
				if (driver.findElement(ele).isDisplayed()) {
					flag = true;
					System.out.println("validating letter is available or not");
					// Assert.assertEquals(true, driver.findElement(ele).isDisplayed());
					System.out.println("successful validation");
					// break;
				}
			} catch (Exception e) {
				// e.getMessage();
				System.out.println(lettername + "Letter is not available   ");
			}
		}
	}

	public void completeInspectionStage() {

		navigatingtoStage("Inspection");
		eleUtil.waitForVisibilityOfElement(submitSOreviewBtn, 10);
		eleUtil.createSelect(submitSOreviewBtn);
		eleUtil.doSelectDropDownByVisibleText(submitSOreviewBtn, "Yes");
		eleUtil.doClick(saveBtn);
		// eleUtil.doClick(closeBtnOnBPF);
		eleUtil.isPageLoaded(10);
		navigatingtoStage("Inspection");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
		// CommonActionsPage.permitnum = permitnumval();
	}

	public String permitnumval() {

		eleUtil.waitForVisibilityOfElement(permitnum, 30);
		String str = eleUtil.doGetElementAttribute(permitnum, "aria-label");
		// System.out.println("permit number is generated :" + str);

		if (!str.isEmpty()) {
			System.out.println("permit number is generated" + str);
		} else {
			System.out.println("permit number is blank");
		}
		return str;

	}

	public void permitnumCheck() throws ParseException {
		navigatingtotab("Work Orders");
		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("size is:" + wonum.size());
		for (int i = 0; i < wonum.size(); i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);
			// eleUtil.doElementClickable(gwctankername, 20);
			// eleUtil.doClick(gwctankername);
			eleUtil.doElementClickable(tankerNumberInWOform, 30);
			eleUtil.doClick(tankerNumberInWOform);
			clickOnRefrehBtn();

			// jsutil.zoomChromeEdgeSafari("80");
			permitnumval();
			eleUtil.waitForVisibilityOfElement(letterdate, 20);
			String letterdateval = eleUtil.doGetElementAttribute(letterdate, "aria-label");
			System.out.println("Letter date is" + letterdateval);
			// need to add code here --> permit expiry date

			System.out.println("---------------");
			// String letterdateval = "12-2-2024";// 2024-02-12
			SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy");
			Date date = formatter.parse(letterdateval);
			SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
			String finalString = newFormat.format(date);
			System.out.println(finalString);
			LocalDate permitgeneratedDate = LocalDate.parse(finalString);
			int month = permitgeneratedDate.getMonth().getValue();
			int year = permitgeneratedDate.getYear();

			// Define the date range criteria based on applicationDate
			int stDateYear = Integer.MIN_VALUE, endDateYear = Integer.MIN_VALUE;
			if (month >= 4 && month <= 12) {
				stDateYear = year;
				endDateYear = year + 1;
			} else if (month >= 1 && month <= 3) {
				stDateYear = year - 1;
				endDateYear = year;
			}
			// Financial year range from
			LocalDate startDate = LocalDate.of(stDateYear, 4, 1);
			LocalDate endDate = LocalDate.of(endDateYear, 3, 31);

			// Calculate the expire date based on the condition
			LocalDate ExpectedexpireDate = LocalDate.of(endDateYear, 3, 31);// Here we always want exp date tobe mar-31

			// Print the result
			// System.out.println("Permit generation Date: " + letterdateval);
			// System.out.println("Expire Date: " + ExpectedexpireDate);

			// Format LocalDate as per our choice
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/M/yyyy");
			String expireDateInString = ExpectedexpireDate.format(formatter1);
			System.out.println("Converted String (DateTimeFormatter): " + expireDateInString);

			System.out.println("--------------------");

			String expirydateval = eleUtil.doGetElementAttribute(expirydate, "aria-label");
			// System.out.println("Expire date is" + expirydateval);
			if (expirydateval.equals(expireDateInString)) {
				System.out.println("Expiry date is expected   " + "actual : " + expirydateval + "   Expected : "
						+ expireDateInString);
			} else {
				System.out
						.println("Not as expected" + "actual : " + expirydateval + "Expected : " + expireDateInString);
			}
			// eleUtil.doClick(backBtn);
			jsutil.clickElementByJS(driver.findElement(backBtn));
			eleUtil.doElementClickable(saveCloseBtn, 30);
			eleUtil.doClick(saveCloseBtn);
			CommonActionsPage.permitExpiryDate = expirydateval;
		}
	}

	public void validateSOReviewNotification() throws InterruptedException {

		CommonActionsPage.WOnumber = getWONumber();// This is place we need to declare wonumber once alerts code is
													// included
		List<String> wonum = CommonActionsPage.WOnumber;
		for (int i = 0; i < wonum.size(); i++) {
			eleUtil.isPageLoaded(100);
			eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
			eleUtil.doClick(notificationIcon);
			Boolean flag = false;
			long startTime = System.currentTimeMillis();
			while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
				try {
					Thread.sleep(3000);
					WebElement WOalert = driver.findElement(
							By.xpath("//p[text()='You Have been scheduled for  Work Order " + wonum.get(i) + ". ']"));
					if (eleUtil.isClickable(WOalert, 10)) {
						String actualAlertcontent = WOalert.getText();
						// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAUTT_WAIT);
						System.out.println("actualAlertcontent" + actualAlertcontent);
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						wait.until(ExpectedConditions.elementToBeClickable(WOalert));

						/*
						 * if (!actualAlertcontent.isEmpty()) { // flag = true; actualAlertcontent =
						 * WOalert.getText(); // break;
						 * 
						 * }
						 */
						String ExpectedAlertContent = "You Have been scheduled for Work Order " + wonum.get(i)
								+ ". \"Tap to open\".";
						System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
						assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
						WebElement taptoopenBtn = driver.findElement(By.xpath(
								"//p[text()='You Have been scheduled for  Work Order " + wonum.get(i) + ". ']/a"));
						taptoopenBtn.click();
						flag = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			System.out.println("open tabs" + tabs.size());
			driver.switchTo().window(tabs.get(1));
			// Thread.sleep(10000);
			eleUtil.waitForVisibilityOfElement(workordertext, 100);
			String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(workordertext, "Value");
			System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
			assertTrue(afterTaptoOpenBtn.contains(wonum.get(i)), "WO is not same after clicking on tap to open button");
			System.out.println(tabs.size() - 1);
			// driver.switchTo().window(tabs.get(tabs.size() - 2));
			eleUtil.doElementClickable(saveCloseBtn, 20);
			eleUtil.doClick(saveCloseBtn);
			driver.switchTo().window(tabs.get(0));
			eleUtil.doClick(cancelBtn);
		}
	}

	public void completeSOReviewStage() {
		navigatingtoStage("SO Review");

		/*
		 * eleUtil.waitForVisibilityOfElement(systemassesmentOption, 10);
		 * assertEquals(eleUtil.doElementGetText(systemassesmentOption), "Complaince");
		 * eleUtil.waitForVisibilityOfElement(userassesmentOption, 10);
		 * assertEquals(eleUtil.doElementGetText(userassesmentOption), "Complaince");
		 */

		eleUtil.waitForVisibilityOfElement(submitAOreviewBtn, 10);
		eleUtil.createSelect(submitAOreviewBtn);
		eleUtil.doSelectDropDownByVisibleText(submitAOreviewBtn, "Yes");
		eleUtil.doClick(saveBtn);
		navigatingtoStage("SO Review");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void completeAOReviewStage() {
		navigatingtoStage("AO Review");
		eleUtil.waitForVisibilityOfElement(AOresponseOption, 10);
		eleUtil.createSelect(AOresponseOption);
		eleUtil.doSelectDropDownByVisibleText(AOresponseOption, "Approve");
		eleUtil.doElementClickable(saveBtn, 10);
		eleUtil.doActionsClick(saveBtn);
		navigatingtoStage("AO Review");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void completeGenerateEmailStage() {
		navigatingtoStage("Generate Email");
		eleUtil.waitForVisibilityOfElement(generateemailOption, 10);
		eleUtil.createSelect(generateemailOption);
		eleUtil.isPageLoaded(40);
		eleUtil.doSelectDropDownByVisibleText(generateemailOption, "Yes");
		eleUtil.waitForVisibilityOfElement(emailtocustomerOption, 10);
		eleUtil.createSelect(emailtocustomerOption);
		eleUtil.doSelectDropDownByVisibleText(emailtocustomerOption, "Yes");
		eleUtil.waitForVisibilityOfElement(endoresementreceivedOption, 10);
		eleUtil.createSelect(endoresementreceivedOption);
		eleUtil.doSelectDropDownByVisibleText(endoresementreceivedOption, "Yes");
		eleUtil.doElementClickable(saveBtn, 30);
		eleUtil.doActionsClick(saveBtn);
		// eleUtil.isPageLoaded(100);
		eleUtil.doElementClickable(generateemailStage, 10);
		navigatingtoStage("Generate Email");
		eleUtil.doElementClickable(nextstageBtn, 50);
		eleUtil.doActionsClick(nextstageBtn);
		eleUtil.isPageLoaded(10);
		// below 2 steps need to be removed once mails code is removed
		eleUtil.doElementClickable(okBtn, 10);
		eleUtil.doClick(okBtn);
	}

	public void completeResolveStage() {
		navigatingtoStage("Close");
		eleUtil.waitForVisibilityOfElement(resolvecaseOption, 10);
		eleUtil.createSelect(resolvecaseOption);
		eleUtil.doSelectDropDownByVisibleText(resolvecaseOption, "Yes");
		eleUtil.doElementClickable(okBtn, 10);
		eleUtil.doClick(okBtn);
		eleUtil.waitForVisibilityOfElement(finishBtn, 10);
		eleUtil.doElementClickable(finishBtn, 10);
		eleUtil.doClick(finishBtn);
	}

	public void uploadDocInCase() throws AWTException {
		navigatingtotab("Documents");
		eleUtil.doElementClickable(attachBtn, 10);
		eleUtil.doClick(attachBtn);
		eleUtil.doElementClickable(browsefield, 10);
		// eleUtil.doClick(browseBtn);
		// driver.findElement(browseBtn).sendKeys("Users/sriswathianusha.nulu/Documents/Test.txt");
		//
		eleUtil.doClick(browsefield);
		eleUtil.doSendKeys(browsefield, "C:/Users/sriswathianusha.nulu/Documents/Test.txt");
		/*
		 * Robot rb = new Robot();
		 * 
		 * // copying File path to Clipboard StringSelection str = new
		 * StringSelection("C:\\Users\\sriswathianusha.nulu\\Documents\\Test.txt");
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 * 
		 * // press Contol+V for pasting rb.keyPress(KeyEvent.VK_CONTROL);
		 * rb.keyPress(KeyEvent.VK_V);
		 * 
		 * // release Contol+V for pasting rb.keyRelease(KeyEvent.VK_CONTROL);
		 * rb.keyRelease(KeyEvent.VK_V);
		 * 
		 * // for pressing and releasing Enter rb.keyPress(KeyEvent.VK_ENTER);
		 * rb.keyRelease(KeyEvent.VK_ENTER);
		 */
		eleUtil.doElementClickable(uploadBtn, 10);
		eleUtil.doClick(uploadBtn);
	}

	public void WOStatusChange() {

		navigatingtotab("Work Orders");
		// eleUtil.doClick(wostatusField);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 30000) {
			try {
				Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAUTT_WAIT);
				navigatingtotab("Work Orders");
				eleUtil.waitForVisibilityOfElement(wostatusField, AppConstants.SHORT_DEFAUTT_WAIT);
				String status = eleUtil.doElementGetText(wostatusField);
				System.out.println(status);
				if (status.equals("Scheduled")) {
					break;
				}
			} catch (Exception e) {
				// e.getMessage();
				System.out.println("Exceptrion:" + e);
			}
		}
	}

	public void mailGeneratedOrNot(String mailType) throws InterruptedException, ParseException {
		clickOnRefrehBtn();
		navigatingtotab("Timeline");
		// eleUtil.isPageLoaded(100);
		Thread.sleep(2000);
		By ele;
		switch (mailType) {

		case "Inspection Schedule":
			ele = By.xpath("//label[contains(text(),'Inspection Appointment')]");
			String mailTrigger = eleUtil.doElementGetText(ele);
			assertTrue(mailTrigger.contains("Inspection Appointment"), "Mail is not generated");
			// driver.switchTo().defaultContent();
			break;
		case "Permit generation":
			ele = By.xpath(
					"//label[text()='Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)']//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			driver.switchTo().defaultContent();
			assertTrue(mailType.contains("Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)"),
					"Mail is generated");
			// Assert.assertEquals(true, driver.findElement(attachment).isDisplayed());
			List<WebElement> files = driver.findElements(attachment);
			if (!files.isEmpty()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			break;
		case "Permit WRP email":
			ele = By.xpath(
					"//label[contains(text(),'For your assistance')]//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			assertTrue(mailType.contains("For your assistance"), "Mail is generated");
			driver.switchTo().defaultContent();
			if (driver.findElement(attachment).isDisplayed()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			break;
		}
		// eleUtil.doElementClickable(backBtn, 50);
		// eleUtil.doClick(backBtn);
	}

	public void mailValidation(String mailType) throws InterruptedException, ParseException {
		clickOnRefrehBtn();
		navigatingtotab("Timeline");
		// eleUtil.isPageLoaded(100);
		Thread.sleep(2000);
		String actualSub, actualFrom, actualBody;
		List<WebElement> actualTo;
		List<String> headersValList;
		By ele;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy");
		Date date = formatter.parse(CommonActionsPage.startdateval);
		SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
		String finalString = newFormat.format(date);
		System.out.println(finalString);
		switch (mailType) {

		case "Inspection Schedule":
			ele = By.xpath(
					"//label[contains(text(),'Inspection scheduled')]//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.waitForVisibilityOfElement(ele, 30);
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(mailSubject, 10);
			actualSub = eleUtil.doGetElementAttribute(mailSubject, "Value");
			System.out.println("subject is" + actualSub);
			actualFrom = eleUtil.doElementGetText(mailFrom);

			actualTo = driver.findElements(mailTo);
			headersValList = new ArrayList<String>();
			for (int i = 0; i < actualTo.size(); i++) {
				String actualToVal = actualTo.get(i).getText();
				headersValList.add(actualToVal);
			}

			assertEquals(actualFrom, "SIES DEV3", "From address is not matching");
			System.out.println("CommonActionsPage.Tankercompanyname" + CommonActionsPage.Tankercompanyname
					+ "headersValList" + headersValList);
			// assertEquals(CommonActionsPage.Tankercompanyname, headersValList, "To address
			// is not matching");
			assertTrue(headersValList.contains(CommonActionsPage.Tankercompanyname), "To address is not matching");
			assertEquals(actualSub, "Inspection scheduled for tanker " + CommonActionsPage.TankerName + ".",
					"Subject is not matching");
			// assertEquals(actualTo, "Tankercompany_022003", "To address is not matching");
			// assertEquals(actualSub, "Inspection scheduled for tanker
			// T_GW+022003.","Subject is not matching");
			eleUtil.scrollUsingRobotClass();
			Thread.sleep(4000);
			// eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc, AppConstants.LONG_DEFAUTT_WAIT);
			Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody);

			/*
			 * SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy"); Date date =
			 * formatter.parse(CommonActionsPage.startdateval); SimpleDateFormat newFormat =
			 * new SimpleDateFormat("dd/MM/yyyy"); String finalString =
			 * newFormat.format(date); System.out.println(finalString);
			 */

			String Expectedstr = "Dear Sir/Madam,\n" + "Please send in the tanker " + CommonActionsPage.TankerName
					+ " to Waterhub during working hours on " + finalString + " 11:30 AM.\n"
					+ "Confirm the appointment date and time 1 day in advance.\n"
					+ "Please ensure the tanker is ready for inspection.\n"
					+ "Tank should be empty to open for visual check, the GPS operational\n"
					+ "and camera can view the suction and discharge valve.\n"
					+ "If satisfactory, its discharge handle will be tagged with PUB seal.\n" + "\n" + "Thanks,\n"
					+ "G RAJ KUMAR\n" + "Senior Assistant Engineer\n"
					+ "Water Reclamation (Network) Department (Operation & Maintenance Division)";
			System.out.println(actualBody);
			assertEquals(actualBody, Expectedstr, "Body is not matching");
			driver.switchTo().defaultContent();
			break;
		case "Permit generation":
			ele = By.xpath(
					"//label[text()='Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)']//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(mailSubject, 10);
			actualSub = eleUtil.doGetElementAttribute(mailSubject, "Value");
			System.out.println("subject is" + actualSub);
			actualFrom = eleUtil.doElementGetText(mailFrom);
			actualTo = driver.findElements(mailTo);
			headersValList = new ArrayList<String>();
			for (int i = 0; i < actualTo.size(); i++) {
				String actualToVal = actualTo.get(i).getText();
				headersValList.add(actualToVal);
			}

			System.out.println("actualTo values:" + headersValList);
			assertEquals(actualFrom, "SIES DEV2", "From address is not matching");
			List<String> expectedTo = new ArrayList<String>();

			expectedTo.add("WRN5 WRP Contact");
			// expectedTo.add("Tankcompany01032024080235");
			expectedTo.add(CommonActionsPage.Tankercompanyname);
			System.out.println("expectedTo values:" + expectedTo);
			// assertEquals(headersValList, expectedTo, "To address is not matching");

			Collections.sort(headersValList);
			Collections.sort(expectedTo);
			if (headersValList.equals(expectedTo) == true) {
				System.out.println(" To address is matching     :" + headersValList + "------->" + expectedTo);
			} else {
				System.out.println(" To address is not matching ");
			}

			assertEquals(actualSub, "Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)",
					"Subject is not matching");
			eleUtil.scrollUsingRobotClass();
			Thread.sleep(4000);
			// eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc, AppConstants.LONG_DEFAUTT_WAIT);
			Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody);

			/*
			 * String ExpectedBody = "Dear Sir,\n" + "\n" +
			 * "The attached permits dated 1/3/2024 are for disposal of greasy waste, organic sludge at Jurong WRP and human wastewater at WRPs. These permits expire on 31/3/2025.\n"
			 * + "\n" +
			 * "Please acknowledge acceptance of the terms and conditions by returning us a copy of this agreement within 5 working days with the signature of a representative of your company listed in ACRA. \n"
			 * + "\n" + "Regards\n" + "\n" + "\n" + "\n" + "SIES DEV2\n" +
			 * "Field Inspection Officer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)\n"
			 * + "\n" +
			 * "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email"
			 * ;
			 */

			String ExpectedBody = "Dear Sir,\n" + "\n" + "The attached permits dated " + CommonActionsPage.startdateval
					+ " are for disposal of greasy waste, organic sludge at Jurong WRP and human wastewater at WRPs. These permits expire on "
					+ CommonActionsPage.permitExpiryDate + ".\n" + "\n"
					+ "Please acknowledge acceptance of the terms and conditions by returning us a copy of this agreement within 5 working days with the signature of a representative of your company listed in ACRA. \n"
					+ "\n" + "Regards\n" + "\n" + "\n" + "\n" + "SIES DEV2\n" + "Field Inspection Officer\n"
					+ "Water Reclamation (Network) Department (Operation & Maintenance Division)\n" + "\n"
					+ "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email";
			System.out.println("permit  generation actual" + actualBody);
			System.out.println("Permit generation expected" + ExpectedBody);
			if (actualBody.equalsIgnoreCase(ExpectedBody)) {
				System.out.println(" Body is same     :" + actualBody + "------->" + ExpectedBody);
			} else {
				System.out.println(" Body is not same");
			}
			driver.switchTo().defaultContent();
			// Assert.assertEquals(true, driver.findElement(attachment).isDisplayed());
			List<WebElement> files = driver.findElements(attachment);
			if (!files.isEmpty()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			break;
		case "Permit WRP email":
			ele = By.xpath(
					"//label[contains(text(),'For your assistance')]//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(mailSubject, 10);
			actualSub = eleUtil.doGetElementAttribute(mailSubject, "Value");
			System.out.println("subject is" + actualSub);
			actualFrom = eleUtil.doElementGetText(mailFrom);
			actualTo = driver.findElements(mailTo);
			headersValList = new ArrayList<String>();
			for (int i = 0; i < actualTo.size(); i++) {
				String actualToVal = actualTo.get(i).getText();
				headersValList.add(actualToVal);
			}
			assertEquals(actualFrom, "SIES DEV2", "From address is not matching");
			assertTrue(headersValList.contains("WRN5 WRP Contact"), "To address is not matching");
			assertEquals(actualSub,
					"For your assistance: Agreement to dispose waste at PUB's Water Reclamation Plants (WRPs) for Year.",
					"Subject is not matching");
			eleUtil.scrollUsingRobotClass();
			Thread.sleep(4000);
			// eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc, AppConstants.LONG_DEFAUTT_WAIT);
			Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody);
			// System.out.println(actualBody);

			ExpectedBody = "Dear WRP colleagues\n" + "\n" + CommonActionsPage.Tankercompanyname
					+ "'s new permit for 0 tankers has been issued.\n" + "\n"
					+ "Please take note and pass on to your teams on the ground to allow the tankers access to WRPs according to type of waste.\n"
					+ "\n" + "Description Attachment Remarks\n"
					+ "List of all GWCs and their vehicle numbers granted permit\n"
					+ "Valid until: [Please refer to attachment for expiry date]\n"
					+ "File 2023 WRP list of tankers effective from 1 Apr 2023_V2.xlsx\n"
					+ "Updated tanker list excludes the following tanker:\n" + CommonActionsPage.Tankercompanyname
					+ " - " + CommonActionsPage.GWCReferenceNum + "\n" + "\n" + "\n" + "\n" + "Regards\n" + "\n" + "\n"
					+ "G RAJ KUMAR \n" + "Assistant Engineer\n"
					+ "Water Reclamation (Network) Department (Operation & Maintenance Division)\n" + "\n"
					+ "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email";

			/*
			 * ExpectedBody = "Dear WRP colleagues\n" +
			 * "\n Tankcompany01032024080235's new permit for 0 tankers has been issued.\n"
			 * + "\n" +
			 * "Please take note and pass on to your teams on the ground to allow the tankers access to WRPs according to type of waste.\n"
			 * + "\n" + "Description Attachment Remarks\n" +
			 * "List of all GWCs and their vehicle numbers granted permit\n" +
			 * "Valid until: [Please refer to attachment for expiry date]\n" +
			 * "File 2023 WRP list of tankers effective from 1 Apr 2023_V2.xlsx\n" +
			 * "Updated tanker list excludes the following tanker:\n Tankcompany01032024080235 - 886\n"
			 * + "\n" + "\n" + "\n" + "Regards\n" + "\n" + "\n" + "G RAJ KUMAR \n" +
			 * "Assistant Engineer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)\n"
			 * + "\n" +
			 * "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email"
			 * ;
			 */
			System.out.println("permit  generation actual" + actualBody);
			System.out.println("Permit generation expected" + ExpectedBody);
			// assertEquals(actualBody, Expectedstr, "Body is not matching");
			if (actualBody.equalsIgnoreCase(ExpectedBody)) {
				// System.out.println(" Body is same :" + actualBody + "------->" +
				// ExpectedBody);
				System.out.println(" Body is same");
			} else {
				System.out.println(" Body is not same");
			}
			driver.switchTo().defaultContent();
			if (driver.findElement(attachment).isDisplayed()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			break;
		}
		eleUtil.doElementClickable(backBtn, 50);
		eleUtil.doClick(backBtn);
	}
}// DQB/TP/I/2024/4257