package com.api.stepdefinition;

import static io.restassured.RestAssured.given;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;

import com.api.utils.PropertiesFile;
import com.api.utils.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class SpotifyApi {
	private TestContext testContext;
	private String clientId = PropertiesFile.getProperty("Client_Id");
	private String redirectUri = PropertiesFile.getProperty("Redirect_URI");
	private String secretKey = PropertiesFile.getProperty("Secret_Key");
	private String authCode;
	private String accessToken;
	private String refreshToken;

	public SpotifyApi(TestContext testContext) {
		super();
		this.testContext = testContext;
	}

	@When("I invoke authorization code api using clientId, {string} and redirectUri from response")
	public void i_invoke_authorization_code_api_using_client_id_and_redirect_uri_from_response(String responseType) {
		RestAssured.baseURI = PropertiesFile.getProperty("baseURL");
		String encodedUrl = null;
		System.out.println("responce type: " + responseType);
		System.out.println("ClientId:" + PropertiesFile.getProperty("Client_Id"));
		System.out.println("redirectURI:" + PropertiesFile.getProperty("Redirect_URI"));
		try {
			encodedUrl = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8.toString());
			System.out.println(encodedUrl);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testContext.response = given().queryParam("client_id", clientId).queryParam("response_type", responseType)
				.queryParam("redirect_uri", encodedUrl).when().log().all().get("/authorize");

		System.out.println(testContext.response.toString());
	}

	@Then("get the authcode from the response")
	public void get_the_authcode_from_the_response() {
		String authCode = testContext.response.jsonPath().getString("code");
		System.out.println(testContext.response.toString());
		System.out.println("the authcode is: " + authCode);
	}

	@When("I invoke access token API using authcode")
	public void i_invoke_access_token_api() {
		String originalToken = clientId + ":" + secretKey;
		byte[] encodedBytes = Base64.encodeBase64(originalToken.getBytes());
		String encodedString = new String(encodedBytes);
		testContext.response = given().header("Authorization", "Basic " + encodedString)
				.contentType("application/x-www-form-urlencoded").formParam("grant_type", "authorization_code")
				.formParam("code", authCode).formParam("redirect_uri", redirectUri).log().all().when()
				.post("/api/token");
	}

	@Then("get the access token and refresh token from response")
	public void get_the_access_token_using_from_response(String string) {
		accessToken = testContext.response.jsonPath().getString("access_token");
		refreshToken = testContext.response.jsonPath().getString("refresh_token");
		System.out.println("The access Token parsed: " + accessToken + "\n" + "The Refresh Token parsed: " + refreshToken);
		System.out.println(testContext.response.toString());
	}

	@Then("I should get a response code of {int}")
	public void verifyResponseCode(Integer respCode) {
		Assert.assertEquals(Long.valueOf(respCode), Long.valueOf(testContext.response.statusCode()));

	}

	@When("I invoke getplaylist API using access token and playlistId")
	public void i_invoke_getplaylist_api_using_access_token_and_playlist_id() {
		String playlistId = PropertiesFile.getProperty("playlist_Id");
		testContext.response = given().header("Authorization", "Bearer " + accessToken).when().log().all()
				.get("/playlists/{playlist_id}", playlistId);
		System.out.println(testContext.response.toString());
	}

}
