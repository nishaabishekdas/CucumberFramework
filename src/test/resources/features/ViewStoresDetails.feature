@tag
Feature: View Store Details

  @viewAllStoreDetails @sanity @regression
  Scenario: Get All store Details
    When the "stores" endpoint is accessed
    Then api should return the response code 200
    And response body data should contain list of stores

	@getSingleStoreDetails @sanity @regression
   Scenario:Get Store details of a specific store
   When the "stores" endpoint is accessed with a storeId parameter
    Then api should return the response code 200    
    And response body data should contain details of specific store