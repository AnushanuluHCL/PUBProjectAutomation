package com.sat.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.sat.constants.AppConstants;
import com.sat.testUtil.ElementUtil;
import com.sat.testbase.TestBase;

public class loginPage extends commonActionsPage {

	/*
	 * private WebDriver driver; private Properties prop; private ElementUtil
	 * eleUtil; private TestBase testbase;
	 */

	// Locators to login the application
	private By app_emailID = By.xpath("//input[@name='loginfmt']");
	private By next_Btn = By.xpath("//input[@type='submit']");
	private By app_password = By.name("passwd");
	private By signin = By.xpath("//input[@value='Sign in']");
	private By DontShowcheckbox = By.name("DontShowAgain");
	private By yesbtn = By.xpath("//*[@type='submit']");
	private By yes = By.id("idSIButton9");
	private By signin_afterlogin = By.xpath("//button[@aria-label='Sign In']");

	// Locators after login
	private By appframeLoc = By.xpath("//iframe[@title='AppLandingPage']");
	private By appText = By.xpath("//span[text()='Published Apps']");
	private By app_Name = By.xpath("a[contains(@aria-label,'DQB - Case Management')]");

	// Locators for home page
	private By changeAreaLocatoin = By.id("areaSwitcherId");
	private By select_ChangeArea = By.xpath("//li[@role='menuitemradio']//span[text()='GWC Tanker']");
	// sprivate By entityName = By.xpath("//span[text()='NEA List']");
	private By signoutPic = By.xpath("//div[@id='mectrl_headerPicture']");
	private By signoutBtn = By.xpath("//button[text()='Sign out']");
	private By useanotheraccount = By.xpath("//div[text()='Use another account']");

	public loginPage(WebDriver driver) {
		super(driver);
		/*
		 * this.driver = driver; eleUtil = new ElementUtil(this.driver); prop =
		 * eleUtil.readProperties();
		 */

	}

	public void appLogin(String userid, String password) throws InterruptedException {
		// eleUtil.isPageLoaded(AppConstants.MEDIUM_DEFAULT_WAIT);
		eleUtil.doElementClickable(app_emailID, 10);
		eleUtil.doSendKeys(app_emailID, prop.getProperty(userid));
		// eleUtil.clickElementWhenReady(next_Btn, AppConstants.SHORT_DEFAULT_WAIT);
		eleUtil.waitForVisibilityOfElement(next_Btn, AppConstants.MEDIUM_DEFAULT_WAIT);
		eleUtil.doClick(next_Btn);
		eleUtil.clickElementWhenReady(app_password, AppConstants.SHORT_DEFAULT_WAIT);
		eleUtil.doSendKeys(app_password, prop.getProperty(password));
		// eleUtil.clickElementWhenReady(signin, AppConstants.SHORT_DEFAULT_WAIT);
		eleUtil.doClick(signin);
		eleUtil.isPageLoaded(10);

		/*
		 * if (driver.findElement(DontShowcheckbox).isDisplayed()) {
		 * eleUtil.clickElementWhenReady(DontShowcheckbox,
		 * AppConstants.SHORT_DEFAULT_WAIT); eleUtil.doClick(DontShowcheckbox);
		 * eleUtil.doClick(yesbtn); } else {
		 * System.out.println("Dont show box is not there"); }
		 */

		List<WebElement> li = driver.findElements(DontShowcheckbox);
		if (li.size() > 0) {
			eleUtil.waitForVisibilityOfElement(DontShowcheckbox, AppConstants.MEDIUM_DEFAULT_WAIT);
			eleUtil.clickElementWhenReady(DontShowcheckbox, AppConstants.SHORT_DEFAULT_WAIT);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(DontShowcheckbox)).click().build().perform();
			// eleUtil.doClick(DontShowcheckbox);
			eleUtil.doClick(yesbtn);

		} else {
			System.out.println("Dont show box is not there");
		}

	}

	public void GetApp(String appName) throws InterruptedException {
		Thread.sleep(6000);
		eleUtil.waitForFrameByLocator(appframeLoc, AppConstants.MEDIUM_DEFAULT_WAIT);
		Thread.sleep(6000);
		String acttitle = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("login title is" + acttitle);
		// Assert.assertEquals(acttitle, AppConstants.LOGIN_PAGE_TITLE); //commented on
		// 31 st may
		WebElement appname = driver.findElement(By.xpath("//div[@title='" + appName + "']"));
		appname.click();
		driver.switchTo().defaultContent();
		System.out.println("App name is : " + appName);
		/*
		 * String actualtitle = eleUtil.waitForTitleIs(AppConstants.HOME_PAGE_TITLE,
		 * AppConstants.SHORT_DEFAULT_WAIT); System.out.println("homepage title is" +
		 * acttitle); Assert.assertEquals(actualtitle, AppConstants.HOME_PAGE_TITLE);
		 */
		// Added below code on Jul-1st--> this is for firefox
		List<WebElement> li1 = driver.findElements(signin_afterlogin);
		if (li1.size() > 0) {
			eleUtil.waitForVisibilityOfElement(signin_afterlogin, AppConstants.MEDIUM_DEFAULT_WAIT);
			eleUtil.clickElementWhenReady(signin_afterlogin, AppConstants.SHORT_DEFAULT_WAIT);
			eleUtil.doClick(signin_afterlogin);
			Thread.sleep(4000);
			eleUtil.waitForFrameByLocator(appframeLoc, AppConstants.SHORT_DEFAULT_WAIT);
			Thread.sleep(4000);
			appname = driver.findElement(By.xpath("//div[@title='" + appName + "']"));
			appname.click();
			driver.switchTo().defaultContent();

		} else {
			System.out.println("sign-in button is is not there");
		}
	}

	public void signoutApp() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		eleUtil.waitForVisibilityOfElement(signoutPic, 50);
		try {
			eleUtil.doClick(signoutPic);
		} catch (Exception e) {
			eleUtil.doActionsClick(signoutPic);
		}
		eleUtil.waitForVisibilityOfElement(signoutBtn, 30);
		eleUtil.doClick(signoutBtn);
		eleUtil.waitForVisibilityOfElement(useanotheraccount, 30);
		eleUtil.doClick(useanotheraccount);
	}

}