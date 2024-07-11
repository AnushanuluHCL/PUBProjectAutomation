package com.sat.Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.sat.constants.AppConstants;
import com.sat.testUtil.ElementUtil;
import com.sat.testUtil.ExcelUtil;
import com.sat.testUtil.JavaScriptUtil;
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
			permitnum, permitExpiryDate, GWCReferenceNum, case_FIO,case_SO, case_AO;
	private static HashMap<String, String> sharedValues = new HashMap<>();
	private static HashMap<String, List<String>> sharedValuesList = new HashMap<>();

	private By saveBtn = By.xpath("//button[@aria-label='Save (CTRL+S)']");
	private By saveCloseBtn = By.xpath("//button[@aria-label='Save & Close']");
	private By refreshBtn = By.xpath("//button[@aria-label='Refresh']");
	private By changeAreaLocatoin = By.id("areaSwitcherId");

	private By newBtn = By.xpath("//button[@aria-label='New']");
	private By createdonCol = By.xpath("//div[text()='Created On']");
	// div[text()='Created On']/ancestor::div[@data-testid='columnHeader']
	private By NewToOldCol = By.xpath("//span[text()='Sort newer to older']");
	private By firstRecord = By.xpath("(//input[contains(@aria-label,'elect or deselect the row')])[1]");
	// "(//input[@aria-label='Select or deselect the row'])[1] |
	// (//input[@aria-label='select or deselect the row'])[1]");

	public CommonActionsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		jsutil = new JavaScriptUtil(this.driver);
		excelUtil = new ExcelUtil();
		prop = eleUtil.readProperties();
		softassert = new SoftAssert();
	}

	public static void setSharedValue(String key, String value) {
		sharedValues.put(key, value);
	}

	public static String getSharedValue(String key) {
		return sharedValues.get(key);
	}
	
	public static void setSharedValuesList(String key, List<String> value) {
		List<String> vals=new ArrayList<>();
		sharedValuesList.put(key, vals);
	}

	public static List<String> getSharedValueList(String key) {
		return sharedValuesList.get(key);
	}

	public void changeAreaSelection(String changearea) {
		eleUtil.waitForVisibilityOfElement(changeAreaLocatoin, 30);
		eleUtil.doClick(changeAreaLocatoin);
		WebElement changeareaname = driver
				.findElement(By.xpath("//li[@role='menuitemradio']//span[text()='" + changearea + "']"));
		changeareaname.click();
	}

	public void clickOnSaveBtn() {
		// eleUtil.doClick(saveBtn);
		eleUtil.doActionsClick(saveBtn);
		System.out.println("Clicked on save button");
	}

	public void clickonSaveAndCloseBtn() {
		eleUtil.doElementClickable(saveCloseBtn, 30);
		eleUtil.doClick(saveCloseBtn);
		System.out.println("form is saved and closed the form");
	}

	public void clickOnRefrehBtn() {
		Boolean flag = false;
		while (!flag) {
			// c++;
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

	public void getFirstRecord(By Locator, int tiemout) {
		// eleUtil.doElementClickable(Locator, tiemout);
		eleUtil.doDoubleClick(Locator);
		// Thread.sleep(2000);
		System.out.println("clicked on first record");
	}

	public void selectFirstRecord(By Locator, int tiemout) {
		// eleUtil.doElementClickable(Locator, tiemout);
		try {
			Thread.sleep(2000);
			// eleUtil.doClick(Locator);
			eleUtil.doActionsClick(Locator);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		System.out.println("selected the first record");
	}

	public void selectEntity(String entityname) {
		clickOnRefrehBtn();
		eleUtil.isPageLoaded(10);
		WebElement nameoftheentity = driver.findElement(By.xpath("//div[@title='" + entityname + "']"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		eleUtil.doElementClickable(By.xpath("//div[@title='" + entityname + "']"), 30);
		nameoftheentity.click();
		// span[text()='" + entityname + "']
	}


}
