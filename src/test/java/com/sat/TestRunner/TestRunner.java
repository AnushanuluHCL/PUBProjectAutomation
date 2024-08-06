package com.sat.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//	@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com.sat.Features"}, glue = {"com.sat.StepDefinitions", "com.sat.AppHooks"}, monochrome = true, publish = true, strict = true, plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, tags = ("@NonComplaince"))
// tags = ("@OSIComplaint or @OSSComplaint"))

public class TestRunner extends AbstractTestNGCucumberTests {

}
