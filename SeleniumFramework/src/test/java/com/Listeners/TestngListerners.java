package com.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListerners implements ITestListener {
	
	public void onTestStart(ITestResult result){
		System.out.println("Starting the Test");
	}
	
	
	public void onTestFailure(ITestResult result){
		System.out.println("Test Fialed");
		
	}

	public void onTestSuccess(ITestResult result){
	
		System.out.println(" Test Passed");
	}
	
	public void onTestSkipped(ITestResult result){
		System.out.println("Skipping the Test");
	}


	

}
