package com.sat.locators;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.sat.Pages.CommonActionsPage;
import com.sat.constants.AppConstants;
import com.sat.testUtil.ElementUtil;
import com.sat.testUtil.Log;
import com.sat.testbase.TestBase;

public class WAApplicationPage extends CommonActionsPage {

	// Locators for Company Details

	private By companyName = By.xpath("//input[@aria-label='Company Name']");
	private By houseNo = By.xpath("//input[contains(@aria-label,'House No')]");
	private By unit = By.xpath("//input[@aria-label='Unit']");
	private By buildingName = By
			.xpath("//h2[@title='Company Details']/../..//descendant::input[@aria-label='Building Name']");
	private By streetName = By
			.xpath("//h2[@title='Company Details']/../..//descendant::input[@aria-label='Street Name']");
	private By postalcodeAtCompDetails = By
			.xpath("//h2[@title='Company Details']/../..//descendant::input[@aria-label='Postal Code']");
	private By UEN = By.xpath("//input[@aria-label='UEN']");
	private By ServiceAccNo1 = By.xpath("//input[@aria-label='SP Services Account No.1']");
	private By serviceActivitiesByFactory = By.xpath("//input[contains(@aria-label,'Describe Manufacturing or')]");
	private By tradeEffulicientGenerated = By.xpath("//textarea[contains(@aria-label,'Trade Effluent is Generated')]");
	private By catchmentField = By.xpath("//select[@aria-label='Catchment']"); // visible Text - Bedok

	// Loactors for Company Rep's Details
	private By companyRepGridhead = By.xpath("//h2[contains(@title,'Company Rep')]");
	private By salutationField = By.xpath("//select[@aria-label='Salutation']"); // visible Text - Mr
	private By applicant_Name = By.xpath("//input[@aria-label='Applicant Name']");
	private By idTypeField = By.xpath("//select[@aria-label='ID Type']"); // visible Text - NRIC
	private By applicantEmail = By.xpath("//input[@aria-label='Applicant Email Address']");
	private By mobileNum = By.xpath("//input[@aria-label='Mobile Number']");
	private By postalcodeAtCompRepDetailsField = By
			.xpath("//h2[contains(@title,'Company Rep')]/../..//descendant::input[@aria-label='Postal Code']");
	private By houseNoAtCompRepDetailsField = By.xpath("//input[@aria-label='Block/House No']");
	private By strNameAtCompRepDetailsField = By
			.xpath("//h2[contains(@title,'Company Rep')]/../..//descendant::input[@aria-label='Street Name']");
	private By buildNameAtCompRepDetailsField = By
			.xpath("//h2[contains(@title,'Company Rep')]/../..//descendant::input[@aria-label='Building Name']");

	// Locators for WA Application details
	private By WAAppDate = By.xpath("//input[@aria-label='Date of WA Application Date']/following-sibling::i");
	private By selectCurrentDate = By.xpath("//td[contains(@class,'ms-CalendarDay-daySelected')]");
	private By SSICCode = By.xpath("//input[@aria-label='SSIC Code, Lookup']");
	private By SSICCodelookup = By.xpath("//button[@aria-label='Search records for SSIC Code, Lookup field']");// Frame
	private By ssicLookupValue = By.xpath("//li[contains(@data-id,'pub_factoryssiccode')]");																											// is
																												// there
																												// to
																												// select
																												// the
																												// value

	public WAApplicationPage(WebDriver driver) {
		super(driver);
	}

	public void companyName() {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		String currentDateTime = formatter.format(date);
		currentDateTime = currentDateTime.replaceAll("\\W", "");
		String companyname = "Testcomp" + currentDateTime;

		eleUtil.waitForVisibilityOfElement(companyName, 10);
		eleUtil.doClickLog(companyName, "Clicked on company Name field");
		eleUtil.doClearUsingKeysLog(companyName, "Clear the company name field");
		eleUtil.doSendKeysLog(companyName, companyname, "Companyname is :");
	}

	public void houseNumber(String blkno) {
		eleUtil.waitForVisibilityOfElement(houseNo, 30);
		eleUtil.doClickLog(houseNo, "Clicked on house number field");
		eleUtil.doClearUsingKeysLog(houseNo, "Clear the house number field");
		eleUtil.doSendKeysLog(houseNo, blkno, "Block/House number from Company details section is :");
	}

	public void unit(String unitval) {
		eleUtil.waitForVisibilityOfElement(unit, 10);
		eleUtil.doClickLog(unit, "Clicked on unit field");
		eleUtil.doClearUsingKeysLog(unit, "Clear the unit field");
		eleUtil.doSendKeysLog(unit, unitval, "Unit number is :");
	}

	public void buildingName(String buildingname) {
		eleUtil.waitForVisibilityOfElement(buildingName, 10);
		eleUtil.doClickLog(buildingName, "Clicked on building name field");
		eleUtil.doClearUsingKeysLog(buildingName, "Clear the building name field");
		eleUtil.doSendKeysLog(buildingName, buildingname, "Building name from Company details section is :");
	}

	public void streetName(String strname) {
		eleUtil.waitForVisibilityOfElement(streetName, 10);
		eleUtil.doClickLog(streetName, "Clicked on street name field");
		eleUtil.doClearUsingKeysLog(streetName, "Clear the street name field");
		eleUtil.doSendKeysLog(streetName, strname, "Street name from Company details section is :");
	}

	public void postalcodeAtCompanyDetailsGrid(String postalcode) {
		eleUtil.waitForVisibilityOfElement(postalcodeAtCompDetails, 10);
		eleUtil.doClickLog(postalcodeAtCompDetails, "Clicked on Postalcode from Company details section field");
		eleUtil.doClearUsingKeysLog(postalcodeAtCompDetails, "Clear the Postalcode from Company details section field");
		eleUtil.doSendKeysLog(postalcodeAtCompDetails, postalcode, "Postalcode from Company details section is :");
	}

	public void UEN() {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		String currentDateTime = formatter.format(date);
		currentDateTime = currentDateTime.replaceAll("\\W", "");
		String UENNumber = "uen" + currentDateTime;

		eleUtil.waitForVisibilityOfElement(UEN, 10);
		eleUtil.doClickLog(UEN, "Clicked on UEN field");
		eleUtil.doClearUsingKeysLog(UEN, "Clear the UEN field");
		eleUtil.doSendKeysLog(UEN, UENNumber, "UEN number is :");
	}

	public void serviceAccountNo1(String Accountnum) {
		eleUtil.waitForVisibilityOfElement(ServiceAccNo1, 10);
		eleUtil.doClickLog(ServiceAccNo1, "Clicked on SP Services Account No.1  field");
		eleUtil.doClearUsingKeysLog(ServiceAccNo1, "Clear the SP Services Account No.1 field");
		eleUtil.doSendKeysLog(ServiceAccNo1, Accountnum, "SP Services Account No.1 value is :");
	}

	public void serviceActivitiesByFactory(String activityval) {
		eleUtil.waitForVisibilityOfElement(serviceActivitiesByFactory, 10);
		eleUtil.doClickLog(serviceActivitiesByFactory,
				"Clicked on 'Describe Manufacturing or Service Activities Conducted in the Factory'  field");
		eleUtil.doClearUsingKeysLog(serviceActivitiesByFactory,
				"Clear the 'Describe Manufacturing or Service Activities Conducted in the Factory' field");
		eleUtil.doSendKeysLog(serviceActivitiesByFactory, activityval, "Service activity by factory value is :");
	}

	public void tradeEffulicientGenerated(String activityval) {
		eleUtil.waitForVisibilityOfElement(tradeEffulicientGenerated, 10);
		eleUtil.doClickLog(tradeEffulicientGenerated,
				"Clicked on Describe Activities/Processes in which Trade Effluent is Generated field");
		eleUtil.doClearUsingKeysLog(tradeEffulicientGenerated,
				"Clear the Describe Activities/Processes in which Trade Effluent is Generated field");
		eleUtil.doSendKeysLog(tradeEffulicientGenerated, activityval, "Trade Effulicient Generated value is :");
	}

	public void catchment(String catchmentval) {
		jsutil.scrollIntoView(driver.findElement(catchmentField));
		eleUtil.waitForVisibilityOfElement(catchmentField, 30);
		eleUtil.createSelectLog(catchmentField, "Selected the dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(catchmentField, catchmentval, "Selected dropdown value is ");
	}

	public void salutation(String salutationtval) {
		eleUtil.waitForVisibilityOfElement(salutationField, 30);
		eleUtil.createSelectLog(salutationField, "Selected the saluation dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(salutationField, salutationtval,
				"Selected salutation dropdown value is ");
	}

	public void applicant(String name) {
		eleUtil.waitForVisibilityOfElement(applicant_Name, 10);
		eleUtil.doClickLog(applicant_Name, "Clicked on Applicant name field");
		eleUtil.doClearUsingKeysLog(applicant_Name, "Clear the Applicant name field");
		eleUtil.doSendKeysLog(applicant_Name, name, "Applicant name is :");
	}

	public void idType(String idtypeval) {
		eleUtil.waitForVisibilityOfElement(idTypeField, 30);
		eleUtil.createSelectLog(idTypeField, "Selected the ID Type dropdown ");
		eleUtil.doSelectDropDownByVisibleTextLog(idTypeField, idtypeval, "Selected ID Type dropdown value is ");
	}

	public void applicantEmail(String email) {
		eleUtil.waitForVisibilityOfElement(applicantEmail, 10);
		eleUtil.doClickLog(applicantEmail, "Clicked on Applicant email field");
		eleUtil.doClearUsingKeysLog(applicantEmail, "Clear the Applicant email field");
		eleUtil.doSendKeysLog(applicantEmail, email, "Applicant name is :");
	}

	public void mobileNumber(String mobilenum) {
		eleUtil.waitForVisibilityOfElement(mobileNum, 10);
		eleUtil.doClickLog(mobileNum, "Clicked on Mobile Number field");
		eleUtil.doClearUsingKeysLog(mobileNum, "Clear the Mobile Number field");
		eleUtil.doSendKeysLog(mobileNum, mobilenum, "Mobile Number is :");
	}

	public void postalcodeAtCompRepDetails(String postalcode) {
		eleUtil.waitForVisibilityOfElement(postalcodeAtCompRepDetailsField, 10);
		eleUtil.doClickLog(postalcodeAtCompRepDetailsField,
				"Clicked on Postal Code field at Company Rep Details section");
		eleUtil.doClearUsingKeysLog(postalcodeAtCompRepDetailsField,
				"Clear the Postal Code field at Company Rep Details section");
		eleUtil.doSendKeysLog(postalcodeAtCompRepDetailsField, postalcode,
				"Postal Code field at Company Rep Details section is :");
	}

	public void houseNoAtCompRepDetails(String houseno) {
		eleUtil.waitForVisibilityOfElement(houseNoAtCompRepDetailsField, 10);
		eleUtil.doClickLog(houseNoAtCompRepDetailsField,
				"Clicked on House Number field at Company Rep Details section");
		eleUtil.doClearUsingKeysLog(houseNoAtCompRepDetailsField,
				"Clear the House Number field at Company Rep Details section");
		eleUtil.doSendKeysLog(houseNoAtCompRepDetailsField, houseno,
				"House Number field at Company Rep Details section is :");
	}

	public void strNameAtCompRepDetails(String streetname) {
		eleUtil.waitForVisibilityOfElement(strNameAtCompRepDetailsField, 10);
		eleUtil.doClickLog(strNameAtCompRepDetailsField, "Clicked on Street name field at Company Rep Details section");
		eleUtil.doClearUsingKeysLog(strNameAtCompRepDetailsField,
				"Clear the Street name field at Company Rep Details section");
		eleUtil.doSendKeysLog(strNameAtCompRepDetailsField, streetname,
				"Street name field at Company Rep Details section is :");
	}

	public void buildNameAtCompRepDetails(String buildingname) {
		eleUtil.waitForVisibilityOfElement(buildNameAtCompRepDetailsField, 10);
		eleUtil.doClickLog(buildNameAtCompRepDetailsField,
				"Clicked on Building name field at Company Rep Details section");
		eleUtil.doClearUsingKeysLog(buildNameAtCompRepDetailsField,
				"Clear the Building name field at Company Rep Details section");
		eleUtil.doSendKeysLog(buildNameAtCompRepDetailsField, buildingname,
				"Building name field at Company Rep Details section is :");
	}

	public void selectWAAppDate() {
		eleUtil.waitForVisibilityOfElement(WAAppDate, 10);
		eleUtil.doClickLog(WAAppDate, "Clicked on calendar icon for WA Application Date field");
		eleUtil.doClickLog(selectCurrentDate,
				"Clicked on current date from calendar present in WA Application Date field");
	}

	public void selectSSICcode(String ssicval) {
		eleUtil.waitForVisibilityOfElement(SSICCode, 10);
		eleUtil.doClickLog(SSICCode, "Clicked on SSIC field");
		eleUtil.doSendKeysLog(SSICCode, ssicval, "SSIC field value is :");
		//eleUtil.waitForFrameByLocator(By.xpath("//iframe[@title='PowerAppsSharedAppHostIframe']"), AppConstants.MEDIUM_DEFAULT_WAIT);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(ssicLookupValue)).click().build().perform();
		//eleUtil.doActionsClickLog(ssicLookupValue,"Clicked the lookup value");
	}
}