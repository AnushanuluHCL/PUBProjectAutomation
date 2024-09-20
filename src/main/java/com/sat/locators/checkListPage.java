package com.sat.locators;

import com.sat.Pages.commonCRMActions;
import com.sat.testUtil.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class checkListPage extends commonCRMActions {
    public checkListPage(WebDriver driver) {
        super(driver);
    }

    commonCRMActions crmActions = new commonCRMActions(driver);
    factoryPage factory = new factoryPage(driver);
    String filePath = System.getProperty("user.dir");
    String pngFilePath = "\\src\\main\\resources\\documents\\PumpingSystemsInspection.png";

    //WRN8IMB
    private By sizeOfPumping = By.xpath("//textarea[contains(@aria-label,'What are the size of pumping main based on the SIP?')]");
    private By photo1 = By.xpath("//input[@type='file']");
    private By remark1 = By.xpath("//input[@aria-label='Remarks']");
    private By sewerCorridorZone = By.xpath("//select[contains(@aria-label,'Are there works carried out within the sewer corridor zone or setback zone?')]");
    private By photo2 = By.xpath("//div[@name='Question5'] //input[@type='file']");
    private By remark2 = By.xpath("//div[@name='Question10'] //input[@aria-label='Remarks']");
    private By setbackZoneWithoutPOWS = By.xpath("//select[contains(@aria-label,'Did the site commence an activity within the sewer corridor zone or setback zone without POWS approval?')]");
    private By photo3 = By.xpath("//div[@name='Question6'] //input[@type='file']");
    private By remark3 = By.xpath("//div[@name='Question7'] //input[@aria-label='Remarks']");

    //WRN7NMB_DTSS1 Combing Photo and Shaft Inspection Checklist
    private By unknownProjectSiteNonCompliance = By.xpath("//input[contains(@name,'Question11_sq') and @value='Yes']");
    private By detailsObtained = By.cssSelector("input[aria-label=' If yes, state the details obtained']");
    private By photoForProjectSite = By.xpath("//input[contains(@aria-label,'Take Photo of the project site')]");
    private By ableToAccess = By.xpath("//input[contains(@name,'Question4_sq') and @value='Yes']");
    private By photoForUpstreamDirection = By.xpath("//input[contains(@aria-label,'Photo showing upstream direction')]");
    private By photoForDownstreamDirection = By.xpath("//input[contains(@aria-label,'Photo showing downstream direction')]");
    private By photoForShowingShaft = By.xpath("//input[contains(@aria-label,'Photo showing shaft')]");
    private By boltsTightened = By.cssSelector("select[aria-label='BOLTS/NUTS TIGHTENED?']");
    private By rustyCover = By.cssSelector("//select[contains(@aria-label,'RUSTY/CRACK COVER?')]");
    private By roofSlab = By.cssSelector("s//select[contains(@aria-label,'CRACK ON ROOF SLAB?')]");
    private By concreteSlab = By.cssSelector("//select[contains(@aria-label,'HOLES IN SEALANT/BITUMEN LAYER AT CONCRETE SLAB?')]");
    private By manholeCover = By.cssSelector("//select[contains(@aria-label,'HOLES IN BITUMEN LAYER ON MANHOLE COVER?')]");
    private By odourDetected = By.xpath("//select[contains(@aria-label,'ODOUR DETECTED?')]");

    public void checkListForWRN8IMB(String status, String checklistType, String checkListName) throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            WRN8IMBChecklist(checklistType, checkListName);
            crmActions.saveChecklist();
        }
    }

    public void WRN8IMBChecklist(String checklistType, String checkListName) throws InterruptedException {
        String path = filePath + pngFilePath;
        Log.info("final path to upload " + path);
        if ("Non-Compliance".equals(checklistType)) {
            eleUtil.waitForVisibilityOfElement(sizeOfPumping, 40);
            eleUtil.doSendKeysLog(sizeOfPumping, "100", "send value in What are the size of pumping main based on the SIP?");
            uploadFile(photo1, path);
            eleUtil.doSendKeysLog(remark1, "Remarks for size of pumping main based on the SIP", "Enter Remark for size of pumping main based on the SIP");

            eleUtil.selectDropDownValue(sewerCorridorZone, "selectByVisibleText", "Yes", "select Yes in sewer corridor zone or setback zone?");
            uploadFile(photo2, path);
            eleUtil.doSendKeysLog(remark2, "Remarks for sewer corridor zone or setback zone?", "Enter Remark for sewer corridor zone or setback zone?");

            eleUtil.selectDropDownValue(setbackZoneWithoutPOWS, "selectByVisibleText", "Yes", "select Yes in sewer corridor zone or setback zone without POWS approval");
            uploadFile(photo3, path);
            eleUtil.doSendKeysLog(remark3, "Remarks for sewer corridor zone or setback zone without POWS approval", "Enter Remark for sewer corridor zone or setback zone without POWS approval");

        } else {
            // Write Compliance code
        }
    }

    public void checkListForWRN7NMBCombingPhoto(String status, String checklistType, String checkListName) throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            WRN7NMBCombingPhotoChecklist(checklistType);
            crmActions.saveChecklist();
        }
    }

    public void WRN7NMBCombingPhotoChecklist(String checklistType) throws InterruptedException {
        String path = filePath + pngFilePath;
        Log.info("final path to upload " + path);
        if ("Non-Compliance".equals(checklistType)) {
            eleUtil.waitForVisibilityOfElement(unknownProjectSiteNonCompliance, 30);
            eleUtil.doClickLog(unknownProjectSiteNonCompliance, "Select Yes for Observed unknown project site?");
            eleUtil.doSendKeysLog(detailsObtained, "WRN7 NMBNon-Compliance", "send value in If yes, state the details obtained");
            uploadFile(photoForProjectSite, path);
            eleUtil.waitForVisibilityOfElement(ableToAccess, 30);
            eleUtil.doClickLog(ableToAccess, "Select Yes for ABLE TO ACCESS?");
            uploadFile(photoForUpstreamDirection, path);
            uploadFile(photoForDownstreamDirection, path);
            uploadFile(photoForShowingShaft, path);
            eleUtil.selectDropDownValue(boltsTightened, "selectByVisibleText", "Yes", "Select Yes in BOLTS/NUTS TIGHTENED?");
            eleUtil.selectDropDownValue(rustyCover, "selectByVisibleText", "Yes", "Select Yes in RUSTY/CRACK COVER?");
            eleUtil.selectDropDownValue(roofSlab, "selectByVisibleText", "Yes", "Select Yes in CRACK ON ROOF SLAB?");
            eleUtil.selectDropDownValue(concreteSlab, "selectByVisibleText", "Yes", "Select Yes in HOLES IN SEALANT/BITUMEN LAYER AT CONCRETE SLAB?");
            eleUtil.selectDropDownValue(manholeCover, "selectByVisibleText", "Yes", "Select Yes in HOLES IN BITUMEN LAYER ON MANHOLE COVER?");
            eleUtil.selectDropDownValue(odourDetected, "selectByVisibleText", "Yes", "Select Yes in ODOUR DETECTED?");

        } else {
            // Write Compliance code
        }
    }

    public void checkListForWRN7NMBCombingVirtual(String status, String checklistType, String checkListName) throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            WRN7NMBCombingVirtualChecklist(checklistType);
            crmActions.saveChecklist();
        }
    }

    public void WRN7NMBCombingVirtualChecklist(String checklistType) throws InterruptedException {
        String path = filePath + pngFilePath;
        Log.info("final path to upload " + path);
        if ("Non-Compliance".equals(checklistType)) {

        } else {
            // Write Compliance code
        }
    }
}
