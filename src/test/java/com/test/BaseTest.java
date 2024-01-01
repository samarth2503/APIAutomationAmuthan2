package com.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tmb.reports.ExtentReport;

public class BaseTest {
	
	@BeforeSuite
	public void setUpSuite()
	{
		ExtentReport.initReport();
	}
	
	@AfterSuite
	public void tearDownSuite()
	{
		ExtentReport.tearDownReport();
	}
	
	@BeforeMethod
	public void setup(Method meth)
	{
		ExtentReport.createTest(meth.getName());
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(!result.isSuccess())
		{
			ExtentReport.getTest().fail(String.valueOf(result.getThrowable()));
		}
	}
	

}
