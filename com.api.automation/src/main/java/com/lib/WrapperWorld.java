package com.lib;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class WrapperWorld {
	
	private static WrapperWorld wrapperWorld;
	
	private Map<String,JSONObject> testResultJsonMap = new HashMap<String,JSONObject>();
	
	private WrapperWorld()
	{
		
	}
	
	public static WrapperWorld getInstance()
	{
		if(wrapperWorld == null)
		{
			synchronized(WrapperWorld.class)
			{
				if(wrapperWorld == null)
				{
					wrapperWorld  = new WrapperWorld();
				}
			}
		}
		
		return wrapperWorld;
	}

	public Map<String, JSONObject> getTestResultJsonMap() {
		return testResultJsonMap;
	}

	public void setTestResultJsonMap(Map<String, JSONObject> testResultJsonMap) {
		this.testResultJsonMap = testResultJsonMap;
	}
	
	
	
}
