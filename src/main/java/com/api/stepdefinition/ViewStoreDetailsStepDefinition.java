package com.api.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.api.model.viewStoreModel.ViewStoresResponse;
import com.api.utils.JsonReader;
import com.api.utils.ResponseHandler;
import com.api.utils.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewStoreDetailsStepDefinition {

	private TestContext context;
	private static final Logger LOG = LogManager.getLogger(ViewStoreDetailsStepDefinition.class);

	public ViewStoreDetailsStepDefinition(TestContext context) {
		this.context = context;
	}

	@When("the {string} endpoint is accessed")
	public void accessStoresEndpoint(String endPoint) {
		context.response = context.requestSetup().when().get(endPoint);
	}
	
	@When("the {string} endpoint is accessed with a storeId parameter")
	public void accessStoresEndpointWithParam(String endPoint) {
		LOG.info("ID from datamap : "+context.storeId);
		context.response = context.requestSetup().pathParam("id", context.storeId).when().get(endPoint+"/{id}");
	}

	@Then("api should return the response code {int}")
	public void verifyResponseCode(Integer respCode) {
		Assert.assertEquals(Long.valueOf(respCode), Long.valueOf(context.response.statusCode()));

	}

	@Then("response body data should contain list of stores")
	public void verifyListOfStoresisDisplayed() {

		//Line no 45 puts you response in a pojo
		ViewStoresResponse viewStoresResponse = ResponseHandler.deserializedResponse(context.response, ViewStoresResponse.class);
		Assert.assertNotEquals("Stores list is empty", 0, viewStoresResponse.getData().size());
		LOG.info("Id:"+viewStoresResponse.getData().get(0).getId());
		context.storeId = viewStoresResponse.getData().get(0).getId();
	}

	@Then("response body data should contain details of specific store")
	public void verifyStoreDetailsisDisplayed() {

		ViewStoresResponse viewStoresResponse = ResponseHandler.deserializedResponse(context.response, ViewStoresResponse.class);
		Assert.assertNotEquals("Stores list is empty", 0, viewStoresResponse.getData().size());
		context.dataMap.put("storeId",viewStoresResponse.getData().get(0).getId());
	}
}
