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

public class PermitRevocationStepdefs extends BaseStepDefs {

	private CasecreationPage casepage = new CasecreationPage(TestBase.getDriver());

	private Properties prop;
	private TestBase testbase = new TestBase();

	@And("validate that SO\\/AO get notified by permit revocation notification")
	public void validate_that_SO_AO_get_notified_by_permit_revocation_notification() throws InterruptedException {
		casepage.validateRevocationNotification();	
	}
	@And("validate the tankerpermitstatus after revocation")
	public void validate_the_tankerpermitstatus_after_revocation() throws InterruptedException {
		casepage.tankerPermitStatusAtTankerLvl();
		casepage.tankerPermitStatusAtPermitLvl();
	}
	
	@And("update the blacklist field value as yes with date and {string} in months")
	public void update_the_blacklist_field_value_as_yes_with_date_and_in_months(String blacklistperiod) {
		casepage.balcklistACompany(blacklistperiod);
	}
	

}
