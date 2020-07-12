package com.ObjectRepo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageAbstract {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor; 
	
	public PageAbstract (WebDriver driver)
	{
		this .driver= driver;
		this.wait=new WebDriverWait(this.driver,50);
		jsExecutor=(JavascriptExecutor)driver;
	}
	
	public abstract String getPageTitle();
	
	public abstract void WaitForPageTitle(String title);
	
	public abstract void WaitForElementPresent(WebElement Element);
	
	public abstract void waitForPageLoad();
		
	public abstract void scrollToElement(WebElement Element);
	
	public abstract void scrollToBottom();
	
	public abstract void scrollToCoordinates(int x, int y);
	
	
	
	
	
	
	

}
