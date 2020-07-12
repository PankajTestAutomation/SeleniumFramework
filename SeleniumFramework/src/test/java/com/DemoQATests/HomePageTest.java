package com.DemoQATests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ObjectRepo.HomePage;

public class HomePageTest extends BaseTest {
	HomePage homepage;
	//public String ExcelDataPath="C:\\DataProviderExcel.xlsx";
	//public String ExcelDataSheetName="Sheet1";
	ExcelUtilities utils=new ExcelUtilities();
	
		
	
	//@Test(dataProvider="dataprovider",enabled=true, priority=1)
		
	public void userLogin(String username, String password)
		{	
		
		test=extentReport.createTest("userLogin");
		test.createNode("Test Case for Parameter" +username);
		
		System.out.println("Inside login method");
		System.out.println("UserName from Dataset " +username);
		System.out.println("Password from Dataset " +password);
		homepage=new HomePage(driver);
		homepage.Login( username,  password);
	}
	
	
	@DataProvider
	//@Parameters("DataproviderMethod")
	public Object[][] dataprovider(){
		
		
		Object[][] dataset=utils.dataProvider("C:\\DataProviderExcel.xlsx","Sheet1");
			
			return dataset;
		
	}
	
	//@Test(priority=2)
	@Parameters("TestMethod")
	
	public void newAccount(String testmethod )
	{
		test=extentReport.createTest("newAccount");
		
		System.out.println(testmethod);	
		homepage=new HomePage(driver);
		//homepage.Login();
		
		AssertJUnit.assertEquals("1", "3"); 
		//homepage.createNewAccount();
	}
	
	@Test(priority=1)
	public void validateDropDownOptions() {
		
			homepage=new HomePage(driver);
			test=extentReport.createTest("validateDropDownOptions");
			
			homepage.getDropDownValues();
		
	}
	
	@Test(priority=2)
	public void getCookies()
	{
		Set<Cookie>cookies= driver.manage().getCookies();
		System.out.println(cookies.size());
		
		Cookie cokie=new Cookie("my cookie","123"); // to add own cookie
		driver.manage().addCookie(cokie);
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName()); // to get name of  cookies
			
		}
	}
		@Test
		public void validateListeners()
		{
			test=extentReport.createTest("validateListeners");
			Assert.assertEquals("2", "3");
		}
	


		
}
