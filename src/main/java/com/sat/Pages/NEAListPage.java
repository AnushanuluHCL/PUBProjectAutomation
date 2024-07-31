package com.sat.Pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sat.constants.AppConstants;
import com.sat.testUtil.ElementUtil;
import com.sat.testUtil.JavaScriptUtil;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class NEAListPage extends CommonActionsPage {

	String tankercompanyname = null;
	HashMap<Integer, String> tanker = new HashMap<Integer, String>();
	HashMap<Integer, String> capacity = new HashMap<Integer, String>();

	/*
	 * private WebDriver driver; private Properties prop; private ElementUtil
	 * eleUtil; private TestBase testbase; private JavaScriptUtil jsutil; private
	 * CommonActionsPage common; //public static String Tankernamefromnea;
	 */

	// Locators for NEA list entity home page
	private By newBtn = By.xpath("//button[@aria-label='New']");
	private By createdonCol = By.xpath("//div[text()='Created On']");
	// div[text()='Created On']/ancestor::div[@data-testid='columnHeader']
	private By NewToOldCol = By.xpath("//span[text()='Sort newer to older']");
	private By firstRecord = By.xpath(
			"(//input[@aria-label='Select or deselect the row'])[1] | (//input[@aria-label='select or deselect the row'])[1]");

	// Locators for NEA List form/
	private By companyName = By.xpath("//input[@aria-label='Company']");
	private By vehicleNo = By.xpath("//input[@aria-label='Vehicle No']");
	private By vehicleType = By.xpath("//input[@aria-label='Vehicle Type']");
	private By TankerCapacity = By.xpath("//input[contains(@aria-label,'Capacity(m3)')]");
	private By RegOrDeregfield = By.xpath("//input[@aria-label='Registration/Deregistration']");
	private By IUNumField = By.xpath("//input[@aria-label='IU Number']");
	private By saveBtn = By.xpath("//button[@aria-label='Save (CTRL+S)']");
	private By saveCloseBtn = By.xpath("//button[@aria-label='Save & Close']");
	private By refreshBtn = By.xpath("//button[@aria-label='Refresh']");

	private By SIESGWCCompanyfield = By
			.xpath("(// div[@data-id='pub_gwctankerid.fieldControl-Lookup_pub_gwctankerid'])[1]");
	// div[@data-id='pub_gwctankerid.fieldControl-Lookup_pub_gwctankerid']
	private By createdNEARecord_tankercompany = By.xpath("(//div[@col-id='pub_name'])[2]");
	private By createdNEARecord_tanker = By.xpath("(//div[@col-id='pub_vehicleno'])[2]");
	private By createdNEARecord_tankercapacity = By.xpath("(//div[@col-id='pub_tankerscapacitym3'])[2]");

	private By companynameOnNEAHome = By.xpath("//div[@data-testid='pub_name']");
	private By filterBy = By.xpath("//span[text()='Filter by']");
	private By filterbyinputbox = By.xpath("//input[@aria-label='Filter by value']");
	private By suggestionbox = By.xpath("//div[contains(@class,'suggestionTextOverflow')]");
	private By applyBtn = By.xpath("//span[text()='Apply']");

	public NEAListPage(WebDriver driver) {
		super(driver);
		/*
		 * this.driver = driver; eleUtil = new ElementUtil(this.driver); jsutil = new
		 * JavaScriptUtil(this.driver); prop = eleUtil.readProperties(); common=new
		 * CommonActionsPage(TestBase.getDriver());
		 */
	}

	public String getRandomTankercompanyName(String iteration) {
		// return "Tankcompany"+System.currentTimeMillis();
		if (iteration.equals("1")) {

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String currentDateTime = formatter.format(date);
			currentDateTime = currentDateTime.replaceAll("\\W", "");
			tankercompanyname = "Tankcompany" + currentDateTime;
			return tankercompanyname;
		} else {
			return tankercompanyname;
		}
	}

	public String getRandomTankerName() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		String currentDateTime = formatter.format(date);
		currentDateTime = currentDateTime.replaceAll("\\W", "");
		// Tankernamefromnea = "Tank" + currentDateTime;
		return "T_" + currentDateTime;

	}

	public void clcikOnNewButton() {
		eleUtil.doElementClickable(newBtn, AppConstants.SHORT_DEFAULT_WAIT);
		eleUtil.clickElementWhenReady(newBtn, AppConstants.SHORT_DEFAULT_WAIT);
	}

	public void creationOfNEAListRecord(String companyname, String VehicleNum, String Vehicletype, String Capacity,
			String RegOrDereg, String iteration) throws InterruptedException {
		// eleUtil.clickElementWhenReady(newBtn, AppConstants.SHORT_DEFAULT_WAIT);
		eleUtil.doClickWithWait(companyName, AppConstants.LONG_DEFAULT_WAIT);
		eleUtil.doClearUsingKeyswithWait(companyName, AppConstants.LONG_DEFAULT_WAIT);
		eleUtil.doSendKeysWithWait(companyName, getRandomTankercompanyName(iteration), AppConstants.LONG_DEFAULT_WAIT);
		eleUtil.doClearUsingKeyswithWait(vehicleNo, AppConstants.LONG_DEFAULT_WAIT);
		eleUtil.doSendKeysWithWait(vehicleNo, getRandomTankerName(), AppConstants.LONG_DEFAULT_WAIT);
		eleUtil.doClearUsingKeys(vehicleType);
		eleUtil.doSendKeys(vehicleType, Vehicletype);
		eleUtil.doClearUsingKeys(TankerCapacity);
		eleUtil.doSendKeys(TankerCapacity, Capacity);
		eleUtil.doClearUsingKeys(RegOrDeregfield);
		eleUtil.doSendKeys(RegOrDeregfield, RegOrDereg);
		eleUtil.doClearUsingKeys(IUNumField);
		eleUtil.doSendKeys(IUNumField, "1212314");
		eleUtil.doClick(saveBtn);
		clickOnSaveBtn();

		String SIESGWCCompanyfieldval = eleUtil.doElementGetText(SIESGWCCompanyfield);
		// System.out.println("SIESGWCCompanyfield value is " + SIESGWCCompanyfieldval);
		// int c = 0;
		Boolean flag = false;

		while (!flag) {
			// c++;
			try {
				Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
				eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield, AppConstants.SHORT_DEFAULT_WAIT);
				SIESGWCCompanyfieldval = eleUtil.doElementGetText(SIESGWCCompanyfield);
				System.out.println("element clicked");
				if (!SIESGWCCompanyfieldval.isEmpty()) {
					// flag = true;
					break;
				}

			}

			catch (Exception e) {
				System.out.println("Tanker company value is not updating in SIES GWC Company field");
			}
		}
		/*
		 * Thread.sleep(10000); eleUtil.clickElementWhenReady(refreshBtn,
		 * AppConstants.LONG_DEFAULT_WAIT); Thread.sleep(10000); String
		 * SIESGWCCompanyfieldval = eleUtil.doElementGetText(SIESGWCCompanyfield);
		 * System.out.println("value is :" + SIESGWCCompanyfieldval);
		 */
		// eleUtil.doClick(saveCloseBtn);
		clickonSaveAndCloseBtn();
		System.out.println("NEA Record created successfully");
		newrecord();

	}

	public void creationOfNEARecordmultiple(DataTable diftypeOfTankersdata) throws InterruptedException {
		List<Map<String, String>> data = diftypeOfTankersdata.asMaps(String.class, String.class);
		int x = 0;
		for (Map<String, String> form : data) {
			x = x + 1;
			tanker.put(x, getRandomTankerName());
			capacity.put(x, form.get("Tankers_Capacity"));
			// System.out.println("x value is"+tanker.get(x));
			// String company_Name = form.get("Company_name");
			String vehicle_Num = form.get("Vehicle_Number");
			String vehicle_type = form.get("Vehicle_Type");
			//String capacity = form.get("Tankers_Capacity");
			String Reg_Dereg = form.get("Registration_Deregistration");
			String iteration = form.get("Iteration");
			clcikOnNewButton();
			Thread.sleep(3000);
			eleUtil.doClickWithWait(companyName, AppConstants.LONG_DEFAULT_WAIT);
			eleUtil.doClearUsingKeyswithWait(companyName, AppConstants.LONG_DEFAULT_WAIT);
			eleUtil.doSendKeysWithWait(companyName, getRandomTankercompanyName(iteration),
					AppConstants.LONG_DEFAULT_WAIT);
			eleUtil.doClearUsingKeyswithWait(vehicleNo, AppConstants.LONG_DEFAULT_WAIT);
			eleUtil.doSendKeysWithWait(vehicleNo, tanker.get(x), AppConstants.LONG_DEFAULT_WAIT);
			eleUtil.doClearUsingKeys(vehicleType);
			eleUtil.doSendKeys(vehicleType, vehicle_type);
			eleUtil.doClearUsingKeys(TankerCapacity);
			//eleUtil.doSendKeys(TankerCapacity, capacity);
			eleUtil.doSendKeys(TankerCapacity, capacity.get(x));
			eleUtil.doClearUsingKeys(RegOrDeregfield);
			eleUtil.doSendKeys(RegOrDeregfield, Reg_Dereg);
			eleUtil.doClearUsingKeys(IUNumField);
			eleUtil.doSendKeys(IUNumField, "1212314");
			eleUtil.doClick(saveBtn);
			// clickOnSaveBtn();

			String SIESGWCCompanyfieldval = eleUtil.doElementGetText(SIESGWCCompanyfield);
			Boolean flag = false;

			while (!flag) {
				try {
					Thread.sleep(3000);
					eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
					eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield, AppConstants.SHORT_DEFAULT_WAIT);
					SIESGWCCompanyfieldval = eleUtil.doElementGetText(SIESGWCCompanyfield);
					System.out.println("element clicked");
					if (!SIESGWCCompanyfieldval.isEmpty()) {
						break;
					}

				}

				catch (Exception e) {
					System.out.println("Tanker company value is not updating in SIES GWC Company field");
				}
			}

			clickonSaveAndCloseBtn();
			System.out.println("NEA Record created successfully");
			sortTheRecords(createdonCol, NewToOldCol, AppConstants.LONG_DEFAULT_WAIT);
			CommonActionsPage.Tankercompanyname = getTankercompName();
			System.out.println("Tankercompany  - " + CommonActionsPage.Tankercompanyname);
			// newrecord();
			System.out.println("tanker - " + tanker.get(x));

		}

		// System.out.println("list of
		// tankers"+Collections.singletonList(tanker.get(x)));
		// System.out.println("List of tankers: " + new ArrayList<>(tanker.values()));

		x = 0;
		CommonActionsPage.tankerNumber.putAll(tanker);
		CommonActionsPage.tankcapacity.putAll(capacity);
		CommonActionsPage.tankerNumberSize.put("tankersize", tanker.size());
		System.out.println("Tankers size"+tanker.size());
		
		System.out.println("CommonActionsPage.tankerNumber" + CommonActionsPage.tankerNumber);
		
		System.out.println("CommonActionsPage.tankcapacity" + CommonActionsPage.tankcapacity);

	}

	public void newrecord() throws InterruptedException {
		sortTheRecords(createdonCol, NewToOldCol, AppConstants.LONG_DEFAULT_WAIT);
		// common.getFirstRecord(firstRecord, AppConstants.LONG_DEFAULT_WAIT);
		CommonActionsPage.Tankercompanyname = getTankercompName();
		System.out.println("Tankercompany  - " + CommonActionsPage.Tankercompanyname);
		CommonActionsPage.TankerName = getTankerName();
		System.out.println("Tankername - " + CommonActionsPage.TankerName);
		CommonActionsPage.TankerCapacity = getTankerCapacity();
		System.out.println("Tanker Capacity - " + CommonActionsPage.TankerCapacity);
	}

	public String getTankercompName() {
		/*
		 * eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,
		 * AppConstants.MEDIUM_DEFAULT_WAIT); String SIESGWCCompanyfieldval =
		 * eleUtil.doElementGetText(SIESGWCCompanyfield); System.out.println("value=" +
		 * SIESGWCCompanyfieldval); return SIESGWCCompanyfieldval;
		 */
		String str = eleUtil.doElementGetText(createdNEARecord_tankercompany);
		return str;
	}

	public String getTankerName() {
		String str = eleUtil.doElementGetText(createdNEARecord_tanker);
		return str;
	}

	public String getTankerCapacity() {
		String str = eleUtil.doElementGetText(createdNEARecord_tankercapacity);
		return str;
	}

}
