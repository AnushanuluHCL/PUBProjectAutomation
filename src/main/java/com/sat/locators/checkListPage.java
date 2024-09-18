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

    private By sizeOfPumping = By.xpath("//textarea[contains(@aria-label,'What are the size of pumping main based on the SIP?')]");
    private By photo1 = By.xpath("//input[@type='file']");
    private By remark1 = By.xpath("//input[@aria-label='Remarks']");
    private By sewerCorridorZone = By.xpath("//select[contains(@aria-label,'Are there works carried out within the sewer corridor zone or setback zone?')]");
    private By photo2 = By.xpath("//div[@name='Question5'] //input[@type='file']");
    private By remark2 = By.xpath("//div[@name='Question10'] //input[@aria-label='Remarks']");
    private By setbackZoneWithoutPOWS = By.xpath("//select[contains(@aria-label,'Did the site commence an activity within the sewer corridor zone or setback zone without POWS approval?')]");
    private By photo3 = By.xpath("//div[@name='Question6'] //input[@type='file']");
    private By remark3 = By.xpath("//div[@name='Question7'] //input[@aria-label='Remarks']");

    public void fillCheckListForWRN8IMB(String status, String checklistType, String checkListName) throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            WRN8IMBNonCompChecklist(checklistType, checkListName);
            crmActions.saveChecklist();
        }
    }

    public void WRN8IMBNonCompChecklist(String checklistType, String checkListName) throws InterruptedException {
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
}
