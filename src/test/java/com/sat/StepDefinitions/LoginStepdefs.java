package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sat.Pages.ApplicationPage;
import com.sat.Pages.LoginPage;
import com.sat.Pages.NEAListPage;
import com.sat.Pages.CommonActionsPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LoginStepdefs extends BaseStepDefs {

    private LoginPage loginpage = new LoginPage(TestBase.getDriver());
    private NEAListPage neapage = new NEAListPage(TestBase.getDriver());
    private ApplicationPage apppage = new ApplicationPage(TestBase.getDriver());
    private CommonActionsPage common = new CommonActionsPage(TestBase.getDriver());
    //public static String tankercompanyname;

    private Properties prop;
    private TestBase testbase = new TestBase();

    @Given("User navigates to CRM login page")
    public void user_navigates_to_CRM_login_page() {
        testbase.UrlLaunch();

    }

    @When("Login to app with {string} and {string}")
    public void login_to_app_with_and(String username, String password) throws InterruptedException {
        loginpage.appLogin(username, password);
    }

    @Then("user selects App {string}")
    public void user_selects_App(String appname) throws InterruptedException {
        loginpage.GetApp(appname);
    }

    @When("user change the changearea to {string}")
    public void user_change_the_changearea_to(String changearea) {
        common.changeAreaSelection(changearea);
    }

    @And("user selects entity as {string}")
    public void user_selects_entity_as(String entityname) {
        common.selectEntity(entityname);
    }

    @And("fill the details {string},{string},{string},{string},{string},{string} in the NEA list record form")
    public void fill_the_details_in_the_NEA_list_record_form(String companyname, String VehicleNum, String Vehicletype, String Capacity, String RegOrDereg, String iteration) throws InterruptedException {
        neapage.clcikOnNewButton();
        neapage.creationOfNEAListRecord(companyname, VehicleNum, Vehicletype, Capacity, RegOrDereg, iteration);
        //neapage.newrecord();

    }

    @And("fill the details in the NEA list record form")
    public void fill_the_details_in_the_NEA_list_record_form(DataTable Tankerdetails) throws InterruptedException {
        neapage.creationOfNEARecordmultiple(Tankerdetails);
    }

    @And("fill the details in application form for General details {string},{string},{string}")
    public void fill_the_details_in_application_form_for_General_details(String AddressOfTankerYard, String PhoneNo, String Emailid) {
        neapage.clcikOnNewButton();
        apppage.creationOfApplicationRecord(AddressOfTankerYard, PhoneNo, Emailid);
    }

    @And("fill the details in application form for waste type details {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void fill_the_details_in_application_form_for_waste_type_details(String GWSelected, String GWPerMomnth, String HWSelected, String HWType, String HWPerMomnth, String OSSSelected, String OSSPerMomnth, String OSISelected, String OSIPerMonth) {
        apppage.amountOfWastetypeOfTankers(GWSelected, GWPerMomnth, HWSelected, HWType, HWPerMomnth, OSSSelected, OSSPerMomnth, OSISelected, OSIPerMonth);
    }

    /*
     * @And("fill the details in application form for waste type details") public
     * void fill_the_details_in_application_form_for_waste_type_details(DataTable
     * wastetypedata) { apppage.amountOfWastetypeOfTankers(wastetypedata); }
     */

    @And("create a tanker by filling the details")
    public void create_a_tanker_by_filling_the_details_as(DataTable typeOfTankersdata) {
        apppage.creationOfTankers(typeOfTankersdata);
    }

    @And("create tankers by filling the details")
    public void create_tankers_by_filling_the_details(DataTable typeOfTankersdata) throws InterruptedException {
        apppage.creationOfMultipleTankers(typeOfTankersdata);
    }


    @And("Open the FormSG URL to create an application")
    public void open_the_form_sg_url_to_create_an_application() throws AWTException, IOException {
        apppage.fillTheDetailsByFormSG();

    }

    @And("create an NEA record through interface")
    public void create_an_NEA_record_through_interface() {
        apppage.neaInterface();
    }

    @And("logout from the admin credentials")
    public void logout_from_the_admin_credentials() {
        loginpage.signoutApp();
    }

}
