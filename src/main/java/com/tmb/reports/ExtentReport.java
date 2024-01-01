package com.tmb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {
	
	private static ExtentReports extent;
	private static ExtentTest test;
	
	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();
	
	private ExtentReport() {};
	
	public static void initReport()
	{
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		extent.attachReporter(spark);
		
	}
	
	public static void tearDownReport()
	{
		extent.flush();
	}
	
	public static void createTest(String name)
	{
		test = extent.createTest(name);
	}
	
	public static ExtentReports getExtent() {
		return extent;
	}

	public static void setExtent(ExtentReports extent) {
		ExtentReport.extent = extent;
	}

	public static ExtentTest getTest()
	{
		return exTest.get();
	}
	
	public static void setTest(ExtentTest test)
	{
		exTest.set(test);
	}

}
