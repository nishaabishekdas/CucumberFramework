package com.api.stepdefinition;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.api.model.createStoreModel.CreateStoresResponse;
import com.api.utils.ResponseHandler;
import com.api.utils.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

public class CreateStoreStepDefinition {
	
	private TestContext context;
	private static final Logger LOG = LogManager.getLogger(ViewStoreDetailsStepDefinition.class);
	public CreateStoreStepDefinition(TestContext context) {
		super();
		this.context = context;
	}
	
	@Given("new store details are populated in request")
	public void populateNewStoreDetails(DataTable dataTable) {
		Map<String,String> storeData = dataTable.asMaps().get(0);
		JSONObject storeDataRequest = new JSONObject();
		storeDataRequest.put("name", storeData.get("name"));
		storeDataRequest.put("type", storeData.get("type"));
		storeDataRequest.put("address", storeData.get("address"));
		storeDataRequest.put("address2", storeData.get("address2"));
		storeDataRequest.put("city", storeData.get("city"));
		storeDataRequest.put("state", storeData.get("state"));
		storeDataRequest.put("zip", storeData.get("zip"));
		storeDataRequest.put("lat",Double.valueOf(storeData.get("lat")));
		storeDataRequest.put("lng", Double.valueOf(storeData.get("lng")));
		storeDataRequest.put("hours", storeData.get("hours"));
		
	  context.requestBody=storeDataRequest;
	}

	

	@When("the stores post endpoint is invoked")
	public void the_stores_post_endpoint_is_invoked() {
		context.response = context.requestSetup().body(context.requestBody.toString()).when().post("stores");
		CreateStoresResponse createStoresResponse = ResponseHandler.deserializedResponse(context.response, CreateStoresResponse.class);
		context.dataMap.put("storeId", createStoresResponse.getId());
		
	}
}
