package com.sat.locators;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.testUtil.ExcelUtil;
import com.sat.testUtil.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class projectPage extends commonActionsPage {

    public projectPage(WebDriver driver) {
        super(driver);
    }

    casePage cases = new casePage(driver);
    commonCRMActions crmAction = new commonCRMActions(driver);
    factoryPage factory = new factoryPage(driver);
    pumpingSystemPage pumpingSystem = new pumpingSystemPage(driver);
    ConstructionLocatorsPage constructionPage = new ConstructionLocatorsPage(driver);
    dtssPage dtss = new dtssPage(driver);

    String projectPath = "\\src\\main\\resources\\documents\\WRN11NMBProjectsTemplate.xlsx";
    String bpuSubmissionPath = "\\src\\main\\resources\\documents\\WRN11NMB1BPUSubmissionTemplates.xlsx";
    String projectTitle = "A" + eleUtil.todayDate("yyyy/MM/dd") + "/PP-" + eleUtil.randomNumber();
    String projectReferenceNo = "A" + eleUtil.todayDate("yyyy/MM/dd") + "/PP-" + eleUtil.randomNumber();
    String submissionNo = "SN" + eleUtil.todayDate("yyyy/MM/dd") + "/" + eleUtil.randomNumber();

    // Create new Project and verification
    private By moreCommandButton = By.xpath("//button[contains(@title,'More commands for')]");
    private By importExcel = By.xpath("//ul/button[contains(@title,'Import from Excel')]");
    private By fileUpload = By.cssSelector("input[aria-label='File Upload']");
    private By nextButton = By.cssSelector("button[aria-label='Next']");
    private By finishImport = By.cssSelector("button[aria-label='Finish Import']");
    private By doneButton = By.cssSelector("button[aria-label='Done']");
    private By bpuOfficer = By.cssSelector("input[aria-label='1BPU Officers, Lookup']");
    private By projectRefNumber = By.xpath("//div[@col-id='pub_projectreferencenumber']//a");

    private By importFromExcelErrorDialog = By.xpath("//div[contains(@id,'modalDialogContentContainer')]");
    private By backButton = By.cssSelector("button[aria-label='Back']");

    // BPU Submission and verification
    private By bpuSubmissionGridRefresh = By.xpath("//ul[@aria-label='1BPU Submission Commands'] //button[@aria-label='Refresh']");

    // Create Premise
    private By premiseType = By.cssSelector("input[aria-label='Premise Type, Lookup']");
    private By category = By.cssSelector("select[aria-label='Category']");

    public By getMoreCommandButton() {
        return moreCommandButton;
    }

    public By getImportExcel() {
        return importExcel;
    }

    public By getFileUpload() {
        return fileUpload;
    }

    public By getNextButton() {
        return nextButton;
    }

    public By getFinishImport() {
        return finishImport;
    }

    public By getDoneButton() {
        return doneButton;
    }

    public By getProjectRefNumber() {
        return projectRefNumber;
    }

    public By getImportFromExcelErrorDialog() {
        return importFromExcelErrorDialog;
    }

    public By getBackButton() {
        return backButton;
    }

    public void createProjectWithExcel(String accountSubType) throws InterruptedException, IOException {
        updateProjectExcel(accountSubType);
        eleUtil.waitForVisibilityOfElement(getMoreCommandButton(), 30);
        eleUtil.doClickLog(getMoreCommandButton(), "Click on More Commands for Entity");
        eleUtil.waitForVisibilityOfElement(getImportExcel(), 30);
        eleUtil.doClickLog(getImportExcel(), "Click on Import from Excel button");
        eleUtil.waitForVisibilityOfElement(getFileUpload(), 30);
        String path = cases.filePath + projectPath;
        Log.info(String.format("Final path to upload: %s", path));
        eleUtil.waitForVisibilityOfElement(getNextButton(), 40);
        uploadFile(getFileUpload(), path);
        eleUtil.doClickLog(getNextButton(), "Click on Next button");
        if (eleUtil.elementIsDisplayed(getImportFromExcelErrorDialog(), "Excel import Dialog box is visible")) {
            eleUtil.waitForVisibilityOfElement(cases.getOkButton(), 40);
            eleUtil.doClickLog(cases.getOkButton(), "Click on OK button");
            eleUtil.waitForVisibilityOfElement(getBackButton(), 40);
            eleUtil.doClickLog(getBackButton(), "Click on Back button");
            eleUtil.waitForVisibilityOfElement(getNextButton(), 40);
            eleUtil.doClickLog(getNextButton(), "Click on Next button");
        }
        //eleUtil.doClickLog(getNextButton(), "Click on Next button");
        eleUtil.waitForVisibilityOfElement(getFinishImport(), 40);
        eleUtil.doClickLog(getFinishImport(), "Click on Finish Import button");
        eleUtil.waitForVisibilityOfElement(getDoneButton(), 40);
        eleUtil.doClickLog(getDoneButton(), "Click on Done button");
    }


    public void updateProjectExcel(String accountSubType) throws IOException {
        excelUtil = new ExcelUtil(cases.filePath + projectPath);
        excelUtil.setSheet("ProjectsWRN11NMB");
        Log.info("Project Title " + projectTitle);
        Log.info("Project Reference No " + projectReferenceNo);
        excelUtil.setCellValue(1, 4, projectTitle);
        excelUtil.setCellValue(1, 5, projectReferenceNo);
        excelUtil.setCellValue(1, 8, accountSubType);
        excelUtil.saveAndClose();
    }

    public void checkProjectCreated() throws InterruptedException {
        crmAction.searchRecord(projectTitle);
    }

    public void enterBPUOfficer() throws InterruptedException {
        eleUtil.isPageLoaded(100);
        eleUtil.waitForVisibilityOfElement(bpuOfficer, 60);
        eleUtil.doSendKeysWithWaitEnter(bpuOfficer, "swetha Swetha" , 30);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
        clickOnSaveBtn();
    }

    public void createBPUSubmissionsWithExcel(String accountSubType) throws InterruptedException, IOException {
        updateBPUSubmissionExcel(accountSubType);
        eleUtil.waitForVisibilityOfElement(getMoreCommandButton(), 30);
        eleUtil.doClickLog(getMoreCommandButton(), "Click on More Commands for Entity");
        eleUtil.waitForVisibilityOfElement(getImportExcel(), 30);
        eleUtil.doClickLog(getImportExcel(), "Click on Import from Excel button");
        eleUtil.waitForVisibilityOfElement(getFileUpload(), 30);
        String path = cases.filePath + bpuSubmissionPath;
        Log.info("final path to upload " + path);
        eleUtil.waitForVisibilityOfElement(getNextButton(), 40);
        uploadFile(getFileUpload(), path);
        eleUtil.doClickLog(getNextButton(), "Click on Next button");
        if (eleUtil.elementIsDisplayed(getImportFromExcelErrorDialog(), "Excel import Dialog box is visible")) {
            eleUtil.waitForVisibilityOfElement(cases.getOkButton(), 40);
            eleUtil.doClickLog(cases.getOkButton(), "Click on OK button");
            eleUtil.waitForVisibilityOfElement(getBackButton(), 40);
            eleUtil.doClickLog(getBackButton(), "Click on Back button");
            eleUtil.waitForVisibilityOfElement(getNextButton(), 40);
            eleUtil.doClickLog(getNextButton(), "Click on Next button");
        }
        /*eleUtil.doClickLog(getNextButton(), "Click on Next button");
        eleUtil.waitForVisibilityOfElement(getNextButton(), 40);
        eleUtil.doClickLog(getNextButton(), "Click on Next button");*/
        eleUtil.waitForVisibilityOfElement(getFinishImport(), 40);
        eleUtil.doClickLog(getFinishImport(), "Click on Finish Import button");
        eleUtil.waitForVisibilityOfElement(getDoneButton(), 40);
        eleUtil.doClickLog(getDoneButton(), "Click on Done button");
    }

    public void updateBPUSubmissionExcel(String accountSubType) throws IOException {
        excelUtil = new ExcelUtil(cases.filePath + bpuSubmissionPath);
        excelUtil.setSheet("1BPUSubmissions");
        excelUtil.setCellValue(1, 3, projectTitle);
        excelUtil.setCellValue(1, 4, projectReferenceNo);
        excelUtil.setCellValue(1, 5, accountSubType);
        excelUtil.setCellValue(1, 6, submissionNo);
        excelUtil.saveAndClose();

    }
    public String getProjectReferenceNo() {
        eleUtil.waitForVisibilityOfElement(getProjectRefNumber(), 100);
        String projectReferenceNumber = eleUtil.doElementGetText(getProjectRefNumber());
        return projectReferenceNumber;
    }

    public void checkBPUSubmissionCreated() throws InterruptedException {
        eleUtil.waitTillElementIsDisplayed(bpuSubmissionGridRefresh, 30);
        eleUtil.doClickLog(bpuSubmissionGridRefresh, "Clicked on case grid refresh button");
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;
        while (System.currentTimeMillis() < endTime) {
            if (eleUtil.elementIsDisplayed(crmAction.getNoDataAvailableInSingleGrid(), "No data available")) {
                Thread.sleep(3000);
                eleUtil.doClickLog(bpuSubmissionGridRefresh, "BPU Submission is not created, click on BPU Submission grid refresh button");
            } else {
                // If the element is not displayed, execute the else block logic
                try {
                    commonActionsPage.projectRefNumber = getProjectReferenceNo();
                    Assert.assertEquals(commonActionsPage.projectRefNumber, projectReferenceNo, "Project Reference Number not matched");
                    Log.info(commonActionsPage.casenumber);
                    return; // Exit the method if the case number is verified
                } catch (NoSuchElementException e) {
                    Log.error("Project Reference Number element not found: " + e.getMessage());
                }
            }
        }
    }

    public void openBPUAndEnterQualifiedPerson() throws InterruptedException {
        selectFirstRecord();
        getFirstRecord();
        pumpingSystem.enterQualifiedPerson();
        clickOnSaveNCloseBtn();
    }

    public void checkCaseCreated() throws InterruptedException {
        factory.caseVerification("NMB/PR/I");
    }

    public void checkWorkOrderCreated() throws InterruptedException {
        factory.workOrderVerification();
    }

    public void createManualPremises(String entityType) throws InterruptedException {
        clickonNewBtn();
        factory.selectEntityType(entityType);
        factory.enterEntityName("Premises");
        factory.selectCatchment();
        eleUtil.waitForVisibilityOfElement(premiseType, 30);
        eleUtil.doClearUsingKeysLog(premiseType, "Clear the Premise Type field");
        eleUtil.doSendKeysWithWaitEnter(premiseType, "Animal Holdings", 30);

        pumpingSystem.enterHouseBlkNumber();
        pumpingSystem.enterPostalCode();
        eleUtil.waitTillElementIsDisplayed(category, 30);
        eleUtil.selectDropDownValue(category, "selectByVisibleText", "Tier1",
                "select entity type as Tier 1");
        clickOnSaveBtn();
    }

    public void createManualPublicSewer(String entityType) throws InterruptedException {
        clickonNewBtn();
        factory.selectEntityType(entityType);
        pumpingSystem.enterProjectReferenceNumber();
        pumpingSystem.enterProjectTitle();
        constructionPage.enterArchitect();
        constructionPage.enterProfEngg();
        factory.selectCatchment();
        pumpingSystem.enterHouseBlkNumber();
        pumpingSystem.enterPostalCode();
        pumpingSystem.enterRoadName();
        commonActionsPage.publicSewer=eleUtil.doGetElementAttributeLog(pumpingSystem.getProjectReferenceNumber(), "title", "Displayed value is : ");
        clickOnSaveBtn();
    }

    public void searchAPublicSewer() throws InterruptedException {
        eleUtil.waitForVisibilityOfElement(dtss.getSearchBoxForEntity(), 20);
        Thread.sleep(2000);
        eleUtil.doSendKeys(dtss.getSearchBoxForEntity(), commonActionsPage.publicSewer);
        eleUtil.isPageLoaded(50);
        Thread.sleep(2000);
        driver.findElement(dtss.getSearchBoxForEntity()).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        selectFirstRecord();
        getFirstRecord();
    }

}