package com.tmb.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentLogger {
	
	private ExtentLogger() {}
	
	public static void pass(String message)
	{
		ExtentReport.getTest().pass(message);
	}
	
	public static void fail(String message)
	{
		ExtentReport.getTest().fail(message);
	}
	
	public static void info(String message)
	{
		ExtentReport.getTest().info(message);
	}
	
	public static void logResposne(String message)
	{
		ExtentReport.getTest().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
	}
	
	public static void logRequest(RequestSpecification requestSpecification)
	{
		QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
		
		info("Request Details below:");
		info(query.getBody());
		ExtentReport.getTest().info(MarkupHelper.createCodeBlock(query.getBody(),CodeLanguage.JSON));
		
		for(Header head : query.getHeaders())
		{
			info(head.getName()+":"+head.getValue());
		}
	}

}
