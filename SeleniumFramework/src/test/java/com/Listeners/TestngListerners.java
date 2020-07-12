package com.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListerners implements ITestListener {
	
	public void onTestStart(ITestResult result){
		System.out.println("Starting the Test");
	}
	
	
	public void onTestFailure(ITestResult result){
		System.out.println("Test Failed");
		
	}

	public void onTestSuccess(ITestResult result){
	
		System.out.println(" Test Passed");
	}
	
	public void onTestSkipped(ITestResult result){
		System.out.println("Skipping the Test");
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	

}
