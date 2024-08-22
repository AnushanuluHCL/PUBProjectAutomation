package com.sat.StepDefinitions;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sat.Pages.WAPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;


public class WRN1_NewWAApplicationStepDefs {

	private WAPage wapage = new WAPage(TestBase.getDriver());

	@And("fill the details in the WA application form")
	public void fill_the_details_in_the_WA_application_form(String blkno, String unitval,
			String buildingname, String strname, String postalcode, String Accountnum, String activityval,
			String tradeval, String catchmentval) {
		//wapage.fillCompanyDetails(blkno, unitval, buildingname, strname, postalcode, Accountnum, activityval,
			//	tradeval, catchmentval);
	}

	@And("fill the details in the WA application form with the following JSON:")
	public void fillTheDetailsInWAApplicationFormWithJson(String json) {
	/*	Gson gson = new Gson();
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
			String catchmentValue = row.get("Catchment");*/
			//wapage.fillCompanyDetails(blkno, unitval, buildingName, streetName, postalCode, accountName,
				//	activityValue, tradeValue, catchmentValue);
		wapage.fillCompanyDetails(json);
		}

	

	@And("fill the details in the WA application form using data from {string}")
	public void fill_the_details_in_the_WA_application_form_using_data_from(String fileName) throws IOException, URISyntaxException {
		wapage.fillCompanyDetails(fileName);		}

	}
