package com.tmb.Listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.reports.ExtentReport;

public class TestListener implements ITestListener, ISuiteListener {
	
	public void onStart(ISuite suite)
	{
		ExtentReport.initReport();
	}
	
	public void onFinish(ISuite suite)
	{
		ExtentReport.tearDownReport();
	}
	
	
	public void onTestStart(ITestResult result)
	{
		ExtentReport.createTest(result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		ExtentReport.getTest().pass(result.getName()+ " is passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		
	}

}
