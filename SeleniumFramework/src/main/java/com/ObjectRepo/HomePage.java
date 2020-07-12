package com.ObjectRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}

	//@FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[3]/h5")
	// WebElement Element;
	
	@FindBy(how=How.XPATH, using="//input[@id='email']")
	WebElement UserName;
	
	@FindBy(how=How.XPATH, using="//input[@id='pass']")
	WebElement Password;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"blueBarDOMInspector\"]/div/div[2]/div/div/span/a")
	WebElement newAccountButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"u_0_b\"]")
	WebElement loginButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"Skills\"]")
	 WebElement demoQADropdown;
	
	public void Login(String UN, String PWD)
	{
		try {
			Thread.sleep(500);
			UserName.sendKeys(UN);
			Password.sendKeys(PWD);
			loginButton.click();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void createNewAccount()
	{		
				WaitForElementPresent(newAccountButton);
				newAccountButton.click();
				
					
	}
	
	public void getDropDownValues()
	{
		try {
			Select select=new Select(demoQADropdown);
			List <WebElement> availableOptions=select.getOptions();
			List originalList=new ArrayList();
			List expectedList=new ArrayList();
			
			
			
			for(WebElement option:availableOptions)
			{
				originalList.add(option.getText());
				expectedList.add(option.getText());
			}
			System.out.println(originalList);
			Collections.sort(expectedList);
			
			if (originalList==expectedList)
			{
				System.out.println("List was sorted");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
				
				
			
		
	}
	
	
	 


