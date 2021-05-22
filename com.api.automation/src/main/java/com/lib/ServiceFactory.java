package com.lib;

import java.util.Map;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ServiceFactory 
{
	public static Response invokeRestService(String system,String method,Headers headers,Object obj,String endpoint,String authkey,Map<String,String> formparams)
	{
		switch(system.toUpperCase())
		{
		case "REST_RELAXED_VAL_NO_FORM_PARAMS":
			if(method.equalsIgnoreCase("GET"))
			{
				return InvokeRestService.SubmitRestGetRequestWithRelaxedValidation(headers, endpoint);
			}
			else if(method.equalsIgnoreCase("POST"))
			{
				return InvokeRestService.SubmitRestPostRequestWithRelaxedValidation(headers, obj, endpoint);
			}
			 else
				{
					return null;
				}
			
		case "REST_RELAXED_VAL_BASIC_AUTH_FORM_PARAMS" :
			if(method.equalsIgnoreCase("GET"))
			{
				return null;
			}
			else if(method.equalsIgnoreCase("POST"))
			{
				return InvokeRestService.SubmitRestPostRequestRelaxedValidationWithBasicAuthAndFormParam(headers,endpoint, authkey,formparams);
			}
			 else
				{
					return null;
				}
			default:
				System.out.println("no matching ");
		}  
		
		return null;
		
	}

}
