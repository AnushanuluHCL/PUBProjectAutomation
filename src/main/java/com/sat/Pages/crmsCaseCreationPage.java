package com.sat.Pages;

import com.sat.locators.casePage;
import com.sat.locators.crmsCasePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class crmsCaseCreationPage extends commonActionsPage {

    crmsCasePage crmsCasePage = new crmsCasePage(driver);
    casePage cases = new casePage(driver);

    public crmsCaseCreationPage(WebDriver driver) {
        super(driver);
    }

    public void createCRMSCaseCWD1() throws IOException {
        crmsCasePage.updateExcelCRMSCaseCWD1();
    }

    public void importIMBExcel() throws InterruptedException {
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
}
