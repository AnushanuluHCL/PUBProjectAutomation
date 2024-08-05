package com.sat.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.sat.constants.AppConstants;
import com.sat.testUtil.ElementUtil;
import com.sat.testUtil.JavaScriptUtil;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class ApplicationPage extends CommonActionsPage {
	int x = 0;
	/*
	 * private WebDriver driver; private Properties prop; private ElementUtil
	 * eleUtil; private TestBase testbase; private JavaScriptUtil jsutil; private
	 * NEAListPage neapage; private LoginPage loginpage; private CommonActionsPage
	 * common;
	 */

	// Locators on NEA list home page
	private By companyName = By.xpath("//input[@aria-label='Company']");

	// Locators on home page
	private By newBtn = By.xpath("//button[@aria-label='New']");
	private By gwccomnpanydropdpwn = By.xpath("//div[@data-testid='pub_gwccompany']");
	private By filterBy = By.xpath("//span[text()='Filter by']");
	private By filterbyinputbox = By.xpath("//input[@aria-label='Filter by value']");
	private By suggestionbox = By.xpath("//div[contains(@class,'suggestionTextOverflow')]");
	private By applyBtn = By.xpath("//span[text()='Apply']");
	private By createdonCol = By.xpath("//div[text()='Created On']");
	// div[text()='Created On']/ancestor::div[@data-testid='columnHeader']
	private By NewToOldCol = By.xpath("//span[text()='Sort newer to older']");
	private By firstRecord = By.xpath("(//input[contains(@aria-label,'elect or deselect the row')])[1]");

	// (//input[@aria-label='Select or deselect the row'])[1] |
	// (//input[@aria-label='select or deselect the row'])[1]");
	private By cretecaseBtn = By.xpath("//button[contains(@aria-label,'Create Case')]");

	// Locators on Application Home page
	private By applicationdateField = By.xpath("//input[@aria-label='Date of Application Date']");
	private By selectCurrentDate = By.xpath("//td[contains(@class,'ms-CalendarDay-daySelected')]");
	private By NameOfCompanyField = By.xpath("//input[@aria-label='Name of Company']");
	private By addressField = By.xpath("//textarea[@aria-label='Address of Company']");
	private By addressOfTankerYardField = By.xpath("//textarea[@aria-label='Address of Tanker Yard']");
	private By phonenumField = By.xpath("//input[@aria-label='Telephone No']");
	private By emailField = By.xpath("//input[@aria-label='Email']");
	private By GreasyWasteBox = By.xpath("//Select[@aria-label='Greasy Waste']");// visible Text - Yes
	private By sourceOfGWField = By
			.xpath("//div[@aria-label='Source of Greasy Waste']//button[@aria-label='Toggle menu']");
	private By TyepeOfGWWaste = By.xpath("//div[text()='Food establishments']");
	private By GWWastePerMonthField = By.xpath("//input[@aria-label='Greasy Waste Per Month (m3 /mth)']");
	private By humanwasteTypeHeading = By.xpath("//h2[@title='Human Waste Water']");
	private By HumanWasteBox = By.xpath("//Select[@aria-label='Human Wastewater']");// visible Text - Yes
	private By HumanwasteTypeToggleBtn = By
			.xpath("//div[@aria-label='Human Waste Type']//button[@aria-label='Toggle menu']");
	// private By TypeOfHumanwaste = By.xpath("//div[text()='Mobile Toilet']");
	private By HWWastePerMonthField = By.xpath("//input[@aria-label='Volume of Waste Per Month (m3 /mth)']");
	private By OSShipsBox = By.xpath("//Select[@aria-label='Organic Sludge- Ships']");// visible Text - Yes
	private By OSShipsPerMonthField = By.xpath("//input[@aria-label='Organic Sludge Per Month- Ships']");
	private By OSIndustriesBox = By.xpath("//Select[@aria-label='Organic Sludge- Industries']");// visible Text - Yes
	private By OSIndustriesPerMonthField = By.xpath("//input[@aria-label='Organic Sludge Per Month- Industries']");
	private By saveBtn = By.xpath("//button[@aria-label='Save (CTRL+S)']");
	private By saveCloseBtn = By.xpath("//button[@aria-label='Save & Close']");
	private By refreshBtn = By.xpath("//button[@aria-label='Refresh']");
	private By createdApp = By.xpath("(//div[@col-id='pub_gwccompany'])[2]");

	// Locators for creating tankers
	private By newAppTankerBtn = By.xpath("//span[text()='New Application Tankers']");
	private By regNoFiled = By.xpath("//input[@aria-label='Registration No']");
	private By capacityField = By.xpath("//input[@aria-label='Capacity of Tanker (Cu/m)']");
	private By typeOfWastedropdown = By.xpath("//select[@aria-label='Type of Waste']"); // visible text = Greasy Waste

	// Locators from case form
	private By entitynameOnCaseForm = By.xpath("(//div[@col-id='customerid'])[2]");
	private By caseidOnCaseForm = By.xpath("(//div[@col-id='title'])[2]");

	// Locators for FormSG
	private By newAppselection = By.xpath(
			"//div[contains(text(),'Please upload your General Waste')]/ancestor::div[contains(@class,'chakra-form-control')]//a");
	private By companyname = By.xpath("//input[contains(@aria-label,'Company Name (for new applications)')]");
	private By telephoneNum = By.xpath("(//input[contains(@autocomplete,'tel')])[1]");
	private By addrYard1 = By.xpath("//input[contains(@aria-label,'Address of tanker yard #1')]");
	private By addrYard2 = By.xpath("//input[contains(@aria-label,'Address of tanker yard #2')]");
	private By houseNo = By.xpath("//input[contains(@aria-label,'Block / House Number')]");
	private By roadNo = By.xpath("//input[contains(@aria-label,'Road Name')]");
	private By unitNo = By.xpath("//input[contains(@aria-label,'Unit Number')]");
	private By postalcode = By.xpath("//input[contains(@aria-label,'Postal Code')]");
	private By salutationCR = By.xpath("(//input[contains(@placeholder,'Select an option')])[1]");
	private By nameOfCR = By.xpath("//input[contains(@aria-label,'Name of Company Representative')]");
	private By designationOfCR = By.xpath("//input[contains(@aria-label,'Designation')]");
	private By emailOfCR = By
			.xpath("//span[contains(@id,'verifiable')]//following-sibling::input[contains(@autocomplete,'email')]");
	private By mobileNo = By.xpath("(//input[contains(@autocomplete,'tel')])[2]");
	private By salutationMD = By.xpath("(//input[contains(@placeholder,'Select an option')])[2]");
	private By nameOfMD = By.xpath("//input[contains(@aria-label,'Name of company')]");
	private By designationOfMD = By.xpath("//input[contains(@aria-label,'Designation')]");
	private By emailOfMD = By
			.xpath("//span[contains(@id,'verifiable')]//following-sibling::input[contains(@autocomplete,'email')]");

	// "10.Salutation"
	// input[contains(@placeholder,'Select an
	// option')]/ancestor::div[text()='Salutation']
	// input[@placeholder="Select an
	// option"]/ancestor::div[@class='css-79elbk']/preceding-sibling::div//span[text()='10.']
	// input[@placeholder="Select an
	// option"]/ancestor::div[@class='css-79elbk']/parent::div/preceding-sibling::div//h2

	// Locators for WRMS
	private By siesImportEntity = By.xpath("//span[text()='SIES Import']");
	private By TemplateField = By.xpath("//select[@class='search-text-input']");
	private By chooseFileOption = By.xpath("//input[@id='file_uploadedfile']");
	private By uploadBtn = By.xpath("//button[text()='Upload']");

	public ApplicationPage(WebDriver driver) {
		super(driver);
		/*
		 * this.driver = driver; eleUtil = new ElementUtil(this.driver); jsutil = new
		 * JavaScriptUtil(this.driver); prop = eleUtil.readProperties(); neapage = new
		 * NEAListPage(TestBase.getDriver()); loginpage = new
		 * LoginPage(TestBase.getDriver()); common = new
		 * CommonActionsPage(TestBase.getDriver());
		 */
	}

	public void creationOfApplicationRecord(String addryard, String phonenumval, String emailval) {

		eleUtil.clickElementWhenReady(applicationdateField, 10);
		try {
			Thread.sleep(1000);
			eleUtil.doClick(selectCurrentDate);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		eleUtil.doClick(NameOfCompanyField);
		eleUtil.doClearUsingKeys(NameOfCompanyField);
		eleUtil.doSendKeysWithWait(NameOfCompanyField, CommonActionsPage.Tankercompanyname,
				AppConstants.SHORT_DEFAULT_WAIT);

		/*
		 * eleUtil.doClearUsingKeys(addressField);
		 * eleUtil.doSendKeysWithWait(addressField, addrval,
		 * AppConstants.SHORT_DEFAULT_WAIT);
		 */
		eleUtil.doClearUsingKeys(addressOfTankerYardField);
		eleUtil.doSendKeys(addressOfTankerYardField, addryard);
		eleUtil.doClearUsingKeys(phonenumField);
		eleUtil.doSendKeys(phonenumField, phonenumval);
		// eleUtil.scrollUsingRobotClass();
		eleUtil.waitForVisibilityOfElement(emailField, 20);
		eleUtil.doClearUsingKeys(emailField);
		eleUtil.doSendKeys(emailField, emailval);
		/*
		 * eleUtil.doElementClickable(saveBtn, 10); common.clickOnSaveBtn();
		 * common.clickOnRefrehBtn();
		 */
	}

	public void amountOfWastetypeOfTankers(String GWSelected, String GWPerMonth, String HWSelected, String HWType,
			String HWPerMonth, String OSSSelected, String OSSPerMonth, String OSISelected, String OSIPerMonth) {
		eleUtil.createSelect(GreasyWasteBox);
		eleUtil.doSelectDropDownByVisibleText(GreasyWasteBox, GWSelected);
		eleUtil.doClick(sourceOfGWField);
		eleUtil.doClick(TyepeOfGWWaste);
		eleUtil.doClick(sourceOfGWField);
		eleUtil.doClearUsingKeys(GWWastePerMonthField);
		eleUtil.doSendKeys(GWWastePerMonthField, GWPerMonth);

		eleUtil.createSelect(HumanWasteBox);
		eleUtil.doSelectDropDownByVisibleText(HumanWasteBox, HWSelected);
		/*
		 * try { Thread.sleep(1000);
		 * jsutil.clickElementByJS(driver.findElement(HumanwasteTypeToggleBtn)); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		jsutil.clickElementByJS(driver.findElement(HumanwasteTypeToggleBtn));
		// jsutil.clickElementByJS(driver.findElement(By.xpath("//div[text()='" + HWType
		// + "']")));
		eleUtil.doClick(By.xpath("//div[text()='" + HWType + "']"));
		eleUtil.doClick(HumanwasteTypeToggleBtn);
		eleUtil.doClearUsingKeys(HWWastePerMonthField);
		eleUtil.doSendKeys(HWWastePerMonthField, HWPerMonth);

		eleUtil.createSelect(OSShipsBox);
		eleUtil.doSelectDropDownByVisibleText(OSShipsBox, OSSSelected);
		eleUtil.doClearUsingKeys(OSShipsPerMonthField);
		eleUtil.doSendKeys(OSShipsPerMonthField, OSSPerMonth);

		eleUtil.createSelect(OSIndustriesBox);
		eleUtil.doSelectDropDownByVisibleText(OSIndustriesBox, OSISelected);
		eleUtil.doClearUsingKeys(OSIndustriesPerMonthField);
		eleUtil.doSendKeys(OSIndustriesPerMonthField, OSIPerMonth);
		eleUtil.doClick(saveBtn);
	}

	public void amountOfGWWastetypeTanker(String GWSelected, String GWPerMonth) {
		eleUtil.scrollUsingRobotClass();
		eleUtil.createSelect(GreasyWasteBox);
		eleUtil.doSelectDropDownByVisibleText(GreasyWasteBox, GWSelected);
		eleUtil.doClick(sourceOfGWField);
		eleUtil.doClick(TyepeOfGWWaste);
		eleUtil.doClick(sourceOfGWField);
		eleUtil.doClearUsingKeys(GWWastePerMonthField);
		eleUtil.doSendKeys(GWWastePerMonthField, GWPerMonth);
		eleUtil.doElementClickable(saveBtn, 10);
		clickOnSaveBtn();
		clickOnRefrehBtn();
	}

	public void amountOfHWWastetypeTanker(String HWSelected, String HWType, String HWPerMonth) {
		// eleUtil.scrollUsingRobotClass();
		// eleUtil.waitForVisibilityOfElement(HumanWasteBox, 30);
		// jsutil.scrollIntoView(driver.findElement(HumanWasteBox));
		// eleUtil.waitForVisibilityOfElement(humanwasteTypeHeading, 60);
		// eleUtil.scrollUsingRobotClass();
		// jsutil.scrollPageDown();
		driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		try {
			eleUtil.waitForVisibilityOfElement(HumanWasteBox, 10);
		} catch (NoSuchElementException e) {
			System.out.println("HumanWasteBox not found even after scrolling.");
			return; // Exit the method or handle the error gracefully
		}
		eleUtil.doElementClickable(HumanWasteBox, 30);
		eleUtil.createSelect(HumanWasteBox);
		eleUtil.doSelectDropDownByVisibleText(HumanWasteBox, HWSelected);
		jsutil.clickElementByJS(driver.findElement(HumanwasteTypeToggleBtn));
		eleUtil.doClick(By.xpath("//div[text()='" + HWType + "']"));
		eleUtil.doClearUsingKeys(HWWastePerMonthField);
		eleUtil.doSendKeys(HWWastePerMonthField, HWPerMonth);
		clickOnSaveBtn();
	}

	public void amountOfOSSWastetypeTanker(String OSSSelected, String OSSPerMonth) {
		// eleUtil.scrollUsingRobotClass();
		// eleUtil.waitForVisibilityOfElement(OSShipsBox, 50);
		driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		try {
			eleUtil.waitForVisibilityOfElement(OSShipsBox, 10);
		} catch (NoSuchElementException e) {
			System.out.println("OSShipsBox not found even after scrolling.");
			return; // Exit the method or handle the error gracefully
		}
		eleUtil.createSelect(OSShipsBox);
		eleUtil.doSelectDropDownByVisibleText(OSShipsBox, OSSSelected);
		eleUtil.doClearUsingKeys(OSShipsPerMonthField);
		eleUtil.doSendKeys(OSShipsPerMonthField, OSSPerMonth);
		clickOnSaveBtn();
	}

	public void amountOfOSIWastetypeTanker(String OSISelected, String OSIPerMonth) {
		 eleUtil.scrollUsingRobotClass();
		 eleUtil.waitForVisibilityOfElement(OSIndustriesBox, 50);

	/*	eleUtil.waitForPresenceOfElement(By.tagName("body"), 20);
		driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		try {
			eleUtil.waitForVisibilityOfElement(OSIndustriesBox, 10);
		} catch (NoSuchElementException e) {
			System.out.println("OSIndustriesBox not found even after scrolling.");
			return; // Exit the method or handle the error gracefully }
		}*/
		eleUtil.createSelect(OSIndustriesBox);
		eleUtil.doSelectDropDownByVisibleText(OSIndustriesBox, OSISelected);
		eleUtil.doClearUsingKeys(OSIndustriesPerMonthField);
		eleUtil.doSendKeys(OSIndustriesPerMonthField, OSIPerMonth);
		clickOnSaveBtn();
	}

	public void amountOfAllWastetypeOfTankers(DataTable wastetypedata) {
		List<Map<String, String>> data = wastetypedata.asMaps(String.class, String.class);
		for (Map<String, String> form : data) {

			String GWSelected = form.get("GW");
			String GWPerMonth = form.get("GWPerMonth");
			String HWSelected = form.get("HW");
			String HWType = form.get("HWType");
			String HWPerMonth = form.get("HWPerMonth");
			String OSSSelected = form.get("OSS");
			String OSSPerMonth = form.get("OSSPerMonth");
			String OSISelected = form.get("OSI");
			String OSIPerMonth = form.get("OSIPerMonth");

			eleUtil.createSelect(GreasyWasteBox);
			eleUtil.doSelectDropDownByVisibleText(GreasyWasteBox, GWSelected);
			eleUtil.doClick(sourceOfGWField);
			eleUtil.doClick(TyepeOfGWWaste);
			eleUtil.doClick(sourceOfGWField);
			eleUtil.doClearUsingKeys(GWWastePerMonthField);
			eleUtil.doSendKeys(GWWastePerMonthField, GWPerMonth);

			eleUtil.createSelect(HumanWasteBox);
			eleUtil.doSelectDropDownByVisibleText(HumanWasteBox, HWSelected);
			try {
				Thread.sleep(1000);
				jsutil.clickElementByJS(driver.findElement(HumanwasteTypeToggleBtn));
			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			} // WebElement TypeOfHumanwaste = //
			driver.findElement(By.xpath("//div[text()='" + HWType + "']"));
			eleUtil.doClick(By.xpath("//div[text()='" + HWType + "']"));
			eleUtil.doClearUsingKeys(HWWastePerMonthField);
			eleUtil.doSendKeys(HWWastePerMonthField, HWPerMonth);

			eleUtil.createSelect(OSShipsBox);
			eleUtil.doSelectDropDownByVisibleText(OSShipsBox, OSSSelected);
			eleUtil.doClearUsingKeys(OSShipsPerMonthField);
			eleUtil.doSendKeys(OSShipsPerMonthField, OSSPerMonth);

			eleUtil.createSelect(OSIndustriesBox);
			eleUtil.doSelectDropDownByVisibleText(OSIndustriesBox, OSISelected);
			eleUtil.doClearUsingKeys(OSIndustriesPerMonthField);
			eleUtil.doSendKeys(OSIndustriesPerMonthField, OSIPerMonth);
		}

		eleUtil.doClick(saveBtn);
	}

	public void creationOfTankers(DataTable diftypeOfTankersdata) {
		List<Map<String, String>> data = diftypeOfTankersdata.asMaps(String.class, String.class);
		for (Map<String, String> form : data) {
			// String capacity = form.get("CapacityOfTanker");
			String wastetype = form.get("WasteType");
			// eleUtil.isPageLoaded(AppConstants.MEDIUM_DEFAULT_WAIT);
			eleUtil.doClickWithWait(newAppTankerBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
			try {// need to remove this code
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eleUtil.doElementClickable(regNoFiled, 10);
			eleUtil.doActionsClick(regNoFiled);
			eleUtil.doClearUsingKeys(regNoFiled);
			System.out.println("tanker number from Applicationtanker - " + CommonActionsPage.TankerName);
			eleUtil.doSendKeys(regNoFiled, CommonActionsPage.TankerName);
			try {// need to remove this code
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("tanker number from Applicationtanker - " +
			// CommonActionsPage.TankerName);
			eleUtil.doClearUsingKeys(capacityField);
			String stringWithCommas = CommonActionsPage.TankerCapacity;
			String stringWithoutCommas = stringWithCommas.replaceAll(",", "");
			// eleUtil.doSendKeys(capacityField, CommonActionsPage.TankerCapacity);
			eleUtil.doSendKeys(capacityField, stringWithoutCommas);
			eleUtil.doClick(typeOfWastedropdown);
			WebElement ele = driver.findElement(By.xpath("//option[text()='" + wastetype + "']"));
			ele.click();
			eleUtil.doElementClickable(saveCloseBtn, 10);
			eleUtil.doClick(saveCloseBtn);
		}
		System.out.println("All tankers are created");
		eleUtil.doElementClickable(saveCloseBtn, 10);
		// eleUtil.doClick(saveCloseBtn);
		eleUtil.isPageLoaded(30);
		try {
			Thread.sleep(2000);
			// eleUtil.doActionsClick(saveCloseBtn);
			clickonSaveAndCloseBtn();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("saving the application");
	}

	public void creationOfMultipleTankers(DataTable diftypeOfTankersdata) throws InterruptedException {
		List<Map<String, String>> data = diftypeOfTankersdata.asMaps(String.class, String.class);
		System.out.println("data size is" + data.size());
		for (Map<String, String> form : data) {
			x = x + 1;
			// String tankernmae = form.get("Tanker_Name");
			// String capacity = form.get("CapacityOfTanker");
			String wastetype = form.get("WasteType");
			// eleUtil.isPageLoaded(AppConstants.MEDIUM_DEFAULT_WAIT);
			eleUtil.doClickWithWait(newAppTankerBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
			Thread.sleep(3000);
			eleUtil.doElementClickable(regNoFiled, 10);
			eleUtil.doActionsClick(regNoFiled);
			eleUtil.doClearUsingKeys(regNoFiled);
			// eleUtil.doSendKeys(regNoFiled, tankernmae);
			eleUtil.doSendKeys(regNoFiled, CommonActionsPage.tankerNumber.get(x));
			Thread.sleep(3000);
			eleUtil.doClearUsingKeys(capacityField);
			// eleUtil.doSendKeys(capacityField, capacity);
			eleUtil.doSendKeys(capacityField, CommonActionsPage.tankcapacity.get(x));
			eleUtil.doClick(typeOfWastedropdown);
			WebElement ele = driver.findElement(By.xpath("//option[text()='" + wastetype + "']"));
			ele.click();
			eleUtil.doElementClickable(saveCloseBtn, 10);
			eleUtil.doClick(saveCloseBtn);
		}
		System.out.println("All tankers are created");
		eleUtil.doElementClickable(saveCloseBtn, 10);
		eleUtil.isPageLoaded(30);
		try {
			Thread.sleep(2000);
			clickonSaveAndCloseBtn();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("saving the application");
	}

	public void approveApp() throws InterruptedException {
		// selectFirstRecord(firstRecord, 20);
		// eleUtil.doClick(refreshBtn);
		eleUtil.isPageLoaded(50);
		eleUtil.waitForVisibilityOfElement(createdApp, 50);
		eleUtil.doElementClickable(gwccomnpanydropdpwn, 100);
		eleUtil.doClick(gwccomnpanydropdpwn);
		eleUtil.doClick(filterBy);

		eleUtil.doSendKeys(filterbyinputbox, CommonActionsPage.Tankercompanyname);
		Thread.sleep(3000);
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
		eleUtil.doClick(applyBtn);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 60000) {
			try {
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
				eleUtil.waitForVisibilityOfElement(createdApp, 30);
				if (driver.findElement(createdApp).isDisplayed()) {
					flag = true;
					break;
				}
			} catch (TimeoutException e) {
				System.out.println("Timeoutexception occured" + e.getMessage());
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		selectFirstRecord(firstRecord, 20);
		eleUtil.doClickWithWait(cretecaseBtn, AppConstants.LONG_DEFAULT_WAIT);
		// eleUtil.doActionsClick(cretecaseBtn);
		eleUtil.isPageLoaded(100);
		eleUtil.acceptJSAlert(50);
		System.out.println("Alert clicked successfully");
	}

	/*
	 * public void creationOfTankers(String capacity, String wastetype) {
	 * eleUtil.isPageLoaded(AppConstants.MEDIUM_DEFAULT_WAIT);
	 * eleUtil.doClickWithWait(newAppTankerBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
	 * eleUtil.doSendKeys(regNoFiled, getRandomTankerName());
	 * eleUtil.doSendKeys(capacityFiled, capacity);
	 * eleUtil.createSelect(typeOfWastedropdown);
	 * eleUtil.doSelectDropDownByVisibleText(typeOfWastedropdown, wastetype); }
	 */

	public void numberOfTankersCheck(String type, String capacity, String wastetype) {
		// select[contains(@data-id,'.fieldControl-checkbox-select')]
		String itemXpath = getItemXpath(type);
		System.out.println("item xpath is : " + itemXpath);
		WebElement ele = driver.findElement(By.xpath("//Select[@aria-label='" + itemXpath + "']"));
		if (ele.getText().equals("Yes")) {
			// creationOfTankers("capacity", "wastetype");
		}
	}

	// Select[@aria-label='Greasy Waste']
	public String getItemXpath(String type) {
		String itemXpath = null;
		switch (type) {
		case "Greasy Waste":
			itemXpath = "Greasy Waste";
			break;
		case "Human Wate water":
			itemXpath = "Human Wastewater";
			break;
		case "Organic Sludge - Ships":
			itemXpath = "Organic Sludge- Ships";
			break;
		case "Organic Sludge- Industries":
			itemXpath = "Organic Sludge- Industries";
			break;
		}
		return itemXpath;

	}

	public void fillTheDetailsByFormSG() throws AWTException, IOException {

		jsutil.switchTab();
		driver.get("https://uat.form.gov.sg/65799f2bc23adc00122846f9");
		eleUtil.scrollUsingRobotClass();
		eleUtil.isPageLoaded(30);
		eleUtil.doElementClickable(By.xpath("//input[@value='Application for new permit']//parent::label"), 20);

		driver.findElement(By.xpath("//input[@value='Application for new permit']//parent::label")).click();
		// eleUtil.waitForVisibilityOfElement(By.xpath("//span[text()='Application for
		// new permit']/preceding-sibling::span"), 20);
		// ele.click();
		// eleUtil.doActionsClick(By.xpath("//input[@value='Application for new
		// permit']//parent::label"));
		jsutil.scrollIntoView(driver.findElement(By.xpath(
				"//div[contains(text(),'Please upload your General Waste Collector')]/ancestor::div[contains(@class,'chakra-form-control')]//div//a[text()='Choose file']")));
		eleUtil.doElementClickable(By.xpath(
				"//div[contains(text(),'Please upload your General Waste Collector')]/ancestor::div[contains(@class,'chakra-form-control')]//div//a[text()='Choose file']"),
				20);

		// driver.findElement(By.xpath("//div[contains(text(),'Please upload your
		// General Waste
		// Collector')]/ancestor::div[contains(@class,'chakra-form-control')]//div//a[text()='Choose
		// file']")).sendKeys("C:\\Users\\sriswathianusha.nulu\\Documents\\Test.txt");
		// driver.findElement(By.xpath("//div[contains(text(),'Please upload your
		// General
		// Waste')]/ancestor::div[contains(@class,'chakra-form-control')]//a")).click();
		// Actions a=new Actions(driver);
		// a.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Choose
		// file')])[1]"))).click().build().perform();
		// div[contains(text(),'Please upload yoGeneral Waste
		// Collector')]/ancestor::div[contains(@class,'chakra-form-control')]//div//a[text()='Choosefile']
		// div[contains(text(),'Please upload your General
		// Waste')]/ancestor::div[contains(@class,'chakra-form-control')]//a
		jsutil.clickElementByJS(driver.findElement(By.xpath(
				"//div[contains(text(),'Please upload your General Waste')]/ancestor::div[contains(@class,'chakra-form-control')]//a")));

		// Runtime.getRuntime().exec("C:\\Users\\sriswathianusha.nulu\\Desktop\\autoscript\\fileupload.exe");

		// eleUtil.doActionsClick(By.xpath("//div[contains(text(),'Please upload your
		// General Waste
		// Collector')]/ancestor::div[contains(@class,'chakra-form-control')]//div//a[text()='Choose
		// file']"));
		// driver.findElement(By.xpath("//div[contains(text(),'Please upload your
		// General Waste
		// Collector')]/ancestor::div[contains(@class,'chakra-form-control')]//div//a[text()='Choose
		// file']"));
		/*
		 * String filePath = "C:\\Users\\sriswathianusha.nulu\\Documents\\Test.txt";
		 * JavascriptExecutor jsx = (JavascriptExecutor) driver; jsx.executeScript(
		 * "document.evaluate('//div[contains(text(),'Please upload your General Waste Collector')]/ancestor::div[contains(@class,'chakra-form-control')]//div//a[text()='Choose file']').value='"
		 * + filePath + "';");
		 */

		System.out.println("Open choose file option");
		String filePath = "C:\\Users\\sriswathianusha.nulu\\Documents\\Test.txt";
		Robot robot = new Robot();
		robot.delay(2000);
		StringSelection stringselection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		jsutil.switchToActiveTab();

	}

	public void neaInterface() {
		eleUtil.isPageLoaded(30);
		eleUtil.waitForVisibilityOfElement(siesImportEntity, 30);
		eleUtil.doClick(siesImportEntity);
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='FullPageWebResource']")));
		eleUtil.waitForFrameByIDOrName("FullPageWebResource", 30);
		// eleUtil.waitForVisibilityOfElement(TemplateField, 30);
		eleUtil.createSelect(TemplateField);
		eleUtil.doSelectDropDownByVisibleText(TemplateField, "WRMS (NEA)");
		eleUtil.doSendKeys(chooseFileOption,
				"C:\\Users\\sriswathianusha.nulu\\newworkspace\\AutomationFramework-main\\src\\test\\resources\\testdata\\WRMS_VehicleRegistrationDetails_20240426_1130.csv");
		// C:\\Users\\sriswathianusha.nulu\\Desktop\\NEA_WRMS_Tanker_Registration_DERegistration_List.xlsx

		eleUtil.doClick(uploadBtn);

		// a[text()='SIES Uploads']

	}

}