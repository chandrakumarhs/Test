package com.actiTime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class BasePage 
{
	WebDriver driver;
	public BasePage(WebDriver driver) 
	{
		this.driver=driver;
				
	}
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try 
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("both the titles are matching: "+eTitle,true);
						
		} 
		catch (Exception e)
		{
			Reporter.log("title is not matching. Expected title is "+eTitle,true);
			Reporter.log("Actual title id : "+driver.getTitle(),true);
			Assert.fail();
		}
		
	}
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present: ",true);
		}
		catch (Exception e) 
		{
			Reporter.log("Elements is not displayed: ",true);
			Assert.fail();
		}
	}
	
	
}
