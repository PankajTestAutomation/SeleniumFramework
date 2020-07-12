package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends PageAbstract {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		
		String title= driver.getTitle();
		return title;
	}

	@Override
	public void waitForPageLoad() {
		
		
	}



	@Override
	public void WaitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void WaitForElementPresent(WebElement Element) {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(Element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void scrollToElement(WebElement Element) {
		jsExecutor.executeScript("argument[0].scrollIntoView(true);", Element);
		
	}

	@Override
	public void scrollToBottom() {
		
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	@Override
	public void scrollToCoordinates(int x, int y) {
		jsExecutor.executeScript("window.scrollBy(x,y)");
		
	}

}
