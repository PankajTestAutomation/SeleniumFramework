package com.DemoQATests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ObjectRepo.BasePage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.PageAbstract;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
WebDriver driver;
public PageAbstract page;
public ExtentHtmlReporter htmlReporter;
public ExtentReports extentReport;
public ExtentTest test;

	@BeforeTest
	public void setUpReporter()
	{
		htmlReporter= new ExtentHtmlReporter("./reports/ExtentHtmlReport.html");
		htmlReporter.config().setDocumentTitle("ExtentReport");
		htmlReporter.config().setReportName("RegressionTest");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("OS", "Windows");
		
	}
	
	@AfterTest
	public void tearDownReporter()
	{
		extentReport.flush();
	}
	

	 
	@BeforeMethod
	public void setupChrome() {
			
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	page=new BasePage(driver);
	driver.get("http://demo.automationtesting.in/Register.html");
	
	
}
	
	@AfterMethod
	public void teardown(ITestResult result) 
		{
			if (result.getStatus()==ITestResult.FAILURE)
			{
				
				try {
					test.log(Status.FAIL, "Test Case Failed- " + result.getName());
					test.log(Status.FAIL, "Test Case Failed- " + result.getThrowable());
					System.out.println("Inside try block of Fail condition" +result.getName());
					test.addScreenCaptureFromPath(getScreenshotPath(driver, result.getName()));
					//System.out.println("Inside try block of Fail condition");
				} catch (Exception e) {
					System.out.println("Inside catch block of Fail condition");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			if (result.getStatus()==ITestResult.SKIP)
			{
				test.log(Status.SKIP, "Test Case Skipped- " + result.getName());
			}
			
			if (result.getStatus()==ITestResult.SUCCESS)
			{
				test.log(Status.PASS, "Test Case Pass- " + result.getName());
			}
			System.out.println("Quitting Driver");
			driver.quit();
			System.out.println(" Driver Quit");
		}
	
	
	
	
	public String getScreenshotPath(WebDriver driver, String ScreenshotName) 
	{
		System.out.println(System.getProperty("user.dir"));
		String Destination= System.getProperty("user.dir") + "/Screenshots/" + ScreenshotName +".png";
		System.out.println(Destination);
		try {
			TakesScreenshot ts= (TakesScreenshot)driver;
			File Source=ts.getScreenshotAs(OutputType.FILE);
			
			
			File file= new File(Destination);
			FileUtils.copyFile(Source, file);
			
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Destination;
	}

}
