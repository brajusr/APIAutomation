package com.lib;

import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

import io.restassured.http.Header;
import io.restassured.http.Headers;




public class RestHeaders 
{
		
	List<Header> headerList =new LinkedList<>();
	static Header HeaderContentTypeJson = new Header("Content-Type","application/json");
	static Header HeaderUserId = new Header("userId","a1bcdefgh");
	static Header HeaderContentTypeUrlEncoded = new Header("Content-Type","application/x-www-form-urlencoded");
	static Header HeaderWithBasicAutorization = new Header("Authorization","Basic Qssfsdfsdgsdgd");
	static Header HeaderAcceptJson = new Header("Accept","application/json");
	
	static Header headerWithBrokerAdminToken;
	static Header headerWithIssueToken;
	

	public static Headers getHeaderUrlEncoded()
	{
		
		List <Header> headerList=new LinkedList<>();
		headerList.add(HeaderContentTypeUrlEncoded);
		return new Headers(headerList);
	}
	
	
	public static Headers getApplicationJsonHeaderWithBrokerAdminToken()
	{
		
		List <Header> headerList =new LinkedList<>();
		headerWithBrokerAdminToken = new Header("Authorization","Bearer xxxxx");
		headerList.add(HeaderContentTypeJson);
		headerList.add(headerWithBrokerAdminToken);
		return new Headers(headerList);
	}
	
	public static Headers getHeaderConnectJsonAcceptJson()
	{
		
		List <Header> headerList=new LinkedList<>();
		headerList.add(HeaderContentTypeJson);
		headerList.add(HeaderAcceptJson);
		headerList.add(HeaderUserId);
		return new Headers(headerList);
	}
	
	public static Headers getHeaderConnectJsonAcceptJson1()
	{
		
		List <Header> headerList=new LinkedList<>();
		headerList.add(HeaderContentTypeJson);
		
		return new Headers(headerList);
	}
	public static Headers getApplicationJsonHeaderWithIssueToken(String issueToken)
	{
		
		List <Header> headerList =new LinkedList<>();
		headerWithIssueToken = new Header("Authorization","Bearer "+issueToken);
		headerList.add(HeaderContentTypeJson);
		headerList.add(headerWithBrokerAdminToken);
		//assertTrue("","pass".equals("pass"));
		return new Headers(headerList);
	}
	
	
	public static Headers getHeaderLoginMeansAPI(byte[] cipherKey,String KeyID)
	{
		
		List <Header> headerList =new LinkedList<>();
		headerList.add(HeaderContentTypeJson);
		headerList.add(HeaderAcceptJson);
		headerList.add(new Header("x-payload-keyid",KeyID));
		
		byte[] base64EncodedCiperKey = Base64.getEncoder().encode(cipherKey);
		headerList.add(new Header("x-payload-keyid",new String(base64EncodedCiperKey)));
		return new Headers(headerList);
	}
	
	public static Headers getHeaderSetPasswordMeansAPI(byte[] cipherKey,String KeyID,String issueToken)
	{
		
		List <Header> headerList =new LinkedList<>();
		headerList.add(HeaderContentTypeJson);
		headerList.add(HeaderAcceptJson);
		headerList.add(new Header("x-payload-keyid",KeyID));
		
		byte[] base64EncodedCiperKey = Base64.getEncoder().encode(cipherKey);
		headerList.add(new Header("x-payload-keyid",new String(base64EncodedCiperKey)));
		headerWithIssueToken = new Header("Authorization","Bearer "+issueToken);
		return new Headers(headerList);
	}
	
	public static Headers getHeaderChangePasswordMeansAPI(byte[] cipherKey,String KeyID,String issueToken)
	{
		
		List <Header> headerList =new LinkedList<>();
		headerWithIssueToken = new Header("Authorization","Bearer "+issueToken);
		headerList.add(HeaderContentTypeJson);
		headerList.add(HeaderAcceptJson);
		headerList.add(new Header("x-payload-keyid",KeyID));
		byte[] base64EncodedCiperKey = Base64.getEncoder().encode(cipherKey);
		headerList.add(new Header("x-payload-keyid",new String(base64EncodedCiperKey)));
		return new Headers(headerList);
	}
		
}
