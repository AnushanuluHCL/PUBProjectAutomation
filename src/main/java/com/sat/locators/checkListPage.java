package com.sat.locators;

import com.sat.Pages.commonActionsPage;
import com.sat.Pages.commonCRMActions;
import com.sat.constants.AppConstants;
import com.sat.testUtil.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class checkListPage extends commonCRMActions {
    public checkListPage(WebDriver driver) {
        super(driver);
    }

    commonCRMActions crmActions = new commonCRMActions(driver);
    commonActionsPage common = new commonActionsPage(driver);
    factoryPage factory = new factoryPage(driver);
    casePage cases = new casePage(driver);
    crmsCasePage crmsCasePage = new crmsCasePage(driver);

    String filePath = System.getProperty("user.dir");
    String pngFilePath = "\\src\\main\\resources\\documents\\PumpingSystemsInspection.png";

    // WRN8IMB
    private By sizeOfPumping = By
            .xpath("//textarea[contains(@aria-label,'What are the size of pumping main based on the SIP?')]");
    private By photo1 = By.xpath("//input[@type='file']");
    private By remark1 = By.cssSelector("input[aria-label='Remarks']");
    private By sewerCorridorZone = By.xpath(
            "//select[contains(@aria-label,'Are there works carried out within the sewer corridor zone or setback zone?')]");
    private By photo2 = By.xpath("//div[@name='Question5'] //input[@type='file']");
    private By remark2 = By.xpath("//div[@name='Question10'] //input[@aria-label='Remarks']");
    private By setbackZoneWithoutPOWS = By.xpath(
            "//select[contains(@aria-label,'Did the site commence an activity within the sewer corridor zone or setback zone without POWS approval?')]");
    private By photo3 = By.xpath("//div[@name='Question6'] //input[@type='file']");
    private By remark3 = By.xpath("//div[@name='Question7'] //input[@aria-label='Remarks']");

    // WRN7NMB_DTSS1 Combing Photo and Shaft Inspection Checklist
    private By projectSiteNonComplianceCombingPhoto = By
            .xpath("//input[contains(@name,'Question11_sq') and @value='Yes']");
    private By detailsObtained = By.xpath("//input[contains(@aria-label,' If yes, state the details obtained')]");
    private By photoForProjectSite = By.xpath("//input[contains(@aria-label,'Take Photo of the project site')]");
    private By ableToAccessCombingPhoto = By.xpath("//input[contains(@name,'Question4_sq') and @value='Yes']");
    private By photoForUpstreamDirection = By
            .xpath("//input[contains(@aria-label,'Photo showing upstream direction')]");
    private By photoForDownstreamDirection = By
            .xpath("//input[contains(@aria-label,'Photo showing downstream direction')]");
    private By photoForShowingShaft = By.xpath("//input[contains(@aria-label,'Photo showing shaft')]");
    private By boltsTightened = By.xpath("//select[contains(@aria-label,'BOLTS/NUTS TIGHTENED?')]");
    private By rustyCover = By.xpath("//select[contains(@aria-label,'RUSTY/CRACK COVER?')]");
    private By roofSlab = By.xpath("//select[contains(@aria-label,'CRACK ON ROOF SLAB?')]");
    private By concreteSlab = By
            .xpath("//select[contains(@aria-label,'HOLES IN SEALANT/BITUMEN LAYER AT CONCRETE SLAB?')]");
    private By manholeCover = By.xpath("//select[contains(@aria-label,'HOLES IN BITUMEN LAYER ON MANHOLE COVER?')]");
    private By odourDetected = By.xpath("//select[contains(@aria-label,'ODOUR DETECTED?')]");

    // WRN7NMB_DTSS Combing virtual checklist for PUB Officer
    private By ltaEMASCCTVCamera = By.xpath("//input[contains(@aria-label,'No. of LTA EMAS CCTV camera viewed')]");
    private By pubCCTVCamera = By.xpath("//input[contains(@aria-label,'No. of PUB CCTV camera viewed')]");
    private By unknownProjectSiteObserved = By.xpath("//input[contains(@name,'Question5_sq') and @value='Yes']");
    private By cameraNumber1 = By.xpath("//input[contains(@aria-label,'Camera Number 1')]");
    private By projectSite = By
            .xpath("//div[@name='Question12'] //input[contains(@aria-label,'Location of project site')]");
    private By screenshotFromCamera = By
            .xpath("//div[@name='Question11'] //input[contains(@aria-label,'Screenshot from the camera')]");

    // WRN7NMB_DTSS1 DTSS1 Shaft Inspection and Gas Reading Checklist for Contractor
    // FIO
    private By ableToAccessShaftInspection = By.xpath("//input[contains(@name,'Question2_sq') and @value='Yes']");
    private By manholeCoverKeyhole = By
            .xpath("//input[contains(@aria-label,'H2S GAS READING AT MANHOLE COVER KEYHOLE')]");
    private By concreteShaftReam = By.xpath("//input[contains(@aria-label,'H2S GAS READING AT CONCRETE SHAFT REAM')]");
    private By projectSiteNonComplianceShaftInspection = By
            .xpath("//input[contains(@name,'Question1_sq') and @value='Yes']");

    // WRN6IMB
    private By physicalActivityCorrectlyStated = By
            .xpath("//select[contains(@aria-label,'physical work activity is correctly stated')]");
    private By PEQPMethodStatement = By.xpath("//select[contains(@aria-label,'PE/QP method statement')]");
    private By anyStructure = By.xpath("//select[contains(@aria-label,'Any structure')]");
    private By anySewageSmell = By.xpath("//select[contains(@aria-label,'Any sewage smell')]");
    private By anyPumpingMainExposed = By.xpath("//select[contains(@aria-label,'Any pumping')]");
    private By markerField = By.xpath("//select[contains(@aria-label,'Marker')]");
    private By worksiteWithin = By.xpath("//select[contains(@aria-label,'work site within')]");
    private By nearingTheStage = By.xpath("//select[contains(@aria-label,'nearing the stage')]");
    private By alWorkComplete = By.xpath("//select[contains(@aria-label,'All Work Complete')]");
    private By remarks = By.xpath("//input[contains(@aria-label,'Remarks')]");

    // WRN4
    private By EERegStatus = By.xpath("//select[@aria-label='EE Registration Status']");
    private By typeOfGT = By.xpath("//select[@aria-label='Type of GT']");
    private By iAmAware = By
            .xpath("//h5[contains(@aria-label,'I am aware')]/../following-sibling::div//input[@Value='Yes']");
    private By iVerify = By
            .xpath("//h5[contains(@aria-label,'I verify')]/../following-sibling::div//input[@Value='Yes']");

    String todayDate = eleUtil.todayDate("MM/dd/yyyy");
    String yesval = "Yes";
    String noval = "No";
    String value;

    private By samplingConducted = By
            .xpath("//h5[@aria-label='Sampling conducted?']/../following-sibling::div//input[@Value='" + value + "']");
    private By doesEEHaveAGT = By.xpath(
            "//h5[contains(@aria-label,'Does EE have a GT')]/../following-sibling::div//input[@Value='" + value + "']");
    private By doesEENeedAGT = By
            .xpath("//h5[contains(@aria-label,'Does EE need a GT')]/../following-sibling::div//input[@Value='" + value
                    + "']	");
    private By whoMaintainedTheGT = By
            .xpath("//h5[contains(@aria-label,'Who maintains the GT? ')]/../following-sibling::div//input[@Value='"
                    + value + "']");
    private By GTCoverSecureToTheGround = By.xpath(
            "//h5[contains(@aria-label,'GT cover secured to the ground?')]/../following-sibling::div//input[@Value='"
                    + value + "']");

    private By unableToRemoveInnerCoreCover = By.xpath(
            "//h5[contains(@aria-label,'Unable to remove inner core cover?')]/../following-sibling::div//input[@Value='"
                    + value + "']");
    private By innerCoreCoverHandleMissing = By.xpath(
            "//h5[contains(@aria-label,'Inner core cover handle missing?')]/../following-sibling::div//input[@Value='"
                    + value + "']");
    private By conditionInInnerCore = By
            .xpath("//h5[contains(@aria-label,'Condition in inner core')]/../following-sibling::div//input[@Value='"
                    + value + "']");
    private By GTObstrcuted = By
            .xpath("//h5[contains(@aria-label,'GT access is obstructed')]/../following-sibling::div//input[@Value='"
                    + value + "']");

    // Locators for WRN1 TEF
    private By housekeepingPremise = By
            .xpath("//select[@aria-label='A.Premise’s Check: 1.Is the housekeeping of the premises satisfactory?']");
    private By spillageOfChemicals = By.xpath(
            "//select[@aria-label='A.Premise’s Check: 2.Is there any spillages of chemicals / oil found in the premises?']");
    private By objToMeetTheVisitField = By
            .xpath("//textarea[contains(@aria-label,'Objectives to meet for the visit: ')]");

    // Locators for WRN8 NMB
    private By constructionActivitiyFound = By
            .xpath("//select[@aria-label='Is there any construction activity found?']");
    private By repName = By.xpath("//input[@aria-label='Contractor’s Rep Name']");
    private By repEmail = By.xpath("//input[contains(@aria-label,\"Contractor's Rep Email Address\")]");
    private By repTelNo = By.xpath("//input[contains(@aria-label,\"Contractor's Rep Tel No\")]");
    private By qpName = By.xpath("//input[@aria-label='QP Rep Name']");
    private By qpEmail = By.xpath("//input[contains(@aria-label,\"QP Rep Email Address\")]");
    private By qpTelNo = By.xpath("//input[contains(@aria-label,\"QP Rep Tel No\")]");
    private By sewerId = By.xpath("//input[@aria-label='Sewer ID']");
    private By sewerDiameter = By.xpath("//input[contains(@aria-label,'Sewer Diameter')]");
    private By sewerOutsideHoarding = By.xpath("//select[contains(@aria-label,'Sewer outside project hoarding?')]");
    private By typeOfActivity = By.xpath("//select[contains(@aria-label,'Type of Specified Activity')]");
    private By depth = By.xpath("//input[contains(@aria-label,'Depth')]");
    private By distance = By.xpath("//input[contains(@aria-label,'Distance')]");
    private By statusOfActivity = By.xpath("//select[contains(@aria-label,'Status of specified activity ')]");
    private By activityCovered = By.xpath("//select[contains(@aria-label,'activity covered in POWS')]");
    private By attachReport = By.xpath("//input[@aria-label='Attach report']/..");// input[@aria-label='Attach
    // report']/..//span[contains(text(),'Choose
    // file')]
    private By sendfileToReport = By.xpath("//input[@aria-label='Attach report']");

    // Locators for WRN5
    private By servicetasksTab = By.xpath("//li[text()='Checklist']");// li[text()='Service Tasks']
    private By oldSealnumField = By.xpath("//td[@title='Old Seal Number']");
    private By newSealnumField = By.xpath("//input[@aria-label='New Seal Number']");
    private By photosTakendropdownField = By.xpath("//select[@aria-label='Photos taken']"); // visible text Yes/No
    private By markcompleteBtn = By.xpath("//button[contains(@title,'Set Task as fully completed')]");
    private By saveBtnInChklsit = By.xpath("//button[contains(@title,'Save this Work Order Service Task.')]");
    private By saveNCloseBtnInChklsit = By
            .xpath("//button[contains(@title,'Save and close this Work Order Service Task.')]");
    // Locators on service tasks home page
    private By checklisttypeField = By.xpath("//div[@col-id='msdyn_inspection']/descendant::a");
    private By checklistNameField = By.xpath("//div[@col-id='msdyn_name']/descendant::a");
    private By maximizescreenBtn = By.xpath("//button[@aria-label='Enter full screen mode']");
    private By tankerregno = By.xpath("//label[text()='Tanker Registration No.']");

    // Locator for WRN10
    private By pumpingInstallation = By.cssSelector("input[aria-label='Pumping Installation']");
    private By pumpingMain = By.cssSelector("input[aria-label='Pumping Main #1/2/3*']");
    private By complianceMethodStatement = By.xpath("//select[contains(@aria-label,'Compliance to Method Statement')]");
    private By passPressureCOP = By.xpath("//select[contains(@aria-label,'Pass Pressure Test according to COP')]");
    private By defect = By.cssSelector("input[aria-label='Defects (if any):']");
    private By abandonedManhole = By.xpath("//select[contains(@aria-label,'abandoned manholes')]");
    private By remarksForSewerageSmell = By.xpath("//div[@name='Question43'] //input[@aria-label='Remarks']");
    private By remarksForLeak = By.xpath("//div[@name='Question44'] //input[@aria-label='Remarks']");
    private By location = By.cssSelector("input[aria-label='Location']");

    // Locator for CWD5
    private By preEventInspection = By.xpath("//input[@name='Question1_sq_100'] [@aria-label='Yes']");
    private By setupComplyCompliance = By.xpath("//input[@name='Question3_sq_102'] [@aria-label='Yes']");
    private By setupComplyNonCompliance = By.xpath("//input[@name='Question3_sq_102'] [@aria-label='No']");

    private By duringEventInspection = By.xpath("//input[@name='Question2_sq_104'] [@aria-label='Yes']");
    private By eventOrgComplyCompliance = By.xpath("//input[@name='Question4_sq_106'] [@aria-label='Yes']");
    private By eventOrgComplyNonCompliance = By.xpath("//input[@name='Question4_sq_106'] [@aria-label='No']");

    private By postEventInspection = By.xpath("//input[@name='Question2_sq_108'] [@aria-label='Yes']");
    private By allEventSetupCompliance = By.xpath("//input[contains(@name,'Question4_')] [@aria-label='Yes']");
    private By allEventSetupNonCompliance = By.xpath("//input[contains(@name,'Question4_')] [@aria-label='No']");

    private By administrationOutcome = By.cssSelector("select[aria-label='Administrative Outcome']");
    private By mainCategory = By.cssSelector("input[aria-label='Main Category, Lookup']");

    private By dateAndTime = By.xpath("//input[@aria-label='Date'] /following-sibling::i");
    private By reservoir = By.cssSelector("input[aria-label='Reservoir']");
    private By vesselId = By.cssSelector("input[aria-label='Vessel ID/ Vessel Name']");
    private By vesselType = By.cssSelector("select[aria-label='Vessel Type']");
    private By activityType = By.cssSelector("select[aria-label='Activity Type']");
    private By compliance = By.cssSelector("select[aria-label='Compliance']");

    //Locator for CWD1
    private By illegalActivityObserved = By.cssSelector("select[aria-label='Illegal Activity Observed']");
    private By uploadPhoto = By.cssSelector("input[aria-label='Photo']");

    //Locator for CWD2
    private By statusConstructionWorkQ1 = By.xpath("//select[contains(@aria-label,'Status of construction work')]");
    private By earthworkAtSiteQ3 = By.xpath("//select[contains(@aria-label,'Who carry out the earthwork at site?')]");
    private By contractorSitePersonnelDetailsQ4 = By.xpath("//input[contains(@aria-label,'Contractor site personnel details')]");
    private By zone = By.cssSelector("input[aria-label='Zone']");
    private By remarksQ22 = By.cssSelector("input[aria-label='22.Remarks']");
    private By overviewPhotoConstructionSiteQ5 = By.xpath("//input[contains(@aria-label,'Overview photo of the construction site')]");

    //Locator for CWD4
    private By contractorName = By.cssSelector("input[aria-label='Contractor Name']");
    private By inspectionType= By.cssSelector("input[aria-label='Manual']");
    private By size = By.cssSelector("input[aria-label='Size (mm)']");
    private By approvedWorksPOWSNonCompliance = By.xpath("//input[contains(@name,'Question2_')] [@aria-label='No']");
    private By remarksQ3 = By.xpath("//textarea[contains(@aria-label,'3.a. Remark')]");
    private By anySignsOfLeaks = By.xpath("//input[contains(@name,'Question20_')] [@aria-label='No']");
    private By rectificationNotRequired = By.xpath("//input[contains(@name,'Question1_')] [@aria-label='No']");
    private By rectificationRequired = By.xpath("//input[contains(@name,'Question1_')] [@aria-label='Yes']");
    private By remark = By.xpath("//textarea[@aria-label='Remarks']");
    private By rawWatermainsQ15 = By.cssSelector("input[aria-label='Prism']");

    //Locator for CWD3&6
    private By temperature = By.xpath("//select[contains(@aria-label,'Temperature')]");
    private By incidentLocation = By.cssSelector("input[aria-label='Incident Location']");
    private By anyAbnormalityObserved = By.xpath("//select[contains(@aria-label,'Any abnormality observed')]");
    private By sampleTaken = By.xpath("//input[contains(@name,'Question8_')] [@aria-label='Yes']");
    private By pubWONumber = By.cssSelector("input[aria-label='PUB WO Number']");
    private By programmeName = By.cssSelector("input[aria-label='Programme Name']");
    private By sourceDischargeIdentified = By.xpath("//select[contains(@aria-label,'Source of Discharge identified')]");
    private By inspectionCompleted = By.xpath("//select[contains(@aria-label,'Inspection Completed')]");
    private By premiseSubType = By.cssSelector("input[aria-label='Premise SubType']");
    private By sampleTakenForPremisesInspection = By.xpath("//input[contains(@name,'Question141_')] [@aria-label='Yes']");
    private By nextButton = By.cssSelector("input[value='Next']");
    private By generalHousekeepingPremises = By.xpath("//input[contains(@name,'Question33_')] [@aria-label='No']");
    private By remarksQ1 = By.xpath("//div[@name='Question1']//input[@aria-label='Remarks']");

    public By getSamplingConducted(String val) {
        return samplingConducted;
    }

    public By getDoesEEHaveAGT(String val) {
        return doesEEHaveAGT;
    }

    public By getDoesEENeedAGT(String val) {
        return doesEENeedAGT;
    }

    public By getWhoMaintainedTheGT(String val) {
        return whoMaintainedTheGT;
    }

    public By getGTCoverSecureToTheGround(String val) {
        return GTCoverSecureToTheGround;
    }

    public By getUnableToRemoveInnerCoreCover(String val) {
        return unableToRemoveInnerCoreCover;
    }

    public By getInnerCoreCoverHandleMissing(String val) {
        return innerCoreCoverHandleMissing;
    }

    public By getConditionInInnerCore(String val) {
        return conditionInInnerCore;
    }

    public By getGTObstrcuted(String val) {
        return GTObstrcuted;
    }

    public void checkListForWRN8IMB(String status, String checklistType, String checkListName)
            throws InterruptedException {
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
            eleUtil.doSendKeysLog(sizeOfPumping, "100",
                    "send value in What are the size of pumping main based on the SIP?");
            uploadFile(photo1, path);
            eleUtil.doSendKeysLog(remark1, "Remarks for size of pumping main based on the SIP",
                    "Enter Remark for size of pumping main based on the SIP");

            eleUtil.selectDropDownValue(sewerCorridorZone, "selectByVisibleText", "Yes",
                    "select Yes in sewer corridor zone or setback zone?");
            uploadFile(photo2, path);
            eleUtil.doSendKeysLog(remark2, "Remarks for sewer corridor zone or setback zone?",
                    "Enter Remark for sewer corridor zone or setback zone?");

            eleUtil.selectDropDownValue(setbackZoneWithoutPOWS, "selectByVisibleText", "Yes",
                    "select Yes in sewer corridor zone or setback zone without POWS approval");
            uploadFile(photo3, path);
            eleUtil.doSendKeysLog(remark3, "Remarks for sewer corridor zone or setback zone without POWS approval",
                    "Enter Remark for sewer corridor zone or setback zone without POWS approval");

        } else {
            // Write Compliance code
        }
    }

    public void checkListForWRN7NMBCombingPhoto(String status, String checklistType, String checkListName)
            throws InterruptedException {
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
            eleUtil.waitForVisibilityOfElement(projectSiteNonComplianceCombingPhoto, 30);
            eleUtil.doClickLog(projectSiteNonComplianceCombingPhoto, "Select Yes for Observed unknown project site?");
            eleUtil.doSendKeysLog(detailsObtained, "WRN7 NMBNon-Compliance",
                    "send value in If yes, state the details obtained");
            uploadFile(photoForProjectSite, path);
            eleUtil.waitForVisibilityOfElement(ableToAccessCombingPhoto, 30);
            eleUtil.doClickLog(ableToAccessCombingPhoto, "Select Yes for ABLE TO ACCESS?");
            uploadFile(photoForUpstreamDirection, path);
            uploadFile(photoForDownstreamDirection, path);
            uploadFile(photoForShowingShaft, path);
            eleUtil.selectDropDownValue(boltsTightened, "selectByVisibleText", "Yes",
                    "Select Yes in BOLTS/NUTS TIGHTENED?");
            eleUtil.selectDropDownValue(rustyCover, "selectByVisibleText", "Yes", "Select Yes in RUSTY/CRACK COVER?");
            eleUtil.selectDropDownValue(roofSlab, "selectByVisibleText", "Yes", "Select Yes in CRACK ON ROOF SLAB?");
            eleUtil.selectDropDownValue(concreteSlab, "selectByVisibleText", "Yes",
                    "Select Yes in HOLES IN SEALANT/BITUMEN LAYER AT CONCRETE SLAB?");
            eleUtil.selectDropDownValue(manholeCover, "selectByVisibleText", "Yes",
                    "Select Yes in HOLES IN BITUMEN LAYER ON MANHOLE COVER?");
            eleUtil.selectDropDownValue(odourDetected, "selectByVisibleText", "Yes", "Select Yes in ODOUR DETECTED?");

        } else {
            // Write Compliance code
        }
    }

    public void checkListForWRN7NMBCombingVirtual(String status, String checklistType, String checkListName)
            throws InterruptedException {
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
            eleUtil.waitForVisibilityOfElement(ltaEMASCCTVCamera, 40);
            eleUtil.doSendKeysLog(ltaEMASCCTVCamera, "100", "send value in No. of LTA EMAS CCTV camera viewed");
            eleUtil.doSendKeysLog(pubCCTVCamera, "100", "send value in No. of PUB CCTV camera viewed");
            eleUtil.doClickLog(unknownProjectSiteObserved,
                    "Select Yes for Are there any unknown project site observed?");
            eleUtil.doSendKeysLog(cameraNumber1, "Test Camera", "send value in Camera Number 1");
            eleUtil.doSendKeysLog(projectSite, "Test Project", "send value in Location of project site");
            uploadFile(screenshotFromCamera, path);
        } else {
            // Write Compliance code
        }
    }

    public void checkListForWRN7NMBShaftInspection(String status, String checklistType, String checkListName)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            WRN7NMBShaftInspectionChecklist(checklistType);
            crmActions.saveChecklist();
        }
    }

    public void WRN7NMBShaftInspectionChecklist(String checklistType) throws InterruptedException {
        String path = filePath + pngFilePath;
        Log.info("final path to upload " + path);
        if ("Non-Compliance".equals(checklistType)) {
            eleUtil.waitForVisibilityOfElement(ableToAccessShaftInspection, 40);
            eleUtil.doClickLog(ableToAccessShaftInspection, "Select Yes for ABLE TO ACCESS?");
            eleUtil.selectDropDownValue(boltsTightened, "selectByVisibleText", "Yes",
                    "Select Yes in BOLTS/NUTS TIGHTENED?");
            eleUtil.selectDropDownValue(rustyCover, "selectByVisibleText", "Yes", "Select Yes in RUSTY/CRACK COVER?");
            eleUtil.selectDropDownValue(roofSlab, "selectByVisibleText", "Yes", "Select Yes in CRACK ON ROOF SLAB?");
            eleUtil.selectDropDownValue(concreteSlab, "selectByVisibleText", "Yes",
                    "Select Yes in HOLES IN SEALANT/BITUMEN LAYER AT CONCRETE SLAB?");
            eleUtil.selectDropDownValue(manholeCover, "selectByVisibleText", "Yes",
                    "Select Yes in HOLES IN BITUMEN LAYER ON MANHOLE COVER?");
            eleUtil.selectDropDownValue(odourDetected, "selectByVisibleText", "Yes", "Select Yes in ODOUR DETECTED?");
            eleUtil.doSendKeysLog(manholeCoverKeyhole, "100", "send value in H2S GAS READING AT MANHOLE COVER KEYHOLE");
            eleUtil.doSendKeysLog(concreteShaftReam, "100", "send value in H2S GAS READING AT CONCRETE SHAFT REAM");
            uploadFile(photoForUpstreamDirection, path);
            uploadFile(photoForDownstreamDirection, path);
            uploadFile(photoForShowingShaft, path);
            eleUtil.doClickLog(projectSiteNonComplianceShaftInspection,
                    "Select Yes for Observed unknown project site?");
            eleUtil.waitForVisibilityOfElement(detailsObtained, 30);
            eleUtil.doSendKeysLog(detailsObtained, "WRN7 NMBNon-Compliance",
                    "send value in If yes, state the details obtained");
        } else {
            // Write Compliance code
        }
    }

    public void fillCheckListQuestionsForWRN6IMB(String complainceStatus, String allWorkComplete, String value)
            throws InterruptedException {
        commonActionsPage.WOnumber = crmActions.getWONumber();
        List<String> woNum = commonActionsPage.WOnumber;
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is:" + woNum.size());
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), "WRN 6 IMB Pumping Main Construction Site Inspection Checklist",
                    "In Progress");
            selectChecklistForWRN6IMB(complainceStatus, allWorkComplete, value);
            crmActions.saveChecklist();
        }
    }

    public void selectChecklistForWRN6IMB(String complainceStatus, String allWorkComplete, String value)
            throws InterruptedException {
        By alWorkComplete = By.xpath("//select[contains(@aria-label,'" + allWorkComplete + "')]");
        By remarksField = By.xpath("//input[contains(@aria-label,'Remarks')]");
        By photoUpload = By.xpath("//input[@aria-label=' Photo' or @aria-label='Photo']");
        if (complainceStatus.equals("Non-Complaince")) {
            eleUtil.waitForVisibilityOfElement(physicalActivityCorrectlyStated, 40);
            eleUtil.doClickLog(physicalActivityCorrectlyStated,
                    "Verify physical work activity is correctly stated based on POWS submission");
            eleUtil.selectDropDownValue(physicalActivityCorrectlyStated, "selectByVisibleText", "No",
                    "Select No in Verify physical work activity is correctly stated based on POWS submission");
            eleUtil.selectDropDownValue(PEQPMethodStatement, "selectByVisibleText", "NA",
                    "Select NA in Physical work activity is done according to PE/QP method statement and at correct location");
            eleUtil.selectDropDownValue(anyStructure, "selectByVisibleText", "NA",
                    "Select NA in Any structure (e.g. heavy load) is on top of our pumping main?");
            eleUtil.selectDropDownValue(anySewageSmell, "selectByVisibleText", "NA",
                    "Select NA in Any sewage smell /leak/water ponding at site?");
            eleUtil.selectDropDownValue(anyPumpingMainExposed, "selectByVisibleText", "NA",
                    "Select NA in Any pumping main is exposed?");
            eleUtil.selectDropDownValue(markerField, "selectByVisibleText", "NA",
                    "Select NA in Marker, Pegging or any other form of identification to demarcate the presence of pumping main is correct within worksite (provide photos)");
            eleUtil.selectDropDownValue(worksiteWithin, "selectByVisibleText", "NA",
                    "Select NA in  For work site within and near pumping installation, any signs of cracks/settlement found within the installation?");
            eleUtil.selectDropDownValue(nearingTheStage, "selectByVisibleText", "NA",
                    "Select NA in Does the work require standing supervision (e.g. excavation is nearing the stage of exposing the PM, specified activity has high risk of damaging PM, etc.)?");

        } else {
            eleUtil.waitForVisibilityOfElement(physicalActivityCorrectlyStated, 40);
            eleUtil.doClickLog(physicalActivityCorrectlyStated,
                    "Verify physical work activity is correctly stated based on POWS submission");
            eleUtil.selectDropDownValue(physicalActivityCorrectlyStated, "selectByVisibleText", "Yes",
                    "Select Yes in Verify physical work activity is correctly stated based on POWS submission");
            eleUtil.selectDropDownValue(PEQPMethodStatement, "selectByVisibleText", "Yes",
                    "Select Yes in Physical work activity is done according to PE/QP method statement and at correct location");
            eleUtil.selectDropDownValue(anyStructure, "selectByVisibleText", "No",
                    "Select No in Any structure (e.g. heavy load) is on top of our pumping main?");
            eleUtil.selectDropDownValue(anySewageSmell, "selectByVisibleText", "No",
                    "Select No in Any sewage smell /leak/water ponding at site?");
            eleUtil.selectDropDownValue(anyPumpingMainExposed, "selectByVisibleText", "No",
                    "Select No in Any pumping main is exposed?");
            eleUtil.selectDropDownValue(markerField, "selectByVisibleText", "Yes",
                    "Select Yes in Marker, Pegging or any other form of identification to demarcate the presence of pumping main is correct within worksite (provide photos)");
            eleUtil.selectDropDownValue(worksiteWithin, "selectByVisibleText", "NA",
                    "Select NA in  For work site within and near pumping installation, any signs of cracks/settlement found within the installation?");
            eleUtil.selectDropDownValue(nearingTheStage, "selectByVisibleText", "NA",
                    "Select NA in Does the work require standing supervision (e.g. excavation is nearing the stage of exposing the PM, specified activity has high risk of damaging PM, etc.)?");

        }

        eleUtil.selectDropDownValue(alWorkComplete, "selectByVisibleText", value, "Select NA in All Work Complete?");
        eleUtil.doSendKeysLog(remarks, "WRN6 IMB Non-Compliance", "Enter remarks in Other observations/Remarks");
        List<WebElement> noOfEles = driver.findElements(remarksField);
        System.out.println("noOfEles" + noOfEles.size());

        for (int i = 0; i < noOfEles.size(); i++) {
            WebElement currEle = noOfEles.get(i);
            currEle.clear();
            currEle.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            currEle.sendKeys("Test");
        }
        List<WebElement> noOfEles1 = driver.findElements(photoUpload);
        System.out.println("noOfEles1" + noOfEles1.size());
        for (int j = 1; j <= noOfEles1.size(); j++) {
            By photoUpload1 = By.xpath("(//input[@aria-label=' Photo' or @aria-label='Photo'])[" + j + "]");
            common.uploadFile(photoUpload1, filePath + "\\src\\test\\resources\\testdata\\UploadForChecklist.xlsx");

        }

    }

    public void amendChecklistFor6IMB(String WOType, String complainceStatus, String allWorkComplete, String value)
            throws InterruptedException {
        selectWOBasedOnType(WOType);
        eleUtil.doClick(getChecklistTab());
        String actualName = eleUtil.doGetElementAttribute(getCheckListNameField(), "aria-label");
        assertTrue(actualName.contains("WRN 6 IMB Pumping Main Construction Site Inspection Checklist"),
                "Checklist name is not matching");
        eleUtil.doElementClickable(getCheckListNameField(), 20);
        eleUtil.doClick(getCheckListNameField());
        eleUtil.doElementClickable(getMaximizeScreenBtn(), 10);
        eleUtil.doClick(getMaximizeScreenBtn());
        clearResponseInChecklist();
        selectChecklistForWRN6IMB(complainceStatus, allWorkComplete, value);
        crmActions.saveChecklist();
    }

    public void sampleLabForAnalysisForWRN4() throws InterruptedException {
        eleUtil.waitTillElementIsDisplayed(factory.clickOnNewSampleLab(), 30);
        eleUtil.doClickLog(factory.clickOnNewSampleLab(), "Click on New Sample For Lab Analysis button");
        eleUtil.waitTillElementIsDisplayed(factory.selectDateAndTime(), 30);
        eleUtil.doSendKeysWithWaitEnter(factory.selectDateAndTime(), todayDate, 100);
        eleUtil.doClickLog(factory.clickOnParametersAnalysed(), "Enter 1st value as Oil & Grease (Hydrocarbon)");
        eleUtil.doClearUsingKeysWithWait(factory.clickOnParametersAnalysed(), 30);
        eleUtil.doSendKeysWithWaitEnter(factory.clickOnParametersAnalysed(), "Oil & Grease (Hydrocarbon)", 30);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
        eleUtil.doClickLog(factory.clickOnParametersAnalysed(), "Enter 2nd value as Oil & Grease (Non-Hydrocarbon)");
        eleUtil.doSendKeysWithWaitEnter(factory.clickOnParametersAnalysed(), "Oil & Grease (Non-Hydrocarbon)", 50);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
        eleUtil.doClickLog(factory.clickOnParametersAnalysed(), "Enter 3rd value as Oil & Grease (Total)");
        eleUtil.doSendKeysWithWaitEnter(factory.clickOnParametersAnalysed(), "Oil & Grease (Total)", 50);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
        eleUtil.doClickLog(factory.clickOnLab(), "Enter 1st value as PUB Laboratory 1");
        eleUtil.doClearUsingKeysWithWait(factory.clickOnLab(), 30);
        eleUtil.doSendKeysWithWaitEnter(factory.clickOnLab(), "PUB Laboratory 1", 30);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
        eleUtil.waitTillElementIsDisplayed(factory.getSaveAndClose(), 30);
        eleUtil.doClickLog(factory.getSaveAndClose(), "Click on Save and Close button");
    }

    public void selectEERegStatus() {
        eleUtil.waitForVisibilityOfElement(EERegStatus, 40);
        eleUtil.doClickLog(EERegStatus, "Clicked on EE Registration Status");
        eleUtil.selectDropDownValue(EERegStatus, "selectByVisibleText", "Active",
                "Select Active in EE Registration Status");
    }

    public void selectChecklistForWRN4_GTSampling(String complainceStatus, String checklistName) {
        selectEERegStatus();
        if (complainceStatus.equals("Non-Complaince")) {
            eleUtil.waitForVisibilityOfElement(getSamplingConducted(yesval), 40);
            eleUtil.doClickLog(getSamplingConducted(yesval), "Clicked on Sampling Conducted? field : ");
        } else {
            eleUtil.waitForVisibilityOfElement(getSamplingConducted(noval), 40);
            eleUtil.doClickLog(getSamplingConducted(noval), "Clicked on Sampling Conducted? field : ");
        }
        eleUtil.waitForVisibilityOfElement(iAmAware, 20);
        eleUtil.doClickLog(iAmAware,
                "Clicked on I am aware that PUB has collected sample from our grease trap field : ");
        eleUtil.waitForVisibilityOfElement(iVerify, 20);
        eleUtil.doClickLog(iVerify, "Clicked on I verify that I have witnessed the sampling process field : ");
    }

    public void selectChecklistForWRN4_GTNotInstalled(String complainceStatus, String checklistName) {
        selectEERegStatus();
        eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(noval), 40);
        eleUtil.doClickLog(getDoesEEHaveAGT(noval),
                "Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

        eleUtil.waitForVisibilityOfElement(getDoesEENeedAGT(yesval), 40);
        eleUtil.doClickLog(getDoesEENeedAGT(yesval),
                "Clicked on Does EE need a GT / Grease Separator / Grease Interceptor (Portable)? field : ");
    }

    public void selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi1(String complainceStatus, String checklistName) {
        selectEERegStatus();

        eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
        eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
                "Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

        eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
        eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
        eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Small GT", "Select Small GT in Type Of GT");

        eleUtil.waitForVisibilityOfElement(getWhoMaintainedTheGT("Not maintained"), 40);
        eleUtil.doClickLog(getWhoMaintainedTheGT("Not maintained"), "Clicked on Who maintains the GT? field : ");

        eleUtil.waitForVisibilityOfElement(getGTCoverSecureToTheGround(yesval), 40);
        eleUtil.doClickLog(getGTCoverSecureToTheGround(yesval),
                "Clicked on GT cover secured to the ground? (Hence can't access GT internals) field : ");
    }

    public void selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi2(String complainceStatus, String checklistName) {
        selectEERegStatus();

        eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
        eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
                "Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

        eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
        eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
        eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Big GT", "Select Big GT in Type Of GT");

        eleUtil.waitForVisibilityOfElement(getWhoMaintainedTheGT("Not maintained"), 40);
        eleUtil.doClickLog(getWhoMaintainedTheGT("Not maintained"), "Clicked on Who maintains the GT? field : ");

        eleUtil.waitForVisibilityOfElement(getGTCoverSecureToTheGround(noval), 40);
        eleUtil.doClickLog(getGTCoverSecureToTheGround(noval),
                "Clicked on GT cover secured to the ground? (Hence can't access GT internals) field : ");

        eleUtil.waitForVisibilityOfElement(getUnableToRemoveInnerCoreCover(noval), 40);
        eleUtil.doClickLog(getUnableToRemoveInnerCoreCover(noval),
                "Clicked on Unable to remove inner core cover? field : ");

        eleUtil.waitForVisibilityOfElement(getInnerCoreCoverHandleMissing(noval), 40);
        eleUtil.doClickLog(getInnerCoreCoverHandleMissing(noval),
                "Clicked on Inner core cover handle missing? field : ");

        eleUtil.waitForVisibilityOfElement(getConditionInInnerCore("Dry"), 40);
        eleUtil.doClickLog(getConditionInInnerCore("Dry"), "Clicked on Condition in inner core field : ");
    }

    public void selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi3(String complainceStatus, String checklistName) {
        selectEERegStatus();

        eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
        eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
                "Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

        eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
        eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
        eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Grease Separator",
                "Select Grease Separator in Type Of GT");

        eleUtil.waitForVisibilityOfElement(getWhoMaintainedTheGT("Not maintained"), 40);
        eleUtil.doClickLog(getWhoMaintainedTheGT("Not maintained"), "Clicked on Who maintains the GT? field : ");

    }

    public void selectChecklistForWRN4_GTNotMaintained_LegalNot(String complainceStatus, String checklistName) {
        selectEERegStatus();

        eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
        eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
                "Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

        eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
        eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
        eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Big GT", "Select Big GT in Type Of GT");

        eleUtil.waitForVisibilityOfElement(getGTCoverSecureToTheGround(noval), 40);
        eleUtil.doClickLog(getGTCoverSecureToTheGround(noval),
                "Clicked on GT cover secured to the ground? (Hence can't access GT internals) field : ");

        eleUtil.waitForVisibilityOfElement(getUnableToRemoveInnerCoreCover(noval), 40);
        eleUtil.doClickLog(getUnableToRemoveInnerCoreCover(noval),
                "Clicked on Unable to remove inner core cover? field : ");

        eleUtil.waitForVisibilityOfElement(getInnerCoreCoverHandleMissing(noval), 40);
        eleUtil.doClickLog(getInnerCoreCoverHandleMissing(noval),
                "Clicked on Inner core cover handle missing? field : ");

        eleUtil.waitForVisibilityOfElement(getConditionInInnerCore("Hardened grease"), 40);
        eleUtil.doClickLog(getConditionInInnerCore("Hardened grease"), "Clicked on Condition in inner core field : ");

    }

    public void selectChecklistForWRN4_GTDamaged_Combination1(String complainceStatus, String checklistName) {
        selectEERegStatus();

        eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
        eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
                "Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

        eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
        eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
        eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Big GT", "Select Big GT in Type Of GT");

        eleUtil.waitForVisibilityOfElement(getGTCoverSecureToTheGround(noval), 40);
        eleUtil.doClickLog(getGTCoverSecureToTheGround(noval),
                "Clicked on GT cover secured to the ground? (Hence can't access GT internals) field : ");

        eleUtil.waitForVisibilityOfElement(getGTObstrcuted(yesval), 40);
        eleUtil.doClickLog(getGTObstrcuted(yesval), "Clicked on GT access is obstructed? field : ");
    }

    public void selectChecklistForWRN4_GTDamaged_Combination2(String complainceStatus, String checklistName) {
        selectEERegStatus();

        eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
        eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
                "Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

        eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
        eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
        eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Big GT", "Select Big GT in Type Of GT");

        // eleUtil.waitForVisibilityOfElement(greaseImnterceptorObstructed?,
        // 40);//greaseInterceptorObstructed not available in checklist
        // eleUtil.doClickLog(greaseInterceptorObstructed, "Clicked on Grease
        // Interceptor (Portable) access is obstructed field : ");
    }

    public void selectChecklistForWRN4_GTDamaged_Combination3(String complainceStatus, String checklistName) {
        selectEERegStatus();

        eleUtil.waitForVisibilityOfElement(getDoesEEHaveAGT(yesval), 40);
        eleUtil.doClickLog(getDoesEEHaveAGT(yesval),
                "Clicked on Does EE have a GT / Grease Separator / Grease Interceptor (Portable)? field : ");

        eleUtil.waitForVisibilityOfElement(typeOfGT, 40);
        eleUtil.doClickLog(typeOfGT, "Clicked on Type Of GT");
        eleUtil.selectDropDownValue(typeOfGT, "selectByVisibleText", "Big GT", "Select Big GT in Type Of GT");

        // eleUtil.waitForVisibilityOfElement(greaseSeperatorObstructed?,
        // 40);//greaseImterceptorObstructed not available in checklist
        // eleUtil.doClickLog(greaseSeperatorObstructed, "Clicked on Grease Separator
        // access is obstructed? field : ");
    }

    public void fillCheckListQuestionsForWRN4(String complainceStatus, String checklistName)
            throws InterruptedException {
        commonActionsPage.WOnumber = crmActions.getWONumber();
        List<String> woNum = commonActionsPage.WOnumber;
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is:" + woNum.size());
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), "Grease Trap Inspection", "In Progress");
            sampleLabForAnalysisForWRN4();
            if ("GT Sampling".equals(checklistName)) {
                selectChecklistForWRN4_GTSampling(complainceStatus, checklistName);
            } else if ("GT Not Installed".equals(checklistName)) {
                selectChecklistForWRN4_GTNotInstalled(complainceStatus, checklistName);
            } else if ("GT Not Maintained Advisory Letter_Combination1".equals(checklistName)) {
                selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi1(complainceStatus, checklistName);
            } else if ("GT Not Maintained Advisory Letter_Combination2".equals(checklistName)) {
                selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi2(complainceStatus, checklistName);
            } else if ("GT Not Maintained Advisory Letter_Combination3".equals(checklistName)) {
                selectChecklistForWRN4_GTNotMaintained_Advisroy_Combi3(complainceStatus, checklistName);
            } else if ("GT Not Maintained Legal Notice".equals(checklistName)) {
                selectChecklistForWRN4_GTNotMaintained_LegalNot(complainceStatus, checklistName);
            } else if ("GT Damaged_Combination1".equals(checklistName)) {
                selectChecklistForWRN4_GTDamaged_Combination1(complainceStatus, checklistName);
            } else if ("GT Damaged_Combination2".equals(checklistName)) {
                selectChecklistForWRN4_GTDamaged_Combination2(complainceStatus, checklistName);
            } else if ("GT Damaged_Combination3".equals(checklistName)) {
                selectChecklistForWRN4_GTDamaged_Combination3(complainceStatus, checklistName);
            }
            crmActions.saveChecklist();
        }
    }

    public void selectChecklistForWRN1TEF() {
        eleUtil.waitTillElementIsDisplayed(factory.getToolboxConducted(), 30);
        eleUtil.selectDropDownValue(factory.getToolboxConducted(), "selectByVisibleText", "Yes",
                "Select Yes Toolbox Briefing Conducted");
        eleUtil.waitTillElementIsDisplayed(factory.selectWrittenApprovalNumber(), 30);
        eleUtil.selectDropDownValue(factory.selectWrittenApprovalNumber(), "selectByVisibleText", "Yes",
                "Select Yes Written Approval Number");
        eleUtil.waitTillElementIsDisplayed(housekeepingPremise, 30);
        eleUtil.selectDropDownValue(housekeepingPremise, "selectByVisibleText", "No",
                "Select No housekeeping of the premises");
        eleUtil.waitTillElementIsDisplayed(spillageOfChemicals, 30);
        eleUtil.selectDropDownValue(spillageOfChemicals, "selectByVisibleText", "No",
                "Select No spillages of chemicals / oil found in the premises");
        eleUtil.waitTillElementIsDisplayed(objToMeetTheVisitField, 20);
        eleUtil.doSendKeysLog(objToMeetTheVisitField, "Test",
                "Passes value to the Objectives to meet for the visit fiedl");
    }

    public void fillCheckListQuestionsForWRN1TEF() throws InterruptedException {
        commonActionsPage.WOnumber = crmActions.getWONumber();
        List<String> woNum = commonActionsPage.WOnumber;
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is:" + woNum.size());
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), "Trade Effluent Inspection", "In Progress");
            factory.sampleLabForAnalysis();
            selectChecklistForWRN1TEF();
            crmActions.saveChecklist();
        }
    }

    public void selectChecklistForWRN8NMB() {
        eleUtil.waitTillElementIsDisplayed(constructionActivitiyFound, 30);
        eleUtil.selectDropDownValue(constructionActivitiyFound, "selectByVisibleText", "Yes",
                "Select Yes Is there any construction activity found? field");

        eleUtil.waitTillElementIsDisplayed(repName, 30);
        eleUtil.doClickLog(repName, "Clicked on Contractor’s Rep Name field");
        eleUtil.doClearUsingKeysLog(repName, "Clear the Contractor’s Rep Name field");
        eleUtil.doSendKeysLog(repName, "Tester A", "Contractor’s Rep Name is :");

        eleUtil.waitTillElementIsDisplayed(repEmail, 30);
        eleUtil.doClickLog(repEmail, "Clicked on Contractor's Rep Email Address field");
        eleUtil.doClearUsingKeysLog(repEmail, "Clear the Contractor's Rep Email Address field");
        eleUtil.doSendKeysLog(repEmail, "testera@gmail.com", "Contractor's Rep Email Address is :");

        eleUtil.waitTillElementIsDisplayed(repTelNo, 30);
        eleUtil.doClickLog(repTelNo, "Clicked on Contractor's Rep Tel No field");
        eleUtil.doClearUsingKeysLog(repTelNo, "Clear the Contractor's Rep Tel No field");
        eleUtil.doSendKeysLog(repTelNo, "9090989897", "Contractor's Rep Tel No is :");

        eleUtil.waitTillElementIsDisplayed(qpName, 30);
        eleUtil.doClickLog(qpName, "Clicked on QP Rep Name field");
        eleUtil.doClearUsingKeysLog(qpName, "Clear the QP Rep Name field");
        eleUtil.doSendKeysLog(qpName, "Tester B", "QP Rep Name is :");

        eleUtil.waitTillElementIsDisplayed(qpEmail, 30);
        eleUtil.doClickLog(qpEmail, "Clicked on QP Rep Email Address field");
        eleUtil.doClearUsingKeysLog(qpEmail, "Clear the QP Rep Email Address field");
        eleUtil.doSendKeysLog(qpEmail, "testera@gmail.com", "QP Rep Email Address is :");

        eleUtil.waitTillElementIsDisplayed(qpTelNo, 30);
        eleUtil.doClickLog(qpTelNo, "Clicked on QP Rep Tel No field");
        eleUtil.doClearUsingKeysLog(qpTelNo, "Clear the QP Rep Tel No field");
        eleUtil.doSendKeysLog(qpTelNo, "t9876543210", "QP Rep Tel No is :");

        eleUtil.waitTillElementIsDisplayed(sewerId, 30);
        eleUtil.doClickLog(sewerId, "Clicked on Sewer ID field");
        eleUtil.doClearUsingKeysLog(sewerId, "Clear the Sewer ID field");
        eleUtil.doSendKeysLog(sewerId, "62464", "Sewer ID is :");

        eleUtil.waitTillElementIsDisplayed(sewerDiameter, 30);
        eleUtil.doClickLog(sewerDiameter, "Clicked on Sewer Diameter field");
        eleUtil.doClearUsingKeysLog(sewerDiameter, "Clear the Sewer Diameter field");
        eleUtil.doSendKeysLog(sewerDiameter, "1100", "Sewer Diameter is :");

        eleUtil.waitTillElementIsDisplayed(sewerOutsideHoarding, 30);
        eleUtil.selectDropDownValue(sewerOutsideHoarding, "selectByVisibleText", "Yes",
                "Select Yes Is there any construction activity found? field");

        eleUtil.waitTillElementIsDisplayed(typeOfActivity, 30);
        eleUtil.selectDropDownValue(typeOfActivity, "selectByVisibleText",
                "The excavation of earth, rock or other material by means of explosives",
                "Selected Type of Specified Activity Within Sewer Corridor field");

        eleUtil.waitTillElementIsDisplayed(depth, 30);
        eleUtil.doClickLog(depth, "Clicked on Depth of Specified Activity field");
        eleUtil.doClearUsingKeysLog(depth, "Clear the Depth of Specified Activity field");
        eleUtil.doSendKeysLog(depth, "Tester A", "Depth of Specified Activity is :");

        eleUtil.waitTillElementIsDisplayed(distance, 30);
        eleUtil.doClickLog(distance, "Clicked on Distance of specified activity from sewer field");
        eleUtil.doClearUsingKeysLog(distance, "Clear the Distance of specified activity from sewer field");
        eleUtil.doSendKeysLog(distance, "testera@gmail.com", "Distance of specified activity from sewer is :");

        eleUtil.waitTillElementIsDisplayed(statusOfActivity, 30);
        eleUtil.selectDropDownValue(statusOfActivity, "selectByVisibleText", "on-going",
                "Selected Status of specified activity field");

        eleUtil.waitTillElementIsDisplayed(activityCovered, 30);
        eleUtil.selectDropDownValue(activityCovered, "selectByVisibleText", "No",
                "Selected activity covered in POWS approval? field");

        eleUtil.waitTillElementIsDisplayed(attachReport, 30);
        eleUtil.doClickLog(attachReport, "Clicked on Attach report field");
        try {
            common.uploadFile(sendfileToReport, filePath + "\\src\\test\\resources\\testdata\\UploadForChecklist.xlsx");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void fillCheckListQuestionsForWRN8NMB() throws InterruptedException {
        commonActionsPage.WOnumber = crmActions.getWONumber();
        List<String> woNum = commonActionsPage.WOnumber;
        Thread.sleep(2000);
        Log.info("print wo number " + woNum);
        Log.info("size is:" + woNum.size());
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), "BCA Project Site Inspection affecting Public Sewerage System",
                    "In Progress");
            selectChecklistForWRN8NMB();
            crmActions.saveChecklist();
        }
    }

    public void fillTheChecklistQuestions(String outcome) throws InterruptedException {
        eleUtil.isPageLoaded(50);
        String yesval = "Yes";
        String noval = "No";
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//label[@aria-label='In Progress']"));
        System.out.println("checklist size is" + elements.size());
        for (int i = 2; i <= elements.size() + 1; i++) {
            try {
                eleUtil.waitForVisibilityOfElement(By.xpath("//label[@aria-label='In Progress']"), 20);
                WebElement refreshedElement = driver
                        .findElement(By.xpath("//div[@aria-rowindex='" + i + "']//div[@aria-colindex='5']"));
                String status = refreshedElement.getText();
                if (status.trim().equalsIgnoreCase("In Progress")) {
                    refreshedElement.click();
                    eleUtil.doDoubleClick(By.xpath("//div[@aria-rowindex='" + i + "']//div[@aria-colindex='5']"));
                    eleUtil.waitForVisibilityOfElement(servicetasksTab, 30);
                    eleUtil.doClick(servicetasksTab);
                    Thread.sleep(2000);

                    String actualname = eleUtil.doGetElementAttribute(checklistNameField, "aria-label");
                    assertTrue(actualname.contains("Tanker Permit Inspection"), "Checklist name is not matching");

                    eleUtil.doElementClickable(checklistNameField, 20);
                    eleUtil.doClick(checklistNameField);
                    eleUtil.doElementClickable(maximizescreenBtn, 10);
                    eleUtil.doClick(maximizescreenBtn);

                    if (outcome.equalsIgnoreCase("Compliance")) {
                        By chklistQ1 = By.xpath("//input[contains(@name,'Q1_sq_') and @value='" + yesval + "']");
                        By chklistQ2 = By.xpath("//input[contains(@name,'Q2_sq_') and @value='" + yesval + "']");
                        By chklistQ3 = By.xpath("//input[contains(@name,'Q3_sq_') and @value='" + yesval + "']");
                        By chklistQ4 = By.xpath("//input[contains(@name,'Q4_sq_') and @value='" + yesval + "']");
                        By chklistQ5 = By.xpath("//input[contains(@name,'Q5_sq_') and @value='" + yesval + "']");
                        By chklistQ6 = By.xpath("//input[contains(@name,'Q6_sq_') and @value='" + yesval + "']");
                        By chklistQ7 = By.xpath("//input[contains(@name,'Q7_sq_') and @value='" + yesval + "']");
                        By chklistQ8 = By.xpath("//input[contains(@name,'Q8_sq_') and @value='" + yesval + "']");
                        By chklistQ9 = By.xpath("//input[contains(@name,'Q9_sq_') and @value='" + yesval + "']");
                        By chklistQ10 = By.xpath("//input[contains(@name,'Q10_sq_') and @value='" + yesval + "']");
                        By chklistQ11 = By.xpath("//input[contains(@name,'Q11_sq_') and @value='" + yesval + "']");
                        By chklistQ12 = By.xpath("//input[contains(@name,'Q12_sq_') and @value='" + yesval + "']");
                        By chklistQ13 = By.xpath("//input[contains(@name,'Q13_sq_') and @value='" + yesval + "']");
                        By chklistQ14 = By.xpath("//input[contains(@name,'Q14_sq_') and @value='" + yesval + "']");
                        By chklistQ15 = By.xpath("//input[contains(@name,'Q15_sq_') and @value='" + yesval + "']");
                        By chklistQ16 = By.xpath("//input[contains(@name,'Q16_sq_') and @value='" + yesval + "']");
                        By chklistQ17 = By.xpath("//input[contains(@name,'Q17_sq_') and @value='" + yesval + "']");

                        eleUtil.waitForVisibilityOfElement(chklistQ1, 20);
                        eleUtil.doClick(chklistQ1);
                        eleUtil.doClick(chklistQ2);
                        eleUtil.doClick(chklistQ3);
                        eleUtil.doClick(chklistQ4);
                        eleUtil.doClick(chklistQ5);
                        eleUtil.doClick(chklistQ6);
                        eleUtil.doClick(chklistQ7);
                        eleUtil.doClick(chklistQ8);
                        eleUtil.doClick(chklistQ9);
                        eleUtil.doClick(chklistQ10);
                        eleUtil.doClick(chklistQ11);
                        eleUtil.doClick(chklistQ12);
                        eleUtil.doClick(chklistQ13);
                        eleUtil.doClick(chklistQ14);
                        eleUtil.doClick(chklistQ15);
                        eleUtil.doClick(chklistQ16);
                        eleUtil.doClick(chklistQ17);

                    } else {
                        By chklistQ1 = By.xpath("//input[contains(@name,'Q1_sq_') and @value='" + yesval + "']");
                        By chklistQ2 = By.xpath("//input[contains(@name,'Q2_sq_') and @value='" + yesval + "']");
                        By chklistQ3 = By.xpath("//input[contains(@name,'Q3_sq_') and @value='" + yesval + "']");
                        By chklistQ4 = By.xpath("//input[contains(@name,'Q4_sq_') and @value='" + yesval + "']");
                        By chklistQ5 = By.xpath("//input[contains(@name,'Q5_sq_') and @value='" + yesval + "']");
                        By chklistQ6 = By.xpath("//input[contains(@name,'Q6_sq_') and @value='" + yesval + "']");
                        By chklistQ7 = By.xpath("//input[contains(@name,'Q7_sq_') and @value='" + yesval + "']");
                        By chklistQ8 = By.xpath("//input[contains(@name,'Q8_sq_') and @value='" + noval + "']");
                        By chklistQ9 = By.xpath("//input[contains(@name,'Q9_sq_') and @value='" + yesval + "']");
                        By chklistQ10 = By.xpath("//input[contains(@name,'Q10_sq_') and @value='" + yesval + "']");
                        By chklistQ11 = By.xpath("//input[contains(@name,'Q11_sq_') and @value='" + yesval + "']");
                        By chklistQ12 = By.xpath("//input[contains(@name,'Q12_sq_') and @value='" + noval + "']");
                        By chklistQ13 = By.xpath("//input[contains(@name,'Q13_sq_') and @value='" + yesval + "']");
                        By chklistQ14 = By.xpath("//input[contains(@name,'Q14_sq_') and @value='" + yesval + "']");
                        By chklistQ15 = By.xpath("//input[contains(@name,'Q15_sq_') and @value='" + yesval + "']");
                        By chklistQ16 = By.xpath("//input[contains(@name,'Q16_sq_') and @value='" + yesval + "']");
                        By chklistQ17 = By.xpath("//input[contains(@name,'Q17_sq_') and @value='" + yesval + "']");

                        eleUtil.waitForVisibilityOfElement(chklistQ1, 20);
                        eleUtil.doClick(chklistQ1);
                        eleUtil.doClick(chklistQ2);
                        eleUtil.doClick(chklistQ3);
                        eleUtil.doClick(chklistQ4);
                        eleUtil.doClick(chklistQ5);
                        eleUtil.doClick(chklistQ6);
                        eleUtil.doClick(chklistQ7);
                        eleUtil.doClick(chklistQ8);
                        eleUtil.doClick(chklistQ9);
                        eleUtil.doClick(chklistQ10);
                        eleUtil.doClick(chklistQ11);
                        eleUtil.doClick(chklistQ12);
                        eleUtil.doClick(chklistQ13);
                        eleUtil.doClick(chklistQ14);
                        eleUtil.doClick(chklistQ15);
                        eleUtil.doClick(chklistQ16);
                        eleUtil.doClick(chklistQ17);

                    }

                    int number = ThreadLocalRandom.current().nextInt();
                    System.out.println("random  number before absolute:" + number);
                    int randomNumber = Math.abs(number);
                    String strform = String.valueOf(randomNumber);
                    System.out.println("random number is:" + strform);
                    jsutil.scrollIntoView(driver.findElement(newSealnumField));
                    eleUtil.doSendKeys(newSealnumField, strform);
                    By acknowledmentOption = By
                            .xpath("//input[contains(@name,'Question2_sq_') and @value='" + yesval + "']");
                    eleUtil.doClick(acknowledmentOption);
                    eleUtil.doClick(saveBtnInChklsit);
                    System.out.println("clicked on save button");
                    Thread.sleep(3000);
                    eleUtil.doElementClickable(markcompleteBtn, 40);
                    try {
                        eleUtil.doClick(markcompleteBtn);
                    } catch (Exception e) {
                        eleUtil.doActionsClick(markcompleteBtn);
                    }
                    Thread.sleep(2000);
                    eleUtil.doClick(saveNCloseBtnInChklsit);

                    boolean tankerRegNoDisplayed = false;
                    long startTime = System.currentTimeMillis();
                    while (!tankerRegNoDisplayed && (System.currentTimeMillis() - startTime) < 180000) {
                        try {
                            clickOnRefreshBtnOnHome();
                            eleUtil.waitForVisibilityOfElement(tankerregno, AppConstants.SHORT_DEFAULT_WAIT);
                            // If tankerregno is displayed, set the flag to true to exit the loop
                            if (driver.findElement(tankerregno).isDisplayed()) {
                                tankerRegNoDisplayed = true;
                            }
                        } catch (StaleElementReferenceException e) {
                            System.out.println("catching the exception");
                        } catch (Exception e) {
                            System.out.println("Button is not present");
                        }
                    }
                    eleUtil.isPageLoaded(30);
                    clickOnSaveNCloseBtn();

                }

            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException occurred: " + e.getMessage()); // elements =
            }

            eleUtil.isPageLoaded(30);
        }

    }

    public void amendChecklist() {
        eleUtil.isPageLoaded(30);
        eleUtil.waitForVisibilityOfElement(servicetasksTab, 30);
        eleUtil.doElementClickable(servicetasksTab, 40);
        eleUtil.doClick(servicetasksTab);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        eleUtil.doElementClickable(checklistNameField, 20);
        eleUtil.doClick(checklistNameField);
        eleUtil.doElementClickable(maximizescreenBtn, 10);
        eleUtil.doClick(maximizescreenBtn);

        // String xpathForNoRadioButtons =
        // "//div[contains(@id,'sq_')]//label[@class='sv_q_radiogroup_label
        // ms-RadioButton-field is-checked']/input[@Value='No']";

        // Find all radio buttons selected as "No"
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<WebElement> noRadioButtons = driver.findElements(By.xpath(
                "//div[contains(@name,'Q')]//label[@class='sv_q_radiogroup_label ms-RadioButton-field is-checked']/input[@Value='No']"));
        System.out.println("size is" + noRadioButtons.size());
        // Iterate through each radio button selected as "No"
        for (int i = 0; i < noRadioButtons.size(); i++) {
            System.out.println("entered for loop");
            WebElement yesRadioButton = driver.findElement(By.xpath(
                    "//div[contains(@name,'Q')]//label[@class='sv_q_radiogroup_label ms-RadioButton-field']/input[@Value='Yes']"));

            if (noRadioButtons.get(i).isSelected() && noRadioButtons.get(i).getAttribute("Value").equals("No"))
                System.out.println("entered if loop");
            yesRadioButton.click();
        }

        eleUtil.doClick(saveBtnInChklsit);
        System.out.println("clicked on save button");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eleUtil.doElementClickable(markcompleteBtn, 40);
        try {
            eleUtil.doClick(markcompleteBtn);
        } catch (Exception e) {
            eleUtil.doActionsClick(markcompleteBtn);
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eleUtil.doClick(saveNCloseBtnInChklsit);
        clickOnSaveNCloseBtn();

    }

    public void checkListForWRN10IMBDLP(String status, String checkListName, String checkListType, String completeStatus)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            if (checkListName.equals("WRN 10 IMB Pumping Main Handing Over Inspection Checklist - Pressure Test")) {
                WRN10IMBPressureTestChecklist(checkListType);
            } else if (checkListName.equals("WRN 10 IMB Pumping Main Handing Over Inspection Checklist - Pre DLP")) {
                WRN10IMBCommissioningTestPreDLPChecklist(checkListType);
            } else {
                WRN10IMBCommissioningTestPostDLPChecklist(checkListType);
            }
            crmActions.saveAndMarkCompleteChecklist();
            crmActions.checkWOSystemAndUserDetails(completeStatus, checkListType);
            clickOnSaveNCloseBtn();
        }
    }

    public void WRN10IMBPressureTestChecklist(String checklistType) {
        if ("In Order".equals(checklistType)) {
            eleUtil.waitForVisibilityOfElement(pumpingInstallation, 30);
            eleUtil.doSendKeysLog(pumpingInstallation, "PumpingValue", "Enter Pumping Installation");
            eleUtil.selectDropDownValue(complianceMethodStatement, "selectByVisibleText", "Yes", "select Compliance to Method Statement");
            eleUtil.selectDropDownValue(passPressureCOP, "selectByVisibleText", "Yes", "select Pass Pressure Test according to COP");
            eleUtil.doSendKeysLog(pumpingMain, "PumpingMail", "Enter Pumping Main");
            eleUtil.doSendKeysLog(defect, "No", "Enter Defect");
        } else {
            // Write Compliance code
        }
    }

    public void WRN10IMBCommissioningTestPreDLPChecklist(String checklistType) {
        if ("Not In Order".equals(checklistType)) {
            eleUtil.waitForVisibilityOfElement(pumpingInstallation, 30);
            eleUtil.doSendKeysLog(pumpingInstallation, "PumpingValue", "Enter Pumping Installation");
            eleUtil.doSendKeysLog(pumpingMain, "PumpingMail", "Enter Pumping Main");
            eleUtil.doSendKeysLog(defect, "No", "Enter Defect");
            // Combine all relevant questions into one loop
            for (int i = 1; i <= 23; i++) {
                if (i != 21 && i != 22) {
                    By wrn10DropDown = By.xpath("//div[@name='Question" + i + "']//select");
                    eleUtil.selectDropDownValue(wrn10DropDown, "selectByVisibleText", "Yes", "select Yes");
                }
            }
        } else {
            eleUtil.waitForVisibilityOfElement(pumpingInstallation, 30);
            eleUtil.doSendKeysLog(pumpingInstallation, "PumpingValue", "Enter Pumping Installation");
            eleUtil.doSendKeysLog(pumpingMain, "PumpingMail", "Enter Pumping Main");
            eleUtil.doSendKeysLog(defect, "No", "Enter Defect");
            // Combine all relevant questions into one loop
            for (int i = 1; i <= 23; i++) {
                By wrn10DropDown = By.xpath("//div[@name='Question" + i + "']//select");
                if (i == 19 || i == 20) {
                    eleUtil.selectDropDownValue(wrn10DropDown, "selectByVisibleText", "No", "select No");
                } else if (i != 21 && i != 22) {
                    eleUtil.selectDropDownValue(wrn10DropDown, "selectByVisibleText", "Yes", "select Yes");
                }
            }
            eleUtil.doSendKeysLog(remarksForSewerageSmell, "Remarks for Any sewerage smell",
                    "Enter Remark for Any sewerage smell");
            eleUtil.doSendKeysLog(remarksForLeak, "Remarks for Any leak observed",
                    "Enter Remark for Any leak observed");
        }
    }

    public void WRN10IMBCommissioningTestPostDLPChecklist(String checklistType) {
        if ("Not In Order".equals(checklistType)) {
            eleUtil.waitForVisibilityOfElement(location, 30);
            eleUtil.doSendKeysLog(location, "Location India", "Enter Location");
            eleUtil.doSendKeysLog(defect, "No", "Enter Defect");
            // Combine all relevant questions into one loop
            for (int i = 1; i <= 9; i++) {
                By wrn10DropDown = By.xpath("//div[@name='Question" + i + "']//select");
                eleUtil.selectDropDownValue(wrn10DropDown, "selectByVisibleText", "Yes", "select Yes");
            }
        } else {
            // Write Compliance code
        }
    }

    public void checkListForWRN10IMBAbandonment(String status, String checkListName, String checkListType, String completeStatus)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            WRN10IMBAbandonmentChecklist(checkListType);
            crmActions.saveAndMarkCompleteChecklist();
            crmActions.checkWOSystemAndUserDetails(completeStatus, checkListType);
            clickOnSaveNCloseBtn();
        }
    }

    public void WRN10IMBAbandonmentChecklist(String checklistType) {
        eleUtil.waitForVisibilityOfElement(abandonedManhole, 30);
        if ("In Order".equals(checklistType)) {
            for (int i = 1; i <= 13; i += 2) {
                By wrn10DropDown = By.xpath("//div[@name='Question" + i + "']//select");
                eleUtil.selectDropDownValue(wrn10DropDown, "selectByVisibleText", "Yes", "select Yes");
            }
        } else {
            // Write Non- Compliance code
        }
    }

    public void checkListForEventPermitCWD5(String status, String checkListName, String checkListType, String completeStatus)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        Thread.sleep(2000);
        crmActions.workOrderIncidentTypeFilter(checkListName);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            cwd5EventPermitChecklist(checkListName, checkListType);
            crmActions.saveAndMarkCompleteChecklist();
            crmActions.checkWOSystemAndUserDetails(completeStatus, checkListType);
            if("Non-Compliance".equals(checkListType)) {
                offenceDetails();
            }
            clickOnSaveNCloseBtn();
        }
    }

    public void offenceDetails() throws InterruptedException {
        eleUtil.waitTillElementIsDisplayed(administrationOutcome, 30);
        eleUtil.selectDropDownValue(administrationOutcome, "selectByVisibleText", "Warning",
                "Select Warning in an Administration Outcome");
        eleUtil.waitForVisibilityOfElement(mainCategory, 30);
        eleUtil.doClearUsingKeysWithWait(mainCategory, 30);
        eleUtil.doSendKeysWithWaitEnter(mainCategory, "Enforcement", 30);
        eleUtil.doClickLog(factory.setLookUp(), "Select Look-up value");
    }

    public void cwd5EventPermitChecklist(String checkListName, String checklistType) {
        if ("Pre-Event Inspection".equals(checkListName)) {
            eleUtil.waitForVisibilityOfElement(preEventInspection, 30);
            eleUtil.doClickLog(preEventInspection, "Select Yes for Pre-Event Inspection Checklist Questions");
            handleCompliance(checklistType, setupComplyCompliance, setupComplyNonCompliance);
        } else if ("During Event Inspection".equals(checkListName)) {
            eleUtil.waitForVisibilityOfElement(duringEventInspection, 30);
            eleUtil.doClickLog(duringEventInspection, "Select Yes for During Event Inspection Checklist Questions");
            handleCompliance(checklistType, eventOrgComplyCompliance, eventOrgComplyNonCompliance);
        } else if ("Post-Event Inspection".equals(checkListName)) {
            eleUtil.waitForVisibilityOfElement(postEventInspection, 30);
            eleUtil.doClickLog(postEventInspection, "Select Yes for Post-Event Inspection Checklist Questions");
            handleCompliance(checklistType, allEventSetupCompliance, allEventSetupNonCompliance);
        } else if ("CWD 5 Re-Inspection".equals(checkListName)) {
            eleUtil.waitForVisibilityOfElement(allEventSetupCompliance, 30);
            eleUtil.doClickLog(allEventSetupCompliance, "Select Yes for All identified issues has been rectified?");
        }
    }

    private void handleCompliance(String checklistType, By complianceElement, By nonComplianceElement) {
        if ("Compliance".equals(checklistType)) {
            eleUtil.doClickLog(complianceElement, "Select Yes");
        } else {
            eleUtil.doClickLog(nonComplianceElement, "Select No");
        }
    }

    public void checkListForEventPermitCWD5Rework(String status, String checkListName, String checkListType, String completeStatus)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        Thread.sleep(2000);
        crmActions.workOrderIncidentTypeFilter(checkListName);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            eleUtil.waitForVisibilityOfElement(allEventSetupCompliance, 30);
            eleUtil.doClickLog(allEventSetupCompliance, "Select Yes for Post-Event Inspection Checklist Questions");
            crmActions.saveAndMarkCompleteChecklist();
            crmActions.checkWOSystemAndUserDetails(completeStatus, checkListType);
            clickOnSaveNCloseBtn();
        }
    }

    public void checkListForVesselInspectionCWD5(String status, String checkListName, String checkListType, String completeStatus)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        Thread.sleep(2000);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            cwd5VesselInspectionChecklist(checkListType);
            crmActions.saveAndMarkCompleteChecklist();;
            crmActions.checkWOSystemAndUserDetails(completeStatus, checkListType);
            if("Non-Compliance".equals(checkListType)) {
                offenceDetails();
            }
            clickOnSaveNCloseBtn();
        }
    }

    public void cwd5VesselInspectionChecklist(String checkListType) {
        eleUtil.waitForVisibilityOfElement(dateAndTime, 30);
        eleUtil.doClickLog(dateAndTime, "Select Data and Time Calendar");
        eleUtil.waitForVisibilityOfElement(crmActions.getSelectTodayDateAndTime(), 30);
        eleUtil.doClickLog(crmActions.getSelectTodayDateAndTime(), "Select today's date");
        eleUtil.waitForVisibilityOfElement(reservoir, 30);
        eleUtil.doSendKeysLog(reservoir, "Reservoir", "Enter reservoir value");
        eleUtil.doSendKeysLog(vesselId, "Vessel ID for Compliance", "Enter Compliance value");
        eleUtil.selectDropDownValue(vesselType, "selectByVisibleText", "CA - CANOE / KAYAK", "Select CA - CANOE / KAYAK");
        eleUtil.selectDropDownValue(activityType, "selectByVisibleText", "VP - Vessel permit", "Select VP - Vessel permit");
        if ("Compliance".equals(checkListType)) {
            eleUtil.selectDropDownValue(compliance, "selectByVisibleText", "Yes", "Select Yes");
        } else {
            eleUtil.selectDropDownValue(compliance, "selectByVisibleText", "No", "Select No");
        }
        eleUtil.doSendKeysLog(cases.getCaseRemarksField(), checkListType + " Remarks", "Enter Remarks");
    }

    public void checkListForSurveillanceChecklistCWD1(String status, String checkListName, String checkListType, String completeStatus)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        Thread.sleep(2000);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            cwd1SurveillanceChecklist(checkListType);
            crmActions.saveAndMarkCompleteChecklist();
            navigateToTab("Summary");
            crmActions.checkWOStatus(completeStatus);
            //For CRMS Case Manually need to select the Compliance Information
            if (checkListType.equals("Rework")) {
                checkListType="Compliance";
            }
            crmsCasePage.selectComplianceInformationOnWO(checkListType);
            clickOnSaveBtn();
            clickOnSaveNCloseBtn();
        }
    }

    public void cwd1SurveillanceChecklist(String checkListType) throws InterruptedException {
        String path = filePath + pngFilePath;
        Log.info("final path to upload " + path);
        eleUtil.waitForVisibilityOfElement(illegalActivityObserved, 30);
        if ("Compliance".equals(checkListType)) {
            eleUtil.selectDropDownValue(illegalActivityObserved, "selectByVisibleText", "Illegal feeding", "Select Illegal feeding");
            uploadFile(uploadPhoto, path);
        } else if ("Non-Compliance".equals(checkListType)){
            eleUtil.selectDropDownValue(illegalActivityObserved, "selectByVisibleText", "Use of live bait", "Select Use of live bait");
            uploadFile(uploadPhoto, path);
        } else {
            eleUtil.selectDropDownValue(illegalActivityObserved, "selectByVisibleText", "Illegal feeding", "Select Illegal feeding");
        }
    }

    public void checkListForECMSetupNDrainageWorkChecklistCWD2(String status, String checkListName, String checkListType, String completeStatus)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        Thread.sleep(2000);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            cwd2ECMSetupNDrainageWorkChecklist(checkListType);
            Thread.sleep(2000);
            crmActions.saveAndMarkCompleteChecklist();
            crmActions.checkWOSystemAndUserDetails(completeStatus, checkListType);
            clickOnSaveNCloseBtn();
        }
    }

    public void cwd2ECMSetupNDrainageWorkChecklist(String checkListType) throws InterruptedException {
        String path = filePath + pngFilePath;
        Log.info("final path to upload " + path);
        eleUtil.waitForVisibilityOfElement(statusConstructionWorkQ1, 30);
        if ("Compliance".equals(checkListType)) {
            eleUtil.selectDropDownValue(statusConstructionWorkQ1, "selectByVisibleText", "Completed", "Select Completed");
            uploadFile(photo1, path);
        } else {
            eleUtil.selectDropDownValue(statusConstructionWorkQ1, "selectByVisibleText", "Ongoing", "Select Ongoing");
            eleUtil.selectDropDownValue(earthworkAtSiteQ3, "selectByVisibleText", "Main Contractor", "Select Main Contractor");
            eleUtil.doSendKeysLog(contractorSitePersonnelDetailsQ4, "Personal Details", "Enter Contractor site personnel details");
            int[] dropDownQuestions = {6, 10, 15, 16, 17, 18, 19, 20, 21, 23};
            for (int question : dropDownQuestions) {
                By cwd2DropDown = By.xpath("//select[contains(@aria-label,'" + question + "')]");
                eleUtil.waitForVisibilityOfElement(cwd2DropDown, 30);
                eleUtil.selectDropDownValue(cwd2DropDown, "selectByVisibleText", "No", "select No");
            }
            eleUtil.doSendKeysLog(remark1, "Remarks for Has CCTV installed", "Enter Remark Has CCTV installed (site >0.2 Ha) at designated discharge point(s) and linked to SIDS?");
            eleUtil.doSendKeysLog(zone, "zone", "Enter value in Zone");
            int[] textBoxQuestions = {11, 12, 13, 14};
            for (int question : textBoxQuestions) {
                By photoInput = By.xpath("//input[contains(@aria-label,'" + question + "')]");
                eleUtil.doSendKeysLog(photoInput, "122312", "Enter value in Number fields");
            }
            eleUtil.doSendKeysLog(remarksQ22, "Remarks for Question 22", "Enter Remark in Question 22");
            uploadFile(overviewPhotoConstructionSiteQ5, path);
            int[] uploadAttachmentQuestions = {39, 44, 46, 47, 71, 72};
            for (int question : uploadAttachmentQuestions) {
                By photoInput = By.xpath("//div[@name='Question" + question + "']//input[@aria-label='Photos']");
                uploadFile(photoInput, path);
            }
            int[] additionalUploadQuestions = {12, 14, 15, 16};
            for (int question : additionalUploadQuestions) {
                By photoInput = By.xpath("//input[@aria-label='Question " + question + " photos']");
                uploadFile(photoInput, path);
            }
        }
    }

    public void checkListForRawWaterMainPipelineChecklistCWD4(String status, String checkListName, String checkListType, String completeStatus)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        Thread.sleep(2000);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            cwd4RawWaterMainPipelineChecklist(checkListType);
            Thread.sleep(2000);
            crmActions.saveAndMarkCompleteChecklist();
            //For CRMS Case Manually need to select the Compliance Information
            if (checkListType.equals("ReInspection")) {
                checkListType="Non-Compliance";
            }
            crmActions.checkWOSystemAndUserDetails(completeStatus, checkListType);
            clickOnSaveNCloseBtn();
        }
    }

    public void cwd4RawWaterMainPipelineChecklist(String checkListType) throws InterruptedException {
        String path = filePath + pngFilePath;
        Log.info("final path to upload " + path);
        eleUtil.waitForVisibilityOfElement(contractorName, 30);
        if ("Compliance".equals(checkListType)) {
        } else if (("Non-Compliance".equals(checkListType))){
            eleUtil.waitForVisibilityOfElement(inspectionType, 30);
            eleUtil.doClickLog(inspectionType, "Select Manual");
            eleUtil.doSendKeysLog(contractorName, "CWD4 Contractor" ,"Enter Contractor Name");
            eleUtil.doSendKeysLog(size, "100" ,"Enter Size");
            eleUtil.doClickLog(approvedWorksPOWSNonCompliance, "Select No");
            eleUtil.doSendKeysLog(remarksQ3, "Remarks for Question 3A", "Enter Remark in Question 3A");
            eleUtil.doClickLog(anySignsOfLeaks, "Select No");
            eleUtil.doClickLog(rectificationNotRequired, "Select No");
            int[] dropDownQuestions = {3, 4, 5, 9, 10, 11, 12, 13, 14, 15, 17, 31, 19, 6, 7, 8, 24, 25, 26, 27, 16, 28, 29};
            for (int question : dropDownQuestions) {
                By selectRadioButton = By.xpath("//input[contains(@name,'Question" + question + "_')] [@aria-label='Yes']");
                eleUtil.waitForVisibilityOfElement(selectRadioButton, 30);
                eleUtil.doClickLog(selectRadioButton, "Select Yes");
            }
            eleUtil.doSendKeysLog(remark, "Enter Remarks for CWD4", "Enter Remark");
            uploadFile(photo1, path);
            eleUtil.doClickLog(rawWatermainsQ15, "Select Prime");
        } else {
            eleUtil.waitForVisibilityOfElement(inspectionType, 30);
            eleUtil.doClickLog(inspectionType, "Select Manual");
            eleUtil.doSendKeysLog(contractorName, "CWD4 Contractor" ,"Enter Contractor Name");
            eleUtil.doSendKeysLog(size, "100" ,"Enter Size");
            eleUtil.doClickLog(approvedWorksPOWSNonCompliance, "Select No");
            eleUtil.doSendKeysLog(remarksQ3, "Remarks for Question 3A", "Enter Remark in Question 3A");
            eleUtil.doClickLog(anySignsOfLeaks, "Select No");
            eleUtil.doClickLog(rectificationRequired, "Select Yes");
            int[] dropDownQuestions = {3, 4, 5, 9, 10, 11, 12, 13, 14, 15, 17, 31, 19, 6, 7, 8, 24, 25, 26, 27, 16, 28, 29};
            for (int question : dropDownQuestions) {
                By selectRadioButton = By.xpath("//input[contains(@name,'Question" + question + "_')] [@aria-label='Yes']");
                eleUtil.waitForVisibilityOfElement(selectRadioButton, 30);
                eleUtil.doClickLog(selectRadioButton, "Select Yes");
            }
            eleUtil.doSendKeysLog(remark, "Enter Remarks for CWD4", "Enter Remark");
            uploadFile(photo1, path);
            eleUtil.doClickLog(rawWatermainsQ15, "Select Prime");
        }
    }

    public void checkListForDischargeIntoWaterwaysChecklistCWD3N6(String status, String checkListName, String checkListType, String completeStatus)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        Thread.sleep(2000);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            cwd3N6DischargeIntoWaterways(checkListType);
            Thread.sleep(2000);
            crmActions.saveAndMarkCompleteChecklist();
            crmActions.checkWOSystemAndUserDetails(completeStatus, checkListType);
            clickOnSaveNCloseBtn();
        }
    }

    public void sampleLabForAnalysisForCWD3N6(String date) throws InterruptedException {
        eleUtil.waitTillElementIsDisplayed(factory.clickOnNewSampleLab(), 30);
        eleUtil.doClickLog(factory.clickOnNewSampleLab(), "Click on New Sample For Lab Analysis button");
        eleUtil.waitTillElementIsDisplayed(factory.selectDateAndTime(), 30);
        eleUtil.doSendKeysWithWaitEnter(factory.selectDateAndTime(), date, 100);
        eleUtil.doClearUsingKeysWithWait(factory.clickOnParametersAnalysed(), 30);
        eleUtil.doSendKeysWithWaitEnter(factory.clickOnParametersAnalysed(), "Oil & Grease (Hydrocarbon)", 30);
        eleUtil.doClickLog(factory.clickOnLab(), "Enter 1st value as PUB Laboratory 1");
        eleUtil.doClearUsingKeysWithWait(factory.clickOnLab(), 30);
        eleUtil.doSendKeysWithWaitEnter(factory.clickOnLab(), "PUB Laboratory 1", 30);
        eleUtil.selectDropDownValue(temperature, "selectByVisibleText", "Fridge", "Select Fridge");
        eleUtil.waitTillElementIsDisplayed(factory.getSaveAndClose(), 30);
        eleUtil.doClickLog(factory.getSaveAndClose(), "Click on Save and Close button");
    }

    public void cwd3N6DischargeIntoWaterways(String checkListType) throws InterruptedException {
        String path = filePath + pngFilePath;
        Log.info("final path to upload " + path);
        eleUtil.waitForVisibilityOfElement(incidentLocation, 30);
        sampleLabForAnalysisForCWD3N6(todayDate);
        if ("Compliance".equals(checkListType)) {
        }  else {
            eleUtil.doSendKeysLog(incidentLocation, "Enter Incident Location for CWD3&6", "Enter Incident Location");
            eleUtil.selectDropDownValue(anyAbnormalityObserved, "selectByVisibleText", "Yes", "Select Yes");
            eleUtil.doSendKeysLog(remark1, "Enter Remarks for CWD3&6", "Enter Remarks");
            uploadFile(photo1, path);
            eleUtil.doClickLog(sampleTaken, "Select Yes");
            eleUtil.doSendKeysLog(pubWONumber, "Enter PUB WO Number", "Enter PUB WO Number");
            eleUtil.doSendKeysLog(programmeName, "Enter Programme Name", "Enter Programme");
            eleUtil.selectDropDownValue(sourceDischargeIdentified, "selectByVisibleText", "No", "Select No");
            eleUtil.selectDropDownValue(inspectionCompleted, "selectByVisibleText", "Yes", "Select Yes");
        }
    }

    public void checklistForPremisesInspectionChecklistCWD3N6(String status, String checkListName, String checkListType, String completeStatus)
            throws InterruptedException {
        crmActions.workOrderStatusFilter(status);
        Thread.sleep(2000);
        List<String> woNum = new ArrayList<>();
        crmActions.fetchWorkOrderNumbers(woNum);
        for (int i = 0; i < woNum.size(); i++) {
            Thread.sleep(2000);
            crmActions.openCheckList(woNum.get(i), checkListName, status);
            cwd3N6PremisesInspection(checkListType);
            Thread.sleep(2000);
            markCompleteChecklistForCWD3N6();
            crmActions.checkWOSystemAndUserDetails(completeStatus, checkListType);
            clickOnSaveNCloseBtn();
        }
    }

    public void cwd3N6PremisesInspection(String checkListType) throws InterruptedException {
        String path = filePath + pngFilePath;
        Log.info("final path to upload " + path);
        eleUtil.waitForVisibilityOfElement(premiseSubType, 30);
        sampleLabForAnalysisForCWD3N6(eleUtil.todayDatePlusDays("dd/MMM/yyyy", 0));
        if ("Compliance".equals(checkListType)) {
        } else {
            eleUtil.waitForVisibilityOfElement(premiseSubType, 30);
            eleUtil.doSendKeysLog(premiseSubType, "Animal Holdings", "Enter Premise SubType");
            eleUtil.waitForVisibilityOfElement(sampleTakenForPremisesInspection, 30);
            eleUtil.doClickLog(sampleTakenForPremisesInspection, "Select Yes");
            eleUtil.doSendKeysLog(pubWONumber, "Enter PUB WO Number", "Enter PUB WO Number");
            eleUtil.doSendKeysLog(programmeName, "Enter Programme Name", "Enter Programme");
            saveNContinueAndNextButton();
            eleUtil.waitForVisibilityOfElement(generalHousekeepingPremises, 30);
            eleUtil.doClickLog(generalHousekeepingPremises, "Select No");
            uploadFile(photo1, path);
            eleUtil.doSendKeysLog(remarksQ1, "Enter Remarks for CWD3&6", "Enter Remarks");
            int[][] dropDownQuestions = {
                    {32, 31, 29, 28, 27, 34},
                    {14, 15, 20, 19, 18, 17, 21},
                    {64, 66, 65, 67},
                    {76, 84, 83, 82, 81, 80,  144, 145},
                    {94, 95, 96, 97},
                    {7, 11}
            };
            for (int i = 0; i < dropDownQuestions.length; i++) {
                processQuestions(dropDownQuestions[i]);
                if (i < dropDownQuestions.length - 1) {
                    saveNContinueAndNextButton();
                } else {
                    // Save the checklist without clicking "Next" for the last set of questions
                    eleUtil.doClickLog(getSaveBtnInChklist(), "click on Save Checklist button");
                    clickSaveNContinueBtn();
                    waitForChecklistPageToSaved();
                }
            }
        }
    }

    private void processQuestions(int[] questions) throws InterruptedException {
        for (int question : questions) {
            By selectRadioButton = By.xpath("//input[contains(@name,'Question" + question + "_')] [@aria-label='Yes']");
            eleUtil.waitForVisibilityOfElement(selectRadioButton, 30);
            eleUtil.doClickLog(selectRadioButton, "Select Yes");
        }
    }

    private void saveNContinueAndNextButton() throws InterruptedException {
        eleUtil.doClickLog(getSaveBtnInChklist(), "click on Save Checklist button");
        clickSaveNContinueBtn();
        waitForChecklistPageToSaved();
        eleUtil.doClickLog(nextButton, "Click on Next button");
    }

    public void markCompleteChecklistForCWD3N6() throws InterruptedException {
        eleUtil.doElementClickable(getMarkCompleteBtn(), 50);
        attemptsDifferentClicks(getMarkCompleteBtn());
        if (eleUtil.elementIsDisplayed(getDiscardChangesBtn(), "Discard Changes button is displayed")) {
            clickDiscardChanges();
            eleUtil.waitForInVisibilityOfElement(getDiscardChangesBtn(), 30);
            Thread.sleep(3000);
        }
        eleUtil.waitForVisibilityOfElement(getChecklistRefreshButton(), 30);
        eleUtil.doClickLog(getChecklistRefreshButton(), "Click on Checklist Refresh button");
        if (eleUtil.elementIsDisplayed(getMarkCompleteBtn(), "Mark Complete button is displayed")) {
            attemptsDifferentClicks(getMarkCompleteBtn());
            clickSaveNContinueBtn();
            Thread.sleep(3000);
        }
        eleUtil.staleElementRefExecClickCRM(getSaveNCloseBtnInChklist());
        Thread.sleep(2000);
        eleUtil.doClickWithWait(getSaveNCloseBtnInChklist(), 150);
    }
}
