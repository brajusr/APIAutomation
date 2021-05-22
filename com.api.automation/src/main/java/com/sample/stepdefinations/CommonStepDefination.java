package com.sample.stepdefinations;

import org.junit.Assert;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CommonStepDefination {
	
	private static Scenario scenario;
	

	public CommonStepDefination()
	{
		
	}
	
	@Before
	public void before(Scenario scenario)
	{
		this.scenario = scenario;
	}
	
	public static void assertResponseStatus(int exceptedSatus,Response response)
	{
		boolean hasMatched = true;
		
		if(response.getStatusCode() != exceptedSatus)
		{
			hasMatched = false;
		}
		
		if(!hasMatched || response.getStatusCode() != exceptedSatus)
		{
			
			Headers responseHearders = response.headers();
			for(Header header : responseHearders)
			{
				scenario.write("Response Header >> key :" + header.getName() +"Value :"+ header.getValue());
			}
			
			scenario.write("Response Body"+response.asString());
		}
		
		Assert.assertTrue("Response code mismatch mismatch !!! "+ "Excepted : " + exceptedSatus + " || Actual : " + response.getStatusCode(), hasMatched);
	}

}
