package com.sat.StepDefinitions;

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

public class HWComplaintStepdefs extends BaseStepDefs {

    //private LoginPage loginpage = new LoginPage(TestBase.getDriver());
    //private NEAListPage neapage = new NEAListPage(TestBase.getDriver());
    private ApplicationPage apppage = new ApplicationPage(TestBase.getDriver());
    //private commonActionsPage common = new commonActionsPage(TestBase.getDriver());
    //public static String tankercompanyname;

    private Properties prop;
    private TestBase testbase = new TestBase();

    @And("fill the details in application form for Human waste type details {string},{string},{string}")
    public void fill_the_details_in_application_form_for_Human_waste_type_details(String HWSelected, String HWType, String HWPerMonth) {
        apppage.amountOfHWWastetypeTanker(HWSelected, HWType, HWPerMonth);
    }

}
