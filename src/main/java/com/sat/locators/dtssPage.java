package com.sat.locators;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.testUtil.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class dtssPage extends commonActionsPage {

    public dtssPage(WebDriver driver) {
        super(driver);
    }

    factoryPage factory = new factoryPage(driver);
    commonCRMActions crmActions = new commonCRMActions(driver);

    private By dtssID = By.cssSelector("input[aria-label='DTSS ID']");
    private By dtssShaftButton = By.cssSelector("button[aria-label='New Shaft Details. Add New Shaft Details']");
    private By dtssShaftType = By.cssSelector("select[aria-label='Type']");
    private By dtssShaftName = By.cssSelector("input[aria-label='Name']");
    private By zone = By.cssSelector("input[aria-label='Zone, Lookup']");
    private By adHocListView = By.cssSelector("div[aria-label='Entity entity, Ad hoc']");
    private By dtssView = By.xpath("//li[@aria-label='DTSS' and @role='option']");
    private By caseCount = By.xpath("//div[@data-id='InspectionCaseInformation-pcf_grid_control_container'] //span[contains(@class,'statusContainer')]");
    private By searchBoxForEntity = By.xpath("//input[@aria-label='Entity Filter by keyword']");
    private By nextPage = By.cssSelector("[data-icon-name='Forward']");
    private By contractFirstInspection = By.cssSelector("label[aria-label='DTSS Combing For Contractor - First Inspection']");

    String todayDateTime = eleUtil.todayDateAndTime();
    String dtssName = "DTSS" + todayDateTime;
    String shaftName = "Shaft" + todayDateTime;

    public By getCaseCount() {
        return caseCount;
    }

    public By getSearchBoxForEntity() {
        return searchBoxForEntity;
    }

    public void changeListView() {
        eleUtil.waitTillElementIsDisplayed(adHocListView, 30);
        eleUtil.doClickLog(adHocListView, "Clicked on Adhoc List View");
        eleUtil.waitTillElementIsDisplayed(dtssView, 30);
        eleUtil.doClickLog(dtssView, "Clicked on DTSS View");
    }

    public void enterDTSSID() {
        eleUtil.waitTillElementIsDisplayed(dtssID, 30);
        eleUtil.doClickLog(dtssID, "Clicked on DTSS ID field");
        eleUtil.doClearUsingKeysLog(dtssID, "Clear the DTSS ID field");
        commonActionsPage.dtssNumber = dtssName;
        eleUtil.doSendKeysLog(dtssID, commonActionsPage.dtssNumber, "DTSS ID is :");
    }

    public void clickDTSSShaftButton() {
        eleUtil.waitTillElementIsDisplayed(dtssShaftButton, 30);
        eleUtil.doClickLog(dtssShaftButton, "Clicked on DTSS Shaft Button");
    }

    public void enterDTSSShaft(String shaftType) throws InterruptedException {
        eleUtil.waitTillElementIsDisplayed(dtssShaftType, 30);
        eleUtil.selectDropDownValue(dtssShaftType, "selectByVisibleText", shaftType, "select Shaft Type as " + shaftType);
        eleUtil.doClickLog(dtssShaftName, "Clicked on Shaft Name field");
        eleUtil.doClearUsingKeysLog(dtssShaftName, "Clear the Shaft Name field");
        eleUtil.doSendKeysLog(dtssShaftName, shaftName, "Shaft Name is :");
        eleUtil.doClearUsingKeyswithWait(zone, 30);
        eleUtil.doSendKeysWithWaitEnter(zone, "West", 30);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
    }

    public int caseCount() {
        eleUtil.waitForVisibilityOfElement(getCaseCount(), 40);
        String cases = eleUtil.doElementGetText(getCaseCount());
        Log.info("print work order " + cases);
        Log.info("After extract " + eleUtil.extractLastValue(cases));
        return eleUtil.extractLastValue(cases);
    }

    public void checkCaseCount(int caseCountAfterJob) {
        Assert.assertEquals(caseCount(), caseCountAfterJob, "Count is not matched " + caseCountAfterJob);
    }

    public void searchADTSS() throws InterruptedException {
        commonActionsPage.dtssNumber = "DTSS190924113921";
        eleUtil.waitForVisibilityOfElement(getSearchBoxForEntity(), 20);
        Thread.sleep(2000);
        eleUtil.doSendKeys(getSearchBoxForEntity(), commonActionsPage.dtssNumber);
        eleUtil.isPageLoaded(50);
        Thread.sleep(2000);
        driver.findElement(getSearchBoxForEntity()).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        selectFirstRecord();
        getFirstRecord();
    }

    public void forwardButton() {
        eleUtil.waitTillElementIsDisplayed(nextPage, 30);
        eleUtil.doClickLog(nextPage, "Clicked on Forward Button");
    }

    public void caseInDTSS(String caseSubType) {
        By openCaseSubType = By.cssSelector("label[aria-label='" + caseSubType + "']");
        try {
            Thread.sleep(2000);
            eleUtil.doActionsClick(openCaseSubType);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        Log.info("selected the " + caseSubType + " record");
        eleUtil.doDoubleClick(openCaseSubType);
        Log.info("clicked on " + caseSubType + " record");
        commonCRMActions.casenumber = crmActions.setPageTitle();
    }
}
