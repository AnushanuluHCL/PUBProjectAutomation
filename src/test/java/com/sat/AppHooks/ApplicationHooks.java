package com.sat.AppHooks;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sat.factory.DriverFactory;
import com.sat.testUtil.ElementUtil;
import com.sat.testbase.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private TestBase driverFactory;
	private WebDriver driver;
	private ElementUtil eleutil;
	// private ConfigReader configReader;

	Properties prop;
	/*
	 * @Before(order=0) public void getproperty() { configReader = new
	 * ConfigReader(); prop = configReader.int_prop(); }
	 */

	@Before(order = 0)
	public void launchbrowser() {
		// String browsername= prop.getProperty("browser");
		driverFactory = new TestBase();
		driver = driverFactory.initialization();
		eleutil=new ElementUtil(driver);
		prop=eleutil.readProperties();
	}

	@After(order = 0)
	public void QuitBrowser() {
		// driver.quit();
	}

	@After(order = 1)
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			//String screenshotname = scenario.getName().replaceAll(" ", "_");
			String screenshotname = scenario.getName();
			byte[] sourcepath = ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotname);
		}
	}

}
