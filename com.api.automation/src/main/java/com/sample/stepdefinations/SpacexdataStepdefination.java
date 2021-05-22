package com.sample.stepdefinations;

import org.junit.Assert;

import com.sample.config.BPConstants;
import com.sample.dto.RegisterRequest;


import com.lib.RestHeaders;
import com.lib.ServiceFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
public class SpacexdataStepdefination {

	Response response;
	private  Scenario scenario;
	
	@Before
	public void before(Scenario scenario)
	{
		this.scenario = scenario;
	}
	

	@Then("^I Verified The Response of  spacedata service$")
	public void i_VerifyResponse() throws Throwable {

		Assert.assertTrue("mis match of id !!! "+"Excepted :"+"605b4b95aa5433645e37d041" + "Actual :"+response.jsonPath().getString("id"),response.jsonPath().getString("id").equals("605b4b95aa5433645e37d041"));
		
		
	}

	
	
	@Given("^I call the space data service$")
	public void icallthetestRegisterUserService() throws Throwable {
		
		
		scenario.write("User End point is : "+BPConstants.USER_ENDPOINT);


		response = ServiceFactory.invokeRestService("REST_RELAXED_VAL_NO_FORM_PARAMS", "get",
				RestHeaders.getHeaderConnectJsonAcceptJson1(), null, BPConstants.USER_ENDPOINT, null, null);
		System.out.println("res***" + response.asString());
		
		CommonStepDefination.assertResponseStatus(200, response);

	}

}
