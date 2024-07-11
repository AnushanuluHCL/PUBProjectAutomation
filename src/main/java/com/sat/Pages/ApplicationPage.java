package com.sat.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
				AppConstants.SHORT_DEFAUTT_WAIT);

		/* eleUtil.doClearUsingKeys(addressField);
		 eleUtil.doSendKeysWithWait(addressField, addrval, AppConstants.SHORT_DEFAUTT_WAIT);*/
		eleUtil.doClearUsingKeys(addressOfTankerYardField);
		eleUtil.doSendKeys(addressOfTankerYardField, addryard);
		eleUtil.doClearUsingKeys(phonenumField);
		eleUtil.doSendKeys(phonenumField, phonenumval);
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
		eleUtil.scrollUsingRobotClass();
		eleUtil.waitForVisibilityOfElement(HumanWasteBox, 10);
		eleUtil.createSelect(HumanWasteBox);
		eleUtil.doSelectDropDownByVisibleText(HumanWasteBox, HWSelected);
		jsutil.clickElementByJS(driver.findElement(HumanwasteTypeToggleBtn));
		eleUtil.doClick(By.xpath("//div[text()='" + HWType + "']"));
		eleUtil.doClearUsingKeys(HWWastePerMonthField);
		eleUtil.doSendKeys(HWWastePerMonthField, HWPerMonth);
		clickOnSaveBtn();
	}

	public void amountOfOSSWastetypeTanker(String OSSSelected, String OSSPerMonth) {
		eleUtil.scrollUsingRobotClass();
		eleUtil.waitForVisibilityOfElement(OSShipsBox, 50);
		eleUtil.createSelect(OSShipsBox);
		eleUtil.doSelectDropDownByVisibleText(OSShipsBox, OSSSelected);
		eleUtil.doClearUsingKeys(OSShipsPerMonthField);
		eleUtil.doSendKeys(OSShipsPerMonthField, OSSPerMonth);
		clickOnSaveBtn();
	}

	public void amountOfOSIWastetypeTanker(String OSISelected, String OSIPerMonth) {
		eleUtil.scrollUsingRobotClass();
		eleUtil.waitForVisibilityOfElement(OSIndustriesBox, 50);
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
			// eleUtil.isPageLoaded(AppConstants.MEDIUM_DEFAUTT_WAIT);
			eleUtil.doClickWithWait(newAppTankerBtn, AppConstants.MEDIUM_DEFAUTT_WAIT);
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
			System.out.println("tanker number from Applicationtanker - " + CommonActionsPage.TankerName);
			eleUtil.doClearUsingKeys(capacityField);
			eleUtil.doSendKeys(capacityField, CommonActionsPage.TankerCapacity);
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

	public void approveApp() throws InterruptedException {
		// selectFirstRecord(firstRecord, 20);
		//eleUtil.doClick(refreshBtn);
		eleUtil.isPageLoaded(50);
		eleUtil.waitForVisibilityOfElement(createdApp, 50);
		eleUtil.doElementClickable(gwccomnpanydropdpwn, 50);
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
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAUTT_WAIT);
				eleUtil.waitForVisibilityOfElement(createdApp, 30);
				if (driver.findElement(createdApp).isDisplayed()) {
					// flag = true;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		selectFirstRecord(firstRecord, 20);
		eleUtil.doClickWithWait(cretecaseBtn, AppConstants.LONG_DEFAUTT_WAIT);
		// eleUtil.doActionsClick(cretecaseBtn);
		eleUtil.isPageLoaded(100);
		eleUtil.acceptJSAlert(50);
		System.out.println("Alert clicked successfully");
	}

	/*
	 * public void creationOfTankers(String capacity, String wastetype) {
	 * eleUtil.isPageLoaded(AppConstants.MEDIUM_DEFAUTT_WAIT);
	 * eleUtil.doClickWithWait(newAppTankerBtn, AppConstants.MEDIUM_DEFAUTT_WAIT);
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

}
