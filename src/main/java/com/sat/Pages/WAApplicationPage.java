package com.sat.Pages;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sat.locators.WAApplicationLocatorsPage;

public class WAApplicationPage extends commonActionsPage {

	public WAApplicationPage(WebDriver driver) {
		super(driver);
	}

	WAApplicationLocatorsPage waapp = new WAApplicationLocatorsPage(driver);

	public void fillCompanyDetails(String json) throws InterruptedException  {
		    clickonNewBtn();
		    
		 /*   Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
		    List<String> lines = Files.readAllLines(path);
		    String[] data = lines.get(1).split(","); 

		  
		    String blkno = data[0];
		    String unitval = data[1];
			String buildingName = data[2];
			String streetName = data[3];
			String postalCode = data[4];
			String accountName = data[5];
			String activityValue = data[6];
			String tradeValue = data[7];
			String catchmentValue = data[8];
			
			
		
			waapp.companyName();
			waapp.houseNumber(blkno);
			waapp.unit(unitval);
			waapp.buildingName(buildingName);
			waapp.streetName(streetName);
			waapp.postalcodeAtCompanyDetailsGrid(postalCode);
			waapp.UEN();
			waapp.serviceAccountNo1(accountName);
			waapp.serviceActivitiesByFactory(activityValue);
			waapp.tradeEffulicientGenerated(tradeValue);
			waapp.catchment(catchmentValue);*/
		    
		    Gson gson = new Gson();
			Type type = new TypeToken<List<Map<String, String>>>() {
			}.getType();
			List<Map<String, String>> data = gson.fromJson(json, type);

			if (!data.isEmpty()) {
				Map<String, String> row = data.get(0);

				String blkno = row.get("Block/House No");
				String unitval = row.get("Unit");
				String buildingName = row.get("Building Name");
				String streetName = row.get("Street Name");
				String postalCode = row.get("Postal Code");
				String accountName = row.get("SP Services Account No.1");
				String activityValue = row.get("Describe Manufacturing or Service Activities Conducted in the Factory");
				String tradeValue = row.get("Describe Activities/Processes in which Trade Effluent is Generated");
				String catchmentValue = row.get("Catchment");
				String salutationValue = row.get("Salutation");
				String applicantName = row.get("Applicant Name");
				String idTypeValue = row.get("ID Type");
				String email = row.get("Applicant Email Address");
				String mobileNum = row.get("Mobile Number");
				String postalCodeAtCompRep=row.get("Postal Code at CompRep");
				String housenoAtCompRep=row.get("Block/House No at CompRep");
				String streetNameAtCompRep = row.get("Street Name at CompRep");
				String buildingNameCompRep = row.get("Building Name at CompRep");
				String SSICValue = row.get("SSIC");
				String DischareInLit=row.get("Peak Discharge Rate (litre / second)");
				String WorkingDays =row.get("Number of working days per month");
				String Hours=row.get("Operating Hours per Day");

				commonActionsPage.WRN1_factoryname=waapp.companyName();
				waapp.houseNumber(blkno);
				waapp.unit(unitval);
				waapp.buildingName(buildingName);
				waapp.streetName(streetName);
				waapp.postalcodeAtCompanyDetailsGrid(postalCode);
				waapp.UEN();
				waapp.serviceAccountNo1(accountName);
				waapp.serviceActivitiesByFactory(activityValue);
				waapp.tradeEffulicientGenerated(tradeValue);
				waapp.catchment(catchmentValue);
				waapp.salutation(salutationValue);
				waapp.applicant(applicantName);
				waapp.idType(idTypeValue);
				waapp.applicantEmail(email);
				waapp.mobileNumber(mobileNum);
				waapp.postalcodeAtCompRepDetails(postalCodeAtCompRep);
				waapp.houseNoAtCompRepDetails(housenoAtCompRep);
				waapp.strNameAtCompRepDetails(streetNameAtCompRep);
				waapp.buildNameAtCompRepDetails(buildingNameCompRep);
				waapp.peakDischargeRate(DischareInLit);
				waapp.noOfWorkingDays(WorkingDays);
				waapp.operatingHours(Hours);
				waapp.selectWAAppDate();
				waapp.selectSSICcode(SSICValue);
				
				clickOnSaveBtn();
				waapp.caseIdExtract();
				
		}

	}

}