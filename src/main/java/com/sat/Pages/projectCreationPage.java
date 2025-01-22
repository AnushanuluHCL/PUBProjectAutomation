package com.sat.Pages;

import com.sat.locators.projectPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class projectCreationPage extends commonCRMActions{
    public projectCreationPage(WebDriver driver) {
        super(driver);
    }

    projectPage project = new projectPage(driver);

    public void createProject(String accountSubType) throws InterruptedException, IOException {
        project.createProjectWithExcel(accountSubType);
    }

    public void verifyProjectCreated() throws InterruptedException {
        project.checkProjectCreated();
    }

    public void enterBPUOfficerAndSave() throws InterruptedException {
        project.enterBPUOfficer();
    }

    public void createBPUSubmission(String accountSubType) throws InterruptedException, IOException {
        project.createBPUSubmissionsWithExcel(accountSubType);
    }

    public void verifyBPUSubmissionCreated() throws InterruptedException {
        project.checkBPUSubmissionCreated();
    }

    public void enterQualifiedPersonAndSave() throws InterruptedException {
        project.openBPUAndEnterQualifiedPerson();
    }

    public void verifyCaseCreated() throws InterruptedException {
        project.checkCaseCreated();
    }

    public void verifyWorkOrderCreated() throws InterruptedException {
        project.checkWorkOrderCreated();
    }

    public void createManualPremisesForNonIndustrialPremises(String entityType) throws InterruptedException {
        project.createManualPremises(entityType);
    }
}