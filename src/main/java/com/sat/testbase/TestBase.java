package com.sat.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.sat.exception.FrameworkException;
import com.sat.factory.OptionsManager;

public class TestBase {

	public WebDriver driver;
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/sat/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebDriver initialization() {
		String browserName = prop.getProperty("browser");

		/*
		 * if (browserName.equals("chrome")) {
		 *
		 * // WebDriverManager.chromedriver().setup(); // driver=new ChromeDriver();
		 * tldriver.set(new ChromeDriver());
		 *
		 * // System.setProperty("webdriver.chrome.driver", //
		 * "src/test/resources/com.sat.Drivers/chromedriver.exe");
		 *
		 * }
		 */
		optionsManager = new OptionsManager(prop);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			// driver = new ChromeDriver(optionsManager.getChromeOptions());
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			// tldriver.set(new ChromeDriver());
			break;

		case "firefox":
			// driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;

		case "edge":
			// driver = new EdgeDriver(optionsManager.getEdgeOptions());
			tldriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;

		case "safari":
			// driver = new SafariDriver();
			tldriver.set(new SafariDriver());
			break;

		default:
			System.out.println("please pass the right browser name...." + browserName);
			throw new FrameworkException("No Browser Found...");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {

		return tldriver.get();
	}

	public void UrlLaunch() {
		try {
			Thread.sleep(6000);
			System.out.println("Environment is : " + prop.getProperty("url"));
			getDriver().get(prop.getProperty("url"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void powerappsURLLaunch(String environment) {
		try {
			String url;
			Thread.sleep(6000);
			switch (environment.toUpperCase()) {
			case "SIT1":
				System.out.println("PowerApps URL is : " + prop.getProperty("powerapps_URL"));
				getDriver().get(prop.getProperty("powerapps_URL"));
				break;
			case "SIT2":
				System.out.println("PowerApps URL is : " + prop.getProperty("powerapps_URL_sit2"));
				getDriver().get(prop.getProperty("powerapps_URL_sit2"));
				break;
			case "SIT3":
				System.out.println("PowerApps URL is : " + prop.getProperty("powerapps_URL_sit3"));
				getDriver().get(prop.getProperty("powerapps_URL_sit3"));
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}