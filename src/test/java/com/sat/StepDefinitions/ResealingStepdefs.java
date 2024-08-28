package com.sat.StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sat.Pages.ApplicationPage;
import com.sat.Pages.CasecreationPage;
import com.sat.Pages.LoginPage;
import com.sat.Pages.NEAListPage;
import com.sat.Pages.CommonActionsPage;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class ResealingStepdefs {

	private CasecreationPage casepage = new CasecreationPage(TestBase.getDriver());

	private Properties prop;
	private TestBase testbase = new TestBase();

	@And("navigate to Processing stage and navigate to next stage")
	public void navigate_to_Processing_stage_and_navigate_to_next_stage() {
		casepage.processingStageToNextSatge();
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
