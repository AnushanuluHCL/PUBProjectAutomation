package com.sat.Pages;

import com.sat.locators.eventPermitApplicationLocators;
import org.openqa.selenium.WebDriver;

public class eventPermitApplicationPage extends commonActionsPage{

    eventPermitApplicationLocators eventPermit = new eventPermitApplicationLocators(driver);
    public eventPermitApplicationPage(WebDriver driver) {
        super(driver);
    }

    public void createEventPermitApplication(String eventInspectionType) throws InterruptedException {
        eventPermit.selectEventCategory();
        eventPermit.setApplicationNo();
        eventPermit.applicationDetails();
        eventPermit.enterDateDetails();
        eventPermit.selectEventInspectionType(eventInspectionType);
    }

    public void createApplicationFromJS() {
        eleUtil.createApplication();
    }

    public void searchAndOpenApplication() throws InterruptedException {
        eventPermit.searchApplication();

    }

}
