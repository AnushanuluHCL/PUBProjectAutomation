package com.sat.StepDefinitions;

import java.text.ParseException;
import java.util.Properties;

import com.sat.Pages.caseCreationPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.*;

public class ResealingStepdefs {

    private caseCreationPage casepage = new caseCreationPage(TestBase.getDriver());

    private Properties prop;
    private TestBase testbase = new TestBase();

    @And("navigate to {string} stage and navigate to next stage")
    public void navigate_to_stage_and_navigate_to_next_stage(String stageName) {
		casepage.processingStageToNextStage(stageName);
    }

    @And("validate that SO\\/AO get notified by resealing notification")
    public void validate_that_SO_AO_get_notified_by_resealing_notification() throws InterruptedException {
        casepage.validateResealingNotification();
    }

    @And("validate the system triggered {string} email to tankercompany about resealed tankers")
    public void validate_the_system_triggered_email_to_tankercompany_about_resealed_tankers(String mailType) throws InterruptedException, ParseException {
        casepage.mailGeneratedOrNot(mailType);
    }

    @And("validate the resealing tanker information")
    public void validate_the_resealing_tanker_information() {
        casepage.resealingTankersInfoCheck();
    }


}
