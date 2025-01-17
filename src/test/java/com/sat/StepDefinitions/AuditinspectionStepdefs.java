package com.sat.StepDefinitions;


import java.util.Properties;
import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.caseCreationPage;
import com.sat.Pages.commonActionsPage;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.*;

public class AuditinspectionStepdefs {

	private PowerAppsAutomateFlowPage powerapppage = new PowerAppsAutomateFlowPage(TestBase.getDriver());
    private caseCreationPage casepage = new caseCreationPage(TestBase.getDriver());


	private Properties prop;
	private TestBase testBase = new TestBase();

	@Given("User navigates to powerapps cloud flow page in {string} environment")
	public void User_navigates_to_powerapps_cloud_flow_page(String env) {
		/*TestBase testBase = new TestBase();
		testBase.initialization();
		System.out.println("WebDriver instance: " + TestBase.getDriver());
		System.out.println("URL: " + prop.getProperty("powerapps_URL"));
		TestBase.getDriver().get(prop.getProperty("powerapps_URL"));*/
		testBase.powerappsURLLaunch(env);
	}
	@And("Run the automatic cloudflow job for {string}")
	public void Run_the_automatic_cloudflow_job_for(String job) {
		powerapppage.runCloudFlow(job);
	}
	@And("change the configuration to create cases today")
	public void change_the_configuration_to_create_cases_today() throws InterruptedException {
		casepage.tpConfigChangeForAudit();
	}
	@And("verify that tanker audit cases are created")
	public void verify_that_tanker_audit_cases_are_created() throws InterruptedException {
		casepage.verifyingCreatedCases();
	}

}
