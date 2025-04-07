package com.sat.Pages;

import com.sat.locators.casePage;
import com.sat.locators.crmsCasePage;
import com.sat.locators.factoryPage;
import org.openqa.selenium.WebDriver;
import org.openxml4j.opc.PackagingURIHelper;
import org.openxml4j.opc.internal.unmarshallers.PackagePropertiesUnmarshaller;

import java.io.IOException;

public class crmsCaseCreationPage extends commonActionsPage {

    crmsCasePage crmsCasePage = new crmsCasePage(driver);
    casePage cases = new casePage(driver);
    factoryPage factory = new factoryPage(driver);

    public crmsCaseCreationPage(WebDriver driver) {
        super(driver);
    }

    public void createCRMSCaseCWD1() throws IOException {
        crmsCasePage.updateExcelCRMSCaseCWD1();
    }

    public void importIMBExcelForCWD1() throws InterruptedException {
        crmsCasePage.importCWD1ExcelData();
    }

    public void verifyCRMSCaseCreated() throws InterruptedException {
        crmsCasePage.checkCRMSCaseCreated();
    }

    public void searchAndOpenCRMSCase(String listView) throws InterruptedException {
        cases.selectCasesListView(listView);
        crmsCasePage.searchCRMSCase();
    }

    public void selectAcceptOrRejectCRMSCase(String crmsCaseAction) throws InterruptedException {
        crmsCasePage.acceptOrRejectCRMSCase(crmsCaseAction);
    }

    public void checkCRMDetails(String crmsCaseStatus) throws InterruptedException {
        crmsCasePage.verifyCRMDetails(crmsCaseStatus);
    }

    public void verifyCRMSCaseWarningMessage(String warningMessage) throws InterruptedException {
        crmsCasePage.crmsCaseWarningMessage(warningMessage);
    }

    public void updateEntityValue() throws InterruptedException {
        crmsCasePage.deleteAndEnterValueInEntity();
    }

    public void enterLandmarkValue() throws InterruptedException {
        crmsCasePage.selectLandmark();
    }

    public void enterSecondaryFioValue(String secondaryFioUser) throws InterruptedException {
        crmsCasePage.selectSecondaryFio(secondaryFioUser);
    }

    public void completeCRMSClosureDetails() throws InterruptedException {
        crmsCasePage.crmsClosureDetails();
    }

    public void approveAndRejectWO(String approveNReject) throws InterruptedException {
        crmsCasePage.workOrderApproveAndReject(approveNReject);
    }

    public void createCRMSCaseCWD3N6() throws IOException {
        crmsCasePage.updateExcelCRMSCaseCWD3N6();
    }

    public void importIMBExcelForCWD3N6() throws InterruptedException {
        crmsCasePage.importCWD3N6ExcelData();
    }

    public void UserAssessmentNDeviationRemark(String userAssessment) {
        crmsCasePage.selectComplianceInformationOnCase(userAssessment);
        crmsCasePage.enterDeviationRemarks();
    }

    public void labReportPopUpForCWD3N6() {
        crmsCasePage.openLabReportPopUpForCWD3N6();
    }

    public void uploadPUBLabReport() throws InterruptedException {
        String WQPath ="\\src\\test\\resources\\testdata\\CWD3&6_LabReport_NonCompliance.xlsx";
        factory.uploadReportInPubLab(WQPath);
    }

    public void checkSystemAssessmentInLabReportResult(String systemAssessment) {
        crmsCasePage.verifySystemAssessment(systemAssessment);
    }
}
