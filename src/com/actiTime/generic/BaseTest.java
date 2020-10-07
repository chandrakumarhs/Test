package com.actiTime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract public class BaseTest implements AutoConstants 
{
	public WebDriver driver;
	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(firefox_key, firefox_value);
	}
	@BeforeMethod
	public void preCondition()
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://demo.actitime.com/login.do");
	}
	
	@AfterMethod
	public void postCondition(ITestResult res) throws IOException
	{
		int status =res.getStatus();
		if (status==2)
		{
			String name=res.getName();
			GenericUtils.takeScreenShot(driver, name);
		}
		driver.close();
	}
}
