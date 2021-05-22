package com.sample.stepdefinations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;


import com.sample.config.BPConstants;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.lib.WrapperWorld;

import junit.textui.TestRunner;

public class ReportUtil {
	
	public static void writeToJson()
	{
		CucumberDetailedResults results = new CucumberDetailedResults();
		FileOutputStream jsonOutputfile = null;
		try
		{
			File targetClassDir = new File(TestRunner.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			System.out.println("files"+targetClassDir.toString());
			File targetDirectory = targetClassDir.getParentFile();
			System.out.println("targetDir"+targetDirectory.toString());
			jsonOutputfile = FileUtils.openOutputStream(new File(targetDirectory + "//"+ BPConstants.JSON_FILENAME));
			System.out.println("jsonOutputfile"+jsonOutputfile.toString());
			jsonOutputfile.write(BPConstants.OPEN_SQARE_BRACES.getBytes());
			Map<String,JSONObject> jsonTestResultMap = WrapperWorld.getInstance().getTestResultJsonMap();
			
			Set<String> jsonResultSet = jsonTestResultMap.keySet();
			System.out.println("*****"+jsonResultSet);
			
			int count = 0;
			for(String jsonResult: jsonResultSet)
			{
				jsonOutputfile.write(jsonTestResultMap.get(jsonResult).toString().getBytes());
				if(++count < jsonResultSet.size())
				{
					jsonOutputfile.write(BPConstants.COMMA_WITHOUT_SPACE.getBytes());
				}else
				{
					jsonOutputfile.write(BPConstants.CLOSE_SQARE_BRACES.getBytes());
				}
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				if(jsonOutputfile != null)
				{
					jsonOutputfile.close();
					jsonOutputfile.flush();
				}
				
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		results.setOutputDirectory("target/cucubmer-detailed-report1");
		results.setOutputName("cucumber-results1");
		results.setSourceFile("./target/cucumber.json");
		try {
			results.execute(Boolean.TRUE);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

}
