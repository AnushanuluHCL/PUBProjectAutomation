package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
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
import java.util.Map;
import java.util.NoSuchElementException;

import com.sat.locators.casePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.constants.AppConstants;
import com.sat.locators.factoryPage;
import com.sat.testUtil.ExcelUtil;
import com.sat.testUtil.Log;

import io.cucumber.datatable.DataTable;

public class caseCreationPage extends commonActionsPage {
	/*
	 * private WebDriver driver; private Properties prop; private ElementUtil
	 * eleUtil; private TestBase testbase; private JavaScriptUtil jsutil; private
	 * CommonActionsPage common; private ApplicationPage apppage;
	 */

	// Locators on application page

	factoryPage factory = new factoryPage(driver);
	casePage cases = new casePage(driver);
	commonCRMActions crmActions = new commonCRMActions(driver);
	String depositFilePath = "\\src\\main\\resources\\documents\\ActiveDeposits.xlsx";

	private By createdApp = By.xpath("(//div[@col-id='pub_gwccompany']//descendant::a)[2]"); // (//div[@col-id='pub_gwccompany'])[2]
	private By changeViewIcon = By.xpath("//span[text()='Open popup to change view.']//following-sibling::i");
	private By AcceptedApplicaion = By.xpath("//label[text()='Accepted applications']");
	private By ActiveCases = By.xpath("//label[contains(text(),'Active Cases')]");

	// Locators from case form
	private By entitydropdown = By.xpath("(//div[@col-id='customerid'])[1]");
	private By entityName = By.xpath("(//div[@col-id='customerid'])[2]");
	private By filterBy = By.xpath("//span[text()='Filter by']");
	private By filterbyinputbox = By.xpath("//input[@aria-label='Filter by value']");
	private By suggestionbox = By.xpath("//div[contains(@class,'suggestionTextOverflow')]");
	private By applyBtn = By.xpath("//span[text()='Apply']");
	private By entitynameOnCaseForm = By.xpath("(//div[@col-id='customerid']//a)[1]");
	private By caseidOnCaseForm = By.xpath("//div[@col-id='title']//a"); // (//div[@col-id='title'])[2]
	// //h1[@data-id='header_title']
	private By entityIdOnCaseHome = By.xpath("//ul[@title='Entity']");
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
	private By caseSOField = By.xpath("//ul[@title='Case SO']//div[contains(@data-id,'pub_caseso')]/span/div");// ul[@title='Case
	// SO']
	private By caseAOField = By.xpath("//ul[@title='Case AO']//div[contains(@data-id,'pub_caseao')]/span/div");// ul[@title='Case
	// AO']
	private By caseFIOField = By.xpath("//ul[@title='Case FIO']//div[contains(@data-id,'pub_casefio')]/span/div");// ul[@title='Case
	// FIO']
	private By statusField = By.xpath("//div[text()='Status']/preceding-sibling::div");
	private By caseSubtypefromTop = By.xpath("//div[text()='Case Sub Type']/preceding-sibling::div");
	private By ownerField = By.xpath("//div[text()='Owner']/preceding-sibling::div");
	private By caseIDAtTop = By.xpath("//div[text()='Case ID']/preceding-sibling::div");
	private By GwcRefNum = By.xpath("//input[@aria-label='GWC Reference Number']");

	// user roles update
	private By SOname = By.xpath("//input[contains(@aria-label,'Case SO, Lookup')]");
	private By AOname = By.xpath("//div[contains(@data-id,'pub_caseao.fieldControl')]");
	private By FIOname = By.xpath("//div[contains(@data-id,'pub_casefio.fieldControl')]");

	// Locators on case form tabs
	private By workorderTab = By.xpath("//ul[@aria-label='Case Form']//li[@aria-label='Work Orders']");
	private By allTabs = By.xpath("//ul[@aria-label='Case Form']");
	private By wostatusField = By.xpath("(//div[@col-id='msdyn_systemstatus'])[2]");
	private By moreCommandsInWorkOrder = By.xpath("//button[@title='More commands for Work Order']");

	// Locators on BPF stage on case form
	private By nextstageBtn = By.xpath("//div[contains(@id,'nextButton')]");
	private By assignmentStage = By.xpath("//div[@title='Assignment']");
	private By confirmInspectionScheduleOption = By.xpath("//select[@aria-label='Confirm Inspection Schedule']"); // visible
	// text
	// Yes/No
	private By InspectionStage = By.xpath("//div[@title='Inspection']");
	// Yes/No
	private By generateInspectionReportOption = By.xpath("//select[@aria-label='Generate Inspection Report']"); // visible
	// text
	private By closeBtnOnBPF = By.xpath("//button[@title='Close']"); // Yes/No
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
	private By selectedGeneratedEmailValue = By
			.xpath("//select[@aria-label='Generate Email']//option[@data-selected='true']");
	private By emailtocustomerOption = By.xpath("//select[@aria-label='Email Sent to Customer?']"); // visible text
	// Yes/No
	private By endoresementreceivedOption = By.xpath("//select[@aria-label='Endorsement Received']"); // visible text
	// Yes/No
	private By closeStage = By.xpath("//div[@title='Close']");
	private By resolvecaseOption = By.xpath("//select[@aria-label='Resolve Case']"); // visible text Yes/No
	private By finishBtn = By.xpath("//button[@aria-label='Finish']");

	private By ProcessingStage = By.xpath("");
	private By processingOption = By.xpath("//select[@aria-label='Submit for SO Review']");

	// Locators for Alerts
	private By notificationIcon = By.xpath("//button[@aria-label='Notifications']");
	private By scheduleWOAlert = By.xpath("//p[text()='You Have been scheduled for  Work Order 03543. ']");
	private By cancelBtn = By.xpath("//i[@data-icon-name='Cancel']");
	private By workordertext = By.xpath("//input[@aria-label='Work Order Number']");
	private By permitnotext = By.xpath("//input[@aria-label='Permit Number']");

	// Locators on WorkOrder tab
	private By WONumber = By.xpath("//div[@col-id='msdyn_name']//descendant::a");// (//div[@col-id='msdyn_name'])[2]
	private By appTankerName = By.xpath("//div[@col-id='pub_applicationtankerid']//descendant::a");
	private By gwctankername = By.xpath("//div[@col-id='pub_tankerid']//descendant::a");
	private By wostatus = By.xpath("(//div[@col-id='msdyn_systemstatus'])[2]");
	private By isComplaintchk = By.xpath("//label[contains(@class,'ms-Label twoOptionRootStyles-')]");
	private By saveNContinueBtn = By.xpath("//span[text()='Save and continue']");

	// Locators on work order form
	private By bookingTab = By.xpath("//li[text()='Bookings']");

	private By summaryTab = By.xpath("//li[text()='Summary']");
	private By WOstatusInWOform = By.xpath(
			"//select[@aria-label='WO Status']//ancestor::div[@data-lp-id='MscrmControls.FieldControls.OptionSet|msdyn_systemstatus.fieldControl|msdyn_workorder']//select");
	private By isComplaintchkInWOfrom = By.xpath("//select[@aria-label='Is Compliant?']");
	private By tankerNumberInWOform = By
			.xpath("//ul[@title='Tanker']//descendant::div[contains(@data-id,'pub_tankerid')]//child::div");
	private By tankerregno = By.xpath("//label[text()='Tanker Registration No.']");
	// Locators on tanker form
	private By permitnumber = By.xpath("(//div[contains(@col-id,'pub_permit')])[2]//a");// div[@col-id='pub_permit']//a
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

	private By scheduledStartDateField = By.xpath("//input[@aria-label='Date of Scheduled Start Time']");
	private By scheduledStartTimeField = By.xpath("//input[@aria-label='Time of Scheduled Start Time']");
	private By scheduledEndTimeField = By.xpath("//input[@aria-label='Time of Scheduled End Time']");
	private By startDateField = By.xpath("//input[@aria-label='Date of Start Time']");
	private By startTimeonBooking = By.xpath("//input[@aria-label='Time of Start Time']");
	private By endTimeonBooking = By.xpath("//input[@aria-label='Time of End Time']");
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
	private By nameOfAssignee = By.xpath("//input[contains(@data-id,'pub_nameofsignee')]");
	private By servicetab = By.xpath("//li[@aria-label='Service']");

	// Locators mail
	private By viewmoreBtn = By.xpath("//a[@aria-label='Open Record']");
	private By mailFrom = By.xpath("//ul[@title='From']//li/child::div");
	private By mailTo = By
			.xpath("//ul[@title='To']//li/child::div[contains(@id,'to.fieldControl-LookupResultsDropdown')]");
	private By mailSubject = By.xpath("//input[@aria-label='Subject']");
	private By mailBody = By.xpath("//body[@aria-label='Press ALT 0 for help']");
	private By mailframeLoc = By.xpath("//iframe[@aria-label='Description rich text editor']");
	private By attachment = By.xpath("//button[contains(@class,'ms-Link')]/div");
	private By morecommandsInTimeline = By.xpath("//button[@title='More commands']");

	// Locators on Docuemnts tab
	private By attachBtn = By.xpath("//span[text()='Attach']/ancestor::button");
	private By browseBtn = By.xpath("//span[text()='Browse']/ancestor::button");
	private By browsefield = By.xpath("(//span[text()='Browse']/ancestor::div[@style])[3]//input");
	private By uploadBtn = By.xpath("//span[text()='Upload']/ancestor::button");

	// Locators for inspection report
	private By morecommands = By.xpath("//button[@title='More commands for SIES Document']");
	private By inspectionreportgenerated = By.xpath("// label[@aria-label='Inspection Report']");

	// Locators for Rework
	private By reworkOption = By.xpath("//select[@aria-label='Rework']");// Visible text Yes/No
	private By reworkCommentsBox = By.xpath("//textarea[@id='reworkComments']");
	private By submitBtn = By.xpath("//input[@value='Submit']");
	private By Inspectioncompletedselectedoption = By.xpath("//select[@aria-label='Inspection Completed?']/option");
	private By generateInspectionReportselectedoption = By
			.xpath("//select[@aria-label='Generate Inspection Report']/option");
	private By submitforSOReviewselectedoption = By
			.xpath("//select[contains(@id,'header') and @aria-label='Submit for SO Review']/option");

	// Locators for Manual WO
	private By newWOBtn = By.xpath("//span[text()='New Work Order']");
	private By applicationTanker = By.xpath("//input[@aria-label='Application Tanker, Lookup']");
	private By quickcreateSaveNCloseBtn = By.xpath("//button[@data-id='quickCreateSaveAndCloseBtn']");

	// Locators for Manual Bookable resource
	private By newBookableresourceBtn = By.xpath("//span[text()='New Bookable Resource Booking']");
	private By bookingStatusManualWO = By.xpath("//div[contains(@aria-label,'Booking Status Control')]");
	private By startDateManualWO = By.xpath("//input[@aria-label='Date of Start Time']");
	private By endDateManualWO = By.xpath("//input[@aria-label='Date of End Time']");
	private By startTimeManualWO = By.xpath("//input[@aria-label='Time of Start Time']");
	private By endTimeManualWO = By.xpath("//input[@aria-label='Time of End Time']");
	private By resource = By.xpath("//input[@aria-label='Resource, Lookup']");

	// Locators for Manual case
	private By entityLookupField = By.xpath("//input[@aria-label='Entity, Lookup']");
	private By newBtn = By.xpath("//button[@aria-label='New']");

	// Locators for TankerDeregistration
	private By tankerLookupField = By.xpath("//input[@aria-label='Tanker, Lookup']");
	private By moreCommandsForDereg = By.xpath("//button[@aria-label='More commands for Case Tanker']");
	private By newCaseTanker = By.xpath("//button[contains(@aria-label,'New Case Tanker')]");
	private By entityLink = By.xpath("//ul[@title='Entity']//div[contains(@data-id,'customerid_selected_tag_text')]");
	private By tankerStatusOnCompanyLvl = By
			.xpath("//div[@col-id='pub_tankerpermitstatus']//label[contains(@class,'optionSetRootStyle')]/div");
	private By tankerLink = By.xpath("//div[@col-id='msdyn_name']//a");
	private By tankerStatusOnTankerLvl = By
			.xpath("//select[@data-id='pub_tankerpermitstatus.fieldControl-option-set-select']");
	private By permitGridAtCompanyLvl = By.xpath(
			"//div[contains(@data-id,'Permits_List-pcf_grid_control_container')]//span[text()='No data available']");

	// Locators for Deposit amount calculations
	private By customerName = By.xpath("//div[@data-testid='pub_customer']");
	private By GWEstimatedQuantity = By.xpath("//input[@aria-label='GW Estimated Quantity']");// attribute=title
	private By GWActualQuantity = By.xpath("//input[@aria-label='GW Actual Quantity']");
	private By OSEstimatedQuantity = By.xpath("//input[@aria-label='OS Estimated Quantity']");
	private By OSActualQuantity = By.xpath("//input[@aria-label='OS Actual Quantity']");
	private By CalDepositOS = By.xpath("//input[@aria-label='Calculated Deposit OS']");
	private By CalDepositGW = By.xpath("//input[@aria-label='Calculated Deposit GW']");
	private By CalculatedDepositApp = By.xpath("//input[@aria-label='Calculated Deposit Based on Application']");
	private By CalculatedDepositActual = By.xpath("//input[@aria-label='Calculated Deposit Based on Actual Volume']");
	private By CalculatedDeposit = By.xpath("//input[@aria-label='Calculated Deposit']");
	private By depositAmount = By.xpath("//input[contains(@aria-label,'Deposit Amount')]");
	private By topUpRefund = By.xpath("//input[contains(@aria-label,'Refund')]");
	private By year = By.xpath("//input[@aria-label='Year']");
	private By wasteType = By.xpath("//ul[@aria-label='Selected values for Waste Type']/parent::div");

	// Locators for permitstatus at Tanker level
	private By editFilterBtn = By.xpath("//button[@aria-label='Edit filters']");
	private By selectedItem = By.xpath("//span[contains(@aria-labelledby,'selected-items-id')]");
	private By cancelItem = By.xpath("//span[text()='Remove']/..//i[@data-icon-name='Cancel']");
	private By listbox = By.xpath("//input[@aria-haspopup='listbox']");
	private By selectInactiveOption = By.xpath("//label[text()='Inactive']");

	private By colHeader = By.xpath("//div[@col-id='msdyn_account']");
	private By permitstatus = By.xpath("(//div[@col-id='pub_tankerpermitstatus'])[2]//label");

	private By custHeader = By.xpath("(//div[@col-id='pub_customer'])[1]");
	private By inactivePermit = By.xpath("//label[text()='Inactive Permits']");
	private By permitNumcol = By.xpath("(//div[@col-id='pub_name'])[1]");
	private By dropdownIcon = By.xpath("//i[@data-icon-name='ChevronDownSmall']");
	private By permitnumrowval = By.xpath("//div[@col-id='pub_name' and not(@role='columnheader')]//span");

	private By name = By.cssSelector("input[aria-label='Name']");
	private By GWCCompanyName = By.cssSelector("input[aria-label='GWC Company, Lookup']");
	private By tankerID = By.cssSelector("input[aria-label='Tanker ID, Lookup']");
	private By quantity = By.cssSelector("input[aria-label='Quantity']");
	private By invoiceDate = By.cssSelector("input[aria-label='Date of Invoice Date']");
	private By recalculate = By.cssSelector("button[aria-label='Recalculate']");
	private By moreAction = By.cssSelector("button[aria-label='More commands for Deposit']");
	private By importExcel = By.cssSelector("li[aria-label='Import from Excel']");
	private By fileUpload = By.cssSelector("input[aria-label='File Upload']");
	private By nextButton = By.cssSelector("button[aria-label='Next']");
	private By allowDuplicate = By.cssSelector("a[aria-label='Allow Duplicates: No']");
	private By finishImport = By.cssSelector("button[aria-label='Finish Import']");
	private By doneButton = By.cssSelector("button[aria-label='Done']");
	private By customerRadioButton = By
			.xpath("//div[contains(@class,'ms-Checkbox is-enabled RowSelectionCheckMarkSpan checkMark')]");
	private By customerDepositAmount1 = By.xpath("//div[@aria-rowindex='2'] //div[@col-id='pub_depositamount']");
	private By customerDepositAmount2 = By.xpath("//div[@aria-rowindex='3'] //div[@col-id='pub_depositamount']");
	private By giroValue1 = By.xpath("//div[@aria-rowindex='2'] //div[@col-id='pub_giro1']");
	private By giroValue2 = By.xpath("//div[@aria-rowindex='3']  //div[@col-id='pub_giro1']");

	private By reregisteringWithNewCompany = By.xpath("//select[@aria-label='Reregistering with new company']");
	private By caseNumberForTankerDeregister = By
			.xpath("//p[contains(text(),'A tanker has been Deregistered and required your approval')]"
					+ "/preceding::p[contains(text(),'DQB')]");
	private By caseNumberForCompliant = By
			.xpath("//p[contains(text(),'Case is compliant')]/preceding::p[contains(text(),'DQB')]");

	// Locators for blacklist a company
	private By blacklistSelect = By.xpath("//select[@aria-label='Blacklist']");
	private By blacklistedOnCalendar = By
			.xpath("//input[@aria-label='Date of Blacklisted On']/following-sibling::i[@data-icon-name='Calendar']");
	private By selectCurrentDate = By.xpath("//td[contains(@class,'ms-CalendarDay-daySelected')]");
	private By blacklistPeriod = By.xpath("//input[contains(@aria-label,'Period of Blacklisting')]");
	private By NEAlistgridAtCompanylvl = By.xpath("//h2[text()='NEA List']");
	private By BalcklistgridAtCompanylvl = By.xpath("//section[@aria-label='Blacklist Details']");
	private By TankerdetailsGridAtCompanylvl = By.xpath("//section[@aria-label='Tanker Details']");
	private By allemails = By.xpath("//label[text()='All Emails']");
	private By regardingFilterIcon = By.xpath("//div[@data-testid='regardingobjectid']");

	// Locators for Resealing
	private By SIESgrisAtTankerLvl = By.xpath("//h2[text()='SIES']");
	private By SealingdetailsAtTankerLvl = By.xpath("//h2[text()='Seal Number']");
	private By oldsealnumField = By.xpath("//input[@aria-label='Old Seal Number']");
	private By newsealnumField = By.xpath("//input[@aria-label='New Seal Number']");
	private By resealReaonField = By.xpath("//input[@aria-label='Reason for resealing']");
	private By dateOfResealField = By.xpath("//input[@aria-label='Date of Date of resealing']");

	// Locators for Audit
	private By tpConfigurationsField = By.xpath("//span[text()='TP Configurations']");
	private By noOfCasesForAudit = By.xpath("//span[text()='Number of Tanker Audit Cases to be scheduled']");
	private By configDate = By.xpath("//textarea[@aria-label='Config']");
	private By calendorIconFromFilter = By.xpath("//i[@aria-label='Filter by value']");
	private By rowsCount = By.xpath("//span[contains(@class,'statusTextContainer')]");

	public caseCreationPage(WebDriver driver) {
		super(driver);
		/*
		 * this.driver = driver; eleUtil = new ElementUtil(this.driver); jsutil = new
		 * JavaScriptUtil(this.driver); prop = eleUtil.readProperties(); common = new
		 * CommonActionsPage(TestBase.getDriver()); apppage = new
		 * ApplicationPage(TestBase.getDriver());
		 */
	}

	public void caseCreationCheck() throws InterruptedException {
		eleUtil.doClick(changeViewIcon);
		eleUtil.doClick(AcceptedApplicaion);
		eleUtil.waitForVisibilityOfElement(createdApp, 50);
		String entitynameFromApplication = eleUtil.doGetElementAttribute(createdApp, "aria-label");
		changeAreaSelection("Inspection");
		selectEntity("Cases");
		eleUtil.waitForVisibilityOfElement(entitydropdown, 50);
		eleUtil.doElementClickable(entitydropdown, 20);
		eleUtil.doClick(entitydropdown);
		eleUtil.doClick(filterBy);
		Thread.sleep(6000);
		eleUtil.doSendKeys(filterbyinputbox, commonActionsPage.Tankercompanyname);
		Thread.sleep(6000);
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
		Thread.sleep(3000);

		eleUtil.doElementClickable(applyBtn, 100);
		eleUtil.doClick(applyBtn);

		eleUtil.waitForVisibilityOfElement(entitynameOnCaseForm, 30);

		String entitynameonCase = eleUtil.doGetElementAttribute(entitynameOnCaseForm, "aria-label");
		System.out.println("entitynameonCase - " + entitynameonCase + "tankercompanyname - "
				+ commonActionsPage.Tankercompanyname);
		Assert.assertEquals(entitynameonCase, commonActionsPage.Tankercompanyname);
		System.out.println("Case created successfully");
		commonActionsPage.casenumber = getcaseID();

		assertTrue(commonActionsPage.casenumber.startsWith("DQB/TP/I"), "Case number format is not expected");
		System.out.println(commonActionsPage.casenumber);
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
		System.out.println("List of work orders is :" + all_elements_text);
		return all_elements_text;
	}

	public void caseFormValidation() throws InterruptedException {
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
		Thread.sleep(2000);
		eleUtil.scrollUsingRobotClass();
		String CaseFIO = eleUtil.doElementGetText(caseFIOField);
		String status = eleUtil.doElementGetText(statusField);
		System.out.println("status field" + status);
		String caseSubtypeonTop = eleUtil.doElementGetText(caseSubtypefromTop);
		/*
		 * String ownerFiledVal = eleUtil.doElementGetText(ownerField);
		 * System.out.println("Owner field" + ownerFiledVal);
		 */
		String caseIDfieldval = eleUtil.doElementGetText(caseIDAtTop);
		System.out.println("case id at top" + caseIDfieldval);
		String GWCRefNumVal = eleUtil.doElementGetText(GwcRefNum);

		assertTrue(BUField.contains("TP"), "BU is not same");
		assertTrue(Casetype.contains("Inspection Case"), "Case type is not same");
		assertTrue(CaseSubtype.contains("Tanker Permit Inspection"), "Case sub type is not same");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
		Date d = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("IST")).getTime(); // UTC
		String currentDateTime = formatter.format(d);
		assertTrue(CaseSO.contains("siesuser 5"), "SO is not same");
		assertTrue(CaseAO.contains("siesuser 6"), "AO is not same");
		assertTrue(CaseFIO.contains("siesuser 3"), "FIO is not same");

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
		commonActionsPage.GWCReferenceNum = GWCRefNumVal;
	}

	public void caseFIOSOAONames() {
		eleUtil.waitForVisibilityOfElement(caseSOField, 20);
		String CaseSO = eleUtil.doElementGetText(caseSOField);
		eleUtil.waitForVisibilityOfElement(caseAOField, 20);
		String CaseAO = eleUtil.doElementGetText(caseAOField);
		eleUtil.waitForVisibilityOfElement(caseFIOField, 20);
		String CaseFIO = eleUtil.doElementGetText(caseFIOField);
		commonActionsPage.case_FIO = CaseFIO;
		commonActionsPage.case_SO = CaseSO;
		commonActionsPage.case_AO = CaseAO;
	}

	public void changeView(String typeOfCases) {
		eleUtil.waitForVisibilityOfElement(changeViewIcon, 20);
		eleUtil.doElementClickable(changeViewIcon, 30);
		eleUtil.doClick(changeViewIcon);
		By viewXpath = By.xpath("//label[contains(text(),'" + typeOfCases + "')]");
		eleUtil.waitForVisibilityOfElement(viewXpath, 20);
		eleUtil.doClick(viewXpath);
	}

	public void rolesUpdate() {

		eleUtil.waitForVisibilityOfElement(By.xpath("//ul[@title='Case SO']"), 50);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//ul[@title='Case SO']"))).build().perform();

		eleUtil.doClick(By.xpath("//button[contains(@aria-label,'Delete')]"));

		eleUtil.waitForVisibilityOfElement(SOname, 20);
		eleUtil.doClick(SOname);
		eleUtil.doSendKeys(SOname, "Siesdev3@PUBSIES.onmicrosoft.com");
		System.out.println("about to click");
		driver.findElement(SOname).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		System.out.println("clicked");

	}

	public void openACase() throws InterruptedException {
		changeAreaSelection("Inspection");
		selectEntity("Cases");
	}

	public void searchACase() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(searchbox, 20);
		Thread.sleep(2000);
		eleUtil.doSendKeysLog(searchbox, commonActionsPage.casenumber, commonActionsPage.casenumber);
		//eleUtil.doSendKeysLog(searchbox, "CWQ/CM/I/2025/935", "CWQ/CM/I/2025/935");
		eleUtil.isPageLoaded(50);
		Thread.sleep(2000);
		driver.findElement(searchbox).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		selectFirstRecord();
		getFirstRecord();
	}

	public void searchChildCase() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(searchbox, 20);
		Thread.sleep(2000);
		eleUtil.doSendKeys(searchbox, commonActionsPage.childCaseNumber);
		//eleUtil.doSendKeys(searchbox, "IFA/WA/I/2024/36405");
		eleUtil.isPageLoaded(50);
		Thread.sleep(2000);
		driver.findElement(searchbox).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		selectFirstRecord();
		getFirstRecord();
	}

	public void navigatingToTab(String tabName) {

		By loc = By.xpath("//ul[@aria-label='Case Form']//li[@aria-label='" + tabName + "']");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eleUtil.waitForVisibilityOfElement(loc, 20);
		WebElement tab = driver.findElement(loc);
		tab.click();
	}

	public void navigatingToStage(String stageName) {
		By clickOnStage = By.xpath("//div[contains(@id,'stageNameContainer') and @title='" + stageName + "']");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		eleUtil.doElementClickable(clickOnStage, 130);
		// Define an array of click methods
		Runnable[] clickMethods = new Runnable[] { () -> eleUtil.doClickWithWait(clickOnStage, 40), // Standard click
				() -> eleUtil.doActionsClick(clickOnStage), // Actions click
				() -> jsutil.clickElementByJS(driver.findElement(clickOnStage)) // JavaScript click
		};
		// Define an array of click method names for logging
		String[] clickMethodNames = new String[] { "Standard click", "Actions click", "JavaScript click" };
		// Try each click method in order until one succeeds
		for (int i = 0; i < clickMethods.length; i++) {
			try {
				clickMethods[i].run();
				Log.info(clickMethodNames[i] + " succeeded");
				break; // If the click method succeeded, break out of the loop
			} catch (Exception e) {
				Log.info(clickMethodNames[i] + " failed: " + e.getMessage());
				// If the click method failed, continue to the next one
			}
		}
	}

	public void validateWOScheduleNotification() throws InterruptedException {
		commonActionsPage.WOnumber = getWONumber();
		List<String> woNum = commonActionsPage.WOnumber;
		for (String wo : woNum) {
			long endTime = System.currentTimeMillis() + 300000;
			while (System.currentTimeMillis() < endTime) {
				eleUtil.isPageLoaded(100);
				eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
				eleUtil.doClick(notificationIcon);
				Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement WOalert = null;
				try {
					WOalert = wait.until(ExpectedConditions.presenceOfElementLocated(
							By.xpath("//p[contains(text(),'You Have been scheduled for  Work Order " + wo + ". ')]")));
				} catch (TimeoutException e) {
					System.out.println("Work Order alert is not present on the page.");
				}
				if (WOalert != null && WOalert.isDisplayed()) {
					String actualAlertcontent = WOalert.getText();
					Log.info("actualAlertcontent " + actualAlertcontent);
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					String ExpectedAlertContent = "You Have been scheduled for Work Order " + wo + ". \"Tap to open\".";
					Log.info("ExpectedAlertContent is :" + ExpectedAlertContent);
					assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
					WebElement taptoopenBtn = driver.findElement(
							By.xpath("//p[contains(text(),'You Have been scheduled for  Work Order " + wo + ". ')]/a"));
					taptoopenBtn.click();
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					Log.info("open tabs" + tabs.size());
					driver.switchTo().window(tabs.get(1));
					eleUtil.waitForVisibilityOfElement(workordertext, 100);
					String afterTapToOpenBtn = eleUtil.doGetElementAttribute(workordertext, "Value");
					Log.info("afterTaptoOpenBtn:" + afterTapToOpenBtn);
					assertTrue(afterTapToOpenBtn.contains(wo), "WO is not same after clicking on tap to open button");
					Log.info(String.valueOf(tabs.size() - 1));
					eleUtil.doElementClickable(saveCloseBtn, 20);
					eleUtil.doClick(saveCloseBtn);
					driver.switchTo().window(tabs.get(0));
					eleUtil.doClick(cancelBtn);
					break;
				} else {
					eleUtil.doClickWithWait(cancelBtn, 30);
					eleUtil.doClickWithWait(refreshBtn, 30);
					eleUtil.doClickWithWait(workorderTab, 30);
					Log.error("In the notification Work Order is not visible");
				}
			}
		}
	}

	public void fillBookingDetails() throws InterruptedException {
		navigatingToTab("Work Orders");
		List<String> woNum = commonActionsPage.WOnumber;
		Log.info("size is:" + woNum.size());
		for (int i = 0; i < woNum.size(); i++) {
			Thread.sleep(2000);
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + woNum.get(i) + "']");
			eleUtil.doActionsClick(woele);
			eleUtil.waitForVisibilityOfElement(workordertext, 30);
			String actualWO = eleUtil.doGetElementAttribute(workordertext, "value");
			System.out.println("actual WO:" + actualWO);
			System.out.println("expected wo:" + woNum.get(i));
			assertTrue(actualWO.contains(woNum.get(i)), "WO is not same");

			// Validation on Booking tab
			eleUtil.doClick(bookingTab);
			Thread.sleep(2000);
			selectFirstRecord();
			getFirstRecord();

			eleUtil.doElementClickable(maximizescreenBtn, 10);
			eleUtil.doClick(maximizescreenBtn);

			eleUtil.doClickWithWait(bookingStatusField, 100);
			By selectAnOption = By.xpath("//button[@title='In Progress']");
			// eleUtil.staleElementRefExecClickCRM(selectAnOption);
			eleUtil.waitForVisibilityOfElement(selectAnOption, 100);
			eleUtil.doClick(selectAnOption);

			eleUtil.doElementClickable(saveOnBooking, 10);
			eleUtil.doClick(saveOnBooking);

			Thread.sleep(5000);
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

	public void workOrderValidation() throws InterruptedException, ParseException {
		List<String> wonum = commonActionsPage.WOnumber;
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
				eleUtil.waitForVisibilityOfElement(ele, AppConstants.LONG_DEFAULT_WAIT);
				li.get(0).click();
			} else {
				System.out.println("no alert present");
			}

			String actualWO = eleUtil.doGetElementAttribute(workordertext, "title");
			System.out.println("actual WO:" + actualWO);
			System.out.println("expected wo:" + wonum.get(i));
			assertTrue(actualWO.contains(wonum.get(i)), "WO is not same");

			// Validation on Booking tab
			eleUtil.doClick(bookingTab);
			eleUtil.waitForVisibilityOfElement(ele, 30);
			if (li.size() > 0) {
				eleUtil.waitForVisibilityOfElement(ele, AppConstants.MEDIUM_DEFAULT_WAIT);
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
			selectFirstRecord();
			getFirstRecord();
			eleUtil.doElementClickable(maximizescreenBtn, 10);
			eleUtil.doClick(maximizescreenBtn);
			eleUtil.doElementClickable(bookingStatusField, 30);
			eleUtil.doClick(bookingStatusField);
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

			commonActionsPage.starttimeval = getStarttime();
			System.out.println("start time after creating a booking record is:" + commonActionsPage.starttimeval);
			commonActionsPage.startdateval = getStartdate();
			System.out.println("start date after creating a booking record is:" + commonActionsPage.startdateval);
			Thread.sleep(5000);
			eleUtil.doClick(saveCloseBtn);

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

	public void complaincecheckInWorkorder(String status, String iscomplaint) {

		navigatingToTab("Work Orders");

		List<String> wonum = commonActionsPage.WOnumber;
		System.out.println("Size of wonum list is: " + wonum.size());

		for (int i = 0; i < wonum.size(); i++) {
			long startTime = System.currentTimeMillis();
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);

			if (iscomplaint.equalsIgnoreCase("No")) {
				System.out.println("Tanker is Non-Compliance");
				// continue;
			} else {
				boolean tankerRegNoDisplayed = false;
				while (!tankerRegNoDisplayed && (System.currentTimeMillis() - startTime) < 180000) {
					try {
						eleUtil.doClick(refreshBtn);
						eleUtil.waitForVisibilityOfElement(tankerregno, AppConstants.SHORT_DEFAULT_WAIT);
						// If tankerregno is displayed, set the flag to true to exit the loop
						if (driver.findElement(tankerregno).isDisplayed()) {
							tankerRegNoDisplayed = true;
						}
					} catch (StaleElementReferenceException e) {
						System.out.println("catching the exception");
					} catch (Exception e) {
						System.out.println("Button is not present");
					}
				}
			}

			if (iscomplaint.equalsIgnoreCase("No")) {
				System.out.println("Tanker is Non-Compliance");
			} else {
				By isComplaintchkInWOfrom = By
						.xpath("//select[@aria-label='Is Compliant?']/option[text()='" + iscomplaint + "']");
				eleUtil.waitForVisibilityOfElement(isComplaintchkInWOfrom, 100);
				String isComplaintVal = eleUtil.doElementGetText(isComplaintchkInWOfrom);
				System.out.println("complaince check - " + isComplaintVal);
				if (isComplaintVal.equals(iscomplaint)) {
					System.out.println("Tanker is Complaince");
				} else {
					System.out.println("Tanker is Non-Complaince");
				}
				assertEquals(eleUtil.doGetElementAttribute(WOstatusInWOform, "title"), status,
						"WO status not matching");
				// eleUtil.doClick(saveCloseBtn);
			}
			eleUtil.waitForVisibilityOfElement(saveCloseBtn, 30);
			eleUtil.doClick(saveCloseBtn);
		}
	}

	public void completeIdentifyStage() {
		navigatingToStage("Identify");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void confirmInspectionSchedule() {
		navigatingToStage("Assignment");
		eleUtil.waitForVisibilityOfElement(confirmInspectionScheduleOption, 10);
		eleUtil.createSelect(confirmInspectionScheduleOption);
		eleUtil.doSelectDropDownByVisibleText(confirmInspectionScheduleOption, "Yes");
		eleUtil.doClick(saveBtn);
	}

	public void completeAssignmnetStage() throws InterruptedException {
		navigatingToStage("Assignment");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
		eleUtil.doActionsClick(saveBtn);
	}

	public void completeInspectionNGenerateReport() {
		navigatingToStage("Inspection");
		eleUtil.waitForVisibilityOfElement(cases.getInspectionCompletedOption(), 10);
		eleUtil.createSelect(cases.getInspectionCompletedOption());
		eleUtil.doSelectDropDownByVisibleText(cases.getInspectionCompletedOption(), "Yes");
		eleUtil.doClick(saveBtn);
		navigatingToStage("Inspection");
		eleUtil.waitForVisibilityOfElement(generateInspectionReportOption, 50);
		eleUtil.createSelect(generateInspectionReportOption);
		eleUtil.doSelectDropDownByVisibleText(generateInspectionReportOption, "Yes");
		eleUtil.doClick(saveBtn);
		clickOnRefreshBtn();
	}

	public void SORejectForRework() {
		navigatingToStage("SO Review");
		eleUtil.waitForVisibilityOfElement(reworkOption, 10);
		eleUtil.createSelect(reworkOption);
		eleUtil.doSelectDropDownByVisibleText(reworkOption, "Yes");
		eleUtil.waitForFrameByIDOrName("FullPageWebResource", 30);
		eleUtil.doSendKeys(reworkCommentsBox, "Rework comments by SO");
		eleUtil.doClick(submitBtn);
		eleUtil.isPageLoaded(30);
	}

	public void movedBackToInspection() {

		navigatingToStage("Inspection");
		eleUtil.waitForVisibilityOfElement(Inspectioncompletedselectedoption, 10);
		String inspectioncompletedval = eleUtil.doElementGetText(Inspectioncompletedselectedoption);
		assertEquals(inspectioncompletedval, "No", "Inspection completed value not changed to default value");
		eleUtil.waitForVisibilityOfElement(generateInspectionReportselectedoption, 10);
		String generateinspectionval = eleUtil.doElementGetText(generateInspectionReportselectedoption);
		assertEquals(generateinspectionval, "No", "Generate inspection value not changed to default value");
		eleUtil.waitForVisibilityOfElement(submitforSOReviewselectedoption, 10);
		String submitSOreviewval = eleUtil.doElementGetText(submitforSOReviewselectedoption);
		System.out.println("submitSOreviewval:" + generateinspectionval);
		assertEquals(submitSOreviewval, "---", "SubmitToSOReview value not changed to default value");
	}

	public void changeWOFromCompletedToInprogress() throws InterruptedException, ParseException {
		navigatingToTab("Work Orders");
		List<String> wonum = commonActionsPage.WOnumber;
		System.out.println("size is:" + wonum.size());
		for (int i = 0; i < wonum.size(); i++) {
			Thread.sleep(2000);
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);

			// Validation on Booking tab
			eleUtil.waitForVisibilityOfElement(bookingTab, 30);
			eleUtil.doClick(bookingTab);
			Thread.sleep(2000);
			selectFirstRecord();
			getFirstRecord();

			eleUtil.doElementClickable(maximizescreenBtn, 10);
			eleUtil.doClick(maximizescreenBtn);
			eleUtil.doElementClickable(bookingStatusField, 50);
			eleUtil.doClick(bookingStatusField);
			By selectAnOption = By.xpath("//button[@title='In Progress']");
			eleUtil.waitForVisibilityOfElement(selectAnOption, 100);
			eleUtil.doClick(selectAnOption);
			eleUtil.isPageLoaded(30);
			// Adding 10 minuites to end time field and enter into the endTime field
			String StartTimeval = eleUtil.doGetElementAttribute(startTimeonBooking, "Value");
			System.out.println("StartTimeval" + StartTimeval);
			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			Date date = timeFormat.parse(StartTimeval);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MINUTE, 10);
			String result = timeFormat.format(cal.getTime());
			System.out.println(result);
			eleUtil.doElementClickable(endTimeonBooking, 30);
			eleUtil.doClick(endTimeonBooking);
			eleUtil.doClearUsingKeys(endTimeonBooking);
			eleUtil.doSendKeys(endTimeonBooking, result);

			eleUtil.doElementClickable(saveOnBooking, 10);
			eleUtil.doClick(saveOnBooking);

			Thread.sleep(5000);

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

			Thread.sleep(2000);
			eleUtil.isPageLoaded(30);

		}
	}

	public void verifyPermitAgreeementLetters(String lettername) {
		eleUtil.waitForVisibilityOfElement(allTabs, 50);
		eleUtil.doElementClickable(workorderTab, 30);
		navigatingToTab("Timeline");
		By ele = By.xpath(
				"//label[text()='Note modified by']//ancestor::div[contains(@id,'timeline_record')]//descendant::div[contains(text(),'"
						+ lettername + "')]");
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 30000) {
			try {
				// Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
				navigatingToTab("Timeline");
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

	public void inspectionReportCheck(String reportType) {
		navigatingToTab("Documents");
		boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				eleUtil.waitForVisibilityOfElement(morecommands, 30);
				eleUtil.doClick(morecommands);
				driver.findElement(By.xpath("//button[@aria-label='Refresh' and contains(@id,'pub_document')]"))
						.click();
				By ReportXpath = By.xpath("// label[@aria-label='" + reportType + "']");
				eleUtil.waitForVisibilityOfElement(ReportXpath, AppConstants.SHORT_DEFAULT_WAIT);
				if (driver.findElement(ReportXpath).isDisplayed()) {
					flag = true;
				}
			} catch (Exception e) {
				System.out.println("Inspection report is not present");
			}
		}
	}

	public void completeInspectionStage() {
		navigatingToStage("Inspection");
		eleUtil.waitForVisibilityOfElement(cases.getSubmitSOReviewBtn(), 10);
		eleUtil.createSelect(cases.getSubmitSOReviewBtn());
		eleUtil.doSelectDropDownByVisibleText(cases.getSubmitSOReviewBtn(), "Yes");
		eleUtil.doClick(saveBtn);
		// eleUtil.doClick(closeBtnOnBPF);
		eleUtil.isPageLoaded(10);
		navigatingToStage("Inspection");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public String permitnumval() {

		eleUtil.waitForVisibilityOfElement(permitnumber, 50);

		String str = eleUtil.doGetElementAttribute(permitnumber, "aria-label");
		if (!str.isEmpty()) {
			System.out.println("permit number is generated" + str);
		} else {
			System.out.println("permit number is blank");
		}
		return str;

	}

	public void permitnumCheck() throws ParseException {
		int i = 0;
		navigatingToTab("Work Orders");
		List<String> woName = commonActionsPage.WOnumber;
		System.out.println("size is:" + woName.size());
		for (i = 0; i < woName.size(); i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + woName.get(i) + "']");
			eleUtil.doActionsClick(woele);
			By isComplaintchkInWOfrom = By.xpath("//select[@aria-label='Is Compliant?']/option[@data-selected='true']");
			eleUtil.waitForVisibilityOfElement(isComplaintchkInWOfrom, 100);
			String isComplaintVal = eleUtil.doElementGetText(isComplaintchkInWOfrom);
			Log.info("isComplaintVal " + isComplaintVal);
			if (isComplaintVal.equalsIgnoreCase("No")) {
				System.out.println("Tanker is noncompalince. Permit will not be generated for this tanker");
			} else {
				eleUtil.doElementClickable(tankerNumberInWOform, 30);
				eleUtil.doClick(tankerNumberInWOform);
				clickOnRefreshBtn();
				clickOnRefreshBtn();
				commonActionsPage.permitnums.put("permits" + i, permitnumval());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
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
					// endDateYear = year + 1;//commented on 07/23
					endDateYear = year;
				} else if (month >= 1 && month <= 3) {
					stDateYear = year - 1;
					endDateYear = year;
				}
				// Financial year range from
				LocalDate startDate = LocalDate.of(stDateYear, 4, 1);
				LocalDate endDate = LocalDate.of(endDateYear, 3, 31);

				// Calculate the expire date based on the condition
				LocalDate ExpectedexpireDate = LocalDate.of(endDateYear, 3, 31);// Here we always want exp date tobe
				// mar-31

				// Print the result
				// System.out.println("Permit generation Date: " + letterdateval);
				// System.out.println("Expire Date: " + ExpectedexpireDate);

				// Format LocalDate as per our choice
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("M/dd/yyyy");// dd/M/yyyy --> modified on
				// 07/23
				String expireDateInString = ExpectedexpireDate.format(formatter1);
				System.out.println("Converted String (DateTimeFormatter): " + expireDateInString);

				System.out.println("--------------------");

				String expirydateval = eleUtil.doGetElementAttribute(expirydate, "aria-label");
				if (expirydateval.equals(expireDateInString)) {
					System.out.println("Expiry date is expected   " + "actual : " + expirydateval + "   Expected : "
							+ expireDateInString);
				} else {
					System.out.println(
							"Not as expected" + "actual : " + expirydateval + "Expected : " + expireDateInString);
				}
				jsutil.clickElementByJS(driver.findElement(backBtn));
			}
			eleUtil.doElementClickable(saveCloseBtn, 30);
			eleUtil.doClick(saveCloseBtn);
		}
		System.out.println("List of permits " + commonActionsPage.permitnums);// key=value
		System.out.println("put" + commonActionsPage.permitnums.get("permits" + i));// null
		System.out.println("keyset" + commonActionsPage.permitnums.keySet());// All keys
		System.out.println(permitnums.get("permits"));// null
	}

	public void validateSOReviewNotification() throws InterruptedException {
		for (Map.Entry<String, String> entry : commonActionsPage.permitnums.entrySet()) {
			System.out.println(entry.getValue());
			eleUtil.isPageLoaded(100);
			eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
			eleUtil.doClick(notificationIcon);
			// jsutil.zoomChromeEdgeSafari("80");
			Boolean flag = false;
			long startTime = System.currentTimeMillis();
			while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
				try {
					Thread.sleep(3000);
					String ExpectedAlertContent = "The Permit " + entry.getValue() + " has been submitted by "
							+ commonActionsPage.case_FIO + " and waiting for your review .\"Tap to Open\"";
					By ele = By.xpath("//p[contains(text(),'The Permit " + entry.getValue() + " has been submitted by "
							+ commonActionsPage.case_FIO + " and waiting for your review')]");
					eleUtil.waitForVisibilityOfElement(ele, 20);
					if (!driver.findElement(ele).isDisplayed()) {
						Boolean flag1 = false;

						while (!flag1) {
							try {
								Thread.sleep(30000);
								// eleUtil.waitForVisibilityOfElement(ele, AppConstants.SHORT_DEFAULT_WAIT);
								WebElement scrollDown = driver.findElement(By.xpath(
										"//div[contains(@class,'ms-Panel-scrollableContent scrollableContent')]//p[contains(text(),'The Permit "
												+ entry.getValue() + "has been submitted by "
												+ commonActionsPage.case_FIO + " and waiting for your review')]/a"));
								// jsutil.scrollIntoView(scrollDown);
								JavascriptExecutor js = (JavascriptExecutor) driver;
								js.executeScript("window.scrollIntoView(0,10000)");

								System.out.println("element clicked  : " + scrollDown);
								if (scrollDown.isDisplayed()) {
									flag1 = true;
								}

							} catch (Exception e) {

								System.out.println("element not found");
							}
						}

					}

					WebElement WOalert = driver.findElement(
							By.xpath("//p[contains(text(),'The Permit " + entry.getValue() + " has been submitted by "
									+ commonActionsPage.case_FIO + " and waiting for your review')]"));
					if (eleUtil.isClickable(WOalert, 10)) {
						String actualAlertcontent = WOalert.getText();
						System.out.println("actualAlertcontent" + actualAlertcontent);
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

						wait.until(ExpectedConditions.elementToBeClickable(WOalert));

						// permitNumber = CommonActionsPage.permitnums.entrySet().iterator().next();
						// String ExpectedAlertContent = "The Permit " + entry.getValue() + " has been
						// submitted by "
						// + CommonActionsPage.case_FIO + " and waiting for your review .\"Tap to
						// Open\"";
						System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
						assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
						WebElement taptoopenBtn = driver.findElement(By
								.xpath("//p[contains(text(),'The Permit " + entry.getValue() + " has been submitted by "
										+ commonActionsPage.case_FIO + " and waiting for your review')]/a"));
						taptoopenBtn.click();
						flag = true;
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						System.out.println("open tabs" + tabs.size());
						driver.switchTo().window(tabs.get(1));
						eleUtil.waitForVisibilityOfElement(permitnotext, 100);
						String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(permitnotext, "Value");
						System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
						assertTrue(afterTaptoOpenBtn.contains(entry.getValue()),
								"Permit number is not same after clicking on tap to open button");

						System.out.println(tabs.size() - 1);
						eleUtil.doElementClickable(saveCloseBtn, 20);
						eleUtil.doClick(saveCloseBtn);
						driver.switchTo().window(tabs.get(0));
						eleUtil.doClick(cancelBtn);
						// jsutil.zoomChromeEdgeSafari("100");

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void validateCaseComplaintNotification() throws InterruptedException {

		eleUtil.isPageLoaded(100);
		eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
		eleUtil.doClick(notificationIcon);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);

				WebElement WOalert = driver.findElement(By.xpath("//p[contains(text(),'Case is compliant')]"));
				if (eleUtil.isClickable(WOalert, 10)) {
					String actualAlertcontent = WOalert.getText();
					// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAULT_WAIT);
					System.out.println("actualAlertcontent" + actualAlertcontent);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					String ExpectedAlertContent = "' Case is compliant'. ''Tap to Open''.";
					System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
					assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
					WebElement taptoopenBtn = driver
							.findElement(By.xpath("//p[contains(text(),'Case is compliant')]/a"));
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
		eleUtil.waitForVisibilityOfElement(caseid, 100);
		String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(caseid, "Value");// need to update code here

		System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
		assertTrue(afterTaptoOpenBtn.contains(commonActionsPage.casenumber),
				"case is not same after clicking on tap to open button");
		System.out.println(tabs.size() - 1);
		// driver.switchTo().window(tabs.get(tabs.size() - 2));
		eleUtil.doElementClickable(saveCloseBtn, 20);
		eleUtil.doClick(saveCloseBtn);
		driver.switchTo().window(tabs.get(0));
		try {
			eleUtil.doClick(cancelBtn);
		} catch (Exception e) {
			eleUtil.doActionsClick(cancelBtn);
		}
	}

	public void validateReworkNotification() throws InterruptedException {

		eleUtil.isPageLoaded(100);
		eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
		eleUtil.doClick(notificationIcon);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);
				WebElement WOalert = driver.findElement(By.xpath("//p[contains(text(),'Case Alert')]"));
				if (eleUtil.isClickable(WOalert, 10)) {
					String actualAlertcontent = WOalert.getText();
					// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAULT_WAIT);
					System.out.println("actualAlertcontent" + actualAlertcontent);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					String ExpectedAlertContent = "Case Alert !" + commonActionsPage.casenumber
							+ " is Re-assigned to you.Tap to Open.";
					System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
					assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
					WebElement taptoopenBtn = driver.findElement(By.xpath("//p[contains(text(),'Case Alert')]/a"));
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
		eleUtil.waitForVisibilityOfElement(caseid, 100);
		String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(caseid, "Value");// need to update code here

		System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
		assertTrue(afterTaptoOpenBtn.contains(commonActionsPage.casenumber),
				"case is not same after clicking on tap to open button");
		System.out.println(tabs.size() - 1);
		// driver.switchTo().window(tabs.get(tabs.size() - 2));
		eleUtil.doElementClickable(saveCloseBtn, 20);
		eleUtil.doClick(saveCloseBtn);
		driver.switchTo().window(tabs.get(0));
		eleUtil.doClick(cancelBtn);
	}

	public void validateWOComplaintNotification() throws InterruptedException {
		eleUtil.isPageLoaded(100);
		eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
		eleUtil.doClick(notificationIcon);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);
				WebElement WOalert = driver.findElement(By.xpath("//p[contains(text(),'Compliant WO')]"));
				if (eleUtil.isClickable(WOalert, 10)) {
					String actualAlertcontent = WOalert.getText();
					// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAULT_WAIT);
					System.out.println("actualAlertcontent" + actualAlertcontent);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					String ExpectedAlertContent = "Compliant WO's of " + commonActionsPage.casenumber;
					System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
					assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
					WebElement taptoopenBtn = driver.findElement(
							By.xpath("//p[contains(text(),'Compliant WO')]/../following-sibling::div/p/a"));
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
		eleUtil.waitForVisibilityOfElement(caseid, 100);
		String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(caseid, "Value");// need to update code here

		System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
		assertTrue(afterTaptoOpenBtn.contains(commonActionsPage.casenumber),
				"case is not same after clicking on tap to open button");
		System.out.println(tabs.size() - 1);
		// driver.switchTo().window(tabs.get(tabs.size() - 2));
		eleUtil.doElementClickable(saveCloseBtn, 20);
		eleUtil.doClick(saveCloseBtn);
		driver.switchTo().window(tabs.get(0));
		try {
			eleUtil.doClick(cancelBtn);
		} catch (Exception e) {
			eleUtil.doActionsClick(cancelBtn);
		}
	}

	public void validateDeregisterNotification() throws InterruptedException {
		String actualCaseNumber = commonActionsPage.casenumber;
		long endTime = System.currentTimeMillis() + 300000;
		while (System.currentTimeMillis() < endTime) {
			eleUtil.isPageLoaded(100);
			eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
			eleUtil.doClick(notificationIcon);
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement WOalert = wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//p[contains(text(),'A tanker has been Deregistered " + "and required your approval')]")));
			if (WOalert != null && WOalert.isDisplayed()) {
				List<String> caseNumberForDeregisterTanker = eleUtil.getElementsTextList(caseNumberForTankerDeregister);
				if (caseNumberForDeregisterTanker.contains(actualCaseNumber)) {
					String actualAlertContent = WOalert.getText();
					Log.info("actualAlertContent: " + actualAlertContent);
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					String expectedAlertContent = "A tanker has been Deregistered and required your approval. \"Click here\".";
					Log.info("ExpectedAlertContent is: " + expectedAlertContent);
					assertTrue(actualAlertContent.contains(expectedAlertContent), "Alert content is not the same");
					WebElement tapToOpenBtn = driver.findElement(By.xpath(
							"//p[contains(text(),'A tanker has been Deregistered and required your approval')]/a"));
					tapToOpenBtn.click();
					ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
					Log.info("open tabs: " + tabs.size());
					driver.switchTo().window(tabs.get(1));
					eleUtil.waitForVisibilityOfElement(caseid, 100);
					String afterTapToOpenBtn = eleUtil.doGetElementAttribute(caseid, "Value");
					Log.info("afterTapToOpenBtn: " + afterTapToOpenBtn);
					assertTrue(afterTapToOpenBtn.contains(commonActionsPage.casenumber),
							"Case is not the same after clicking on tap to open button");
					eleUtil.doElementClickable(saveCloseBtn, 20);
					eleUtil.doClick(saveCloseBtn);
					driver.switchTo().window(tabs.get(0));
					eleUtil.doClick(cancelBtn);
					break;
				} else {
					eleUtil.doClickWithWait(cancelBtn, 30);
					eleUtil.doClickWithWait(refreshBtn, 30);
					Log.error("Actual Case number is not matched with the open Case number");
				}
			} else {
				eleUtil.doClickWithWait(cancelBtn, 30);
				eleUtil.doClickWithWait(refreshBtn, 30);
				Log.error("SO is not notified by tanker deregister notification");
			}
		}
	}

	public void validateRevocationNotification() throws InterruptedException {

		eleUtil.isPageLoaded(100);
		eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
		eleUtil.doClick(notificationIcon);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);

				WebElement WOalert = driver.findElement(By.xpath(
						"//p[contains(text(),'A tanker Permit has requested to be  Revoked and requires your review')]"));
				// JavascriptExecutor js = (JavascriptExecutor) driver;
				// js.executeScript("arguments[0].scrollIntoView(true);", WOalert);
				if (eleUtil.isClickable(WOalert, 10)) {
					String actualAlertcontent = WOalert.getText();
					// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAULT_WAIT);
					System.out.println("actualAlertcontent" + actualAlertcontent);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					String ExpectedAlertContent = "A tanker Permit has requested to be Revoked and requires your review /approval. \"Click here\".";
					System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
					assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
					WebElement taptoopenBtn = driver.findElement(By.xpath(
							"//p[contains(text(),'A tanker Permit has requested to be  Revoked and requires your review')]/a"));
					taptoopenBtn.click();
					flag = true;
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					System.out.println("open tabs" + tabs.size());
					driver.switchTo().window(tabs.get(1));
					// Thread.sleep(10000);
					eleUtil.waitForVisibilityOfElement(caseid, 100);
					String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(caseid, "Value");

					System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
					assertTrue(afterTaptoOpenBtn.contains(commonActionsPage.casenumber),
							"case is not same after clicking on tap to open button");
					System.out.println(tabs.size() - 1);
					// driver.switchTo().window(tabs.get(tabs.size() - 2));
					eleUtil.doElementClickable(saveCloseBtn, 20);
					eleUtil.doClick(saveCloseBtn);
					driver.switchTo().window(tabs.get(0));
					try {
						eleUtil.doClick(cancelBtn);
					} catch (Exception e) {
						eleUtil.doActionsClick(cancelBtn);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void validateResealingNotification() throws InterruptedException {

		eleUtil.isPageLoaded(100);
		eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
		eleUtil.doClick(notificationIcon);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);
				WebElement WOalert = driver.findElement(
						By.xpath("//p[contains(text(),'A tanker has requested to be  resealed and requires your')]"));
				// JavascriptExecutor js = (JavascriptExecutor) driver;
				// js.executeScript("arguments[0].scrollIntoView(true);", WOalert);
				if (eleUtil.isClickable(WOalert, 10)) {
					String actualAlertcontent = WOalert.getText();
					// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAULT_WAIT);
					System.out.println("actualAlertcontent" + actualAlertcontent);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					String ExpectedAlertContent = "A tanker has requested to be resealed and requires your approval. \"Click here\".";
					System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
					assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
					WebElement taptoopenBtn = driver.findElement(By.xpath(
							"//p[contains(text(),'A tanker has requested to be  resealed and requires your approval')]/a"));
					taptoopenBtn.click();
					flag = true;
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					System.out.println("open tabs" + tabs.size());
					driver.switchTo().window(tabs.get(1));
					// Thread.sleep(10000);
					eleUtil.waitForVisibilityOfElement(caseid, 100);
					String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(caseid, "Value");

					System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
					assertTrue(afterTaptoOpenBtn.contains(commonActionsPage.casenumber),
							"case is not same after clicking on tap to open button");
					System.out.println(tabs.size() - 1);
					// driver.switchTo().window(tabs.get(tabs.size() - 2));
					eleUtil.doElementClickable(saveCloseBtn, 20);
					eleUtil.doClick(saveCloseBtn);
					driver.switchTo().window(tabs.get(0));
					try {
						eleUtil.doClick(cancelBtn);
					} catch (Exception e) {
						eleUtil.doActionsClick(cancelBtn);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (!flag) {
				System.out.println("Notification not found within 5 minutes, canceling.");
				eleUtil.doClick(cancelBtn);
			}
		}
	}

	public void completeSOReviewStage() {
		navigatingToStage("SO Review");
		eleUtil.waitForVisibilityOfElement(submitAOreviewBtn, 10);
		eleUtil.createSelect(submitAOreviewBtn);
		eleUtil.doSelectDropDownByVisibleText(submitAOreviewBtn, "Yes");
		eleUtil.doClick(saveBtn);
		navigatingToStage("SO Review");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void completeAOReviewStage() throws InterruptedException {
		navigatingToStage("AO Review");
		eleUtil.waitForVisibilityOfElement(AOresponseOption, 10);
		eleUtil.createSelect(AOresponseOption);
		// eleUtil.doClick(AOresponseOption);
		eleUtil.doSelectDropDownByVisibleText(AOresponseOption, "Approve");
		eleUtil.doElementClickable(saveBtn, 10);
		eleUtil.doActionsClick(saveBtn);
		navigatingToStage("AO Review");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
		eleUtil.isPageLoaded(50);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if (driver.findElement(okBtn).isDisplayed()) {
		try {
			if (eleUtil.elementIsDisplayed(By.cssSelector("div[id='modalDialogContentContainer_1']"),
					"Saving in Progress Pop Up")) {
				eleUtil.waitForVisibilityOfElement(cases.getOkBtn(), 10);
				eleUtil.doClickLog(cases.getOkBtn(), "Click on ok button");
			} else {
				System.out.println("There in no OK button");
			}
		} catch (InterruptedException e) {
			System.out.println("An error occured while executin the loop");
		}
		crmActions.clickOnSavingInProgressOkButton();

	}

	public void completeGenerateEmailStage() {
		navigatingToStage("Generate Email");
		eleUtil.waitForVisibilityOfElement(generateemailOption, 10);
		eleUtil.createSelect(generateemailOption);
		eleUtil.isPageLoaded(40);
		if (eleUtil.doElementGetText(selectedGeneratedEmailValue).equals("No")) {
			eleUtil.doSelectDropDownByVisibleText(generateemailOption, "Yes");
		} else {
			Log.info("already value selected as Yes");
		}
		if (driver.findElement(emailtocustomerOption).isDisplayed()) {
			eleUtil.waitForVisibilityOfElement(emailtocustomerOption, 10);
			eleUtil.createSelect(emailtocustomerOption);
			eleUtil.doSelectDropDownByVisibleText(emailtocustomerOption, "Yes");
		} else {
			Log.info("This field is not available in this BPF");
		}
		clickOnSaveBtn();
		clickOnRefreshBtnOnHome();
		navigatingToStage("Generate Email");
		clickOnNextStageBtn();
		while (true) {
			try {
				eleUtil.waitForVisibilityOfElement(cases.getOkBtn(), 10);
				eleUtil.doClick(cases.getOkBtn());
			} catch (org.openqa.selenium.NoSuchElementException e) {
				break;
			}
		}
	}

	public void completeResolveStage() {
		navigatingToStage("Close");
		eleUtil.waitForVisibilityOfElement(endoresementreceivedOption, 10);
		if (driver.findElement(endoresementreceivedOption).isDisplayed()) {
			eleUtil.createSelectLog(endoresementreceivedOption, "Clicked on Endoresement Receiverd dropdown");
			eleUtil.doSelectDropDownByVisibleTextLog(endoresementreceivedOption, "Yes",
					"Selected Endoresement Receiverd dropdown value is : ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		eleUtil.waitForVisibilityOfElement(resolvecaseOption, 10);
		eleUtil.createSelectLog(resolvecaseOption, "Clicked on Resolve Case dropdown");
		eleUtil.doSelectDropDownByVisibleTextLog(resolvecaseOption, "Yes",
				"Selected Endoresement Resolve Case dropdown value is : ");
		eleUtil.waitForVisibilityOfElement(finishBtn, 10);
		eleUtil.doElementClickable(finishBtn, 10);
		try {
			eleUtil.doClickLog(finishBtn, "Click on Finish button");
		} catch (Exception e) {
			eleUtil.doActionsClickLog(finishBtn, "Click on Finish button");
		}
	}

	public void processingStage() {
		navigatingToStage("Processing");

		eleUtil.waitForVisibilityOfElement(processingOption, 10);
		eleUtil.doSelectDropDownByVisibleText(processingOption, "Yes");
		eleUtil.doElementClickable(saveBtn, 10);
		eleUtil.doActionsClick(saveBtn);

		navigatingToStage("Processing");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void processingStageToNextSatge() {
		navigatingToStage("Processing");
		eleUtil.waitForVisibilityOfElement(nextstageBtn, 20);
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void uploadDocInCase() throws AWTException {
		navigatingToTab("Documents");
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

		navigatingToTab("Work Orders");
		// eleUtil.doClick(wostatusField);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 30000) {
			try {
				Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
				navigatingToTab("Work Orders");
				eleUtil.waitForVisibilityOfElement(wostatusField, AppConstants.SHORT_DEFAULT_WAIT);
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

	public void manualWOCreation() throws InterruptedException {

		eleUtil.waitForVisibilityOfElement(newWOBtn, 20);
		eleUtil.doClick(newWOBtn);

		eleUtil.waitForVisibilityOfElement(applicationTanker, 50);
		eleUtil.doClick(applicationTanker);
		// driver.findElement(applicationTanker).sendKeys(CommonActionsPage.TankerName,
		// Keys.ARROW_DOWN, Keys.ENTER);
		eleUtil.doClear(applicationTanker);
		System.out.println(commonActionsPage.tankerNumber.get(1));
		eleUtil.doSendKeys(applicationTanker, commonActionsPage.tankerNumber.get(1));
		Thread.sleep(30000);
		By tankernumxpath = By.xpath("//li[contains(@data-id,'pub_applicationtankerid')]");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(tankernumxpath)).click().build().perform();

		eleUtil.doClick(quickcreateSaveNCloseBtn);
		eleUtil.isPageLoaded(30);
		// give wait for eleement visible WO STtaus= Uncheduled

		By manWOStatus = By.xpath("//label[@aria-label='Unscheduled']");
		eleUtil.waitForVisibilityOfElement(manWOStatus, 30);

		sortTheRecords(createdonCol, NewToOldCol, AppConstants.LONG_DEFAULT_WAIT);

		WebElement Workordernum = driver.findElement(By.xpath("(//div[@col-id='msdyn_name']//descendant::a)[1]"));
		By ele2 = By.xpath("(//div[@col-id='msdyn_name']//descendant::a)[1]");
		String manwotext = eleUtil.doGetElementAttribute(ele2, "aria-label");
		System.out.println("manwotext is" + manwotext);
		commonActionsPage.WOnumber.add(manwotext);
		System.out.println("new WOrk order list is " + commonActionsPage.WOnumber);

	}

	public void manualBookableResource() throws ParseException, InterruptedException {
		selectFirstRecord();
		getFirstRecord();
		// Validation on Booking tab
		eleUtil.waitForVisibilityOfElement(bookingTab, 30);
		eleUtil.doClick(bookingTab);

		eleUtil.waitForVisibilityOfElement(newBookableresourceBtn, 100);
		eleUtil.doClick(newBookableresourceBtn);
		eleUtil.doElementClickable(bookingStatusManualWO, 50);
		eleUtil.doClick(bookingStatusManualWO);
		By selectAnOption = By.xpath("//button[@title='In Progress']");
		eleUtil.waitForVisibilityOfElement(selectAnOption, 100);
		eleUtil.doClick(selectAnOption);
		eleUtil.isPageLoaded(30);
		// Adding 10 minuites to end time field and enter into the endTime field
		Thread.sleep(3000);
		String StartDateval = eleUtil.doGetElementAttribute(startDateManualWO, "value");
		String StartTimeval = eleUtil.doGetElementAttribute(startTimeManualWO, "value");
		System.out.println("StartDateval=" + StartDateval);
		System.out.println("StartTimeval=" + StartTimeval);

		eleUtil.doElementClickable(endDateManualWO, 30);
		eleUtil.doClick(endDateManualWO);
		Thread.sleep(15000);
		eleUtil.doClick(endDateManualWO);
		Thread.sleep(1000);
		eleUtil.doClearUsingKeys(endDateManualWO);
		// Thread.sleep(1000);
		eleUtil.doSendKeys(endDateManualWO, StartDateval);
		driver.findElement(endDateManualWO).sendKeys(Keys.ENTER);

		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		Date date = timeFormat.parse(StartTimeval);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, 10);
		String result = timeFormat.format(cal.getTime());
		System.out.println(result);
		eleUtil.doElementClickable(endTimeManualWO, 30);
		eleUtil.doClick(endTimeManualWO);
		eleUtil.doClearUsingKeys(endTimeManualWO);
		eleUtil.doSendKeys(endTimeManualWO, result);

		eleUtil.waitForVisibilityOfElement(resource, 50);
		eleUtil.doClick(resource);
		eleUtil.doClear(resource);
		eleUtil.doSendKeys(resource, commonActionsPage.case_FIO);
		Thread.sleep(30000);
		By resourcexpath = By.xpath("//li[contains(@data-id,'resource.field')]");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(resourcexpath)).click().build().perform();
		// eleUtil.doActionsClick(fioxpath);
		/*
		 * driver.findElement(resource).sendKeys(Keys.ARROW_DOWN); Thread.sleep(10000);
		 * driver.findElement(resource).sendKeys(Keys.ENTER);
		 */
		// eleUtil.isPageLoaded(10);
		eleUtil.doElementClickable(saveOnBooking, 10);
		eleUtil.doClick(saveOnBooking);

		Thread.sleep(5000);

		signTheChecklist();

		eleUtil.doElementClickable(saveOnBooking, 10);
		eleUtil.doClick(saveOnBooking);

		eleUtil.doElementClickable(saveNCloseOnBooking, 10);
		eleUtil.doClick(saveNCloseOnBooking);

		while (true) {
			try {
				eleUtil.doElementClickable(saveNContinueBtn, 30);
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

	public void manualCaseCreation(String caseSubType) throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(newBtn, 50);
		eleUtil.doElementClickable(newBtn, 20);
		jsutil.clickElementByJS(driver.findElement(newBtn));
		eleUtil.doElementClickable(caseSubtypeField, 30);
		eleUtil.createSelect(caseSubtypeField);
		eleUtil.doSelectDropDownByVisibleText(caseSubtypeField, caseSubType);

		eleUtil.waitForVisibilityOfElement(entityLookupField, 50);
		eleUtil.doClick(entityLookupField);
		eleUtil.doClear(entityLookupField);
		System.out.println(commonActionsPage.Tankercompanyname);
		eleUtil.doSendKeys(entityLookupField, commonActionsPage.Tankercompanyname);
		// eleUtil.doSendKeys(entityLookupField, "Tankcompany31072024070710");
		Thread.sleep(25000);
		By tankercompanyxpath = By.xpath("//li[contains(@data-id,'customerid')]");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(tankercompanyxpath)).click().build().perform();

		eleUtil.doClick(saveBtn);

		eleUtil.isPageLoaded(30);

		Thread.sleep(4000);
		System.out.println("title :" + eleUtil.doGetElementAttribute(caseid, "title"));
		commonActionsPage.casenumber = eleUtil.doGetElementAttribute(caseid, "title");
		System.out.println("updated case number : " + commonActionsPage.casenumber);

	}

	public void tankerToDeregister() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(moreCommandsForDereg, 30);
		eleUtil.doElementClickable(moreCommandsForDereg, 20);
		jsutil.clickElementByJS(driver.findElement(moreCommandsForDereg));
		eleUtil.doElementClickable(newCaseTanker, 20);
		eleUtil.doClick(newCaseTanker);
		eleUtil.waitForVisibilityOfElement(tankerLookupField, 50);
		eleUtil.doClick(tankerLookupField);
		eleUtil.doClear(tankerLookupField);
		System.out.println(commonActionsPage.tankerNumber.get(1));
		eleUtil.doSendKeys(tankerLookupField, commonActionsPage.tankerNumber.get(1));
		// eleUtil.doSendKeys(tankerLookupField, "T_310724070705");
		Thread.sleep(25000);
		By tankerxpath = By.xpath("//li[contains(@data-id,'pub_tanker')]");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(tankerxpath)).click().build().perform();
		Thread.sleep(3000);
		eleUtil.waitForVisibilityOfElement(saveBtn, 50);
		eleUtil.doClickWithWait(saveBtn, 100);
		eleUtil.doClickWithWait(saveCloseBtn, 100);
	}

	public void verifyDeregisteredTankers() {
		navigatingToTab("Inspection Case Information");
		eleUtil.waitForVisibilityOfElement(entityLink, 20);
		eleUtil.doClick(entityLink);
		driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		String permitStatusAtCompanyLevel = eleUtil.doElementGetText(tankerStatusOnCompanyLvl);
		Log.info("permitStatusAtCompanyLevel" + permitStatusAtCompanyLevel);
		assertEquals(permitStatusAtCompanyLevel, "Deregistered", "Tanker permit status is not showing as Deregistered");
		jsutil.scrollIntoView(driver.findElement(permitGridAtCompanyLvl));
		String str = eleUtil.doElementGetText(permitGridAtCompanyLvl);
		assertEquals(str, "No data available", "Permits are not removed from the company");
		jsutil.scrollPageUp();
		eleUtil.waitForVisibilityOfElement(backBtn, 10);
		eleUtil.doClick(backBtn);
	}

	public void tankerPermitStatusAtTankerLvl() throws InterruptedException {

		changeAreaSelection("GWC Tanker");

		selectEntity("GWC Tankers");

		eleUtil.waitForVisibilityOfElement(editFilterBtn, 30);
		eleUtil.doClick(editFilterBtn);
		eleUtil.waitForVisibilityOfElement(cancelItem, 30);
		eleUtil.doClick(cancelItem);
		eleUtil.waitForVisibilityOfElement(listbox, 30);
		eleUtil.doClick(listbox);
		eleUtil.waitForVisibilityOfElement(selectInactiveOption, 30);
		eleUtil.doClick(selectInactiveOption);
		eleUtil.waitForVisibilityOfElement(applyBtn, 30);
		eleUtil.doClick(applyBtn);

		eleUtil.waitForVisibilityOfElement(colHeader, 50);
		eleUtil.doElementClickable(colHeader, 20);
		eleUtil.doClick(colHeader);
		eleUtil.doClick(filterBy);
		Thread.sleep(6000);
		eleUtil.doSendKeys(filterbyinputbox, commonActionsPage.tankerNumber.get(1));
		Thread.sleep(6000);
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);

		eleUtil.waitForVisibilityOfElement(permitstatus, 50);
		eleUtil.doGetElementAttribute(permitstatus, "aria-label");
		System.out.println("permit status is" + eleUtil.doGetElementAttribute(permitstatus, "aria-label"));

	}

	public void tankerPermitStatusAtPermitLvl() throws InterruptedException {

		changeAreaSelection("GWC Tanker");

		selectEntity("Permits");

		eleUtil.waitForVisibilityOfElement(changeViewIcon, 50);
		eleUtil.doClick(changeViewIcon);
		eleUtil.doClick(inactivePermit);

		for (Map.Entry<String, String> entry : commonActionsPage.permitnums.entrySet()) {
			eleUtil.doElementClickable(permitNumcol, 20);
			eleUtil.doClick(permitNumcol);
			eleUtil.doClick(filterBy);
			Thread.sleep(6000);
			eleUtil.doSendKeys(filterbyinputbox, entry.getValue());
			Thread.sleep(6000);
			driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);

			eleUtil.waitForVisibilityOfElement(permitnumrowval, 20);
			System.out.println("permit number is" + eleUtil.doElementGetText(permitnumrowval));

			assertEquals(eleUtil.doElementGetText(permitnumrowval), entry.getValue(), "permit number is not matching");

		}

	}

	public void balcklistACompany(String period) {

		eleUtil.waitForVisibilityOfElement(entityLink, 20);
		eleUtil.doClick(entityLink);

		eleUtil.waitForVisibilityOfElement(NEAlistgridAtCompanylvl, 10);

		jsutil.scrollIntoView(driver.findElement(BalcklistgridAtCompanylvl));
		eleUtil.waitForVisibilityOfElement(blacklistSelect, 20);
		eleUtil.createSelect(blacklistSelect);
		eleUtil.doSelectDropDownByVisibleText(blacklistSelect, "Yes");
		eleUtil.waitForVisibilityOfElement(blacklistedOnCalendar, 20);
		eleUtil.doClick(blacklistedOnCalendar);
		eleUtil.waitForVisibilityOfElement(selectCurrentDate, 20);
		eleUtil.doClick(selectCurrentDate);
		eleUtil.waitForVisibilityOfElement(blacklistPeriod, 20);
		eleUtil.doClick(blacklistPeriod);
		eleUtil.doSendKeys(blacklistPeriod, period);

		eleUtil.waitForVisibilityOfElement(saveBtn, 10);
		eleUtil.doClick(saveBtn);

		eleUtil.waitForVisibilityOfElement(saveCloseBtn, 20);
		eleUtil.doClick(saveCloseBtn);
		eleUtil.isPageLoaded(30);
	}

	public void emailsFromEmailmessages() throws InterruptedException {
		changeAreaSelection("Inspection");

		selectEntity("Email Messages");
		eleUtil.waitForVisibilityOfElement(changeViewIcon, 20);
		eleUtil.doClick(changeViewIcon);

		eleUtil.waitForVisibilityOfElement(allemails, 20);
		eleUtil.doClick(allemails);

		eleUtil.waitForVisibilityOfElement(regardingFilterIcon, 50);
		eleUtil.doElementClickable(regardingFilterIcon, 20);
		eleUtil.doClick(regardingFilterIcon);
		eleUtil.doClick(filterBy);
		eleUtil.waitForVisibilityOfElement(filterBy, 60);
		eleUtil.doSendKeys(filterbyinputbox, commonActionsPage.Tankercompanyname);
		eleUtil.waitForVisibilityOfElement(filterBy, 60);
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
		eleUtil.waitForVisibilityOfElement(applyBtn, 30);
		eleUtil.doClick(applyBtn);

		String ExpectedBlacklistEmail = "Account " + commonActionsPage.Tankercompanyname + " has been Blacklisted";
		By ele = By.xpath("//a[contains(@aria-label,'has been Blacklisted')]");
		String actualBlacklistEmail = eleUtil.doGetElementAttribute(ele, "aria-label");
		assertEquals(actualBlacklistEmail, ExpectedBlacklistEmail, "Blacklist email is not generated");
	}

	public void resealingTankersInfoCheck() {
		navigatingToTab("Inspection Case Information");

		eleUtil.waitForVisibilityOfElement(entityLink, 20);
		eleUtil.doClick(entityLink);

		eleUtil.waitForVisibilityOfElement(NEAlistgridAtCompanylvl, 10);

		jsutil.scrollIntoView(driver.findElement(TankerdetailsGridAtCompanylvl));
		eleUtil.waitForVisibilityOfElement(tankerLink, 20);
		eleUtil.doClick(tankerLink);

		eleUtil.waitForVisibilityOfElement(SIESgrisAtTankerLvl, 20);
		jsutil.scrollIntoView(driver.findElement(SealingdetailsAtTankerLvl));

		String oldsealnumFieldVal = eleUtil.doGetElementAttribute(oldsealnumField, "title");
		assertEquals(oldsealnumFieldVal, commonActionsPage.oldSealNumber,
				"Old Seal Number field value is not matching");

		String newsealnumFieldVal = eleUtil.doGetElementAttribute(newsealnumField, "title");
		assertEquals(newsealnumFieldVal, commonActionsPage.newSealNumber,
				"New Seal Number field value is not matching");

		String resealReaonFieldVal = eleUtil.doGetElementAttribute(resealReaonField, "title");
		assertEquals(resealReaonFieldVal, commonActionsPage.resealReason, "Reseal reason field value is not matching");

		/*
		 * String dateOfResealFieldVal =
		 * eleUtil.doGetElementAttribute(dateOfResealField,"title");
		 * assertEquals(dateOfResealFieldVal, "",
		 * "Reseal date field value is not matching");
		 */

		eleUtil.waitForVisibilityOfElement(backBtn, 10);
		eleUtil.doClick(backBtn);

		eleUtil.waitForVisibilityOfElement(backBtn, 10);
		eleUtil.doClick(backBtn);

	}

	public void tpConfigChangeForAudit() throws InterruptedException {
		changeAreaSelection("Settings");

		selectEntity("TP Configurations");

		eleUtil.waitForVisibilityOfElement(noOfCasesForAudit, 20);
		eleUtil.doClick(noOfCasesForAudit);
		eleUtil.waitForVisibilityOfElement(configDate, 20);
		eleUtil.doClear(configDate);

		LocalDate today = LocalDate.now();

		// Define the desired format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = today.format(formatter);
		eleUtil.doClearUsingKeys(configDate);
		eleUtil.doSendKeys(configDate, formattedDate);
		eleUtil.waitForVisibilityOfElement(saveBtn, 30);
		eleUtil.doClick(saveBtn);
		eleUtil.waitForVisibilityOfElement(saveCloseBtn, 30);
		eleUtil.doClick(saveCloseBtn);
	}

	public void verifyingCreatedCases() throws InterruptedException {
		selectEntity("Cases");
		changeView("Tanker Audit Inspection Cases");
		eleUtil.isPageLoaded(30);
		By createdonCol = By.xpath("//div[@col-id='createdon']");
		eleUtil.waitForVisibilityOfElement(createdonCol, 20);
		eleUtil.doElementClickable(createdonCol, 20);
		eleUtil.doClick(createdonCol);
		eleUtil.doClick(filterBy);
		eleUtil.doClick(calendorIconFromFilter);
		eleUtil.doClick(selectCurrentDate);
		eleUtil.doClick(applyBtn);
		eleUtil.waitForVisibilityOfElement(rowsCount, 20);
		String rowsText = eleUtil.doElementGetText(rowsCount);
		String rowsCountVal = rowsText.substring(6);
		Log.info("Rows count : " + rowsCountVal);
		assertEquals(rowsCountVal, "10", "Created cases are not equal to 10");
	}

	public void GWEstQuan(String GWPerMonth) {
		eleUtil.waitForVisibilityOfElement(GWEstimatedQuantity, 10);
		String actualGWEstimatedQuantity = eleUtil.doGetElementAttribute(GWEstimatedQuantity, "title");
		assertEquals(actualGWEstimatedQuantity, GWPerMonth, "GW Estimated quantity not matching");
	}

	public int OSEstQuan(String OSSPerMonth, String OSIPerMonth) {
		int Average = (Integer.valueOf(OSSPerMonth) + Integer.valueOf(OSIPerMonth)) / 2;
		return Average;
	}

	public int calculatedDepositOS(String OSSPerMonth, String OSIPerMonth) {
		int expectedcalculatedDepositOS = OSEstQuan(OSSPerMonth, OSIPerMonth) * 38;
		return expectedcalculatedDepositOS;
	}

	public int calculatedDepositGW(String GWPerMonth) {
		int expectedcalculatedDepositGW = Integer.valueOf(GWPerMonth) * 2;
		return expectedcalculatedDepositGW;
	}

	public int calculatedDepositBasedOnApp(String OSSPerMonth, String OSIPerMonth, String GWPerMonth) {
		int val = calculatedDepositOS(OSSPerMonth, OSIPerMonth) + calculatedDepositGW(GWPerMonth);
		return val;
	}

	public void depoitAmountRecotrdCreation() throws InterruptedException {
		changeAreaSelection("GWC Tanker");
		selectEntity("Deposits");

	}

	public void paymentRecordValidation(String OSSPerMonth, String OSIPerMonth, String GWPerMonth, String wastetype)
			throws InterruptedException {
		eleUtil.doElementClickable(customerName, 30);
		eleUtil.doClick(customerName);
		eleUtil.waitForVisibilityOfElement(customerName, 50);
		eleUtil.doElementClickable(customerName, 100);
		eleUtil.doClick(customerName);
		eleUtil.doClick(filterBy);
		eleUtil.doSendKeys(filterbyinputbox, commonActionsPage.Tankercompanyname);
		Thread.sleep(3000);
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
		eleUtil.doClick(applyBtn);

		selectFirstRecord();
		getFirstRecord();
		switch (wastetype) {
		case "Greasy Waste":
			eleUtil.waitForVisibilityOfElement(wasteType, 20);
			assertEquals(eleUtil.doGetElementAttribute(wasteType, "title"), "Greasy Waste",
					"Wate type is not matching");
			GWEstQuan(GWPerMonth);
			assertEquals(eleUtil.doGetElementAttribute(OSEstimatedQuantity, "title"), "0.00",
					"OS Estimated quantity not matching");
			break;
		case "Organic Sludge":
			eleUtil.waitForVisibilityOfElement(wasteType, 20);
			assertEquals(eleUtil.doGetElementAttribute(wasteType, "title"),
					"Organic Sludge – Ships, Organic Sludge – Industries", "Wate type is not matching");
			eleUtil.waitForVisibilityOfElement(OSEstimatedQuantity, 10);
			String actualOSEstimatedQuantity = eleUtil.doGetElementAttribute(OSEstimatedQuantity, "title");
			int averageVal = OSEstQuan(OSSPerMonth, OSIPerMonth);
			String expectedOSEstimatedQuantity = Integer.toString(averageVal);
			assertEquals(actualOSEstimatedQuantity, expectedOSEstimatedQuantity, "OS Estimated quantity not matching");
			assertEquals(eleUtil.doGetElementAttribute(GWEstimatedQuantity, "title"), "0.00",
					"OS Estimated quantity not matching");
			break;
		case "Graesy Waste and Organic Sludge":
			eleUtil.waitForVisibilityOfElement(wasteType, 20);
			assertEquals(eleUtil.doGetElementAttribute(wasteType, "title"),
					"Greasy Waste, Organic Sludge – Ships, Organic Sludge – Industries", "Wate type is not matching");
			GWEstQuan(GWPerMonth);
			eleUtil.waitForVisibilityOfElement(OSEstimatedQuantity, 10);
			actualOSEstimatedQuantity = eleUtil.doGetElementAttribute(OSEstimatedQuantity, "title");
			averageVal = OSEstQuan(OSSPerMonth, OSIPerMonth);
			expectedOSEstimatedQuantity = Integer.toString(averageVal);
			assertEquals(actualOSEstimatedQuantity, expectedOSEstimatedQuantity, "OS Estimated quantity not matching");
			break;
		}

	}

	public void mailGeneratedOrNot(String mailType) throws InterruptedException, ParseException {
		clickOnRefreshBtn();
		navigatingToTab("Timeline");
		// eleUtil.isPageLoaded(100);
		Thread.sleep(2000);
		By ele;
		switch (mailType) {

		case "Inspection Schedule":
			String mailTrigger;
			ele = By.xpath("//label[contains(text(),'Inspection Appointment')]");
			// String mailTrigger = eleUtil.doElementGetText(ele);
			// assertTrue(mailTrigger.contains("Inspection Appointment"), "Mail is not
			// generated");
			// ----------

			boolean flag = false;
			long startTime = System.currentTimeMillis();
			ele = By.xpath("//label[contains(text(),'Inspection Appointment')]");
			while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
				try {
					for (int i = 0; i <= commonActionsPage.tankerNumberSize.get("tankersize"); i++) {

						eleUtil.waitForVisibilityOfElement(morecommandsInTimeline, 30);
						eleUtil.doClick(morecommandsInTimeline);
						driver.findElement(By.xpath("//div[text()='Refresh timeline']")).click();

						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
						eleUtil.waitForVisibilityOfElement(ele, AppConstants.SHORT_DEFAULT_WAIT);
						List<WebElement> emailElements = driver.findElements(ele);
						for (WebElement email : emailElements) {
							// if(CommonActionsPage.tankerNumberSize.get("tanker
							// size").equals(email.getSize()))
							String emailContent = email.getText();
							if (emailContent.contains("Inspection Appointment")) {
								System.out.println("Email related to Inspection Appointment: " + emailContent);
								assertTrue(emailContent.contains("Inspection Appointment"), "Mail is not generated");
								// flag = true;
								// break;

							}
						}
						flag = true;

						if (flag) {
							System.out.println("Email with Inspection Appointment found.");
						} else {
							System.out.println("Email with Inspection Appointment not found.");
							// Add assertion for failure if necessary
							// assertTrue(foundEmail, "Mail is not generated");
						}
					}
				} catch (NoSuchElementException e) {
					System.out.println("Element not found: ");
				} catch (TimeoutException e) {
					System.out.println("Timeout waiting for element visibility: ");
				} catch (Exception e) {
					System.out.println("Exception occurred: ");
				}
			}

			break;
		case "Permit generation":
			ele = By.xpath("//label[text()='Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)']");
			mailTrigger = eleUtil.doElementGetText(ele);
			assertTrue(mailTrigger.contains("Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)"),
					"Mail is not generated");
			// Assert.assertEquals(true,driver.findElement(attachment).isDisplayed());
			ele = By.xpath(
					"//label[text()='Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)']//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(attachment, 30);
			if (driver.findElement(attachment).isDisplayed()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			eleUtil.doElementClickable(backBtn, 50);
			eleUtil.doClick(backBtn);
			break;
		case "Permit WRP email":
			ele = By.xpath("//label[contains(text(),'For your assistance')]");

			mailTrigger = eleUtil.doElementGetText(ele);
			assertTrue(mailTrigger.contains("For your assistance"), "Mail is generated");
			ele = By.xpath(
					"//label[contains(text(),'For your assistance')]//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(attachment, 30);
			if (driver.findElement(attachment).isDisplayed()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			eleUtil.doElementClickable(backBtn, 50);
			eleUtil.doClick(backBtn);
			break;
		case "Tanker non-complaince":
			ele = By.xpath("//label[text()='Tanker failed inspection']");

			flag = false;
			startTime = System.currentTimeMillis();
			ele = By.xpath("//label[contains(text(),'Tanker failed inspection')]");
			while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
				try {
					eleUtil.waitForVisibilityOfElement(morecommandsInTimeline, 30);
					eleUtil.doClick(morecommandsInTimeline);
					driver.findElement(By.xpath("//div[text()='Refresh timeline']"))// button[contains(@aria-label,'Refresh')
							// and contains(@id,'pub_document')]
							.click();
					eleUtil.waitForVisibilityOfElement(ele, AppConstants.SHORT_DEFAULT_WAIT);
					if (driver.findElement(ele).isDisplayed()) {
						flag = true;
						mailTrigger = eleUtil.doElementGetText(ele);
						assertTrue(mailTrigger.contains("Tanker failed inspection"), "Mail is not generated");

					}
				} catch (Exception e) {
					// Log the specific exception message for better debugging
					System.out.println("Non-Complaince email is not displayed");
				}
			}

			break;

		case "Tanker Deregistration":
			ele = By.xpath("(//label[contains(text(),'Deregistration of')])[1]");
			eleUtil.waitForVisibilityOfElement(ele, 20);
			mailTrigger = eleUtil.doElementGetText(ele);
			assertTrue(mailTrigger.contains("Deregistration of"), "Mail is not generated");

			break;
		case "Tanker Resealing":
			ele = By.xpath("//label[contains(text(),'Tanker Resealing Email')]");
			eleUtil.waitForVisibilityOfElement(ele, 20);
			mailTrigger = eleUtil.doElementGetText(ele);
			assertTrue(mailTrigger.contains("Tanker Resealing Email"), "Mail is not generated");

			break;

		}

	}

	

	public void paymentWasteTypeValidation() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(customerName, 50);
		eleUtil.doElementClickable(customerName, 100);
		eleUtil.doClick(customerName);
		eleUtil.doClick(filterBy);
		eleUtil.doSendKeys(filterbyinputbox, commonActionsPage.Tankercompanyname);
		Thread.sleep(3000);
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
		eleUtil.doClick(applyBtn);
		selectFirstRecord();
		getFirstRecord();
		eleUtil.waitForVisibilityOfElement(wasteType, 20);
		String actualWasteType = eleUtil.doGetElementAttributeLog(wasteType, "title", "Get the Waste Type: ");
		assertEquals(actualWasteType, "Greasy Waste, Organic Sludge – Ships, Organic Sludge – Industries",
				"Waste type is not matching");
	}

	public void paymentRecordBeforeActualQuantitiesValidation(int GWPerMonth, int OSSPerMonth, int OSIPerMonth)
			throws InterruptedException {
		// Calculation for Payment
		float totalOSEstimatedQuantity = OSSPerMonth + OSIPerMonth;
		float totalActualCalDepositOS = totalOSEstimatedQuantity * 38;
		float totalActualCalDepositGW = (float) (GWPerMonth * 10.8605);
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		float totalActualCalculatedDepositApp = (totalActualCalDepositGW + totalActualCalDepositOS) * 2;
		eleUtil.waitForVisibilityOfElement(GWEstimatedQuantity, 10);
		float actualGWEstimatedQuantity = Float.parseFloat(eleUtil.doGetElementAttribute(GWEstimatedQuantity, "title"));
		assertEquals(actualGWEstimatedQuantity, GWPerMonth, "GW Estimated Quantity not matching");

		eleUtil.waitForVisibilityOfElement(GWActualQuantity, 10);
		float actualGWActualQuantity = Float.parseFloat(eleUtil.doGetElementAttribute(GWActualQuantity, "title"));
		assertEquals(actualGWActualQuantity, 0.00, "GW Actual Quantity not matching");

		eleUtil.waitForVisibilityOfElement(OSEstimatedQuantity, 10);
		float actualOSEstimatedQuantity = Float.parseFloat(eleUtil.doGetElementAttribute(OSEstimatedQuantity, "title"));
		assertEquals(actualOSEstimatedQuantity, totalOSEstimatedQuantity, "OS Estimated Quantity not matching");

		eleUtil.waitForVisibilityOfElement(OSActualQuantity, 10);
		float actualOSActualQuantity = Float.parseFloat(eleUtil.doGetElementAttribute(OSActualQuantity, "title"));
		assertEquals(actualOSActualQuantity, 0.00, "OS Actual Quantity not matching");

		eleUtil.waitForVisibilityOfElement(CalDepositOS, 10);
		String actualCalDepositOSString = eleUtil.doGetElementAttribute(CalDepositOS, "title");
		actualCalDepositOSString = actualCalDepositOSString.replace(",", ""); // Remove commas
		float actualCalDepositOS = Float.parseFloat(actualCalDepositOSString);
		assertEquals(actualCalDepositOS, totalActualCalDepositOS, "Calculated Deposit OS not matching");

		eleUtil.waitForVisibilityOfElement(CalDepositGW, 10);
		String actualCalDepositGWString = eleUtil.doGetElementAttribute(CalDepositGW, "title");
		actualCalDepositGWString = actualCalDepositGWString.replace(",", ""); // Remove commas
		float actualCalDepositGW = Float.parseFloat(actualCalDepositGWString);
		assertEquals(actualCalDepositGW, totalActualCalDepositGW, "Calculated Deposit GW not matching");

		eleUtil.waitForVisibilityOfElement(CalculatedDepositApp, 10);
		String actualCalculatedDepositAppString = eleUtil.doGetElementAttribute(CalculatedDepositApp, "title");
		actualCalculatedDepositAppString = actualCalculatedDepositAppString.replace(",", ""); // Remove commas
		float actualCalculatedDepositApp = Float.parseFloat(actualCalculatedDepositAppString);
		assertEquals(actualCalculatedDepositApp, totalActualCalculatedDepositApp,
				"Calculated Deposit Based on Application not matching");

		eleUtil.waitForVisibilityOfElement(CalculatedDepositActual, 10);
		float actualCalculatedDepositActual = Float
				.parseFloat(eleUtil.doGetElementAttribute(CalculatedDepositActual, "title"));
		assertEquals(actualCalculatedDepositActual, 0.00, "Calculated Deposit Based on Actual Volume not matching");

		eleUtil.waitForVisibilityOfElement(CalculatedDeposit, 10);
		String actualCalculatedDepositString = eleUtil.doGetElementAttribute(CalculatedDeposit, "title");
		actualCalculatedDepositString = actualCalculatedDepositString.replace(",", ""); // Remove commas
		float actualCalculatedDeposit = Float.parseFloat(actualCalculatedDepositString);
		assertEquals(actualCalculatedDeposit, totalActualCalculatedDepositApp, "Calculated Deposit not matching");

		eleUtil.waitForVisibilityOfElement(depositAmount, 10);
		float actualDepositAmount = Float.parseFloat(eleUtil.doGetElementAttribute(depositAmount, "title"));
		assertEquals(actualDepositAmount, 0.00, "Deposit Amount not matching");

		eleUtil.scrollDownTillElementVisible(topUpRefund);
		eleUtil.waitForVisibilityOfElement(topUpRefund, 10);
		String actualTopUpRefundString = eleUtil.doGetElementAttribute(topUpRefund, "title");
		actualTopUpRefundString = actualTopUpRefundString.replace(",", ""); // Remove commas
		float actualTopUpRefund = Float.parseFloat(actualTopUpRefundString);
		assertEquals(actualTopUpRefund, totalActualCalculatedDepositApp, "Top-Up Required (Refund) not matching");

		eleUtil.waitForVisibilityOfElement(year, 10);
		int actualYear = Integer.parseInt(eleUtil.doGetElementAttribute(year, "title"));
		assertEquals(actualYear, currentYear, "Year not matching");
	}

	public void mailValidation(String mailType) throws InterruptedException, ParseException {
		clickOnRefreshBtn();
		navigatingToTab("Timeline");
		// eleUtil.isPageLoaded(100);
		Thread.sleep(2000);
		String actualSub, actualFrom, actualBody;
		List<WebElement> actualTo;
		List<String> headersValList;
		By ele;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy");
		Date date = formatter.parse(commonActionsPage.startdateval);
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
			System.out.println("CommonActionsPage.Tankercompanyname" + commonActionsPage.Tankercompanyname
					+ "headersValList" + headersValList); //
			assertEquals(commonActionsPage.Tankercompanyname, headersValList, "To address is not matching");
			assertTrue(headersValList.contains(commonActionsPage.Tankercompanyname), "To address is not matching");
			assertEquals(actualSub, "Inspection scheduled for tanker " + commonActionsPage.TankerName + ".",
					"Subject is not matching");
			// assertEquals(actualTo, "Tankercompany_022003","To address is not matching");
			// assertEquals(actualSub, "Inspection scheduled for tanker //
			// T_GW+022003.","Subject is not matching");
			eleUtil.scrollUsingRobotClass();
			Thread.sleep(4000);
			// eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc,AppConstants.LONG_DEFAULT_WAIT);
			// Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody);

			System.out.println(finalString);

			/*
			 * String Expectedstr = "Dear Sir/Madam,\n" + "Please send in the tanker " +
			 * CommonActionsPage.TankerName + " to Waterhub during working hours on " +
			 * finalString + " 11:30 AM.\n" +
			 * "Confirm the appointment date and time 1 day in advance.\n" +
			 * "Please ensure the tanker is ready for inspection.\n" +
			 * "Tank should be empty to open for visual check, the GPS operational\n" +
			 * "and camera can view the suction and discharge valve.\n" +
			 * "If satisfactory, its discharge handle will be tagged with PUB seal.\n" +
			 * "\n" + "Thanks,\n" + "G RAJ KUMAR\n" + "Senior Assistant Engineer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)";
			 * System.out.println(actualBody); assertEquals(actualBody, Expectedstr,
			 * "Body is not matching");
			 */

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

			expectedTo.add("WRN5 WRP Contact"); //
			expectedTo.add("Tankcompany01032024080235");
			expectedTo.add(commonActionsPage.Tankercompanyname);
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
			// eleUtil.waitForFrameByLocator(mailframeLoc,AppConstants.LONG_DEFAULT_WAIT);
			// Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody);

			String ExpectedBody = "Dear Sir,\n" + "\n"
					+ "The attached permits dated 1/3/2024 are for disposal of greasy waste, organic sludge at Jurong WRP and human wastewater at WRPs. These permits expire on 31/3/2025.\n"
					+ "\n"
					+ "Please acknowledge acceptance of the terms and conditions by returning us a copy of this agreement within 5 working days with the signature of a representative of your company listed in ACRA. \n"
					+ "\n" + "Regards\n" + "\n" + "\n" + "\n" + "SIES DEV2\n" + "Field Inspection Officer\n"
					+ "Water Reclamation (Network) Department (Operation & Maintenance Division)\n" + "\n"
					+ "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email";

			/*
			 * String ExpectedBody = "Dear Sir,\n" + "\n" + "The attached permits dated " +
			 * CommonActionsPage.startdateval +
			 * " are for disposal of greasy waste, organic sludge at Jurong WRP and human wastewater at WRPs. These permits expire on "
			 * + CommonActionsPage.permitExpiryDate + ".\n" + "\n" +
			 * "Please acknowledge acceptance of the terms and conditions by returning us a copy of this agreement within 5 working days with the signature of a representative of your company listed in ACRA. \n"
			 * + "\n" + "Regards\n" + "\n" + "\n" + "\n" + "SIES DEV2\n" +
			 * "Field Inspection Officer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)\n"
			 * + "\n" +
			 * "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email"
			 * ;
			 */
			System.out.println("permit  generation actual" + actualBody);
			System.out.println("Permit generation expected" + ExpectedBody);
			if (actualBody.equalsIgnoreCase(ExpectedBody)) {
				System.out.println(" Body is same     :" + actualBody + "------->" + ExpectedBody);
			} else {
				System.out.println(" Body is not same");
			}
			driver.switchTo().defaultContent();

			// Assert.assertEquals(true,driver.findElement(attachment).isDisplayed());
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
			Thread.sleep(4000); // eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc,AppConstants.LONG_DEFAULT_WAIT);
			Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody); // System.out.println(actualBody);

			ExpectedBody = "Dear WRP colleagues\n" + "\n" + commonActionsPage.Tankercompanyname
					+ "'s new permit for 0 tankers has been issued.\n" + "\n"
					+ "Please take note and pass on to your teams on the ground to allow the tankers access to WRPs according to type of waste.\n"
					+ "\n" + "Description Attachment Remarks\n"
					+ "List of all GWCs and their vehicle numbers granted permit\n"
					+ "Valid until: [Please refer to attachment for expiry date]\n"
					+ "File 2023 WRP list of tankers effective from 1 Apr 2023_V2.xlsx\n"
					+ "Updated tanker list excludes the following tanker:\n" + commonActionsPage.Tankercompanyname
					+ " - " + commonActionsPage.GWCReferenceNum + "\n" + "\n" + "\n" + "\n" + "Regards\n" + "\n" + "\n"
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


	public void createActualQuantity(DataTable typeOfTankersData) {
		List<Map<String, String>> data = typeOfTankersData.asMaps(String.class, String.class);
		Log.info("data size is" + data.size());
		int x = 0;
		for (Map<String, String> form : data) {
			x = x + 1;
			String wasteType = form.get("WasteType");
			String Quantity = form.get("Quantity");
			eleUtil.waitForVisibilityOfElement(newBtn, 50);
			eleUtil.doElementClickable(newBtn, 20);
			jsutil.clickElementByJS(driver.findElement(newBtn));
			eleUtil.waitTillElementIsDisplayed(name, 50);
			eleUtil.doClearUsingKeys(name);
			eleUtil.doSendKeys(name, "Actual Quantity " + x);
			eleUtil.doSendKeysWithWait(GWCCompanyName, commonActionsPage.Tankercompanyname,
					AppConstants.SHORT_DEFAULT_WAIT);
			eleUtil.waitTillElementIsDisplayed(factory.setLookUp(), 50);
			eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
			eleUtil.doSendKeys(GWCCompanyName, commonActionsPage.tankerNumber.get(x));
			eleUtil.waitTillElementIsDisplayed(factory.setLookUp(), 50);
			eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
			WebElement enterWasteType = driver.findElement(By.xpath("//option[text()='" + wasteType + "']"));
			enterWasteType.click();
			eleUtil.doClearUsingKeys(invoiceDate);
			eleUtil.doSendKeys(invoiceDate, eleUtil.generateLastMonthRandomDate());
			eleUtil.doClearUsingKeys(quantity);
			eleUtil.doSendKeys(quantity, Quantity);
			eleUtil.doElementClickable(saveCloseBtn, 10);
			eleUtil.doClick(saveCloseBtn);
			eleUtil.doClickWithWait(refreshBtn, 20);
		}
		Log.info("All Actual Quantities are created");
	}

	public void paymentRecordAfterActualQuantitiesValidation(int GWPerMonth, int OSSPerMonth, int OSIPerMonth,
			int GWActual, int OSActual) throws InterruptedException {
		// Calculation for Payment
		float totalOSEstimatedQuantity = OSSPerMonth + OSIPerMonth;
		float totalActualCalDepositOS = totalOSEstimatedQuantity * 38;
		float totalActualCalDepositGW = (float) (GWPerMonth * 10.8605f);
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		float totalActualCalculatedDepositApp = (totalActualCalDepositGW + totalActualCalDepositOS) * 2;
		float totalDeposit = (GWActual * 10.8605f + OSActual * 38.0f) * 2;
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		String actualGWActualQuantity = eleUtil.doGetElementAttribute(GWActualQuantity, "title");
		while (actualGWActualQuantity.equals("0.00")) {
			if (System.currentTimeMillis() > endTime) {
				throw new RuntimeException("Test timed out after 120 seconds");
			}
			Thread.sleep(5000);
			eleUtil.doClickWithWait(recalculate, 20);
			eleUtil.acceptJSAlert(50);
			eleUtil.doClickWithWait(refreshBtn, 20);
		}

		eleUtil.waitForVisibilityOfElement(GWEstimatedQuantity, 10);
		float actualGWEstimatedQuantity = Float.parseFloat(eleUtil.doGetElementAttribute(GWEstimatedQuantity, "title"));
		assertEquals(actualGWEstimatedQuantity, GWPerMonth, "GW Estimated Quantity not matching");

		eleUtil.waitForVisibilityOfElement(GWActualQuantity, 10);
		float actualGWActualQuantityFloat = Float.parseFloat(actualGWActualQuantity);
		assertEquals(actualGWActualQuantityFloat, GWActual, "GW Actual Quantity not matching");

		eleUtil.waitForVisibilityOfElement(OSEstimatedQuantity, 10);
		float actualOSEstimatedQuantity = Float.parseFloat(eleUtil.doGetElementAttribute(OSEstimatedQuantity, "title"));
		assertEquals(actualOSEstimatedQuantity, totalOSEstimatedQuantity, "OS Estimated Quantity not matching");

		eleUtil.waitForVisibilityOfElement(OSActualQuantity, 10);
		float actualOSActualQuantity = Float.parseFloat(eleUtil.doGetElementAttribute(OSActualQuantity, "title"));
		assertEquals(actualOSActualQuantity, OSActual, "OS Actual Quantity not matching");

		eleUtil.waitForVisibilityOfElement(CalDepositOS, 10);
		String actualCalDepositOSString = eleUtil.doGetElementAttribute(CalDepositOS, "title");
		actualCalDepositOSString = actualCalDepositOSString.replace(",", ""); // Remove commas
		float actualCalDepositOS = Float.parseFloat(actualCalDepositOSString);
		assertEquals(actualCalDepositOS, totalActualCalDepositOS, "Calculated Deposit OS not matching");

		eleUtil.waitForVisibilityOfElement(CalDepositGW, 10);
		String actualCalDepositGWString = eleUtil.doGetElementAttribute(CalDepositGW, "title");
		actualCalDepositGWString = actualCalDepositGWString.replace(",", ""); // Remove commas
		float actualCalDepositGW = Float.parseFloat(actualCalDepositGWString);
		assertEquals(actualCalDepositGW, totalActualCalDepositGW, "Calculated Deposit GW not matching");

		eleUtil.waitForVisibilityOfElement(CalculatedDepositApp, 10);
		String actualCalculatedDepositAppString = eleUtil.doGetElementAttribute(CalculatedDepositApp, "title");
		actualCalculatedDepositAppString = actualCalculatedDepositAppString.replace(",", ""); // Remove commas
		float actualCalculatedDepositApp = Float.parseFloat(actualCalculatedDepositAppString);
		assertEquals(actualCalculatedDepositApp, totalActualCalculatedDepositApp,
				"Calculated Deposit Based on Application not matching");

		eleUtil.waitForVisibilityOfElement(CalculatedDepositActual, 10);
		String actualCalculatedDepositActualString = eleUtil.doGetElementAttribute(CalculatedDepositActual, "title");
		actualCalculatedDepositActualString = actualCalculatedDepositActualString.replace(",", ""); // Remove commas
		float actualCalculatedDepositActual = Float.parseFloat(actualCalculatedDepositActualString);
		assertEquals(actualCalculatedDepositActual, totalDeposit,
				"Calculated Deposit Based on Actual Volume not matching");

		eleUtil.waitForVisibilityOfElement(CalculatedDeposit, 10);
		String actualCalculatedDepositString = eleUtil.doGetElementAttribute(CalculatedDeposit, "title");
		actualCalculatedDepositString = actualCalculatedDepositString.replace(",", ""); // Remove commas
		float actualCalculatedDeposit = Float.parseFloat(actualCalculatedDepositString);
		assertEquals(actualCalculatedDeposit, totalDeposit, "Calculated Deposit not matching");

		eleUtil.waitForVisibilityOfElement(depositAmount, 10);
		float actualDepositAmount = Float.parseFloat(eleUtil.doGetElementAttribute(depositAmount, "title"));
		assertEquals(actualDepositAmount, 0.00, "Deposit Amount not matching");

		eleUtil.scrollDownTillElementVisible(topUpRefund);
		eleUtil.waitForVisibilityOfElement(topUpRefund, 10);
		String actualTopUpRefundString = eleUtil.doGetElementAttribute(topUpRefund, "title");
		actualTopUpRefundString = actualTopUpRefundString.replace(",", ""); // Remove commas
		float actualTopUpRefund = Float.parseFloat(actualTopUpRefundString);
		assertEquals(actualTopUpRefund, totalDeposit, "Top-Up Required (Refund) not matching");

		eleUtil.waitForVisibilityOfElement(year, 10);
		int actualyear = Integer.parseInt(eleUtil.doGetElementAttribute(year, "title"));
		assertEquals(actualyear, currentYear, "Year not matching");
	}

	public void paymentRecordAfterDepositQuantitiesValidation(int GWPerMonth, int OSSPerMonth, int OSIPerMonth,
			int GWActual, int OSActual, int expectedDepositAmount) throws InterruptedException {
		float totalOSEstimatedQuantity = OSSPerMonth + OSIPerMonth;
		float totalActualCalDepositOS = totalOSEstimatedQuantity * 38;
		float totalActualCalDepositGW = (float) (GWPerMonth * 10.8605f);
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		float totalActualCalculatedDepositApp = (totalActualCalDepositGW + totalActualCalDepositOS);
		float totalDeposit = (GWActual * 10.8605f + OSActual * 38.0f);
		float refundAmount = totalDeposit - expectedDepositAmount;
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		Float actualDepositAmount = Float.parseFloat(eleUtil.doGetElementAttribute(depositAmount, "title"));
		System.out.println("deposit Value" + actualDepositAmount);
		while (actualDepositAmount.equals("500.00")) {
			if (System.currentTimeMillis() > endTime) {
				throw new RuntimeException("Test timed out after 120 seconds");
			}
			Thread.sleep(5000);
			eleUtil.doClickWithWait(recalculate, 20);
			eleUtil.acceptJSAlert(50);
			eleUtil.doClickWithWait(refreshBtn, 20);
			actualDepositAmount = Float.parseFloat(eleUtil.doGetElementAttribute(depositAmount, "title"));
		}

		eleUtil.waitForVisibilityOfElement(GWEstimatedQuantity, 10);
		float actualGWEstimatedQuantity = Float.parseFloat(eleUtil.doGetElementAttribute(GWEstimatedQuantity, "title"));
		assertEquals(actualGWEstimatedQuantity, GWPerMonth, "GW Estimated Quantity not matching");

		eleUtil.waitForVisibilityOfElement(GWActualQuantity, 10);
		float actualGWActualQuantityFloat = Float.parseFloat(eleUtil.doGetElementAttribute(GWActualQuantity, "title"));
		assertEquals(actualGWActualQuantityFloat, GWActual, "GW Actual Quantity not matching");

		eleUtil.waitForVisibilityOfElement(OSEstimatedQuantity, 10);
		float actualOSEstimatedQuantity = Float.parseFloat(eleUtil.doGetElementAttribute(OSEstimatedQuantity, "title"));
		assertEquals(actualOSEstimatedQuantity, totalOSEstimatedQuantity, "OS Estimated Quantity not matching");

		eleUtil.waitForVisibilityOfElement(OSActualQuantity, 10);
		float actualOSActualQuantity = Float.parseFloat(eleUtil.doGetElementAttribute(OSActualQuantity, "title"));
		assertEquals(actualOSActualQuantity, OSActual, "OS Actual Quantity not matching");

		eleUtil.waitForVisibilityOfElement(CalDepositOS, 10);
		String actualCalDepositOSString = eleUtil.doGetElementAttribute(CalDepositOS, "title");
		actualCalDepositOSString = actualCalDepositOSString.replace(",", ""); // Remove commas
		float actualCalDepositOS = Float.parseFloat(actualCalDepositOSString);
		assertEquals(actualCalDepositOS, totalActualCalDepositOS, "Calculated Deposit OS not matching");

		eleUtil.waitForVisibilityOfElement(CalDepositGW, 10);
		String actualCalDepositGWString = eleUtil.doGetElementAttribute(CalDepositGW, "title");
		actualCalDepositGWString = actualCalDepositGWString.replace(",", ""); // Remove commas
		float actualCalDepositGW = Float.parseFloat(actualCalDepositGWString);
		assertEquals(actualCalDepositGW, totalActualCalDepositGW, "Calculated Deposit GW not matching");

		eleUtil.waitForVisibilityOfElement(CalculatedDepositApp, 10);
		String actualCalculatedDepositAppString = eleUtil.doGetElementAttribute(CalculatedDepositApp, "title");
		actualCalculatedDepositAppString = actualCalculatedDepositAppString.replace(",", ""); // Remove commas
		float actualCalculatedDepositApp = Float.parseFloat(actualCalculatedDepositAppString);
		assertEquals(actualCalculatedDepositApp, totalActualCalculatedDepositApp,
				"Calculated Deposit Based on Application not matching");

		eleUtil.waitForVisibilityOfElement(CalculatedDepositActual, 10);
		String actualCalculatedDepositActualString = eleUtil.doGetElementAttribute(CalculatedDepositActual, "title");
		actualCalculatedDepositActualString = actualCalculatedDepositActualString.replace(",", ""); // Remove commas
		float actualCalculatedDepositActual = Float.parseFloat(actualCalculatedDepositActualString);
		assertEquals(actualCalculatedDepositActual, totalDeposit,
				"Calculated Deposit Based on Actual Volume not matching");

		eleUtil.waitForVisibilityOfElement(CalculatedDeposit, 10);
		String actualCalculatedDepositString = eleUtil.doGetElementAttribute(CalculatedDeposit, "title");
		actualCalculatedDepositString = actualCalculatedDepositString.replace(",", ""); // Remove commas
		float actualCalculatedDeposit = Float.parseFloat(actualCalculatedDepositString);
		assertEquals(actualCalculatedDeposit, totalDeposit, "Calculated Deposit not matching");

		eleUtil.waitForVisibilityOfElement(depositAmount, 10);
		assertEquals(actualDepositAmount, expectedDepositAmount, "Deposit Amount not matching");

		eleUtil.scrollDownTillElementVisible(topUpRefund);
		eleUtil.waitForVisibilityOfElement(topUpRefund, 10);
		String actualTopUpRefundString = eleUtil.doGetElementAttribute(topUpRefund, "title");
		actualTopUpRefundString = actualTopUpRefundString.replace(",", ""); // Remove commas
		float actualTopUpRefund = Float.parseFloat(actualTopUpRefundString);
		assertEquals(actualTopUpRefund, refundAmount, "Top-Up Required (Refund) not matching");

		eleUtil.waitForVisibilityOfElement(year, 10);
		int actualyear = Integer.parseInt(eleUtil.doGetElementAttribute(year, "title"));
		assertEquals(actualyear, currentYear, "Year not matching");
	}

	public void updateExcelForDepositAmountCal(String giro) throws IOException {
		excelUtil = new ExcelUtil(cases.filePath + depositFilePath);
		excelUtil.setSheet("Deposits"); // Ensure this is the correct sheet name
		// Assuming you want to update the first row (index 1) for "Customer" and "GIRO"
		excelUtil.setCellValue(1, 3, commonActionsPage.Tankercompanyname); // Column 0 for "Customer"
		excelUtil.setCellValue(1, 5, giro); // Column 2 for "GIRO"
		excelUtil.saveAndClose();
	}

	public void importExcelForDeposit(int deposit, String giro) throws InterruptedException {
		String path = depositFilePath;
		Float depositAmount;
		String giroValue;
		int customerCount;
		importExcel(path);
		Thread.sleep(3000);
		eleUtil.isPageLoaded(30);
		eleUtil.waitForVisibilityOfElement(customerName, 50);
		eleUtil.doElementClickable(customerName, 100);
		eleUtil.doClick(customerName);
		eleUtil.staleElementRefExecClickCRM(filterBy);
		eleUtil.doClick(filterBy);
		eleUtil.doSendKeys(filterbyinputbox, commonActionsPage.Tankercompanyname);
		Thread.sleep(3000);
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
		eleUtil.doClick(applyBtn);
		long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
		while (System.currentTimeMillis() < endTime) {
			if (eleUtil.elementIsDisplayed(crmActions.getNoDataAvailableInSingleGrid(), "No data available")) {
				Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, 30);
			}
			customerCount = driver.findElements(customerRadioButton).size();
			if (giro.equals("") && customerCount != 2) {
				Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, 30);
			} else {
				try {
					customerCount = driver.findElements(customerRadioButton).size();
					if (customerCount == 2) {
						depositAmount = Float.parseFloat(eleUtil.doElementGetText(customerDepositAmount2));
						giroValue = eleUtil.doElementGetText(giroValue2);
					} else {
						depositAmount = Float.parseFloat(eleUtil.doElementGetText(customerDepositAmount1));
						giroValue = eleUtil.doElementGetText(giroValue1);
					}
					Assert.assertEquals(depositAmount, deposit, "Deposit Amount is incorrect");
					Assert.assertEquals(giroValue, giro, "GIRO is incorrect");
					return;
				} catch (org.openqa.selenium.NoSuchElementException e) {
					Log.error("Case number element not found: " + e.getMessage());
				}
			}
		}
	}

	public void verifyReregisteringWithNewCompany(String reregisterWithNewCompany) throws InterruptedException {
		Thread.sleep(2000);
		int i = 0;
		navigatingToTab("Work Orders");
		List<String> woName = commonActionsPage.WOnumber;
		System.out.println("size is:" + woName.size());
		for (i = 0; i < woName.size(); i++) {
			Thread.sleep(2000);
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + woName.get(i) + "']");
			eleUtil.doActionsClick(woele);
			By isComplaintchkInWOfrom = By.xpath("//select[@aria-label='Is Compliant?']/option[@data-selected='true']");
			eleUtil.waitForVisibilityOfElement(isComplaintchkInWOfrom, 100);
			String isComplaintVal = eleUtil.doElementGetText(isComplaintchkInWOfrom);
			Log.info("isComplaintVal " + isComplaintVal);
			if (isComplaintVal.equalsIgnoreCase("No")) {
				System.out.println("Tanker is noncompalince. Permit will not be generated for this tanker");
			} else {
				eleUtil.doElementClickable(tankerNumberInWOform, 30);
				eleUtil.doClick(tankerNumberInWOform);
				clickOnRefreshBtn();
			}
			eleUtil.scrollUsingRobotClass();
			String reregisteringWithNewCompanyValue = eleUtil.createSelect(reregisteringWithNewCompany)
					.getFirstSelectedOption().getText();
			Assert.assertEquals(reregisteringWithNewCompanyValue, reregisterWithNewCompany,
					"Reregistering with new company is not set as Yes");
		}
	}

	public void processingStageToNextStage(String stageName) {
		navigatingToStage(stageName);
		clickOnNextStageBtn();
	}
}
