package com.sat.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.sat.testUtil.Log;

public class PowerAppsAutomateFlowPage extends CommonActionsPage {

	private By UserName = By.xpath("//*[@name='loginfmt']");
	private By NextButton = By.xpath("//*[@type='submit']");
	private By Password = By.xpath("//*[@type='password']");
	private By Signin = By.xpath("//*[@id='idSIButton9']");
	private By DontShowAgain = By.xpath("//*[@name='DontShowAgain']");
	private By Yes = By.className("//*[@id='idSIButton9']");
	private By Search = By.xpath("//*[@aria-label='Search' and contains(@id,'SearchBox')]");
	private By CreateSellerItemsCount = By.xpath("//a[text()='Create_Seller_ItemsCount']");
	private By Run = By.xpath("//button[@data-automation-id='flowCommand-run']");
	private By Runflowbutton = By.xpath("//span[text()='Run flow']");
	private By Done = By.xpath("//span[text()='Done']");
	private By execTime = By.xpath("(//div[@role='rowheader']//span//span[@class='fl-StartTime-ago'])[1]");
	private By refresh = By.xpath("//*[@data-icon-name='Refresh']");
	private By successmessage = By.xpath("(//div[@data-automation-key='status'])[1]");
	private By running = By.xpath("//*[contains(@class,'fl-StatusInCell root')]//*[text()='Running']");

	public PowerAppsAutomateFlowPage(WebDriver driver) {
		super(driver);
	}
	
	

	public void loginPowerApp(String userid, String password) {
		eleUtil.doElementClickable(UserName, 10);
		eleUtil.doSendKeys(UserName, prop.getProperty(userid));
		eleUtil.doClick(NextButton);
		eleUtil.waitForVisibilityOfElement(Password, 20);
		eleUtil.doSendKeys(Password, prop.getProperty(password));
		eleUtil.doElementClickable(Signin, 20);
		eleUtil.doClick(Signin);
	}

	public void runCloudFlow(String flowName) {
		eleUtil.isPageLoaded(30);
		eleUtil.waitForVisibilityOfElement(Search, 20);
		eleUtil.doClick(Search);
		eleUtil.doSendKeys(Search, flowName);
		//driver.findElement(Search).sendKeys(flowName, Keys.ENTER);
		By ele = By.xpath("//a[text()='" + flowName + "']");
		eleUtil.waitForVisibilityOfElement(ele, 20);
		eleUtil.doClick(ele);
		eleUtil.isPageLoaded(100);
		eleUtil.waitForVisibilityOfElement(Run, 30);
		driver.switchTo().frame("widgetIFrame");
		eleUtil.doClick(Run);
		eleUtil.isPageLoaded(50);
		eleUtil.waitForVisibilityOfElement(Runflowbutton, 30);
		try {
			eleUtil.doClick(Runflowbutton);
		}
		catch(Exception e){
			eleUtil.doActionsClick(Runflowbutton);
		}
		eleUtil.waitForVisibilityOfElement(Done, 30);
		eleUtil.doClick(Done);
		eleUtil.isPageLoaded(30);
		eleUtil.doElementClickable(refresh, 20);
		eleUtil.doClick(refresh);
		Log.info("clicked on refresh");
		eleUtil.doElementClickable(execTime, 20);
		String time = eleUtil.doElementGetText(execTime);
		Log.info(time + "hms");
		boolean condition = true;
		while (condition) {
			if (time.contains("sec")) {
				String successmsg = eleUtil.doElementGetText(successmessage);
				if (successmsg.equalsIgnoreCase("Succeeded")) {
					Log.info(successmsg);
					Assert.assertEquals("Succeeded", successmsg);
					condition = false;
				} else {
					eleUtil.doClick(refresh);
				}

			} else {
				Log.info("Flow Execution Failed");
				condition = false;
			}
		}
	}

}